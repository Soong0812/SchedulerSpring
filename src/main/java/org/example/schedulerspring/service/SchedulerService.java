package org.example.schedulerspring.service;

import lombok.RequiredArgsConstructor;
import org.example.schedulerspring.dto.SchedulerRequest;
import org.example.schedulerspring.dto.SchedulerResponse;
import org.example.schedulerspring.entity.Schedule;
import org.example.schedulerspring.repository.SchedulerRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SchedulerService {

    private final SchedulerRepository schedulerRepository;

    public SchedulerResponse createScheduler(SchedulerRequest request) {
        Schedule schedule = new Schedule(
                request.getTitle(),
                request.getContent(),
                request.getWriter(),
                request.getPassword()
        );

        Schedule saved = schedulerRepository.save(schedule);
        return new SchedulerResponse(saved);
    }
}
