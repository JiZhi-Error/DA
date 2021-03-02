package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.luggage.sdk.b.a.c.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandOnCopyUrlEvent;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandJsApiEvent;", "isCopyShortLink", "", "(Z)V", "dispatchEvent", "", "webviewId", "", "service", "Lcom/tencent/luggage/sdk/jsapi/component/service/AppBrandServiceLU;", "Companion", "luggage-wechat-full-sdk_release"})
public final class u extends s {
    public static final int CTRL_INDEX = 754;
    public static final String NAME = "onCopyUrl";
    public static final a lya = new a((byte) 0);
    private final boolean lxZ;

    static {
        AppMethodBeat.i(169553);
        AppMethodBeat.o(169553);
    }

    public u(byte b2) {
        this();
    }

    private /* synthetic */ u() {
        this(false);
    }

    public u(boolean z) {
        this.lxZ = z;
    }

    public final void a(int i2, d dVar) {
        AppMethodBeat.i(230057);
        p.h(dVar, "service");
        HashMap hashMap = new HashMap();
        hashMap.put("webviewId", Integer.valueOf(i2));
        hashMap.put("shortLinkEnable", Boolean.valueOf(this.lxZ));
        g(dVar).L(hashMap).bEo();
        AppMethodBeat.o(230057);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandOnCopyUrlEvent$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "SHORT_LINK_ENABLE", "WEBVIEW_ID", "luggage-wechat-full-sdk_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }
}
