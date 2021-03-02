package com.tencent.mm.plugin.sns.model;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.kd;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.j.k;
import com.tencent.mm.plugin.sns.j.l;
import com.tencent.mm.plugin.sns.k.e;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class aw {
    public long DNA = 0;
    public List<Long> DNB = new ArrayList();
    public boolean DNC = false;
    public long DND = 0;
    public long DNE = 0;
    public int DNF = ax.DOf;
    public boolean DNG = false;
    public boolean DNH = false;
    public boolean DNI = false;
    public k DNJ = new k();
    public l DNK = null;
    public long DNL = 0;
    public long DNM = 0;
    public long DNN = 0;
    public long DNO = 0;
    public l DNP = null;
    public l DNQ = null;
    public int DNR = 0;
    public long DNS = 0;
    public av DNT = new av();
    public String DNm = "";
    public boolean DNn = false;
    public long DNo = 3600;
    public long DNp = 86400;
    public int DNq = 5;
    public int DNr = 5;
    public int DNs = 50;
    public int DNt = 30;
    public int DNu = 5;
    public long DNv = 0;
    int DNw = 50;
    public int DNx = 0;
    public Map<Long, Integer> DNy = new HashMap();
    public View DNz = null;
    public String sessionId = "";

    public aw() {
        AppMethodBeat.i(179099);
        AppMethodBeat.o(179099);
    }

    static /* synthetic */ void a(aw awVar) {
        AppMethodBeat.i(202791);
        awVar.fbF();
        AppMethodBeat.o(202791);
    }

    public final boolean fbD() {
        AppMethodBeat.i(179100);
        if (this.DNK == null || Util.isNullOrNil(this.DNK.tbl)) {
            AppMethodBeat.o(179100);
            return false;
        }
        AppMethodBeat.o(179100);
        return true;
    }

    /* access modifiers changed from: package-private */
    public final boolean a(l lVar) {
        AppMethodBeat.i(179101);
        if (Util.isNullOrNil(lVar.tbl) || lVar.tbl.size() < this.DNq || Util.secondsToNow(lVar.timestamp) > this.DNp || Util.secondsToNow(lVar.timestamp) < this.DNo || lVar.state == 2) {
            AppMethodBeat.o(179101);
            return true;
        }
        AppMethodBeat.o(179101);
        return false;
    }

    public final void fbE() {
        boolean z;
        AppMethodBeat.i(179102);
        if (!Util.isNullOrNil(this.DNJ.DRY)) {
            Iterator<l> it = this.DNJ.DRY.iterator();
            while (it.hasNext()) {
                l next = it.next();
                if (Util.secondsToNow(next.timestamp) > this.DNp) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    Log.i("MicroMsg.SnsUnreadTipManager", "prepareLastUnreadTipFaultReadCache remove invalid fault:[%s, %s]", Long.valueOf(next.timestamp), Integer.valueOf(next.tbl.size()));
                    it.remove();
                }
            }
        }
        AppMethodBeat.o(179102);
    }

    public final void fbF() {
        AppMethodBeat.i(179103);
        if (this.DNJ.DRZ == 0 || Util.isNullOrNil(this.DNJ.DRY)) {
            this.DNK = null;
            this.DNL = 0;
            this.DNJ.DRZ = 0;
            this.DNA = 0;
            Log.i("MicroMsg.SnsUnreadTipManager", "findTargetItem unreadSnsItems is null");
            h.INSTANCE.n(1295, 0, 0);
        } else {
            this.DNK = null;
            int size = this.DNJ.DRY.size() - 1;
            while (true) {
                if (size < 0) {
                    break;
                }
                l lVar = this.DNJ.DRY.get(size);
                if (!a(lVar) && lVar.tbl.peek().longValue() < this.DNJ.DRZ) {
                    this.DNK = lVar;
                    Log.i("MicroMsg.SnsUnreadTipManager", "findTargetItem result:[%s,%s]", Long.valueOf(this.DNK.timestamp), Integer.valueOf(this.DNK.tbl.size()));
                    break;
                }
                size--;
            }
            if (this.DNK != null) {
                this.DNL = this.DNJ.DRZ;
                this.DNA = this.DNK.tbl.peek().longValue();
                if (this.DNL == 0 || this.DNK == null || Util.isNullOrNil(this.DNK.tbl)) {
                    this.DNx = 0;
                } else {
                    n faO = aj.faO();
                    String Jc = r.Jc(this.DNM);
                    String Jc2 = r.Jc(this.DNK.tbl.peek().longValue());
                    String str = "select snsId from SnsInfo  where " + n.feO();
                    if (n.aQw(Jc)) {
                        str = str + " AND " + faO.aQA(Jc);
                    }
                    if (n.aQw(Jc2)) {
                        str = str + " AND " + faO.aQz(Jc2);
                    }
                    String str2 = str + n.Emu;
                    Log.d("MicroMsg.SnsInfoStorage", "getAdCursorForTimeLine:%s upLimtiSeq:%s downLimitSeq:%s", str2, Jc, Jc2);
                    this.DNx = faO.iFy.rawQuery(str2, null).getCount();
                    Log.i("MicroMsg.SnsUnreadTipManager", "calculateFeedsGapCount up:%s down:%s", Long.valueOf(this.DNL), this.DNK.tbl.peek());
                }
                Log.i("MicroMsg.SnsUnreadTipManager", "calculateFeedsGapCount:%s", Integer.valueOf(this.DNx));
                if (this.DNK.state == 0) {
                    av avVar = this.DNT;
                    l lVar2 = this.DNK;
                    if (lVar2 != null) {
                        LinkedList<Long> linkedList = lVar2.tbl;
                        avVar.DNj.clear();
                        avVar.DNj.addAll(linkedList);
                        avVar.DNk = lVar2;
                        if (!Util.isNullOrNil(avVar.DNj)) {
                            Log.i("MicroMsg.SnsUnreadPreloader", "start preload unread fault:[%s, %s], preloadCount:%s, unreadItem:%s", Long.valueOf(lVar2.timestamp), Integer.valueOf(lVar2.tbl.size()), Integer.valueOf(lVar2.DSd), lVar2);
                            lVar2.DSd++;
                            g.aAg().hqi.a(new z(avVar.DNj.get(0).longValue() + 1, 0, 2), 0);
                        }
                    }
                }
            }
            h.INSTANCE.n(1295, 0, (long) this.DNJ.DRY.size());
        }
        this.DNQ = this.DNK;
        Log.i("MicroMsg.SnsUnreadTipManager", "findTargetItem firstUnreadId:%s, indicatorSnsId:%s", Long.valueOf(this.DNA), Long.valueOf(this.DNL));
        AppMethodBeat.o(179103);
    }

    public final void fbG() {
        AppMethodBeat.i(179104);
        aj.eJP().post(new Runnable() {
            /* class com.tencent.mm.plugin.sns.model.aw.AnonymousClass1 */

            public final void run() {
                SnsInfo JJ;
                AppMethodBeat.i(179095);
                if (!(aw.this.DNJ == null || (JJ = aj.faO().JJ(aw.this.DNJ.DRZ)) == null)) {
                    aw.this.DNO = (long) (JJ.field_createTime + 1);
                }
                AppMethodBeat.o(179095);
            }
        });
        AppMethodBeat.o(179104);
    }

    public final void fbH() {
        AppMethodBeat.i(179105);
        if (this.DNn) {
            Log.i("MicroMsg.SnsUnreadTipManager", "==============dumpSnsUnreadFault==============");
            if (Util.isNullOrNil(this.DNJ.DRY)) {
                Log.i("MicroMsg.SnsUnreadTipManager", "** unread fault is null **");
                AppMethodBeat.o(179105);
                return;
            }
            Log.i("MicroMsg.SnsUnreadTipManager", "** unread fault count:%s **", Integer.valueOf(this.DNJ.DRY.size()));
            Iterator<l> it = this.DNJ.DRY.iterator();
            while (it.hasNext()) {
                l next = it.next();
                Log.i("MicroMsg.SnsUnreadTipManager", "** [%s, %s] **", Long.valueOf(next.timestamp), Integer.valueOf(next.tbl.size()));
                Iterator<Long> it2 = next.tbl.iterator();
                while (it2.hasNext()) {
                    Log.i("MicroMsg.SnsUnreadTipManager", "|__ snsId:%s", it2.next());
                }
            }
        }
        AppMethodBeat.o(179105);
    }

    private void fbI() {
        AppMethodBeat.i(179106);
        if (BuildInfo.DEBUG || BuildInfo.IS_FLAVOR_PURPLE || BuildInfo.IS_FLAVOR_RED) {
            if (this.DNK != null) {
                Log.i("MicroMsg.SnsUnreadTipManager", "target:[%s, %s]", Long.valueOf(this.DNK.timestamp), Integer.valueOf(this.DNK.tbl.size()));
            } else {
                Log.i("MicroMsg.SnsUnreadTipManager", "target:null");
            }
            if (!Util.isNullOrNil(this.DNJ.DRY)) {
                Iterator<l> it = this.DNJ.DRY.iterator();
                while (it.hasNext()) {
                    l next = it.next();
                    Log.i("MicroMsg.SnsUnreadTipManager", "item:%s", Long.valueOf(next.timestamp));
                    Iterator<Long> it2 = next.tbl.iterator();
                    while (it2.hasNext()) {
                        Log.i("MicroMsg.SnsUnreadTipManager", "id:%s", it2.next());
                    }
                }
            }
        }
        AppMethodBeat.o(179106);
    }

    public final long fbJ() {
        AppMethodBeat.i(179107);
        if (!fbD()) {
            AppMethodBeat.o(179107);
            return -1;
        }
        long longValue = this.DNK.tbl.peek().longValue();
        AppMethodBeat.o(179107);
        return longValue;
    }

    public final void fbK() {
        AppMethodBeat.i(179108);
        if (this.DNn) {
            ArrayList arrayList = new ArrayList();
            HashMap hashMap = new HashMap();
            Map<String, Boolean> cMF = ((c) g.af(c.class)).cMF();
            if (cMF == null || cMF.size() == 0) {
                Log.d("MicroMsg.SnsUnreadTipManager", "getLegalFeedId is NullOrNil");
            } else {
                hashMap.putAll(cMF);
                for (Map.Entry entry : hashMap.entrySet()) {
                    if (!((Boolean) entry.getValue()).booleanValue()) {
                        arrayList.add(Long.valueOf(r.aOw((String) entry.getKey())));
                    }
                }
                Collections.sort(arrayList);
                if (Util.isNullOrNil(arrayList)) {
                    Log.d("MicroMsg.SnsUnreadTipManager", "exposeFeedList is NullOrNil");
                }
            }
            this.DNB.clear();
            if (!Util.isNullOrNil(arrayList)) {
                this.DNB.addAll(arrayList);
                if (this.DNL != 0 && this.DNN == 0 && this.DNB.contains(Long.valueOf(this.DNL))) {
                    this.DNN = (long) cl.aWB();
                    AppMethodBeat.o(179108);
                    return;
                }
            } else {
                Log.i("MicroMsg.SnsUnreadTipManager", "checkExposeFeeds newExposeSnsId isNullOrNil, return");
            }
        }
        AppMethodBeat.o(179108);
    }

    public final void Jw(long j2) {
        AppMethodBeat.i(179109);
        if (this.DNn && !Util.isNullOrNil(this.DNJ.DRY) && !this.DNH) {
            if (Util.isNullOrNil(this.DNB)) {
                Log.i("MicroMsg.SnsUnreadTipManager", "curExposeIdList isNullOrNil, return");
                AppMethodBeat.o(179109);
                return;
            }
            long longValue = this.DNB.get(0).longValue();
            Iterator<Long> it = this.DNB.iterator();
            while (it.hasNext()) {
                Log.d("MicroMsg.SnsUnreadTipManager", "exposeId:%s", it.next());
            }
            if (this.DNL != 0 && j2 == this.DNL) {
                this.DNR++;
                if (this.DNS == 0 && j2 == this.DNL) {
                    this.DNS = (long) cl.aWB();
                }
            }
            Iterator<l> it2 = this.DNJ.DRY.iterator();
            while (it2.hasNext()) {
                l next = it2.next();
                if (next == this.DNK) {
                    ArrayList arrayList = new ArrayList();
                    Iterator<Long> it3 = next.tbl.iterator();
                    while (it3.hasNext()) {
                        Long next2 = it3.next();
                        if (next2.longValue() >= longValue) {
                            arrayList.add(next2);
                        }
                    }
                    next.tbl.removeAll(arrayList);
                    if (Util.isNullOrNil(next.tbl)) {
                        this.DNK = null;
                    }
                } else {
                    next.tbl.removeAll(this.DNB);
                    Util.isNullOrNil(next.tbl);
                }
            }
            if (this.DNA != 0 && longValue <= this.DNA) {
                Log.i("MicroMsg.SnsUnreadTipManager", "alreadyReachFirstFaultItem:%s, %s <= %s", Boolean.valueOf(this.DNG), Long.valueOf(longValue), Long.valueOf(this.DNA));
                this.DNG = true;
                this.DNL = 0;
                this.DNJ.DRZ = 0;
            }
            Log.i("MicroMsg.SnsUnreadTipManager", "firstExposeId:%s, unreadCount:%s", Long.valueOf(longValue), Integer.valueOf(this.DNJ.DRY.size()));
            fbI();
        }
        AppMethodBeat.o(179109);
    }

    public final void Jx(long j2) {
        AppMethodBeat.i(179110);
        Log.i("MicroMsg.SnsUnreadTipManager", "removeFeed:%s", Long.valueOf(j2));
        if (!Util.isNullOrNil(this.DNJ.DRY)) {
            Iterator<l> it = this.DNJ.DRY.iterator();
            while (it.hasNext()) {
                l next = it.next();
                next.tbl.remove(Long.valueOf(j2));
                if (Util.isNullOrNil(next.tbl)) {
                    it.remove();
                    if (next == this.DNK) {
                        this.DNK = null;
                    }
                }
            }
        }
        AppMethodBeat.o(179110);
    }

    public final void fj(View view) {
        AppMethodBeat.i(179111);
        this.DNz = view;
        if (view == null || !(view.getTag() instanceof Long)) {
            this.DND = 0;
            AppMethodBeat.o(179111);
            return;
        }
        this.DND = ((Long) view.getTag()).longValue();
        AppMethodBeat.o(179111);
    }

    public final void fbL() {
        if (this.DNK != null) {
            this.DNK.state = 2;
        }
    }

    public final void fbM() {
        AppMethodBeat.i(179114);
        if (!this.DNn) {
            AppMethodBeat.o(179114);
            return;
        }
        final long j2 = this.DNO;
        final l lVar = this.DNP;
        final l lVar2 = this.DNQ;
        final LinkedList linkedList = new LinkedList(this.DNJ.DRY);
        aj.eJP().post(new Runnable() {
            /* class com.tencent.mm.plugin.sns.model.aw.AnonymousClass5 */

            public final void run() {
                int i2;
                AppMethodBeat.i(202789);
                if (lVar != null) {
                    kd kdVar = e.DUQ.DVy;
                    LinkedList linkedList = new LinkedList(lVar.DSa);
                    linkedList.removeAll(lVar.tbl);
                    LinkedList linkedList2 = new LinkedList();
                    LinkedList linkedList3 = new LinkedList();
                    int i3 = 0;
                    for (int i4 = 0; i4 < lVar.DSa.size(); i4++) {
                        if (i4 < aw.this.DNw * i3) {
                            List list = (List) linkedList2.peekLast();
                            if (list != null) {
                                list.add(lVar.DSa.get(i4));
                            }
                        } else {
                            i3++;
                            ArrayList arrayList = new ArrayList();
                            arrayList.add(lVar.DSa.get(i4));
                            linkedList2.add(arrayList);
                        }
                    }
                    int i5 = 0;
                    for (int i6 = 0; i6 < linkedList.size(); i6++) {
                        if (i6 < aw.this.DNw * i5) {
                            List list2 = (List) linkedList3.peekLast();
                            if (list2 != null) {
                                list2.add(linkedList.get(i6));
                            }
                        } else {
                            i5++;
                            ArrayList arrayList2 = new ArrayList();
                            arrayList2.add(linkedList.get(i6));
                            linkedList3.add(arrayList2);
                        }
                    }
                    int max = Math.max(linkedList3.size(), linkedList2.size());
                    long currentTimeMillis = System.currentTimeMillis();
                    for (int i7 = 0; i7 < max; i7++) {
                        StringBuffer stringBuffer = new StringBuffer();
                        StringBuffer stringBuffer2 = new StringBuffer();
                        int i8 = 0;
                        if (i7 < linkedList2.size()) {
                            List<Long> list3 = (List) linkedList2.get(i7);
                            i2 = list3.size();
                            for (Long l : list3) {
                                stringBuffer.append(r.Jc(l.longValue())).append("|");
                            }
                        } else {
                            i2 = 0;
                        }
                        if (i7 < linkedList3.size()) {
                            List<Long> list4 = (List) linkedList3.get(i7);
                            i8 = list4.size();
                            for (Long l2 : list4) {
                                stringBuffer2.append(r.Jc(l2.longValue())).append("|");
                            }
                        }
                        int i9 = 0;
                        int i10 = 0;
                        for (l lVar : linkedList) {
                            if (!aw.this.a(lVar)) {
                                i10++;
                            } else {
                                if (lVar != null && !Util.isNullOrNil(lVar.tbl)) {
                                    i9++;
                                }
                                i9 = i9;
                            }
                        }
                        if (lVar2 != null) {
                            if (!Util.isNullOrNil(lVar2.DSa)) {
                                kdVar.eTX = (long) (lVar2.DSa.size() - lVar2.DSc);
                                kdVar.eTW = (long) lVar2.DSa.size();
                            }
                            if (!Util.isNullOrNil(lVar2.tbl)) {
                                kdVar.eTE = lVar2.DSa.peek().longValue();
                                StringBuffer stringBuffer3 = new StringBuffer();
                                Iterator<Long> it = lVar2.tbl.iterator();
                                while (it.hasNext()) {
                                    stringBuffer3.append(r.Jc(it.next().longValue())).append("|");
                                }
                                kdVar.eTH = kdVar.x("JumpBreakLayerFeeds", stringBuffer3.toString(), true);
                            }
                        }
                        kdVar.eTV = aw.this.DNS;
                        kdVar.eiB = kdVar.x("SessionId", aw.this.sessionId, true);
                        kdVar.eTM = kdVar.x("NewFeeds", stringBuffer.toString(), true);
                        kdVar.eTN = (long) i2;
                        kdVar.eTO = kdVar.x("ExposureNewFeeds", stringBuffer2.toString(), true);
                        kdVar.eTP = (long) i8;
                        kdVar.eTQ = (long) i9;
                        kdVar.eTR = (long) i10;
                        kdVar.eTS = (long) aw.this.DNR;
                        kdVar.eTD = j2;
                        kdVar.eLd = currentTimeMillis;
                        kdVar.eMG = (long) i7;
                        kdVar.eMH = (long) max;
                        kdVar.bfK();
                    }
                    e.DUQ.DVy = new kd();
                    aw.this.DNR = 0;
                    aw.this.DNS = 0;
                }
                AppMethodBeat.o(202789);
            }
        });
        AppMethodBeat.o(179114);
    }

    static /* synthetic */ void a(aw awVar, List list) {
        AppMethodBeat.i(202790);
        Iterator<l> it = awVar.DNJ.DRY.iterator();
        while (it.hasNext()) {
            l next = it.next();
            ArrayList arrayList = new ArrayList();
            Iterator<Long> it2 = next.tbl.iterator();
            while (it2.hasNext()) {
                Long next2 = it2.next();
                if (!list.contains(next2)) {
                    arrayList.add(next2);
                }
            }
            next.tbl.removeAll(arrayList);
        }
        AppMethodBeat.o(202790);
    }
}
