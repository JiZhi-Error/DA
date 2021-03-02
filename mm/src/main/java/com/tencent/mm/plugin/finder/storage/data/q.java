package com.tencent.mm.plugin.finder.storage.data;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.arb;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u0011\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0002J\u0006\u0010\n\u001a\u00020\u000bJ\u0019\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u0004H\u0002J\u0006\u0010\u000e\u001a\u00020\tR\u0016\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\u0004\n\u0002\u0010\u0006¨\u0006\u000f"}, hxF = {"Lcom/tencent/mm/plugin/finder/storage/data/PageCacheList;", "", "array", "", "Lcom/tencent/mm/plugin/finder/storage/data/CachePage;", "([Lcom/tencent/mm/plugin/finder/storage/data/CachePage;)V", "[Lcom/tencent/mm/plugin/finder/storage/data/CachePage;", "get", "typeFlag", "", "reset", "", "set", "page", "size", "plugin-finder_release"})
public final class q {
    final a[] vGC;

    public q(a[] aVarArr) {
        p.h(aVarArr, "array");
        AppMethodBeat.i(252037);
        this.vGC = aVarArr;
        AppMethodBeat.o(252037);
    }

    public final a Lg(int i2) {
        a aVar;
        boolean z;
        AppMethodBeat.i(252034);
        a[] aVarArr = this.vGC;
        int length = aVarArr.length;
        int i3 = 0;
        while (true) {
            if (i3 >= length) {
                aVar = null;
                break;
            }
            aVar = aVarArr[i3];
            if (aVar.type == i2) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                break;
            }
            i3++;
        }
        if (aVar == null) {
            aVar = new a(10000, "default_v3", new arb(), (byte) 0);
        }
        AppMethodBeat.o(252034);
        return aVar;
    }

    public final void a(int i2, a aVar) {
        AppMethodBeat.i(252035);
        p.h(aVar, "page");
        a[] aVarArr = this.vGC;
        int length = aVarArr.length;
        int i3 = 0;
        int i4 = 0;
        while (i3 < length) {
            int i5 = i4 + 1;
            if (i2 == aVarArr[i3].type) {
                this.vGC[i4] = aVar;
            }
            i3++;
            i4 = i5;
        }
        AppMethodBeat.o(252035);
    }

    public final void reset() {
        AppMethodBeat.i(252036);
        a[] aVarArr = this.vGC;
        for (a aVar : aVarArr) {
            aVar.lNl = false;
            aVar.a(new arb());
        }
        AppMethodBeat.o(252036);
    }
}
