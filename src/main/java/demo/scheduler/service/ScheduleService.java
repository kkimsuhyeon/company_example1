package demo.scheduler.service;

import demo.scheduler.domain.Schedule;
import demo.scheduler.dto.common.ScheduleDto;
import demo.scheduler.dto.common.ScheduleFilterDto;
import demo.scheduler.dto.schedule.ScheduleWithFile;
import demo.scheduler.repository.ScheduleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ScheduleService {

    ScheduleMapper scheduleMapper;
    UploadedFileService uploadedFileService;

    @Autowired
    public ScheduleService(ScheduleMapper scheduleMapper, UploadedFileService uploadedFileService) {
        this.scheduleMapper = scheduleMapper;
        this.uploadedFileService = uploadedFileService;
    }

    public List<ScheduleDto> getSchedules(Integer month, Integer weekly) {

        ScheduleFilterDto filterDto = new ScheduleFilterDto(month, weekly);

        List<Schedule> result = scheduleMapper.selectSchedules(filterDto);

        return result
                .stream()
                .map(ScheduleDto::fromEntity)
                .collect(Collectors.toList());
    }

    public ScheduleWithFile getScheduleById(Long id) {
        return scheduleMapper.selectScheduleById(id)
                .orElseThrow(() -> new IllegalArgumentException("에러 발생"));
    }

    public ScheduleDto createSchedule(ScheduleDto dto) {

        Schedule entity = dto.toEntity();
        scheduleMapper.insertSchedule(entity);

        if (dto.getFiles() != null) {
            uploadedFileService.uploadFiles(dto.getFiles(), entity.getId());
        }
        return dto;
    }

    public ScheduleDto modifySchedule(Long id, ScheduleDto dto) {
        if (scheduleMapper.selectScheduleById(id).isPresent()) {
            scheduleMapper.updateSchedule(dto.toEntity());
        } else {
            throw new IllegalArgumentException("??");
        }

        return dto;
    }
}
