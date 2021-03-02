package com.tencent.mm.plugin.ac;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u001f\u0018\u0000 >2\u00020\u0001:\u0003=>?B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0018\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\rH\u0002J\u0016\u0010$\u001a\u00020!2\u0006\u0010#\u001a\u00020\u00062\u0006\u0010%\u001a\u00020\u0003J\u000e\u0010&\u001a\u00020!2\u0006\u0010'\u001a\u00020\u0003J\u000e\u0010(\u001a\u00020!2\u0006\u0010'\u001a\u00020\u0003J\u000e\u0010)\u001a\u00020!2\u0006\u0010#\u001a\u00020\u0006J\u000e\u0010*\u001a\u00020!2\u0006\u0010#\u001a\u00020\u0006J\u0006\u0010+\u001a\u00020!J\u0006\u0010,\u001a\u00020!J \u0010-\u001a\u00020!2\u0006\u0010.\u001a\u00020\u000e2\u0006\u0010#\u001a\u00020\u00062\u0006\u0010/\u001a\u00020\u0003H\u0002J\u0006\u00100\u001a\u00020!J\u0006\u00101\u001a\u00020!J\u0006\u00102\u001a\u00020!J \u00103\u001a\u00020!2\u0006\u0010.\u001a\u00020\u000e2\u0006\u0010#\u001a\u00020\u00062\u0006\u0010/\u001a\u00020\u0003H\u0002J \u00104\u001a\u00020!2\u0006\u0010.\u001a\u00020\u000e2\u0006\u0010#\u001a\u00020\u00062\u0006\u0010/\u001a\u00020\u0003H\u0002J&\u00105\u001a\u00020\u00032\u0006\u00106\u001a\u00020\u00012\u0006\u00107\u001a\u00020\u00062\u0006\u0010'\u001a\u00020\u00032\u0006\u0010#\u001a\u00020\u0006J\u0016\u00108\u001a\u00020!2\u0006\u00107\u001a\u00020\u00032\u0006\u00109\u001a\u00020\u0003J \u0010:\u001a\u00020!2\u0006\u0010.\u001a\u00020\u000e2\u0006\u0010#\u001a\u00020\u00062\u0006\u0010/\u001a\u00020\u0003H\u0002J\u0016\u0010;\u001a\u00020!2\u0006\u0010\"\u001a\u00020\u00062\u0006\u0010<\u001a\u00020\rR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u0003XD¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00160\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0017\u001a\u00020\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u000e\u0010\u001c\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0012¨\u0006@"}, hxF = {"Lcom/tencent/mm/plugin/webjsengine/WebCanvasPerformanceReporter;", "", "reportId", "", "initStartTime", "appId", "", "(JJLjava/lang/String;)V", "getAppId", "()Ljava/lang/String;", "baseReportId", "bindStartTimeMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/plugin/webjsengine/WebCanvasPerformanceReporter$BindInfo;", "configCost", "configStartTime", "getConfigStartTime", "()J", "setConfigStartTime", "(J)V", "createStartTimeMap", "Lcom/tencent/mm/plugin/webjsengine/WebCanvasPerformanceReporter$CreateInfo;", "isMainContextStarted", "", "()Z", "setMainContextStarted", "(Z)V", "lastCreateStartTime", "magicBrushInitCost", "magicBrushInitStartTime", "getReportId", "addBindStartTime", "", "canvasId", "id", "addCreateStartTime", "startTime", "onBasePkgRead", FFmpegMetadataRetriever.METADATA_KEY_DURATION, "onBizPkgRead", "onClientContextReady", "onConfigClientEnd", "onConfigEnd", "onConfigStart", "onJsInit", "info", "timeCost", "onMagicBrushInit", "onMagicBrushInitStart", "onMainContextReady", "onRafInit", "onScreen", "performance", "elementId", "key", "report", "value", "reportWebCanvasRender", "resetBindStartTime", "canvasElementId", "BindInfo", "Companion", "CreateInfo", "webview-sdk_release"})
public final class b {
    public static final C0512b IBK = new C0512b((byte) 0);
    private final long IBA;
    public volatile boolean IBB;
    private long IBC;
    public final ConcurrentHashMap<String, c> IBD;
    public final ConcurrentHashMap<Integer, a> IBE;
    public long IBF;
    public long IBG;
    public long IBH;
    private long IBI;
    private final long IBJ;
    public final String appId;
    public final long hpW;

    static {
        AppMethodBeat.i(224867);
        AppMethodBeat.o(224867);
    }

    public /* synthetic */ b(long j2) {
        this(j2, "wxf337cbaa27790d8e");
        AppMethodBeat.i(224866);
        AppMethodBeat.o(224866);
    }

    private b(long j2, String str) {
        p.h(str, "appId");
        AppMethodBeat.i(224865);
        this.IBJ = 1498;
        this.hpW = j2;
        this.appId = str;
        this.IBA = 1497;
        this.IBD = new ConcurrentHashMap<>();
        this.IBE = new ConcurrentHashMap<>();
        this.IBF = System.currentTimeMillis();
        this.IBG = System.currentTimeMillis();
        AppMethodBeat.o(224865);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00052\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\bHÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0012¨\u0006\u001d"}, hxF = {"Lcom/tencent/mm/plugin/webjsengine/WebCanvasPerformanceReporter$CreateInfo;", "", "createTime", "", "isMainContextStarted", "", "(JZ)V", "configClientCost", "", "getConfigClientCost", "()I", "setConfigClientCost", "(I)V", "getCreateTime", "()J", "setCreateTime", "(J)V", "isClientContextStarted", "()Z", "setClientContextStarted", "(Z)V", "component1", "component2", "copy", "equals", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "toString", "", "webview-sdk_release"})
    public static final class c {
        public final boolean IBB;
        public boolean IBM;
        public int IBN;
        public long createTime;

        public final boolean equals(Object obj) {
            if (this != obj) {
                if (obj instanceof c) {
                    c cVar = (c) obj;
                    if (!(this.createTime == cVar.createTime && this.IBB == cVar.IBB)) {
                        return false;
                    }
                }
                return false;
            }
            return true;
        }

        public final int hashCode() {
            long j2 = this.createTime;
            int i2 = ((int) (j2 ^ (j2 >>> 32))) * 31;
            boolean z = this.IBB;
            if (z) {
                z = true;
            }
            int i3 = z ? 1 : 0;
            int i4 = z ? 1 : 0;
            int i5 = z ? 1 : 0;
            return i3 + i2;
        }

        public final String toString() {
            AppMethodBeat.i(224860);
            String str = "CreateInfo(createTime=" + this.createTime + ", isMainContextStarted=" + this.IBB + ")";
            AppMethodBeat.o(224860);
            return str;
        }

        public c(long j2, boolean z) {
            this.createTime = j2;
            this.IBB = z;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0012\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0005HÆ\u0003J\t\u0010\"\u001a\u00020\u0007HÆ\u0003J'\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010$\u001a\u00020\u00162\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001a\u00020\u0005HÖ\u0001J\t\u0010'\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0010\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0018\"\u0004\b\u001c\u0010\u001aR\u001a\u0010\u001d\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0010\"\u0004\b\u001f\u0010\u0014¨\u0006("}, hxF = {"Lcom/tencent/mm/plugin/webjsengine/WebCanvasPerformanceReporter$BindInfo;", "", "createTime", "", "elementId", "", "canvasId", "", "(JILjava/lang/String;)V", "getCanvasId", "()Ljava/lang/String;", "getCreateTime", "()J", "setCreateTime", "(J)V", "getElementId", "()I", "firstOnScreenCost", "getFirstOnScreenCost", "setFirstOnScreenCost", "(I)V", "hasRendered", "", "getHasRendered", "()Z", "setHasRendered", "(Z)V", "isClientContextStarted", "setClientContextStarted", "jsInitCost", "getJsInitCost", "setJsInitCost", "component1", "component2", "component3", "copy", "equals", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "toString", "webview-sdk_release"})
    public static final class a {
        public boolean IBL;
        public boolean IBM = true;
        private final int biJ;
        public long createTime;
        private final String lAN;

        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0024, code lost:
            if (kotlin.g.b.p.j(r5.lAN, r6.lAN) != false) goto L_0x0026;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean equals(java.lang.Object r6) {
            /*
                r5 = this;
                r4 = 224859(0x36e5b, float:3.15095E-40)
                com.tencent.matrix.trace.core.AppMethodBeat.i(r4)
                if (r5 == r6) goto L_0x0026
                boolean r0 = r6 instanceof com.tencent.mm.plugin.ac.b.a
                if (r0 == 0) goto L_0x002b
                com.tencent.mm.plugin.ac.b$a r6 = (com.tencent.mm.plugin.ac.b.a) r6
                long r0 = r5.createTime
                long r2 = r6.createTime
                int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
                if (r0 != 0) goto L_0x002b
                int r0 = r5.biJ
                int r1 = r6.biJ
                if (r0 != r1) goto L_0x002b
                java.lang.String r0 = r5.lAN
                java.lang.String r1 = r6.lAN
                boolean r0 = kotlin.g.b.p.j(r0, r1)
                if (r0 == 0) goto L_0x002b
            L_0x0026:
                r0 = 1
                com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
            L_0x002a:
                return r0
            L_0x002b:
                r0 = 0
                com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
                goto L_0x002a
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.ac.b.a.equals(java.lang.Object):boolean");
        }

        public final int hashCode() {
            AppMethodBeat.i(224858);
            long j2 = this.createTime;
            int i2 = ((((int) (j2 ^ (j2 >>> 32))) * 31) + this.biJ) * 31;
            String str = this.lAN;
            int hashCode = (str != null ? str.hashCode() : 0) + i2;
            AppMethodBeat.o(224858);
            return hashCode;
        }

        public final String toString() {
            AppMethodBeat.i(224857);
            String str = "BindInfo(createTime=" + this.createTime + ", elementId=" + this.biJ + ", canvasId=" + this.lAN + ")";
            AppMethodBeat.o(224857);
            return str;
        }

        public a(long j2, int i2, String str) {
            p.h(str, "canvasId");
            AppMethodBeat.i(224856);
            this.createTime = j2;
            this.biJ = i2;
            this.lAN = str;
            AppMethodBeat.o(224856);
        }
    }

    public final void fXb() {
        AppMethodBeat.i(224861);
        this.IBC = System.currentTimeMillis();
        Q(10, 1);
        long j2 = this.IBC - this.hpW;
        Q(11, j2);
        Log.i("MicroMsg.WebCanvasPerformanceReporter", "performance: [ConfigStart]:" + j2 + LocaleUtil.MALAY);
        AppMethodBeat.o(224861);
    }

    public final void fXc() {
        AppMethodBeat.i(224862);
        long currentTimeMillis = System.currentTimeMillis();
        long j2 = currentTimeMillis - this.hpW;
        Q(12, j2);
        long j3 = currentTimeMillis - this.IBC;
        Q(16, j3);
        Log.i("MicroMsg.WebCanvasPerformanceReporter", "performance: [ConfigEnd]:" + j2 + LocaleUtil.MALAY);
        this.IBI = j3;
        AppMethodBeat.o(224862);
    }

    public final void fXd() {
        AppMethodBeat.i(224863);
        this.IBB = true;
        long currentTimeMillis = System.currentTimeMillis();
        long j2 = currentTimeMillis - this.hpW;
        long j3 = currentTimeMillis - this.IBC;
        Q(17, j2);
        Log.i("MicroMsg.WebCanvasPerformanceReporter", "performance: [MainContextReady]:" + j2 + "ms, inject mainContextCost " + j3);
        if (50 <= j3 && 100 >= j3) {
            Q(19, 1);
        } else if (101 <= j3 && 300 >= j3) {
            Q(20, 1);
        } else if (301 <= j3 && 500 >= j3) {
            Q(21, 1);
        } else if (j3 > 500) {
            Q(22, 1);
        }
        String str = this.appId + "," + this.IBH + "," + this.IBI + "," + j2;
        p.g(str, "StringBuilder().apply {\n…ast)\n        }.toString()");
        h.INSTANCE.kvStat(20918, str);
        AppMethodBeat.o(224863);
    }

    public final void Q(long j2, long j3) {
        AppMethodBeat.i(224864);
        h.INSTANCE.n(this.IBA, j2, j3);
        h.INSTANCE.n(this.IBJ, j2, j3);
        AppMethodBeat.o(224864);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/webjsengine/WebCanvasPerformanceReporter$Companion;", "", "()V", "SPLITOR", "", "TAG", "kvWebCanvasCreate", "", "kvWebCanvasMainContextInit", "kvWebCanvasRender", "webview-sdk_release"})
    /* renamed from: com.tencent.mm.plugin.ac.b$b  reason: collision with other inner class name */
    public static final class C0512b {
        private C0512b() {
        }

        public /* synthetic */ C0512b(byte b2) {
            this();
        }
    }
}
