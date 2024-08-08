package demo.scheduler.dto.response;

import demo.scheduler.domain.constant.Color;
import demo.scheduler.dto.common.ScheduleDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;


@AllArgsConstructor
@Getter
@ToString
public class ResponseScheduleItem {

    private Long id;

    private String title;

    private Color color;

    private LocalDateTime startDateTime;

    private LocalDateTime endDateTime;

    public static ResponseScheduleItem from(ScheduleDto dto) {
        return new ResponseScheduleItem(dto.getId(), dto.getTitle(), dto.getColor(), dto.getStartDateTime(), dto.getEndDateTime());
    }
}
