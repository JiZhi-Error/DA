package com.tencent.mm.plugin.sns.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.data.e;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.an;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class bi extends d<SnsInfo> {
    private Comparator<SnsInfo> DGA = new Comparator<SnsInfo>() {
        /* class com.tencent.mm.plugin.sns.ui.bi.AnonymousClass1 */

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // java.util.Comparator
        public final /* synthetic */ int compare(SnsInfo snsInfo, SnsInfo snsInfo2) {
            AppMethodBeat.i(203634);
            SnsInfo snsInfo3 = snsInfo;
            SnsInfo snsInfo4 = snsInfo2;
            if (snsInfo3.localid == -1) {
                AppMethodBeat.o(203634);
                return -1;
            } else if (snsInfo4.localid == -1) {
                AppMethodBeat.o(203634);
                return 1;
            } else if (snsInfo3.getHead() != snsInfo4.getHead()) {
                int head = snsInfo4.getHead() - snsInfo3.getHead();
                AppMethodBeat.o(203634);
                return head;
            } else if (snsInfo3.getCreateTime() != snsInfo4.getCreateTime()) {
                int createTime = snsInfo4.getCreateTime() - snsInfo3.getCreateTime();
                AppMethodBeat.o(203634);
                return createTime;
            } else {
                AppMethodBeat.o(203634);
                return 0;
            }
        }
    };
    private a EIS;
    private e EIT;
    private int Eny = 0;
    private int Enz = 0;
    private boolean dJM = false;
    List<SnsInfo> list = new ArrayList();
    private String sNG = "";
    private String userName = "";
    private boolean vUk = false;

    public interface a {
        void b(List<SnsInfo> list, Map<Integer, Integer> map, Map<Integer, Integer> map2, Map<Integer, Integer> map3, int i2, int i3);

        void fiF();
    }

    public bi(a aVar, String str, boolean z) {
        AppMethodBeat.i(99057);
        this.EIS = aVar;
        this.userName = str;
        this.dJM = z;
        AppMethodBeat.o(99057);
    }

    @Override // com.tencent.mm.plugin.sns.ui.d
    public final void gZ(List<SnsInfo> list2) {
        AppMethodBeat.i(99058);
        if (this.EIS != null) {
            if (list2 != null) {
                g(true, list2);
            }
            this.EIS.fiF();
        }
        AppMethodBeat.o(99058);
    }

    @Override // com.tencent.mm.plugin.sns.ui.d
    public final List<SnsInfo> anm() {
        AppMethodBeat.i(99059);
        List<SnsInfo> a2 = an.a(this.userName, this.dJM, this.sNG, this.vUk);
        Log.i("MicroMsg.SnsSelfHelper", "loadData thread: %d count: %d", Long.valueOf(Thread.currentThread().getId()), Integer.valueOf(a2.size()));
        AppMethodBeat.o(99059);
        return a2;
    }

    /* access modifiers changed from: package-private */
    public final boolean he(List<Integer> list2) {
        AppMethodBeat.i(99060);
        if (list2 == null || list2.size() == 0) {
            AppMethodBeat.o(99060);
            return false;
        }
        Log.d("MicroMsg.SnsSelfHelper", "remove Items");
        boolean z = false;
        for (Integer num : list2) {
            int intValue = num.intValue();
            int size = this.list.size();
            int i2 = 1;
            while (true) {
                if (i2 >= size) {
                    break;
                }
                SnsInfo snsInfo = this.list.get(i2);
                if (snsInfo != null && snsInfo.localid == intValue) {
                    this.list.remove(i2);
                    z = true;
                    break;
                }
                i2++;
            }
        }
        AppMethodBeat.o(99060);
        return z;
    }

    /* access modifiers changed from: package-private */
    public final boolean hf(List<Integer> list2) {
        boolean z;
        AppMethodBeat.i(99061);
        if (list2 == null || list2.size() == 0) {
            AppMethodBeat.o(99061);
            return false;
        }
        Log.d("MicroMsg.SnsSelfHelper", "change Items");
        LinkedList linkedList = new LinkedList();
        int i2 = 1;
        boolean z2 = false;
        while (i2 < this.list.size()) {
            SnsInfo snsInfo = this.list.get(i2);
            if (snsInfo != null) {
                Iterator<Integer> it = list2.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    int intValue = it.next().intValue();
                    if (snsInfo.localid == intValue) {
                        Log.d("MicroMsg.SnsSelfHelper", "update list localId ".concat(String.valueOf(intValue)));
                        this.list.remove(i2);
                        linkedList.add(aj.faO().Zr(intValue));
                        i2--;
                        z = true;
                        break;
                    }
                }
            }
            z = z2;
            i2++;
            z2 = z;
        }
        Iterator it2 = linkedList.iterator();
        while (it2.hasNext()) {
            this.list.add((SnsInfo) it2.next());
        }
        AppMethodBeat.o(99061);
        return z2;
    }

    public final void fiH() {
        AppMethodBeat.i(99062);
        Collections.sort(this.list, this.DGA);
        AppMethodBeat.o(99062);
    }

    /* access modifiers changed from: package-private */
    public final void fiI() {
        AppMethodBeat.i(99063);
        g(false, this.list);
        AppMethodBeat.o(99063);
    }

    public final void k(String str, boolean z, boolean z2) {
        AppMethodBeat.i(99064);
        Log.d("MicroMsg.SnsSelfHelper", "limitSeq ".concat(String.valueOf(str)));
        this.sNG = str;
        this.vUk = z;
        pN(z2);
        AppMethodBeat.o(99064);
    }

    private int iQ(int i2, int i3) {
        int i4 = 0;
        if (this.dJM && i2 == 0) {
            return 0;
        }
        if (i3 > 0 && this.EIT.DDA == 1) {
            i4 = 1;
        }
        if (i3 >= 2 && this.EIT.DDw == 1) {
            i4++;
        }
        if (i3 < 3 || this.EIT.DDF != 1) {
            return i4;
        }
        return i4 + 1;
    }

    private int b(int i2, int i3, List<SnsInfo> list2) {
        AppMethodBeat.i(99065);
        this.EIT.eZq();
        if (!this.dJM || i2 != 0) {
            if (i2 + 1 < i3) {
                SnsInfo snsInfo = list2.get(i2 + 1);
                this.EIT.DDu = snsInfo.getHead();
                TimeLineObject timeLine = snsInfo.getTimeLine();
                this.EIT.DDx = timeLine.ContentDesc;
                this.EIT.DDv = an.aQ(snsInfo.getLocalPrivate(), this.dJM);
                this.EIT.DDw = snsInfo.getTypeFlag();
                if (timeLine.ContentObj != null) {
                    this.EIT.uUn = timeLine.ContentObj.LoV.size();
                } else {
                    this.EIT.uUn = 0;
                }
            }
            if (i2 + 2 < i3) {
                SnsInfo snsInfo2 = list2.get(i2 + 2);
                this.EIT.DDD = snsInfo2.getHead();
                TimeLineObject timeLine2 = snsInfo2.getTimeLine();
                this.EIT.DDy = timeLine2.ContentDesc;
                this.EIT.DDE = an.aQ(snsInfo2.getLocalPrivate(), this.dJM);
                this.EIT.DDF = snsInfo2.getTypeFlag();
                if (timeLine2.ContentObj != null) {
                    this.EIT.DDG = timeLine2.ContentObj.LoV.size();
                } else {
                    this.EIT.DDG = 0;
                }
            }
            SnsInfo snsInfo3 = list2.get(i2);
            this.EIT.DDt = snsInfo3.getHead();
            TimeLineObject timeLine3 = snsInfo3.getTimeLine();
            this.EIT.DDz = timeLine3.ContentDesc;
            this.EIT.DDA = snsInfo3.getTypeFlag();
            this.EIT.DDC = an.aQ(snsInfo3.getLocalPrivate(), this.dJM);
            if (timeLine3.ContentObj != null) {
                this.EIT.DDB = timeLine3.ContentObj.LoV.size();
            } else {
                this.EIT.DDB = 0;
            }
            if (this.EIT.eZr()) {
                AppMethodBeat.o(99065);
                return 1;
            } else if (this.EIT.eZs()) {
                AppMethodBeat.o(99065);
                return 2;
            } else {
                AppMethodBeat.o(99065);
                return 3;
            }
        } else {
            AppMethodBeat.o(99065);
            return 1;
        }
    }

    private void f(boolean z, List<SnsInfo> list2) {
        AppMethodBeat.i(99066);
        if (!z) {
            AppMethodBeat.o(99066);
            return;
        }
        if (this.dJM) {
            SnsInfo snsInfo = new SnsInfo(0);
            snsInfo.field_snsId = 0;
            snsInfo.localid = -1;
            snsInfo.setCreateTime((int) (System.currentTimeMillis() / 1000));
            list2.add(0, snsInfo);
        }
        AppMethodBeat.o(99066);
    }

    private void g(boolean z, List<SnsInfo> list2) {
        AppMethodBeat.i(99067);
        this.EIT = new e();
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        HashMap hashMap3 = new HashMap();
        long currentTimeMillis = System.currentTimeMillis();
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        f(z, list2);
        int size = list2.size();
        Log.d("MicroMsg.SnsSelfHelper", "initFixType ".concat(String.valueOf(size)));
        int i5 = 0;
        while (i5 < size) {
            int b2 = b(i5, size, list2);
            hashMap.put(Integer.valueOf(i4), Integer.valueOf(i2));
            hashMap2.put(Integer.valueOf(i4), Integer.valueOf(b2));
            i2 += b2;
            hashMap3.put(Integer.valueOf(i4), Integer.valueOf(i3));
            i3 += iQ(i5, b2);
            i5 += b2;
            i4++;
        }
        this.Eny = i4;
        this.Enz = list2.size();
        Log.d("MicroMsg.SnsSelfHelper", "icount " + this.Eny);
        this.list = list2;
        r.bm("SnsphotoAdapter initFixType ", currentTimeMillis);
        this.EIS.b(this.list, hashMap, hashMap2, hashMap3, this.Enz, this.Eny);
        AppMethodBeat.o(99067);
    }
}
