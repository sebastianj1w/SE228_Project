package ebookBackend;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(value = "ebookBackend.dao")
public class RESTfulServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(RESTfulServiceApplication.class, args);
    }

}
