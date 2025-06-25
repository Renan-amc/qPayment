package com.qpayment.fast.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qpayment.fast.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long>{

}
