package com.exalt.poller.exaltpoller.webservices.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exalt.poller.exaltpoller.webservices.model.Factor;

@Repository
public interface IFactorRepository extends JpaRepository<Factor, Integer>{

	
}
