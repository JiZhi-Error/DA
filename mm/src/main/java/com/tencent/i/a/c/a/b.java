package com.tencent.i.a.c.a;

import android.os.SystemClock;
import com.tencent.i.a.a.c;
import com.tencent.i.a.b.a;
import com.tencent.i.a.c.b.d;
import com.tencent.i.a.c.b.f;
import com.tencent.i.a.c.b.g;
import com.tencent.i.a.c.b.h;
import com.tencent.i.a.c.b.i;
import com.tencent.i.a.c.c.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class b extends a {
    private List<e> SrH = new ArrayList();
    private e SrI;

    public b(c cVar, a aVar) {
        super(cVar, aVar);
        AppMethodBeat.i(214739);
        AppMethodBeat.o(214739);
    }

    @Override // com.tencent.i.a.c.a.a
    public final void a(HashMap<Integer, List<g>> hashMap, List<i> list, List<h> list2, com.tencent.i.a.c.d.b bVar) {
        ArrayList arrayList;
        long j2;
        boolean z;
        boolean z2;
        com.tencent.i.a.c.b.a hqx;
        AppMethodBeat.i(214740);
        if (b(hashMap, list)) {
            if (this.SrE.YZ()) {
                a(bVar);
            }
            com.tencent.h.c.h.i("sensor_MultiDataHandle", "[method: add2SlicedList ] --data exception, delete this req");
            AppMethodBeat.o(214740);
            return;
        }
        com.tencent.i.a.c.b.c cVar = new com.tencent.i.a.c.b.c();
        int ls = com.tencent.h.c.c.ls(this.SqM.mAppContext);
        int lr = ls == 0 ? 0 : com.tencent.h.c.c.lr(this.SqM.mAppContext);
        cVar.RNi = ls == 0 ? 2 : 1;
        cVar.RNj = lr == 0 ? 1 : 2;
        if (hashMap == null || hashMap.isEmpty()) {
            arrayList = null;
        } else {
            arrayList = new ArrayList();
            for (Map.Entry<Integer, List<g>> entry : hashMap.entrySet()) {
                List<g> value = entry.getValue();
                if (value != null && !value.isEmpty()) {
                    arrayList.addAll(value);
                }
            }
        }
        if (arrayList == null || arrayList.isEmpty()) {
            cVar.RNB = SystemClock.uptimeMillis();
        } else {
            cVar.RNB = ((g) arrayList.get(0)).RNA;
            cVar.Ssd = new ArrayList<>(arrayList);
        }
        if (list != null && !list.isEmpty()) {
            Collections.sort(list, new Comparator<i>() {
                /* class com.tencent.i.a.c.a.b.AnonymousClass1 */

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
                @Override // java.util.Comparator
                public final /* bridge */ /* synthetic */ int compare(i iVar, i iVar2) {
                    return (int) (iVar.Ssw - iVar2.Ssw);
                }
            });
        }
        com.tencent.i.a.c.b.a a2 = a(cVar, list, list2);
        if (this.SrI == null) {
            this.SrI = d(a2);
            com.tencent.h.c.h.i("sensor_MultiDataHandle", "[method: add2SlicedList ] --create sliced when tmpSliced is null : " + this.SrI.SsP);
        } else {
            long j3 = this.SrI != null ? this.SrI.SsP : 0;
            long a3 = com.tencent.i.a.a.b.a.a(a2);
            com.tencent.i.a.c.b.a aVar = this.SrI.SsO;
            if (!com.tencent.i.a.a.b.a.b(aVar) || !com.tencent.i.a.a.b.a.c(aVar) || !com.tencent.i.a.a.b.a.b(a2) || !com.tencent.i.a.a.b.a.c(a2)) {
                j2 = 0;
            } else {
                ArrayList<g> arrayList2 = aVar.SrN.get(0).kgc.get(0).Ssd;
                j2 = Math.abs(a2.SrN.get(0).kgc.get(0).Ssd.get(0).RNA - arrayList2.get(arrayList2.size() - 1).RNA);
            }
            com.tencent.h.c.h.i("sensor_MultiDataHandle", "[method: isNotAllowedMerge ] slicedDuration : " + j3 + ", nowReqDuration : " + a3 + ", interval : " + j2);
            if (j2 > 500 || j3 + a3 > 2000) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                if (this.SrI.SsP < 600) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2) {
                    this.SrI = d(a2);
                    com.tencent.h.c.h.i("sensor_MultiDataHandle", "[method: add2SlicedList ] --cover the last sliced : " + this.SrI.SsP);
                } else {
                    this.SrH.add(this.SrI);
                    this.SrI = d(a2);
                    com.tencent.h.c.h.i("sensor_MultiDataHandle", "[method: add2SlicedList ] --add and create a new sliced : " + this.SrI.SsP);
                }
            } else {
                e eVar = this.SrI;
                f fVar = eVar.SsO.SrN.get(0);
                f fVar2 = a2.SrN.get(0);
                com.tencent.i.a.a.b.a.a(fVar, fVar2);
                com.tencent.i.a.a.b.a.b(fVar, fVar2);
                eVar.SsP += com.tencent.i.a.a.b.a.a(a2);
                com.tencent.h.c.h.i("sensor_MultiDataHandle", "[method: add2SlicedList ] --merge sliced : " + this.SrI.SsP);
            }
        }
        com.tencent.h.c.h.i("sensor_MultiDataHandle", "[method: handleData ] sliced size : " + this.SrH.size());
        if (this.SrH.size() < 3) {
            hqx = null;
        } else {
            com.tencent.h.c.h.i("sensor_MultiDataHandle", "[method: getMergeSlicedList ] callback all sliced from list & mSlicedList getPointerSize : " + this.SrH.size());
            hqx = hqx();
        }
        if (hqx != null) {
            com.tencent.h.c.h.i("sensor_MultiDataHandle", "[method: handleData ] call back report data");
            int i2 = 0;
            if (a(hqx, 307200)) {
                i2 = 106;
            }
            a(i2, hqx, bVar);
        } else if (this.SrE.YZ()) {
            com.tencent.h.c.h.i("sensor_MultiDataHandle", "[method: handleData ] call back when stop");
            a(bVar);
        }
        if (this.SrE.YZ()) {
            com.tencent.h.c.h.i("sensor_MultiDataHandle", "[method: handleData ] clear all cache when pause");
            hqy();
        }
        AppMethodBeat.o(214740);
    }

    @Override // com.tencent.i.a.c.a.a
    public final void dQn() {
        AppMethodBeat.i(214741);
        if (this.SrH != null) {
            com.tencent.h.c.h.i("sensor_MultiDataHandle", "[method: doStop ] " + this.SrH.size());
            this.SrH.clear();
        }
        AppMethodBeat.o(214741);
    }

    private static e d(com.tencent.i.a.c.b.a aVar) {
        AppMethodBeat.i(214742);
        e eVar = new e(aVar);
        AppMethodBeat.o(214742);
        return eVar;
    }

    private com.tencent.i.a.c.b.a hqx() {
        int i2;
        AppMethodBeat.i(214743);
        com.tencent.i.a.c.b.a aVar = this.SrH.get(0).SsO;
        StringBuilder sb = new StringBuilder();
        f fVar = aVar.SrN.get(0);
        com.tencent.i.a.c.b.e eVar = new com.tencent.i.a.c.b.e();
        eVar.Ssj = com.tencent.h.c.c.i(this.SqM.mAppContext, (float) com.tencent.h.c.c.getScreenWidth(this.SqM.mAppContext));
        eVar.Ssk = com.tencent.h.c.c.i(this.SqM.mAppContext, (float) com.tencent.h.c.c.getScreenHeight(this.SqM.mAppContext));
        int screenOrientation = com.tencent.h.c.c.getScreenOrientation(this.SqM.mAppContext);
        if (screenOrientation == 0) {
            i2 = 3;
        } else if (screenOrientation == 1) {
            i2 = 12;
        } else {
            i2 = 0;
        }
        eVar.screenOrientation = i2;
        fVar.Ssp = eVar;
        sb.append(((double) fVar.Ssn.get(0).Ssw) / 1000.0d);
        for (int i3 = 1; i3 < this.SrH.size(); i3++) {
            f fVar2 = this.SrH.get(i3).SsO.SrN.get(0);
            com.tencent.i.a.a.b.a.a(fVar, fVar2);
            com.tencent.i.a.a.b.a.b(fVar, fVar2);
            sb.append("-");
            sb.append(((double) fVar2.Ssn.get(0).Ssw) / 1000.0d);
        }
        if (aVar.SrQ == null) {
            aVar.SrQ = new ArrayList<>();
        }
        d dVar = new d();
        dVar.Ssh = "splitingPoints";
        dVar.Ssi = sb.toString();
        aVar.SrQ.add(dVar);
        hqy();
        AppMethodBeat.o(214743);
        return aVar;
    }

    private void hqy() {
        AppMethodBeat.i(214744);
        this.SrH.clear();
        AppMethodBeat.o(214744);
    }

    private void a(com.tencent.i.a.c.d.b bVar) {
        boolean z;
        int i2 = 0;
        AppMethodBeat.i(214745);
        if (bVar != null) {
            com.tencent.i.a.c.b.a aVar = null;
            if (this.SrH.size() > 0) {
                com.tencent.h.c.h.i("sensor_MultiDataHandle", "[method: callBackWhenStop size] " + this.SrH.size());
                aVar = hqx();
            }
            StringBuilder sb = new StringBuilder("[method: callBackWhenStop ] ");
            if (aVar != null) {
                z = true;
            } else {
                z = false;
            }
            com.tencent.h.c.h.i("sensor_MultiDataHandle", sb.append(z).toString());
            if (aVar == null) {
                i2 = 107;
            }
            a(i2, aVar, bVar);
        }
        AppMethodBeat.o(214745);
    }
}
