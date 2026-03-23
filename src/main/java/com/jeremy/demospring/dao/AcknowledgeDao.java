package com.jeremy.demospring.dao;

import com.jeremy.demospring.model.Acknowledge;
import com.jeremy.demospring.model.Component;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AcknowledgeDao extends JpaRepository<Acknowledge, Acknowledge.Key> {
}
