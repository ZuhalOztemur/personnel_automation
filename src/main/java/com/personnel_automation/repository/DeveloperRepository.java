package com.personnel_automation.repository;

import com.personnel_automation.entity.DeveloperEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeveloperRepository extends CrudRepository<DeveloperEntity, Long> {
    DeveloperEntity findDeveloperEntityByUserName(String userName);
}

