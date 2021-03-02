package com.tencent.mm.plugin.ab;

import android.webkit.JavascriptInterface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0002\u0010\u0004J\u001c\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\bH\u0007¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/webjsapi/WxMessageAPI;", "Lcom/tencent/mm/plugin/webjsapi/JSAPI;", "Lcom/tencent/mm/plugin/webjsapi/WxMessageAPIContext;", "context", "(Lcom/tencent/mm/plugin/webjsapi/WxMessageAPIContext;)V", "postMessage", "", "message", "", "targetOrigin", "webview-sdk_release"})
public final class l extends a<m> {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public l(m mVar) {
        super("wxMessage", mVar);
        p.h(mVar, "context");
        AppMethodBeat.i(224837);
        AppMethodBeat.o(224837);
    }

    @JavascriptInterface
    public final void postMessage(String str, String str2) {
        AppMethodBeat.i(224836);
        p.h(str, "message");
        p.h(str2, "targetOrigin");
        ((m) this.IBa).postMessage(str, str2);
        AppMethodBeat.o(224836);
    }
}
