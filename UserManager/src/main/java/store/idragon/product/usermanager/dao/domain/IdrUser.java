package store.idragon.product.usermanager.dao.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author xiaoshimei0305
 * date  2020/11/3 8:47 下午
 * description
 * @version 1.0
 */
@Entity
@Table(name = "idr_user")
@Data
public class IdrUser implements Serializable {
    /**
     * 用户主键
     */
    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private String userId;
    /**
     * 用户名称
     */
    @Column(name = "user_name")
    private String userName;
    /**
     * 用户密码
     */
    @Column(name = "password")
    private String passWord;
    /**
     * 用户手机号码
     */
    @Column(name = "phone")
    private String phone;
    /**
     * 用户微信帐号
     */
    @Column(name = "wx_mini")
    private String wxMini;
}
