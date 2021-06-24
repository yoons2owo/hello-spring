package hello.hellospring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// @SpringBootApplication 내부의 @ComponentScan 애노테이션이 현재 패키지 하위의 @Component를 스캔해서 스프링 컨테이너의  스프링 빈으로 등록해준다.
@SpringBootApplication
public class HelloSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(HelloSpringApplication.class, args);
    }

}
