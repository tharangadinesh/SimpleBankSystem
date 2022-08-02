package com.diligroup.simplebanksystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.diligroup.simplebanksystem.model.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository < Transaction, Long > {


}
