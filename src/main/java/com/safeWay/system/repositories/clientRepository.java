package com.safeWay.system.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.safeWay.system.entities.Client;

public interface clientRepository extends JpaRepository <Client, Long>  {


}