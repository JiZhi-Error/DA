package com.tencent.mm.plugin.appbrand.report;

import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.nc;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001d2\u00020\u00012\u00020\u0002:\u0001\u001dB\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J(\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\u0010\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020\u0005H\u0016J\u0010\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u0005H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\b\"\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/report/AppBrandVideoCastReportHelper;", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/IVideoCastReportHelper;", "Lcom/tencent/luggage/base/ICustomize;", "()V", "appId", "", "isInFullScreen", "", "()Z", "setInFullScreen", "(Z)V", "pagePath", "videoPath", "baseStruct", "Lcom/tencent/mm/autogen/mmdata/rpt/WeAppVideoCastStruct;", "caseId", "", "doReport", "", "isConnectSuccess", "deviceName", "manufactureName", "deviceCount", "getFullscreenStatusListener", "Lcom/tencent/mm/plugin/appbrand/platform/window/FullscreenStatusListener;", "setAppId", "setPagePath", "setVideoPath", "path", "Companion", "plugin-appbrand-integration_release"})
public final class n implements com.tencent.luggage.a.b, com.tencent.mm.plugin.appbrand.jsapi.ag.e.a.c {
    public static final a nHx = new a((byte) 0);
    private String appId = "";
    private String dCx = "";
    boolean kGg;
    private String videoPath = "";

    static {
        AppMethodBeat.i(51023);
        AppMethodBeat.o(51023);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/report/AppBrandVideoCastReportHelper$Companion;", "", "()V", "TAG", "", "plugin-appbrand-integration_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.ag.e.a.c
    public final void setVideoPath(String str) {
        AppMethodBeat.i(51016);
        p.h(str, "path");
        this.videoPath = str;
        AppMethodBeat.o(51016);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.ag.e.a.c
    public final void abO(String str) {
        AppMethodBeat.i(51017);
        p.h(str, "pagePath");
        this.dCx = str;
        AppMethodBeat.o(51017);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.ag.e.a.c
    public final void setAppId(String str) {
        AppMethodBeat.i(51018);
        p.h(str, "appId");
        this.appId = str;
        AppMethodBeat.o(51018);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0005"}, hxF = {"com/tencent/mm/plugin/appbrand/report/AppBrandVideoCastReportHelper$getFullscreenStatusListener$1", "Lcom/tencent/mm/plugin/appbrand/platform/window/FullscreenStatusListener;", "onEnterFullscreen", "", "onExitFullscreen", "plugin-appbrand-integration_release"})
    public static final class e extends com.tencent.mm.plugin.appbrand.platform.window.b {
        final /* synthetic */ n nHy;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        e(n nVar) {
            this.nHy = nVar;
        }

        @Override // com.tencent.mm.plugin.appbrand.platform.window.b
        public final void bDq() {
            this.nHy.kGg = true;
        }

        @Override // com.tencent.mm.plugin.appbrand.platform.window.b
        public final void Na() {
            this.nHy.kGg = false;
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.ag.e.a.c
    public final com.tencent.mm.plugin.appbrand.platform.window.b bMn() {
        AppMethodBeat.i(175211);
        e eVar = new e(this);
        AppMethodBeat.o(175211);
        return eVar;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.ag.e.a.c
    public final void xV(int i2) {
        AppMethodBeat.i(51020);
        h.RTc.aX(new b(this, i2));
        AppMethodBeat.o(51020);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class b implements Runnable {
        final /* synthetic */ n nHy;
        final /* synthetic */ int nHz;

        b(n nVar, int i2) {
            this.nHy = nVar;
            this.nHz = i2;
        }

        public final void run() {
            AppMethodBeat.i(51013);
            try {
                n.a(this.nHy, this.nHz).bfK();
                AppMethodBeat.o(51013);
            } catch (Exception e2) {
                Log.d("AppBrandVideoCastReportHelperWC", "catch: " + e2.getMessage());
                AppMethodBeat.o(51013);
            }
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.ag.e.a.c
    public final void er(int i2, int i3) {
        AppMethodBeat.i(51021);
        h.RTc.aX(new c(this, i3, i2));
        AppMethodBeat.o(51021);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class c implements Runnable {
        final /* synthetic */ int nHA;
        final /* synthetic */ n nHy;
        final /* synthetic */ int nHz;

        c(n nVar, int i2, int i3) {
            this.nHy = nVar;
            this.nHz = i2;
            this.nHA = i3;
        }

        public final void run() {
            AppMethodBeat.i(51014);
            try {
                nc a2 = n.a(this.nHy, this.nHz);
                a2.xB((long) this.nHA);
                a2.bfK();
                AppMethodBeat.o(51014);
            } catch (Exception e2) {
                Log.d("AppBrandVideoCastReportHelperWC", "catch: " + e2.getMessage());
                AppMethodBeat.o(51014);
            }
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.ag.e.a.c
    public final void a(boolean z, String str, String str2, int i2) {
        AppMethodBeat.i(51022);
        p.h(str, "deviceName");
        p.h(str2, "manufactureName");
        h.RTc.aX(new d(this, i2, z, str, str2));
        AppMethodBeat.o(51022);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class d implements Runnable {
        final /* synthetic */ String lLO;
        final /* synthetic */ boolean nHB;
        final /* synthetic */ String nHC;
        final /* synthetic */ n nHy;
        final /* synthetic */ int nHz;

        d(n nVar, int i2, boolean z, String str, String str2) {
            this.nHy = nVar;
            this.nHz = i2;
            this.nHB = z;
            this.lLO = str;
            this.nHC = str2;
        }

        public final void run() {
            AppMethodBeat.i(51015);
            try {
                nc a2 = n.a(this.nHy, this.nHz);
                a2.xC(this.nHB ? 1 : 0);
                a2.Ao(this.lLO);
                a2.Ap(this.nHC);
                a2.bfK();
                AppMethodBeat.o(51015);
            } catch (Exception e2) {
                Log.d("AppBrandVideoCastReportHelperWC", "catch: " + e2.getMessage());
                AppMethodBeat.o(51015);
            }
        }
    }

    public static final /* synthetic */ nc a(n nVar, int i2) {
        long j2;
        AppMethodBeat.i(51024);
        nc ncVar = new nc();
        ncVar.Al(nVar.appId);
        WxaAttributes e2 = com.tencent.mm.plugin.appbrand.app.n.buC().e(ncVar.getAppId(), "appInfo");
        if (e2 != null) {
            ncVar.xy(((long) e2.bAn().serviceType) + 1000);
        }
        ncVar.xA((long) i2);
        ncVar.xz(System.currentTimeMillis());
        ncVar.An(nVar.videoPath);
        ncVar.Am(nVar.dCx);
        if (nVar.kGg) {
            j2 = 2;
        } else {
            j2 = 1;
        }
        ncVar.xD(j2);
        AppMethodBeat.o(51024);
        return ncVar;
    }
}
