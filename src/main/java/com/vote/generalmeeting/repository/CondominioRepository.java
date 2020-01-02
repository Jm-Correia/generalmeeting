package com.vote.generalmeeting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vote.generalmeeting.domain.Condominio;

@Repository
public interface CondominioRepository extends JpaRepository<Condominio, Integer> {

}
