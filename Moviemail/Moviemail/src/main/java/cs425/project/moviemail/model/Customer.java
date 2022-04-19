package cs425.project.moviemail.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Long customerId;

    @Column(name="name", nullable = false)
    private String name;

    @Column(name="address", nullable = false)
    private String address;

    @Column(name="phone", nullable = false)
    private String phoneNo;
}
