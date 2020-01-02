package com.vote.generalmeeting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vote.generalmeeting.domain.Morador;

@Repository
public interface MoradorRespository extends JpaRepository<Morador, Integer> {

}
