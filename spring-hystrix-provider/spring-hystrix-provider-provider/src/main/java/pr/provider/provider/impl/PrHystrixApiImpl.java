package pr.provider.provider.impl;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pr.provider.api.feign.PrHystrixApi;

@Slf4j
@RestController
@Api(tags = "Hystrix模块")
@RequestMapping("/hystrix")
public class PrHystrixApiImpl implements PrHystrixApi {
    @Override
    @GetMapping("/ok")
    public String ok() {
        return "ok";
    }

    @Override
    @GetMapping("/timeOut")
    public String timeOut() {
        try {
            Thread.sleep(5000);
        } catch (Exception e) {
        }
        return "timeOut";
    }

    @Override
    @GetMapping("/error")
    public String error() {
        int a = 3 / 0;
        return "error" + a;
    }
}