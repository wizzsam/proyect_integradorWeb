package bean;

import model.Review;
import dao.ReviewDao;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@RequestScoped
public class ReviewBean implements Serializable {
    private String comment;
    private int rating;
    private List<Review> reviews;

    private ReviewDao reviewDao = new ReviewDao();

    public String agregarReseña() {
        Review review = new Review(comment, rating);
        reviewDao.save(review);

        // Actualiza la lista de reseñas
        reviews = reviewDao.findAll();

        // Limpiar los campos del formulario
        limpiarFormulario();

        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Reseña agregada con éxito"));

        return "detallesRestaurante?faces-redirect=true"; // Redirige a la página de detalles del restaurante
    }

    private void limpiarFormulario() {
        comment = null;
        rating = 0;
    }

   public List<Review> getReviews() {
    if (reviews == null) {
        reviews = reviewDao.findAll();
    }
    return reviews;
}

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}