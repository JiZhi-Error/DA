package com.tencent.i.a.c.d;

import com.tencent.h.c.h;
import com.tencent.i.a.c.a.a;
import com.tencent.i.a.c.b.g;
import com.tencent.i.a.c.b.i;
import com.tencent.i.a.c.d.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class c extends a {
    public a Stq;

    public c(com.tencent.i.a.a.c cVar) {
        super(cVar);
    }

    public final void v(int i2, Object obj) {
        boolean z;
        ArrayList arrayList;
        AppMethodBeat.i(214815);
        if (i2 == 1) {
            List<g> list = (List) obj;
            a.C0145a aVar = this.Stk;
            if (list != null && !list.isEmpty()) {
                g gVar = (g) list.get(0);
                if (gVar != null) {
                    int i3 = gVar.RNh;
                    List<g> list2 = aVar.Stl.get(Integer.valueOf(i3));
                    if (list2 == null) {
                        ArrayList arrayList2 = new ArrayList();
                        aVar.Stl.put(Integer.valueOf(i3), arrayList2);
                        arrayList = arrayList2;
                    } else {
                        arrayList = list2;
                    }
                    for (g gVar2 : list) {
                        if (gVar2 != null) {
                            arrayList.add(gVar2);
                        }
                    }
                }
            }
            AppMethodBeat.o(214815);
            return;
        } else if (i2 == 11 && (obj instanceof i)) {
            i iVar = (i) obj;
            a.C0145a aVar2 = this.Stk;
            if (iVar != null) {
                List<i> list3 = aVar2.Stm;
                if (list3 == null || list3.isEmpty()) {
                    z = false;
                } else {
                    i iVar2 = list3.get(list3.size() - 1);
                    if (iVar.Ssw != iVar2.Ssw || iVar.Ssz != iVar2.Ssz) {
                        z = false;
                    } else if (iVar2.Ssv == 1 && (iVar.Ssv == 3 || iVar.Ssv == 4)) {
                        iVar.Ssw++;
                        list3.add(iVar);
                        z = true;
                    } else if (iVar2.Ssv == 1 && iVar.Ssv == 2) {
                        z = true;
                    } else {
                        list3.remove(iVar2);
                        list3.add(iVar);
                        z = true;
                    }
                }
                if (!z) {
                    aVar2.Stm.add(iVar);
                }
            }
        }
        AppMethodBeat.o(214815);
    }

    public final void Eg(boolean z) {
        AppMethodBeat.i(214817);
        if (!z || this.Stj == null) {
            this.Stk.clearAll();
            this.Stk.Sto.clear();
            AppMethodBeat.o(214817);
            return;
        }
        h.i("sensor_MasterEngine", "[method: dataPush ] ");
        if (this.Stq != null) {
            this.Stq.a(this.Stk.Stl, this.Stk.Stm, this.Stk.Stn, this.Stj);
        }
        this.Stk.clearAll();
        AppMethodBeat.o(214817);
    }

    public final void dQn() {
        AppMethodBeat.i(214816);
        this.Stk.clearAll();
        this.Stk.Sto.clear();
        if (this.Stq != null) {
            this.Stq.dQn();
        }
        AppMethodBeat.o(214816);
    }

    public final void hqH() {
        AppMethodBeat.i(214818);
        for (Map.Entry<String, ArrayList<Object>> entry : this.Stk.Sto.entrySet()) {
            ArrayList<Object> value = entry.getValue();
            if (a.C0145a.brb(entry.getKey()) == 1) {
                v(1, value);
            } else {
                for (int i2 = 0; i2 < value.size(); i2++) {
                    v(Integer.valueOf(entry.getKey()).intValue(), value.get(i2));
                }
            }
        }
        this.Stk.Sto.clear();
        AppMethodBeat.o(214818);
    }
}
