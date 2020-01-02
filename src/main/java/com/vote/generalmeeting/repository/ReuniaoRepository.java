package com.vote.generalmeeting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vote.generalmeeting.domain.Reuniao;

@Repository
public interface ReuniaoRepository extends JpaRepository<Reuniao, Integer> {

}
