package com.tencent.mm.live.core.core.trtc.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class b {
    List<a> hBJ;

    /* synthetic */ b(byte b2) {
        this();
    }

    private b() {
        AppMethodBeat.i(196281);
        this.hBJ = new ArrayList();
        AppMethodBeat.o(196281);
    }

    public static b bxh() {
        AppMethodBeat.i(261575);
        b bVar = a.hBK;
        AppMethodBeat.o(261575);
        return bVar;
    }

    public final void a(a aVar) {
        AppMethodBeat.i(196282);
        this.hBJ.add(aVar);
        AppMethodBeat.o(196282);
    }

    public final void Gx(String str) {
        AppMethodBeat.i(261576);
        Iterator<a> it = this.hBJ.iterator();
        while (it.hasNext()) {
            if (str.equals(it.next().goe)) {
                it.remove();
                AppMethodBeat.o(261576);
                return;
            }
        }
        AppMethodBeat.o(261576);
    }

    public final List<a> bxn() {
        return this.hBJ;
    }

    public final a Gr(String str) {
        AppMethodBeat.i(196283);
        for (a aVar : this.hBJ) {
            if (str.equals(aVar.goe)) {
                AppMethodBeat.o(196283);
                return aVar;
            }
        }
        AppMethodBeat.o(196283);
        return null;
    }

    /* access modifiers changed from: package-private */
    public static class a {
        private static b hBK = new b((byte) 0);

        static {
            AppMethodBeat.i(196280);
            AppMethodBeat.o(196280);
        }
    }
}
