package demo.scheduler.repository;

import demo.scheduler.domain.Schedule;
import demo.scheduler.dto.common.ScheduleFilterDto;
import demo.scheduler.dto.schedule.ScheduleWithFile;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface ScheduleMapper {

    public List<Schedule> selectSchedules(ScheduleFilterDto dto);

    public Optional<ScheduleWithFile> selectScheduleById(Long id);

    public Long insertSchedule(Schedule schedule);

    public void updateSchedule(Schedule schedule);
}
