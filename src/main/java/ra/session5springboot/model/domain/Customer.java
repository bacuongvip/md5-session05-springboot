package ra.session5springboot.model.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "customers")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "full_name", length = 50)
    private String fullName;
    @Column(name = "age")
    private int age;
    @Column(name = "gender")
    private boolean sex;
    @Column(name = "email", length = 100)
    private String email;
    @Column(name = "phone", length = 11)
    private String phoneNumber;
}
