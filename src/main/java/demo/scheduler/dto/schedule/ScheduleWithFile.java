package demo.scheduler.dto.schedule;

import demo.scheduler.domain.constant.Color;
import demo.scheduler.domain.constant.RepeatUnit;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;

@AllArgsConstructor
@ToString
@Getter
public class ScheduleWithFile {

    private Long id;
    private String title;
    private String content;
    private Color color;
    private RepeatUnit repeatUnit;
    private int alertTime;
    private LocalDate startDateTime;
    private LocalDate endDateTime;

    private Long fileId;
    private String originName;
}
