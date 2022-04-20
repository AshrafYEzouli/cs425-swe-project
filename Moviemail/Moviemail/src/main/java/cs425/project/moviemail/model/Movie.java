package cs425.project.moviemail.model;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

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
    private String genre;

    @Column(name="released_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate releasedDate;

    @Column(name="price", nullable = false)
    private double rentalPrice;

    @ManyToMany(mappedBy="movies")
    private List<Record> records = new ArrayList<>();
}
