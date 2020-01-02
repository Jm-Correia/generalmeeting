package com.vote.generalmeeting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vote.generalmeeting.domain.Pauta;

@Repository
public interface PautaRepository extends JpaRepository<Pauta, Integer> {

}
