package hello.springmvc.basic.response;


import hello.springmvc.basic.HelloData;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.IOException;


// controller대신 RestController를 사용하면 ResponseBody가 적용되는 효과가 있다.
@Slf4j
@Controller
public class ResponseBodyController {

    @GetMapping("/response-body-string-v1")
    public void responseBodyV1(HttpServletResponse response) throws IOException {
        // HttpServletResponse 객체를 통해서 HTTP 메세지에 직접 "ok" 응답 메시지를 전달함
        response.getWriter().write("ok");
    }

    @GetMapping("/response-body-string-v2")
    public ResponseEntity<String> responseBodyV2() throws IOException {
        // ResponseEntity 엔티티는 HttpEntity를 상속받았는데, HttpEntity는 HTTP 메시지의 헤더, 바디 정보를 가지고있음. 그리고 HTTP 응답코드도 설정가능
        return new ResponseEntity<>("ok", HttpStatus.OK);
    }

    @ResponseBody
    @GetMapping("/response-body-string-v3")
    public String responseBodyV3() throws IOException {
        // @ResponseBody를 사용하면 view를 사용하지 않고, HTTP 메시지 컨버터를 통해서 HTTP 메시지를 직접 입력할수있음. ResponseEntity도 동일한 방식으로 동작
        return "ok";
    }
    @GetMapping("/response-body-json-v1")
    public ResponseEntity<HelloData> responseBodyJsonV1() {
        HelloData helloData= new HelloData();
        helloData.setUsername("userA");
        helloData.setAge(21);
        return new ResponseEntity<>(helloData, HttpStatus.OK);
    }

    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @GetMapping("/response-body-json-v2")
    public HelloData responseBodyJsonV2() {
        // 응답코드를 동적으로 변경할수 없기때문에 그때는 jsonV1형식으로 하면된다.
        HelloData helloData= new HelloData();
        helloData.setUsername("userA");
        helloData.setAge(21);
        return helloData;
    }
}
