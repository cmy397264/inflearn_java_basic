package hello.core.web;

import hello.core.common.MyLogger;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class LogDemoController {

    // Spring 실행 시 의존성 주입이 시작되어
    // 아래의 final 변수에 대해 의존성 주입이 시작되는데
    // 이때 MyLogger의 생명주기는 Request이기 때문에
    // Request 범위 안에서 생존하는데 실행 초기 Request는 요청되지 않았기 때문에 오류가 발생함.
    private final LogDemoService logDemoService;
    private final MyLogger myLogger;

    //화면없이 글자로 응답을 반환 => ResponseBody
    @RequestMapping("log-demo")
    @ResponseBody
    public String logDemo(HttpServletRequest request) {
        String requestURL = request.getRequestURI();

        myLogger.setRequestURL(requestURL);
        myLogger.log("controller test");

        logDemoService.logic("testId");
        return "OK";
    }
}
