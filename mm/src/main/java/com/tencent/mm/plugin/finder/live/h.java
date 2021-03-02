package com.tencent.mm.plugin.finder.live;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.service.r;
import com.tencent.mm.plugin.appbrand.service.w;
import com.tencent.mm.plugin.appbrand.service.z;
import com.tencent.mm.plugin.finder.storage.c;
import com.tencent.mm.plugin.finder.utils.m;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.protocal.protobuf.awc;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0019\u001a\u00020\b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bJ\u000e\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fJ\u0018\u0010 \u001a\u00020\u001d2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001e\u001a\u00020\u001fJ\u0006\u0010!\u001a\u00020\u001dR\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\fR\u001a\u0010\u0010\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\fR\u001b\u0010\u0013\u001a\u00020\u00148FX\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0015\u0010\u0016¨\u0006\""}, hxF = {"Lcom/tencent/mm/plugin/finder/live/MiniProgramPreloadHelper;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "ispreload", "", "getIspreload", "()Z", "setIspreload", "(Z)V", "ispresend", "getIspresend", "setIspresend", "isprewarm", "getIsprewarm", "setIsprewarm", "performanceLevel", "", "getPerformanceLevel", "()I", "performanceLevel$delegate", "Lkotlin/Lazy;", "checkPreRender", "liveData", "Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveRoomData;", "preLoadPkgAndEnv", "", "bundle", "Lcom/tencent/mm/plugin/appbrand/api/WeAppOpenBundle;", "preRender", "reset", "plugin-finder_release"})
public final class h {
    private static final String TAG = TAG;
    private static boolean ufU;
    private static boolean ufV;
    private static boolean ufW;
    private static final f ufX = g.ah(a.ufZ);
    public static final h ufY = new h();

    public static int deY() {
        AppMethodBeat.i(245874);
        int intValue = ((Number) ufX.getValue()).intValue();
        AppMethodBeat.o(245874);
        return intValue;
    }

    static {
        AppMethodBeat.i(245878);
        AppMethodBeat.o(245878);
    }

    private h() {
    }

    public static String getTAG() {
        return TAG;
    }

    public static boolean deV() {
        return ufU;
    }

    public static boolean deW() {
        return ufV;
    }

    public static boolean deX() {
        return ufW;
    }

    public final boolean a(com.tencent.mm.plugin.finder.live.viewmodel.g gVar) {
        awc awc;
        int i2 = 1;
        AppMethodBeat.i(245875);
        m mVar = m.vVH;
        if (m.dBP() || (gVar != null && gVar.uEp)) {
            AppMethodBeat.o(245875);
            return true;
        }
        y yVar = y.vXH;
        if (gVar != null) {
            awc = gVar.uEl;
        } else {
            awc = null;
        }
        com.tencent.mm.plugin.appbrand.api.g c2 = y.c(awc);
        if (Util.isNullOrNil(c2.appId)) {
            Log.i(TAG, "[checkPreRender] fail, appId:" + c2.appId);
            AppMethodBeat.o(245875);
            return false;
        }
        r rVar = (r) com.tencent.mm.kernel.g.af(r.class);
        String str = c2.appId;
        c cVar = c.vCb;
        if (!c.dvc()) {
            i2 = 0;
        }
        boolean bW = rVar.bW(str, i2);
        Log.i(TAG, "[checkPreRender] hasInstance:" + bW + ",appId:" + c2.appId + ",patch:" + c2.kHw);
        if (!bW) {
            a(gVar, c2);
        }
        if (gVar != null) {
            gVar.uEp = bW;
        }
        AppMethodBeat.o(245875);
        return bW;
    }

    public static void d(com.tencent.mm.plugin.appbrand.api.g gVar) {
        AppMethodBeat.i(245876);
        p.h(gVar, "bundle");
        Log.i(TAG, "[preLoadPkgAndEnv],username:" + gVar.username);
        if (Util.isNullOrNil(gVar.username)) {
            Log.i(TAG, "[preLoadPkgAndEnv] fail, stack:" + Util.getStack());
            AppMethodBeat.o(245876);
            return;
        }
        ((w) com.tencent.mm.kernel.g.af(w.class)).bb(gVar.username, 4);
        ((com.tencent.mm.plugin.appbrand.service.f) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.appbrand.service.f.class)).a(z.FINDER_LIVING);
        ufU = true;
        ufV = true;
        AppMethodBeat.o(245876);
    }

    public static void a(com.tencent.mm.plugin.finder.live.viewmodel.g gVar, com.tencent.mm.plugin.appbrand.api.g gVar2) {
        AppMethodBeat.i(245877);
        p.h(gVar2, "bundle");
        m mVar = m.vVH;
        if (m.dBP()) {
            AppMethodBeat.o(245877);
            return;
        }
        int deY = deY();
        c cVar = c.vCb;
        int dva = c.dva();
        String str = TAG;
        StringBuilder append = new StringBuilder("[preRender] performanceLevel:").append(deY).append(",threshold:").append(dva).append(",appId:").append(gVar2.appId).append(",patch:").append(gVar2.kHw).append(",is test:");
        c cVar2 = c.vCb;
        Log.i(str, append.append(c.dvc()).toString());
        if (Util.isNullOrNil(gVar2.appId) || Util.isNullOrNil(gVar2.kHw)) {
            Log.i(TAG, "[preRender] fail, stack:" + Util.getStack());
            AppMethodBeat.o(245877);
            return;
        }
        c cVar3 = c.vCb;
        if (c.dvc()) {
            gVar2.iOo = 1;
        } else {
            gVar2.iOo = 0;
        }
        if (deY >= dva) {
            long currentTimeMillis = System.currentTimeMillis();
            ufW = true;
            ((r) com.tencent.mm.kernel.g.af(r.class)).b(gVar2, new b(gVar, gVar2, currentTimeMillis));
            AppMethodBeat.o(245877);
        } else if (1 > dva) {
            AppMethodBeat.o(245877);
        } else {
            if (dva > dva) {
                d(gVar2);
            }
            AppMethodBeat.o(245877);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\b\u001a\u00020\u0003H\u0016¨\u0006\t"}, hxF = {"com/tencent/mm/plugin/finder/live/MiniProgramPreloadHelper$preRender$1", "Lcom/tencent/mm/plugin/appbrand/api/PreRenderColdStartResultCallback;", "onError", "", "errCode", "", "errMsg", "", "onSuccess", "plugin-finder_release"})
    public static final class b implements com.tencent.mm.plugin.appbrand.api.f {
        final /* synthetic */ com.tencent.mm.plugin.finder.live.viewmodel.g uga;
        final /* synthetic */ com.tencent.mm.plugin.appbrand.api.g ugb;
        final /* synthetic */ long ugc;

        b(com.tencent.mm.plugin.finder.live.viewmodel.g gVar, com.tencent.mm.plugin.appbrand.api.g gVar2, long j2) {
            this.uga = gVar;
            this.ugb = gVar2;
            this.ugc = j2;
        }

        @Override // com.tencent.mm.plugin.appbrand.api.f
        public final void onSuccess() {
            AppMethodBeat.i(245872);
            h hVar = h.ufY;
            Log.i(h.getTAG(), "prerender mini pro success!");
            if (this.uga != null) {
                j jVar = j.ugg;
                j.a(this.uga, this.ugb, this.ugc, System.currentTimeMillis());
            }
            AppMethodBeat.o(245872);
        }

        @Override // com.tencent.mm.plugin.appbrand.api.f
        public final void onError(int i2, String str) {
            AppMethodBeat.i(245873);
            h hVar = h.ufY;
            Log.i(h.getTAG(), "prerender mini pro fail,errCode:" + i2 + ",errMsg:" + str);
            if (this.uga != null) {
                j jVar = j.ugg;
                j.a(this.uga, this.ugb, this.ugc, System.currentTimeMillis());
            }
            AppMethodBeat.o(245873);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class a extends q implements kotlin.g.a.a<Integer> {
        public static final a ufZ = new a();

        static {
            AppMethodBeat.i(245871);
            AppMethodBeat.o(245871);
        }

        a() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Integer invoke() {
            AppMethodBeat.i(245870);
            Integer valueOf = Integer.valueOf(com.tencent.mm.n.h.aqJ().getInt("ClientBenchmarkLevel", -1));
            AppMethodBeat.o(245870);
            return valueOf;
        }
    }
}
