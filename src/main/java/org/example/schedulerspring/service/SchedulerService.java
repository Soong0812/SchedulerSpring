package org.example.schedulerspring.service;

import lombok.RequiredArgsConstructor;
import org.example.schedulerspring.dto.SchedulerRequest;
import org.example.schedulerspring.dto.SchedulerResponse;
import org.example.schedulerspring.entity.Schedule;
import org.example.schedulerspring.repository.SchedulerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SchedulerService {

    private final SchedulerRepository schedulerRepository;

    @Transactional
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

    @Transactional(readOnly = true)
    public List<SchedulerResponse> getSchedules(String writer) {
        List<Schedule> scheduleList;
            if (writer != null) {
                scheduleList = schedulerRepository.findAllByWriterOrderByUpdatedAtDesc(writer);
            } else {
                scheduleList = schedulerRepository.findAllByOrderByUpdatedAtDesc();
            }

        List<SchedulerResponse> dtoList = new ArrayList<>();
        for (Schedule schedule : scheduleList) {
            dtoList.add(new SchedulerResponse(schedule));
        }
        return dtoList;
    }
    @Transactional
    public SchedulerResponse getSchedule(Long id) {
        Schedule schedule = schedulerRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 일정이 없습니다.")
        );
        return new SchedulerResponse(schedule);
    }

    @Transactional
    public SchedulerResponse updateSchedule(Long id, SchedulerRequest request) {
        Schedule schedule = schedulerRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 일정이 없습니다.")
        );

        if (!schedule.getPassword().equals(request.getPassword())) {
            throw new IllegalArgumentException("비밀번호가 틀렸습니다.");
        }

        schedule.updateTitleAndWriter(request.getTitle(), request.getWriter());
        return new SchedulerResponse(schedule);
    }

    @Transactional
    public void deleteSchedule(Long id, String password) {
        Schedule schedule = schedulerRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 일정이 없습니다.")
        );

        if (!schedule.getPassword().equals(password)) {
            throw new IllegalArgumentException("비밀번호가 틀렸습니다.");
        }

        schedulerRepository.deleteById(id);
    }

}
