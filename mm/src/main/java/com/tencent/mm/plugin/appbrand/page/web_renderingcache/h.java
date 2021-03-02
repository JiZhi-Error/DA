package com.tencent.mm.plugin.appbrand.page.web_renderingcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.vfs.s;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\b\u0010\u0006\u001a\u00020\u0004H\u0007¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/page/web_renderingcache/WebRenderingCacheUtils;", "", "()V", "generateDirectoryPrefix", "", "appId", "generateRootDirectoryPrefix", "plugin-appbrand-integration_release"})
public final class h {
    public static final h nwx = new h();

    static {
        AppMethodBeat.i(50996);
        AppMethodBeat.o(50996);
    }

    private h() {
    }

    public static final String aeh(String str) {
        AppMethodBeat.i(50994);
        p.h(str, "appId");
        String str2 = bSI() + '/' + str;
        s.boN(str2);
        AppMethodBeat.o(50994);
        return str2;
    }

    public static final String bSI() {
        AppMethodBeat.i(50995);
        e aAh = g.aAh();
        p.g(aAh, "MMKernel.storage()");
        String azM = aAh.azM();
        p.g(azM, "path");
        if (!n.a((CharSequence) azM, '/')) {
            azM = azM + '/';
        }
        String str = azM + "appbrand/web_renderingcache";
        p.g(str, "path");
        AppMethodBeat.o(50995);
        return str;
    }
}
