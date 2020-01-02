package com.vote.generalmeeting.repository;


import com.vote.generalmeeting.domain.ItemPauta;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemPautaRepository extends JpaRepository<ItemPauta, Integer> {

}
