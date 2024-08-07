package demo.scheduler.domain.constant;

import lombok.Getter;

public enum RepeatUnit {

    DAY("매일"),
    WEEK("매주"),
    MONTH("매월"),
    YEAR("매년");

    @Getter
    private final String description;

    RepeatUnit(String description) {
        this.description = description;
    }

}
