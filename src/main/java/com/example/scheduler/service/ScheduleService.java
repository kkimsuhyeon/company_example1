package com.example.scheduler.service;

import com.example.scheduler.dto.common.ScheduleDto;
import com.example.scheduler.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    @Autowired
    public ScheduleService(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    public void createSchedule(ScheduleDto dto) {
        scheduleRepository.insertSchedule(dto.toEntity());
    }
}
