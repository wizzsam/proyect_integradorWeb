/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bean;



import model.Restaurante;
import dao.RestauranteDao;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import java.util.List;

@Named
@RequestScoped
public class RestauranteBean {

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
    private List<Restaurante> restaurantes;

    private RestauranteDao restauranteDao = new RestauranteDao();

    @PostConstruct
    public void init() {
        restaurantes = restauranteDao.findAll();
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

        restauranteDao.save(restaurante);
        return "registroExitoso"; // Redirige a una página de confirmación
    }

    public List<Restaurante> getRestaurantes() {
        return restaurantes;
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

    public RestauranteDao getRestauranteDao() {
        return restauranteDao;
    }

    public void setRestauranteDao(RestauranteDao restauranteDao) {
        this.restauranteDao = restauranteDao;
    }

    
}