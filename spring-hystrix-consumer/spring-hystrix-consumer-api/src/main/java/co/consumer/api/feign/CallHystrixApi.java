package co.consumer.api.feign;

import co.consumer.api.constants.CoApiConstant;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = CoApiConstant.APPLICATION_NAME)
public interface CallHystrixApi {
    @GetMapping("hystrix/ok")
    String callOK();

    @GetMapping("hystrix/timeOut")
    String callTimeOut();

    @GetMapping("hystrix/error")
    String callError();
}