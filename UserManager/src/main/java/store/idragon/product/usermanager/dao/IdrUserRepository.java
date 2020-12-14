package store.idragon.product.usermanager.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import store.idragon.product.usermanager.dao.domain.IdrUser;

/**
 * @author xiaoshimei0305
 * date  2020/11/3 8:52 下午
 * description
 * @version 1.0
 */
public interface IdrUserRepository extends JpaRepository<IdrUser, String> {
}
