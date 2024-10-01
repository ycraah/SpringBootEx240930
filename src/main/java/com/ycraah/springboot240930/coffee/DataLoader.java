package com.ycraah.springboot240930.coffee;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * '@Component'는 스프링 부트가 관리하는 빈으로 등록한다.
 */
@Component
public class DataLoader {
  private final CoffeeRepository coffeeRepository;
  public DataLoader(CoffeeRepository coffeeRepository) {
    this.coffeeRepository = coffeeRepository;
  }

  /**
   * '@PostConstruct'는 의존성 주입이 완료된 이후에 초기화를 수행하는 기능을 한다.
   */
  @PostConstruct
  private void loadData() {
    /*
     * <<이것이 자바다>> <수정할 수 없는 컬렉션> p.684 참조
     * 요소를 추가, 삭제할 수 없는 컬렉션을 말한다. 컬렉션 생성 시 저장된 요소를 바꾸지 않고 싶을 때 유용하다.
     * List, Set, Map 인터페이스의 정적 메서드인 of를 활용한다.
     * <<Java의 정석>> <ArrayList의 메서드> p.395 참조
     * boolean addAll(Collection c) : 주어진 컬렉션의 모든 객체를 저장한다.
     */
    coffeeRepository.saveAll(List.of(
        new Coffee("아메리카노"),
        new Coffee("카페모카"),
        new Coffee("카페라떼"),
        new Coffee("캐러멜마키아토")
    ));
  }
}
