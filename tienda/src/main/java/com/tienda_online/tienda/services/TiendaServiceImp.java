package com.tienda_online.tienda.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tienda_online.tienda.model.Tienda;
import com.tienda_online.tienda.repository.TiendaRepository;

@Service 
public class TiendaServiceImp implements TiendaService{
    @Autowired 
    private TiendaRepository tiendaRepository;

    @Override 
    public List<Tienda> getAllTiendas(){
        return tiendaRepository.findAll();
    }

    @Override 
    public Optional<Tienda> getTiendaById(Long idUsuario){
        return tiendaRepository.findById(idUsuario);
    }

    @Override
    public Tienda createRegistroTienda(Tienda tienda){
        return tiendaRepository.save(tienda);
    }

    @Override 
    public Tienda updateRegistroTienda(Long idUsuario, Tienda tienda){
        if(tiendaRepository.existsById(idUsuario)){
            tienda.setIdUsuario(idUsuario);
            return tiendaRepository.save(tienda);
        }else{
            return null;
        }
    }

    @Override public void deleteRegistroTienda(Long idUsuario){
        tiendaRepository.deleteById(idUsuario);
    }
}
