package com.tencent.mm.plugin.appbrand.shortlink;

import android.support.annotation.Keep;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import kotlin.l;

@Keep
@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/shortlink/WxaShortLinkLaunchErrorCode;", "", TMQQDownloaderOpenSDKConst.UINTYPE_CODE, "", OpenSDKTool4Assistant.EXTRA_ERROR_MSG, "", "(Ljava/lang/String;IILjava/lang/String;)V", "getCode", "()I", "getErrorMsg", "()Ljava/lang/String;", "SUCCESS", "ILLEGAL_LINK", "DECODE_LINK_FAIL", "USER_CANCEL", "CONTEXT_RELEASE", "INTERRUPT", "LAUNCH_PHASE_FAIL", "luggage-wechat-full-sdk_release"})
public enum WxaShortLinkLaunchErrorCode {
    SUCCESS(0, "OK"),
    ILLEGAL_LINK(-1001, "illegal link"),
    DECODE_LINK_FAIL(-1002, "decode link fail"),
    USER_CANCEL(-1003, "user cancel"),
    CONTEXT_RELEASE(-1004, "context release"),
    INTERRUPT(-1005, "interrupt"),
    LAUNCH_PHASE_FAIL(-1006, "launch phase fail");
    
    private final int code;
    private final String errorMsg;

    public static WxaShortLinkLaunchErrorCode valueOf(String str) {
        AppMethodBeat.i(230176);
        WxaShortLinkLaunchErrorCode wxaShortLinkLaunchErrorCode = (WxaShortLinkLaunchErrorCode) Enum.valueOf(WxaShortLinkLaunchErrorCode.class, str);
        AppMethodBeat.o(230176);
        return wxaShortLinkLaunchErrorCode;
    }

    private WxaShortLinkLaunchErrorCode(int i2, String str) {
        this.code = i2;
        this.errorMsg = str;
    }

    public final int getCode() {
        return this.code;
    }

    public final String getErrorMsg() {
        return this.errorMsg;
    }

    static {
        AppMethodBeat.i(230174);
        AppMethodBeat.o(230174);
    }
}
