package per.wkz.rookie.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserSearchCriteria {

    private int id;

    private String name;//姓名

    private String account;//账号

    private String password;//密码

    private Integer type;//用户类型，0为寄件人，1为取件人

    private String IDCard;//身份证号

    private String phone;//手机号

    private String email;//邮箱






}
