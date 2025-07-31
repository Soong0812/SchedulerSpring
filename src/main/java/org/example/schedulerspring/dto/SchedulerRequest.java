package org.example.schedulerspring.dto;

import lombok.Getter;

@Getter
public class SchedulerRequest {
    private String title;
    private String content;
    private String writer;
    private String password;
}
