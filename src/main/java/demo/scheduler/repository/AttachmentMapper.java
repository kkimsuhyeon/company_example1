package demo.scheduler.repository;

import demo.scheduler.dto.common.Attachment;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface AttachmentMapper {

    public void insertAttachment(Attachment attachment);

    public Optional<Attachment> selectAttachmentById(Long fileId);

    public void deleteAttachmentById(Long fileId);

}
