package com.tencent.mm.plugin.brandservice.ui.c;

import android.webkit.JavascriptInterface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0004\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0002\u0010\u0004J \u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0007J \u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0007J\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\bH\u0007J\b\u0010\u0011\u001a\u00020\bH\u0007J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\bH\u0007J\u0018\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0017H\u0007¨\u0006\u0018"}, hxF = {"Lcom/tencent/mm/plugin/brandservice/ui/webjsapi/BizCanvasAPI;", "Lcom/tencent/mm/plugin/webjsapi/JSAPI;", "Lcom/tencent/mm/plugin/brandservice/ui/webjsapi/BizCanvasAPIContext;", "context", "(Lcom/tencent/mm/plugin/brandservice/ui/webjsapi/BizCanvasAPIContext;)V", "adRequest", "", "message", "", "subType", "callback", "canvasRequest", "businessId", "", "reqJson", "deleteCanvasCard", "fieldId", "getData", "getInfo", "", "key", "onItemClick", "pos", "", "plugin-brandservice_release"})
public final class a extends com.tencent.mm.plugin.ab.a<b> {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(b bVar) {
        super("wxBizCanvas", bVar);
        p.h(bVar, "context");
        AppMethodBeat.i(196006);
        AppMethodBeat.o(196006);
    }

    @JavascriptInterface
    public final Object getInfo(String str) {
        AppMethodBeat.i(196000);
        p.h(str, "key");
        Object info = ((b) this.IBa).getInfo(str);
        AppMethodBeat.o(196000);
        return info;
    }

    @JavascriptInterface
    public final String getData() {
        AppMethodBeat.i(196001);
        String data = ((b) this.IBa).getData();
        AppMethodBeat.o(196001);
        return data;
    }

    @JavascriptInterface
    public final void deleteCanvasCard(String str) {
        AppMethodBeat.i(196002);
        p.h(str, "fieldId");
        ((b) this.IBa).deleteCanvasCard(str);
        AppMethodBeat.o(196002);
    }

    @JavascriptInterface
    public final void adRequest(String str, String str2, String str3) {
        AppMethodBeat.i(196003);
        p.h(str, "message");
        p.h(str2, "subType");
        p.h(str3, "callback");
        ((b) this.IBa).adRequest(str, str2, str3);
        AppMethodBeat.o(196003);
    }

    @JavascriptInterface
    public final void canvasRequest(Number number, String str, String str2) {
        AppMethodBeat.i(196004);
        p.h(number, "businessId");
        p.h(str, "reqJson");
        p.h(str2, "callback");
        ((b) this.IBa).canvasRequest(number, str, str2);
        AppMethodBeat.o(196004);
    }

    @JavascriptInterface
    public final void onItemClick(String str, int i2) {
        AppMethodBeat.i(196005);
        p.h(str, "fieldId");
        ((b) this.IBa).onItemClick(str, i2);
        AppMethodBeat.o(196005);
    }
}
