package demo.scheduler.service;

import demo.scheduler.dto.common.Schedule;
import demo.scheduler.dto.common.ScheduleFilter;
import demo.scheduler.dto.request.RequestCreateSchedule;
import demo.scheduler.dto.request.RequestModifySchedule;
import demo.scheduler.dto.request.RequestUploadAttachment;
import demo.scheduler.dto.response.ResponseScheduleItem;
import demo.scheduler.dto.response.ResponseScheduleWithAttachment;
import demo.scheduler.repository.ScheduleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ScheduleService {

    ScheduleMapper scheduleMapper;
    AttachmentService attachmentService;

    @Autowired
    public ScheduleService(ScheduleMapper scheduleMapper, AttachmentService attachmentService) {
        this.scheduleMapper = scheduleMapper;
        this.attachmentService = attachmentService;
    }

    public List<ResponseScheduleItem> getSchedules(Integer month, Integer weekly) {

        ScheduleFilter filterDto = new ScheduleFilter(month, weekly);
        List<Schedule> result = scheduleMapper.selectSchedules(filterDto);

        return result.stream()
                .map(ResponseScheduleItem::from)
                .collect(Collectors.toList());
    }

    public ResponseScheduleWithAttachment getScheduleById(Long id) {
        return ResponseScheduleWithAttachment.from(scheduleMapper.selectScheduleById(id));
    }

    public void createSchedule(RequestCreateSchedule requestCreateSchedule, RequestUploadAttachment requestUploadFile) {
        Schedule dto = requestCreateSchedule.toDto();
        scheduleMapper.insertSchedule(dto);

        if (requestUploadFile.getFiles() != null && !requestUploadFile.getFiles().isEmpty()) {
            attachmentService.uploadAttachment(requestUploadFile, dto.getId());
        }
    }

    public void modifySchedule(Long id, RequestModifySchedule requestModifySchedule, RequestUploadAttachment requestUploadFile) {
        if (!scheduleMapper.selectScheduleById(id).isEmpty()) {
            Schedule dto = requestModifySchedule.toDto(id);
            scheduleMapper.updateSchedule(dto);

            if (requestUploadFile.getFiles() != null && !requestUploadFile.getFiles().isEmpty()) {
                attachmentService.uploadAttachment(requestUploadFile, dto.getId());
            }
        } else {
            throw new IllegalArgumentException("??");
        }
    }
}
