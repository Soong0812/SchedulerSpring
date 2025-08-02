package org.example.schedulerspring.controller;

import lombok.RequiredArgsConstructor;
import org.example.schedulerspring.dto.SchedulerRequest;
import org.example.schedulerspring.dto.SchedulerResponse;
import org.example.schedulerspring.service.SchedulerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class SchedulerController {

    private final SchedulerService schedulerService;

    @PostMapping
    public ResponseEntity<SchedulerResponse> createSchedule(@RequestBody SchedulerRequest request) {
        SchedulerResponse response = schedulerService.createScheduler(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/schedules")
    public List<SchedulerResponse> getSchedules(
            @RequestParam(required = false) String writer
    ) {
        return schedulerService.getSchedules(writer);
    }

    @GetMapping("/schedules/{scheduleId}")
    public SchedulerResponse getSchedule(
            @PathVariable Long scheduleId
    ) {
        return schedulerService.getSchedule(scheduleId);
    }

    @PutMapping("/schedules/{scheduleId}")
    public ResponseEntity<SchedulerResponse> updateSchedule(
            @PathVariable Long scheduleId,
            @RequestBody SchedulerRequest request
    ) {
        return ResponseEntity.ok(schedulerService.updateSchedule(scheduleId, request));
    }

    @DeleteMapping("/schedules/{scheduleId}")
    public ResponseEntity<Void> deleteSchedule(
            @PathVariable Long scheduleId,
            @RequestBody SchedulerRequest request
    ) {
        schedulerService.deleteSchedule(scheduleId, request.getPassword());
        return ResponseEntity.ok().build();
    }
}
