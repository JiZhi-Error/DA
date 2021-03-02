package com.tencent.mm.plugin.eggspring;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0000\u0018\u00002\u00060\u0001j\u0002`\u0002B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\n¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/eggspring/CgiException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "errorType", "", OpenSDKTool4Assistant.EXTRA_ERROR_CODE, "message", "", "(IILjava/lang/String;)V", "getErrorCode", "()I", "getErrorType", "plugin-eggspring_release"})
public final class a extends Exception {
    private final int dGe;
    public final int errorCode;

    public a(int i2, int i3, String str) {
        super("Cgi exception: errorType=" + i2 + ", errorCode=" + i3 + ", message=" + str);
        AppMethodBeat.i(194551);
        this.dGe = i2;
        this.errorCode = i3;
        AppMethodBeat.o(194551);
    }
}
