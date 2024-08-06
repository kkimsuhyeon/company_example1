package demo.scheduler.repository;

import demo.scheduler.domain.Schedule;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ScheduleMapper {

    public void insertSchedule(Schedule schedule);
}
