package com.tencent.mm.storage;

import android.net.Uri;
import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.u;
import com.tencent.mm.al.ag;
import com.tencent.mm.al.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.biz.PluginBiz;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.pluginsdk.ui.tools.z;
import com.tencent.mm.protocal.protobuf.ege;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.storage.r;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.o;

@l(hxD = {1, 1, 16}, hxE = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0006J,\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00182\b\b\u0002\u0010\u001a\u001a\u00020\tH\u0002J \u0010\u001b\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0018J \u0010\u001c\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0018J\u0016\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u001a\u001a\u00020\tJ\u0006\u0010 \u001a\u00020\u0015J \u0010 \u001a\u00020\u00152\u0006\u0010!\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\t2\u0006\u0010\"\u001a\u00020\tH\u0002J\n\u0010#\u001a\u00020\u0004*\u00020\u0004J\n\u0010$\u001a\u00020\u0004*\u00020\u0004J\n\u0010%\u001a\u00020\u0004*\u00020\u0004J\n\u0010&\u001a\u00020\u0004*\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0004\n\u0002\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0019\u0010\n\u001a\n \f*\u0004\u0018\u00010\u000b0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006'"}, hxF = {"Lcom/tencent/mm/storage/BizMainCellExposeHelper;", "", "()V", "TAG", "", "isMainCellHideReportOpen", "", "Ljava/lang/Boolean;", "lastExposeMsgId", "", "mmkv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "getMmkv", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "officialAccountShow", "getOfficialAccountShow", "()Z", "setOfficialAccountShow", "(Z)V", "postDoReportMainCellHide", "", "desc", "pos", "", "unReadCount", "msgId", "reportMainCellExpose", "reportMainCellHide", "setExposeParams", "item", "Lcom/tencent/mm/protocal/protobuf/BizMsgItem;", "updateExposeTime", "slot", "currentTime", "LastExposeTimeKey", "MinExposeIndexKey", "TotalExposeCountKey", "TotalExposeTimeKey", "plugin-biz_release"})
public final class v {
    static volatile boolean NPE;
    private static Boolean NPF;
    static long NPG = -1;
    public static final v NPH = new v();
    private static final MultiProcessMMKV cQe = MultiProcessMMKV.getSingleMMKV("brandService");

    static {
        AppMethodBeat.i(212567);
        AppMethodBeat.o(212567);
    }

    private v() {
    }

    public static final /* synthetic */ void a(v vVar, String str, long j2) {
        AppMethodBeat.i(212568);
        e(str, 0, 0, j2);
        AppMethodBeat.o(212568);
    }

    public static String biQ(String str) {
        AppMethodBeat.i(212557);
        p.h(str, "$this$LastExposeTimeKey");
        String str2 = "lstExpTime_" + str + '}';
        AppMethodBeat.o(212557);
        return str2;
    }

    public static String biR(String str) {
        AppMethodBeat.i(212558);
        p.h(str, "$this$TotalExposeTimeKey");
        String str2 = "totalExpTime_" + str + '}';
        AppMethodBeat.o(212558);
        return str2;
    }

    public static String biS(String str) {
        AppMethodBeat.i(212559);
        p.h(str, "$this$TotalExposeCountKey");
        String str2 = "totalExpCount_" + str + '}';
        AppMethodBeat.o(212559);
        return str2;
    }

    public static String biT(String str) {
        AppMethodBeat.i(212560);
        p.h(str, "$this$MinExposeIndexKey");
        String str2 = "minExpIndex_" + str + '}';
        AppMethodBeat.o(212560);
        return str2;
    }

    public static boolean gAg() {
        return NPE;
    }

    public static void gAh() {
        NPE = true;
    }

    public static MultiProcessMMKV aTI() {
        return cQe;
    }

    public static boolean gAi() {
        AppMethodBeat.i(212561);
        if (BuildInfo.IS_FLAVOR_RED || BuildInfo.DEBUG || WeChatEnvironment.hasDebugger()) {
            AppMethodBeat.o(212561);
            return true;
        } else if (NPF != null) {
            Boolean bool = NPF;
            if (bool == null) {
                p.hyc();
            }
            boolean booleanValue = bool.booleanValue();
            AppMethodBeat.o(212561);
            return booleanValue;
        } else {
            NPF = Boolean.valueOf(((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_open_main_cell_hide_report, 1) == 1);
            Log.i("MicroMsg.BizMainCellExposeHelper", "isMainCellHideReportOpen open " + NPF);
            Boolean bool2 = NPF;
            if (bool2 == null) {
                p.hyc();
            }
            boolean booleanValue2 = bool2.booleanValue();
            AppMethodBeat.o(212561);
            return booleanValue2;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class a implements Runnable {
        final /* synthetic */ int NPI;
        final /* synthetic */ String gZs;
        final /* synthetic */ int prP;

        a(String str, int i2, int i3) {
            this.gZs = str;
            this.NPI = i2;
            this.prP = i3;
        }

        public final void run() {
            int i2;
            z zVar;
            int i3;
            String str;
            int i4;
            long j2;
            AppMethodBeat.i(212555);
            long currentTimeMillis = System.currentTimeMillis();
            v vVar = v.NPH;
            long decodeLong = v.aTI().decodeLong("BizLastMsgId");
            if (decodeLong == 0) {
                AppMethodBeat.o(212555);
                return;
            }
            v vVar2 = v.NPH;
            if (v.gAg()) {
                v vVar3 = v.NPH;
                if (decodeLong == v.NPG) {
                    AppMethodBeat.o(212555);
                    return;
                }
            }
            MultiProcessMMKV multiProcessMMKV = (MultiProcessMMKV) c.iNQ.getSlot();
            v vVar4 = v.NPH;
            if (v.gAg()) {
                v vVar5 = v.NPH;
                if (v.NPG != 0) {
                    v vVar6 = v.NPH;
                    v vVar7 = v.NPH;
                    v.a(vVar6, "", v.NPG);
                }
            }
            v vVar8 = v.NPH;
            v.NPG = decodeLong;
            v vVar9 = v.NPH;
            v.gAh();
            if (multiProcessMMKV.decodeInt(String.valueOf(decodeLong), 0) == 1) {
                i2 = 0;
            } else {
                i2 = 1;
            }
            long j3 = 0;
            int i5 = 0;
            int gBq = ag.gBq();
            String str2 = this.gZs;
            int i6 = this.NPI;
            try {
                z MM = ag.ban().MM(decodeLong);
                if (MM != null || decodeLong >= 0) {
                    zVar = MM;
                } else {
                    zVar = ag.bap().MM(decodeLong);
                }
                if (zVar == null) {
                    AppMethodBeat.o(212555);
                    return;
                }
                int G = af.G(zVar);
                if (zVar.gAt()) {
                    u a2 = ((com.tencent.mm.plugin.biz.a.a) g.af(com.tencent.mm.plugin.biz.a.a.class)).a(zVar.field_msgId, zVar.field_content);
                    if (a2 != null && !Util.isNullOrNil(a2.iAd)) {
                        com.tencent.mm.ag.v vVar10 = (com.tencent.mm.ag.v) a2.iAd.get(0);
                        if (!Util.isNullOrNil(vVar10.url)) {
                            j3 = Util.getLong(Uri.parse(vVar10.url).getQueryParameter("mid"), 0);
                        }
                    }
                    String str3 = zVar.field_talker;
                    p.g(str3, "info.field_talker");
                    i3 = 0;
                    str = str3;
                    i4 = i6;
                } else if (zVar.gAx()) {
                    String I = ag.I(zVar);
                    i5 = ag.f(zVar);
                    String H = ag.H(zVar);
                    int ctM = ag.bap().ctM();
                    Log.v("MicroMsg.BizMainCellExposeHelper", "reportMainCellExpose dyeing template bizUsername = " + I + ", msgType = " + i5);
                    i3 = 0;
                    str = I;
                    i4 = ctM;
                    str2 = H;
                } else if (zVar.gAu()) {
                    ege ege = zVar.NQn;
                    i3 = ege != null ? ege.style : 0;
                    str = "";
                    i4 = i6;
                } else {
                    i3 = 0;
                    str = "";
                    i4 = i6;
                }
                String valueOf = String.valueOf(decodeLong);
                multiProcessMMKV.encode(valueOf, 1);
                v vVar11 = v.NPH;
                multiProcessMMKV.encode(v.biQ(valueOf), currentTimeMillis);
                v vVar12 = v.NPH;
                String biS = v.biS(valueOf);
                v vVar13 = v.NPH;
                multiProcessMMKV.encode(biS, multiProcessMMKV.decodeInt(v.biS(valueOf), 0) + 1);
                v vVar14 = v.NPH;
                String biT = v.biT(valueOf);
                v vVar15 = v.NPH;
                multiProcessMMKV.encode(biT, Math.min(multiProcessMMKV.decodeInt(v.biT(valueOf), this.prP), this.prP));
                String bfG = z.bfG(str2);
                if (i2 == 1) {
                    com.tencent.mm.pluginsdk.c cVar = com.tencent.mm.pluginsdk.c.JSr;
                    boolean z = com.tencent.mm.pluginsdk.c.aTI().getBoolean("biz_time_preload_at_biz_box_expose", false);
                    Log.d("MicroMsg.BizImagePreloadStrategy", "ImageStrategy chatListPreloadEnable %b", Boolean.valueOf(z));
                    if (z) {
                        com.tencent.mm.pluginsdk.c.JSr.glN();
                    }
                }
                com.tencent.mm.plugin.biz.b.a aVar = com.tencent.mm.plugin.biz.b.a.pfl;
                o<String, String> a3 = com.tencent.mm.plugin.biz.b.a.a(zVar);
                r.NPl.ajP(2);
                if (r.uft || !r.gzQ()) {
                    Log.d("MicroMsg.BizCardLogic", "exposePreload hasPreload=" + r.uft + ", canvasPreloadOpen=" + r.gzQ());
                } else {
                    r.uft = true;
                    com.tencent.mm.plugin.webcanvas.l lVar = com.tencent.mm.plugin.webcanvas.l.IAx;
                    com.tencent.mm.plugin.webcanvas.l.LV(14);
                    com.tencent.mm.plugin.biz.b.c cVar2 = com.tencent.mm.plugin.biz.b.c.pfv;
                    int decodeInt = com.tencent.mm.plugin.biz.b.c.cks().decodeInt("biz_canvas_card_expose_preload_crash_times", 0);
                    boolean z2 = BuildInfo.DEBUG || BuildInfo.IS_FLAVOR_RED || WeChatEnvironment.hasDebugger();
                    com.tencent.mm.plugin.biz.b.c cVar3 = com.tencent.mm.plugin.biz.b.c.pfv;
                    if (com.tencent.mm.plugin.biz.b.c.a(decodeInt, z2 ? 0 : 600000, "biz_canvas_card_expose_preload_last_time", 11)) {
                        i iVar = h.RTc;
                        r.f fVar = new r.f(decodeInt);
                        if (System.currentTimeMillis() - PluginBiz.startTime > 20000 || BuildInfo.DEBUG || BuildInfo.IS_FLAVOR_RED) {
                            j2 = 0;
                        } else {
                            j2 = 10000;
                        }
                        iVar.o(fVar, j2);
                    }
                }
                com.tencent.mm.plugin.report.service.h hVar = com.tencent.mm.plugin.report.service.h.INSTANCE;
                Object[] objArr = new Object[17];
                objArr[0] = Integer.valueOf((int) (currentTimeMillis / 1000));
                objArr[1] = str;
                objArr[2] = Long.valueOf(j3);
                objArr[3] = Integer.valueOf(i2);
                objArr[4] = Integer.valueOf(this.prP);
                objArr[5] = bfG;
                objArr[6] = Integer.valueOf(i4);
                objArr[7] = 0;
                objArr[8] = Long.valueOf(currentTimeMillis);
                objArr[9] = Long.valueOf(currentTimeMillis);
                objArr[10] = 0;
                objArr[11] = Integer.valueOf(i5);
                objArr[12] = Integer.valueOf(gBq);
                objArr[13] = a3 != null ? a3.first : null;
                objArr[14] = a3 != null ? a3.second : null;
                objArr[15] = Integer.valueOf(G);
                objArr[16] = Integer.valueOf(i3);
                hVar.a(18218, objArr);
                Log.d("MicroMsg.BizMainCellExposeHelper", "reportMainCellExpose username %s, mid %d, firstTimeExpose %d, pos %d, unReadCountReport %d, currentTime %d, msgId=" + zVar.field_msgId, str, Long.valueOf(j3), Integer.valueOf(i2), Integer.valueOf(this.prP), Integer.valueOf(i4), Long.valueOf(currentTimeMillis));
                AppMethodBeat.o(212555);
            } catch (Exception e2) {
                Log.w("MicroMsg.BizMainCellExposeHelper", "reportMainCellExpose exp %s", e2.getMessage());
                AppMethodBeat.o(212555);
            }
        }
    }

    public static void aO(String str, int i2, int i3) {
        AppMethodBeat.i(212562);
        h.RTc.b(new a(str, i3, i2), "MicroMsg.BizMainCellExposeHelper");
        AppMethodBeat.o(212562);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class b implements Runnable {
        final /* synthetic */ int NPI = 0;
        final /* synthetic */ String gZs;
        final /* synthetic */ int prP = 0;

        b(String str) {
            this.gZs = str;
        }

        public final void run() {
            AppMethodBeat.i(212556);
            v.a(v.NPH, this.gZs, this.prP, this.NPI);
            AppMethodBeat.o(212556);
        }
    }

    public static void biU(String str) {
        AppMethodBeat.i(212563);
        h.RTc.b(new b(str), "MicroMsg.BizMainCellExposeHelper");
        AppMethodBeat.o(212563);
    }

    static /* synthetic */ void a(v vVar, String str, int i2, int i3) {
        AppMethodBeat.i(212565);
        e(str, i2, i3, 0);
        AppMethodBeat.o(212565);
    }

    private static void e(String str, int i2, int i3, long j2) {
        z zVar;
        AppMethodBeat.i(212564);
        if (!NPE) {
            AppMethodBeat.o(212564);
            return;
        }
        NPE = false;
        long currentTimeMillis = System.currentTimeMillis();
        if (j2 == 0) {
            j2 = cQe.decodeLong("BizLastMsgId");
        }
        if (j2 == 0) {
            AppMethodBeat.o(212564);
            return;
        }
        long j3 = 0;
        int i4 = 0;
        int gBq = ag.gBq();
        String str2 = "";
        int i5 = 0;
        try {
            z MM = ag.ban().MM(j2);
            if (MM != null || j2 >= 0) {
                zVar = MM;
            } else {
                zVar = ag.bap().MM(j2);
            }
            if (zVar == null) {
                AppMethodBeat.o(212564);
                return;
            }
            int G = af.G(zVar);
            if (zVar.gAt()) {
                u a2 = ((com.tencent.mm.plugin.biz.a.a) g.af(com.tencent.mm.plugin.biz.a.a.class)).a(zVar.field_msgId, zVar.field_content);
                if (a2 != null && !Util.isNullOrNil(a2.iAd)) {
                    com.tencent.mm.ag.v vVar = (com.tencent.mm.ag.v) a2.iAd.get(0);
                    if (!Util.isNullOrNil(vVar.url)) {
                        j3 = Util.getLong(Uri.parse(vVar.url).getQueryParameter("mid"), 0);
                    }
                }
                String str3 = zVar.field_talker;
                p.g(str3, "info.field_talker");
                str2 = str3;
            } else if (zVar.gAx()) {
                String I = ag.I(zVar);
                i4 = ag.f(zVar);
                str2 = I;
            } else if (zVar.gAu()) {
                ege ege = zVar.NQn;
                i5 = ege != null ? ege.style : 0;
            }
            MultiProcessMMKV multiProcessMMKV = (MultiProcessMMKV) c.iNQ.getSlot();
            long decodeLong = multiProcessMMKV.decodeLong(biQ(String.valueOf(j2)), 0);
            a(multiProcessMMKV, zVar.field_msgId, currentTimeMillis);
            com.tencent.mm.plugin.report.service.h.INSTANCE.a(18218, Integer.valueOf((int) (currentTimeMillis / 1000)), str2, Long.valueOf(j3), 0, Integer.valueOf(i2), str, Integer.valueOf(i3), 1, Long.valueOf(decodeLong), Long.valueOf(currentTimeMillis), 0, Integer.valueOf(i4), Integer.valueOf(gBq), "", "", Integer.valueOf(G), Integer.valueOf(i5));
            Log.d("MicroMsg.BizMainCellExposeHelper", "postDoReportMainCellHide username %s, mid %d, lastExposeTime=%s", str2, Long.valueOf(j3), Long.valueOf(decodeLong));
            AppMethodBeat.o(212564);
        } catch (Exception e2) {
            Log.w("MicroMsg.BizMainCellExposeHelper", "postDoReportMainCellHide exp %s", e2.getMessage());
            AppMethodBeat.o(212564);
        }
    }

    static void a(MultiProcessMMKV multiProcessMMKV, long j2, long j3) {
        AppMethodBeat.i(212566);
        String valueOf = String.valueOf(j2);
        long decodeLong = multiProcessMMKV.decodeLong(biQ(valueOf), 0);
        if (decodeLong > 0 && j3 - decodeLong > 0) {
            long decodeLong2 = (multiProcessMMKV.decodeLong(biR(valueOf), 0) + j3) - decodeLong;
            multiProcessMMKV.encode(biR(valueOf), decodeLong2);
            Log.v("MicroMsg.BizMainCellExposeHelper", "updateExposeTime totalExposeTime=".concat(String.valueOf(decodeLong2)));
        }
        AppMethodBeat.o(212566);
    }
}
