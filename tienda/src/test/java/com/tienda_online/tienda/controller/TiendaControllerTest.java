package com.tienda_online.tienda.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import com.tienda_online.tienda.model.Tienda;
import com.tienda_online.tienda.services.TiendaService;

import tools.jackson.databind.ObjectMapper;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@WebMvcTest (TiendaController.class)
class TiendaControllerTest {
    
    @Autowired 
    private MockMvc mockMvc;

    @MockitoBean 
    private TiendaService service;

    @Autowired 
    private ObjectMapper mapper;

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
    void testGetAllTiendas() throws Exception{
        when(service.getAllTiendas()).thenReturn(Arrays.asList(tienda));
        mockMvc.perform(get("/tienda"))
        .andExpect(status().isOk())
        .andExpect(content()
        .json(mapper.writeValueAsString(Arrays.asList(tienda))));
    }

    @Test 
    void testGetTiendaById() throws Exception {
        when(service.getTiendaById(1L)).thenReturn(Optional.of(tienda));
        mockMvc.perform(get("/tienda/1"))
            .andExpect(status().isOk())
            .andExpect(content().json(mapper.writeValueAsString(tienda)));
    } 
    
    @Test 
    void testCreateTienda() throws Exception{
        when(service.createRegistroTienda(any(Tienda.class))).thenReturn(tienda);
        mockMvc.perform(post("/tienda")
            .contentType(MediaType.APPLICATION_JSON)
            .content(mapper.writeValueAsString(tienda)))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(content().json(mapper.writeValueAsString(tienda)));
    }  

    @Test 
    void testUpdateTienda() throws Exception{
        when(service.updateRegistroTienda(eq(1L), any(Tienda.class))).thenReturn(tienda);
        mockMvc.perform(put("/tienda/1")
        .contentType(MediaType.APPLICATION_JSON)
        .content(mapper.writeValueAsString(tienda)))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().json(mapper.writeValueAsString(tienda)));
    }

    @Test 
    void testDeleteTienda() throws Exception{
        mockMvc.perform(delete("/tienda/1"))
                .andExpect(status().isOk());
        verify(service).deleteRegistroTienda(1L);
    }    
}
