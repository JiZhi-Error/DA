package com.tencent.mm.plugin.appbrand.shortlink;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.shortlink.cgi.WxaShortLinkInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.LruCache;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005H\u0016J\b\u0010\u000b\u001a\u00020\tH\u0016J\u0012\u0010\f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\n\u001a\u00020\u0005H\u0016J\u0018\u0010\r\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0006H\u0016R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000¨\u0006\u000f"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/shortlink/ShortLinkInfoCache;", "Lcom/tencent/mm/plugin/appbrand/shortlink/IShortLinkInfoCache;", "()V", "CACHE", "Lcom/tencent/mm/sdk/platformtools/LruCache;", "", "Lcom/tencent/mm/plugin/appbrand/shortlink/cgi/WxaShortLinkInfo;", "TAG", "clear", "", "shortLink", "clearAll", "get", "store", "info", "plugin-appbrand-integration_release"})
public final class b implements a {
    private static final LruCache<String, WxaShortLinkInfo> nNM = new LruCache<>(128);
    public static final b nNN = new b();

    static {
        AppMethodBeat.i(229344);
        AppMethodBeat.o(229344);
    }

    private b() {
    }

    @Override // com.tencent.mm.plugin.appbrand.shortlink.a
    public final void a(String str, WxaShortLinkInfo wxaShortLinkInfo) {
        AppMethodBeat.i(229341);
        p.h(str, "shortLink");
        p.h(wxaShortLinkInfo, "info");
        nNM.put(str, wxaShortLinkInfo);
        AppMethodBeat.o(229341);
    }

    @Override // com.tencent.mm.plugin.appbrand.shortlink.a
    public final WxaShortLinkInfo aeX(String str) {
        AppMethodBeat.i(229342);
        p.h(str, "shortLink");
        WxaShortLinkInfo wxaShortLinkInfo = nNM.get(str);
        AppMethodBeat.o(229342);
        return wxaShortLinkInfo;
    }

    public static void clearAll() {
        AppMethodBeat.i(229343);
        Log.i("MicroMsg.ShortLinkInfoCache", "clearAll");
        nNM.evictAll();
        AppMethodBeat.o(229343);
    }
}
