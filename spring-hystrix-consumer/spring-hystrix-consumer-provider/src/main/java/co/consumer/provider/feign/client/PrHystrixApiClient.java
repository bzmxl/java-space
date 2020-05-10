package co.consumer.provider.feign.client;

import co.consumer.provider.feign.fallback.PrHystrixApiFallback;
import org.springframework.cloud.openfeign.FeignClient;
import pr.provider.api.constants.PrApiConstant;
import pr.provider.api.feign.PrHystrixApi;

@FeignClient(contextId = "prHystrixApiClient", value = PrApiConstant.APPLICATION_NAME, fallback = PrHystrixApiFallback.class)
public interface PrHystrixApiClient extends PrHystrixApi {
}