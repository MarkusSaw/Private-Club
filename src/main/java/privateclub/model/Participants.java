package privateclub.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "participants")
public class Participants {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name" , nullable = false)
    private String firstname;

    @Column(name = "last_name" , nullable = false)
    private String lastname;

    @Column(name = "patronymic", nullable = false)
    private  String patronymic;

    @OneToMany(mappedBy = "participant")
    @JoinColumn(name = "codes")
    private List<Qrcodes> qrcodes = new ArrayList<>();


}