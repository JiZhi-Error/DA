package kotlin.l.b.a.b.e.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l.b.a.b.e.a;

public final class h {
    private final List<a.p> GjM;

    public h(a.s sVar) {
        p.h(sVar, "typeTable");
        AppMethodBeat.i(59084);
        ArrayList arrayList = sVar.TzW;
        if (sVar.hHI()) {
            int i2 = sVar.TzX;
            List<a.p> list = sVar.TzW;
            p.g(list, "typeTable.typeList");
            List<a.p> list2 = list;
            ArrayList arrayList2 = new ArrayList(j.a(list2, 10));
            int i3 = 0;
            for (T t : list2) {
                int i4 = i3 + 1;
                if (i3 < 0) {
                    j.hxH();
                }
                T t2 = t;
                if (i3 >= i2) {
                    t2 = t2.hHf().EH(true).hHn();
                }
                arrayList2.add(t2);
                i3 = i4;
            }
            arrayList = arrayList2;
        } else {
            p.g(arrayList, "originalTypes");
        }
        this.GjM = arrayList;
        AppMethodBeat.o(59084);
    }

    public final a.p avo(int i2) {
        AppMethodBeat.i(59083);
        a.p pVar = this.GjM.get(i2);
        AppMethodBeat.o(59083);
        return pVar;
    }
}
