package com.example.scheduler.entity;

import com.example.scheduler.constant.Color;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Schedule {

    private Long id;

    private String title;

    private String content;

    private Color color;
}
