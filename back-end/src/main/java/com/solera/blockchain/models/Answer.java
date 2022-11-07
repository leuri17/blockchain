package com.solera.blockchain.models;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name="answers")
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Type(type = "org.hibernate.type.PostgresUUIDType")
    public UUID id;

    @ManyToOne
    @JoinColumn(name="id_question", nullable=false)
    public Question id_question;

    @Column(nullable = false)
    public String answer;



}
