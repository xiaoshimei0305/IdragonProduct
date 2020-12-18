package store.idragon.product.usermanager.constants;

import store.idragon.tool.base.dto.result.ICodeMessage;

/**
 * @author xiaoshimei0305
 * date  2020/12/17 7:08 下午
 * <p>外部帐号类型</p>
 * @version 1.0
 */
public enum ExternalAccountEnum implements ICodeMessage {
    /**
     * 用户手机号码
     */
    PHONE("phone","手机号码"),
    /**
     * 微信小程序帐号
     */
    WX_MINI("wx_mini","微信小程序");

    /**
     * 外部帐号编码
     */
    private String code;
    /**
     * 外部帐号说明
     */
    private String name;
    ExternalAccountEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }


    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return name;
    }
}
