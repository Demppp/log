package com.dsl;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.querydsl.jpa.impl.JPAQueryFactory;

public class BaseRepositoryDsl {
	public JPAQueryFactory queryFactory;

    @Autowired
    @PersistenceContext
    public EntityManager entityManager;

    @PostConstruct
    public void init() {
        queryFactory = new JPAQueryFactory(entityManager);
    }
}
