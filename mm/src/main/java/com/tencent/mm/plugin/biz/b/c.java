package com.tencent.mm.plugin.biz.b;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0016\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J&\u0010+\u001a\u00020\u00172\u0006\u0010,\u001a\u00020\r2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\u00042\u0006\u00100\u001a\u00020.J\u000e\u00101\u001a\u0002022\u0006\u00103\u001a\u00020\u0004J\u0018\u00104\u001a\u00020\u00172\u0006\u00103\u001a\u00020\u00042\b\u00105\u001a\u0004\u0018\u000106J\n\u0010,\u001a\u00020\u0004*\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R#\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00068FX\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u000e\u0010\f\u001a\u00020\rXT¢\u0006\u0002\n\u0000R#\u0010\u000e\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00068BX\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u000f\u0010\tR!\u0010\u0011\u001a\u00020\u00048FX\u0002¢\u0006\u0012\n\u0004\b\u0015\u0010\u000b\u0012\u0004\b\u0012\u0010\u0002\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0016\u001a\u00020\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR$\u0010\u001c\u001a\u00020\u00178\u0006@\u0006X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u001d\u0010\u0002\u001a\u0004\b\u001e\u0010\u0019\"\u0004\b\u001f\u0010\u001bR$\u0010 \u001a\u00020\u00178\u0006@\u0006X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b!\u0010\u0002\u001a\u0004\b\"\u0010\u0019\"\u0004\b#\u0010\u001bR\u001b\u0010$\u001a\u00020\u00178FX\u0002¢\u0006\f\n\u0004\b&\u0010\u000b\u001a\u0004\b%\u0010\u0019R$\u0010'\u001a\u00020\u00178\u0006@\u0006X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b(\u0010\u0002\u001a\u0004\b)\u0010\u0019\"\u0004\b*\u0010\u001b¨\u00067"}, hxF = {"Lcom/tencent/mm/plugin/biz/util/TestBiz;", "", "()V", "TAG", "", "crashMMKV", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "getCrashMMKV", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "crashMMKV$delegate", "Lkotlin/Lazy;", "maxViewItemCrashTimes", "", "mmkv", "getMmkv", "mmkv$delegate", "mpManifestPath", "mpManifestPath$annotations", "getMpManifestPath", "()Ljava/lang/String;", "mpManifestPath$delegate", "needReportIdKey", "", "getNeedReportIdKey", "()Z", "setNeedReportIdKey", "(Z)V", "noOftenReadMode", "noOftenReadMode$annotations", "getNoOftenReadMode", "setNoOftenReadMode", "noVideoChannelMode", "noVideoChannelMode$annotations", "getNoVideoChannelMode", "setNoVideoChannelMode", WeChatBrands.Business.GROUP_OPEN, "getOpen", "open$delegate", "useDebugMpManifestPath", "useDebugMpManifestPath$annotations", "getUseDebugMpManifestPath", "setUseDebugMpManifestPath", "canPreloadNow", "crashTimes", "defaultInterval", "", "preloadLastTimeKey", "reportKey", "postProcessShowView", "", "viewId", "preProcessShowView", "view", "Landroid/view/View;", "plugin-biz_release"})
public final class c {
    private static final f iBW = g.ah(b.pfx);
    private static final f pfo = g.ah(a.pfw);
    private static boolean pfp;
    private static boolean pfq;
    public static final f pfr = g.ah(d.pfz);
    private static boolean pfs = true;
    private static final f pft = g.ah(C0856c.pfy);
    private static boolean pfu;
    public static final c pfv = new c();

    public static MultiProcessMMKV cks() {
        AppMethodBeat.i(212464);
        MultiProcessMMKV multiProcessMMKV = (MultiProcessMMKV) pfo.getValue();
        AppMethodBeat.o(212464);
        return multiProcessMMKV;
    }

    public static final String ckv() {
        AppMethodBeat.i(212469);
        String str = (String) pft.getValue();
        AppMethodBeat.o(212469);
        return str;
    }

    static {
        AppMethodBeat.i(212470);
        AppMethodBeat.o(212470);
    }

    private c() {
    }

    private static String ahi(String str) {
        AppMethodBeat.i(212465);
        p.h(str, "$this$crashTimes");
        String concat = "ViewItemCrashTimes_".concat(String.valueOf(str));
        AppMethodBeat.o(212465);
        return concat;
    }

    public static final boolean ckt() {
        return pfp;
    }

    public static final void kc(boolean z) {
        pfp = z;
    }

    public static final boolean cku() {
        return pfq;
    }

    public static final void kd(boolean z) {
        pfq = z;
    }

    public static boolean d(String str, View view) {
        AppMethodBeat.i(212466);
        p.h(str, "viewId");
        int decodeInt = cks().decodeInt(ahi(str));
        if (decodeInt > 2) {
            Log.e("MicroMsg.TestBiz", "PreProcessShowView " + str + " crash too much times(" + decodeInt + "), can not show now!!");
            if (view != null) {
                view.setVisibility(8);
            }
            AppMethodBeat.o(212466);
            return false;
        }
        cks().encode(ahi(str), decodeInt + 1);
        AppMethodBeat.o(212466);
        return true;
    }

    public static void ahj(String str) {
        AppMethodBeat.i(212467);
        p.h(str, "viewId");
        cks().encode(ahi(str), 0);
        AppMethodBeat.o(212467);
    }

    public static boolean a(int i2, long j2, String str, long j3) {
        long j4;
        AppMethodBeat.i(212468);
        p.h(str, "preloadLastTimeKey");
        Log.d("MicroMsg.TestBiz", "do canPreloadNow %d", Long.valueOf(j2));
        if (i2 > 0) {
            if (pfs) {
                com.tencent.mm.plugin.webcanvas.l lVar = com.tencent.mm.plugin.webcanvas.l.IAx;
                com.tencent.mm.plugin.webcanvas.l.LV(j3);
                pfs = false;
            }
            Log.e("MicroMsg.TestBiz", "canPreloadNow hasCrashFlag last time crashTimes=" + i2 + ", defaultInterval=" + j2);
            if (i2 == 1) {
                j4 = 10800000;
            } else {
                j4 = i2 == 2 ? Util.MILLSECONDS_OF_DAY : 604800000;
            }
            if (!BuildInfo.DEBUG) {
                j2 = j4;
            }
        }
        long j5 = cks().getLong(str, 0);
        long currentTimeMillis = System.currentTimeMillis();
        long abs = Math.abs(currentTimeMillis - j5);
        if (abs < j2) {
            Log.d("MicroMsg.TestBiz", "canPreloadNow delta(" + abs + ") < interval(" + j2 + ')');
            AppMethodBeat.o(212468);
            return false;
        }
        cks().encode(str, currentTimeMillis);
        AppMethodBeat.o(212468);
        return true;
    }

    public static final boolean ckw() {
        return pfu;
    }

    public static final void ckx() {
        pfu = true;
    }

    public static final /* synthetic */ MultiProcessMMKV cky() {
        AppMethodBeat.i(212471);
        MultiProcessMMKV multiProcessMMKV = (MultiProcessMMKV) iBW.getValue();
        AppMethodBeat.o(212471);
        return multiProcessMMKV;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "invoke"})
    static final class b extends q implements kotlin.g.a.a<MultiProcessMMKV> {
        public static final b pfx = new b();

        static {
            AppMethodBeat.i(212459);
            AppMethodBeat.o(212459);
        }

        b() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ MultiProcessMMKV invoke() {
            AppMethodBeat.i(212458);
            MultiProcessMMKV singleMMKV = MultiProcessMMKV.getSingleMMKV("brandService");
            AppMethodBeat.o(212458);
            return singleMMKV;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "invoke"})
    static final class a extends q implements kotlin.g.a.a<MultiProcessMMKV> {
        public static final a pfw = new a();

        static {
            AppMethodBeat.i(212457);
            AppMethodBeat.o(212457);
        }

        a() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ MultiProcessMMKV invoke() {
            AppMethodBeat.i(212456);
            MultiProcessMMKV singleMMKV = MultiProcessMMKV.getSingleMMKV("BizViewItemCrash");
            AppMethodBeat.o(212456);
            return singleMMKV;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class d extends q implements kotlin.g.a.a<Boolean> {
        public static final d pfz = new d();

        static {
            AppMethodBeat.i(212463);
            AppMethodBeat.o(212463);
        }

        d() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x004e, code lost:
            if (r0 != false) goto L_0x0050;
         */
        @Override // kotlin.g.a.a
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final /* synthetic */ java.lang.Boolean invoke() {
            /*
                r7 = this;
                r6 = 212462(0x33dee, float:2.97723E-40)
                r1 = 1
                r2 = 0
                com.tencent.matrix.trace.core.AppMethodBeat.i(r6)
                boolean r0 = com.tencent.mm.sdk.platformtools.BuildInfo.DEBUG
                if (r0 != 0) goto L_0x0050
                boolean r0 = com.tencent.mm.sdk.platformtools.BuildInfo.IS_FLAVOR_RED
                if (r0 != 0) goto L_0x0050
                boolean r0 = com.tencent.mm.sdk.platformtools.WeChatEnvironment.hasDebugger()
                if (r0 != 0) goto L_0x0050
                com.tencent.mm.plugin.biz.b.c r0 = com.tencent.mm.plugin.biz.b.c.pfv
                com.tencent.mm.sdk.platformtools.MultiProcessMMKV r0 = com.tencent.mm.plugin.biz.b.c.cky()
                java.lang.String r3 = "BizTimeLineTestMode"
                int r0 = r0.decodeInt(r3, r2)
                if (r0 == r1) goto L_0x0050
                java.lang.Class<com.tencent.mm.plugin.expt.b.b> r0 = com.tencent.mm.plugin.expt.b.b.class
                com.tencent.mm.kernel.c.a r0 = com.tencent.mm.kernel.g.af(r0)
                com.tencent.mm.plugin.expt.b.b r0 = (com.tencent.mm.plugin.expt.b.b) r0
                com.tencent.mm.plugin.expt.b.b$a r3 = com.tencent.mm.plugin.expt.b.b.a.clicfg_open_biz_time_line_test
                int r0 = r0.a(r3, r2)
                if (r0 != r1) goto L_0x0059
                r0 = r1
            L_0x0036:
                java.lang.String r3 = "MicroMsg.TestBiz"
                java.lang.StringBuilder r4 = new java.lang.StringBuilder
                java.lang.String r5 = "test biz open "
                r4.<init>(r5)
                com.tencent.mm.plugin.biz.b.c r5 = com.tencent.mm.plugin.biz.b.c.pfv
                java.lang.StringBuilder r4 = r4.append(r5)
                java.lang.String r4 = r4.toString()
                com.tencent.mm.sdk.platformtools.Log.i(r3, r4)
                if (r0 == 0) goto L_0x0051
            L_0x0050:
                r2 = r1
            L_0x0051:
                java.lang.Boolean r0 = java.lang.Boolean.valueOf(r2)
                com.tencent.matrix.trace.core.AppMethodBeat.o(r6)
                return r0
            L_0x0059:
                r0 = r2
                goto L_0x0036
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.biz.b.c.d.invoke():java.lang.Object");
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.biz.b.c$c  reason: collision with other inner class name */
    static final class C0856c extends q implements kotlin.g.a.a<String> {
        public static final C0856c pfy = new C0856c();

        static {
            AppMethodBeat.i(212461);
            AppMethodBeat.o(212461);
        }

        C0856c() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ String invoke() {
            AppMethodBeat.i(212460);
            String str = com.tencent.mm.loader.j.b.aKJ() + "preloadVideo_debug/videoPrefetcher.js";
            Log.d("MicroMsg.TestBiz", "mpManifestPath = ".concat(String.valueOf(str)));
            AppMethodBeat.o(212460);
            return str;
        }
    }
}
