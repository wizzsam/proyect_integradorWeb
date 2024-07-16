/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author abelp
 */
public class Restaurante {
    private int id;
    private String nombreRestaurante1;
    private String nombreRestaurante2;
    private String tipoComida1;
    private String comidaDia;
    private String tipoEstablecimiento;
    private String direccionRestaurante;
    private String telefono;
    private String paginaWeb;
    private String precio;
    private String imagen1;
    private String imagen2;
    private String imagen3;
    private String pais;
    public Restaurante() {
    }

    public Restaurante(int id, String nombreRestaurante1, String nombreRestaurante2, String tipoComida1, String comidaDia, String tipoEstablecimiento, String direccionRestaurante, String telefono, String paginaWeb, String precio, String imagen1, String imagen2, String imagen3, String pais) {
        this.id = id;
        this.nombreRestaurante1 = nombreRestaurante1;
        this.nombreRestaurante2 = nombreRestaurante2;
        this.tipoComida1 = tipoComida1;
        this.comidaDia = comidaDia;
        this.tipoEstablecimiento = tipoEstablecimiento;
        this.direccionRestaurante = direccionRestaurante;
        this.telefono = telefono;
        this.paginaWeb = paginaWeb;
        this.precio = precio;
        this.imagen1 = imagen1;
        this.imagen2 = imagen2;
        this.imagen3 = imagen3;
        this.pais=pais;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreRestaurante1() {
        return nombreRestaurante1;
    }

    public void setNombreRestaurante1(String nombreRestaurante1) {
        this.nombreRestaurante1 = nombreRestaurante1;
    }

    public String getNombreRestaurante2() {
        return nombreRestaurante2;
    }

    public void setNombreRestaurante2(String nombreRestaurante2) {
        this.nombreRestaurante2 = nombreRestaurante2;
    }

    public String getTipoComida1() {
        return tipoComida1;
    }

    public void setTipoComida1(String tipoComida1) {
        this.tipoComida1 = tipoComida1;
    }

    public String getComidaDia() {
        return comidaDia;
    }

    public void setComidaDia(String comidaDia) {
        this.comidaDia = comidaDia;
    }

    public String getTipoEstablecimiento() {
        return tipoEstablecimiento;
    }

    public void setTipoEstablecimiento(String tipoEstablecimiento) {
        this.tipoEstablecimiento = tipoEstablecimiento;
    }

    public String getDireccionRestaurante() {
        return direccionRestaurante;
    }

    public void setDireccionRestaurante(String direccionRestaurante) {
        this.direccionRestaurante = direccionRestaurante;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getPaginaWeb() {
        return paginaWeb;
    }

    public void setPaginaWeb(String paginaWeb) {
        this.paginaWeb = paginaWeb;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getImagen1() {
        return imagen1;
    }

    public void setImagen1(String imagen1) {
        this.imagen1 = imagen1;
    }

    public String getImagen2() {
        return imagen2;
    }

    public void setImagen2(String imagen2) {
        this.imagen2 = imagen2;
    }

    public String getImagen3() {
        return imagen3;
    }

    public void setImagen3(String imagen3) {
        this.imagen3 = imagen3;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    
}
