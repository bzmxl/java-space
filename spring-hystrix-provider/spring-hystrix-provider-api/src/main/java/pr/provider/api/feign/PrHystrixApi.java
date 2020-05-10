package pr.provider.api.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import pr.provider.api.constants.PrApiConstant;

@FeignClient(name = PrApiConstant.APPLICATION_NAME)
public interface PrHystrixApi {
    @GetMapping("hystrix/ok")
    String ok();

    @GetMapping("hystrix/timeOut")
    String timeOut();

    @GetMapping("hystrix/error")
    String error();
}