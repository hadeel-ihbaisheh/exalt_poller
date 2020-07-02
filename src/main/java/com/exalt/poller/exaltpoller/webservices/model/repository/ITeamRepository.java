package com.exalt.poller.exaltpoller.webservices.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exalt.poller.exaltpoller.webservices.model.Team;

public interface ITeamRepository extends JpaRepository<Team, Integer> {

}
