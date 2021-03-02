package com.tencent.mm.plugin.finder.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.core.core.a.b;
import com.tencent.mm.live.core.core.e;
import com.tencent.mm.model.cl;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.live.h;
import com.tencent.mm.plugin.finder.live.viewmodel.g;
import com.tencent.mm.plugin.finder.report.k;
import com.tencent.mm.plugin.finder.storage.c;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.awe;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import kotlin.g.b.p;

public final class ae {
    private static final String TAG = TAG;
    private static int curNetworkQuality = e.h.aCT();
    private static b hOO;
    private static long lastReportTime;
    private static final String vZA = vZA;
    private static final String vZB = vZB;
    private static final String vZC = vZC;
    private static final String vZD = vZD;
    private static final String vZE = vZE;
    private static final String vZF = vZF;
    private static final String vZG = vZG;
    private static final String vZH = vZH;
    private static final String vZI = vZI;
    private static final String vZJ = vZJ;
    private static final int vZK = 1;
    private static final int vZL = 2;
    private static final int vZM = c.dvf();
    private static final int vZN = 100;
    private static long vZO;
    private static long vZP;
    private static long vZQ;
    private static long vZR;
    private static int vZS;
    private static String vZT = "";
    private static int vZU;
    private static int vZV;
    public static final ae vZW = new ae();
    private static final int vZw = 1001;
    private static final String vZx = vZx;
    private static final String vZy = vZy;
    private static final String vZz = vZz;

    static {
        AppMethodBeat.i(253767);
        c cVar = c.vCb;
        e.h hVar = e.h.hya;
        AppMethodBeat.o(253767);
    }

    private ae() {
    }

    public static int dDZ() {
        return vZw;
    }

    public static String dEa() {
        return vZx;
    }

    public static String dEb() {
        return vZy;
    }

    public static String dEc() {
        return vZz;
    }

    public static String dEd() {
        return vZA;
    }

    public static String dEe() {
        return vZB;
    }

    public static String dEf() {
        return vZC;
    }

    public static String dEg() {
        return vZD;
    }

    public static String dEh() {
        return vZE;
    }

    public static String dEi() {
        return vZF;
    }

    public static String dEj() {
        return vZG;
    }

    public static String dEk() {
        return vZH;
    }

    public static void e(b bVar) {
        AppMethodBeat.i(253762);
        p.h(bVar, "liveCore");
        hOO = bVar;
        AppMethodBeat.o(253762);
    }

    public static void Gk(long j2) {
        vZO = j2;
    }

    public static void Gl(long j2) {
        vZP = j2;
    }

    public static void Gm(long j2) {
        vZQ = j2;
    }

    public static void Gn(long j2) {
        vZR = j2;
    }

    public static /* synthetic */ void a(String str, int i2, int i3, String str2, g gVar) {
        String str3;
        String str4;
        long j2;
        awe awe;
        FinderObject finderObject;
        AppMethodBeat.i(253763);
        String netTypeString = NetStatusUtil.getNetTypeString(MMApplicationContext.getContext());
        p.g(netTypeString, "NetStatusUtil.getNetType…tionContext.getContext())");
        p.h(str, "cgiEvent");
        p.h(str2, "cgiErrmsg");
        p.h(netTypeString, "extra");
        if (!p.j(vZT, str) || vZU != i2) {
            vZT = str;
            vZU = i2;
            curNetworkQuality = dEl();
            int i4 = (gVar == null || !gVar.uit) ? 0 : 1;
            h hVar = h.ufY;
            int i5 = h.deW() ? 1 : 0;
            int i6 = vZK;
            long j3 = vZO;
            long j4 = vZP - vZO;
            long j5 = vZQ - vZO;
            long j6 = vZR - vZO;
            int i7 = gVar != null ? gVar.uEg : 0;
            int i8 = gVar != null ? gVar.uEf : 0;
            if (gVar == null || (str3 = gVar.uEs) == null) {
                str3 = "";
            }
            String str5 = vZT + str2;
            if (gVar == null || (finderObject = gVar.uDz) == null || (str4 = finderObject.nickname) == null) {
                str4 = z.aUa();
                p.g(str4, "ConfigStorageLogic.getNicknameFromUserInfo()");
            }
            if (gVar == null || (awe = gVar.liveInfo) == null) {
                j2 = 0;
            } else {
                j2 = awe.liveId;
            }
            b(i6, i4, i5, j3, j4, j5, j6, i7, i8, str3, i2, i3, str5, 0, 0, "", netTypeString, str4, j2, (long) curNetworkQuality);
            AppMethodBeat.o(253763);
            return;
        }
        Log.i(TAG, "anchorStatisticsReport,liveCgiEvent:" + vZT + ",liveCgiErrorCode:" + vZU);
        AppMethodBeat.o(253763);
    }

    public static void a(int i2, g gVar, String str) {
        int i3;
        int i4;
        String str2;
        com.tencent.mm.live.core.core.b.g gVar2;
        AppMethodBeat.i(253764);
        p.h(gVar, "liveRoomData");
        p.h(str, "extra");
        e.d dVar = e.d.hxF;
        if (i2 == e.d.aCr() || i2 != vZV) {
            int dEl = dEl();
            e.d dVar2 = e.d.hxF;
            if (i2 == e.d.aCr() && dEl == curNetworkQuality) {
                m mVar = m.vVH;
                m.hd(TAG, "anchorStatisticsReport liveCallbackEvent:" + i2 + ", curNetworkQuality:" + curNetworkQuality);
                AppMethodBeat.o(253764);
                return;
            }
            vZV = i2;
            curNetworkQuality = dEl;
            int i5 = gVar.uit ? 1 : 0;
            h hVar = h.ufY;
            if (h.deW()) {
                i3 = 1;
            } else {
                i3 = 0;
            }
            b bVar = hOO;
            if (bVar == null || (gVar2 = bVar.hAz) == null) {
                i4 = -2;
            } else {
                i4 = gVar2.networkType;
            }
            int i6 = vZK;
            long j2 = vZO;
            long j3 = vZP - vZO;
            long j4 = vZQ - vZO;
            long j5 = vZR - vZO;
            int i7 = gVar.uEg;
            int i8 = gVar.uEf;
            String str3 = gVar.uEs;
            if (str3 == null) {
                str3 = "";
            }
            FinderObject finderObject = gVar.uDz;
            if (finderObject == null || (str2 = finderObject.nickname) == null) {
                str2 = z.aUa();
                p.g(str2, "ConfigStorageLogic.getNicknameFromUserInfo()");
            }
            awe awe = gVar.liveInfo;
            b(i6, i5, i3, j2, j3, j4, j5, i7, i8, str3, 0, 0, "", i2, i4, "", str, str2, (awe != null ? Long.valueOf(awe.liveId) : null).longValue(), (long) curNetworkQuality);
            AppMethodBeat.o(253764);
            return;
        }
        Log.i(TAG, "anchorStatisticsReport liveCallbackEvent:".concat(String.valueOf(i2)));
        AppMethodBeat.o(253764);
    }

    private static void b(int i2, int i3, int i4, long j2, long j3, long j4, long j5, int i5, int i6, String str, int i7, int i8, String str2, int i9, int i10, String str3, String str4, String str5, long j6, long j7) {
        long j8;
        AppMethodBeat.i(253765);
        if (lastReportTime != 0 && cl.aWy() - lastReportTime < ((long) vZM)) {
            Log.i(TAG, "anchorStatisticsReport too fast,frequency:" + (cl.aWy() - lastReportTime) + '!');
            AppMethodBeat.o(253765);
        } else if (vZS >= vZN) {
            Log.i(TAG, "anchorStatisticsReport too much times!");
            AppMethodBeat.o(253765);
        } else {
            if (j2 == 0) {
                j8 = cl.aWy();
                vZO = j8;
            } else {
                j8 = j2;
            }
            lastReportTime = cl.aWy();
            vZS++;
            k kVar = k.vfA;
            k.a(i2, i3, i4, j8, j3, j4, j5, i5, i6, str, i7, i8, str2, i9, i10, str3, str4, str5, j6, j7);
            AppMethodBeat.o(253765);
        }
    }

    public static void reset() {
        AppMethodBeat.i(261492);
        Log.i(TAG, "anchorStatisticsReport reset");
        hOO = null;
        vZO = 0;
        vZP = 0;
        vZQ = 0;
        vZR = 0;
        lastReportTime = 0;
        vZS = 0;
        vZT = "";
        vZU = 0;
        vZV = 0;
        e.h hVar = e.h.hya;
        curNetworkQuality = e.h.aCT();
        AppMethodBeat.o(261492);
    }

    private static int dEl() {
        com.tencent.mm.live.core.core.b.g gVar;
        b bVar = hOO;
        if (bVar == null || (gVar = bVar.hAz) == null) {
            return -1;
        }
        return gVar.hzL;
    }
}
