package com.ycraah.springboot240930;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @RestController은 @Controller와 @ResponseBody를 합쳐 쓴 것이다.
 */

@RestController
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
   * @GetMapping은
   * @RequestMapping(value = "/coffees",  method = RequestMethod.GET)을 생략한 것이다.
   * HTTP 메서드 타입인 RequestMethod.GET을 추가한다.
   */
  @GetMapping("/coffees")
  Iterable<Coffee> getCoffees() {
    return coffees;
  }
}
