package com.example.scheduler.dto.request;

import com.example.scheduler.constant.Color;
import com.example.scheduler.dto.common.ScheduleDto;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class RequestCreateSchedule {

    @NotNull
    private String title;

    private String content;

    @NotNull
    private Color color;

    public ScheduleDto toDto() {
        return new ScheduleDto.Builder(title, color).content(content).build();
    }
}
