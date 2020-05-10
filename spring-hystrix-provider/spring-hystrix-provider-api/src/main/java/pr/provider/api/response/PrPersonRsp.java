package pr.provider.api.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class PrPersonRsp {
    @ApiModelProperty("名字")
    private String name;
    @ApiModelProperty("年龄")
    private Integer age;
    @ApiModelProperty("地址")
    private String address;
    @ApiModelProperty("电话")
    private String phone;
}