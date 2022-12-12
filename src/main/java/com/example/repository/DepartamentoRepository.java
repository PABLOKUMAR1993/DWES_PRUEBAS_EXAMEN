package com.example.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.model.entityBeans.Departamento;


public interface DepartamentoRepository extends JpaRepository<Departamento, Integer> { }
