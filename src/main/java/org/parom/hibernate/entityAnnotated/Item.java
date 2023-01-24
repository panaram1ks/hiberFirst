package org.parom.hibernate.entityAnnotated;

import lombok.*;
import org.parom.hibernate.entity.User;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(schema = "hiber_annotations")
@Data
@EqualsAndHashCode(exclude = { "pid"})
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long pid;

    @ManyToOne(fetch = FetchType.LAZY)
    private UserAnnotated seller;

    @OneToMany(mappedBy = "item", fetch = FetchType.LAZY)
    private Set<Bid> bids = new HashSet<Bid>();

    private String nameLot;
}
