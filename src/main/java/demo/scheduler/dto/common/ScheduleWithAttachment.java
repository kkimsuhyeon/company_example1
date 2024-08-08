package demo.scheduler.dto.common;

import demo.scheduler.domain.constant.Color;
import demo.scheduler.domain.constant.RepeatUnit;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@ToString
@Builder
public class ScheduleWithAttachment {

    private Long id;
    private String title;
    private String content;
    private Color color;
    private RepeatUnit repeatUnit;
    private int alertTime;
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;

    private Long fileId;
    private String originName;


}
