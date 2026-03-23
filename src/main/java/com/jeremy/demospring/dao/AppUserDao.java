package com.jeremy.demospring.dao;

import com.jeremy.demospring.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface AppUserDao extends JpaRepository<AppUser, Integer> {

}
