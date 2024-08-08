package demo.scheduler.repository;

import demo.scheduler.dto.common.Attachment;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AttachmentMapper {

    public void insertAttachment(Attachment attachment);

    public Attachment selectAttachmentById(Long fileId);
}
