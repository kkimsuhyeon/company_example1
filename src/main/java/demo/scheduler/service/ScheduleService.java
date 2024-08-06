package demo.scheduler.service;

import demo.scheduler.dto.common.ScheduleDto;
import demo.scheduler.repository.ScheduleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScheduleService {

    @Autowired
    ScheduleMapper scheduleMapper;

    public void createSchedule(ScheduleDto dto) {
        scheduleMapper.insertSchedule(dto.toEntity());
    }
}
