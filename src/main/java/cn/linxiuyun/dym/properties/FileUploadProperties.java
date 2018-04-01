package cn.linxiuyun.dym.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:upload.properties")
public class FileUploadProperties {

    @Value("${path}")
    private String path;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return "FileUploadProperties{" +
                "path='" + path + '\'' +
                '}';
    }
}
