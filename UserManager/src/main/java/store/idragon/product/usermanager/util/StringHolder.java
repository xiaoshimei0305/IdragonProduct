package store.idragon.product.usermanager.util;

import store.idragon.tool.base.inf.IKeyValueHolder;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xiaoshimei0305
 * date  2020/12/27 12:24 上午
 * description
 * @version 1.0
 */
public class StringHolder implements IKeyValueHolder<String> {
    /**
     * 数据存储本地缓存
     */
    private Map<String, String> cache=new HashMap<>();
    @Override
    public void store(String key, String value) {
        cache.put(key,value);
    }

    @Override
    public String get(String key) {
        return cache.get(key);
    }
}
