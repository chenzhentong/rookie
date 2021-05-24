package per.wkz.rookie.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LogisticsSearchCriteria {

    private Integer packageId;

    private Integer senderId;

    private Integer receiverId;

    private String message;

    private Integer packageState;

//    private Integer userId;
}
