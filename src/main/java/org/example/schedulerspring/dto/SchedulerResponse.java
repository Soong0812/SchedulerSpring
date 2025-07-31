package org.example.schedulerspring.dto;

import lombok.Getter;
import org.example.schedulerspring.entity.Schedule;

import java.time.LocalDateTime;

@Getter
public class SchedulerResponse {
    private Long id;
    private String title;
    private String content;
    private String writer;
    private LocalDateTime createAt;

    public SchedulerResponse(Schedule schedule) {
        this.id = schedule.getId();
        this.title = schedule.getTitle();
        this.content = schedule.getContent();
        this.writer = schedule.getWriter();
        this.createAt = schedule.getCreateAt();
    }
}
