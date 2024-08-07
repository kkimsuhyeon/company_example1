package demo.scheduler.service;

import demo.scheduler.domain.Schedule;
import demo.scheduler.dto.common.ScheduleDto;
import demo.scheduler.dto.common.ScheduleFilterDto;
import demo.scheduler.repository.ScheduleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ScheduleService {

    ScheduleMapper scheduleMapper;

    @Autowired
    public ScheduleService(ScheduleMapper scheduleMapper) {
        this.scheduleMapper = scheduleMapper;
    }

    public List<ScheduleDto> getSchedules(Integer month, Integer weekly) {

        ScheduleFilterDto filterDto = new ScheduleFilterDto(month, weekly);

        List<Schedule> result = scheduleMapper.selectSchedules(filterDto);

        return result
                .stream()
                .map(ScheduleDto::fromEntity)
                .collect(Collectors.toList());
    }

    public ScheduleDto getScheduleById(Long id) {
        return scheduleMapper.selectScheduleById(id)
                .map(ScheduleDto::fromEntity)
                .orElseThrow(() -> new IllegalArgumentException("에러 발생"));
    }

    public ScheduleDto createSchedule(ScheduleDto dto) {
        Schedule schedule = scheduleMapper.insertSchedule(dto.toEntity());
        System.out.println(schedule);
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
