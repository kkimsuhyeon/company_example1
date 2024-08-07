package demo.scheduler.domain;

import demo.scheduler.domain.constant.Color;
import demo.scheduler.domain.constant.RepeatUnit;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Builder
@Getter
public class Schedule {

    private Long id;

    private String title;

    private String content;

    private Color color;

    private RepeatUnit repeatUnit;

    private int alertTime;

    private LocalDate startDateTime;

    private LocalDate endDateTime;

}
