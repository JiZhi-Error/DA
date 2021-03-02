package com.tencent.mm.ba;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ba.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.a.k;
import com.tencent.mm.protocal.protobuf.cxl;
import com.tencent.mm.protocal.protobuf.cxn;
import java.util.ArrayList;
import java.util.LinkedList;

public final class a implements h {
    SparseArray<LinkedList<h.a>> jfY = new SparseArray<>();

    public a() {
        AppMethodBeat.i(116837);
        AppMethodBeat.o(116837);
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.h
    public final void b(final k.b bVar) {
        AppMethodBeat.i(116838);
        if (g.aAg().hqi == null || g.aAg().hqi.iMw == null) {
            AppMethodBeat.o(116838);
            return;
        }
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(bVar);
        b bVar2 = new b(arrayList);
        g.aAi();
        bVar2.doScene(g.aAg().hqi.iMw, new i() {
            /* class com.tencent.mm.ba.a.AnonymousClass1 */

            @Override // com.tencent.mm.ak.i
            public final void onSceneEnd(int i2, int i3, String str, q qVar) {
                int i4 = -1;
                AppMethodBeat.i(116836);
                if (qVar.getType() != 681) {
                    AppMethodBeat.o(116836);
                } else if (((b) qVar).jgb == null) {
                    AppMethodBeat.o(116836);
                } else {
                    ((b) qVar).jgb.getReqObjImp();
                    cxn cxn = ((b.c) ((b) qVar).jgb.getRespObj()).jgg;
                    int i5 = ((b.C0277b) ((b) qVar).jgb.getReqObj()).jgf.MyZ.oTA.getLast().Lms;
                    if (cxn == null || cxn.MBY == null || cxn.MBY.LRr == null) {
                        LinkedList<h.a> linkedList = a.this.jfY.get(i5);
                        if (linkedList != null) {
                            for (h.a aVar : linkedList) {
                                aVar.a(-1, new cxl(), bVar);
                            }
                        }
                        AppMethodBeat.o(116836);
                        return;
                    }
                    if (cxn.MBY.LRr.size() > 0) {
                        i4 = cxn.MBY.LRr.getLast().intValue();
                    }
                    cxl last = cxn.MBY.MBZ.size() > 0 ? cxn.MBY.MBZ.getLast() : new cxl();
                    LinkedList<h.a> linkedList2 = a.this.jfY.get(i5);
                    if (linkedList2 != null) {
                        for (h.a aVar2 : linkedList2) {
                            aVar2.a(i4, last, bVar);
                        }
                    }
                    AppMethodBeat.o(116836);
                }
            }
        });
        AppMethodBeat.o(116838);
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.h
    public final void a(int i2, h.a aVar) {
        AppMethodBeat.i(116839);
        if (this.jfY.indexOfKey(i2) < 0) {
            this.jfY.put(i2, new LinkedList<>());
        }
        this.jfY.get(i2).add(aVar);
        AppMethodBeat.o(116839);
    }

    @Override // com.tencent.mm.plugin.messenger.foundation.a.a.h
    public final void b(int i2, h.a aVar) {
        AppMethodBeat.i(116840);
        if (this.jfY.indexOfKey(i2) >= 0) {
            this.jfY.get(i2).remove(aVar);
        }
        AppMethodBeat.o(116840);
    }
}
