package com.tienda_online.tienda.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;


@Entity 
@Table (name = "tienda")
public class Tienda{
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name="id_usuario")
    private Long idUsuario;


    @NotBlank(message = "El número de compra no debe estar vacío")
    @Pattern(regexp = "C\\d{4}", message = "El número de compra debe ser una C seguida de 4 dígitos (ej: C0001)")
    @Size (min = 5,max = 5, message="El número de compra debe ser de 5 carácteres")
    @Column (name="numero_compra")
    private String numeroCompra;

    @NotBlank (message = "El nombre del producto no puede estar vacío")
    @Size (min = 10, max = 60, message = "El nombre del producto debe estar entre 10 y 60 carácteres")
    @Column (name="producto")
    private String producto;

    @NotBlank (message = "El nombre del usuario no puede estar vacío")
    @Pattern (regexp = "^[a-zA-ZÀ-ÿ\\s]+$", message = "El nombre del usuario solo puede contener letras y espacios")
    @Size (min = 4, max = 50, message = "El/los nombres del usuario deben estar entre los 4 y 50 carácteres")
    @Column (name="nombre_usuario")
    private String nombreUsuario;

    @NotBlank (message = "El rol del usuario no puede estar vacío")
    @Pattern (regexp = "^[a-zA-ZÀ-ÿ]+$", message = "El rol del usuario solo puede contener letras, sin espacios")
    @Size (min = 4, max = 5, message = "El rol del usuario deben estar entre los 4 y 5 carácteres")  
    @Column (name="roles_usuario")
    private String roles;

    @NotBlank (message = "La dirección de despacho no puede estar vacía")
    @Size (max = 60, message = "La direccion de despacho puede tener un máximo de 60 caracteres")  
    @Column (name="direccion_despacho")
    private String direccionDespacho;

    @NotBlank (message = "El apellido del usuario no puede estar vacío")
    @Pattern (regexp = "^[a-zA-ZÀ-ÿ\\s]+$", message = "El/los apellidos del usuario solo puede contener letras y espacios")
    @Size (min = 4, max = 50, message = "El/los apellidos del usuario deben estar entre los 4 y 50 carácteres")
    @Column (name="apellido_usuario")
    private String apellidoUsuario;


    @NotBlank (message = "La región de despacho no puede estar vacía")
    @Pattern (regexp = "^[a-zA-ZÀ-ÿ\\s]+$", message = "La región de despacho solo puede contener letras y espacios")
    @Size (min = 5, max = 30, message = "La región de despacho puede tener entre 5 y 30 carácteres")  
    @Column (name="region_despacho")
    private String regionDespacho;

    @NotBlank (message = "La comuna de despacho no puede estar vacía")
    @Pattern (regexp = "^[a-zA-ZÀ-ÿ\\s]+$", message = "La comuna de despacho solo puede contener letras y espacios")
    @Size (max = 40, message = "La región de despacho puede tener entre 40 carácteres máximo")     
    @Column (name="comuna_despacho")
    private String comunaDespacho;

    @JsonFormat (pattern = "yyyy-MM-dd")
    @Past (message = "La fecha de nacimiento debe ser una fecha pasada")
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
