package com.jeremy.demospring.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@IdClass(Acknowledge.Key.class)
public class Acknowledge {

    @Embeddable
    public class Key implements Serializable {
        @Column(name = "user_id")
        Integer userId;
        @Column(name = "skill_id")
        Integer skillId;
    }

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    protected Integer Id;

    @Id
    protected Integer userId;

    @Id
    protected Integer skillId;

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    protected AppUser user;

    @ManyToOne
    @MapsId("skillId")
    @JoinColumn(name = "skill_id")
    protected Skill skill;

    protected int level;

}
