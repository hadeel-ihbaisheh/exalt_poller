package com.exalt.poller.exaltpoller.webservices.model.repository;

import java.util.Date;
import java.util.List;

import org.hibernate.type.TrueFalseType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.exalt.poller.exaltpoller.webservices.model.PostedQuestion;

@Repository
public interface IPostedQuestionRepository extends JpaRepository<PostedQuestion, Integer> {

	
	public List<PostedQuestion> findByTeam(String team);
	
	@Query(value = "select a from PostedQuestion a where a.questionDate >= :questionDate and a.team = :team order by a.questionDate DESC", nativeQuery = true )
	public List<PostedQuestion> findAfterDate(@Param("questionDate") Date fromTime, @Param("team") String team);
}
