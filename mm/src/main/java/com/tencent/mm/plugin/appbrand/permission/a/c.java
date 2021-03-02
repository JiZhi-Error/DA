package com.tencent.mm.plugin.appbrand.permission.a;

import com.google.android.gms.dynamite.ProviderConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.d;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\u0018\u00002\u00020\u0001B-\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\b\u0010\u0011\u001a\u00020\u0005H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0012"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/permission/jsauth/JsAuthExecuteContext;", "", "env", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", ProviderConstants.API_PATH, "", "args", "callbackId", "", "(Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;Ljava/lang/String;Ljava/lang/String;I)V", "getApi", "()Ljava/lang/String;", "getArgs", "getCallbackId", "()I", "getEnv", "()Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "toString", "luggage-wechat-full-sdk_release"})
public final class c {
    private final int lqe;
    private final String nbc;
    final d nyB;
    final String nyC;

    public c(d dVar, String str, byte b2) {
        this(dVar, str);
    }

    public c(d dVar, String str, String str2, int i2) {
        p.h(dVar, "env");
        p.h(str, ProviderConstants.API_PATH);
        AppMethodBeat.i(230131);
        this.nyB = dVar;
        this.nyC = str;
        this.nbc = str2;
        this.lqe = i2;
        AppMethodBeat.o(230131);
    }

    private /* synthetic */ c(d dVar, String str) {
        this(dVar, str, null, 0);
    }

    public final String toString() {
        AppMethodBeat.i(230130);
        String str = "JsAuthExecuteContext(appId='" + this.nyB.getAppId() + "', api='" + this.nyC + "', callbackId=" + this.lqe + ')';
        AppMethodBeat.o(230130);
        return str;
    }
}
