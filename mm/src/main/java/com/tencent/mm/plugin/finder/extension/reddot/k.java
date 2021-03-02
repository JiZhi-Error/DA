package com.tencent.mm.plugin.finder.extension.reddot;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.co;
import com.tencent.mm.model.cl;
import com.tencent.mm.protocal.protobuf.FinderTipsShowEntranceExtInfo;
import com.tencent.mm.protocal.protobuf.bbi;
import com.tencent.mm.protocal.protobuf.bbj;
import com.tencent.mm.protocal.protobuf.bdo;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.x;

public final class k extends co {
    private static final IAutoDBItem.MAutoDBInfo info = co.ajs();
    public static final a tLn = new a((byte) 0);
    public final ConcurrentHashMap<String, bdo> tLk = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, List<String>> tLl = new ConcurrentHashMap<>();
    public bbj tLm = new bbj();

    public static final class b extends q implements kotlin.g.a.b<String, Boolean> {
        final /* synthetic */ String tLo;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(String str) {
            super(1);
            this.tLo = str;
        }

        @Override // kotlin.g.a.b
        public final /* synthetic */ Boolean invoke(String str) {
            AppMethodBeat.i(178194);
            String str2 = str;
            p.h(str2, LocaleUtil.ITALIAN);
            Boolean valueOf = Boolean.valueOf(p.j(str2, this.tLo));
            AppMethodBeat.o(178194);
            return valueOf;
        }
    }

    public static final class c extends q implements kotlin.g.a.b<bdo, Boolean> {
        final /* synthetic */ k tLp;
        final /* synthetic */ LinkedList tLq;
        final /* synthetic */ String tLr;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(k kVar, LinkedList linkedList, String str) {
            super(1);
            this.tLp = kVar;
            this.tLq = linkedList;
            this.tLr = str;
        }

        @Override // kotlin.g.a.b
        public final /* synthetic */ Boolean invoke(bdo bdo) {
            AppMethodBeat.i(178195);
            Boolean valueOf = Boolean.valueOf(p.j(bdo.path, this.tLr));
            AppMethodBeat.o(178195);
            return valueOf;
        }
    }

    public static final class d extends q implements kotlin.g.a.b<bdo, Boolean> {
        final /* synthetic */ k tLp;
        final /* synthetic */ LinkedList tLq;
        final /* synthetic */ String tLr;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(k kVar, LinkedList linkedList, String str) {
            super(1);
            this.tLp = kVar;
            this.tLq = linkedList;
            this.tLr = str;
        }

        @Override // kotlin.g.a.b
        public final /* synthetic */ Boolean invoke(bdo bdo) {
            AppMethodBeat.i(178196);
            Boolean valueOf = Boolean.valueOf(p.j(bdo.path, this.tLr));
            AppMethodBeat.o(178196);
            return valueOf;
        }
    }

    public k() {
        AppMethodBeat.i(178204);
        AppMethodBeat.o(178204);
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(178205);
        AppMethodBeat.o(178205);
    }

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem
    public final IAutoDBItem.MAutoDBInfo getDBInfo() {
        return info;
    }

    public final FinderTipsShowEntranceExtInfo dbx() {
        AppMethodBeat.i(243634);
        FinderTipsShowEntranceExtInfo finderTipsShowEntranceExtInfo = this.field_tipsShowEntranceExtInfo;
        if (finderTipsShowEntranceExtInfo == null) {
            finderTipsShowEntranceExtInfo = new FinderTipsShowEntranceExtInfo();
        }
        AppMethodBeat.o(243634);
        return finderTipsShowEntranceExtInfo;
    }

    public final k f(bbi bbi) {
        List<String> list;
        AppMethodBeat.i(178197);
        p.h(bbi, "proto");
        this.field_ctrInfo = bbi;
        this.field_ctrType = bbi.type;
        this.field_expiredTime = (long) bbi.pRN;
        this.field_tipsId = bbi.LKM;
        if (this.field_time <= 0) {
            this.field_time = cl.aWA();
        }
        g(bbi);
        dby();
        this.field_revokeId = this.tLm.LKO;
        bbi.feedId = this.tLm.object_id;
        LinkedList<bdo> linkedList = new LinkedList();
        LinkedList<bdo> linkedList2 = this.field_ctrInfo.GaM;
        p.g(linkedList2, "field_ctrInfo.show_infos");
        for (T t : linkedList2) {
            ConcurrentHashMap<String, bdo> concurrentHashMap = this.tLk;
            String str = t.path;
            if (str == null) {
                str = "";
            }
            p.g(t, LocaleUtil.ITALIAN);
            concurrentHashMap.put(str, t);
            if (t.LNm == 2) {
                ConcurrentHashMap<String, List<String>> concurrentHashMap2 = this.tLl;
                String str2 = t.path;
                if (str2 == null) {
                    str2 = "";
                }
                List<String> synchronizedList = Collections.synchronizedList(new LinkedList());
                p.g(synchronizedList, "Collections.synchronizedList(LinkedList<String>())");
                concurrentHashMap2.put(str2, synchronizedList);
                linkedList.add(t);
            }
        }
        for (bdo bdo : linkedList) {
            LinkedList<bdo> linkedList3 = this.field_ctrInfo.GaM;
            p.g(linkedList3, "field_ctrInfo.show_infos");
            for (T t2 : linkedList3) {
                if (p.j(t2.Bvg, bdo.path) && (list = this.tLl.get(bdo.path)) != null) {
                    String str3 = t2.path;
                    if (str3 == null) {
                        str3 = "";
                    }
                    list.add(str3);
                }
            }
        }
        AppMethodBeat.o(178197);
        return this;
    }

    private final void g(bbi bbi) {
        byte[] bArr;
        AppMethodBeat.i(243636);
        FinderTipsShowEntranceExtInfo finderTipsShowEntranceExtInfo = new FinderTipsShowEntranceExtInfo();
        LinkedList<bdo> linkedList = bbi.GaM;
        p.g(linkedList, "proto.show_infos");
        for (T t : linkedList) {
            if (t.LNn == 1) {
                com.tencent.mm.bw.b bVar = t.LNo;
                if (bVar != null) {
                    bArr = bVar.zy;
                } else {
                    bArr = null;
                }
                finderTipsShowEntranceExtInfo.parseFrom(bArr);
            }
        }
        this.field_tipsShowEntranceExtInfo = finderTipsShowEntranceExtInfo;
        AppMethodBeat.o(243636);
    }

    public static /* synthetic */ boolean a(k kVar, c cVar) {
        AppMethodBeat.i(243638);
        boolean a2 = kVar.a(cVar, true);
        AppMethodBeat.o(243638);
        return a2;
    }

    public final String toString() {
        AppMethodBeat.i(243639);
        String str = this.field_tipsId + ' ' + this.field_ctrInfo.type + ' ' + this.field_time + ' ' + this.field_ctrInfo.priority + ' ' + this.field_revokeId + ' ' + this.field_ctrInfo.GaM.size();
        AppMethodBeat.o(243639);
        return str;
    }

    public final boolean dbz() {
        AppMethodBeat.i(178200);
        LinkedList<bdo> linkedList = this.field_ctrInfo.GaM;
        if (linkedList == null || linkedList.isEmpty()) {
            AppMethodBeat.o(178200);
            return true;
        }
        AppMethodBeat.o(178200);
        return false;
    }

    public static /* synthetic */ boolean b(k kVar, c cVar) {
        AppMethodBeat.i(243641);
        boolean b2 = kVar.b(cVar, true);
        AppMethodBeat.o(243641);
        return b2;
    }

    public final boolean b(c cVar, boolean z) {
        AppMethodBeat.i(243640);
        p.h(cVar, "storage");
        this.field_ctrInfo.GaM.clear();
        this.tLk.clear();
        this.tLl.clear();
        boolean a2 = a(cVar, z);
        AppMethodBeat.o(243640);
        return a2;
    }

    public final bdo atl(String str) {
        AppMethodBeat.i(178201);
        p.h(str, "path");
        bdo bdo = this.tLk.get(str);
        AppMethodBeat.o(178201);
        return bdo;
    }

    public final LinkedList<String> atm(String str) {
        boolean z;
        bdo remove;
        boolean z2;
        boolean z3 = false;
        boolean z4 = true;
        AppMethodBeat.i(178202);
        p.h(str, "path");
        LinkedList<String> linkedList = new LinkedList<>();
        bdo bdo = this.tLk.get(str);
        if (bdo == null || bdo.LNm != 1) {
            if (bdo != null && bdo.LNm == 2) {
                List<String> list = this.tLl.get(str);
                if (list != null) {
                    List<String> list2 = list;
                    synchronized (list2) {
                        try {
                            Iterator<T> it = list2.iterator();
                            z = false;
                            while (it.hasNext()) {
                                if (this.tLk.containsKey(it.next())) {
                                    z2 = true;
                                } else {
                                    z2 = z;
                                }
                                z = z2;
                            }
                            x xVar = x.SXb;
                        } catch (Throwable th) {
                            AppMethodBeat.o(178202);
                            throw th;
                        }
                    }
                } else {
                    z = false;
                }
                if (!z && (remove = this.tLk.remove(str)) != null) {
                    linkedList.add(str);
                    String str2 = remove.Bvg;
                    if (!(str2 == null || str2.length() == 0)) {
                        z4 = false;
                    }
                    if (!z4) {
                        String str3 = remove.Bvg;
                        if (str3 == null) {
                            str3 = "";
                        }
                        String str4 = remove.path;
                        if (str4 == null) {
                            str4 = "";
                        }
                        gJ(str3, str4);
                        String str5 = remove.Bvg;
                        if (str5 == null) {
                            str5 = "";
                        }
                        linkedList.addAll(atm(str5));
                    }
                    LinkedList<bdo> linkedList2 = this.field_ctrInfo.GaM;
                    p.g(linkedList2, "field_ctrInfo.show_infos");
                    j.c((List) linkedList2, (kotlin.g.a.b) new d(this, linkedList, str));
                }
            }
            AppMethodBeat.o(178202);
            return linkedList;
        }
        bdo remove2 = this.tLk.remove(str);
        if (remove2 != null) {
            linkedList.add(str);
            String str6 = remove2.Bvg;
            if (str6 == null || str6.length() == 0) {
                z3 = true;
            }
            if (!z3) {
                String str7 = remove2.Bvg;
                if (str7 == null) {
                    str7 = "";
                }
                String str8 = remove2.path;
                if (str8 == null) {
                    str8 = "";
                }
                gJ(str7, str8);
                String str9 = remove2.Bvg;
                if (str9 == null) {
                    str9 = "";
                }
                linkedList.addAll(atm(str9));
            }
            LinkedList<bdo> linkedList3 = this.field_ctrInfo.GaM;
            p.g(linkedList3, "field_ctrInfo.show_infos");
            j.c((List) linkedList3, (kotlin.g.a.b) new c(this, linkedList, str));
        }
        AppMethodBeat.o(178202);
        return linkedList;
    }

    private final void gJ(String str, String str2) {
        AppMethodBeat.i(178203);
        bdo bdo = this.tLk.get(str);
        if (bdo == null || bdo.LNm != 2) {
            AppMethodBeat.o(178203);
            return;
        }
        List<String> list = this.tLl.get(str);
        if (list != null) {
            p.g(list, "list");
            com.tencent.mm.ac.d.a(list, new b(str2));
            AppMethodBeat.o(178203);
            return;
        }
        AppMethodBeat.o(178203);
    }

    private final void dby() {
        boolean z;
        AppMethodBeat.i(243635);
        try {
            com.tencent.mm.bw.b bVar = this.field_ctrInfo.LKL;
            if (bVar != null) {
                this.tLm.parseFrom(bVar.zy);
            }
            if (this.tLm.tab_type == 0) {
                FinderTipsShowEntranceExtInfo finderTipsShowEntranceExtInfo = this.field_tipsShowEntranceExtInfo;
                this.tLm.tabTipsByPassInfo = finderTipsShowEntranceExtInfo.tabTipsByPassInfo;
                this.tLm.username = finderTipsShowEntranceExtInfo.username;
                this.tLm.tab_type = finderTipsShowEntranceExtInfo.tab_type;
                this.tLm.object_id = finderTipsShowEntranceExtInfo.object_id;
                this.tLm.object_nonce_id = finderTipsShowEntranceExtInfo.object_nonce_id;
                Log.i("Finder.RedDotManager", "[parseRedDotExtInfo] use old logic for FinderRedDotExtInfo. tabTipsByPassInfo=" + (finderTipsShowEntranceExtInfo.tabTipsByPassInfo != null) + " tipsId=" + this.field_tipsId);
                AppMethodBeat.o(243635);
                return;
            }
            StringBuilder sb = new StringBuilder("[parseRedDotExtInfo] tabTipsByPassInfo=");
            if (this.tLm.tabTipsByPassInfo != null) {
                z = true;
            } else {
                z = false;
            }
            Log.i("Finder.RedDotManager", sb.append(z).append(" tipsId=").append(this.field_tipsId).toString());
            AppMethodBeat.o(243635);
        } catch (Exception e2) {
            Log.printDebugStack("Finder.RedDotCtrInfo", "", e2);
            AppMethodBeat.o(243635);
        }
    }

    public static final class f extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ k tLp;
        final /* synthetic */ c tLs;
        final /* synthetic */ k tLt;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(k kVar, c cVar, k kVar2) {
            super(0);
            this.tLp = kVar;
            this.tLs = cVar;
            this.tLt = kVar2;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            boolean replace;
            AppMethodBeat.i(243633);
            long currentTimeMillis = System.currentTimeMillis();
            if (this.tLp.dbz()) {
                replace = this.tLs.delete(this.tLt, new String[0]);
            } else {
                replace = this.tLs.replace(this.tLt);
            }
            Log.i("Finder.RedDotCtrInfo", "[store] ret=" + replace + " cost=" + (System.currentTimeMillis() - currentTimeMillis));
            x xVar = x.SXb;
            AppMethodBeat.o(243633);
            return xVar;
        }
    }

    public static final class e extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ kotlin.g.a.a qgW;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(kotlin.g.a.a aVar) {
            super(0);
            this.qgW = aVar;
        }

        @Override // kotlin.g.a.a
        public final /* bridge */ /* synthetic */ x invoke() {
            AppMethodBeat.i(243632);
            this.qgW.invoke();
            x xVar = x.SXb;
            AppMethodBeat.o(243632);
            return xVar;
        }
    }

    private boolean a(c cVar, boolean z) {
        boolean z2;
        boolean z3;
        AppMethodBeat.i(243637);
        p.h(cVar, "storage");
        String str = this.field_ctrInfo.LKM;
        if (str == null || str.length() == 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (!z2) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (!z3) {
            Log.e("Finder.RedDotCtrInfo", this.field_tipsId + " is inValid");
            AppMethodBeat.o(243637);
            return false;
        }
        k kVar = new k();
        bbi bbi = new bbi();
        bbi.priority = this.field_ctrInfo.priority;
        bbi.type = this.field_ctrInfo.type;
        bbi.LKL = this.field_ctrInfo.LKL;
        bbi.GaM.addAll(this.field_ctrInfo.GaM);
        bbi.LKM = this.field_ctrInfo.LKM;
        bbi.pRN = this.field_ctrInfo.pRN;
        bbi.feedId = this.field_ctrInfo.feedId;
        bbi.LKN = this.field_ctrInfo.LKN;
        bbi.MQX = this.field_ctrInfo.MQX;
        kVar.field_ctrInfo = bbi;
        kVar.field_tipsId = this.field_tipsId;
        kVar.field_time = this.field_time;
        kVar.field_revokeId = this.field_revokeId;
        kVar.field_ctrType = this.field_ctrType;
        kVar.field_expiredTime = this.field_expiredTime;
        kVar.field_tipsShowEntranceExtInfo = this.field_tipsShowEntranceExtInfo;
        f fVar = new f(this, cVar, kVar);
        if (z) {
            com.tencent.mm.ac.d.c("Finder.RedDotCtrInfo", new e(fVar));
        } else {
            fVar.invoke();
        }
        AppMethodBeat.o(243637);
        return true;
    }
}
