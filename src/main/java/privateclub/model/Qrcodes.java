package privateclub.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "qrcodes")
public class Qrcodes {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "codes", nullable = false, unique = true)
    private UUID codes;

    @ManyToOne
    @JoinColumn(name = "participant_id")


    private Participants participant;

    public Qrcodes(Participants participant){
        this.codes = UUID.randomUUID();
        this.participant = participant;

    }


}
