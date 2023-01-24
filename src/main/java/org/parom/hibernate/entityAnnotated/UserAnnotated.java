package org.parom.hibernate.entityAnnotated;

import lombok.*;

import javax.persistence.*;

@Data //lombok
@EqualsAndHashCode(exclude = { "pid"})
@NoArgsConstructor //lombok
@AllArgsConstructor //lombok
@Builder //lombok
@Entity //hibernate
@Table(name = "users_annotated", schema = "hiber_annotations")//hibernate
public class UserAnnotated {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pid;

    private String username;
    private String firstname;
    private String lastname;
}
