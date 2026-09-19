package com.tienda_online.tienda.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity 
@Table (name = "tienda")
public class Tienda{
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name="id_usuario")
    private Long idUsuario;

    @Column (name="numero_compra")
    private String numeroCompra;

    @Column (name="producto")
    private String producto;
    @Column (name="nombre_usuario")
    private String nombreUsuario;
    @Column (name="roles_usuario")
    private String roles;
    @Column (name="direccion_despacho")
    private String direccionDespacho;
    @Column (name="apellido_usuario")
    private String apellidoUsuario;
    @Column (name="region_despacho")
    private String regionDespacho;
    @Column (name="comuna_despacho")
    private String comunaDespacho;
    @Column (name="fecha_compra")
    private LocalDate fechaCompra;
  
    //Getters
    public Long getIdUsuario() {
        return idUsuario;
    }

    public String getNumeroCompra() {
        return numeroCompra;
    }


    public String getProductos() {
        return producto;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getRoles() {
        return roles;
    }

    public String getDireccionDespacho() {
        return direccionDespacho;
    }

    public String getApellidoUsuario() {
        return apellidoUsuario;
    }

    public String getRegionDespacho() {
        return regionDespacho;
    }

    public String getComunaDespacho() {
        return comunaDespacho;
    }

    public LocalDate getFechaCompra() {
        return fechaCompra;
    }


    //Setters
    public void setIdUsuario(Long idUsuario){
        this.idUsuario=idUsuario;
    }

    public void setNumeroCompra(String numeroCompra){
        this.numeroCompra=numeroCompra;
    }

    public void setProductos(String producto){
        this.producto=producto;
    }

    public void setNombreUsuario(String nombreUsuario){
        this.nombreUsuario=nombreUsuario;
    }

    public void setRoles(String roles){
        this.roles=roles;
    }

    public void setDireccionDespacho(String direccionDespacho){
        this.direccionDespacho=direccionDespacho;
    }

    public void setApellidoUsuario(String apellidoUsuario){
        this.apellidoUsuario=apellidoUsuario;
    }

    public void setRegionDespacho(String regionDespacho){
        this.regionDespacho=regionDespacho;
    }

    public void setComunaDespacho(String comunaDespacho){
        this.comunaDespacho=comunaDespacho;
    }

    public void setFechaCompra(LocalDate fechaCompra){
        this.fechaCompra=fechaCompra;
    }
}
