package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        // 시작위치 지정(default = ComponentScan을 붙인 지점부터 하위목록까지) => 설정 정보 클래스를 최상위로
        basePackages =  "hello.core",
        // ComponentScan 에서 제외(기존 예제 코드를 남기고 유지하기 위해서)
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION,
                classes = Configuration.class)
)
public class AutoAppConfig {

}
