package org.parom.hibernate.entityAnnotated;

import lombok.*;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;
import java.util.Date;

/**
 * @author E.Parominsky 23/01/2023 10:26
 */

@Entity
@Table(schema = "hiber_annotations")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = { "pid"})
@Builder
public class Bid {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pid;

    @ManyToOne
    @JoinColumn(name = "item")
    private Item item;

    @Column(name = "bid_bate")
    private Date dateOfbid;

    @Column(name = "amount")
    private Double value;

}
