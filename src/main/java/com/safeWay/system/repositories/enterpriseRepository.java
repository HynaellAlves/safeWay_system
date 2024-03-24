package com.safeWay.system.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.safeWay.system.entities.Enterprise;

public interface enterpriseRepository extends JpaRepository<Enterprise, Long> {

}
