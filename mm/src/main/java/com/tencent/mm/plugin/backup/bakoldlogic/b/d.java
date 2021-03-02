package com.tencent.mm.plugin.backup.bakoldlogic.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.backup.b.a;
import java.util.HashMap;

public final class d extends a {
    private static String TAG = "MicroMsg.BakOldItemFactory";
    private static d oRd;
    private HashMap<Integer, j> oNF;

    public static d cgY() {
        AppMethodBeat.i(21843);
        if (oRd == null) {
            d dVar = new d();
            oRd = dVar;
            a(dVar);
        }
        d dVar2 = oRd;
        AppMethodBeat.o(21843);
        return dVar2;
    }

    @Override // com.tencent.mm.plugin.backup.b.a
    public final void ceH() {
        oRd = null;
    }

    public final j Bt(int i2) {
        AppMethodBeat.i(21844);
        if (this.oNF == null) {
            this.oNF = new HashMap<>();
            this.oNF.put(3, new e());
            this.oNF.put(47, new c());
            this.oNF.put(49, new b());
            this.oNF.put(34, new h());
            g gVar = new g();
            this.oNF.put(43, gVar);
            this.oNF.put(44, gVar);
            this.oNF.put(62, gVar);
            f fVar = new f();
            this.oNF.put(48, fVar);
            this.oNF.put(42, fVar);
            this.oNF.put(66, fVar);
            this.oNF.put(10000, fVar);
            this.oNF.put(1, fVar);
            this.oNF.put(37, fVar);
            this.oNF.put(40, fVar);
            this.oNF.put(50, fVar);
        }
        j jVar = this.oNF.get(Integer.valueOf(i2));
        AppMethodBeat.o(21844);
        return jVar;
    }
}
