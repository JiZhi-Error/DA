package com.tencent.mm.plugin.address.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.j.a.b;
import java.util.Iterator;

public final class a {
    public com.tencent.mm.plugin.j.a.a ksN = new com.tencent.mm.plugin.j.a.a();

    public a() {
        AppMethodBeat.i(20762);
        AppMethodBeat.o(20762);
    }

    public final b vo(int i2) {
        AppMethodBeat.i(20763);
        Iterator<b> it = this.ksN.ynO.iterator();
        while (it.hasNext()) {
            b next = it.next();
            if (next.ynP == i2) {
                AppMethodBeat.o(20763);
                return next;
            }
        }
        AppMethodBeat.o(20763);
        return null;
    }
}
