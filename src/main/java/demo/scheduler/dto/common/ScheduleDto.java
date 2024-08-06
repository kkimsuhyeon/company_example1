package demo.scheduler.dto.common;

import demo.scheduler.domain.Schedule;
import demo.scheduler.domain.constant.Color;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class ScheduleDto {

    private Long id;
    private String title;
    private String content;
    private Color color;

    public ScheduleDto(Builder builder) {
        this.id = builder.id;
        this.title = builder.title;
        this.content = builder.content;
        this.color = builder.color;
    }

    public Schedule toEntity() {
        return Schedule.builder()
                .id(id)
                .title(title)
                .content(content)
                .color(color)
                .build();
    }

    public static class Builder {
        private Long id;
        private String title;
        private String content;
        private Color color;

        public Builder(String title, Color color) {
            this.title = title;
            this.color = color;
        }

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder content(String content) {
            this.content = content;
            return this;
        }

        public ScheduleDto build() {
            return new ScheduleDto(this);
        }
    }
}
