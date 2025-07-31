package org.example.schedulerspring.controller;

import lombok.RequiredArgsConstructor;
import org.example.schedulerspring.dto.SchedulerRequest;
import org.example.schedulerspring.dto.SchedulerResponse;
import org.example.schedulerspring.service.SchedulerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/schedules")
public class SchedulerController {

    private final SchedulerService schedulerService;

    @PostMapping
    public ResponseEntity<SchedulerResponse> createSchedule(@RequestBody SchedulerRequest request) {
        SchedulerResponse response = schedulerService.createScheduler(request);
        return ResponseEntity.ok(response);
    }
}
