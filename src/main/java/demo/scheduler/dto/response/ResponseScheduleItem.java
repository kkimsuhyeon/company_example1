package demo.scheduler.dto.response;

import demo.scheduler.domain.constant.Color;
import demo.scheduler.dto.common.Schedule;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@ToString
public class ResponseScheduleItem {

    private Long id;

    private String title;

    private Color color;

    private LocalDateTime startDateTime;

    private LocalDateTime endDateTime;

    public static ResponseScheduleItem from(Schedule dto) {
        return new ResponseScheduleItem(
                dto.getId(),
                dto.getTitle(),
                dto.getColor(),
                dto.getStartDateTime(),
                dto.getEndDateTime());
    }
}
