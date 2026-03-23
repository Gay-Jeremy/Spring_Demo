package com.jeremy.demospring.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

// Génération des gettes
@Getter
// Génération des setters
@Setter
//Génération d'un constructeur avec tous les champs en paramètres'
@AllArgsConstructor
// Génération d'un constructeur vide
@NoArgsConstructor
//Indique à JPA (Java Persistence API) que cette classe est mappée (correspondance direct) à une table en base de données
@Entity

public class AppUser {

    public interface  OnUpdate {};
    public interface  OnCreate {};

    // désigne le champ Id comme clé primaire
    @Id
    // Indique que la valeur de l'ID est auto-incrémentée par la base de données
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer Id;

    @Column(nullable = false, unique = true) // email ne peut pas être null et doit être unique
    @NotBlank(groups = {OnCreate.class}) // Vérifie que la valeur n'est ni null ni vide("")
    @Email(groups = {OnCreate.class}) // Vérifie la valeur a un format d'email ("a@a")
    // @Pattern() => permet de vérifier via REGEX
    protected String email;

    @Column(nullable = false)
    @NotBlank(groups = {OnCreate.class})
    protected String password;

    // Plusieurs utilisateurs peuvent ne pas avoir de pseudo
    // Mais si un pseudo est fournis il doit être unique, >5 caractères et <= 20 cacractères
    @Column(length = 20, unique = true) // Optimisation BDD car crée un VARCHAR 20
    @Length(min = 5, max = 20, groups = {OnUpdate.class, OnCreate.class})
    protected String pseudo;

    @ManyToOne(optional = false)
    protected Role role;

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo.toLowerCase();
    }
}
