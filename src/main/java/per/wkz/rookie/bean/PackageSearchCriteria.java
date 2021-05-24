package per.wkz.rookie.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PackageSearchCriteria {

    private Integer packageId;

    private Integer userId;

    private Integer deliverId;

    private String senderPhone;

    private String senderIDCard;

    private String receiverPhone;

    private String receiverIDCard;

    private Boolean isHasDeliveryed;

}
