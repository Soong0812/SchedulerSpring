package org.example.schedulerspring.repository;

import org.example.schedulerspring.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SchedulerRepository extends JpaRepository<Schedule,Long> {
    List<Schedule> findAllByWriterOrderByUpdatedAtDesc(String writer);
    List<Schedule> findAllByOrderByUpdatedAtDesc();
}
