package com.tencent.luggage.sdk;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.b.g;
import com.tencent.mm.plugin.appbrand.jsapi.bk;
import com.tencent.mm.plugin.appbrand.jsapi.bz;
import com.tencent.mm.plugin.appbrand.jsapi.camera.o;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.q;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.r;
import com.tencent.mm.plugin.appbrand.jsapi.cs;
import com.tencent.mm.plugin.appbrand.jsapi.ct;
import com.tencent.mm.plugin.appbrand.jsapi.cu;
import com.tencent.mm.plugin.appbrand.jsapi.de;
import com.tencent.mm.plugin.appbrand.jsapi.file.w;
import com.tencent.mm.plugin.appbrand.jsapi.h.d;
import com.tencent.mm.plugin.appbrand.jsapi.h.i;
import com.tencent.mm.plugin.appbrand.jsapi.h.j;
import com.tencent.mm.plugin.appbrand.jsapi.k.aj;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.logic.c;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.jsapi.p.aa;
import com.tencent.mm.plugin.appbrand.jsapi.p.ab;
import com.tencent.mm.plugin.appbrand.jsapi.p.ac;
import com.tencent.mm.plugin.appbrand.jsapi.p.ah;
import com.tencent.mm.plugin.appbrand.jsapi.p.ai;
import com.tencent.mm.plugin.appbrand.jsapi.p.an;
import com.tencent.mm.plugin.appbrand.jsapi.p.ap;
import com.tencent.mm.plugin.appbrand.jsapi.p.m;
import com.tencent.mm.plugin.appbrand.jsapi.p.n;
import com.tencent.mm.plugin.appbrand.jsapi.p.u;
import com.tencent.mm.plugin.appbrand.jsapi.p.v;
import com.tencent.mm.plugin.appbrand.jsapi.p.z;
import com.tencent.mm.plugin.appbrand.jsapi.r.e;
import com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoWrapper;
import com.tencent.mm.plugin.appbrand.jsapi.video.f;
import com.tencent.mm.plugin.appbrand.jsapi.video.videoview.a.c;
import com.tencent.mm.plugin.appbrand.jsapi.z.k;
import com.tencent.mm.plugin.appbrand.jsapi.z.l;
import com.tencent.mm.plugin.appbrand.jsapi.z.t;
import com.tencent.mm.plugin.appbrand.platform.window.h;
import com.tencent.mm.plugin.appbrand.t.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class a {
    protected Map<String, p> cyc = new HashMap();
    protected Map<String, p> cyd = new HashMap();

    static {
        AppMethodBeat.i(146678);
        de.bEv();
        Log.i("MicroMsg.Video.LuggageVideoNonSameLayerStrategy", "init, use ExoVideoView");
        AppBrandVideoWrapper.setVideoViewFactory(new f() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.video.i.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.appbrand.jsapi.video.f
            public final String getName() {
                return "Factory#LuggageVideoNonSameLayerStrategy";
            }

            @Override // com.tencent.mm.plugin.appbrand.jsapi.video.f
            public final e dU(Context context) {
                AppMethodBeat.i(234630);
                c cVar = new c(context, (byte) 0);
                AppMethodBeat.o(234630);
                return cVar;
            }
        });
        c.a aVar = com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.logic.c.miO;
        c.a.b(b.INSTANCE);
        e.a(h.nEx);
        AppMethodBeat.o(146678);
    }

    public a() {
        AppMethodBeat.i(146675);
        AppMethodBeat.o(146675);
    }

    private void a(p pVar) {
        AppMethodBeat.i(146677);
        if (pVar == null || Util.isNullOrNil(pVar.getName())) {
            AppMethodBeat.o(146677);
            return;
        }
        this.cyd.put(pVar.getName(), pVar);
        AppMethodBeat.o(146677);
    }

    public final Map<String, p> Nt() {
        AppMethodBeat.i(146676);
        a(new bz());
        a(new com.tencent.mm.plugin.appbrand.jsapi.h.h());
        a(new com.tencent.mm.plugin.appbrand.jsapi.h.c());
        a(new com.tencent.mm.plugin.appbrand.jsapi.h.b());
        a(new i());
        a(new d());
        a(new j());
        a(new com.tencent.mm.plugin.appbrand.jsapi.h.e());
        a(new com.tencent.mm.plugin.appbrand.jsapi.h.f());
        a(new k());
        a(new l());
        a(new com.tencent.mm.plugin.appbrand.jsapi.z.j());
        a(new com.tencent.mm.plugin.appbrand.jsapi.p.h());
        a(new n());
        a(new m());
        a(new cs());
        a(new com.tencent.mm.plugin.appbrand.jsapi.r.f());
        a(new com.tencent.mm.plugin.appbrand.jsapi.r.h());
        a(new com.tencent.mm.plugin.appbrand.jsapi.p.c());
        a(new bk());
        a(new com.tencent.mm.plugin.appbrand.jsapi.video.d.a());
        a(new com.tencent.mm.plugin.appbrand.jsapi.video.d.e());
        a(new com.tencent.mm.plugin.appbrand.jsapi.video.d.d());
        a(new com.tencent.mm.plugin.appbrand.jsapi.video.d.c());
        a(new com.tencent.mm.plugin.appbrand.jsapi.video.d.b());
        a(new com.tencent.mm.plugin.appbrand.jsapi.b.f());
        a(new g());
        a(new com.tencent.mm.plugin.appbrand.jsapi.b.j());
        a(new com.tencent.mm.plugin.appbrand.jsapi.b.l());
        a(new com.tencent.mm.plugin.appbrand.jsapi.p.b());
        a(new com.tencent.mm.plugin.appbrand.jsapi.autofill.e());
        a(new com.tencent.mm.plugin.appbrand.jsapi.autofill.h());
        a(new com.tencent.mm.plugin.appbrand.jsapi.autofill.b());
        a(new com.tencent.mm.plugin.appbrand.jsapi.autofill.g());
        a(new cu());
        a(new t());
        a(new com.tencent.mm.plugin.appbrand.jsapi.container.a());
        a(new com.tencent.mm.plugin.appbrand.jsapi.container.c());
        a(new com.tencent.mm.plugin.appbrand.jsapi.container.b());
        a(new com.tencent.mm.plugin.appbrand.jsapi.autofill.d());
        a(new com.tencent.mm.plugin.appbrand.jsapi.r.g());
        a(new com.tencent.mm.plugin.appbrand.jsapi.r.i());
        a(new ct());
        a(new com.tencent.mm.plugin.appbrand.jsapi.coverview.i());
        a(new r());
        a(new com.tencent.mm.plugin.appbrand.jsapi.coverview.n());
        a(new com.tencent.mm.plugin.appbrand.jsapi.coverview.g());
        a(new com.tencent.mm.plugin.appbrand.jsapi.coverview.p());
        a(new com.tencent.mm.plugin.appbrand.jsapi.coverview.l());
        a(new com.tencent.mm.plugin.appbrand.jsapi.camera.l());
        a(new com.tencent.mm.plugin.appbrand.jsapi.camera.p());
        a(new o());
        a(new com.tencent.mm.plugin.appbrand.debugger.f());
        a(new com.tencent.mm.plugin.appbrand.jsapi.coverview.e());
        a(new com.tencent.mm.plugin.appbrand.jsapi.p.t());
        a(new com.tencent.mm.plugin.appbrand.jsapi.coverview.h());
        a(new q());
        a(new com.tencent.mm.plugin.appbrand.jsapi.coverview.m());
        a(new ab());
        a(new z());
        a(new ai());
        a(new com.tencent.mm.plugin.appbrand.jsapi.p.f());
        a(new v());
        a(new u());
        List<p> bGR = aj.bGR();
        if (bGR.size() > 0) {
            for (p pVar : bGR) {
                a(pVar);
            }
        }
        a(new com.tencent.mm.plugin.appbrand.jsapi.ui.d());
        a(new com.tencent.mm.plugin.appbrand.jsapi.ui.b());
        a(new ah());
        a(new com.tencent.mm.plugin.appbrand.jsapi.p.e());
        a(new com.tencent.mm.plugin.appbrand.jsapi.ui.e());
        a(new com.tencent.mm.plugin.appbrand.jsapi.ui.c());
        a(new com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.h());
        a(new com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.g());
        a(new aa());
        a(new com.tencent.mm.plugin.appbrand.jsapi.storage.d());
        a(new com.tencent.mm.plugin.appbrand.jsapi.storage.j());
        a(new com.tencent.mm.plugin.appbrand.jsapi.storage.m());
        a(new com.tencent.mm.plugin.appbrand.jsapi.storage.e());
        a(new com.tencent.mm.plugin.appbrand.jsapi.z.h());
        a(new com.tencent.mm.plugin.appbrand.jsapi.z.q());
        a(new com.tencent.mm.plugin.appbrand.jsapi.z.n());
        a(new com.tencent.mm.plugin.appbrand.jsapi.z.r());
        a(new an());
        a(new com.tencent.mm.plugin.appbrand.jsapi.v.b());
        a(new w());
        a(new ap());
        a(new ac());
        a(new com.tencent.mm.plugin.appbrand.jsapi.p.p());
        Map<String, p> map = this.cyd;
        AppMethodBeat.o(146676);
        return map;
    }
}
