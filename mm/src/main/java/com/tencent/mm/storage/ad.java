package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.u;
import com.tencent.mm.ag.v;
import com.tencent.mm.ak.aa;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.q;
import com.tencent.mm.al.ag;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.ahh;
import com.tencent.mm.protocal.protobuf.dkm;
import com.tencent.mm.protocal.protobuf.dkn;
import com.tencent.mm.protocal.protobuf.ege;
import com.tencent.mm.protocal.protobuf.ow;
import com.tencent.mm.protocal.protobuf.ox;
import com.tencent.mm.protocal.protobuf.oy;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.thumbplayer.core.thirdparties.LocalCache;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.k.j;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0002J\u0012\u0010 \u001a\u00020\u00172\b\u0010!\u001a\u0004\u0018\u00010\"H\u0002J\b\u0010#\u001a\u00020\u0006H\u0002J\b\u0010$\u001a\u00020\u0006H\u0002J\u0006\u0010\r\u001a\u00020\u0006J\u0006\u0010\u000e\u001a\u00020\u0006J\u0006\u0010\u000f\u001a\u00020\u0006J\u001c\u0010%\u001a\u00020\u00172\b\u0010&\u001a\u0004\u0018\u00010\u00042\b\u0010'\u001a\u0004\u0018\u00010(H\u0002J\u000e\u0010)\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019J\u000e\u0010*\u001a\u00020\u00172\u0006\u0010+\u001a\u00020\u0019J\u0018\u0010,\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010!\u001a\u00020\"H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0004\n\u0002\u0010\u0007R\u001b\u0010\b\u001a\u00020\u00068BX\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u0012\u0010\f\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0004\n\u0002\u0010\u0007R\u000e\u0010\r\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0004\n\u0002\u0010\u0007R\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0004\n\u0002\u0010\u0007R#\u0010\u0010\u001a\n \u0012*\u0004\u0018\u00010\u00110\u00118FX\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u000b\u001a\u0004\b\u0013\u0010\u0014¨\u0006-"}, hxF = {"Lcom/tencent/mm/storage/BizTimeLineResortLogic;", "", "()V", "TAG", "", "isBizMsgResort", "", "Ljava/lang/Boolean;", "isBizMsgResortCheckOpen", "()Z", "isBizMsgResortCheckOpen$delegate", "Lkotlin/Lazy;", "isBizMsgResortNew", "isDoingSortBizMsg", "isForeGroundBizMsgResortOpen", "isReceiveMsgResortOpen", "mmkv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "getMmkv", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "mmkv$delegate", "doReSortCgi", "", "fromScene", "", "getResortBizTimeLineInfo", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "groupId", "", "item", "Lcom/tencent/mm/protocal/protobuf/BizMsgItem;", "handleReSortResult", "resp", "Lcom/tencent/mm/protocal/protobuf/BizMsgReSortResp;", "isBizMsgResortNewOpen", "isBizMsgResortOpen", "onReceiveRecCard", "msgContent", "digestInfo", "Lcom/tencent/mm/protocal/protobuf/DigestInfo;", "reSortBizMsg", "reportBizMsgResortIDKey", "value", "saveConfig", "plugin-biz_release"})
public final class ad {
    private static boolean NRh;
    private static Boolean NRi;
    private static Boolean NRj;
    private static final f NRk = g.ah(b.NRr);
    public static Boolean NRl;
    private static Boolean NRm;
    public static final ad NRn = new ad();
    private static final f iBW = g.ah(c.NRs);

    public static MultiProcessMMKV aTI() {
        AppMethodBeat.i(212625);
        MultiProcessMMKV multiProcessMMKV = (MultiProcessMMKV) iBW.getValue();
        AppMethodBeat.o(212625);
        return multiProcessMMKV;
    }

    private static boolean gBj() {
        AppMethodBeat.i(212627);
        boolean booleanValue = ((Boolean) NRk.getValue()).booleanValue();
        AppMethodBeat.o(212627);
        return booleanValue;
    }

    static {
        AppMethodBeat.i(212631);
        AppMethodBeat.o(212631);
    }

    private ad() {
    }

    public static boolean gBi() {
        boolean z;
        AppMethodBeat.i(212626);
        if (BuildInfo.IS_FLAVOR_RED || BuildInfo.DEBUG || WeChatEnvironment.hasDebugger()) {
            AppMethodBeat.o(212626);
            return true;
        } else if (!ab.clc()) {
            AppMethodBeat.o(212626);
            return false;
        } else if (NRi != null) {
            Boolean bool = NRi;
            if (bool == null) {
                p.hyc();
            }
            boolean booleanValue = bool.booleanValue();
            AppMethodBeat.o(212626);
            return booleanValue;
        } else {
            if (((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_open_biz_time_line_resort, 0) == 1) {
                z = true;
            } else {
                z = false;
            }
            NRi = Boolean.valueOf(z);
            Log.i("MicroMsg.BizTimeLineResortLogic", "isBizMsgResortOpen open %b", NRi);
            Boolean bool2 = NRi;
            if (bool2 == null) {
                p.hyc();
            }
            boolean booleanValue2 = bool2.booleanValue();
            AppMethodBeat.o(212626);
            return booleanValue2;
        }
    }

    public static boolean gBk() {
        boolean z;
        AppMethodBeat.i(212628);
        if (BuildInfo.IS_FLAVOR_RED || BuildInfo.DEBUG || WeChatEnvironment.hasDebugger()) {
            AppMethodBeat.o(212628);
            return true;
        } else if (!gBi()) {
            AppMethodBeat.o(212628);
            return false;
        } else if (NRm != null) {
            Boolean bool = NRm;
            if (bool == null) {
                p.hyc();
            }
            boolean booleanValue = bool.booleanValue();
            AppMethodBeat.o(212628);
            return booleanValue;
        } else {
            if (((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_open_biz_time_line_rev_msg_resort, 1) == 1) {
                z = true;
            } else {
                z = false;
            }
            NRm = Boolean.valueOf(z);
            Log.i("MicroMsg.BizTimeLineResortLogic", "isReceiveMsgResortOpen open %b", NRm);
            Boolean bool2 = NRm;
            if (bool2 == null) {
                p.hyc();
            }
            boolean booleanValue2 = bool2.booleanValue();
            AppMethodBeat.o(212628);
            return booleanValue2;
        }
    }

    public static boolean gBl() {
        return NRh;
    }

    public static void ajZ(int i2) {
        AppMethodBeat.i(212629);
        h.INSTANCE.idkeyStat(1130, (long) i2, 1, false);
        AppMethodBeat.o(212629);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class d implements Runnable {
        final /* synthetic */ int pnf;

        d(int i2) {
            this.pnf = i2;
        }

        public final void run() {
            AppMethodBeat.i(212624);
            ad adVar = ad.NRn;
            ad.akb(this.pnf);
            AppMethodBeat.o(212624);
        }
    }

    public static void aka(int i2) {
        AppMethodBeat.i(212630);
        com.tencent.f.h.RTc.b(new d(i2), "MicroMsg.BizTimeLineResortLogic");
        AppMethodBeat.o(212630);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u00052\u000e\u0010\u0007\u001a\n \u0006*\u0004\u0018\u00010\b0\b2\u000e\u0010\t\u001a\n \u0006*\u0004\u0018\u00010\n0\nH\n¢\u0006\u0002\b\u000b"}, hxF = {"<anonymous>", "", "errType", "errCode", "errMsg", "", "kotlin.jvm.PlatformType", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "callback"})
    public static final class a implements aa.a {
        final /* synthetic */ ox NRo;
        final /* synthetic */ LinkedList NRp;
        final /* synthetic */ int pnf;

        a(ox oxVar, LinkedList linkedList, int i2) {
            this.NRo = oxVar;
            this.NRp = linkedList;
            this.pnf = i2;
        }

        @Override // com.tencent.mm.ak.aa.a
        public final int a(int i2, int i3, String str, com.tencent.mm.ak.d dVar, q qVar) {
            AppMethodBeat.i(212619);
            Log.i("MicroMsg.BizTimeLineResortLogic", "doReSortCgi CGI callback errType=%d, errCode=%d, bitFlag=%d, digest_bold_cnt=" + this.NRo.KVJ + ", digest_expose_cnt=" + this.NRo.KVK + ", size=" + this.NRp.size(), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(this.NRo.KVI));
            if (i2 == 0 && i3 == 0) {
                ad adVar = ad.NRn;
                ad.ajZ(1);
                p.g(dVar, "rr");
                com.tencent.mm.bw.a aYK = dVar.aYK();
                if (aYK == null) {
                    t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.BizMsgReSortResp");
                    AppMethodBeat.o(212619);
                    throw tVar;
                }
                final oy oyVar = (oy) aYK;
                ad adVar2 = ad.NRn;
                ad.a(this.pnf, oyVar);
                com.tencent.f.h.RTc.b(new Runnable() {
                    /* class com.tencent.mm.storage.ad.a.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(212618);
                        ad adVar = ad.NRn;
                        ad.a(oyVar);
                        ad adVar2 = ad.NRn;
                        ad.NRh = false;
                        AppMethodBeat.o(212618);
                    }
                }, "MicroMsg.BizTimeLineResortLogic");
                AppMethodBeat.o(212619);
            } else {
                ad adVar3 = ad.NRn;
                ad.ajZ(2);
                ad adVar4 = ad.NRn;
                ad.NRh = false;
                AppMethodBeat.o(212619);
            }
            return 0;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "invoke"})
    static final class c extends kotlin.g.b.q implements kotlin.g.a.a<MultiProcessMMKV> {
        public static final c NRs = new c();

        static {
            AppMethodBeat.i(212623);
            AppMethodBeat.o(212623);
        }

        c() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ MultiProcessMMKV invoke() {
            AppMethodBeat.i(212622);
            MultiProcessMMKV singleMMKV = MultiProcessMMKV.getSingleMMKV("brandService");
            AppMethodBeat.o(212622);
            return singleMMKV;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class b extends kotlin.g.b.q implements kotlin.g.a.a<Boolean> {
        public static final b NRr = new b();

        static {
            AppMethodBeat.i(212621);
            AppMethodBeat.o(212621);
        }

        b() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Boolean invoke() {
            boolean z = true;
            AppMethodBeat.i(212620);
            ad adVar = ad.NRn;
            if (ad.aTI().decodeInt("BizTimeLineReSortMsgCheck", 1) != 1) {
                z = false;
            }
            Boolean valueOf = Boolean.valueOf(z);
            AppMethodBeat.o(212620);
            return valueOf;
        }
    }

    public static final /* synthetic */ void akb(int i2) {
        long max;
        boolean z;
        List<z> ajU;
        long j2;
        int i3;
        boolean z2;
        AppMethodBeat.i(212632);
        if (gBi()) {
            Log.d("MicroMsg.BizTimeLineResortLogic", "doReSortCgi isDoingSortBizMsg=%b, isInTimeLine=%b", Boolean.valueOf(NRh), Boolean.valueOf(ab.NQR));
            if (!NRh) {
                if (ab.NQR) {
                    ajZ(9);
                    AppMethodBeat.o(212632);
                    return;
                }
                long decodeLong = aTI().decodeLong("ReSortBizMsgLastTime", 0);
                if (i2 == ab.NQO) {
                    max = Math.max(aTI().decodeLong("ReSortBizMsgNextForeGroundReqTime", 0), ab.NQP);
                } else {
                    max = Math.max(aTI().decodeLong("ReSortBizMsgNextReqTime", 0), ab.NQQ);
                }
                long currentTimeMillis = System.currentTimeMillis() / 1000;
                if (!gBj() || Math.abs(currentTimeMillis - decodeLong) >= max) {
                    aa ban = ag.ban();
                    p.g(ban, "SubCoreBiz.getBizTimeLineInfoStorage()");
                    z gAM = ban.gAM();
                    if (gAM == null || gAM.field_msgId == 0) {
                        Log.i("MicroMsg.BizTimeLineResortLogic", "handleReSortResult getLastBizTimeLineInfo return null");
                        AppMethodBeat.o(212632);
                        return;
                    }
                    int na = j.na(j.mZ(aTI().decodeInt("ReSortBizMsgReqCount", 10), 5), 100);
                    int na2 = j.na(j.mZ(aTI().decodeInt("ReSortBizMsgMinUnExposedCount", 10), 1), 100);
                    int na3 = j.na(j.mZ(aTI().decodeInt("ReSortBizMsgMinUnReadCount", 1), 0), 100);
                    int mZ = j.mZ(aTI().decodeInt("ReSortBizMsgLimitTime", LocalCache.TIME_DAY), 21600);
                    long j3 = (currentTimeMillis - ((long) mZ)) * 1000;
                    MultiProcessMMKV aTI = aTI();
                    aa ban2 = ag.ban();
                    p.g(ban2, "SubCoreBiz.getBizTimeLineInfoStorage()");
                    aTI.encode("ReSortBizMsgMaxGroupId", ban2.gAS());
                    Log.i("MicroMsg.BizTimeLineResortLogic", "doReSortCgi reqLimit=%d, unReadLimit=%d, unExposedLimit=%d, limitTime=%d", Integer.valueOf(na), Integer.valueOf(na3), Integer.valueOf(na2), Integer.valueOf(mZ));
                    if (BuildInfo.IS_FLAVOR_RED || BuildInfo.DEBUG || WeChatEnvironment.hasDebugger()) {
                        z = true;
                    } else if (NRj != null) {
                        Boolean bool = NRj;
                        if (bool == null) {
                            p.hyc();
                        }
                        z = bool.booleanValue();
                    } else {
                        NRj = Boolean.valueOf(((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_open_biz_time_line_resort_new, 0) == 1);
                        Log.i("MicroMsg.BizTimeLineResortLogic", "isBizMsgResortNew open %b", NRj);
                        Boolean bool2 = NRj;
                        if (bool2 == null) {
                            p.hyc();
                        }
                        z = bool2.booleanValue();
                    }
                    if (z) {
                        ajU = ag.ban().aV(Math.max(na, na2), j3);
                    } else {
                        ajU = ag.ban().ajU(Math.max(na, na2));
                    }
                    LinkedList<ow> linkedList = new LinkedList<>();
                    long j4 = 0;
                    v vVar = v.NPH;
                    MultiProcessMMKV multiProcessMMKV = (MultiProcessMMKV) com.tencent.mm.al.c.iNQ.getSlot();
                    long currentTimeMillis2 = System.currentTimeMillis();
                    if (v.NPE && v.NPG > 0) {
                        v.a(multiProcessMMKV, v.NPG, currentTimeMillis2);
                        multiProcessMMKV.encode(v.biQ(String.valueOf(v.NPG)), currentTimeMillis2);
                    }
                    Iterator<z> it = ajU.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            j2 = j4;
                            break;
                        }
                        z next = it.next();
                        p.g(next, "info");
                        if ((next.gAt() || next.gAu()) && next.field_createTime >= j3) {
                            ow owVar = new ow();
                            owVar.KVy = next.field_bizClientMsgId;
                            owVar.KVE = next.field_msgId;
                            owVar.weight = (int) ab.Na(next.field_orderFlag);
                            owVar.KVz = next.iE(1) ? 1 : 2;
                            owVar.hXs = (int) (next.field_createTime / 1000);
                            owVar.cSx = (next.field_hasShow == 1 ? 1 : 0) | (next.field_isRead == 1 ? 2 : 0);
                            if (next.gAt()) {
                                try {
                                    u a2 = ((com.tencent.mm.plugin.biz.a.a) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.biz.a.a.class)).a(next.field_msgId, next.field_content);
                                    if (a2 != null && !Util.isNullOrNil(a2.iAd)) {
                                        owVar.url = ((v) a2.iAd.get(0)).url;
                                        owVar.KIJ = ((v) a2.iAd.get(0)).type;
                                    }
                                } catch (Exception e2) {
                                }
                                owVar.nHh = af.G(next);
                            } else if (next.gAu()) {
                                ege gAD = next.gAD();
                                p.g(gAD, "wrapper");
                                p.h(gAD, "$this$isUnderLineMsg");
                                if (gAD.MOD == 2) {
                                    z2 = true;
                                } else {
                                    z2 = false;
                                }
                                if (!z2) {
                                    if (gAD.style != 1001 || gAD.Ngc == null) {
                                        af.a(next, owVar);
                                    } else {
                                        owVar.KUp = gAD.dSJ;
                                    }
                                    owVar.nHh = af.G(next);
                                } else {
                                    j2 = j4;
                                    j4 = j2;
                                }
                            } else {
                                continue;
                            }
                            v vVar2 = v.NPH;
                            long j5 = next.field_msgId;
                            p.h(owVar, "item");
                            MultiProcessMMKV multiProcessMMKV2 = (MultiProcessMMKV) com.tencent.mm.al.c.iNQ.getSlot();
                            String valueOf = String.valueOf(j5);
                            owVar.KVA = multiProcessMMKV2.decodeInt(valueOf) == 1 ? 1 : 0;
                            owVar.KVB = multiProcessMMKV2.decodeInt(v.biS(valueOf), 0);
                            owVar.KVC = multiProcessMMKV2.decodeInt(v.biR(valueOf), 0);
                            owVar.KVD = multiProcessMMKV2.decodeInt(v.biT(valueOf), 0);
                            Log.d("setExposeParams", "setExposeParams digest_exposure=" + owVar.KVA + ',' + " digest_exposure_cnt=" + owVar.KVB + ',' + " digest_exposure_period=" + owVar.KVC + ',' + " digest_exposure_pos=" + owVar.KVD);
                            if (next.field_orderFlag > j4) {
                                j2 = next.field_orderFlag;
                            } else {
                                j2 = j4;
                            }
                            linkedList.add(owVar);
                            w wVar = w.NPK;
                            p.h(owVar, "item");
                            p.h(next, "info");
                            if (w.gAk()) {
                                if (((long) owVar.weight) != next.gAp()) {
                                    w.biV("checkReqData weight invalid!");
                                }
                                if ((owVar.KVz == 1 && !next.iE(1)) || (owVar.KVz != 1 && next.iE(1))) {
                                    w.biV("checkReqData show big pic flag invalid!");
                                }
                                if (next.field_isRead != 0) {
                                    w.biV("checkReqData Msg has exposed!");
                                }
                                if (((long) owVar.hXs) < j3 / 1000) {
                                    w.biV("CheckReqData Msg time invalid!");
                                }
                            }
                            if (linkedList.size() >= na) {
                                break;
                            }
                            j4 = j2;
                        }
                    }
                    if (Util.isNullOrNil(linkedList)) {
                        Log.i("MicroMsg.BizTimeLineResortLogic", "doReSortCgi reqMsg is empty");
                        AppMethodBeat.o(212632);
                        return;
                    }
                    w wVar2 = w.NPK;
                    if (na < linkedList.size()) {
                        w.biV("checkReqLimit reqLimit check fail!");
                    }
                    int i4 = 0;
                    int i5 = 0;
                    for (z zVar : ajU) {
                        if (zVar.field_hasShow != 1) {
                            i4++;
                        }
                        if (zVar.field_isRead != 1) {
                            i3 = i5 + 1;
                        } else {
                            i3 = i5;
                        }
                        i5 = i3;
                    }
                    if (gBj()) {
                        if (i4 < na3) {
                            Log.i("MicroMsg.BizTimeLineResortLogic", "doReSortCgi unReadLimit return %d", Integer.valueOf(i4));
                            AppMethodBeat.o(212632);
                            return;
                        } else if (i5 < na2) {
                            Log.i("MicroMsg.BizTimeLineResortLogic", "doReSortCgi unExposedLimit return %d", Integer.valueOf(i5));
                            AppMethodBeat.o(212632);
                            return;
                        }
                    }
                    d.a aVar = new d.a();
                    aVar.c(new ox());
                    aVar.d(new oy());
                    aVar.MB("/cgi-bin/mmbiz-bin/timeline/bizmsgresort");
                    aVar.sG(2818);
                    com.tencent.mm.ak.d aXF = aVar.aXF();
                    p.g(aXF, "rr");
                    com.tencent.mm.bw.a aYJ = aXF.aYJ();
                    if (aYJ == null) {
                        t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.BizMsgReSortReq");
                        AppMethodBeat.o(212632);
                        throw tVar;
                    }
                    ox oxVar = (ox) aYJ;
                    oxVar.KVH = linkedList;
                    oxVar.scene = i2;
                    oxVar.KVI = 0;
                    if (gAM.field_orderFlag <= j2) {
                        oxVar.KVI |= 1;
                    }
                    com.tencent.mm.plugin.biz.b.a aVar2 = com.tencent.mm.plugin.biz.b.a.pfl;
                    p.h(oxVar, "req");
                    MultiProcessMMKV multiProcessMMKV3 = (MultiProcessMMKV) com.tencent.mm.al.c.iNQ.getSlot();
                    String valueOf2 = String.valueOf(System.currentTimeMillis() / 43200000);
                    String valueOf3 = String.valueOf((System.currentTimeMillis() - 43200000) / 43200000);
                    oxVar.KVJ = multiProcessMMKV3.decodeInt(com.tencent.mm.plugin.biz.b.a.ahg(valueOf2), 0) + multiProcessMMKV3.decodeInt(com.tencent.mm.plugin.biz.b.a.ahg(valueOf3), 0);
                    oxVar.KVK = multiProcessMMKV3.decodeInt(com.tencent.mm.plugin.biz.b.a.ahf(valueOf3), 0) + multiProcessMMKV3.decodeInt(com.tencent.mm.plugin.biz.b.a.ahf(valueOf2), 0);
                    NRh = true;
                    aTI().encode("ReSortBizMsgLastTime", System.currentTimeMillis() / 1000);
                    aa.a(aXF, new a(oxVar, linkedList, i2));
                    ajZ(0);
                } else {
                    Log.i("MicroMsg.BizTimeLineResortLogic", "doReSortCgi return currentTime:%d, lastReSortBizMsgTime:%d, timePast:%d, minReSortBizMsgGap:%d", Long.valueOf(currentTimeMillis), Long.valueOf(decodeLong), Long.valueOf(currentTimeMillis - decodeLong), Long.valueOf(max));
                    AppMethodBeat.o(212632);
                    return;
                }
            }
        }
        AppMethodBeat.o(212632);
    }

    public static final /* synthetic */ void a(int i2, oy oyVar) {
        AppMethodBeat.i(212633);
        if (i2 == ab.NQO) {
            aTI().encode("ReSortBizMsgNextForeGroundReqTime", oyVar.KVL);
        } else {
            aTI().encode("ReSortBizMsgNextReqTime", oyVar.KVL);
        }
        aTI().encode("ReSortBizMsgMinUnExposedCount", oyVar.KVM);
        aTI().encode("ReSortBizMsgMinUnReadCount", oyVar.KVN);
        aTI().encode("ReSortBizMsgLimitTime", oyVar.KVO);
        aTI().encode("ReSortBizMsgReqCount", oyVar.KUq);
        dkm dkm = oyVar.KVS;
        if (dkm != null) {
            aTI().encode("RecCardMaxKeepMsgCount", dkm.MOq);
            aTI().encode("RecCardMinNewMsgCount", dkm.MOp);
            AppMethodBeat.o(212633);
            return;
        }
        AppMethodBeat.o(212633);
    }

    public static final /* synthetic */ void a(oy oyVar) {
        z zVar;
        int a2;
        AppMethodBeat.i(212634);
        if (ab.NQR || oyVar == null) {
            Log.w("MicroMsg.BizTimeLineResortLogic", "handleReSortResult is isInTimeLine now");
            ajZ(8);
            AppMethodBeat.o(212634);
            return;
        }
        boolean z = ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_open_timeline_resort_recommend_card, 1) == 1;
        Log.i("MicroMsg.BizTimeLineResortLogic", "handleReSortResult insertCard = %s", Boolean.valueOf(z));
        if (z && !Util.isNullOrNil(oyVar.KVR)) {
            Log.i("MicroMsg.BizTimeLineResortLogic", "handleReSortResult recommend_article_info size = %s", Integer.valueOf(oyVar.KVR.size()));
            LinkedList<dkn> linkedList = oyVar.KVR;
            if (linkedList != null) {
                for (T t : linkedList) {
                    String str = t.xml;
                    ahh ahh = t.KVG;
                    if (!(str == null || !com.tencent.mm.kernel.g.aAc() || (a2 = n.a((CharSequence) str, "<sysmsg", 0, false, 6)) == -1)) {
                        String substring = str.substring(a2);
                        p.g(substring, "(this as java.lang.String).substring(startIndex)");
                        Map<String, String> parseXml = XmlParser.parseXml(substring, "sysmsg", null);
                        if (parseXml == null) {
                            Log.e("MicroMsg.BizTimeLineResortLogic", "XmlParser values is null, msgContent %s", str);
                        } else if (af.bU(parseXml)) {
                            if (af.gBp()) {
                                if (Util.getInt(parseXml.get(".sysmsg.BizRecommendExpt.RedDotFlag"), -1) == 2) {
                                    ac acVar = ac.NRc;
                                    ac.bjb(str);
                                    ac acVar2 = ac.NRc;
                                    ac.Nd(0);
                                } else {
                                    ege bV = af.bV(parseXml);
                                    if (bV != null) {
                                        if (!af.b(bV, (z) null)) {
                                            Log.i("MicroMsg.BizTimeLineResortLogic", "[TRACE_BIZRECCARD] onBizRecommendExpt illegal");
                                        } else {
                                            z f2 = af.f(bV);
                                            if (f2 != null) {
                                                com.tencent.mm.plugin.biz.b.a aVar = com.tencent.mm.plugin.biz.b.a.pfl;
                                                com.tencent.mm.plugin.biz.b.a.a(ahh, f2);
                                            }
                                        }
                                    }
                                }
                            }
                        } else if (Util.getInt(parseXml.get(".sysmsg.BizAccountRecommend.RedDotFlag"), -1) == 2) {
                            ac acVar3 = ac.NRc;
                            ac.bjb(str);
                            ac acVar4 = ac.NRc;
                            ac.Nd(1);
                        } else {
                            z X = ab.X(str, parseXml);
                            if (X != null) {
                                com.tencent.mm.plugin.biz.b.a aVar2 = com.tencent.mm.plugin.biz.b.a.pfl;
                                com.tencent.mm.plugin.biz.b.a.a(ahh, X);
                            }
                        }
                    }
                }
            }
        }
        LinkedList<ow> linkedList2 = oyVar.KVP;
        Log.i("MicroMsg.BizTimeLineResortLogic", "handleReSortResult size %d, replaceExposureTime %d, rank_sessionid %s", Integer.valueOf(linkedList2.size()), Integer.valueOf(oyVar.KVQ), oyVar.KVe);
        if (Util.isNullOrNil(linkedList2)) {
            ajZ(4);
            Log.w("MicroMsg.BizTimeLineResortLogic", "handleReSortResult items is null");
            AppMethodBeat.o(212634);
            return;
        }
        ajZ(5);
        Log.i("MicroMsg.BizTimeLineResortLogic", "handleReSortResult");
        aa ban = ag.ban();
        p.g(ban, "SubCoreBiz.getBizTimeLineInfoStorage()");
        if (ban.gAR() <= 0) {
            Log.i("MicroMsg.BizTimeLineResortLogic", "handleReSortResult no redDot");
            ajZ(10);
            AppMethodBeat.o(212634);
            return;
        }
        aa ban2 = ag.ban();
        p.g(ban2, "SubCoreBiz.getBizTimeLineInfoStorage()");
        long gAS = ban2.gAS();
        if (gAS != aTI().decodeLong("ReSortBizMsgMaxGroupId", 0)) {
            ajZ(11);
            Log.w("MicroMsg.BizTimeLineResortLogic", "handleReSortResult MsgMaxGroupId has changed!");
            AppMethodBeat.o(212634);
            return;
        }
        LinkedList linkedList3 = new LinkedList();
        Iterator<ow> it = linkedList2.iterator();
        while (it.hasNext()) {
            ow next = it.next();
            if (next == null) {
                zVar = null;
            } else {
                z MM = Util.isNullOrNil(next.KVy) ? ag.ban().MM(next.KVE) : ag.ban().biX(next.KVy);
                if (MM == null || MM.field_msgId == 0) {
                    Log.w("MicroMsg.BizTimeLineResortLogic", "getResortBizTimeLineInfo msg not found");
                    zVar = null;
                } else if (MM.field_isRead == 1) {
                    Log.w("MicroMsg.BizTimeLineResortLogic", "getResortBizTimeLineInfo msg is read");
                    zVar = null;
                } else if (System.currentTimeMillis() - MM.field_createTime > 604800000) {
                    Log.w("MicroMsg.BizTimeLineResortLogic", "getResortBizTimeLineInfo too old msg %d", Long.valueOf(MM.field_createTime));
                    zVar = null;
                } else {
                    if (MM.gAo() != gAS) {
                        MM.NQl = true;
                    }
                    MM.field_orderFlag = ab.aE(gAS, MM.field_createTime / 1000) | ((((long) next.weight) << 24) & 4278190080L) | (gAS << 32);
                    ab.E(MM);
                    if (next.KVz == 1) {
                        MM.iF(1);
                    } else {
                        MM.gAK();
                    }
                    MM.iF(1073741824);
                    Log.i("MicroMsg.BizTimeLineResortLogic", "getResortBizTimeLineInfo bizclientmsgid:%s msgid:%d pic_type:%d biz_flag:%d cardType:%d, weight:%d", next.KVy, Long.valueOf(next.KVE), Integer.valueOf(next.KVz), Integer.valueOf(MM.field_bitFlag), Integer.valueOf(next.nHh), Integer.valueOf(next.weight));
                    w wVar = w.NPK;
                    p.h(next, "item");
                    p.h(MM, "info");
                    if (w.gAk()) {
                        if (((long) next.weight) != MM.gAp()) {
                            w.biV("checkRespData weight invalid!");
                        }
                        if ((next.KVz == 1 && !MM.iE(1)) || (next.KVz != 1 && MM.iE(1))) {
                            w.biV("checkRespData show big pic flag invalid!");
                        }
                        if (!MM.iE(1073741824)) {
                            w.biV("checkRespData resort flag invalid!");
                        }
                        if (MM.field_isRead != 0) {
                            w.biV("CheckRespProcessedData Msg has exposed!");
                        }
                        if (System.currentTimeMillis() - MM.field_createTime > 604800000) {
                            w.biV("CheckRespProcessedData time invalid!");
                        }
                    }
                    zVar = MM;
                }
            }
            if (zVar != null) {
                zVar.field_rankSessionId = oyVar.KVe;
                linkedList3.add(zVar);
                com.tencent.mm.plugin.biz.b.a aVar3 = com.tencent.mm.plugin.biz.b.a.pfl;
                p.g(next, "item");
                p.h(next, "item");
                p.h(zVar, "info");
                String ahe = com.tencent.mm.plugin.biz.b.a.ahe(new StringBuilder().append(zVar.field_msgId).append('-').append(zVar.field_createTime).toString());
                MultiProcessMMKV multiProcessMMKV = (MultiProcessMMKV) com.tencent.mm.al.c.iNQ.getSlot();
                if (next.KVG == null || Util.isNullOrNil(next.KVG.KEQ)) {
                    if (multiProcessMMKV.containsKey(ahe)) {
                        multiProcessMMKV.removeValueForKey(ahe);
                        Log.i("MicroMsg.BizDigestUtil", "saveWebViewAlbumInfoInfo remove " + zVar.field_msgId + "  " + zVar.field_bizClientMsgId);
                    }
                } else if ((next.cSx & 1) == 0 || !multiProcessMMKV.containsKey(ahe)) {
                    Log.i("MicroMsg.BizDigestUtil", "saveWebViewAlbumInfoInfo " + zVar.field_msgId + "  " + zVar.field_bizClientMsgId);
                    ahh ahh2 = next.KVG;
                    p.g(ahh2, "item.digest_info");
                    com.tencent.mm.plugin.biz.b.a.a(ahe, ahh2, multiProcessMMKV);
                } else {
                    Log.d("MicroMsg.BizDigestUtil", "saveWebViewAlbumInfoInfo not update " + zVar.field_msgId + "  " + zVar.field_bizClientMsgId);
                }
            }
        }
        Log.i("MicroMsg.BizTimeLineResortLogic", "handleReSortResult new size %d", Integer.valueOf(linkedList3.size()));
        if (!Util.isNullOrNil(linkedList3)) {
            ajZ(7);
            if (ab.NQR) {
                Log.i("MicroMsg.BizTimeLineResortLogic", "batResortBizTimeLineInfo isInTimeLine just return");
                AppMethodBeat.o(212634);
                return;
            }
            ag.ban().iD(linkedList3);
            com.tencent.mm.pluginsdk.c cVar = com.tencent.mm.pluginsdk.c.JSr;
            if (com.tencent.mm.pluginsdk.c.glJ()) {
                com.tencent.mm.pluginsdk.c cVar2 = com.tencent.mm.pluginsdk.c.JSr;
                if (com.tencent.mm.pluginsdk.c.glK()) {
                    Log.i("MicroMsg.BizTimeLineResortLogic", "BizImagePreloadStrategy preload after resort");
                    com.tencent.mm.pluginsdk.c.JSr.glO();
                }
            }
            r.NPl.ajP(1);
            AppMethodBeat.o(212634);
            return;
        }
        ajZ(6);
        AppMethodBeat.o(212634);
    }
}
