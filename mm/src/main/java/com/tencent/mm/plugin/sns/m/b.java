package com.tencent.mm.plugin.sns.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vending.h.e;
import com.tencent.mm.vending.j.f;

public class b implements com.tencent.mm.vending.c.b<a> {
    protected a FgA;
    public final a FgB;
    public final C1717b FgC;
    public final c FgD;

    public b() {
        this(new a());
        AppMethodBeat.i(100582);
        AppMethodBeat.o(100582);
    }

    private b(a aVar) {
        AppMethodBeat.i(100583);
        this.FgB = new a();
        this.FgC = new C1717b();
        this.FgD = new c();
        this.FgA = aVar;
        AppMethodBeat.o(100583);
    }

    public final a flo() {
        return this.FgA;
    }

    public class a implements e<Void, com.tencent.mm.vending.j.e<String, Boolean, Boolean, Integer>> {
        public a() {
        }

        @Override // com.tencent.mm.vending.c.a
        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.i(100580);
            com.tencent.mm.vending.j.e eVar = (com.tencent.mm.vending.j.e) obj;
            ((Boolean) eVar.get(1)).booleanValue();
            b.this.FgA.g((String) eVar.get(0), ((Boolean) eVar.get(2)).booleanValue(), ((Integer) eVar.get(3)).intValue());
            Void r0 = QZL;
            AppMethodBeat.o(100580);
            return r0;
        }

        @Override // com.tencent.mm.vending.h.e
        public final String akn() {
            return "Vending.LOGIC";
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.m.b$b  reason: collision with other inner class name */
    public class C1717b implements e<Void, com.tencent.mm.vending.j.e<String, Boolean, Boolean, Integer>> {
        public C1717b() {
        }

        @Override // com.tencent.mm.vending.c.a
        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.i(100581);
            com.tencent.mm.vending.j.e eVar = (com.tencent.mm.vending.j.e) obj;
            ((Boolean) eVar.get(1)).booleanValue();
            b.this.FgA.h((String) eVar.get(0), ((Boolean) eVar.get(2)).booleanValue(), ((Integer) eVar.get(3)).intValue());
            Void r0 = QZL;
            AppMethodBeat.o(100581);
            return r0;
        }

        @Override // com.tencent.mm.vending.h.e
        public final String akn() {
            return "Vending.LOGIC";
        }
    }

    public class c implements e<Void, f<String, Integer, Boolean, Integer, Long>> {
        public c() {
        }

        @Override // com.tencent.mm.vending.c.a
        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.i(179435);
            f fVar = (f) obj;
            b.this.FgA.a((String) fVar.get(0), ((Integer) fVar.get(1)).intValue(), ((Boolean) fVar.get(2)).booleanValue(), ((Integer) fVar.get(3)).intValue(), ((Long) fVar.get(4)).longValue());
            Void r0 = QZL;
            AppMethodBeat.o(179435);
            return r0;
        }

        @Override // com.tencent.mm.vending.h.e
        public final String akn() {
            return "Vending.LOGIC";
        }
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.tencent.mm.vending.c.b
    public final /* bridge */ /* synthetic */ a bmc() {
        return this.FgA;
    }
}
