package com.example.scheduler.repository;

import com.example.scheduler.entity.Schedule;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ScheduleRepository {
    void insertSchedule(Schedule schedule);
}
