package co.consumer.api.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class CoPersonReq {
    @ApiModelProperty("名字")
    @NotBlank
    private String name;

    @ApiModelProperty("年龄")
    @NotNull
    private Integer age;
}