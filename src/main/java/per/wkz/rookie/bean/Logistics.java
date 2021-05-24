package per.wkz.rookie.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Logistics {

    private int id;

    private String message;//物流信息

    private Date createDate;//物流信息发送时间

    private Date updateDate;//更新时间

    private Package aPackage;//包裹


    private Integer packageId;

    private Boolean isViewed;//是否查看

}
