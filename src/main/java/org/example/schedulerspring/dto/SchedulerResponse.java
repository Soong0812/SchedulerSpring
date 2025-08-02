package org.example.schedulerspring.dto;

import lombok.Getter;
import org.example.schedulerspring.entity.Schedule;

import java.time.LocalDateTime;

@Getter
public class SchedulerResponse {
    private final Long id;
    private final String title;
    private final String content;
    private final String writer;
    private final LocalDateTime createdAt;
    private final LocalDateTime updatedAt;

    public SchedulerResponse(Schedule schedule) {
        this.id = schedule.getId();
        this.title = schedule.getTitle();
        this.content = schedule.getContent();
        this.writer = schedule.getWriter();
        this.createdAt = schedule.getCreatedAt();
        this.updatedAt = schedule.getUpdatedAt();
    }

}
