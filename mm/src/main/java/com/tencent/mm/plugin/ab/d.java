package com.tencent.mm.plugin.ab;

import android.webkit.JavascriptInterface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\b2\u0006\u0010\f\u001a\u00020\rH\u0007J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\bH\u0007J\u0010\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\bH\u0007¨\u0006\u0013"}, hxF = {"Lcom/tencent/mm/plugin/webjsapi/WxAdAPI;", "Lcom/tencent/mm/plugin/webjsapi/JSAPI;", "Lcom/tencent/mm/plugin/webjsapi/WxAdAPIContext;", "context", "(Lcom/tencent/mm/plugin/webjsapi/WxAdAPIContext;)V", "deleteAd", "", "msgId", "", "forceDelete", "", "getAdContext", "from", "", "getInfo", "", "key", "replaceAdData", "data", "webview-sdk_release"})
public final class d extends a<e> {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d(e eVar) {
        super("wxAd", eVar);
        p.h(eVar, "context");
        AppMethodBeat.i(224776);
        AppMethodBeat.o(224776);
    }

    @JavascriptInterface
    public final void replaceAdData(String str) {
        AppMethodBeat.i(224772);
        p.h(str, "data");
        ((e) this.IBa).replaceAdData(str);
        AppMethodBeat.o(224772);
    }

    @JavascriptInterface
    public final String getAdContext(int i2) {
        AppMethodBeat.i(224773);
        String adContext = ((e) this.IBa).getAdContext(i2);
        AppMethodBeat.o(224773);
        return adContext;
    }

    @JavascriptInterface
    public final void deleteAd(String str, boolean z) {
        AppMethodBeat.i(224774);
        p.h(str, "msgId");
        ((e) this.IBa).deleteAd(str, z);
        AppMethodBeat.o(224774);
    }

    @JavascriptInterface
    public final Object getInfo(String str) {
        AppMethodBeat.i(224775);
        p.h(str, "key");
        Object info = ((e) this.IBa).getInfo(str);
        AppMethodBeat.o(224775);
        return info;
    }
}
