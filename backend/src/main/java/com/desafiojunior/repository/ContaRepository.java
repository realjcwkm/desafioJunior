package com.desafiojunior.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.desafiojunior.model.Conta;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Integer>{

}
