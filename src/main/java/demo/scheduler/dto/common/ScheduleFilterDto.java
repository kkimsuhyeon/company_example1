package demo.scheduler.dto.common;

import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;
import java.time.temporal.WeekFields;
import java.util.Locale;

@Getter
@ToString
public class ScheduleFilterDto {

    private Integer month;
    private Integer weekly;
    private Integer totalWeekly;

    public ScheduleFilterDto(Integer month, Integer weekly) {
        this.month = month;
        this.weekly = weekly;

        if (month != null && weekly != null) {
            this.totalWeekly = getTotalWeekly(month, weekly);
        }
    }


    public static Integer getTotalWeekly(Integer month, Integer weekly) {

        int year = 2024;

        LocalDate startOfMarch = LocalDate.of(year, month, 1);
        LocalDate startOfThirdWeek = startOfMarch.plusWeeks(weekly - 1);

        WeekFields weekFields = WeekFields.of(Locale.getDefault());
        int weekNumber = startOfThirdWeek.get(weekFields.weekOfWeekBasedYear());

        return weekNumber;
    }

}
