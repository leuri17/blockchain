package com.solera.blockchain.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name="answers")
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Type(type = "org.hibernate.type.PostgresUUIDType")
    public UUID id;

    @Column(nullable = false)
    public String answer;

    @ManyToOne
    @JoinColumn(name="question_id", nullable=false)
    public Question question_id;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            },
            mappedBy = "answers")
    @JsonIgnore
    private Set<User> users = new HashSet<>();
}
