package com.example.sportgamesmanagement.model;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "odds")
public class MatchOdds implements Serializable {

    @Id
    @GeneratedValue(generator = "uuid", strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "ID")
    private String odd_id;

    @OneToOne
    @JoinColumn(name = "match_id")
    private Match match;

    @Column(name = "specifier", nullable = false)
    private String specifier;

    @Column(name = "odd", nullable = false)
    private double odd;

}
