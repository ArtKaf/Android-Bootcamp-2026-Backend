package ru.sicampus.bootcamp2026.repository;

import ru.sicampus.bootcamp2026.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
}