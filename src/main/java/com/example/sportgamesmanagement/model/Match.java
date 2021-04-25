package com.example.sportgamesmanagement.model;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Time;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "match")
public class Match implements Serializable {

    @Id
    @GeneratedValue(generator = "uuid", strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "ID")
    private String id;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "match_date", nullable = false)
    private Date match_date;

    @Column(name = "match_time", nullable = false)
    private Time match_time;

    @Column(name = "team_a", nullable = false)
    private String team_a;

    @Column(name = "team_b", nullable = false)
    private String team_b;

    @Enumerated(value = EnumType.STRING)
    private Sport sport;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "odd_id")
    private Set<MatchOdds> matchOdds = new HashSet<>();

}
