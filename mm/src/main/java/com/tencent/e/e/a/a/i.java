package com.tencent.e.e.a.a;

import com.tencent.e.e.a.b.f;
import com.tencent.e.e.a.b.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class i {
    Object[] OW;
    private final int RNf;
    final int RNg;
    int acm = 0;
    final int dpI;

    public i(int i2, int i3, int i4) {
        AppMethodBeat.i(138410);
        this.RNf = i2;
        this.OW = new Object[((int) Math.ceil((double) ((1.0f * ((float) i4)) / ((float) i3))))];
        this.dpI = i4;
        this.RNg = i3;
        AppMethodBeat.o(138410);
    }

    private ArrayList<f> aqB(int i2) {
        AppMethodBeat.i(138411);
        ArrayList<f> arrayList = new ArrayList<>();
        List list = (List) this.OW[i2];
        if (list == null) {
            AppMethodBeat.o(138411);
            return arrayList;
        }
        for (int i3 = 0; i3 < list.size(); i3++) {
            j jVar = (j) list.get(i3);
            f fVar = new f();
            fVar.x = jVar.values[0];
            fVar.y = jVar.values[1];
            fVar.z = jVar.values[2];
            fVar.RNA = jVar.timestamp;
            arrayList.add(fVar);
        }
        AppMethodBeat.o(138411);
        return arrayList;
    }

    public final ArrayList<g> kd(List<k> list) {
        int i2;
        k kVar;
        AppMethodBeat.i(138412);
        ArrayList<g> arrayList = new ArrayList<>();
        for (int i3 = 0; i3 < this.OW.length; i3++) {
            List list2 = (List) this.OW[i3];
            if (!(list2 == null || list2.size() == 0)) {
                g gVar = new g();
                ArrayList<f> aqB = aqB(i3);
                HashMap hashMap = new HashMap();
                if (this.RNf == 1) {
                    i2 = 0;
                } else if (this.RNf == 4) {
                    i2 = 2;
                } else if (this.RNf == 9) {
                    i2 = 4;
                } else {
                    i2 = -1;
                }
                hashMap.put(Integer.valueOf(i2), aqB);
                gVar.RNC = hashMap;
                j jVar = (j) list2.get(0);
                if (jVar != null) {
                    gVar.RNB = jVar.timestamp;
                    if (list.size() > i3 && (kVar = list.get(i3)) != null) {
                        gVar.RNi = kVar.RNi;
                        gVar.RNj = kVar.RNj;
                        gVar.RNk = kVar.RNk;
                        gVar.RNl = kVar.RNl;
                    }
                    arrayList.add(gVar);
                }
            }
        }
        AppMethodBeat.o(138412);
        return arrayList;
    }

    public final Object[] hkM() {
        AppMethodBeat.i(138413);
        Object[] objArr = (Object[]) this.OW.clone();
        AppMethodBeat.o(138413);
        return objArr;
    }
}
