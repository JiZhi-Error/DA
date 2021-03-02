package com.tencent.i.a.c.a;

import android.os.SystemClock;
import com.tencent.i.a.b.a;
import com.tencent.i.a.c.b.f;
import com.tencent.i.a.c.b.g;
import com.tencent.i.a.c.b.h;
import com.tencent.i.a.c.b.i;
import com.tencent.i.a.c.d.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class c extends a {
    public c(com.tencent.i.a.a.c cVar, a aVar) {
        super(cVar, aVar);
    }

    @Override // com.tencent.i.a.c.a.a
    public final void a(HashMap<Integer, List<g>> hashMap, List<i> list, List<h> list2, b bVar) {
        ArrayList arrayList;
        f fVar;
        int i2 = 2;
        boolean z = true;
        AppMethodBeat.i(214746);
        if (b(hashMap, list)) {
            a(107, (com.tencent.i.a.c.b.a) null, bVar);
            AppMethodBeat.o(214746);
            return;
        }
        com.tencent.i.a.c.b.c cVar = new com.tencent.i.a.c.b.c();
        int ls = com.tencent.h.c.c.ls(this.SqM.mAppContext);
        int lr = ls == 0 ? 0 : com.tencent.h.c.c.lr(this.SqM.mAppContext);
        cVar.RNi = ls == 0 ? 2 : 1;
        if (lr == 0) {
            i2 = 1;
        }
        cVar.RNj = i2;
        long j2 = list.get(list.size() - 1).Ssw;
        com.tencent.h.c.h.i("sensor_SingleHandle", "[method: buildDataUnit ] , endTouch : ".concat(String.valueOf(j2)));
        if (hashMap == null || hashMap.isEmpty()) {
            arrayList = null;
        } else {
            arrayList = new ArrayList();
            for (Map.Entry<Integer, List<g>> entry : hashMap.entrySet()) {
                List<g> value = entry.getValue();
                j(value, j2);
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
        com.tencent.i.a.c.b.a a2 = a(cVar, list, list2);
        if (list != null && !list.isEmpty() && Math.abs(list.get(list.size() - 1).Ssw - list.get(0).Ssw) < this.SrG.dyB) {
            z = false;
        }
        if (z) {
            a(105, (com.tencent.i.a.c.b.a) null, bVar);
            AppMethodBeat.o(214746);
        } else if (a(a2, 61440)) {
            a(106, (com.tencent.i.a.c.b.a) null, bVar);
            AppMethodBeat.o(214746);
        } else {
            if (!(a2.SrN == null || a2.SrN.isEmpty() || (fVar = a2.SrN.get(0)) == null || fVar.Ssn == null || fVar.Ssn.isEmpty())) {
                Collections.sort(fVar.Ssn, new Comparator<i>() {
                    /* class com.tencent.i.a.c.a.c.AnonymousClass1 */

                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
                    @Override // java.util.Comparator
                    public final /* bridge */ /* synthetic */ int compare(i iVar, i iVar2) {
                        i iVar3 = iVar;
                        i iVar4 = iVar2;
                        int i2 = iVar3.Ssz - iVar4.Ssz;
                        return i2 == 0 ? (int) (iVar3.Ssw - iVar4.Ssw) : i2;
                    }
                });
            }
            a(0, a2, bVar);
            AppMethodBeat.o(214746);
        }
    }

    private static void j(List<g> list, long j2) {
        AppMethodBeat.i(214747);
        if (list == null || list.isEmpty() || j2 <= 0) {
            AppMethodBeat.o(214747);
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (int size = list.size() - 1; size >= 0; size--) {
            g gVar = list.get(size);
            if (gVar.RNA - j2 <= 30) {
                break;
            }
            arrayList.add(gVar);
        }
        com.tencent.h.c.h.i("sensor_SingleHandle", "[method: filterSensor ] " + arrayList.size());
        if (!arrayList.isEmpty()) {
            list.removeAll(arrayList);
        }
        AppMethodBeat.o(214747);
    }
}
