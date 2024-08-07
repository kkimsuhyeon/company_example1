package demo.scheduler.dto.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class ScheduleFilterDto {

    private Integer month;
    private Integer weekly;

}
