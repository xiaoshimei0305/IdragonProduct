package store.idragon.product.usermanager.dto.commond;

import lombok.Data;

/**
 * @author xiaoshimei0305
 * date  2020/12/21 7:37 下午
 * description
 * @version 1.0
 */
@Data
public class WxMiniUserInfo {
    /**
     * 用户信息
     */
    private String userId;
    /**
     * 加密内容
     */
    private String encryptedData;
    /**
     * 偏移量
     */
    private String iv;
}
