package com.tencent.mm.plugin.backup.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.backup.b.a;
import java.util.HashMap;

public final class c extends a {
    private static String TAG = "MicroMsg.BackupItemFactory";
    private static c oNE;
    private HashMap<Integer, l> oNF;

    public static c cfW() {
        AppMethodBeat.i(21510);
        if (oNE == null) {
            c cVar = new c();
            oNE = cVar;
            a(cVar);
        }
        c cVar2 = oNE;
        AppMethodBeat.o(21510);
        return cVar2;
    }

    @Override // com.tencent.mm.plugin.backup.b.a
    public final void ceH() {
        oNE = null;
    }

    public final l Bh(int i2) {
        AppMethodBeat.i(21511);
        if (this.oNF == null) {
            cfX();
        }
        l lVar = this.oNF.get(Integer.valueOf(i2));
        AppMethodBeat.o(21511);
        return lVar;
    }

    private void cfX() {
        AppMethodBeat.i(21512);
        this.oNF = new HashMap<>();
        this.oNF.put(3, new d());
        this.oNF.put(47, new b());
        this.oNF.put(49, new a());
        this.oNF.put(34, new g());
        f fVar = new f();
        this.oNF.put(43, fVar);
        this.oNF.put(44, fVar);
        this.oNF.put(62, fVar);
        e eVar = new e();
        this.oNF.put(48, eVar);
        this.oNF.put(42, eVar);
        this.oNF.put(66, eVar);
        this.oNF.put(10000, eVar);
        this.oNF.put(1, eVar);
        this.oNF.put(37, eVar);
        this.oNF.put(40, eVar);
        this.oNF.put(50, eVar);
        AppMethodBeat.o(21512);
    }
}
