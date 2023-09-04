package hello.springmvc.basic;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


// @Controller는 반환값이 String 이면 뷰 이름으로 인식된다. 그래서 뷰를 찾고 뷰가 랜더링된다.
// @RestController는 반환값으로 뷰를 찾는것이 아니라 HTTP 메시지 바디에 바로 입력한다. 따라서 실행결과로 ok 메세지를 받을수 있다.
@RestController
@Slf4j
public class LogTestController {
    //private final Logger log = LoggerFactory.getLogger(getClass()); -> @Slf4j 써주면 생략가능

    @RequestMapping("/log-test")
    public String logTest() {
        String name = "Spring";


        // 이것을 쓰면 운영에서도 로그가 다 남음
        System.out.println("name = " +  name);

        // 로그를 사용하면 시간, 로그레벨, 프로세스 ID, 그리고 찍힌 클래스명 등 다채로운 정보들이 같이나와서 디버깅이 수월해짐
        // 로그레벨을 조절할수있는데 그건 application.properties에서 조정가능
        log.trace("info log={}", name);
        log.debug("info log={}", name);
        log.info("info log={}", name);
        log.warn("info log={}", name);
        log.error("info log={}", name);

        return "ok";
    }
}
