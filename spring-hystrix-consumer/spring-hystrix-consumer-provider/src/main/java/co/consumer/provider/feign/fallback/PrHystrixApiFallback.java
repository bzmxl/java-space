package co.consumer.provider.feign.fallback;

import co.consumer.provider.feign.client.PrHystrixApiClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class PrHystrixApiFallback implements PrHystrixApiClient {
    @Override
    public String ok() {
        log.info("======Fallback ok========");
        return "Fallback 0k";
    }

    @Override
    public String timeOut() {
        log.info("======Fallback timeOut========");
        return "Fallback timeOut";
    }

    @Override
    public String error() {
        log.info("======Fallback error========");
        return "Fallback error";
    }
}