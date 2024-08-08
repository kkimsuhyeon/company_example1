package demo.scheduler.repository;

import demo.scheduler.domain.UploadedFile;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UploadedFileMapper {

    public void insertFile(UploadedFile uploadedFile);

    public UploadedFile selectFileById(Long fileId);
}
