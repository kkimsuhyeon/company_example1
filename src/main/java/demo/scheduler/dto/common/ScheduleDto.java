package demo.scheduler.dto.common;

import demo.scheduler.domain.Schedule;
import demo.scheduler.domain.constant.Color;
import demo.scheduler.domain.constant.RepeatUnit;
import lombok.Getter;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@ToString
public class ScheduleDto {

    private Long id;
    private String title;
    private String content;
    private Color color;
    private RepeatUnit repeatUnit;
    private int alertTime;
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;
    private List<MultipartFile> files;

    public ScheduleDto(Builder builder) {
        this.id = builder.id;
        this.title = builder.title;
        this.content = builder.content;
        this.color = builder.color;
        this.repeatUnit = builder.repeatUnit;
        this.alertTime = builder.alertTime;
        this.startDateTime = builder.startDateTime;
        this.endDateTime = builder.endDateTime;
        this.files = builder.files;
    }

    public Schedule toEntity() {
        return Schedule.builder()
                .id(id)
                .title(title)
                .content(content)
                .color(color)
                .repeatUnit(repeatUnit)
                .alertTime(alertTime)
                .startDateTime(startDateTime)
                .endDateTime(endDateTime)
                .build();
    }

    public static ScheduleDto fromEntity(Schedule entity) {
        return new Builder(entity.getTitle(), entity.getColor(), entity.getStartDateTime(), entity.getEndDateTime())
                .id(entity.getId())
                .alertTime(entity.getAlertTime())
                .repeatUnit(entity.getRepeatUnit())
                .build();
    }

    public static class Builder {
        private Long id;
        private String title;
        private String content;
        private Color color;
        private RepeatUnit repeatUnit;
        private int alertTime;
        private LocalDateTime startDateTime;
        private LocalDateTime endDateTime;
        private List<MultipartFile> files;

        public Builder(String title, Color color, LocalDateTime startDateTime, LocalDateTime endDateTime) {
            this.title = title;
            this.color = color;
            this.startDateTime = startDateTime;
            this.endDateTime = endDateTime;
        }

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder content(String content) {
            this.content = content;
            return this;
        }

        public Builder repeatUnit(RepeatUnit repeatUnit) {
            this.repeatUnit = repeatUnit;
            return this;
        }

        public Builder alertTime(int alertTime) {
            this.alertTime = alertTime;
            return this;
        }

        public Builder files(List<MultipartFile> files) {
            this.files = files;
            return this;
        }

        public ScheduleDto build() {
            return new ScheduleDto(this);
        }
    }
}
