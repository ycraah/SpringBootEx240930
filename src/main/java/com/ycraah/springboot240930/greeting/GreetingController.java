package com.ycraah.springboot240930.greeting;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 속성값은 spEl형식을 사용한다.
 * 아래 속성값은 application.properties에 정의되어있다.
 * 속성값이 없을 경우에는 아래처럼 정의
 */

@RestController
@RequestMapping("/greeting")
public class GreetingController {
  private final Greeting greeting;

  public GreetingController(Greeting greeting) {
    this.greeting = greeting;
  }

  @GetMapping
  String getGreeting() {
    return greeting.getName();
  }

  @GetMapping("/coffee")
  String getNameAndCoffee(){
    return greeting.getCoffee();
  }
}
