package com.vote.generalmeeting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vote.generalmeeting.domain.Wallet;

@Repository
public interface WalletRepository extends JpaRepository<Wallet, Integer> {

}
