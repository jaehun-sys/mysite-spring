package com.javaex.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.javaex.dao.UserDao;
import com.javaex.vo.UserVo;

@Controller
public class UserController {

	@Autowired
	private UserDao userDao;
	
	public UserController(UserDao userDao) {
		this.userDao = userDao;
	}

	@RequestMapping("/user/loginform")
	public ModelAndView loginform(ModelAndView mav) {
		System.out.println(">>> "+this.getClass()+" 호출됨! loginform");
		
		mav.setViewName("user/loginform");
		return mav;
	}
	
	@RequestMapping("/user/login")
	public ModelAndView login(ModelAndView mav, @ModelAttribute UserVo userVo, 
								HttpSession session) {
		System.out.println(">>> "+this.getClass()+" 호출됨! login");
		System.out.println("userVo: "+userVo);
		List<UserVo> resultList = userDao.loginSelect(userVo);
		if(resultList.isEmpty()) {					//로그인 실패
			System.out.println("로그인 fail!");
			mav.setViewName("user/loginform");
		}else {										//로그인 성공
			System.out.println("로그인 success!");
			//session.setAttribute("sessionEmail", userVo.getEmail() );
			session.setAttribute("authUser", resultList.get(0));
			mav.setViewName("main/index");
		}
		return mav;
	}
	
	@RequestMapping("/user/logout")
	public ModelAndView modify(ModelAndView mav, HttpSession session) {
		System.out.println(">>> "+this.getClass()+" 호출됨! modify");
		
		session.invalidate();
		mav.setViewName("main/index");
		return mav;
	}
	
	@RequestMapping("/user/joinform")
	public ModelAndView joinform(ModelAndView mav) {
		System.out.println(">>> "+this.getClass()+" 호출됨! joinform");
		
		mav.setViewName("user/joinform");
		return mav;
	}
	
	@RequestMapping("/user/join")
	public ModelAndView join(ModelAndView mav, @ModelAttribute UserVo userVo) {
		System.out.println(">>> "+this.getClass()+" 호출됨! join");
		System.out.println("join userVo: "+userVo);
		if(userVo.getName().equals("")||userVo.getEmail().equals("")||userVo.getPassword().equals("")) {
			System.out.println("회원가입 fail!");
			mav.setViewName("user/joinform");
		}else {
			userDao.join(userVo);
			System.out.println("회원가입 success!");
			mav.setViewName("user/joinsuccess");
		}		
		return mav;
	}
	
	@RequestMapping("/user/modifyform")
	public ModelAndView modifyform(ModelAndView mav) {
		System.out.println(">>> "+this.getClass()+" 호출됨! modifyform");
		
		mav.setViewName("user/modifyform");
		return mav;
	}
	
	@RequestMapping("/user/modify")
	public ModelAndView modify(ModelAndView mav, @ModelAttribute UserVo userVo,
								HttpSession session) {
		System.out.println(">>> "+this.getClass()+" 호출됨! modify");
		
		int no = ((UserVo) session.getAttribute("authUser")).getNo();
		String email = ((UserVo) session.getAttribute("authUser")).getEmail();
		String password = ((UserVo) session.getAttribute("authUser")).getPassword();
		userVo.setNo(no);
		userVo.setEmail(email);
		userVo.setPassword(password);
		
		userDao.updateUser(userVo);
		List<UserVo> resultList = userDao.loginSelect(userVo);
		
		session.setAttribute("authUser", resultList.get(0));
		mav.setViewName("main/index");
		return mav;
	}
}
