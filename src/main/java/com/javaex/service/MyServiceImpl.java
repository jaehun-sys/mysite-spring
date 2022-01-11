package com.javaex.service;

import org.springframework.stereotype.Service;

@Service("myService")
public class MyServiceImpl implements MyService {
  @Override
  public void testJobMethod() {
    System.out.println("test job....");
  }

}