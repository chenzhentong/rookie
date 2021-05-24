package per.wkz.rookie.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Goods {


    private int id;

    private String name;//名称

    //private int stock;//库存

   // private User seller;//商家

    private double weight;//重量

    //private boolean personal;

    private Date createDate;

    private Date updateDate;

   /// private Integer userId;

}
