package com.ycraah.springboot240930;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.UUID;

@SpringBootApplication
public class SpringBoot240930Application {

  public static void main(String[] args) {
    SpringApplication.run(SpringBoot240930Application.class, args);
  }
}

class Coffee {
  /**
   * final을 통해 한 번만 할당하면 절대 수정 불가능하다.
   * 따라서 변경자 메서드가 없다.
   */
  private final String id;
  private String name;

  public Coffee(String id, String name) {
    this.id = id;
    this.name = name;
  }

  /**
   * 참조 : https://adjh54.tistory.com/142
   * UUID 예시) 45b7713c-7534-4160-9c12-81e96676e4d4
   * UUID.randomUUID()는 충돌 가능성이 없는 128비트 보유 식별자 생성한다.
   * .toString()을 통해 이를 문자열로 변환한다. (UUID 객체 -> String)
   * Coffee 객체를 생성할 때 이름을 지정하면 자동으로 UUID 부여하는 생성자 코드
   */
  public Coffee(String name){
    this(UUID.randomUUID().toString(),name);
  }
}
