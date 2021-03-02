package com.tencent.mm.plugin.ab;

import android.webkit.JavascriptInterface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/webjsapi/WxVideoPrefetcherAPI;", "Lcom/tencent/mm/plugin/webjsapi/JSAPI;", "Lcom/tencent/mm/plugin/webjsapi/WxVideoPrefetcherAPIContext;", "context", "(Lcom/tencent/mm/plugin/webjsapi/WxVideoPrefetcherAPIContext;)V", "cacheVideo", "", "data", "", "webview-sdk_release"})
public final class r extends a<s> {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public r(s sVar) {
        super("wxVideoPrefetcher", sVar);
        p.h(sVar, "context");
        AppMethodBeat.i(224847);
        AppMethodBeat.o(224847);
    }

    @JavascriptInterface
    public final void cacheVideo(String str) {
        AppMethodBeat.i(224846);
        p.h(str, "data");
        ((s) this.IBa).cacheVideo(str);
        AppMethodBeat.o(224846);
    }
}
