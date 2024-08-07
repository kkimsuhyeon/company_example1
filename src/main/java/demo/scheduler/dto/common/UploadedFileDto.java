package demo.scheduler.dto.common;

import demo.scheduler.domain.UploadedFile;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class UploadedFileDto {

    private Long id;
    private String originName;
    private String storedName;
    private String path;
    private Long scheduleId;

    public UploadedFileDto(Builder builder) {
        this.id = builder.id;
        this.originName = builder.originName;
        this.storedName = builder.storedName;
        this.path = builder.path;
        this.scheduleId = builder.scheduleId;
    }

    public UploadedFile toEntity() {
        return UploadedFile
                .builder()
                .id(this.id)
                .originName(this.originName)
                .storedName(this.storedName)
                .path(this.path)
                .scheduleId(this.scheduleId)
                .build();
    }

    public static class Builder {

        private Long id;
        private String originName;
        private String storedName;
        private String path;
        private Long scheduleId;

        public Builder(String originName, String storedName, String path, Long scheduleId) {
            this.originName = originName;
            this.storedName = storedName;
            this.path = path;
            this.scheduleId = scheduleId;
        }

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public UploadedFileDto build() {
            return new UploadedFileDto(this);
        }
    }
}
