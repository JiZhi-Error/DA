package com.tencent.mm.plugin.wallet.wecoin.model;

import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\r"}, hxF = {"Lcom/tencent/mm/plugin/wallet/wecoin/model/CgiRespInfo;", "", "errorType", "", OpenSDKTool4Assistant.EXTRA_ERROR_CODE, OpenSDKTool4Assistant.EXTRA_ERROR_MSG, "", "(IILjava/lang/String;)V", "getErrorCode", "()I", "getErrorMsg", "()Ljava/lang/String;", "getErrorType", "plugin-wxpay_release"})
public final class a {
    public final int dGe;
    public final int errorCode;
    public final String errorMsg;

    public a(int i2, int i3, String str) {
        this.dGe = i2;
        this.errorCode = i3;
        this.errorMsg = str;
    }
}
