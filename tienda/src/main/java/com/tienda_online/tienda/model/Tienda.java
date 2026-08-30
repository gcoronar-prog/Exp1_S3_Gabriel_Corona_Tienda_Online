package com.tienda_online.tienda.model;

public class Tienda{
    private int idUsuario;
    private int numeroCompra;
    private int idRoles;
    private int idProductos;
    private String productos;
    private String nombreUsuario;
    private String roles;
    private String direccionDespacho;


    public Tienda(int idUsuario, int numeroCompra, int idRoles, int idProductos, String productos, String nombreUsuario, String roles, String direccionDespacho) {
        this.idUsuario = idUsuario;
        this.numeroCompra = numeroCompra;
        this.idRoles = idRoles;
        this.idProductos = idProductos;
        this.productos = productos;
        this.nombreUsuario = nombreUsuario;
        this.roles = roles;
        this.direccionDespacho = direccionDespacho;
    }

    //Getters
    public int getIdUsuario() {
        return idUsuario;
    }

    public int getNumeroCompra() {
        return numeroCompra;
    }

    public int getIdRoles() {
        return idRoles;
    }

    public int getIdProductos() {
        return idProductos;
    }

    public String getProductos() {
        return productos;
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

}
