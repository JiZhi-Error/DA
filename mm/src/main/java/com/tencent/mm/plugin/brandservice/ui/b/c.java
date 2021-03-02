package com.tencent.mm.plugin.brandservice.ui.b;

import android.os.Looper;
import android.os.MessageQueue;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.q;
import com.tencent.mm.ak.aa;
import com.tencent.mm.ak.d;
import com.tencent.mm.al.ag;
import com.tencent.mm.ay.a;
import com.tencent.mm.ay.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.brandservice.b;
import com.tencent.mm.plugin.brandservice.ui.timeline.item.j;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.efz;
import com.tencent.mm.protocal.protobuf.ega;
import com.tencent.mm.protocal.protobuf.egc;
import com.tencent.mm.protocal.protobuf.ege;
import com.tencent.mm.protocal.protobuf.po;
import com.tencent.mm.protocal.protobuf.pp;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.r;
import com.tencent.mm.storage.z;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class c {
    private static Map<Long, Integer> pMr = new HashMap();
    private static LinkedList<Long> pMs = new LinkedList<>();

    static {
        AppMethodBeat.i(6257);
        AppMethodBeat.o(6257);
    }

    public static String crh() {
        AppMethodBeat.i(6244);
        String str = null;
        f bef = a.bef();
        if (bef != null && bef.jeV != null && bef.jeT == 0 && a.bec()) {
            str = bef.jeV;
        }
        AppMethodBeat.o(6244);
        return str;
    }

    public static boolean DW(int i2) {
        AppMethodBeat.i(6245);
        if ((System.currentTimeMillis() / 1000) - ((long) i2) > ((long) a.pMl)) {
            AppMethodBeat.o(6245);
            return true;
        }
        AppMethodBeat.o(6245);
        return false;
    }

    public static void w(final z zVar) {
        AppMethodBeat.i(6246);
        if (zVar == null || !zVar.gAt()) {
            AppMethodBeat.o(6246);
            return;
        }
        b.a("BrandServiceWorkerThread", new Runnable() {
            /* class com.tencent.mm.plugin.brandservice.ui.b.c.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(6239);
                if (!c.pMr.containsKey(Long.valueOf(zVar.field_msgId)) || c.DW(((Integer) c.pMr.get(Long.valueOf(zVar.field_msgId))).intValue())) {
                    List<z> aU = ag.ban().aU(5, zVar.field_orderFlag);
                    List<z> MN = ag.ban().MN(zVar.field_orderFlag);
                    LinkedList linkedList = new LinkedList();
                    linkedList.addAll(aU);
                    linkedList.add(zVar);
                    linkedList.addAll(MN);
                    c.cL(linkedList);
                    AppMethodBeat.o(6239);
                    return;
                }
                AppMethodBeat.o(6239);
            }
        }, 0);
        AppMethodBeat.o(6246);
    }

    public static void cL(List<z> list) {
        AppMethodBeat.i(6247);
        if (Util.isNullOrNil(list)) {
            AppMethodBeat.o(6247);
            return;
        }
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        for (z zVar : list) {
            if (!pMr.containsKey(Long.valueOf(zVar.field_msgId)) || DW(pMr.get(Long.valueOf(zVar.field_msgId)).intValue())) {
                if (zVar.gAt()) {
                    q qVar = new q();
                    qVar.msgId = zVar.field_msgId;
                    qVar.iAc = zVar.field_content;
                    linkedList.add(qVar);
                    pMr.put(Long.valueOf(zVar.field_msgId), Integer.valueOf((int) (System.currentTimeMillis() / 1000)));
                } else {
                    pMr.put(Long.valueOf(zVar.field_msgId), Integer.valueOf((int) (System.currentTimeMillis() / 1000)));
                    linkedList2.add(zVar);
                }
            }
        }
        if (linkedList.size() > 0) {
            ((com.tencent.mm.plugin.brandservice.a.b) g.af(com.tencent.mm.plugin.brandservice.a.b.class)).l(linkedList, 90);
        }
        AppMethodBeat.o(6247);
    }

    public static void a(final List<z> list, final Runnable runnable) {
        AppMethodBeat.i(6248);
        Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler() {
            /* class com.tencent.mm.plugin.brandservice.ui.b.c.AnonymousClass2 */

            public final boolean queueIdle() {
                AppMethodBeat.i(195062);
                Looper.myQueue().removeIdleHandler(this);
                b.a("BrandServiceWorkerThread", new Runnable() {
                    /* class com.tencent.mm.plugin.brandservice.ui.b.c.AnonymousClass2.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(195061);
                        for (z zVar : list) {
                            if (zVar.gAt()) {
                                ((com.tencent.mm.plugin.biz.a.a) g.af(com.tencent.mm.plugin.biz.a.a.class)).a(zVar.field_msgId, zVar.field_content);
                            }
                        }
                        c.cN(list);
                        c.cO(list);
                        MMHandlerThread.postToMainThread(runnable);
                        AppMethodBeat.o(195061);
                    }
                }, 0);
                AppMethodBeat.o(195062);
                return false;
            }
        });
        AppMethodBeat.o(6248);
    }

    public static boolean b(com.tencent.mm.bw.a aVar, com.tencent.mm.bw.a aVar2) {
        AppMethodBeat.i(6249);
        if (aVar == null && aVar2 == null) {
            AppMethodBeat.o(6249);
            return true;
        } else if (aVar == null || aVar2 == null) {
            AppMethodBeat.o(6249);
            return false;
        } else {
            try {
                boolean isEqual = Util.isEqual(aVar.toByteArray(), aVar2.toByteArray());
                AppMethodBeat.o(6249);
                return isEqual;
            } catch (IOException e2) {
                Log.i("MicroMsg.ConversationAdapter", "isMsgStatInfoProtoEqual exp %s", e2.getMessage());
                AppMethodBeat.o(6249);
                return false;
            }
        }
    }

    public static String aiW(String str) {
        AppMethodBeat.i(6250);
        if (str != null) {
            String replaceAll = str.replaceAll("(?m)^\\s*$(\\n|\\r\\n)", "");
            AppMethodBeat.o(6250);
            return replaceAll;
        }
        AppMethodBeat.o(6250);
        return null;
    }

    public static void cM(final List<z> list) {
        AppMethodBeat.i(6251);
        b.a("BrandServiceWorkerThread", new Runnable() {
            /* class com.tencent.mm.plugin.brandservice.ui.b.c.AnonymousClass3 */

            public final void run() {
                AppMethodBeat.i(6241);
                c.cN(list);
                AppMethodBeat.o(6241);
            }
        }, 0);
        AppMethodBeat.o(6251);
    }

    public static void cN(List<z> list) {
        ege gAD;
        egc a2;
        AppMethodBeat.i(6252);
        int decodeInt = MultiProcessMMKV.getSingleMMKV("brandService").decodeInt("BizRecommendCardRefreshIntervalSec", 300);
        LinkedList linkedList = new LinkedList();
        long currentTimeMillis = System.currentTimeMillis();
        for (z zVar : list) {
            if (zVar.gAu() && !j.k(zVar) && (gAD = zVar.gAD()) != null && gAD.NfY != null && Math.abs(currentTimeMillis - gAD.lastUpdateTime) / 1000 > ((long) decodeInt) && (a2 = a(gAD, zVar)) != null) {
                linkedList.add(a2);
            }
        }
        if (!Util.isNullOrNil(linkedList)) {
            M(linkedList);
        }
        AppMethodBeat.o(6252);
    }

    public static void cO(List<z> list) {
        AppMethodBeat.i(195064);
        LinkedList linkedList = new LinkedList();
        for (z zVar : list) {
            r rVar = r.NPl;
            if (!r.gzL() || !zVar.gAv()) {
                r rVar2 = r.NPl;
                if (r.gzM() && zVar.gAu()) {
                    r.NPl.z(zVar);
                }
            } else {
                linkedList.add(zVar);
                r.NPl.z(zVar);
            }
        }
        AppMethodBeat.o(195064);
    }

    public static void cP(List<z> list) {
        ege gAD;
        AppMethodBeat.i(195065);
        for (z zVar : list) {
            r rVar = r.NPl;
            if (!r.gzL() || !zVar.gAv()) {
                r rVar2 = r.NPl;
                if (r.gzM() && zVar.gAu() && (gAD = zVar.gAD()) != null && gAD.style == 1001) {
                    ((com.tencent.mm.plugin.brandservice.a.b) g.af(com.tencent.mm.plugin.brandservice.a.b.class)).clj();
                    AppMethodBeat.o(195065);
                    return;
                }
            } else {
                ((com.tencent.mm.plugin.brandservice.a.b) g.af(com.tencent.mm.plugin.brandservice.a.b.class)).clj();
                AppMethodBeat.o(195065);
                return;
            }
        }
        AppMethodBeat.o(195065);
    }

    public static void x(z zVar) {
        egc a2;
        AppMethodBeat.i(6253);
        if (zVar == null || !zVar.gAu()) {
            AppMethodBeat.o(6253);
            return;
        }
        ege gAD = zVar.gAD();
        if (j.k(zVar)) {
            AppMethodBeat.o(6253);
            return;
        }
        int decodeInt = MultiProcessMMKV.getSingleMMKV("brandService").decodeInt("BizRecommendCardRefreshIntervalSec", 300);
        LinkedList linkedList = new LinkedList();
        long currentTimeMillis = System.currentTimeMillis();
        if (!(gAD == null || gAD.NfY == null || Math.abs(currentTimeMillis - gAD.lastUpdateTime) / 1000 <= ((long) decodeInt) || (a2 = a(gAD, zVar)) == null)) {
            linkedList.add(a2);
        }
        if (!Util.isNullOrNil(linkedList)) {
            M(linkedList);
        }
        AppMethodBeat.o(6253);
    }

    private static void M(LinkedList<egc> linkedList) {
        AppMethodBeat.i(6254);
        if (Util.isNullOrNil(linkedList)) {
            AppMethodBeat.o(6254);
            return;
        }
        final LinkedList linkedList2 = new LinkedList();
        synchronized (pMs) {
            try {
                if (!Util.isNullOrNil(pMs)) {
                    LinkedList linkedList3 = new LinkedList();
                    Iterator<egc> it = linkedList.iterator();
                    while (it.hasNext()) {
                        egc next = it.next();
                        if (pMs.contains(Long.valueOf(next.KWz))) {
                            linkedList3.add(next);
                        }
                    }
                    linkedList.removeAll(linkedList3);
                    if (Util.isNullOrNil(linkedList)) {
                        Log.d("MicroMsg.ConversationAdapter", "doUpdateRecommendCard is doing return %d", Integer.valueOf(linkedList3.size()));
                        return;
                    }
                }
                Iterator<egc> it2 = linkedList.iterator();
                while (it2.hasNext()) {
                    linkedList2.add(Long.valueOf(it2.next().KWz));
                }
                pMs.addAll(linkedList2);
                d.a aVar = new d.a();
                aVar.iLN = new po();
                aVar.iLO = new pp();
                aVar.uri = "/cgi-bin/mmbiz-bin/timeline/bizrecommendcard";
                aVar.funcId = 2787;
                d aXF = aVar.aXF();
                final po poVar = (po) aXF.iLK.iLR;
                poVar.KWD = linkedList;
                aa.a(aXF, new aa.a() {
                    /* class com.tencent.mm.plugin.brandservice.ui.b.c.AnonymousClass4 */

                    @Override // com.tencent.mm.ak.aa.a
                    public final int a(int i2, int i3, String str, d dVar, com.tencent.mm.ak.q qVar) {
                        AppMethodBeat.i(6242);
                        Log.i("MicroMsg.ConversationAdapter", "[TRACE_BIZRECCARD] doUpdateRecommendCard check result errType:%d errCode:%d msg:%s", Integer.valueOf(i2), Integer.valueOf(i3), str);
                        synchronized (c.pMs) {
                            try {
                                c.pMs.removeAll(linkedList2);
                            } catch (Throwable th) {
                                AppMethodBeat.o(6242);
                                throw th;
                            }
                        }
                        if (i2 == 0 && i3 == 0) {
                            pp ppVar = (pp) dVar.iLL.iLR;
                            if (ppVar == null) {
                                AppMethodBeat.o(6242);
                                return 0;
                            }
                            MultiProcessMMKV.getSingleMMKV("brandService").encode("BizRecommendCardRefreshIntervalSec", Math.min(300, ppVar.KSO));
                            if (ppVar.KWD == null) {
                                Log.i("MicroMsg.ConversationAdapter", "response.RecCard is null");
                                AppMethodBeat.o(6242);
                                return 0;
                            }
                            LinkedList linkedList = new LinkedList();
                            Iterator<efz> it = ppVar.KWD.iterator();
                            while (it.hasNext()) {
                                efz next = it.next();
                                Iterator<egc> it2 = poVar.KWD.iterator();
                                while (it2.hasNext()) {
                                    egc next2 = it2.next();
                                    if (Util.isEqual(next2.KWz, next.KWz)) {
                                        if (next.NfT == null) {
                                            Log.i("MicroMsg.ConversationAdapter", "doUpdateRecommendCard BizInfo is null");
                                        } else if ((next.NfT.KHa & 1) != 0) {
                                            ag.ban().MX(next.KWz);
                                            h.INSTANCE.idkeyStat(1149, 5, 1, false);
                                            Log.w("MicroMsg.ConversationAdapter", "doUpdateRecommendCard delete card by flag %d, msgId %d", Integer.valueOf(next.NfT.KHa), Long.valueOf(next.KWz));
                                        } else if (Util.isNullOrNil(next.NfT.UserName)) {
                                            Log.i("MicroMsg.ConversationAdapter", "doUpdateRecommendCard UserName is null");
                                        } else if (Util.isNullOrNil(next.KWy) || next.KWy.get(0) == null || Util.isNullOrNil(next.KWy.get(0).KSj)) {
                                            Log.i("MicroMsg.ConversationAdapter", "doUpdateRecommendCard ContentUrl is null");
                                        } else if (!Util.isEqual(next.Luh, next2.Luh)) {
                                            linkedList.add(next);
                                        } else {
                                            Log.i("MicroMsg.ConversationAdapter", "doUpdateRecommendCard VersionInfo isEqual");
                                            if (next.NfU != null && !Util.isEqual(next.NfU.Luh, next2.NfW)) {
                                                linkedList.add(next);
                                                Log.i("MicroMsg.ConversationAdapter", "doUpdateRecommendCard UserVersionInfo update");
                                            }
                                        }
                                    }
                                }
                            }
                            Log.i("MicroMsg.ConversationAdapter", "doUpdateRecommendCard updateList size %d, RecCard.size %d", Integer.valueOf(linkedList.size()), Integer.valueOf(ppVar.KWD.size()));
                            if (!Util.isNullOrNil(linkedList)) {
                                com.tencent.mm.storage.aa ban = ag.ban();
                                if (!Util.isNullOrNil(linkedList)) {
                                    LinkedList linkedList2 = new LinkedList();
                                    com.tencent.mm.co.g.hio().h(new com.tencent.mm.vending.c.a<Void, Void>(linkedList, linkedList2) {
                                        /* class com.tencent.mm.storage.aa.AnonymousClass7 */
                                        final /* synthetic */ List NQD;
                                        final /* synthetic */ List hjk;

                                        {
                                            this.hjk = r2;
                                            this.NQD = r3;
                                        }

                                        /* Return type fixed from 'java.lang.Object' to match base method */
                                        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                                        @Override // com.tencent.mm.vending.c.a
                                        public final /* synthetic */ Void call(Void r13) {
                                            AppMethodBeat.i(124616);
                                            for (efz efz : this.hjk) {
                                                if (efz != null) {
                                                    z R = aa.this.R(efz.KWz, "msgId");
                                                    if (R == null) {
                                                        Log.i("MicroMsg.BizTimeLineInfoStorage", "batUpdateRecCardInfo info is null ClientId=%d", Long.valueOf(efz.KWz));
                                                    } else {
                                                        ege gAD = R.gAD();
                                                        if (gAD == null) {
                                                            Log.i("MicroMsg.BizTimeLineInfoStorage", "batUpdateRecCardInfo wrapper is null ClientId=%d", Long.valueOf(efz.KWz));
                                                        } else {
                                                            efz efz2 = gAD.NfY;
                                                            if (!Util.isEqual(efz2.Luh, efz.Luh)) {
                                                                gAD.NfY = efz;
                                                                if (!(efz2.NfU == null || efz2.NfU.NfX == null)) {
                                                                    Log.i("MicroMsg.BizTimeLineInfoStorage", "[TRACE_BIZRECCARD] batUpdateRecCardInfo recCard.VersionInfo diff, localRecCard.ver = %s, origin.ver = %s", efz2.Luh, efz.Luh);
                                                                    gAD.NfY.NfU = efz2.NfU;
                                                                }
                                                            }
                                                            if (efz2.NfU == null) {
                                                                gAD.NfY.NfU = efz.NfU;
                                                            } else if (efz.NfU == null) {
                                                                gAD.NfY.NfU = efz2.NfU;
                                                            } else if (!Util.isEqual(efz.NfU.Luh, efz2.NfU.Luh)) {
                                                                gAD.NfY.NfU = efz.NfU;
                                                            }
                                                            gAD.lastUpdateTime = System.currentTimeMillis();
                                                            R.c(gAD);
                                                            aa.this.updateNotify(R, false, "msgId");
                                                            this.NQD.add(R);
                                                        }
                                                    }
                                                }
                                            }
                                            AppMethodBeat.o(124616);
                                            return null;
                                        }
                                    }).b(new com.tencent.mm.vending.c.a<Void, Void>(linkedList2) {
                                        /* class com.tencent.mm.storage.aa.AnonymousClass6 */
                                        final /* synthetic */ List NQD;

                                        {
                                            this.NQD = r2;
                                        }

                                        /* Return type fixed from 'java.lang.Object' to match base method */
                                        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                                        @Override // com.tencent.mm.vending.c.a
                                        public final /* synthetic */ Void call(Void r4) {
                                            AppMethodBeat.i(124615);
                                            a aVar = new a();
                                            aVar.NQE = b.UPDATE;
                                            aVar.list = this.NQD;
                                            aa.this.a(aVar);
                                            AppMethodBeat.o(124615);
                                            return null;
                                        }
                                    });
                                }
                            }
                            AppMethodBeat.o(6242);
                            return 0;
                        }
                        AppMethodBeat.o(6242);
                        return 0;
                    }
                });
                AppMethodBeat.o(6254);
            } finally {
                AppMethodBeat.o(6254);
            }
        }
    }

    private static egc a(ege ege, z zVar) {
        AppMethodBeat.i(6255);
        if (ege == null || ege.NfY == null || zVar == null) {
            Log.i("MicroMsg.ConversationAdapter", "getTLRecCardLite invalid data");
            AppMethodBeat.o(6255);
            return null;
        }
        egc egc = new egc();
        if (!Util.isNullOrNil(ege.NfY.KWy)) {
            Iterator<ega> it = ege.NfY.KWy.iterator();
            while (it.hasNext()) {
                egc.KUB.add(it.next().KSj);
            }
        }
        egc.KSV = zVar.field_talker;
        egc.KWz = zVar.field_msgId;
        egc.Luh = ege.NfY.Luh;
        egc.KUh = ege.style;
        if (ege.NfY.NfU != null) {
            egc.NfW = ege.NfY.NfU.Luh;
        }
        AppMethodBeat.o(6255);
        return egc;
    }

    public static void y(final z zVar) {
        AppMethodBeat.i(195066);
        if (zVar == null || !zVar.gAu()) {
            AppMethodBeat.o(195066);
            return;
        }
        b.a("BrandServiceWorkerThread", new Runnable() {
            /* class com.tencent.mm.plugin.brandservice.ui.b.c.AnonymousClass5 */

            public final void run() {
                AppMethodBeat.i(195063);
                if (!c.pMr.containsKey(Long.valueOf(zVar.field_msgId)) || c.DW(((Integer) c.pMr.get(Long.valueOf(zVar.field_msgId))).intValue())) {
                    List<z> aU = ag.ban().aU(5, zVar.field_orderFlag);
                    List<z> MN = ag.ban().MN(zVar.field_orderFlag);
                    LinkedList<z> linkedList = new LinkedList();
                    linkedList.addAll(aU);
                    linkedList.add(zVar);
                    linkedList.addAll(MN);
                    if (Util.isNullOrNil(linkedList)) {
                        AppMethodBeat.o(195063);
                        return;
                    }
                    LinkedList linkedList2 = new LinkedList();
                    for (z zVar : linkedList) {
                        if ((!c.pMr.containsKey(Long.valueOf(zVar.field_msgId)) || c.DW(((Integer) c.pMr.get(Long.valueOf(zVar.field_msgId))).intValue())) && zVar.NQn != null && zVar.NQn.NfY != null && !Util.isNullOrNil(zVar.NQn.NfY.KWy) && zVar.gAu()) {
                            if (zVar.NQn.style == 3 || zVar.NQn.style == 5) {
                                for (int i2 = 0; i2 < zVar.NQn.NfY.KWy.size(); i2++) {
                                    ega ega = zVar.NQn.NfY.KWy.get(i2);
                                    q qVar = new q();
                                    qVar.Url = ega.KSj;
                                    qVar.iAb = ega.iAb;
                                    qVar.ReqType = 1;
                                    linkedList2.add(qVar);
                                }
                                c.pMr.put(Long.valueOf(zVar.field_msgId), Integer.valueOf((int) (System.currentTimeMillis() / 1000)));
                            }
                        }
                    }
                    if (linkedList2.size() > 0) {
                        ((com.tencent.mm.plugin.brandservice.a.b) g.af(com.tencent.mm.plugin.brandservice.a.b.class)).ct(linkedList2);
                    }
                    AppMethodBeat.o(195063);
                    return;
                }
                AppMethodBeat.o(195063);
            }
        }, 0);
        AppMethodBeat.o(195066);
    }
}
