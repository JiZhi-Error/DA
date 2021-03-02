package com.tencent.mm.plugin.aa.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vending.h.e;
import com.tencent.mm.vending.j.d;
import java.util.Map;

public final class m implements com.tencent.mm.vending.c.b<l> {
    protected l jSX;
    public final a jSY;
    public final c jSZ;
    public final b jTa;

    public m() {
        this(new l());
        AppMethodBeat.i(63368);
        AppMethodBeat.o(63368);
    }

    private m(l lVar) {
        AppMethodBeat.i(63369);
        this.jSY = new a();
        this.jSZ = new c();
        this.jTa = new b();
        this.jSX = lVar;
        AppMethodBeat.o(63369);
    }

    public final l bmn() {
        return this.jSX;
    }

    public class a implements e<Boolean, com.tencent.mm.vending.j.c<Integer, Map<String, Object>>> {
        public a() {
        }

        @Override // com.tencent.mm.vending.c.a
        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.i(63366);
            com.tencent.mm.vending.j.c cVar = (com.tencent.mm.vending.j.c) obj;
            m.this.jSX.d(((Integer) cVar.get(0)).intValue(), (Map) cVar.get(1));
            AppMethodBeat.o(63366);
            return null;
        }

        @Override // com.tencent.mm.vending.h.e
        public final String akn() {
            return "Vending.LOGIC";
        }
    }

    public class c implements e<d<Boolean, String, Long>, Map<String, Object>> {
        public c() {
        }

        @Override // com.tencent.mm.vending.c.a
        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.i(63367);
            m.this.jSX.F((Map) obj);
            AppMethodBeat.o(63367);
            return null;
        }

        @Override // com.tencent.mm.vending.h.e
        public final String akn() {
            return "Vending.LOGIC";
        }
    }

    public class b implements e<d<Boolean, String, Long>, Map<String, Object>> {
        public b() {
        }

        @Override // com.tencent.mm.vending.c.a
        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.i(212944);
            m.this.jSX.G((Map) obj);
            AppMethodBeat.o(212944);
            return null;
        }

        @Override // com.tencent.mm.vending.h.e
        public final String akn() {
            return "Vending.LOGIC";
        }
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.tencent.mm.vending.c.b
    public final /* bridge */ /* synthetic */ l bmc() {
        return this.jSX;
    }
}
