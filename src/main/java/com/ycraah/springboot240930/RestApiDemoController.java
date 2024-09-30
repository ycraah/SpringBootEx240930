package com.ycraah.springboot240930;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @RestController은 @Controller와 @ResponseBody를 합쳐 쓴 것이다.
 */

@RestController
@RequestMapping("/")
public class RestApiDemoController {
  private List<Coffee> coffees = new ArrayList<>();

  /**
   * <<이것이 자바다>> <수정할 수 없는 컬렉션> p.684 참조
   * 요소를 추가, 삭제할 수 없는 컬렉션을 말한다. 컬렉션 생성 시 저장된 요소를 바꾸지 않고 싶을 때 유용하다.
   * List, Set, Map 인터페이스의 정적 메서드인 of를 활용한다.
   * <<Java의 정석>> <ArrayList의 메서드> p.395 참조
   * boolean addAll(Collection c) : 주어진 컬렉션의 모든 객체를 저장한다.
   */
  public RestApiDemoController() {
    coffees.addAll(List.of(
        new Coffee("아메리카노"),
        new Coffee("카페모카"),
        new Coffee("카페라떼"),
        new Coffee("캐러멜마키아토")
    ));
  }

  /**
   * @GetMapping은 @RequestMapping(value = "/coffees",  method = RequestMethod.GET)을 생략한 것이다.
   * HTTP 메서드 타입인 RequestMethod.GET을 추가한다.
   */
  @GetMapping("/coffees")
  Iterable<Coffee> getCoffees() {
    return coffees;
  }

  /**
   * {id}부분은 URI 변수이며, 이 값은 @PathVariable 어노테이션에 달린 id 매개변수를 통해 전달된다.
   * 만약 URI 변수와 어노테이션 매개변수와 이름이 다르면 @PathVariable("URI 변수 이름")을 통해 정리할 수 있다.
   */
  @GetMapping("/coffee/{id}")
  /**
   * <<Java의 정석>> p.590~591 참조
   * Optional<T>는 'T타입의 객체'를 감싸는 래퍼 클래스이다. 그래서 Optional타입의 객체에는 모든 타입의 객체를 담을 수 있다.
   * Optional을 이용하면 null 체크를 위한 if문 없이도 NullpointerException이 발생하지 않고 간결하고 안전한 코드를 작성하는 것이 가능하다.
   * Optional 객체 생성은 of() 또는 ofNullable()을 사용한다. of()는 매개변수 값이 null이면 NullPointerException이 발생하다.
   * empty()를 통해 참조변수 값을 초기화할 수 있다.
   */
  Optional<Coffee> getCoffeeById(@PathVariable String id) {
    for (Coffee c : coffees) {
      if (c.getId().equals(id)) {
        return Optional.of(c);
      }
    }
    return Optional.empty();
  }
}
