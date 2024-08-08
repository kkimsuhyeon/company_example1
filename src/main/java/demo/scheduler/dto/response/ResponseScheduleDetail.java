package demo.scheduler.dto.response;

import demo.scheduler.domain.constant.Color;
import demo.scheduler.domain.constant.RepeatUnit;
import demo.scheduler.dto.common.ScheduleDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;


@AllArgsConstructor
@Getter
@ToString
public class ResponseScheduleDetail {

    private Long id;

    private String title;

    private String content;

    private Color color;

    private RepeatUnit repeatUnit;

    private int alertTime;

    private LocalDateTime startDateTime;

    private LocalDateTime endDateTime;

    public static ResponseScheduleDetail from(ScheduleDto dto) {
        return new ResponseScheduleDetail(
                dto.getId(),
                dto.getTitle(),
                dto.getContent(),
                dto.getColor(),
                dto.getRepeatUnit(),
                dto.getAlertTime(),
                dto.getStartDateTime(),
                dto.getEndDateTime());
    }
}
