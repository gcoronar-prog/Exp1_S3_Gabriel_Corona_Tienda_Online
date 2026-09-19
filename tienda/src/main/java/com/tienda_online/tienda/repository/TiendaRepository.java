package com.tienda_online.tienda.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tienda_online.tienda.model.Tienda;

public interface TiendaRepository extends JpaRepository<Tienda,Long>{
    
}
