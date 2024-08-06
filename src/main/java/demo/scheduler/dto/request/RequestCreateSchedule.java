package demo.scheduler.dto.request;

import demo.scheduler.domain.constant.Color;
import demo.scheduler.dto.common.ScheduleDto;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
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
