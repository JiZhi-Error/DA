package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.e.d;
import java.util.Iterator;
import java.util.LinkedList;

public final class i extends h {
    protected i(String str) {
        super(str);
    }

    public final void dVh() {
        AppMethodBeat.i(41408);
        LinkedList<c> z = z(optJSONArray("items"));
        Iterator<c> it = z.iterator();
        while (it.hasNext()) {
            c next = it.next();
            next.Bm(next.xDV);
        }
        d.aZ(z);
        AppMethodBeat.o(41408);
    }
}
