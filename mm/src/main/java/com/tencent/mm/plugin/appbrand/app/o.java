package com.tencent.mm.plugin.appbrand.app;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.luggage.bridge.a.a;
import com.tencent.luggage.game.d.a.a.a;
import com.tencent.luggage.h.j;
import com.tencent.luggage.sdk.b;
import com.tencent.luggage.sdk.b.a.c.c;
import com.tencent.luggage.sdk.b.a.c.e;
import com.tencent.luggage.sdk.g.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.MediaCodecProxyUtils;
import com.tencent.mm.compatible.deviceinfo.u;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.modelappbrand.a.b;
import com.tencent.mm.plugin.appbrand.ac.p;
import com.tencent.mm.plugin.appbrand.ad.k;
import com.tencent.mm.plugin.appbrand.appcache.bq;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.mm.plugin.appbrand.debugger.t;
import com.tencent.mm.plugin.appbrand.jsapi.video.m;
import com.tencent.mm.plugin.appbrand.luggage.b.f;
import com.tencent.mm.plugin.appbrand.media.record.h;
import com.tencent.mm.plugin.appbrand.permission.i;
import com.tencent.mm.plugin.appbrand.ui.ah;
import com.tencent.mm.plugin.appbrand.ui.r;
import com.tencent.mm.plugin.appbrand.utils.v;
import com.tencent.mm.plugin.appbrand.xweb_ext.video.d;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.io.InputStream;

final class o extends b {
    a.b kJQ = null;
    private final g kJR;

    public o(final g gVar) {
        AppMethodBeat.i(44225);
        this.kJR = gVar;
        c.a("WeChatMultiProcessInitDelegateImpl<init>", new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.app.o.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(44217);
                Log.i("MicroMsg.WeChatMultiProcessInitDelegateImpl", "<init> %s", gVar.mProcessName);
                j jVar = j.cDv;
                j.a(v.ohj);
                h.a(new h.a() {
                    /* class com.tencent.mm.plugin.appbrand.app.o.AnonymousClass1.AnonymousClass1 */

                    @Override // com.tencent.mm.plugin.appbrand.media.record.h.a
                    public final void ef(String str) {
                        AppMethodBeat.i(174700);
                        com.tencent.mm.compatible.util.j.Ed(str);
                        AppMethodBeat.o(174700);
                    }
                });
                com.tencent.mm.modelappbrand.a.b.LH(com.tencent.mm.loader.j.b.aKJ());
                com.tencent.mm.modelappbrand.a.b.a(new b.g() {
                    /* class com.tencent.mm.plugin.appbrand.app.o.AnonymousClass1.AnonymousClass2 */

                    @Override // com.tencent.mm.modelappbrand.a.b.g
                    public final Bitmap decodeStream(InputStream inputStream) {
                        AppMethodBeat.i(174701);
                        Bitmap decodeStream = BitmapUtil.decodeStream(inputStream);
                        AppMethodBeat.o(174701);
                        return decodeStream;
                    }
                });
                AppBrandLocalMediaObjectManager.LH(com.tencent.mm.loader.j.b.aKJ());
                if (MMApplicationContext.isToolsProcess() || MMApplicationContext.isToolsMpProcess() || PluginAppBrand.isAppBrandProcess()) {
                    o.this.kJQ = new com.tencent.mm.plugin.appbrand.luggage.a();
                    AppMethodBeat.o(44217);
                } else if (PluginAppBrand.isSupportProcess()) {
                    o.this.kJQ = new com.tencent.mm.plugin.appbrand.luggage.b();
                    AppMethodBeat.o(44217);
                } else {
                    o.this.kJQ = new a.b() {
                        /* class com.tencent.mm.plugin.appbrand.app.o.AnonymousClass1.AnonymousClass3 */

                        @Override // com.tencent.luggage.bridge.a.a.b
                        public final void a(a.c cVar) {
                        }

                        @Override // com.tencent.luggage.bridge.a.a.b
                        public final void a(a.AbstractC0164a aVar) {
                        }
                    };
                    AppMethodBeat.o(44217);
                }
            }
        });
        AppMethodBeat.o(44225);
    }

    @Override // com.tencent.luggage.bridge.impl.a, com.tencent.luggage.sdk.b, com.tencent.luggage.sdk.c, com.tencent.luggage.bridge.a.a.b
    public final void a(a.c cVar) {
        AppMethodBeat.i(44226);
        Log.i("MicroMsg.WeChatMultiProcessInitDelegateImpl", "onInitialize %s", MMApplicationContext.getProcessName());
        super.a(cVar);
        this.kJQ.a(cVar);
        cVar.a(ah.class, new r());
        cVar.a(p.a.class, new f(MMApplicationContext.getContext()));
        cVar.a(com.tencent.mm.plugin.appbrand.jsapi.video.h.class, new m());
        cVar.a(com.tencent.mm.plugin.appbrand.w.a.class, new com.tencent.mm.plugin.appbrand.luggage.c.a());
        cVar.a(com.tencent.mm.plugin.appbrand.w.b.class, new com.tencent.mm.plugin.appbrand.luggage.c.b());
        cVar.a(com.tencent.mm.plugin.appbrand.jsapi.video.g.class, com.tencent.mm.plugin.appbrand.jsapi.video.j.bJE());
        cVar.a(com.tencent.mm.plugin.appbrand.jsapi.ag.e.h.class, d.a.cdQ());
        cVar.a(k.class, com.tencent.mm.plugin.appbrand.ad.d.kGH);
        cVar.a(com.tencent.luggage.sdk.customize.a.class, new com.tencent.mm.plugin.appbrand.luggage.b.b());
        cVar.a(com.tencent.mm.plugin.appbrand.networking.c.class, com.tencent.mm.plugin.appbrand.networking.h.njF);
        cVar.a(i.class, new com.tencent.mm.plugin.appbrand.task.a.d());
        cVar.a(com.tencent.mm.plugin.appbrand.widget.a.a.class, new bq());
        com.tencent.mm.plugin.appbrand.jsapi.autofill.i.init();
        MediaCodecProxyUtils.a(new u() {
            /* class com.tencent.mm.plugin.appbrand.app.o.AnonymousClass2 */

            @Override // com.tencent.mm.compatible.deviceinfo.u
            public final void yU(long j2) {
                AppMethodBeat.i(174702);
                com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(1132, j2, 1, false);
                AppMethodBeat.o(174702);
            }

            @Override // com.tencent.mm.compatible.deviceinfo.u
            public final void DX(String str) {
                AppMethodBeat.i(174703);
                com.tencent.mm.plugin.report.service.h.INSTANCE.kvStat(17952, str);
                AppMethodBeat.o(174703);
            }

            @Override // com.tencent.mm.compatible.deviceinfo.u
            public final boolean aoV() {
                AppMethodBeat.i(174704);
                if (TextUtils.equals(com.tencent.mm.plugin.expt.h.d.cRY().b("clicfg_media_codec_proxy_kv_switch", "1", false, false), AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
                    AppMethodBeat.o(174704);
                    return false;
                }
                AppMethodBeat.o(174704);
                return true;
            }
        });
        AppMethodBeat.o(44226);
    }

    @Override // com.tencent.luggage.bridge.impl.a, com.tencent.luggage.sdk.c, com.tencent.luggage.bridge.a.a.b
    public final void a(a.AbstractC0164a aVar) {
        AppMethodBeat.i(44227);
        Log.i("MicroMsg.WeChatMultiProcessInitDelegateImpl", "onInitComponent %s", MMApplicationContext.getProcessName());
        super.a(aVar);
        this.kJQ.a(aVar);
        AppMethodBeat.o(44227);
    }

    @Override // com.tencent.luggage.sdk.b
    public final void Nu() {
        AppMethodBeat.i(44228);
        if (this.kJR.FZ(":appbrand")) {
            super.Nu();
            e.Oy().a(new c.a(), com.tencent.mm.plugin.appbrand.service.b.class);
            e.Oy().a(new a.b(), com.tencent.mm.plugin.appbrand.game.a.class);
            e.Oy().a(com.tencent.luggage.sdk.b.a.c.j.cBs, t.class);
        }
        AppMethodBeat.o(44228);
    }
}
