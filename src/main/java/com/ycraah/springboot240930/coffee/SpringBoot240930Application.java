package com.ycraah.springboot240930.coffee;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.UUID;

@SpringBootApplication
public class SpringBoot240930Application {

  public static void main(String[] args) {
    SpringApplication.run(SpringBoot240930Application.class, args);
  }
}

/**
 * <<점프 투 스프링부트3>> p.73
 * @Entity는 엔티티와 테이블을 매칭한다.
 * @Id는 id 속성을 기본키로 지정한다. id 속성은 엔티티에서 각 데이터들을 구분하는 유효한 값으로 중복이 불가능하다.
 * 엔티티의 속성은 @Column을 사용하지 않더라도 테이블의 열로 인식한다. 세부 설정을 위해 @column을 사용할 수 있다. 만약, 엔티티 속성으로 만들고 싶지 않으면 @Transient를 사용한다.
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
/**
 * <<자바웹개발 워크북>> p.136
 * @Data는 getter/setter/toString/equals/hashCode 모두 컴파일 할 때 생성해준다.
 */
@Data
class Coffee {
  @Id
  private String id;
  private String name;

  /**
   * 참조 : https://adjh54.tistory.com/142
   * UUID 예시) 45b7713c-7534-4160-9c12-81e96676e4d4
   * UUID.randomUUID()는 충돌 가능성이 없는 128비트 보유 식별자 생성한다.
   * .toString()을 통해 이를 문자열로 변환한다. (UUID 객체 -> String)
   * Coffee 객체를 생성할 때 이름을 지정하면 자동으로 UUID 부여하는 생성자 코드
   */
  public Coffee(String name) {
    this(UUID.randomUUID().toString(), name);
  }
}
