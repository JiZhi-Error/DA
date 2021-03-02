package com.tencent.mm.plugin.sns.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.data.e;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.model.an;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.ui.bi;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public final class bj extends d<SnsInfo> {
    Comparator<SnsInfo> DGA = new Comparator<SnsInfo>() {
        /* class com.tencent.mm.plugin.sns.ui.bj.AnonymousClass1 */

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // java.util.Comparator
        public final /* synthetic */ int compare(SnsInfo snsInfo, SnsInfo snsInfo2) {
            AppMethodBeat.i(203635);
            SnsInfo snsInfo3 = snsInfo;
            SnsInfo snsInfo4 = snsInfo2;
            if (snsInfo3.localid == -1) {
                AppMethodBeat.o(203635);
                return -1;
            } else if (snsInfo4.localid == -1) {
                AppMethodBeat.o(203635);
                return 1;
            } else if (snsInfo3.getHead() != snsInfo4.getHead()) {
                int head = snsInfo4.getHead() - snsInfo3.getHead();
                AppMethodBeat.o(203635);
                return head;
            } else if (snsInfo3.getCreateTime() != snsInfo4.getCreateTime()) {
                int createTime = snsInfo4.getCreateTime() - snsInfo3.getCreateTime();
                AppMethodBeat.o(203635);
                return createTime;
            } else {
                AppMethodBeat.o(203635);
                return 0;
            }
        }
    };
    private bi.a EIS;
    private e EIT;
    boolean EIV = false;
    private int Eny = 0;
    private int Enz = 0;
    private boolean dJM = false;
    List<SnsInfo> list = new ArrayList();
    private boolean vUk = false;

    public bj(bi.a aVar, boolean z) {
        AppMethodBeat.i(99068);
        this.EIS = aVar;
        this.dJM = z;
        AppMethodBeat.o(99068);
    }

    public final void aq(boolean z, boolean z2) {
        AppMethodBeat.i(99069);
        this.vUk = z;
        pN(z2);
        AppMethodBeat.o(99069);
    }

    /* access modifiers changed from: package-private */
    public final void g(boolean z, List<SnsInfo> list2) {
        int i2;
        int i3;
        AppMethodBeat.i(203636);
        this.EIT = new e();
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        HashMap hashMap3 = new HashMap();
        long currentTimeMillis = System.currentTimeMillis();
        int i4 = 0;
        int i5 = 0;
        if (z && this.dJM) {
            SnsInfo snsInfo = new SnsInfo(0);
            snsInfo.field_snsId = 0;
            snsInfo.localid = -1;
            snsInfo.setCreateTime((int) (System.currentTimeMillis() / 1000));
            list2.add(0, snsInfo);
        }
        int size = list2.size();
        Log.d("MicroMsg.SnsSelfAdapterSearchHelper", "initFixType ".concat(String.valueOf(size)));
        int i6 = 0;
        int i7 = 0;
        while (i6 < size) {
            this.EIT.eZq();
            if (i6 + 1 < size) {
                SnsInfo snsInfo2 = list2.get(i6 + 1);
                this.EIT.DDu = snsInfo2.getHead();
                TimeLineObject timeLine = snsInfo2.getTimeLine();
                this.EIT.DDx = timeLine.ContentDesc;
                this.EIT.DDv = an.aQ(snsInfo2.getLocalPrivate(), this.dJM);
                this.EIT.DDw = snsInfo2.getTypeFlag();
                if (timeLine.ContentObj != null) {
                    this.EIT.uUn = timeLine.ContentObj.LoV.size();
                } else {
                    this.EIT.uUn = 0;
                }
            }
            if (i6 + 2 < size) {
                SnsInfo snsInfo3 = list2.get(i6 + 2);
                this.EIT.DDD = snsInfo3.getHead();
                TimeLineObject timeLine2 = snsInfo3.getTimeLine();
                this.EIT.DDy = timeLine2.ContentDesc;
                this.EIT.DDE = an.aQ(snsInfo3.getLocalPrivate(), this.dJM);
                this.EIT.DDF = snsInfo3.getTypeFlag();
                if (timeLine2.ContentObj != null) {
                    this.EIT.DDG = timeLine2.ContentObj.LoV.size();
                } else {
                    this.EIT.DDG = 0;
                }
            }
            SnsInfo snsInfo4 = list2.get(i6);
            this.EIT.DDt = snsInfo4.getHead();
            TimeLineObject timeLine3 = snsInfo4.getTimeLine();
            this.EIT.DDz = timeLine3.ContentDesc;
            this.EIT.DDA = snsInfo4.getTypeFlag();
            this.EIT.DDC = an.aQ(snsInfo4.getLocalPrivate(), this.dJM);
            if (timeLine3.ContentObj != null) {
                this.EIT.DDB = timeLine3.ContentObj.LoV.size();
            } else {
                this.EIT.DDB = 0;
            }
            if (this.EIT.eZr()) {
                i2 = 1;
            } else if (this.EIT.eZs()) {
                i2 = 2;
            } else {
                i2 = 3;
            }
            hashMap.put(Integer.valueOf(i7), Integer.valueOf(i4));
            hashMap2.put(Integer.valueOf(i7), Integer.valueOf(i2));
            i4 += i2;
            hashMap3.put(Integer.valueOf(i7), Integer.valueOf(i5));
            if (!this.dJM || i6 != 0) {
                i3 = 0;
                if (i2 > 0 && this.EIT.DDA == 1) {
                    i3 = 1;
                }
                if (i2 >= 2 && this.EIT.DDw == 1) {
                    i3++;
                }
                if (i2 >= 3 && this.EIT.DDF == 1) {
                    i3++;
                }
            } else {
                i3 = 0;
            }
            i5 += i3;
            i6 = i2 + i6;
            i7++;
        }
        this.Eny = i7;
        this.Enz = list2.size();
        Log.d("MicroMsg.SnsSelfAdapterSearchHelper", "icount " + this.Eny);
        this.list = list2;
        r.bm("SnsphotoAdapter initFixType ", currentTimeMillis);
        this.EIS.b(this.list, hashMap, hashMap2, hashMap3, this.Enz, this.Eny);
        AppMethodBeat.o(203636);
    }

    @Override // com.tencent.mm.plugin.sns.ui.d
    public final void gZ(List<SnsInfo> list2) {
        AppMethodBeat.i(99071);
        if (this.EIS != null) {
            if (list2 != null) {
                g(this.EIV, list2);
            }
            this.EIS.fiF();
        }
        AppMethodBeat.o(99071);
    }

    @Override // com.tencent.mm.plugin.sns.ui.d
    public final List<SnsInfo> anm() {
        AppMethodBeat.i(99072);
        List<SnsInfo> kh = an.kh(r.Jc(an.DIf), r.Jc(an.DIg));
        Log.i("MicroMsg.SnsSelfAdapterSearchHelper", "loadData thread: %d count: %d", Long.valueOf(Thread.currentThread().getId()), Integer.valueOf(kh.size()));
        AppMethodBeat.o(99072);
        return kh;
    }
}
