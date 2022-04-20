package cs425.project.moviemail.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "movie")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movie_id")
    private Long movieId;

    @Column(name="movie_name", nullable = false)
    private String movieName;

    @Column(name="genre", nullable = false)
    private int genre; //Genre.Action.value;

    @Column(name="released_date")
    private LocalDate releasedDate;

    @Column(name="price", nullable = false)
    private double rentalPrice;

    @ManyToMany(mappedBy="movies")
    private List<Record> records = new ArrayList<>();

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public int getGenre() {
        return genre;
    }

    public void setGenre(int genre) {
        this.genre = genre;
    }

    public LocalDate getReleasedDate() {
        return releasedDate;
    }

    public void setReleasedDate(LocalDate releasedDate) {
        this.releasedDate = releasedDate;
    }

    public double getRentalPrice() {
        return rentalPrice;
    }

    public void setRentalPrice(double rentalPrice) {
        this.rentalPrice = rentalPrice;
    }

    public List<Record> getRecords() {
        return records;
    }

    public void setRecords(List<Record> records) {
        this.records = records;
    }
}
