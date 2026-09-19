package com.tienda_online.tienda.services;

import java.util.List;
import java.util.Optional;

import com.tienda_online.tienda.model.Tienda;

public interface TiendaService {
    List<Tienda> getAllTiendas();
    Optional<Tienda> getTiendaById(Long idUsuario);
    Tienda createRegistroTienda(Tienda tienda);
    Tienda updateRegistroTienda(Long idUsuario, Tienda tienda);
    void deleteRegistroTienda(Long idUsuario);
}
