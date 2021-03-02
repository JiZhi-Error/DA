package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.aa;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.q;
import com.tencent.mm.al.ag;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.protocal.protobuf.dli;
import com.tencent.mm.protocal.protobuf.dlk;
import com.tencent.mm.protocal.protobuf.dll;
import com.tencent.mm.protocal.protobuf.dlm;
import com.tencent.mm.protocal.protobuf.dln;
import com.tencent.mm.protocal.protobuf.dlo;
import com.tencent.mm.protocal.protobuf.ege;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMKVSlotManager;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001:\u0003+,-B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u000e\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#J\u001c\u0010$\u001a\u00020!2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020'0&2\u0006\u0010\"\u001a\u00020#J\u0010\u0010(\u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0002J\u000e\u0010)\u001a\u00020!2\u0006\u0010*\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8FX\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u001a\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0012\u001a\u00020\u000e8BX\u0002¢\u0006\f\n\u0004\b\u0013\u0010\f\u001a\u0004\b\u0012\u0010\u000fR#\u0010\u0014\u001a\n \u0016*\u0004\u0018\u00010\u00150\u00158FX\u0002¢\u0006\f\n\u0004\b\u0019\u0010\f\u001a\u0004\b\u0017\u0010\u0018R\u001b\u0010\u001a\u001a\u00020\u000e8BX\u0002¢\u0006\f\n\u0004\b\u001c\u0010\f\u001a\u0004\b\u001b\u0010\u000f¨\u0006."}, hxF = {"Lcom/tencent/mm/storage/BizRecycleCardLogic;", "", "()V", "DEFAULT_INTERVAL", "", "TAG", "", "cardRecycleSlot", "Lcom/tencent/mm/sdk/platformtools/MMKVSlotManager;", "getCardRecycleSlot", "()Lcom/tencent/mm/sdk/platformtools/MMKVSlotManager;", "cardRecycleSlot$delegate", "Lkotlin/Lazy;", "isRecycleCard", "", "()Z", "setRecycleCard", "(Z)V", "isRecycleCardCheckOpen", "isRecycleCardCheckOpen$delegate", "mmkv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "getMmkv", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "mmkv$delegate", "recycleCardOpen", "getRecycleCardOpen", "recycleCardOpen$delegate", "checkRecycleReportStatus", "info", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "doRecycleCard", "", "fromScene", "Lcom/tencent/mm/storage/BizRecycleCardLogic$RecycleCardScene;", "handleRecycleCardResult", "list", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/RecycleCard;", "recycleCard", "reportIdKey", "key", "RecycleCardFlag", "RecycleCardScene", "RecycleCardStatus", "plugin-biz_release"})
public final class y {
    private static final kotlin.f NPL = kotlin.g.ah(d.NQb);
    private static final kotlin.f NPM = kotlin.g.ah(j.NQi);
    private static final kotlin.f NPN = kotlin.g.ah(g.NQe);
    private static boolean NPO;
    public static final y NPP = new y();
    private static final kotlin.f iBW = kotlin.g.ah(h.NQf);

    public static MultiProcessMMKV aTI() {
        AppMethodBeat.i(212595);
        MultiProcessMMKV multiProcessMMKV = (MultiProcessMMKV) iBW.getValue();
        AppMethodBeat.o(212595);
        return multiProcessMMKV;
    }

    private static MMKVSlotManager gAl() {
        AppMethodBeat.i(212594);
        MMKVSlotManager mMKVSlotManager = (MMKVSlotManager) NPL.getValue();
        AppMethodBeat.o(212594);
        return mMKVSlotManager;
    }

    private static boolean gAm() {
        AppMethodBeat.i(212596);
        boolean booleanValue = ((Boolean) NPN.getValue()).booleanValue();
        AppMethodBeat.o(212596);
        return booleanValue;
    }

    static {
        AppMethodBeat.i(212601);
        AppMethodBeat.o(212601);
    }

    private y() {
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, hxF = {"Lcom/tencent/mm/storage/BizRecycleCardLogic$RecycleCardFlag;", "", "flag", "", "(Ljava/lang/String;II)V", "getFlag", "()I", "RECYCLE_CARD_FLAG_NORMAL", "RECYCLE_CARD_FLAG_DEL", "plugin-biz_release"})
    public enum a {
        RECYCLE_CARD_FLAG_NORMAL(1),
        RECYCLE_CARD_FLAG_DEL(2);
        
        final int cSx;

        public static a valueOf(String str) {
            AppMethodBeat.i(212574);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(212574);
            return aVar;
        }

        private a(int i2) {
            this.cSx = i2;
        }

        static {
            AppMethodBeat.i(212572);
            AppMethodBeat.o(212572);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, hxF = {"Lcom/tencent/mm/storage/BizRecycleCardLogic$RecycleCardScene;", "", "scene", "", "(Ljava/lang/String;II)V", "getScene", "()I", "RECYCLE_CARD_SCENE_NEW_MSG", "RECYCLE_CARD_SCENE_ENTER_BOX", "RECYCLE_CARD_SCENE_FEEDBACK", "plugin-biz_release"})
    public enum b {
        RECYCLE_CARD_SCENE_NEW_MSG(1),
        RECYCLE_CARD_SCENE_ENTER_BOX(2),
        RECYCLE_CARD_SCENE_FEEDBACK(3);
        
        final int scene;

        public static b valueOf(String str) {
            AppMethodBeat.i(212577);
            b bVar = (b) Enum.valueOf(b.class, str);
            AppMethodBeat.o(212577);
            return bVar;
        }

        private b(int i2) {
            this.scene = i2;
        }

        static {
            AppMethodBeat.i(212575);
            AppMethodBeat.o(212575);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, hxF = {"Lcom/tencent/mm/storage/BizRecycleCardLogic$RecycleCardStatus;", "", "status", "", "(Ljava/lang/String;II)V", "getStatus", "()I", "RECYCLE_CARD_STATUS_CARD_EXPOSURE", "RECYCLE_CARD_STATUS_DIGEST_EXPOSURE", "RECYCLE_CARD_STATUS_NEWEST_CARD", "plugin-biz_release"})
    public enum c {
        RECYCLE_CARD_STATUS_CARD_EXPOSURE(1),
        RECYCLE_CARD_STATUS_DIGEST_EXPOSURE(2),
        RECYCLE_CARD_STATUS_NEWEST_CARD(3);
        
        final int status;

        public static c valueOf(String str) {
            AppMethodBeat.i(212580);
            c cVar = (c) Enum.valueOf(c.class, str);
            AppMethodBeat.o(212580);
            return cVar;
        }

        private c(int i2) {
            this.status = i2;
        }

        static {
            AppMethodBeat.i(212578);
            AppMethodBeat.o(212578);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class e implements Runnable {
        final /* synthetic */ b NQc;

        e(b bVar) {
            this.NQc = bVar;
        }

        public final void run() {
            AppMethodBeat.i(212583);
            y yVar = y.NPP;
            y.b(this.NQc);
            AppMethodBeat.o(212583);
        }
    }

    public static void a(b bVar) {
        AppMethodBeat.i(212597);
        p.h(bVar, "fromScene");
        com.tencent.f.h.RTc.a(new e(bVar), 1000, "BizRecycleCardLogic");
        AppMethodBeat.o(212597);
    }

    public static void gAn() {
        NPO = false;
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u00052\u000e\u0010\u0007\u001a\n \u0006*\u0004\u0018\u00010\b0\b2\u000e\u0010\t\u001a\n \u0006*\u0004\u0018\u00010\n0\nH\n¢\u0006\u0002\b\u000b"}, hxF = {"<anonymous>", "", "errType", "errCode", "errMsg", "", "kotlin.jvm.PlatformType", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "callback"})
    public static final class i implements aa.a {
        final /* synthetic */ b NQc;

        i(b bVar) {
            this.NQc = bVar;
        }

        @Override // com.tencent.mm.ak.aa.a
        public final int a(int i2, int i3, String str, com.tencent.mm.ak.d dVar, q qVar) {
            AppMethodBeat.i(212591);
            y yVar = y.NPP;
            y.aTI().encode("RecycleCardLastTime", System.currentTimeMillis() / 1000);
            if (i2 == 0 && i3 == 0) {
                p.g(dVar, "rr");
                final dlo dlo = (dlo) dVar.aYK();
                if (dlo == null) {
                    y yVar2 = y.NPP;
                    y.gAn();
                    AppMethodBeat.o(212591);
                } else {
                    y yVar3 = y.NPP;
                    y.aTI().encode("RecycleCardInterval", dlo.KVL);
                    y yVar4 = y.NPP;
                    y.aTI().encode("RecycleCardMaxMsgCount", dlo.KUq);
                    com.tencent.mm.ac.d.b("BizRecycleCardLogic", new kotlin.g.a.a<x>(this) {
                        /* class com.tencent.mm.storage.y.i.AnonymousClass1 */
                        final /* synthetic */ i NQg;

                        {
                            this.NQg = r2;
                        }

                        /* Return type fixed from 'java.lang.Object' to match base method */
                        @Override // kotlin.g.a.a
                        public final /* synthetic */ x invoke() {
                            AppMethodBeat.i(212590);
                            y yVar = y.NPP;
                            LinkedList<dli> linkedList = dlo.gCs;
                            p.g(linkedList, "resp.list");
                            y.a(linkedList, this.NQg.NQc);
                            y yVar2 = y.NPP;
                            y.gAn();
                            x xVar = x.SXb;
                            AppMethodBeat.o(212590);
                            return xVar;
                        }
                    });
                    AppMethodBeat.o(212591);
                }
            } else {
                y yVar5 = y.NPP;
                y.gAn();
                AppMethodBeat.o(212591);
            }
            return 0;
        }
    }

    public static void a(LinkedList<dli> linkedList, b bVar) {
        int i2;
        AppMethodBeat.i(212598);
        p.h(linkedList, "list");
        p.h(bVar, "fromScene");
        if (linkedList.isEmpty()) {
            Log.i("MicroMsg.BizRecycleCardLogic", "handleRecycleCardResult list is empty");
            AppMethodBeat.o(212598);
            return;
        }
        LinkedList<dlk> linkedList2 = new LinkedList<>();
        if (bVar == b.RECYCLE_CARD_SCENE_FEEDBACK) {
            ArrayList<dli> arrayList = new ArrayList();
            for (T t : linkedList) {
                T t2 = t;
                Log.d("MicroMsg.BizRecycleCardLogic", "handleRecycleCardResult flag " + t2.cSx);
                if (t2.cSx == a.RECYCLE_CARD_FLAG_DEL.cSx) {
                    arrayList.add(t);
                }
            }
            for (dli dli : arrayList) {
                z MM = ag.ban().MM(dli.KVE);
                if (MM != null && MM.gAu()) {
                    dlk dlk = new dlk();
                    ege gAD = MM.gAD();
                    dlk.KUp = gAD != null ? gAD.dSJ : null;
                    dlk.KVE = dli.KVE;
                    dlk.MPh = dli.MPh;
                    linkedList2.add(dlk);
                    ag.ban().MX(dli.KVE);
                    Log.i("MicroMsg.BizRecycleCardLogic", "handleRecycleCardResult ok " + MM.field_msgId);
                    Bt(12);
                }
            }
        } else {
            aa ban = ag.ban();
            p.g(ban, "SubCoreBiz.getBizTimeLineInfoStorage()");
            z gAN = ban.gAN();
            MultiProcessMMKV multiProcessMMKV = (MultiProcessMMKV) com.tencent.mm.al.c.iNQ.getSlot();
            ArrayList<dli> arrayList2 = new ArrayList();
            for (T t3 : linkedList) {
                T t4 = t3;
                Log.d("MicroMsg.BizRecycleCardLogic", "handleRecycleCardResult flag " + t4.cSx);
                if (t4.cSx == a.RECYCLE_CARD_FLAG_DEL.cSx) {
                    arrayList2.add(t3);
                }
            }
            for (dli dli2 : arrayList2) {
                z MM2 = ag.ban().MM(dli2.KVE);
                if (MM2 != null && MM2.gAu()) {
                    if (MM2.field_isRead != 1 || !gAm()) {
                        if (multiProcessMMKV.decodeInt(String.valueOf(MM2.field_msgId), 0) != 1 || !gAm()) {
                            if (MM2.field_msgId != gAN.field_msgId || !gAm()) {
                                ag.ban().MX(dli2.KVE);
                                Log.i("MicroMsg.BizRecycleCardLogic", "handleRecycleCardResult ok " + MM2.field_msgId);
                                Bt(4);
                                dlk dlk2 = new dlk();
                                ege gAD2 = MM2.gAD();
                                dlk2.KUp = gAD2 != null ? gAD2.dSJ : null;
                                dlk2.KVE = dli2.KVE;
                                dlk2.MPh = dli2.MPh;
                                linkedList2.add(dlk2);
                                ege gAD3 = MM2.gAD();
                                if (gAD3 != null && gAD3.MOD == 2) {
                                    ac acVar = ac.NRc;
                                    ac.Nd(20);
                                }
                            } else if (A(MM2)) {
                                Bt(3);
                                s sVar = s.NPC;
                                int i3 = c.RECYCLE_CARD_STATUS_NEWEST_CARD.status;
                                ege gAD4 = MM2.gAD();
                                s.di(i3, gAD4 != null ? gAD4.dSJ : null);
                                Log.i("MicroMsg.BizRecycleCardLogic", "handleRecycleCardResult msg is newest card " + MM2.field_msgId);
                            } else {
                                Log.d("MicroMsg.BizRecycleCardLogic", "handleRecycleCardResult msg is newest card " + MM2.field_msgId);
                            }
                        } else if (A(MM2)) {
                            Bt(2);
                            s sVar2 = s.NPC;
                            int i4 = c.RECYCLE_CARD_STATUS_DIGEST_EXPOSURE.status;
                            ege gAD5 = MM2.gAD();
                            s.di(i4, gAD5 != null ? gAD5.dSJ : null);
                            Log.i("MicroMsg.BizRecycleCardLogic", "handleRecycleCardResult msg digest IsRead " + MM2.field_msgId);
                        } else {
                            Log.d("MicroMsg.BizRecycleCardLogic", "handleRecycleCardResult msg digest IsRead " + MM2.field_msgId);
                        }
                    } else if (A(MM2)) {
                        Bt(1);
                        s sVar3 = s.NPC;
                        int i5 = c.RECYCLE_CARD_STATUS_CARD_EXPOSURE.status;
                        ege gAD6 = MM2.gAD();
                        s.di(i5, gAD6 != null ? gAD6.dSJ : null);
                        Log.i("MicroMsg.BizRecycleCardLogic", "handleRecycleCardResult msgIsRead " + MM2.field_msgId);
                    } else {
                        Log.d("MicroMsg.BizRecycleCardLogic", "handleRecycleCardResult msgIsRead " + MM2.field_msgId);
                    }
                }
            }
        }
        Log.i("MicroMsg.BizRecycleCardLogic", "handleRecycleCardResult recycleReportList fromScene=" + bVar.scene + ", size = " + linkedList2.size() + '/' + linkedList.size());
        if (linkedList2.isEmpty()) {
            AppMethodBeat.o(212598);
            return;
        }
        int i6 = 0;
        aa ban2 = ag.ban();
        aa ban3 = ag.ban();
        p.g(ban3, "SubCoreBiz.getBizTimeLineInfoStorage()");
        List<z> MO = ban2.MO(ban3.gAS() << 32);
        if (MO != null) {
            i2 = 0;
            for (T t5 : MO) {
                p.g(t5, LocaleUtil.ITALIAN);
                int i7 = (t5.gAt() ? 1 : 0) + i6;
                i2 = (t5.gAu() ? 1 : 0) + i2;
                i6 = i7;
            }
        } else {
            i2 = 0;
        }
        d.a aVar = new d.a();
        dll dll = new dll();
        dll.gCs = linkedList2;
        dll.MPj = i6;
        dll.MPk = i2;
        aVar.c(dll);
        aVar.d(new dlm());
        aVar.MB("/cgi-bin/mmbiz-bin/timeline/recyclecardreport");
        aVar.sG(4768);
        aa.a(aVar.aXF(), f.NQd);
        AppMethodBeat.o(212598);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u00052\u000e\u0010\u0007\u001a\n \u0006*\u0004\u0018\u00010\b0\b2\u000e\u0010\t\u001a\n \u0006*\u0004\u0018\u00010\n0\nH\n¢\u0006\u0002\b\u000b"}, hxF = {"<anonymous>", "", "errType", "errCode", "errMsg", "", "kotlin.jvm.PlatformType", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "callback"})
    public static final class f implements aa.a {
        public static final f NQd = new f();

        static {
            AppMethodBeat.i(212585);
            AppMethodBeat.o(212585);
        }

        f() {
        }

        @Override // com.tencent.mm.ak.aa.a
        public final int a(int i2, int i3, String str, com.tencent.mm.ak.d dVar, q qVar) {
            AppMethodBeat.i(212584);
            Log.i("MicroMsg.BizRecycleCardLogic", "handleRecycleCardResult callback errType = " + i2 + ", errCode=" + i3);
            AppMethodBeat.o(212584);
            return 0;
        }
    }

    private static boolean A(z zVar) {
        AppMethodBeat.i(212599);
        MultiProcessMMKV multiProcessMMKV = (MultiProcessMMKV) gAl().getSlot();
        String str = "CardRecycleReport" + zVar.field_msgId + '-' + zVar.field_recommendCardId;
        if (multiProcessMMKV.decodeBool(str, false)) {
            AppMethodBeat.o(212599);
            return false;
        }
        multiProcessMMKV.encode(str, true);
        AppMethodBeat.o(212599);
        return true;
    }

    public static void Bt(long j2) {
        AppMethodBeat.i(212600);
        com.tencent.mm.plugin.report.service.h.INSTANCE.n(1534, j2, 1);
        AppMethodBeat.o(212600);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Lcom/tencent/mm/sdk/platformtools/MMKVSlotManager;", "invoke"})
    static final class d extends kotlin.g.b.q implements kotlin.g.a.a<MMKVSlotManager> {
        public static final d NQb = new d();

        static {
            AppMethodBeat.i(212582);
            AppMethodBeat.o(212582);
        }

        d() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ MMKVSlotManager invoke() {
            AppMethodBeat.i(212581);
            MultiProcessMMKV mmkv = MultiProcessMMKV.getMMKV("__biz_cardRecycleSlot_slot_mmkv_key__");
            p.g(mmkv, "MultiProcessMMKV.getMMKV…cleSlot_slot_mmkv_key__\")");
            MMKVSlotManager mMKVSlotManager = new MMKVSlotManager(mmkv, 31536000);
            AppMethodBeat.o(212581);
            return mMKVSlotManager;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "invoke"})
    static final class h extends kotlin.g.b.q implements kotlin.g.a.a<MultiProcessMMKV> {
        public static final h NQf = new h();

        static {
            AppMethodBeat.i(212589);
            AppMethodBeat.o(212589);
        }

        h() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ MultiProcessMMKV invoke() {
            AppMethodBeat.i(212588);
            MultiProcessMMKV singleMMKV = MultiProcessMMKV.getSingleMMKV("brandService");
            AppMethodBeat.o(212588);
            return singleMMKV;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class j extends kotlin.g.b.q implements kotlin.g.a.a<Boolean> {
        public static final j NQi = new j();

        static {
            AppMethodBeat.i(212593);
            AppMethodBeat.o(212593);
        }

        j() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Boolean invoke() {
            AppMethodBeat.i(212592);
            boolean z = ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_open_biz_recycle_card, 1) == 1;
            Log.i("MicroMsg.BizRecycleCardLogic", "recycleCardOpen open ".concat(String.valueOf(z)));
            Boolean valueOf = Boolean.valueOf(z);
            AppMethodBeat.o(212592);
            return valueOf;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class g extends kotlin.g.b.q implements kotlin.g.a.a<Boolean> {
        public static final g NQe = new g();

        static {
            AppMethodBeat.i(212587);
            AppMethodBeat.o(212587);
        }

        g() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Boolean invoke() {
            boolean z = true;
            AppMethodBeat.i(212586);
            y yVar = y.NPP;
            if (y.aTI().decodeInt("BizTimeLineRecycleCardCheck", 1) != 1) {
                z = false;
            }
            Boolean valueOf = Boolean.valueOf(z);
            AppMethodBeat.o(212586);
            return valueOf;
        }
    }

    public static final /* synthetic */ void b(b bVar) {
        AppMethodBeat.i(212602);
        if (!((Boolean) NPM.getValue()).booleanValue() || NPO) {
            AppMethodBeat.o(212602);
            return;
        }
        long abs = Math.abs((System.currentTimeMillis() / 1000) - aTI().decodeLong("RecycleCardLastTime", 0));
        long decodeLong = aTI().decodeLong("RecycleCardInterval", 1800);
        if (!gAm() || abs >= decodeLong) {
            int na = kotlin.k.j.na(kotlin.k.j.mZ(aTI().decodeInt("RecycleCardMaxMsgCount", 10), 2), 50);
            List<z> kL = ag.ban().kL(620757041, na);
            List<z> list = kL;
            if (list == null || list.isEmpty()) {
                Log.i("MicroMsg.BizRecycleCardLogic", "recycleCard list is empty");
                AppMethodBeat.o(212602);
                return;
            }
            Bt(0);
            LinkedList<dli> linkedList = new LinkedList<>();
            MultiProcessMMKV multiProcessMMKV = (MultiProcessMMKV) com.tencent.mm.al.c.iNQ.getSlot();
            for (T t : kL) {
                if (((z) t).field_isRead == 1 && gAm()) {
                    p.g(t, "info");
                    if (A(t)) {
                        s sVar = s.NPC;
                        int i2 = c.RECYCLE_CARD_STATUS_CARD_EXPOSURE.status;
                        ege gAD = t.gAD();
                        s.di(i2, gAD != null ? gAD.dSJ : null);
                        Bt(1);
                        Log.i("MicroMsg.BizRecycleCardLogic", "recycleCard msgIsRead " + ((z) t).field_msgId);
                    } else {
                        Log.d("MicroMsg.BizRecycleCardLogic", "recycleCard msgIsRead " + ((z) t).field_msgId);
                    }
                } else if (multiProcessMMKV.decodeInt(String.valueOf(((z) t).field_msgId), 0) != 1 || !gAm()) {
                    dli dli = new dli();
                    p.g(t, "info");
                    ege gAD2 = t.gAD();
                    dli.KUp = gAD2 != null ? gAD2.dSJ : null;
                    dli.KVE = ((z) t).field_msgId;
                    linkedList.add(dli);
                } else {
                    p.g(t, "info");
                    if (A(t)) {
                        s sVar2 = s.NPC;
                        int i3 = c.RECYCLE_CARD_STATUS_DIGEST_EXPOSURE.status;
                        ege gAD3 = t.gAD();
                        s.di(i3, gAD3 != null ? gAD3.dSJ : null);
                        Bt(2);
                        Log.i("MicroMsg.BizRecycleCardLogic", "recycleCard  msg digest is read " + ((z) t).field_msgId);
                    } else {
                        Log.d("MicroMsg.BizRecycleCardLogic", "recycleCard  msg digest is read " + ((z) t).field_msgId);
                    }
                }
            }
            if (linkedList.isEmpty()) {
                Log.i("MicroMsg.BizRecycleCardLogic", "recycleCard recycleCardList is empty");
                AppMethodBeat.o(212602);
                return;
            }
            Log.i("MicroMsg.BizRecycleCardLogic", "recycleCard recycleCardList fromScene=" + bVar.scene + ", size = " + linkedList.size() + ", maxMsgCount = " + na);
            d.a aVar = new d.a();
            dln dln = new dln();
            dln.scene = bVar.scene;
            dln.gCs = linkedList;
            aVar.c(dln);
            aVar.d(new dlo());
            aVar.MB("/cgi-bin/mmbiz-bin/timeline/recyclecard");
            aVar.sG(4816);
            com.tencent.mm.ak.d aXF = aVar.aXF();
            NPO = true;
            aa.a(aXF, new i(bVar));
            AppMethodBeat.o(212602);
            return;
        }
        Log.i("MicroMsg.BizRecycleCardLogic", "recycleCard delta < interval, return");
        AppMethodBeat.o(212602);
    }
}
