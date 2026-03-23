package com.jeremy.demospring.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Component {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer Id;

    @Column(length = 20,nullable = false)
    @NotBlank
    @Length(min=3,max=20)
    protected String name;

    @Column(length = 10,nullable = false, unique = true)
    @NotBlank
    @Length(min=10,max=10)
    protected String serialNumber;

    @Column(columnDefinition = "TEXT")
    protected String description;

}
