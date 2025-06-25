package com.qpayment.fast.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qpayment.fast.entities.Charge;

public interface ChargeRepository extends JpaRepository<Charge, Long>{

}
