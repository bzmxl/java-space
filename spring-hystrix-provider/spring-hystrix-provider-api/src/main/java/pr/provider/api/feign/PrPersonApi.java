package pr.provider.api.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import pr.provider.api.constants.PrApiConstant;
import pr.provider.api.request.PrPersonReq;
import pr.provider.api.response.PrPersonRsp;

@FeignClient(name = PrApiConstant.APPLICATION_NAME)
public interface PrPersonApi {
    @PostMapping("pr/insert")
    PrPersonRsp insert(@RequestBody PrPersonReq req);
}