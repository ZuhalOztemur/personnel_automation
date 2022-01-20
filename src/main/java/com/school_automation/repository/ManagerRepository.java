package com.school_automation.repository;

import com.school_automation.entity.ManagerEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManagerRepository extends CrudRepository<ManagerEntity, Long> {

    ManagerEntity findManagerEntityByUserName(String userName);
}
