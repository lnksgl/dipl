package spring.enquiry;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.Instant;

@Entity
@Table(name="enquiry")
@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Enquiry {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", updatable = false, nullable = false, unique=true)
    Long id;
    @Column(name="idusers")
    Long idUsers;
    @Column(name="idgroups")
    Long idGroups;
    @Column(name="createdon")
    Instant createdOn;
}
