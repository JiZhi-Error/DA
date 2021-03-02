package com.tencent.mm.kiss.widget.textview;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kiss.widget.textview.a.a;
import java.util.concurrent.ConcurrentHashMap;

public final class c {
    public static c hue = new c();
    public ConcurrentHashMap<Integer, b> huf = new ConcurrentHashMap<>();

    public c() {
        AppMethodBeat.i(141012);
        AppMethodBeat.o(141012);
    }

    static {
        AppMethodBeat.i(141017);
        AppMethodBeat.o(141017);
    }

    public final void a(a aVar, f fVar) {
        AppMethodBeat.i(141013);
        if (aVar == null) {
            AppMethodBeat.o(141013);
            return;
        }
        b bVar = this.huf.get(Integer.valueOf(aVar.hashCode()));
        if (bVar != null) {
            bVar.a(fVar);
            this.huf.put(Integer.valueOf(aVar.hashCode()), bVar);
            AppMethodBeat.o(141013);
            return;
        }
        b bVar2 = new b();
        bVar2.a(fVar);
        this.huf.put(Integer.valueOf(aVar.hashCode()), bVar2);
        AppMethodBeat.o(141013);
    }

    public final f a(a aVar, CharSequence charSequence) {
        b bVar;
        AppMethodBeat.i(141014);
        if (aVar == null || (bVar = this.huf.get(Integer.valueOf(aVar.hashCode()))) == null) {
            AppMethodBeat.o(141014);
            return null;
        }
        f z = bVar.z(charSequence);
        AppMethodBeat.o(141014);
        return z;
    }

    public final void aBj() {
        AppMethodBeat.i(141015);
        for (b bVar : this.huf.values()) {
            bVar.hud.clear();
        }
        this.huf.clear();
        AppMethodBeat.o(141015);
    }

    public static int a(a aVar) {
        AppMethodBeat.i(141016);
        int hashCode = aVar.hashCode();
        AppMethodBeat.o(141016);
        return hashCode;
    }
}
