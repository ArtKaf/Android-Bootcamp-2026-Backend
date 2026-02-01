package ru.sicampus.bootcamp2026.repository;
import ru.sicampus.bootcamp2026.entity.Meeting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MeetingRepository extends JpaRepository<Meeting, Long> {
}