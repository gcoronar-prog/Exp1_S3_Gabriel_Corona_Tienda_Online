package com.tienda_online.tienda.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.tienda_online.tienda.model.Tienda;
import com.tienda_online.tienda.repository.TiendaRepository;

@ExtendWith (MockitoExtension.class)
class TiendaServiceImpTest {
    @Mock 
    private TiendaRepository repository;

    @InjectMocks 
    private TiendaServiceImp service;

    private Tienda tienda;

    @BeforeEach 
    void setUp(){
        tienda = new Tienda();
        tienda.setIdUsuario(1L);
        tienda.setNumeroCompra("C0001");
        tienda.setProductos("Producto A");
        tienda.setNombreUsuario("Juan");
        tienda.setRoles("Admin");
        tienda.setDireccionDespacho("Calle Falsa 123");
        tienda.setApellidoUsuario("Pérez");
        tienda.setRegionDespacho("Región Metropolitana");
        tienda.setComunaDespacho("Estacion Central");
        tienda.setFechaCompra(LocalDate.of(1990, 1, 1));
    }  

   @Test 
    void testGetAlltiendas(){
        List<Tienda> expected = Arrays.asList(tienda);
        when(repository.findAll()).thenReturn(expected);
        assertEquals(expected, service.getAllTiendas());
        verify(repository).findAll();
    } 

    @Test 
    void testGetTiendaById(){
        when(repository.findById(1L)).thenReturn(Optional.of(tienda));
        assertEquals(Optional.of(tienda), service.getTiendaById(1L));
        verify(repository).findById(1L);
    }

    @Test 
    void testCreateTienda(){
        when(repository.save(tienda)).thenReturn(tienda);
        assertEquals(tienda, service.createRegistroTienda(tienda));
        verify(repository).save(tienda);
    }

    @Test  
    void testUpdateTiendaExist(){
        when(repository.existsById(1L)).thenReturn(true);
        when(repository.save(tienda)).thenReturn(tienda);

        Tienda result = service.updateRegistroTienda(1L, tienda);

        assertEquals(1L, tienda.getIdUsuario());
        assertEquals(tienda, result);
        verify(repository).existsById(1L);
        verify(repository).save(tienda);
    }

    @Test 
    void testUpdateTiendaNotExist(){
        when(repository.existsById(1L)).thenReturn(false);
        assertNull(service.updateRegistroTienda(1L, tienda));
        verify(repository).existsById(1L);
        verify(repository, never()).save(any());
    }

    @Test 
    void testDeleteTienda(){
        service.deleteRegistroTienda(1L);
        verify(repository).deleteById(1L);
    }

    @AfterEach
    void verificarSinLlamadasExtra() {
        verifyNoMoreInteractions(repository); 
    }    

}
