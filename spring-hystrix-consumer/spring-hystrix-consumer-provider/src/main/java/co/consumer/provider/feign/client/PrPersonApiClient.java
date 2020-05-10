package co.consumer.provider.feign.client;

import org.springframework.cloud.openfeign.FeignClient;
import pr.provider.api.constants.PrApiConstant;
import pr.provider.api.feign.PrPersonApi;

@FeignClient(name = PrApiConstant.APPLICATION_NAME)
public interface PrPersonApiClient extends PrPersonApi {
}