package store.idragon.product.usermanager.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import store.idragon.product.usermanager.dao.domain.IdrUser;

import javax.transaction.Transactional;

/**
 * @author xiaoshimei0305
 * date  2020/11/3 8:52 下午
 * description
 * @version 1.0
 */
public interface IdrUserRepository extends JpaRepository<IdrUser, String> {
    /**
     * 查询唯一结果
     * @param value 值
     * @return 一条结果数据
     */
    @Query(value = "select * from idr_user where wx_mini =:value", nativeQuery = true)
    IdrUser queryOneByFieldValue(@Param("value") String value);

    /**
     * 外部帐号直接创建用户数据
     * @param userId 用户主键
     * @param value 值
     */
    @Modifying
    @Transactional
    @Query(value="insert into idr_user(user_id,wx_mini) values (:userId,:value)",nativeQuery = true)
    void createrUserByExctenalAccount(@Param("userId") String userId,@Param("value") String value);
}
