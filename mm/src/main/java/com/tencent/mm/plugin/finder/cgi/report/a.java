package com.tencent.mm.plugin.finder.cgi.report;

import android.os.SystemClock;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.data.APMidasPluginInfo;
import com.tencent.mm.ac.f;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.n.n;
import kotlin.o;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002$%B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0019\u001a\u00020\u0004J<\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u0017\u0012\u0006\u0012\u0004\u0018\u00010\t0\u001b2\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00072\u0006\u0010\u001d\u001a\u00020\f2\b\u0010\u0018\u001a\u0004\u0018\u00010\bH\u0002J\u0006\u0010\u001e\u001a\u00020\u001fJ\u0010\u0010 \u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\bJ\u0010\u0010!\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\bJ\u0006\u0010\"\u001a\u00020\u0017J\u0006\u0010#\u001a\u00020\u001fR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\b0\u000fX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\b0\u000fX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\b0\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\b0\u000fX\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, hxF = {"Lcom/tencent/mm/plugin/finder/cgi/report/CgiStrategy;", "", "()V", "MAGIC_CODE_1", "", "MAGIC_CODE_2", "autoBlockErrorMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/plugin/finder/cgi/report/CgiStrategy$TimeLimit;", "autoBlockMap", "autoLimitBlock", "Lcom/tencent/mm/plugin/finder/cgi/report/CgiStrategy$ServerLimit;", "autoLimitErrorBlock", "blockErrorReport", "Ljava/util/concurrent/ConcurrentSkipListSet;", "blockList", "blockReport", "lastInitTime", "", "magicCode", "noPrint", "autoBlock", "", ShareConstants.MEDIA_URI, OpenSDKTool4Assistant.EXTRA_ERROR_CODE, "checkMapCount", "Lkotlin/Pair;", "map", "svrLimit", APMidasPluginInfo.LAUNCH_INTERFACE_INIT, "", "isBlock", "isNoPrint", "isOnlyReportError", "tryMoreInit", "ServerLimit", "TimeLimit", "plugin-finder_release"})
public final class a {
    private static final ConcurrentSkipListSet<String> txQ = new ConcurrentSkipListSet<>();
    private static final ConcurrentSkipListSet<String> txR = new ConcurrentSkipListSet<>();
    private static int txS;
    private static C1096a txT = new C1096a(200, 60);
    private static C1096a txU = new C1096a(1000, 60);
    private static final ConcurrentHashMap<String, b> txV = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<String, b> txW = new ConcurrentHashMap<>();
    private static final ConcurrentSkipListSet<String> txX = new ConcurrentSkipListSet<>();
    private static final ConcurrentSkipListSet<String> txY = new ConcurrentSkipListSet<>();
    public static long txZ;
    public static final a tya = new a();

    static {
        AppMethodBeat.i(242684);
        txQ.add("finderstatsreport");
        txQ.add("findergetlivemsg");
        txQ.add("findermarkread");
        AppMethodBeat.o(242684);
    }

    private a() {
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0018"}, hxF = {"Lcom/tencent/mm/plugin/finder/cgi/report/CgiStrategy$TimeLimit;", "", "count", "", "lastTryTime", "", "(IJ)V", "getCount", "()I", "setCount", "(I)V", "getLastTryTime", "()J", "setLastTryTime", "(J)V", "component1", "component2", "copy", "equals", "", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "toString", "", "plugin-finder_release"})
    public static final class b {
        int count = 0;
        long dAG;

        public final boolean equals(Object obj) {
            if (this != obj) {
                if (obj instanceof b) {
                    b bVar = (b) obj;
                    if (!(this.count == bVar.count && this.dAG == bVar.dAG)) {
                        return false;
                    }
                }
                return false;
            }
            return true;
        }

        public final int hashCode() {
            long j2 = this.dAG;
            return (this.count * 31) + ((int) (j2 ^ (j2 >>> 32)));
        }

        public final String toString() {
            AppMethodBeat.i(242676);
            String str = "TimeLimit(count=" + this.count + ", lastTryTime=" + this.dAG + ")";
            AppMethodBeat.o(242676);
            return str;
        }

        public b(long j2) {
            this.dAG = j2;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0018"}, hxF = {"Lcom/tencent/mm/plugin/finder/cgi/report/CgiStrategy$ServerLimit;", "", "count", "", "time", "", "(IJ)V", "getCount", "()I", "setCount", "(I)V", "getTime", "()J", "setTime", "(J)V", "component1", "component2", "copy", "equals", "", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "toString", "", "plugin-finder_release"})
    /* renamed from: com.tencent.mm.plugin.finder.cgi.report.a$a  reason: collision with other inner class name */
    public static final class C1096a {
        int count;
        long time;

        public final boolean equals(Object obj) {
            if (this != obj) {
                if (obj instanceof C1096a) {
                    C1096a aVar = (C1096a) obj;
                    if (!(this.count == aVar.count && this.time == aVar.time)) {
                        return false;
                    }
                }
                return false;
            }
            return true;
        }

        public final int hashCode() {
            long j2 = this.time;
            return (this.count * 31) + ((int) (j2 ^ (j2 >>> 32)));
        }

        public final String toString() {
            AppMethodBeat.i(242675);
            String str = "ServerLimit(count=" + this.count + ", time=" + this.time + ")";
            AppMethodBeat.o(242675);
            return str;
        }

        public C1096a(int i2, long j2) {
            this.count = i2;
            this.time = j2;
        }
    }

    public static void init() {
        String str;
        String str2;
        String str3;
        String str4;
        String str5 = null;
        AppMethodBeat.i(242679);
        f.a aVar = new f.a();
        com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
        String dxg = com.tencent.mm.plugin.finder.storage.c.dxg();
        List<String> stringToList = Util.stringToList(dxg, ",");
        p.g(stringToList, LocaleUtil.ITALIAN);
        String str6 = (String) j.L(stringToList, 0);
        if (str6 == null) {
            str = null;
        } else if (str6 == null) {
            t tVar = new t("null cannot be cast to non-null type kotlin.CharSequence");
            AppMethodBeat.o(242679);
            throw tVar;
        } else {
            str = n.trim(str6).toString();
        }
        int safeParseInt = Util.safeParseInt(str);
        String str7 = (String) j.L(stringToList, 1);
        if (str7 == null) {
            str2 = null;
        } else if (str7 == null) {
            t tVar2 = new t("null cannot be cast to non-null type kotlin.CharSequence");
            AppMethodBeat.o(242679);
            throw tVar2;
        } else {
            str2 = n.trim(str7).toString();
        }
        txT = new C1096a(safeParseInt, (long) Util.safeParseInt(str2));
        String str8 = (String) j.L(stringToList, 2);
        if (str8 == null) {
            str3 = null;
        } else if (str8 == null) {
            t tVar3 = new t("null cannot be cast to non-null type kotlin.CharSequence");
            AppMethodBeat.o(242679);
            throw tVar3;
        } else {
            str3 = n.trim(str8).toString();
        }
        int safeParseInt2 = Util.safeParseInt(str3);
        String str9 = (String) j.L(stringToList, 3);
        if (str9 == null) {
            str4 = null;
        } else if (str9 == null) {
            t tVar4 = new t("null cannot be cast to non-null type kotlin.CharSequence");
            AppMethodBeat.o(242679);
            throw tVar4;
        } else {
            str4 = n.trim(str9).toString();
        }
        txU = new C1096a(safeParseInt2, (long) Util.safeParseInt(str4));
        com.tencent.mm.plugin.finder.storage.c cVar2 = com.tencent.mm.plugin.finder.storage.c.vCb;
        String dxf = com.tencent.mm.plugin.finder.storage.c.dxf();
        if (dxf != null) {
            if (dxf == null) {
                t tVar5 = new t("null cannot be cast to non-null type kotlin.CharSequence");
                AppMethodBeat.o(242679);
                throw tVar5;
            }
            str5 = n.trim(dxf).toString();
        }
        int safeParseInt3 = Util.safeParseInt(str5);
        txS = safeParseInt3;
        if (safeParseInt3 > 0) {
            Log.e("Finder.CgiStrategy", "blockAll cgi " + txS);
            AppMethodBeat.o(242679);
            return;
        }
        com.tencent.mm.plugin.finder.storage.c cVar3 = com.tencent.mm.plugin.finder.storage.c.vCb;
        List<String> stringToList2 = Util.stringToList(com.tencent.mm.plugin.finder.storage.c.dxf(), ",");
        Log.i("Finder.CgiStrategy", "init blockString " + dxf + " limitString " + dxg + " size " + stringToList2.size() + " autoLimitErrorBlock:" + txT.count + ' ' + txT.time + " autoLimitBlock:" + txU.count + ' ' + txU.time + " errorReport " + txX.size() + ' ' + txY.size() + " cost:" + aVar.apr());
        txR.clear();
        txR.addAll(stringToList2);
        AppMethodBeat.o(242679);
    }

    public static boolean dv(String str, int i2) {
        AppMethodBeat.i(242680);
        if (i2 != 0) {
            o<Boolean, b> a2 = a(txV, txT, str);
            if (a2.first.booleanValue()) {
                if (BuildInfo.DEBUG) {
                    Log.i("Finder.CgiStrategy", "isBlock error case " + str + ' ' + i2);
                }
                if (!txY.contains(str)) {
                    f.a.a(com.tencent.mm.plugin.finder.utils.c.vVc, "cgiReportError", false, false, new c(str, i2, a2), 12);
                    txY.add(str);
                }
                AppMethodBeat.o(242680);
                return true;
            }
        } else {
            o<Boolean, b> a3 = a(txW, txU, str);
            if (a3.first.booleanValue()) {
                if (!txX.contains(str)) {
                    f.a.a(com.tencent.mm.plugin.finder.utils.c.vVc, "cgiReportNormal", false, false, new d(str, i2, a3), 12);
                    txX.add(str);
                }
                if (BuildInfo.DEBUG) {
                    Log.i("Finder.CgiStrategy", "isBlock normal case " + str + ' ' + i2);
                }
                AppMethodBeat.o(242680);
                return true;
            }
        }
        AppMethodBeat.o(242680);
        return false;
    }

    private static o<Boolean, b> a(ConcurrentHashMap<String, b> concurrentHashMap, C1096a aVar, String str) {
        b putIfAbsent;
        AppMethodBeat.i(242681);
        if (str == null || Util.isNullOrNil(str)) {
            o<Boolean, b> oVar = new o<>(Boolean.TRUE, null);
            AppMethodBeat.o(242681);
            return oVar;
        }
        String oD = n.oD(str, FilePathGenerator.ANDROID_DIR_SEP);
        ConcurrentHashMap<String, b> concurrentHashMap2 = concurrentHashMap;
        b bVar = concurrentHashMap2.get(oD);
        if (bVar == null && (putIfAbsent = concurrentHashMap2.putIfAbsent(oD, (bVar = new b(SystemClock.elapsedRealtime())))) != null) {
            bVar = putIfAbsent;
        }
        b bVar2 = bVar;
        if (bVar2.count >= aVar.count) {
            if (SystemClock.elapsedRealtime() - bVar2.dAG <= aVar.time * 60 * 1000) {
                o<Boolean, b> oVar2 = new o<>(Boolean.TRUE, bVar2);
                AppMethodBeat.o(242681);
                return oVar2;
            }
            bVar2.count = 0;
            bVar2.dAG = SystemClock.elapsedRealtime();
        }
        bVar2.count++;
        o<Boolean, b> oVar3 = new o<>(Boolean.FALSE, null);
        AppMethodBeat.o(242681);
        return oVar3;
    }

    public static boolean cZs() {
        return txS == 2;
    }

    public static boolean asP(String str) {
        AppMethodBeat.i(242682);
        if (str == null || Util.isNullOrNil(str)) {
            AppMethodBeat.o(242682);
            return true;
        } else if (txS == 1) {
            AppMethodBeat.o(242682);
            return true;
        } else {
            if (txR.contains(n.oD(str, FilePathGenerator.ANDROID_DIR_SEP))) {
                AppMethodBeat.o(242682);
                return true;
            }
            AppMethodBeat.o(242682);
            return false;
        }
    }

    public static boolean asQ(String str) {
        AppMethodBeat.i(242683);
        if (str == null || Util.isNullOrNil(str)) {
            AppMethodBeat.o(242683);
            return true;
        }
        if (txQ.contains(n.oD(str, FilePathGenerator.ANDROID_DIR_SEP))) {
            AppMethodBeat.o(242683);
            return true;
        }
        AppMethodBeat.o(242683);
        return false;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class c extends q implements kotlin.g.a.a<String> {
        final /* synthetic */ String jDd;
        final /* synthetic */ int tyb;
        final /* synthetic */ o tyc;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(String str, int i2, o oVar) {
            super(0);
            this.jDd = str;
            this.tyb = i2;
            this.tyc = oVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ String invoke() {
            AppMethodBeat.i(242677);
            StringBuilder append = new StringBuilder("uri:").append(this.jDd).append(",errCode:").append(this.tyb).append(",size:");
            B b2 = this.tyc.second;
            String sb = append.append(b2 != null ? Integer.valueOf(b2.count) : null).toString();
            AppMethodBeat.o(242677);
            return sb;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class d extends q implements kotlin.g.a.a<String> {
        final /* synthetic */ String jDd;
        final /* synthetic */ int tyb;
        final /* synthetic */ o tyc;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(String str, int i2, o oVar) {
            super(0);
            this.jDd = str;
            this.tyb = i2;
            this.tyc = oVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ String invoke() {
            AppMethodBeat.i(242678);
            StringBuilder append = new StringBuilder("uri:").append(this.jDd).append(",errCode:").append(this.tyb).append(",size:");
            B b2 = this.tyc.second;
            String sb = append.append(b2 != null ? Integer.valueOf(b2.count) : null).toString();
            AppMethodBeat.o(242678);
            return sb;
        }
    }
}
