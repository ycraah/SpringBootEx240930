package com.ycraah.springboot240930.coffee;

import org.springframework.data.repository.CrudRepository;

/*
 * "참조 : https://docs.spring.io/spring-data/commons/docs/current/api/org/springframework/data/repository/CrudRepository.html"
 * save(S entity):<S extends T> :저장 혹은 업데이트
 * saveAll(Iterable<S> entities): <S extends T> Iterable<S> : 여러 엔티티 저장 및 업데이트
 * findById(ID id): Optional<T> : ID에 해당하는 엔티티 반환
 * existsById(ID id): boolean : ID에 해당하는 엔티티 존재 확인
 * findAll(): Iterable<T> : 모든 엔티티 반환
 * findAllById(Iterable<ID> ids): Iterable<T> : ID에 해당하는 모든 엔티티 반환
 * count(): long : 총 엔티티 개수 반환
 * deleteById(ID id): void : 주어진 ID에 해당하는 엔티티 삭제
 * delete(T entity): void : 주어진 엔티티 삭제
 * deleteAllById(Iterable<? extends ID> ids): void : 주어진 ID들에 해당하는 엔티티 삭제
 * deleteAll(Iterable<? extends T> entities): void : 주어진 엔티티 삭제
 * deleteAll(): void : 모든 엔티티 삭제
 */
public interface CoffeeRepository extends CrudRepository<Coffee, String> {

}
