package com.ycraah.springboot240930.greeting;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

/**
 * prefix가 greeting으로 되어있으면 application.properties에 greeting.을 통해서 각 값을 입력할 수 있다. (ex. greeting.name , greeting.coffee)
 */
@ConfigurationProperties(prefix = "greeting")
public class Greeting {
  private String name;
  private String coffee;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCoffee() {
    return coffee;
  }

  public void setCoffee(String coffee) {
    this.coffee = coffee;
  }
}
