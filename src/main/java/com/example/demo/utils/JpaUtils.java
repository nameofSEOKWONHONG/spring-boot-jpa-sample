package com.example.demo.utils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

import java.util.List;

public class JpaUtils {
    public static <T> long getTotalCount(EntityManager entityManager, Class<T> entityClass, List<Predicate> predicates) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Long> countQuery = cb.createQuery(Long.class);

        // Notice 엔티티에 대한 Root 객체 생성
        Root<T> countRoot = countQuery.from(entityClass);

        // 카운트 쿼리 작성
        countQuery.select(cb.count(countRoot));

        // 조건이 있는 경우 설정
        if (!predicates.isEmpty()) {
            countQuery.where(predicates.toArray(new Predicate[predicates.size()]));
        }

        // 카운트 쿼리 실행
        try {
            return entityManager.createQuery(countQuery).getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Count query execution failed", e);
        }
    }
}
