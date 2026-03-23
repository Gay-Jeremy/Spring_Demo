package com.jeremy.demospring.dao;

import com.jeremy.demospring.model.Component;
import com.jeremy.demospring.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ComponentDao extends JpaRepository<Component, Integer> {
}
