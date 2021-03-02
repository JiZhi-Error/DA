package com.tencent.mm.plugin.appbrand.jsapi.video.b.b;

import android.webkit.URLUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.a.b;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.a.c;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.c.e;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.c.n;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.e.d;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.e.g;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h;

public final class i implements com.tencent.mm.plugin.appbrand.jsapi.video.b.c.a {
    private com.tencent.mm.plugin.appbrand.jsapi.video.b.a.a mxs;
    private k myb;
    private j myc;
    private b myd;
    private n mye;
    private b myf;

    public i(com.tencent.mm.plugin.appbrand.jsapi.video.b.a.a aVar, e eVar, n nVar) {
        AppMethodBeat.i(234733);
        if (this.myf == null) {
            this.myf = new h((byte) 0);
        }
        this.myc = new n("com.tencent.mm.video", new g(), this.myf, eVar, new d(nVar.mzx, nVar.getLogTag()), nVar);
        this.myb = new k();
        this.mxs = aVar;
        if (aVar != null) {
            this.myd = new b(aVar, com.tencent.mm.plugin.appbrand.jsapi.video.b.a.bJK().mxm);
        }
        this.mye = nVar;
        AppMethodBeat.o(234733);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.b.c.a
    public final e dO(String str, String str2) {
        e eVar;
        AppMethodBeat.i(234734);
        this.myc.setLogTag(str2);
        if (this.myd != null) {
            this.myd.mxw = str2;
        }
        this.myb.setLogTag(str2);
        boolean z = !URLUtil.isNetworkUrl(str);
        boolean abq = h.abq(str);
        boolean abr = h.abr(str);
        if (abq) {
            eVar = new a(com.tencent.mm.plugin.appbrand.jsapi.video.b.a.bJK().appContext);
            eVar.setLogTag(str2);
            h.log(4, str2 + "DataSourceBuilder", "play asset file, dataSource:".concat(String.valueOf(eVar)));
        } else if (abr) {
            eVar = new o(com.tencent.mm.plugin.appbrand.jsapi.video.b.a.bJK().appContext);
            eVar.setLogTag(str2);
            h.log(4, str2 + "DataSourceBuilder", "play raw file, dataSource:".concat(String.valueOf(eVar)));
        } else if (z) {
            eVar = this.myb;
            h.log(4, str2 + "DataSourceBuilder", "play local file, dataSource:".concat(String.valueOf(eVar)));
        } else if (this.mxs == null || !com.tencent.mm.plugin.appbrand.jsapi.video.b.a.bJK().mxg) {
            eVar = this.myc;
            h.log(5, str2 + "DataSourceBuilder", "cache disabled, dataSource:".concat(String.valueOf(eVar)));
        } else {
            eVar = new c(this.mxs, this.myc, this.myb, this.mye.mzv ? this.myd : null, new a());
            eVar.setLogTag(str2);
            h.log(4, str2 + "DataSourceBuilder", "cache enabled, dataSource:".concat(String.valueOf(eVar)));
        }
        AppMethodBeat.o(234734);
        return eVar;
    }

    public class a implements c.a {
        public a() {
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.video.b.a.c.a
        public final void k(long j2, long j3) {
            AppMethodBeat.i(234730);
            h.log(3, "DataSourceBuilder", String.format("onCachedBytesRead, cacheSizeBytes:%s, cachedBytesRead:%s", Long.valueOf(j2), Long.valueOf(j3)));
            AppMethodBeat.o(234730);
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.video.b.a.c.a
        public final void b(String str, long j2, long j3, long j4) {
            AppMethodBeat.i(234731);
            h.log(3, "DataSourceBuilder", String.format("onHttpUpstreamServerCost, videoUuid:%s, httpDnsCost:%s, httpConnectCost:%s, httpFirstRecvCost:%s", str, Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4)));
            if (com.tencent.mm.plugin.appbrand.jsapi.video.b.a.bJK().mxp != null) {
                com.tencent.mm.plugin.appbrand.jsapi.video.b.a.bJK();
            }
            AppMethodBeat.o(234731);
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.video.b.a.c.a
        public final void a(String str, int i2, long j2, long j3, long j4) {
            AppMethodBeat.i(234732);
            h.log(3, "DataSourceBuilder", String.format("downloadSizeAndDuration, uuid:%s, totalUpstreamBytesRead:%s, totalUpstreamReadCost:%s, totalLength:%s, totalCachedBytesRead:%s", str, Integer.valueOf(i2), Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4)));
            if (com.tencent.mm.plugin.appbrand.jsapi.video.b.a.bJK().mxp != null) {
                com.tencent.mm.plugin.appbrand.jsapi.video.b.a.bJK();
            }
            AppMethodBeat.o(234732);
        }
    }
}
