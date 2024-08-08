package demo.scheduler.dto.common;

import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;
import java.time.temporal.WeekFields;
import java.util.Locale;

@Getter
@ToString
public class ScheduleFilter {

    private static final int YEAR = 2024;

    private final Integer month;
    private final Integer weekly;
    private Integer totalWeekly;

    public ScheduleFilter(Integer month, Integer weekly) {
        this.month = month;
        this.weekly = weekly;

        if (month != null && weekly != null) {
            this.totalWeekly = getTotalWeekly(month, weekly);
        }
    }

    public static Integer getTotalWeekly(Integer month, Integer weekly) {

        LocalDate startOfMarch = LocalDate.of(YEAR, month, 1);
        LocalDate startOfThirdWeek = startOfMarch.plusWeeks(weekly - 1);

        WeekFields weekFields = WeekFields.of(Locale.getDefault());

        return startOfThirdWeek.get(weekFields.weekOfWeekBasedYear());
    }

}
