package com.ycraah.springboot240930.coffee;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * '@RestController'은 @Controller와 @ResponseBody를 합쳐 쓴 것이다.
 */

@RestController
@RequestMapping("/coffees")
public class RestApiDemoController {
  private final CoffeeRepository coffeeRepository;

  public RestApiDemoController(CoffeeRepository coffeeRepository) {
    this.coffeeRepository = coffeeRepository;
  }

  /**
   * '@GetMapping'은 @RequestMapping(value = "/coffees",  method = RequestMethod.GET)을 생략한 것이다.
   * HTTP 메서드 타입인 RequestMethod.GET을 추가한다.
   */
  @GetMapping
  Iterable<Coffee> getCoffees() {
    return coffeeRepository.findAll();
  }

  /**
   * {id}부분은 URI 변수이며, 이 값은 @PathVariable 어노테이션에 달린 id 매개변수를 통해 전달된다.
   * 만약 URI 변수와 어노테이션 매개변수와 이름이 다르면 @PathVariable("URI 변수 이름")을 통해 정리할 수 있다.
   */

  @GetMapping("/{id}")
  /**
   * <<Java의 정석>> p.590~591 참조
   * Optional<T>는 'T타입의 객체'를 감싸는 래퍼 클래스이다. 그래서 Optional타입의 객체에는 모든 타입의 객체를 담을 수 있다.
   * Optional을 이용하면 null 체크를 위한 if문 없이도 NullpointerException이 발생하지 않고 간결하고 안전한 코드를 작성하는 것이 가능하다.
   * Optional 객체 생성은 of() 또는 ofNullable()을 사용한다. of()는 매개변수 값이 null이면 NullPointerException이 발생하다.
   * empty()를 통해 참조변수 값을 초기화할 수 있다.
   */
  Optional<Coffee> getCoffeeById(@PathVariable String id) {
    return coffeeRepository.findById(id);
  }

  /**
   * 참조 : https://cheershennah.tistory.com/179
   * @RequestBody는 http요청의 본문(body)가 그대로 자바 객체로 변환해서 메서드 파라미터로 전달된다.
   * xml이나 json 기반의 메시지를 사용하는 요청에 유횽하다.
   */
  @PostMapping
  Coffee postCoffee(@RequestBody Coffee coffee) {
    return coffeeRepository.save(coffee);
  }

  /**
   * <<HTTP 완벽 가이드>> p.10
   * PUT은 클라이언트에서 서버로 보낸 데이터를 지정한 이름의 리소스로 저장하라는 의미의 메서드이다.
   * 참조 : https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/http/ResponseEntity.html
   * ResponseEntity(T body, HttpStatusCode status)는 데이터와 상태 코드를 반환한다.
   * HttpStatus.CREATED(201) HttpStatus.OK(200)의 200~206 코드는 성공을 의미한다.
   *  p.51, p.70 참조 200 OK 요청은 정상이고, 엔터티 본문은 요청된 리소스를 포함하고 있다는 의미이다.
   *  201 Created는 서버 개체를 생성하라는 요청을 위한 것으로 생성된 리소스에 대한 구체적인 참조가 담긴 헤더와 리소스를 참조할 수 있는 여러 URL을 엔티티 본문에 포함해야한다.
   */
  @PutMapping("/{id}")
  ResponseEntity<Coffee> putCoffee(@PathVariable String id, @RequestBody Coffee coffee) {
    return (coffeeRepository.existsById(id)) ? new ResponseEntity<>(postCoffee(coffee), HttpStatus.CREATED) : new ResponseEntity<>(coffee, HttpStatus.OK);
  }

  @DeleteMapping("/{id}")
  void deleteCoffee(@PathVariable String id) {
    coffeeRepository.deleteById(id);
  }
}
