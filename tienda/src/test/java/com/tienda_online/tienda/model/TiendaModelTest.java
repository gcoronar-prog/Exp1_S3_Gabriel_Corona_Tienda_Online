package com.tienda_online.tienda.model;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

class TiendaModelTest {
    @Test 
    void testGettersAndSetters(){
        //Test de getters y setters de clase Tienda
        Tienda tienda = new Tienda();
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

        assert tienda.getIdUsuario().equals(1L);
        assert tienda.getNumeroCompra().equals("C0001");
        assert tienda.getProductos().equals("Producto A");
        assert tienda.getNombreUsuario().equals("Juan");
        assert tienda.getRoles().equals("Admin");
        assert tienda.getDireccionDespacho().equals("Calle Falsa 123");
        assert tienda.getApellidoUsuario().equals("Pérez");
        assert tienda.getRegionDespacho().equals("Región Metropolitana");
        assert tienda.getComunaDespacho().equals("Estacion Central");
        assert tienda.getFechaCompra().equals(LocalDate.of(1990, 1,1));
    }
}
