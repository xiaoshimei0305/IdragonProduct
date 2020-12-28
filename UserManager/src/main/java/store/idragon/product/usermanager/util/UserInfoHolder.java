package store.idragon.product.usermanager.util;

import store.idragon.product.usermanager.dto.info.UserInfo;
import store.idragon.tool.base.inf.IKeyValueHolder;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xiaoshimei0305
 * date  2020/12/27 12:22 上午
 * description
 * @version 1.0
 */
public class UserInfoHolder  implements IKeyValueHolder<UserInfo> {
    /**
     * 数据存储本地缓存
     */
    private Map<String,UserInfo> cache=new HashMap<>();

    @Override
    public void store(String key, UserInfo value) {
        cache.put(key,value);
    }

    @Override
    public UserInfo get(String key) {
        return cache.get(key);
    }
}
