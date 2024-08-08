package demo.scheduler.dto.request;

import demo.scheduler.domain.constant.Color;
import demo.scheduler.domain.constant.RepeatUnit;
import demo.scheduler.dto.common.ScheduleDto;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;


@AllArgsConstructor
@Getter
@ToString
public class RequestModifySchedule {

    @NotNull
    private String title;

    private String content;

    @NotNull
    private Color color;

    private RepeatUnit repeatUnit;

    private int alertTime;

    @NotNull
    private LocalDateTime startDateTime;

    @NotNull
    private LocalDateTime endDateTime;

    private MultipartFile files;

    public ScheduleDto of(Long id) {
        return new ScheduleDto
                .Builder(title, color, startDateTime, endDateTime)
                .id(id)
                .content(content)
                .repeatUnit(repeatUnit)
                .alertTime(alertTime)
                .build();
    }
}
