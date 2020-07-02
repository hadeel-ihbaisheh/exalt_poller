package com.exalt.poller.exaltpoller.webservices.model.repository;

import java.util.List;

import org.hibernate.type.TrueFalseType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.exalt.poller.exaltpoller.webservices.dao.VotingInfo;
import com.exalt.poller.exaltpoller.webservices.model.Answer;

@Repository
public interface IAnswerRepository extends JpaRepository<Answer, Integer> {

	public List<Answer> findAllByTeam(String team);

	@Query(value = "SELECT MEMBER.NAME as memberName, COUNT(*) as votingRate FROM MEMBER JOIN ANSWER ON ANSWER.TEAM_MEMBER_ID=MEMBER.ID JOIN TEAM ON TEAM.ID=MEMBER.TEAM_ID WHERE TEAM.TEAM_NAME IN (:team) GROUP BY MEMBER.ID", nativeQuery = true )
	public List<VotingInfo> retrieveVotingInfo(@Param("team") String team);
	
	
	
	@Query(value = "SELECT * FROM ANSWER ", nativeQuery = true )
	//public List<Answer> GetALL_Team_Answers(@Param("team") String team);
	public List<Answer> GetALL_Team_Answers();
}
