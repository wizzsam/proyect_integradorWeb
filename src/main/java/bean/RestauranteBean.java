/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bean;

import model.Restaurante;
import dao.RestauranteDao;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

@Named
@SessionScoped
public class RestauranteBean implements Serializable {

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
    private String ciudad; // Nuevo campo
    private String filtroPais;
    private String filtroCiudad;
    private boolean filtroDesayuno;
    private boolean filtroAlmuerzo;
    private boolean filtroCena;
    private boolean filtroOriental;
    private boolean filtroNacional;
    private boolean filtroJaponesa;
    private boolean filtroVegana;
    private boolean filtroCaro;
    private boolean filtroEconomico;
    private boolean filtroModerado;
    private boolean filtroRestaurante;
    private boolean filtroHuarique;
    private boolean filtroAlPaso;

    private List<Restaurante> restaurantes;
    private List<Restaurante> restaurantesFiltrados;

    private RestauranteDao restauranteDao = new RestauranteDao();

    @PostConstruct
    public void init() {
        restaurantes = restauranteDao.findAll();
        restaurantesFiltrados = restaurantes;
    }

     public void verificarSesion() throws IOException {
        String username = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("username");
        if (username == null) {
            FacesContext.getCurrentInstance().getExternalContext().redirect("login.xhtml");
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Debe iniciar sesión", "Debe iniciar sesión para acceder a esta página."));
        }
    }
    
    
    public void filtrar() {
        restaurantesFiltrados = restaurantes.stream()
                .filter(r -> (filtroPais == null || filtroPais.isEmpty() || r.getPais().equalsIgnoreCase(filtroPais)) &&
                             (filtroCiudad == null || filtroCiudad.isEmpty() || r.getCiudad().equalsIgnoreCase(filtroCiudad)) &&
                             (!filtroDesayuno || r.getComidaDia().equalsIgnoreCase("Desayuno")) &&
                             (!filtroAlmuerzo || r.getComidaDia().equalsIgnoreCase("Almuerzo")) &&
                             (!filtroCena || r.getComidaDia().equalsIgnoreCase("Cena")) &&
                             (!filtroOriental || r.getTipoComida1().equalsIgnoreCase("Oriental")) &&
                             (!filtroNacional || r.getTipoComida1().equalsIgnoreCase("Nacional")) &&
                             (!filtroJaponesa || r.getTipoComida1().equalsIgnoreCase("Japonesa")) &&
                             (!filtroVegana || r.getTipoComida1().equalsIgnoreCase("Vegana")) &&
                             (!filtroCaro || r.getPrecio().equalsIgnoreCase("Caro")) &&
                             (!filtroEconomico || r.getPrecio().equalsIgnoreCase("Económico")) &&
                             (!filtroModerado || r.getPrecio().equalsIgnoreCase("Moderado")) &&
                             (!filtroRestaurante || r.getTipoEstablecimiento().equalsIgnoreCase("Restaurante")) &&
                             (!filtroHuarique || r.getTipoEstablecimiento().equalsIgnoreCase("Huarique")) &&
                             (!filtroAlPaso || r.getTipoEstablecimiento().equalsIgnoreCase("Al paso")))
                .collect(Collectors.toList());
    }

    public String registrar() {
        Restaurante restaurante = new Restaurante();
        restaurante.setNombreRestaurante1(nombreRestaurante1);
        restaurante.setNombreRestaurante2(nombreRestaurante2);
        restaurante.setTipoComida1(tipoComida1);
        restaurante.setComidaDia(comidaDia);
        restaurante.setTipoEstablecimiento(tipoEstablecimiento);
        restaurante.setDireccionRestaurante(direccionRestaurante);
        restaurante.setTelefono(telefono);
        restaurante.setPaginaWeb(paginaWeb);
        restaurante.setPrecio(precio);
        restaurante.setImagen1(imagen1);
        restaurante.setImagen2(imagen2);
        restaurante.setImagen3(imagen3);
        restaurante.setPais(pais);
        restaurante.setCiudad(ciudad);

        restauranteDao.save(restaurante);
        // Actualiza la lista de restaurantes
        restaurantes = restauranteDao.findAll();
        filtrar();

        // Limpiar los campos del formulario
        limpiarFormulario();

        return "registroExitoso"; // Redirige a una página de confirmación
    }

    private void limpiarFormulario() {
        nombreRestaurante1 = null;
        nombreRestaurante2 = null;
        tipoComida1 = null;
        comidaDia = null;
        tipoEstablecimiento = null;
        direccionRestaurante = null;
        telefono = null;
        paginaWeb = null;
        precio = null;
        imagen1 = null;
        imagen2 = null;
        imagen3 = null;
        pais = null;
        ciudad = null;
    }

    public List<Restaurante> getRestaurantes() {
        return restaurantesFiltrados;
    }

    // Getters y setters

    public String getFiltroPais() {
        return filtroPais;
    }

    public void setFiltroPais(String filtroPais) {
        this.filtroPais = filtroPais;
        filtrar();
    }

    public String getFiltroCiudad() {
        return filtroCiudad;
    }

    public void setFiltroCiudad(String filtroCiudad) {
        this.filtroCiudad = filtroCiudad;
        filtrar();
    }

    public boolean isFiltroDesayuno() {
        return filtroDesayuno;
    }

    public void setFiltroDesayuno(boolean filtroDesayuno) {
        this.filtroDesayuno = filtroDesayuno;
        filtrar();
    }

    public boolean isFiltroAlmuerzo() {
        return filtroAlmuerzo;
    }

    public void setFiltroAlmuerzo(boolean filtroAlmuerzo) {
        this.filtroAlmuerzo = filtroAlmuerzo;
        filtrar();
    }

    public boolean isFiltroCena() {
        return filtroCena;
    }

    public void setFiltroCena(boolean filtroCena) {
        this.filtroCena = filtroCena;
        filtrar();
    }

    public boolean isFiltroOriental() {
        return filtroOriental;
    }

    public void setFiltroOriental(boolean filtroOriental) {
        this.filtroOriental = filtroOriental;
        filtrar();
    }

    public boolean isFiltroNacional() {
        return filtroNacional;
    }

    public void setFiltroNacional(boolean filtroNacional) {
        this.filtroNacional = filtroNacional;
        filtrar();
    }

    public boolean isFiltroJaponesa() {
        return filtroJaponesa;
    }

    public void setFiltroJaponesa(boolean filtroJaponesa) {
        this.filtroJaponesa = filtroJaponesa;
        filtrar();
    }

    public boolean isFiltroVegana() {
        return filtroVegana;
    }

    public void setFiltroVegana(boolean filtroVegana) {
        this.filtroVegana = filtroVegana;
        filtrar();
    }

    public boolean isFiltroCaro() {
        return filtroCaro;
    }

    public void setFiltroCaro(boolean filtroCaro) {
        this.filtroCaro = filtroCaro;
        filtrar();
    }

    public boolean isFiltroEconomico() {
        return filtroEconomico;
    }

    public void setFiltroEconomico(boolean filtroEconomico) {
        this.filtroEconomico = filtroEconomico;
        filtrar();
    }

    public boolean isFiltroModerado() {
        return filtroModerado;
    }

    public void setFiltroModerado(boolean filtroModerado) {
        this.filtroModerado = filtroModerado;
        filtrar();
    }

    public boolean isFiltroRestaurante() {
        return filtroRestaurante;
    }

    public void setFiltroRestaurante(boolean filtroRestaurante) {
        this.filtroRestaurante = filtroRestaurante;
        filtrar();
    }

    public boolean isFiltroHuarique() {
        return filtroHuarique;
    }

    public void setFiltroHuarique(boolean filtroHuarique) {
        this.filtroHuarique = filtroHuarique;
        filtrar();
    }

    public boolean isFiltroAlPaso() {
        return filtroAlPaso;
    }

    public void setFiltroAlPaso(boolean filtroAlPaso) {
        this.filtroAlPaso = filtroAlPaso;
        filtrar();
    }

    public List<Restaurante> getRestaurantesFiltrados() {
        return restaurantesFiltrados;
    }

    public void setRestaurantesFiltrados(List<Restaurante> restaurantesFiltrados) {
        this.restaurantesFiltrados = restaurantesFiltrados;
    }

    public RestauranteDao getRestauranteDao() {
        return restauranteDao;
    }

    public void setRestauranteDao(RestauranteDao restauranteDao) {
        this.restauranteDao = restauranteDao;
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

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    
}