package com.tencent.mm.plugin.ab;

import android.webkit.JavascriptInterface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.kernel.a;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0007J\b\u0010\u0007\u001a\u00020\bH\u0007¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/webjsapi/WxPrefetcherClient;", "Lcom/tencent/mm/plugin/webjsapi/JSAPI;", "Lcom/tencent/mm/plugin/webjsapi/WxPrefetcherClientContext;", "context", "(Lcom/tencent/mm/plugin/webjsapi/WxPrefetcherClientContext;)V", "getId", "", "getUserHash", "", "webview-sdk_release"})
public final class p extends a<q> {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public p(q qVar) {
        super("wxPrefetcherClient", qVar);
        kotlin.g.b.p.h(qVar, "context");
        AppMethodBeat.i(224845);
        AppMethodBeat.o(224845);
    }

    @JavascriptInterface
    public final int getUserHash() {
        AppMethodBeat.i(224844);
        int abs = Math.abs((a.azs() + '-' + q.aoz()).hashCode() % 10000);
        AppMethodBeat.o(224844);
        return abs;
    }

    @JavascriptInterface
    public final String getId() {
        AppMethodBeat.i(224843);
        String id = ((q) this.IBa).getId();
        AppMethodBeat.o(224843);
        return id;
    }
}
