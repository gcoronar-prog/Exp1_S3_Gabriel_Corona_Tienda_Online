package com.tienda_online.tienda.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tienda_online.tienda.model.Tienda;
import com.tienda_online.tienda.services.TiendaService;

@RestController
@RequestMapping ("/tienda")
public class TiendaController {
    @Autowired 
    private TiendaService tiendaService;


    //retorno de todos los datos
    @GetMapping 
    public List<Tienda> getTiendas(){
        return tiendaService.getAllTiendas();
    }


    //retorno de datos segun idUsuario
    @GetMapping("/{idUsuario}") 
    public Optional<Tienda> getRegistroById(@PathVariable Long idUsuario){
        return tiendaService.getTiendaById(idUsuario);
    }
    
    //retorno de datos segun numero de compra
    @PostMapping
    public Tienda createRegistroTienda(@RequestBody Tienda tienda){
        return tiendaService.createRegistroTienda(tienda);
    }
    
    @PutMapping ("/{idUsuario}")
    public Tienda updateRegistroTienda(@PathVariable Long idUsuario, @RequestBody Tienda tienda){
        return tiendaService.updateRegistroTienda(idUsuario, tienda);
    }

    @DeleteMapping ("/{idUsuario}")
    public void deleteRegistroTienda(@PathVariable Long idUsuario){
        tiendaService.deleteRegistroTienda(idUsuario);
    }
}
    
    

