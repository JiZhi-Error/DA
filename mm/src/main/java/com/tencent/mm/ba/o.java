package com.tencent.mm.ba;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.b.f;
import com.tencent.mm.ba.b;
import com.tencent.mm.g.a.pd;
import com.tencent.mm.kernel.g;
import com.tencent.mm.memory.a.c;
import com.tencent.mm.openim.b.l;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.appbrand.jsapi.pay.d;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.k;
import com.tencent.mm.protocal.protobuf.cwl;
import com.tencent.mm.protocal.protobuf.cxl;
import com.tencent.mm.protocal.protobuf.cxn;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.smtt.sdk.TbsListener;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class o implements i, j {
    public HashMap<Integer, HashSet<WeakReference<j.a>>> bGH;
    boolean iKb;
    long iKm;
    f<Integer, Integer> iWk;
    private final int iWp;
    MTimerHandler iWr;
    private f<Integer, Integer> jgs;
    j jgt;

    public o(j jVar) {
        AppMethodBeat.i(116849);
        this.iKb = false;
        this.iWk = new c(200);
        this.jgs = new c(200);
        this.bGH = new HashMap<>();
        this.iKm = 0;
        this.iWp = 500;
        this.iWr = new MTimerHandler(g.aAk().getLooper(), (MTimerHandler.CallBack) new MTimerHandler.CallBack() {
            /* class com.tencent.mm.ba.o.AnonymousClass1 */

            @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
            public final boolean onTimerExpired() {
                ArrayList<k.b> arrayList;
                AppMethodBeat.i(116843);
                Log.d("MicroMsg.OplogService", "summeroplog pusherTry onTimerExpired tryStartNetscene");
                o oVar = o.this;
                long nowMilliSecond = Util.nowMilliSecond();
                if (oVar.iKb && nowMilliSecond - oVar.iKm > 10000) {
                    oVar.iKb = false;
                }
                if (oVar.iKb) {
                    Log.w("MicroMsg.OplogService", "summeroplog tryStartNetscene netSceneRunning, return.");
                } else {
                    j jVar = oVar.jgt;
                    ArrayList arrayList2 = new ArrayList();
                    Cursor rawQuery = jVar.iFy.rawQuery("select oplog2.id,oplog2.inserTime,oplog2.cmdId,oplog2.buffer,oplog2.reserved1,oplog2.reserved2,oplog2.reserved3,oplog2.reserved4 from oplog2  order by inserTime asc limit ?", new String[]{"200"});
                    if (rawQuery == null) {
                        arrayList = arrayList2;
                    } else {
                        int count = rawQuery.getCount();
                        if (count > 0) {
                            for (int i2 = 0; i2 < count; i2++) {
                                rawQuery.moveToPosition(i2);
                                k.b bVar = new k.b(0);
                                bVar.id = rawQuery.getInt(0);
                                bVar.iWh = rawQuery.getLong(1);
                                bVar.cmdId = rawQuery.getInt(2);
                                bVar.buffer = rawQuery.getBlob(3);
                                bVar.zqr = rawQuery.getInt(4);
                                bVar.zqs = rawQuery.getLong(5);
                                bVar.zqt = rawQuery.getString(6);
                                bVar.zqu = rawQuery.getString(7);
                                arrayList2.add(bVar);
                            }
                        }
                        rawQuery.close();
                        arrayList = arrayList2;
                    }
                    if (arrayList.size() == 0) {
                        Log.d("MicroMsg.OplogService", "summeroplog tryStartNetscene list null ret");
                    } else {
                        if (!oVar.iKb && arrayList.size() > 0) {
                            oVar.iKm = nowMilliSecond;
                            oVar.iKb = true;
                            LinkedList<k.b> linkedList = new LinkedList();
                            for (k.b bVar2 : arrayList) {
                                if (bVar2.getCmdId() == 0 && bVar2.zqr > 0) {
                                    linkedList.add(bVar2);
                                }
                            }
                            arrayList.removeAll(linkedList);
                            for (k.b bVar3 : linkedList) {
                                if ("@openim".equals(bVar3.zqt)) {
                                    g.aAi();
                                    g.aAg().hqi.a(new l(bVar3), 0);
                                } else {
                                    oVar.jgt.c(bVar3);
                                }
                            }
                            if (!arrayList.isEmpty()) {
                                g.aAi();
                                g.aAg().hqi.a(new b(arrayList), 0);
                            }
                        }
                        Log.d("MicroMsg.OplogService", "summeroplog tryStartNetscene ret ok lastNetscene: %d,  netSceneRunning:%B, take:%d ms. size %s", Long.valueOf(oVar.iKm), Boolean.valueOf(oVar.iKb), Long.valueOf(System.currentTimeMillis() - nowMilliSecond), Integer.valueOf(arrayList.size()));
                    }
                }
                AppMethodBeat.o(116843);
                return false;
            }

            public final String toString() {
                AppMethodBeat.i(116844);
                String str = super.toString() + "|pusherTry";
                AppMethodBeat.o(116844);
                return str;
            }
        }, false);
        this.bGH = new HashMap<>();
        this.jgt = jVar;
        g.aAi();
        g.aAg().hqi.a(d.CTRL_INDEX, this);
        g.aAi();
        g.aAg().hqi.a(TbsListener.ErrorCode.INFO_OPEN_FILE_MINIQB_INIT_FAILED, this);
        AppMethodBeat.o(116849);
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.j
    public final void a(int i2, j.a aVar) {
        HashSet<WeakReference<j.a>> hashSet;
        AppMethodBeat.i(116850);
        HashSet<WeakReference<j.a>> hashSet2 = this.bGH.get(Integer.valueOf(i2));
        if (hashSet2 == null) {
            hashSet = new HashSet<>();
        } else {
            hashSet = hashSet2;
        }
        Iterator<WeakReference<j.a>> it = hashSet.iterator();
        while (it.hasNext()) {
            WeakReference<j.a> next = it.next();
            if (next != null && next.get() != null && next.get().equals(aVar)) {
                AppMethodBeat.o(116850);
                return;
            }
        }
        hashSet.add(new WeakReference<>(aVar));
        this.bGH.put(Integer.valueOf(i2), hashSet);
        AppMethodBeat.o(116850);
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.j
    public final void b(int i2, j.a aVar) {
        AppMethodBeat.i(116851);
        HashSet<WeakReference<j.a>> hashSet = this.bGH.get(Integer.valueOf(i2));
        if (hashSet == null) {
            AppMethodBeat.o(116851);
            return;
        }
        Iterator<WeakReference<j.a>> it = hashSet.iterator();
        while (it.hasNext()) {
            WeakReference<j.a> next = it.next();
            if (next != null && next.get() != null && next.get().equals(aVar)) {
                hashSet.remove(next);
                AppMethodBeat.o(116851);
                return;
            }
        }
        if (hashSet.size() == 0) {
            this.bGH.remove(Integer.valueOf(i2));
            AppMethodBeat.o(116851);
            return;
        }
        this.bGH.put(Integer.valueOf(i2), hashSet);
        AppMethodBeat.o(116851);
    }

    /* access modifiers changed from: package-private */
    public final void b(int i2, int i3, String str, String str2) {
        AppMethodBeat.i(116852);
        HashSet<WeakReference<j.a>> hashSet = this.bGH.get(Integer.valueOf(i2));
        if (hashSet == null) {
            AppMethodBeat.o(116852);
            return;
        }
        LinkedList linkedList = new LinkedList();
        Iterator<WeakReference<j.a>> it = hashSet.iterator();
        while (it.hasNext()) {
            WeakReference<j.a> next = it.next();
            if (!(next == null || next.get() == null)) {
                linkedList.add(next.get());
            }
        }
        Iterator it2 = linkedList.iterator();
        while (it2.hasNext()) {
            ((j.a) it2.next()).F(i3, str, str2);
        }
        linkedList.clear();
        AppMethodBeat.o(116852);
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.j
    public final void d(k.b bVar) {
        AppMethodBeat.i(116853);
        if (bVar != null) {
            Object[] objArr = new Object[3];
            objArr[0] = Integer.valueOf(bVar.getCmdId());
            objArr[1] = Integer.valueOf(bVar.getBuffer() == null ? -1 : bVar.getBuffer().length);
            objArr[2] = Util.getStack();
            Log.i("MicroMsg.OplogService", "summeroplog dealWith option cmdId= %d, buf len:%d, stack=%s", objArr);
            bVar.iWh = Util.nowMilliSecond();
            j jVar = this.jgt;
            if (bVar != null) {
                bVar.cSx = -1;
                ContentValues contentValues = new ContentValues();
                if ((bVar.cSx & 2) != 0) {
                    contentValues.put("inserTime", Long.valueOf(bVar.iWh));
                }
                if ((bVar.cSx & 4) != 0) {
                    contentValues.put("cmdId", Integer.valueOf(bVar.getCmdId()));
                }
                if ((bVar.cSx & 8) != 0) {
                    contentValues.put("buffer", bVar.getBuffer());
                }
                if ((bVar.cSx & 16) != 0) {
                    contentValues.put("reserved1", Integer.valueOf(bVar.zqr));
                }
                if ((bVar.cSx & 32) != 0) {
                    contentValues.put("reserved2", Long.valueOf(bVar.zqs));
                }
                if ((bVar.cSx & 64) != 0) {
                    contentValues.put("reserved3", bVar.zqt);
                }
                if ((bVar.cSx & 128) != 0) {
                    contentValues.put("reserved4", bVar.zqu);
                }
                int insert = (int) jVar.iFy.insert("oplog2", "id", contentValues);
                if (insert > 0) {
                    bVar.id = insert;
                }
            }
        } else {
            Log.i("MicroMsg.OplogService", "summeroplog dealWith option null");
        }
        this.iWr.startTimer(0);
        AppMethodBeat.o(116853);
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.j
    public final void e(k.b bVar) {
        AppMethodBeat.i(116854);
        g.aAi();
        long beginTransaction = g.aAh().hqK.beginTransaction(Thread.currentThread().getId());
        this.jgt.c(bVar);
        g.aAi();
        g.aAh().hqK.endTransaction(beginTransaction);
        AppMethodBeat.o(116854);
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        String str2;
        String str3;
        AppMethodBeat.i(116855);
        Log.i("MicroMsg.OplogService", "oplog onsceneEnd errType:%d,errCode:%d,errMsg:%s, sceneType %d", Integer.valueOf(i2), Integer.valueOf(i3), str, Integer.valueOf(qVar.getType()));
        if (qVar.getType() == 806) {
            cwl cwl = (cwl) ((com.tencent.mm.ak.d) qVar.getReqResp()).iLL.iLR;
            k.b bVar = ((l) qVar).jHe;
            if (i2 != 0 && i3 != 0) {
                if (cwl == null || cwl.getBaseResponse() == null) {
                    str3 = "";
                } else {
                    str3 = z.a(cwl.getBaseResponse().ErrMsg);
                }
                if (!Util.isNullOrNil(str3)) {
                    str = str3;
                }
                int cmdId = bVar.getCmdId();
                b(bVar.getCmdId(), -1, "", str);
                this.iKb = false;
                Integer aT = this.jgs.aT(Integer.valueOf(cmdId));
                Log.d("MicroMsg.OplogService", "summeroplog id:%d, inserttime:%d, mapCnt:%d", Integer.valueOf(cmdId), Long.valueOf(bVar.iWh), aT);
                if (aT == null) {
                    this.jgs.x(Integer.valueOf(cmdId), 1);
                    AppMethodBeat.o(116855);
                } else if (aT.intValue() < 2) {
                    this.jgs.x(Integer.valueOf(cmdId), Integer.valueOf(aT.intValue() + 1));
                    AppMethodBeat.o(116855);
                } else {
                    Log.d("MicroMsg.OplogService", "summeroplog LRUMap Max now id:%d, inserttime:%d", Integer.valueOf(cmdId), Long.valueOf(bVar.iWh));
                    this.jgt.c(bVar);
                    AppMethodBeat.o(116855);
                }
            } else if (!(qVar instanceof l)) {
                AppMethodBeat.o(116855);
            } else {
                int i4 = cwl.getBaseResponse() != null ? cwl.getBaseResponse().Ret : 0;
                pd pdVar = new pd();
                pdVar.dVh.ret = i4;
                EventCenter.instance.publish(pdVar);
                b(bVar.getCmdId(), i4, "", "");
                Log.i("MicroMsg.OplogService", "openim op success, type:%d id %d", Integer.valueOf(bVar.zqr), Integer.valueOf(bVar.getCmdId()));
                this.jgt.c(bVar);
                this.iKb = false;
                this.iWr.startTimer(this.iWk.size() > 0 ? 500 : 0);
                AppMethodBeat.o(116855);
            }
        } else if (qVar.getType() != 681) {
            AppMethodBeat.o(116855);
        } else if (i2 == 0 && i3 == 0 && ((b) qVar).jgb != null) {
            cxn cxn = ((b.c) ((b) qVar).jgb.getRespObj()).jgg;
            if (cxn.Ret != 0 || cxn.MBY == null || cxn.MBY.LRr == null) {
                Log.e("MicroMsg.OplogService", "summeroplog tryStartNetscene onSceneEnd Ret:%d  not ok and no retry.", Integer.valueOf(cxn.Ret));
                this.iKb = false;
                AppMethodBeat.o(116855);
                return;
            }
            if (!(cxn.MBY == null || cxn.MBY.LRr.size() == 0)) {
                pd pdVar2 = new pd();
                pdVar2.dVh.ret = cxn.MBY.LRr.getLast().intValue();
                LinkedList<cxl> linkedList = cxn.MBY.MBZ;
                pdVar2.dVh.dVi = linkedList.isEmpty() ? "" : linkedList.getLast().Title;
                pd.a aVar = pdVar2.dVh;
                if (linkedList.isEmpty()) {
                    str2 = "";
                } else {
                    str2 = linkedList.getLast().iAc;
                }
                aVar.dVj = str2;
                if (Util.isNullOrNil(pdVar2.dVh.dVi) && Util.isNullOrNil(pdVar2.dVh.dVj)) {
                    for (int size = linkedList.size() - 1; size >= 0; size--) {
                        pdVar2.dVh.dVi = linkedList.get(size).Title;
                        pdVar2.dVh.dVj = linkedList.get(size).iAc;
                        if (!(Util.isNullOrNil(pdVar2.dVh.dVi) && Util.isNullOrNil(pdVar2.dVh.dVj))) {
                            break;
                        }
                    }
                }
                EventCenter.instance.publish(pdVar2);
            }
            new a(this, ((b) qVar).jgc, cxn.MBY.LRr, cxn.MBY.MBZ).startTimer(50);
            AppMethodBeat.o(116855);
        } else {
            Log.e("MicroMsg.OplogService", "summeroplog tryStartNetscene onSceneEnd errType:%d, errCode:%d, rr:%s not retry", Integer.valueOf(i2), Integer.valueOf(i3), ((b) qVar).jgb.toString());
            this.iKb = false;
            AppMethodBeat.o(116855);
        }
    }

    class a extends MTimerHandler {
        public a(final o oVar, final List<k.b> list, final LinkedList<Integer> linkedList, final LinkedList<cxl> linkedList2) {
            super(g.aAk().getLooper(), (MTimerHandler.CallBack) new MTimerHandler.CallBack() {
                /* class com.tencent.mm.ba.o.a.AnonymousClass1 */
                private int jcH = 0;
                private int successCount = 0;

                @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
                public final boolean onTimerExpired() {
                    int i2;
                    final cxl cxl;
                    AppMethodBeat.i(116846);
                    int size = list.size();
                    int size2 = linkedList.size();
                    int i3 = size < size2 ? size : size2;
                    if (size != size2) {
                        Log.w("MicroMsg.OplogService", "summeroplog oplogSize[%d] not equal to resultSize[%d]! now size[%d] respIndex[%d]", Integer.valueOf(size), Integer.valueOf(size2), Integer.valueOf(i3), Integer.valueOf(this.jcH));
                    }
                    ArrayList arrayList = new ArrayList();
                    if (this.jcH >= i3) {
                        o.this.iKb = false;
                        if (this.successCount > 0) {
                            o.this.iWr.startTimer(o.this.iWk.size() > 0 ? 500 : 0);
                        }
                        AppMethodBeat.o(116846);
                        return false;
                    }
                    int i4 = this.jcH + 20;
                    if (i4 > i3) {
                        i2 = i3;
                    } else {
                        i2 = i4;
                    }
                    while (this.jcH < i2) {
                        final int intValue = ((Integer) linkedList.get(this.jcH)).intValue();
                        final k.b bVar = (k.b) list.get(this.jcH);
                        if (this.jcH < linkedList2.size()) {
                            cxl = (cxl) linkedList2.get(this.jcH);
                        } else {
                            cxl = null;
                        }
                        int i5 = bVar.id;
                        Log.i("MicroMsg.OplogService", "summeroplog id:%d, cmd:%d, result:%d", Integer.valueOf(i5), Integer.valueOf(bVar.getCmdId()), Integer.valueOf(intValue));
                        MMHandlerThread.postToMainThread(new Runnable() {
                            /* class com.tencent.mm.ba.o.a.AnonymousClass1.AnonymousClass1 */

                            public final void run() {
                                String str;
                                String str2;
                                AppMethodBeat.i(116845);
                                o oVar = oVar;
                                int cmdId = bVar.getCmdId();
                                int i2 = intValue;
                                if (cxl == null) {
                                    str = "";
                                } else {
                                    str = cxl.Title;
                                }
                                if (cxl == null) {
                                    str2 = "";
                                } else {
                                    str2 = cxl.iAc;
                                }
                                oVar.b(cmdId, i2, str, str2);
                                AppMethodBeat.o(116845);
                            }
                        });
                        if (intValue == 0 || intValue == -3400) {
                            this.successCount++;
                            arrayList.add(bVar);
                            o.this.iWk.remove(Integer.valueOf(i5));
                        } else if (intValue == -433) {
                            Log.e("MicroMsg.OplogService", "oplog not yet process, id:%d, cmd:%d", Integer.valueOf(i5), Integer.valueOf(bVar.getCmdId()));
                        } else {
                            Integer aT = o.this.iWk.aT(Integer.valueOf(i5));
                            Log.d("MicroMsg.OplogService", "summeroplog id:%d, inserttime:%d, mapCnt:%d", Integer.valueOf(i5), Long.valueOf(bVar.iWh), aT);
                            if (aT == null) {
                                o.this.iWk.x(Integer.valueOf(i5), 1);
                            } else if (aT.intValue() < 2) {
                                o.this.iWk.x(Integer.valueOf(i5), Integer.valueOf(aT.intValue() + 1));
                            } else {
                                Log.d("MicroMsg.OplogService", "summeroplog LRUMap Max now id:%d, inserttime:%d", Integer.valueOf(i5), Long.valueOf(bVar.iWh));
                                arrayList.add(bVar);
                            }
                        }
                        this.jcH++;
                    }
                    int size3 = arrayList.size();
                    if (size3 > 0) {
                        g.aAi();
                        long beginTransaction = g.aAh().hqK.beginTransaction(Thread.currentThread().getId());
                        for (int i6 = 0; i6 < size3; i6++) {
                            o.this.jgt.c((k.b) arrayList.get(i6));
                        }
                        g.aAi();
                        g.aAh().hqK.endTransaction(beginTransaction);
                    }
                    AppMethodBeat.o(116846);
                    return true;
                }

                public final String toString() {
                    AppMethodBeat.i(116847);
                    String str = super.toString() + "|RespHandler";
                    AppMethodBeat.o(116847);
                    return str;
                }
            }, true);
            AppMethodBeat.i(116848);
            AppMethodBeat.o(116848);
        }
    }
}
