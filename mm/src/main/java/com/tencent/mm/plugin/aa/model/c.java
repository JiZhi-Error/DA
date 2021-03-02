package com.tencent.mm.plugin.aa.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.aa.model.cgi.k;
import com.tencent.mm.protocal.protobuf.y;
import com.tencent.mm.vending.c.b;
import com.tencent.mm.vending.h.e;
import com.tencent.mm.vending.j.f;

public final class c implements b<b> {
    protected b jSj;
    public final a jSk;

    public c() {
        this(new b());
        AppMethodBeat.i(63321);
        AppMethodBeat.o(63321);
    }

    private c(b bVar) {
        AppMethodBeat.i(63322);
        this.jSk = new a();
        this.jSj = bVar;
        AppMethodBeat.o(63322);
    }

    public final b bmb() {
        return this.jSj;
    }

    public class a implements e<y, f<String, Integer, String, String, Integer>> {
        public a() {
        }

        @Override // com.tencent.mm.vending.c.a
        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.i(63320);
            f fVar = (f) obj;
            b bVar = c.this.jSj;
            k kVar = new k((String) fVar.get(0), ((Integer) fVar.get(1)).intValue(), (String) fVar.get(2), (String) fVar.get(3), ((Integer) fVar.get(4)).intValue());
            g.aAi();
            g.aAg().hqi.a(kVar, 0);
            bVar.jSi = com.tencent.mm.vending.g.g.hdH();
            AppMethodBeat.o(63320);
            return null;
        }

        @Override // com.tencent.mm.vending.h.e
        public final String akn() {
            return "Vending.LOGIC";
        }
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.tencent.mm.vending.c.b
    public final /* bridge */ /* synthetic */ b bmc() {
        return this.jSj;
    }
}
