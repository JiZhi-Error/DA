package com.tencent.mm.plugin.aa.model.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.aa.model.l;
import com.tencent.mm.vending.g.g;
import java.util.Map;

public class e implements com.tencent.mm.vending.c.b<d> {
    protected d jTZ;
    public final b jUa;
    public final d jUb;
    public final c jUc;
    public final a jUd;

    public e() {
        this(new d());
        AppMethodBeat.i(63451);
        AppMethodBeat.o(63451);
    }

    private e(d dVar) {
        AppMethodBeat.i(63452);
        this.jUa = new b();
        this.jUb = new d();
        this.jUc = new c();
        this.jUd = new a();
        this.jTZ = dVar;
        AppMethodBeat.o(63452);
    }

    public class b implements com.tencent.mm.vending.h.e<Boolean, com.tencent.mm.vending.j.c<Integer, Map<String, Object>>> {
        public b() {
        }

        @Override // com.tencent.mm.vending.c.a
        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.i(63448);
            com.tencent.mm.vending.j.c cVar = (com.tencent.mm.vending.j.c) obj;
            d dVar = e.this.jTZ;
            int intValue = ((Integer) cVar.get(0)).intValue();
            Map map = (Map) cVar.get(1);
            map.put(l.jSO, Integer.valueOf(dVar.QYU.getIntExtra("enter_scene", 1)));
            g.a(g.O(Integer.valueOf(intValue), map).c(dVar.jTX.jSY));
            AppMethodBeat.o(63448);
            return null;
        }

        @Override // com.tencent.mm.vending.h.e
        public final String akn() {
            return "Vending.LOGIC";
        }

        public final com.tencent.mm.vending.g.c<Boolean> e(int i2, Map<String, Object> map) {
            AppMethodBeat.i(63447);
            com.tencent.mm.vending.g.c<Boolean> c2 = g.O(Integer.valueOf(i2), map).c(this);
            AppMethodBeat.o(63447);
            return c2;
        }
    }

    public class d implements com.tencent.mm.vending.h.e<com.tencent.mm.vending.j.d<Boolean, String, Long>, Map<String, Object>> {
        public d() {
        }

        @Override // com.tencent.mm.vending.c.a
        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.i(63450);
            Map map = (Map) obj;
            d dVar = e.this.jTZ;
            map.put(l.jSO, Integer.valueOf(dVar.QYU.getIntExtra("enter_scene", 1)));
            g.a(g.en(map).c(dVar.jTX.jSZ));
            AppMethodBeat.o(63450);
            return null;
        }

        @Override // com.tencent.mm.vending.h.e
        public final String akn() {
            return "Vending.LOGIC";
        }

        public final com.tencent.mm.vending.g.c<com.tencent.mm.vending.j.d<Boolean, String, Long>> H(Map<String, Object> map) {
            AppMethodBeat.i(63449);
            com.tencent.mm.vending.g.c<com.tencent.mm.vending.j.d<Boolean, String, Long>> c2 = g.en(map).c(this);
            AppMethodBeat.o(63449);
            return c2;
        }
    }

    public class c implements com.tencent.mm.vending.h.e<com.tencent.mm.vending.j.d<Boolean, String, Long>, Map<String, Object>> {
        public c() {
        }

        @Override // com.tencent.mm.vending.c.a
        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.i(212950);
            Map map = (Map) obj;
            d dVar = e.this.jTZ;
            map.put(l.jSO, Integer.valueOf(dVar.QYU.getIntExtra("enter_scene", 1)));
            g.a(g.en(map).c(dVar.jTX.jTa));
            AppMethodBeat.o(212950);
            return null;
        }

        @Override // com.tencent.mm.vending.h.e
        public final String akn() {
            return "Vending.LOGIC";
        }

        public final com.tencent.mm.vending.g.c<com.tencent.mm.vending.j.d<Boolean, String, Long>> H(Map<String, Object> map) {
            AppMethodBeat.i(212949);
            com.tencent.mm.vending.g.c<com.tencent.mm.vending.j.d<Boolean, String, Long>> c2 = g.en(map).c(this);
            AppMethodBeat.o(212949);
            return c2;
        }
    }

    public class a implements com.tencent.mm.vending.h.e<com.tencent.mm.plugin.aa.model.e, Void> {
        public a() {
        }

        @Override // com.tencent.mm.vending.h.e
        public final String akn() {
            return "Vending.LOGIC";
        }

        @Override // com.tencent.mm.vending.c.a
        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.i(63446);
            g.a(g.hdG().c(e.this.jTZ.jTY.jSy));
            AppMethodBeat.o(63446);
            return null;
        }
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.tencent.mm.vending.c.b
    public final /* bridge */ /* synthetic */ d bmc() {
        return this.jTZ;
    }
}
