package com.tencent.mm.plugin.aa.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.aa.model.cgi.i;
import com.tencent.mm.vending.c.b;
import com.tencent.mm.vending.h.e;

public final class f implements b<e> {
    protected e jSx;
    public final a jSy;

    public f() {
        this(new e());
        AppMethodBeat.i(63332);
        AppMethodBeat.o(63332);
    }

    private f(e eVar) {
        AppMethodBeat.i(63333);
        this.jSy = new a();
        this.jSx = eVar;
        AppMethodBeat.o(63333);
    }

    public final e bmj() {
        return this.jSx;
    }

    public class a implements e<Void, Void> {
        public a() {
        }

        @Override // com.tencent.mm.vending.h.e
        public final String akn() {
            return "Vending.LOGIC";
        }

        @Override // com.tencent.mm.vending.c.a
        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.i(63331);
            e eVar = f.this.jSx;
            i iVar = new i();
            g.aAi();
            g.aAg().hqi.a(iVar, 0);
            eVar.jSi = com.tencent.mm.vending.g.g.hdH();
            Void r0 = QZL;
            AppMethodBeat.o(63331);
            return r0;
        }
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.tencent.mm.vending.c.b
    public final /* bridge */ /* synthetic */ e bmc() {
        return this.jSx;
    }
}
