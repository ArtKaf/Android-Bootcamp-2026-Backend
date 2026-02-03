package ru.sicampus.bootcamp2026.entity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "person")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "role", nullable = false)
    private String role;

    @Column(name = "password", nullable = true)
    private  String password;

    @Column(name = "login", nullable = false)
    private String login;
}