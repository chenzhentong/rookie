package per.wkz.rookie.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Province {

    private int id;

    private String name;//名称

    private Double firstWeight = 1.0;//省内首重重量

    private Double firstWeightFee = 8.0;//省内首重费用

    private Double additionalWeightFee = 2.0;//省内续重费用

    private Double firstWeight2 = 1.0;//省外首重重量

    private Double firstWeightFee2 = 10.0;//省外首重费用

    private Double additionalWeightFee2 = 3.0;//省外续重费用

    public Province(int id, String name){
       this.id = id;
       this.name = name;
    }

}
