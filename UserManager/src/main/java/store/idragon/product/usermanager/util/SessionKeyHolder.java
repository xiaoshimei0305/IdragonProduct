package store.idragon.product.usermanager.util;

import org.springframework.stereotype.Component;
import store.idragon.tool.http.wechat.ISessionKeyHolder;

/**
 * @author xiaoshimei0305
 * date  2020/12/17 7:42 下午
 * description
 * @version 1.0
 */
@Component
public class SessionKeyHolder implements ISessionKeyHolder {
    /**
     * 存储本地sessionKey
     */
    private String sessionKey;

    @Override
    public String getSessionKey() {
        return this.sessionKey;
    }

    @Override
    public void storeSessionKey(String sessionKey) {
        this.sessionKey=sessionKey;
    }
}
