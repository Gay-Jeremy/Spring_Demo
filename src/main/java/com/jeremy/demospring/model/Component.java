package com.jeremy.demospring.model;

import com.fasterxml.jackson.annotation.JsonView;
import com.jeremy.demospring.view.AppUserView;
import com.jeremy.demospring.view.ComponentView;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Component {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(ComponentView.class)
    protected Integer Id;

    @Column(length = 20,nullable = false)
    @NotBlank
    @Length(min=3,max=20)
    @JsonView({AppUserView.class, ComponentView.class})
    protected String name;

    @Column(length = 10,nullable = false, unique = true)
    @NotBlank
    @Length(min=10,max=10)
    @JsonView({AppUserView.class, ComponentView.class})
    protected String serialNumber;

    @Column(columnDefinition = "TEXT")
    @JsonView(ComponentView.class)
    protected String description;

    @ManyToOne
    @JsonView(ComponentView.class)
    protected AppUser loaner;

    @ManyToMany
    @JoinTable(
            name = "tag_component",
            joinColumns = @JoinColumn(name = "component_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    @JsonView(ComponentView.class)
    protected List<Tag> tags = new ArrayList<>();

}
