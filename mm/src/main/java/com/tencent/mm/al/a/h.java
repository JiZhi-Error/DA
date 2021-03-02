package com.tencent.mm.al.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.al.ag;
import com.tencent.mm.al.p;
import com.tencent.mm.b.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.bfs;
import com.tencent.mm.protocal.protobuf.nt;
import com.tencent.mm.protocal.protobuf.nu;
import com.tencent.mm.protocal.protobuf.nv;
import com.tencent.mm.protocal.protobuf.nw;
import com.tencent.mm.protocal.protobuf.oa;
import com.tencent.mm.protocal.protobuf.qv;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public final class h implements i {
    private HashSet<a> iQe = new HashSet<>();
    private HashSet<a> iQf = new HashSet<>();
    private final Object iQg = new Object();
    private f<String, Long> iQh = new com.tencent.mm.b.h(64);
    private HashSet<a> iQi = new HashSet<>();
    private HashSet<a> iQj = new HashSet<>();
    private final Object iQk = new Object();
    private f<String, Long> iQl = new com.tencent.mm.b.h(64);

    public static class a {
        private String dUd;
        private String id;

        public a(String str, String str2) {
            this.dUd = str;
            this.id = str2;
        }

        public boolean equals(Object obj) {
            AppMethodBeat.i(124253);
            if (obj.getClass() != a.class) {
                AppMethodBeat.o(124253);
                return false;
            }
            a aVar = (a) obj;
            if ((!(this.dUd == null && aVar.dUd == null) && (this.dUd == null || !this.dUd.equals(aVar.dUd))) || (!(this.id == null && aVar.id == null) && (this.id == null || !this.id.equals(aVar.id)))) {
                AppMethodBeat.o(124253);
                return false;
            }
            AppMethodBeat.o(124253);
            return true;
        }

        public int hashCode() {
            AppMethodBeat.i(124254);
            int hashCode = this.dUd.hashCode() + this.id.hashCode();
            AppMethodBeat.o(124254);
            return hashCode;
        }
    }

    public h() {
        AppMethodBeat.i(124255);
        g.aAg().hqi.a(1352, this);
        g.aAg().hqi.a(1365, this);
        g.aAg().hqi.a(1353, this);
        g.aAg().hqi.a(1354, this);
        g.aAg().hqi.a(1357, this);
        g.aAg().hqi.a(1356, this);
        g.aAg().hqi.a(1355, this);
        g.aAg().hqi.a(1358, this);
        g.aAg().hqi.a(1367, this);
        g.aAg().hqi.a(1361, this);
        g.aAg().hqi.a(1389, this);
        g.aAg().hqi.a(1315, this);
        AppMethodBeat.o(124255);
    }

    /* access modifiers changed from: protected */
    public final void finalize() {
        AppMethodBeat.i(124256);
        g.aAg().hqi.b(1352, this);
        g.aAg().hqi.b(1365, this);
        g.aAg().hqi.b(1353, this);
        g.aAg().hqi.b(1354, this);
        g.aAg().hqi.b(1357, this);
        g.aAg().hqi.b(1356, this);
        g.aAg().hqi.b(1355, this);
        g.aAg().hqi.b(1358, this);
        g.aAg().hqi.b(1367, this);
        g.aAg().hqi.b(1361, this);
        g.aAg().hqi.b(1389, this);
        g.aAg().hqi.b(1315, this);
        super.finalize();
        AppMethodBeat.o(124256);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Removed duplicated region for block: B:243:0x0545  */
    /* JADX WARNING: Removed duplicated region for block: B:276:0x05d2  */
    @Override // com.tencent.mm.ak.i
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onSceneEnd(int r15, int r16, java.lang.String r17, com.tencent.mm.ak.q r18) {
        /*
        // Method dump skipped, instructions count: 2406
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.al.a.h.onSceneEnd(int, int, java.lang.String, com.tencent.mm.ak.q):void");
    }

    public static void d(q qVar) {
        AppMethodBeat.i(124258);
        g.aAg().hqi.a(qVar);
        AppMethodBeat.o(124258);
    }

    public final void bj(String str, String str2) {
        AppMethodBeat.i(124259);
        Long aT = this.iQh.aT(str);
        if (aT == null || aT.longValue() + 5000 < System.currentTimeMillis()) {
            bk(str, str2);
        }
        AppMethodBeat.o(124259);
    }

    private void bk(String str, String str2) {
        AppMethodBeat.i(124260);
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (this.iQg) {
            try {
                a aVar = new a(str2, str);
                if (!this.iQf.contains(aVar)) {
                    this.iQe.add(aVar);
                    this.iQh.put(str, new Long(currentTimeMillis));
                    baA();
                    AppMethodBeat.o(124260);
                }
            } finally {
                AppMethodBeat.o(124260);
            }
        }
    }

    public final void b(LinkedList<String> linkedList, String str) {
        AppMethodBeat.i(124261);
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (this.iQg) {
            try {
                Iterator<String> it = linkedList.iterator();
                while (it.hasNext()) {
                    String next = it.next();
                    a aVar = new a(str, next);
                    if (!this.iQf.contains(aVar)) {
                        this.iQe.add(aVar);
                        this.iQh.put(next, new Long(currentTimeMillis));
                    }
                }
                baA();
            } finally {
                AppMethodBeat.o(124261);
            }
        }
    }

    private void baA() {
        AppMethodBeat.i(124262);
        LinkedList linkedList = new LinkedList();
        synchronized (this.iQg) {
            try {
                if (this.iQf.isEmpty()) {
                    if (this.iQe.isEmpty()) {
                        AppMethodBeat.o(124262);
                        return;
                    }
                    Iterator<a> it = this.iQe.iterator();
                    while (it.hasNext()) {
                        a next = it.next();
                        nu nuVar = new nu();
                        nuVar.KTt = next.dUd;
                        nuVar.KTl = next.id;
                        linkedList.add(nuVar);
                    }
                    if (linkedList.isEmpty()) {
                        AppMethodBeat.o(124262);
                        return;
                    }
                    this.iQf.addAll(this.iQe);
                    this.iQe.clear();
                    g.aAg().hqi.a(new q(linkedList), 0);
                    AppMethodBeat.o(124262);
                }
            } finally {
                AppMethodBeat.o(124262);
            }
        }
    }

    public final void bl(String str, String str2) {
        AppMethodBeat.i(124263);
        Long aT = this.iQl.aT(str);
        if (aT == null || aT.longValue() + 5000 < System.currentTimeMillis()) {
            bm(str, str2);
        }
        AppMethodBeat.o(124263);
    }

    public final void bm(String str, String str2) {
        AppMethodBeat.i(124264);
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (this.iQk) {
            try {
                a aVar = new a(str2, str);
                if (!this.iQj.contains(aVar)) {
                    this.iQi.add(aVar);
                    this.iQl.put(str, new Long(currentTimeMillis));
                    baB();
                    AppMethodBeat.o(124264);
                }
            } finally {
                AppMethodBeat.o(124264);
            }
        }
    }

    public final void c(LinkedList<String> linkedList, String str) {
        AppMethodBeat.i(124265);
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (this.iQk) {
            try {
                Iterator<String> it = linkedList.iterator();
                while (it.hasNext()) {
                    String next = it.next();
                    a aVar = new a(str, next);
                    if (!this.iQj.contains(aVar)) {
                        this.iQi.add(aVar);
                        this.iQl.put(next, new Long(currentTimeMillis));
                    } else {
                        return;
                    }
                }
                baB();
                AppMethodBeat.o(124265);
            } finally {
                AppMethodBeat.o(124265);
            }
        }
    }

    private void baB() {
        AppMethodBeat.i(124266);
        LinkedList linkedList = new LinkedList();
        synchronized (this.iQk) {
            try {
                if (this.iQj.isEmpty()) {
                    if (this.iQi.isEmpty()) {
                        AppMethodBeat.o(124266);
                        return;
                    }
                    HashMap hashMap = new HashMap();
                    Iterator<a> it = this.iQi.iterator();
                    while (it.hasNext()) {
                        a next = it.next();
                        LinkedList linkedList2 = (LinkedList) hashMap.get(next.dUd);
                        if (linkedList2 == null) {
                            linkedList2 = new LinkedList();
                            hashMap.put(next.dUd, linkedList2);
                        }
                        linkedList2.add(next.id);
                    }
                    for (String str : hashMap.keySet()) {
                        LinkedList<String> linkedList3 = (LinkedList) hashMap.get(str);
                        if (linkedList3 != null && !linkedList3.isEmpty()) {
                            qv qvVar = new qv();
                            qvVar.KTt = str;
                            qvVar.KXK = linkedList3;
                            linkedList.add(qvVar);
                        }
                    }
                    this.iQj.addAll(this.iQi);
                    this.iQi.clear();
                    g.aAg().hqi.a(new s(linkedList, null), 0);
                    AppMethodBeat.o(124266);
                }
            } finally {
                AppMethodBeat.o(124266);
            }
        }
    }

    public static void bn(String str, String str2) {
        AppMethodBeat.i(124267);
        g.aAg().hqi.a(new p(str, str2), 0);
        AppMethodBeat.o(124267);
    }

    public static void a(String str, String str2, p pVar) {
        AppMethodBeat.i(124268);
        if (pVar == null) {
            AppMethodBeat.o(124268);
            return;
        }
        k NJ = e.NJ(str2);
        if (NJ == null || NJ.field_userId.equals(str)) {
            a(str2, pVar);
            AppMethodBeat.o(124268);
            return;
        }
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add(str);
        qv qvVar = new qv();
        qvVar.KTt = str2;
        qvVar.KXK = linkedList;
        LinkedList linkedList2 = new LinkedList();
        linkedList2.add(qvVar);
        g.aAg().hqi.a(new s(linkedList2, pVar), 0);
        AppMethodBeat.o(124268);
    }

    public static void a(String str, p pVar) {
        AppMethodBeat.i(124269);
        g.aAg().hqi.a(new r(str, pVar), 0);
        AppMethodBeat.o(124269);
    }

    public static o a(String str, bfs bfs, p pVar) {
        AppMethodBeat.i(124270);
        o oVar = new o(str, bfs, pVar);
        g.aAg().hqi.a(oVar, 0);
        AppMethodBeat.o(124270);
        return oVar;
    }

    public static y a(String str, String str2, nw nwVar, nw nwVar2, p pVar) {
        AppMethodBeat.i(124271);
        y yVar = new y(str, str2, nwVar, nwVar2, pVar);
        g.aAg().hqi.a(yVar, 0);
        AppMethodBeat.o(124271);
        return yVar;
    }

    public static x a(String str, nt ntVar, p pVar) {
        AppMethodBeat.i(124272);
        x xVar = new x(str, ntVar, pVar);
        g.aAg().hqi.a(xVar, 0);
        AppMethodBeat.o(124272);
        return xVar;
    }

    public static void k(String str, String str2, int i2) {
        AppMethodBeat.i(124273);
        g.aAg().hqi.a(new w(str, str2, i2), 0);
        AppMethodBeat.o(124273);
    }

    private static boolean a(oa oaVar, String str) {
        AppMethodBeat.i(124274);
        if (Util.isNullOrNil(str) || Util.isNullOrNil(oaVar.KTu)) {
            AppMethodBeat.o(124274);
            return false;
        }
        k kVar = new k();
        kVar.field_userId = oaVar.KTu;
        kVar.field_userName = oaVar.pWm;
        kVar.field_brandUserName = str;
        kVar.field_headImageUrl = oaVar.KTm;
        kVar.field_profileUrl = oaVar.gTH;
        kVar.field_UserVersion = oaVar.ver;
        kVar.field_addMemberUrl = oaVar.KTr;
        if (!ag.bal().b(kVar)) {
            ag.bal().a(kVar);
        }
        c cVar = new c();
        cVar.field_bizChatServId = kVar.field_userId;
        cVar.field_brandUserName = kVar.field_brandUserName;
        cVar.field_chatName = kVar.field_userName;
        cVar.field_chatType = j.BIZ_CHAT_TYPE_GROUP.iQq;
        if (e.e(cVar) == null) {
            AppMethodBeat.o(124274);
            return false;
        }
        AppMethodBeat.o(124274);
        return true;
    }

    private static boolean a(bfs bfs, String str, boolean z) {
        boolean z2;
        c cVar;
        AppMethodBeat.i(124275);
        Log.d("MicroMsg.BizChatNetworkMgr", "handleGetBizChatInfoSceneEnd");
        if (bfs == null || bfs.LPp == null || Util.isNullOrNil(str)) {
            Log.w("MicroMsg.BizChatNetworkMgr", "fullBizChat or fullBizChat.chat or brandUserName == null");
            AppMethodBeat.o(124275);
            return false;
        }
        c NE = ag.baj().NE(bfs.LPp.KTl);
        if (NE == null) {
            Log.w("MicroMsg.BizChatNetworkMgr", "bizChatInfo == null");
            c cVar2 = new c();
            cVar2.field_bizChatServId = bfs.LPp.KTl;
            cVar2.field_brandUserName = str;
            z2 = true;
            cVar = cVar2;
            z = true;
        } else {
            z2 = false;
            cVar = NE;
        }
        if (bfs.KTv == null) {
            Log.w("MicroMsg.BizChatNetworkMgr", "members==null");
            AppMethodBeat.o(124275);
            return false;
        }
        if (cVar.bay() || bfs.LPp.ver > cVar.field_chatVersion) {
            cVar.field_chatType = bfs.LPp.type;
            cVar.field_headImageUrl = bfs.LPp.KTm;
            cVar.field_chatName = bfs.LPp.name;
            cVar.field_chatVersion = bfs.LPp.ver;
            cVar.field_needToUpdate = false;
            cVar.field_bitFlag = bfs.LPp.KTn;
            cVar.field_maxMemberCnt = bfs.LPp.KTp;
            cVar.field_ownerUserId = bfs.LPp.KTq;
            cVar.field_addMemberUrl = bfs.LPp.KTr;
            cVar.field_brandUserName = str;
            cVar.field_roomflag = bfs.LPp.KTs;
            LinkedList linkedList = new LinkedList();
            Iterator<nv> it = bfs.KTv.iterator();
            while (it.hasNext()) {
                linkedList.add(it.next().KTu);
            }
            cVar.field_userList = Util.listToString(linkedList, ";");
            if (z2) {
                ag.baj().a(cVar);
            } else {
                ag.baj().b(cVar);
            }
        }
        e.h(cVar);
        if (z) {
            qv qvVar = new qv();
            qvVar.KTt = cVar.field_brandUserName;
            LinkedList<String> linkedList2 = new LinkedList<>();
            Iterator<nv> it2 = bfs.KTv.iterator();
            while (it2.hasNext()) {
                nv next = it2.next();
                if (((long) next.ver) > ((long) ag.bal().NP(next.KTu))) {
                    linkedList2.add(next.KTu);
                }
            }
            if (linkedList2.size() > 0) {
                qvVar.KXK = linkedList2;
                LinkedList linkedList3 = new LinkedList();
                linkedList3.add(qvVar);
                g.aAg().hqi.a(new s(linkedList3, null), 0);
            }
        } else {
            ISQLiteDatabase iSQLiteDatabase = ag.bal().db;
            long j2 = 0;
            if (iSQLiteDatabase instanceof com.tencent.mm.storagebase.h) {
                j2 = ((com.tencent.mm.storagebase.h) iSQLiteDatabase).beginTransaction(Thread.currentThread().getId());
            }
            Iterator<nv> it3 = bfs.KTv.iterator();
            while (it3.hasNext()) {
                nv next2 = it3.next();
                k fB = ag.bal().fB(next2.KTu);
                if (fB == null) {
                    k kVar = new k();
                    kVar.field_userId = next2.KTu;
                    kVar.field_userName = next2.pWm;
                    kVar.field_brandUserName = cVar.field_brandUserName;
                    kVar.field_needToUpdate = true;
                    ag.bal().a(kVar);
                } else if (next2.ver > fB.field_UserVersion) {
                    fB.field_needToUpdate = true;
                    ag.bal().b(fB);
                }
            }
            if (iSQLiteDatabase instanceof com.tencent.mm.storagebase.h) {
                g.aAh().hqK.endTransaction(j2);
            }
        }
        AppMethodBeat.o(124275);
        return true;
    }
}
