package cs425.project.moviemail.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "admin")
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "admin_id")
    private Long adminId;

    @Column(name="name", nullable = false)
    private String name;

    @Column(name="address", nullable = false)
    private String address;

    @Column(name="phone", nullable = false)
    private String phoneNo;
}
