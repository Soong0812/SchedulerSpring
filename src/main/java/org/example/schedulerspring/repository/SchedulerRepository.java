package org.example.schedulerspring.repository;

import org.example.schedulerspring.entity.Schedule;
import org.springframework.data.repository.CrudRepository;

public interface SchedulerRepository extends CrudRepository<Schedule,Long> {
}
