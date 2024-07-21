
package bean;

import model.Reseña;
import dao.ReseñaDao;
import dao.UserDao;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

@Named
@SessionScoped
public class ReseñaBean implements Serializable {

    private int idRestaurante;
    private String usuario;
    private String descripcion;
    private int calificacion;
    private String imagen;
    private List<Reseña> reseñas;
    private List<Reseña> reseñasFiltradas;
    private ReseñaDao reseñaDao = new ReseñaDao();

    @PostConstruct
    public void init() {
        reseñas = reseñaDao.findAll();
        reseñasFiltradas = reseñas;
    }

    public String registrar() {
        try {
        // Obtener el ID del usuario de la sesión
        usuario = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("username");
         if (usuario == null) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Debe iniciar sesión", "Debe iniciar sesión para registrar una reseña."));
                return "login"; // Redirigir a la página de login si no hay usuario en la sesión
            }
        Reseña reseña = new Reseña();
            reseña.setIdRestaurante(idRestaurante);
            reseña.setUsuario(usuario); // Asignar el nombre de usuario de la sesión
            reseña.setDescripcion(descripcion);
            reseña.setCalificacion(calificacion);
            reseña.setImagen(imagen);

            reseñaDao.addReseña(reseña);
        // Actualiza la lista de reseñas
        reseñas = reseñaDao.findAll();
        filtrar();

        // Limpiar los campos del formulario
        limpiarFormulario();

        return "registroExitoso"; // Redirige a una página de confirmación
   } catch (Exception e) {
        e.printStackTrace();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Error al registrar la reseña"));
        return "error"; // Navegación a la página de error
    }
    }
    private void limpiarFormulario() {
        idRestaurante = 0;
        usuario = null;
        descripcion = null;
        calificacion = 0;
        imagen = null;
    }

    public void filtrar() {
        // Filtrar reseñas según el id del restaurante o algún otro criterio si es necesario
        reseñasFiltradas = reseñas.stream()
                .filter(r -> r.getIdRestaurante() == idRestaurante)
                .collect(Collectors.toList());
    }

    // Getters y setters

    public int getIdRestaurante() {
        return idRestaurante;
    }

    public void setIdRestaurante(int idRestaurante) {
        this.idRestaurante = idRestaurante;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public List<Reseña> getReseñas() {
        return reseñasFiltradas;
    }

    public void setReseñas(List<Reseña> reseñas) {
        this.reseñas = reseñas;
    }

    public List<Reseña> getReseñasFiltradas() {
        return reseñasFiltradas;
    }

    public void setReseñasFiltradas(List<Reseña> reseñasFiltradas) {
        this.reseñasFiltradas = reseñasFiltradas;
    }

    public ReseñaDao getReseñaDao() {
        return reseñaDao;
    }

    public void setReseñaDao(ReseñaDao reseñaDao) {
        this.reseñaDao = reseñaDao;
    }
}
