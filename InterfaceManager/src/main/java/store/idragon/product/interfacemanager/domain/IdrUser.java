package store.idragon.product.interfacemanager.domain;

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
    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private String userId;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "password")
    private String passWord;
}
