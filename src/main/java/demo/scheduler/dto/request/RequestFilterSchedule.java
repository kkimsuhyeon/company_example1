package demo.scheduler.dto.request;

import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;
import java.time.temporal.WeekFields;
import java.util.Locale;

@Getter
@ToString
public class RequestFilterSchedule {

    private final Integer month;
    private final Integer weekly;
    private Integer totalWeekly;

    public RequestFilterSchedule(Integer month, Integer weekly) {
        this.month = month;
        this.weekly = weekly;

        if (month != null && weekly != null) {
            this.totalWeekly = getTotalWeekly();
        }
    }

    private Integer getTotalWeekly() {

        int year = 2024;

        LocalDate startOfMarch = LocalDate.of(year, this.month, 1);
        LocalDate startOfThirdWeek = startOfMarch.plusWeeks(this.weekly - 1);

        WeekFields weekFields = WeekFields.of(Locale.getDefault());
        return startOfThirdWeek.get(weekFields.weekOfWeekBasedYear());
    }
}
