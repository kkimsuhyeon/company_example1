package demo.scheduler.dto.request;

import demo.scheduler.domain.constant.Color;
import demo.scheduler.domain.constant.RepeatUnit;
import demo.scheduler.dto.common.Schedule;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.List;


@Getter
@ToString
@AllArgsConstructor
public class RequestCreateSchedule {

    @NotNull
    private String title;

    private String content;

    @NotNull
    private Color color;

    private RepeatUnit repeatUnit;

    private int alertTime;

    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime startDateTime;

    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime endDateTime;

    public Schedule toDto() {
        return Schedule
                .builder()
                .title(title)
                .content(content)
                .color(color)
                .repeatUnit(repeatUnit)
                .alertTime(alertTime)
                .startDateTime(startDateTime)
                .endDateTime(endDateTime)
                .build();
    }
}
