package com.tienda_online.tienda.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.tienda_online.tienda.model.Tienda;

@RestController
public class TiendaController {
    private List<Tienda> tiendas = new ArrayList<>();

    //poblado de datos
    public TiendaController(){
        tiendas.add(new Tienda(1, 1001, 1, 501, "Notebook Lenovo IdeaPad 3", "Camila Espinoza", "Cliente", "Avenida Barros Luco 1520, San Antonio"));
        tiendas.add(new Tienda(2, 1002, 1, 502, "Mouse Logitech M170", "Matías Fernández", "Cliente", "Calle Centenario 340, San Antonio"));
        tiendas.add(new Tienda(3, 1003, 2, 503, "Teclado mecánico Redragon K552", "Benjamín Salazar", "Administrador", "Pasaje Los Aromos 85, Cartagena"));
        tiendas.add(new Tienda(4, 1004, 1, 504, "Monitor Samsung 24 pulgadas", "Valentina Cárdenas", "Cliente", "Calle Merced 870, Santiago"));
        tiendas.add(new Tienda(5, 1005, 3, 505, "Impresora Epson L3250", "Tomás Bustos", "Vendedor", "Avenida Francisco de Aguirre 412, La Serena"));
        tiendas.add(new Tienda(6, 1006, 1, 506, "Audífonos JBL Tune 510BT", "Josefa Maldonado", "Cliente", "Calle Lautaro 410, Cartagena"));
        tiendas.add(new Tienda(7, 1007, 3, 507, "Disco SSD Kingston 480GB", "Diego Sepúlveda", "Vendedor", "Avenida Pedro Montt 1875, Valparaíso"));
        tiendas.add(new Tienda(8, 1008, 2, 508, "Webcam Logitech C920", "Antonia Palma", "Administrador", "Calle Von Schroeders 215, Viña del Mar"));
    }

    //retorno de todos los datos
    @GetMapping("/tiendas") 
    public List<Tienda> getTiendas(){
        return tiendas;
    }


    //retorno de datos segun idUsuario
    @GetMapping("/tiendas/{idUsuario}") 
        public Tienda getTiendaById(@PathVariable int idUsuario){
            for (Tienda tienda:tiendas){
                if (tienda.getIdUsuario() == idUsuario) {
                    return tienda;
                }
            }
            return null;
        }
    
    //retorno de datos segun numero de compra
    @GetMapping("/compras/{numeroCompra}")
        public Tienda getNumCompra(@PathVariable int numeroCompra ){
            for (Tienda tienda:tiendas){
                if (tienda.getNumeroCompra() == numeroCompra) {
                    return tienda;
                }
            }
            return null;
        }
    
    //retorno de datos segun la id del producto
    @GetMapping("/productos/{idProducto}")
        public Tienda getProductosCompras(@PathVariable int idProducto ){
            for (Tienda tienda:tiendas){
                if (tienda.getIdProductos() == idProducto) {
                    return tienda;
                }
            }
            return null;
        }

    //retorno de datos segun la id del rol
    @GetMapping("/rol/{idRoles}")
    public List<Tienda> getTiendaRoles(@PathVariable int idRoles){
            List<Tienda> tiendasRoles = new ArrayList<>(); //se agrega lista
            for (Tienda tienda : tiendas){
                if (tienda.getIdRoles() == idRoles) { //se evalua que la id del endpoint corresponda con la id de los datos existentes
                   tiendasRoles.add(tienda); //agrega los datos a la lista de la tienda si la condición es true
                }
            }
            return tiendasRoles; //retorna los datos agregados a la lista segun el criterio utilizado
        }

    }
    
    

