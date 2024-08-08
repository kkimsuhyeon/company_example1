package demo.scheduler.dto.response;

import demo.scheduler.domain.constant.Color;
import demo.scheduler.domain.constant.RepeatUnit;
import demo.scheduler.dto.common.ScheduleWithAttachment;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Builder
class AttachInfo {
    private Long fileId;
    private String originName;
}


@Getter
@ToString
@Builder
public class ResponseScheduleWithAttachment {
    private Long id;
    private String title;
    private String content;
    private Color color;
    private RepeatUnit repeatUnit;
    private int alertTime;
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;

    private List<AttachInfo> attachInfo;


    public static ResponseScheduleWithAttachment from(List<ScheduleWithAttachment> entity) {
        return ResponseScheduleWithAttachment
                .builder()
                .id(entity.get(0).getId())
                .title(entity.get(0).getTitle())
                .content(entity.get(0).getContent())
                .color(entity.get(0).getColor())
                .repeatUnit(entity.get(0).getRepeatUnit())
                .alertTime(entity.get(0).getAlertTime())
                .startDateTime(entity.get(0).getStartDateTime())
                .endDateTime(entity.get(0).getEndDateTime())
                .attachInfo(entity.stream().map(item -> {
                    return AttachInfo
                            .builder()
                            .fileId(item.getFileId())
                            .originName(item.getOriginName())
                            .build();
                }).collect(Collectors.toList()))
                .build();
    }
}
