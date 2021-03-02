package com.tencent.mm.plugin.finder.live;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.appbrand.api.d;
import com.tencent.mm.plugin.finder.live.model.x;
import com.tencent.mm.plugin.finder.live.viewmodel.g;
import com.tencent.mm.plugin.finder.report.k;
import com.tencent.mm.protocal.protobuf.awc;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.Serializable;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000eJ\u0016\u0010\u000f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ&\u0010\u0010\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0014"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/MiniProgramReportHelper;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "report21188", "", "liveData", "Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveRoomData;", "bundle", "Lcom/tencent/mm/plugin/appbrand/api/WeAppOpenBundle;", "luanchFromApp", "", "report21235", "report21237", "prewarmStartTime", "", "prewarmEndTime", "plugin-finder_release"})
public final class j {
    private static final String TAG = TAG;
    public static final j ugg = new j();

    static {
        AppMethodBeat.i(245885);
        AppMethodBeat.o(245885);
    }

    private j() {
    }

    public static void b(g gVar, com.tencent.mm.plugin.appbrand.api.g gVar2) {
        String str;
        String str2;
        AppMethodBeat.i(245882);
        p.h(gVar, "liveData");
        p.h(gVar2, "bundle");
        k kVar = k.vfA;
        Context context = MMApplicationContext.getContext();
        p.g(context, "MMApplicationContext.getContext()");
        String str3 = gVar2.appId;
        if (str3 == null) {
            str3 = "";
        }
        awc awc = gVar.uEl;
        if (awc == null || (str = awc.LGH) == null) {
            str = "";
        }
        h hVar = h.ufY;
        boolean deV = h.deV();
        h hVar2 = h.ufY;
        boolean deW = h.deW();
        String valueOf = String.valueOf(gVar.liveInfo.liveId);
        String aUg = z.aUg();
        p.g(aUg, "ConfigStorageLogic.getMyFinderUsername()");
        awc awc2 = gVar.uEl;
        if (awc2 == null || (str2 = awc2.vtD) == null) {
            str2 = "";
        }
        k.a(context, str3, str, deV, deW, valueOf, aUg, str2, String.valueOf(gVar.sessionId));
        AppMethodBeat.o(245882);
    }

    public static void a(g gVar, com.tencent.mm.plugin.appbrand.api.g gVar2, boolean z) {
        String str;
        String str2;
        awc awc;
        AppMethodBeat.i(245883);
        p.h(gVar, "liveData");
        p.h(gVar2, "bundle");
        if (z) {
            boolean z2 = Util.isNullOrNil(gVar.uEq) && !Util.isNullOrNil(gVar2.appId);
            d dVar = gVar2.kHx;
            if (dVar == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.live.model.WxLiveShoppingExtranData");
                AppMethodBeat.o(245883);
                throw tVar;
            }
            x xVar = (x) dVar;
            h hVar = h.ufY;
            if (!h.deX() || (awc = gVar.uEl) == null || (str = awc.LGH) == null) {
                str = "";
            }
            p.g(str, "if (MiniProgramPreloadHe…derPagePath ?: \"\" else \"\"");
            k kVar = k.vfA;
            Context context = MMApplicationContext.getContext();
            p.g(context, "MMApplicationContext.getContext()");
            int i2 = xVar.uks;
            byte[] bArr = xVar.ukt;
            String valueOf = String.valueOf(bArr != null ? (Serializable) bArr : "");
            String str3 = gVar2.appId;
            if (str3 == null) {
                str3 = "";
            }
            int i3 = gVar2.scene;
            h hVar2 = h.ufY;
            boolean deV = h.deV();
            h hVar3 = h.ufY;
            boolean deW = h.deW();
            String valueOf2 = String.valueOf(gVar.liveInfo.liveId);
            String aUg = z.aUg();
            p.g(aUg, "ConfigStorageLogic.getMyFinderUsername()");
            awc awc2 = gVar.uEl;
            if (awc2 == null || (str2 = awc2.vtD) == null) {
                str2 = "";
            }
            k.a(context, z2, i2, valueOf, str3, i3, str, deV, deW, valueOf2, aUg, str2, String.valueOf(gVar.sessionId));
            AppMethodBeat.o(245883);
            return;
        }
        Log.i(TAG, "luanch from mini program!");
        AppMethodBeat.o(245883);
    }

    public static void a(g gVar, com.tencent.mm.plugin.appbrand.api.g gVar2, long j2, long j3) {
        String str;
        AppMethodBeat.i(245884);
        p.h(gVar, "liveData");
        p.h(gVar2, "bundle");
        k kVar = k.vfA;
        Context context = MMApplicationContext.getContext();
        p.g(context, "MMApplicationContext.getContext()");
        h hVar = h.ufY;
        boolean deV = h.deV();
        h hVar2 = h.ufY;
        boolean deW = h.deW();
        String valueOf = String.valueOf(gVar.liveInfo.liveId);
        String aUg = z.aUg();
        p.g(aUg, "ConfigStorageLogic.getMyFinderUsername()");
        awc awc = gVar.uEl;
        if (awc == null || (str = awc.vtD) == null) {
            str = "";
        }
        String valueOf2 = String.valueOf(gVar.sessionId);
        String str2 = gVar2.appId;
        if (str2 == null) {
            str2 = "";
        }
        k.a(context, deV, deW, valueOf, aUg, str, valueOf2, j2, j3, str2, "");
        AppMethodBeat.o(245884);
    }
}
