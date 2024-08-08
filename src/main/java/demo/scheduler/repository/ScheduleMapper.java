package demo.scheduler.repository;

import demo.scheduler.dto.common.Schedule;
import demo.scheduler.dto.common.ScheduleFilter;
import demo.scheduler.dto.common.ScheduleWithAttachment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ScheduleMapper {

    public List<Schedule> selectSchedules(ScheduleFilter dto);

    public List<ScheduleWithAttachment> selectScheduleById(Long id);

    public void insertSchedule(Schedule schedule);

    public void updateSchedule(Schedule schedule);
}
