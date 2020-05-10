package co.consumer.api.feign;

import co.consumer.api.constants.CoApiConstant;
import co.consumer.api.request.CoPersonReq;
import co.consumer.api.response.CoPersonRsp;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = CoApiConstant.APPLICATION_NAME)
public interface CoPersonApi {
    @PostMapping("co/insert")
    CoPersonRsp insert(@RequestBody CoPersonReq req);

    @GetMapping("co/callPr")
    String callPr();
}