package kotlin.l.b.a.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.a.ab;
import kotlin.a.ak;
import kotlin.a.v;
import kotlin.a.x;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l.b.a.b.b.a.g;
import kotlin.l.b.a.b.b.c.ai;
import kotlin.l.b.a.b.b.c.g;
import kotlin.l.b.a.b.b.c.m;
import kotlin.l.b.a.b.f.f;
import kotlin.l.b.a.b.j.f.h;
import kotlin.l.b.a.b.l.j;
import kotlin.l.b.a.b.m.a.i;
import kotlin.l.b.a.b.m.at;
import kotlin.l.b.a.b.m.bh;

public final class aa {
    final j TcN;
    final y Tfp;
    final kotlin.l.b.a.b.l.c<kotlin.l.b.a.b.f.b, ab> Thu = this.TcN.U(new d(this));
    private final kotlin.l.b.a.b.l.c<a, e> Thv = this.TcN.U(new c(this));

    static final class c extends q implements kotlin.g.a.b<a, b> {
        final /* synthetic */ aa ThA;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(aa aaVar) {
            super(1);
            this.ThA = aaVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX WARNING: Removed duplicated region for block: B:11:0x0068  */
        /* JADX WARNING: Removed duplicated region for block: B:15:0x0089  */
        @Override // kotlin.g.a.b
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final /* synthetic */ kotlin.l.b.a.b.b.aa.b invoke(kotlin.l.b.a.b.b.aa.a r9) {
            /*
            // Method dump skipped, instructions count: 139
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.l.b.a.b.b.aa.c.invoke(java.lang.Object):java.lang.Object");
        }
    }

    static final class d extends q implements kotlin.g.a.b<kotlin.l.b.a.b.f.b, m> {
        final /* synthetic */ aa ThA;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(aa aaVar) {
            super(1);
            this.ThA = aaVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ m invoke(kotlin.l.b.a.b.f.b bVar) {
            AppMethodBeat.i(56875);
            kotlin.l.b.a.b.f.b bVar2 = bVar;
            p.h(bVar2, "fqName");
            m mVar = new m(this.ThA.Tfp, bVar2);
            AppMethodBeat.o(56875);
            return mVar;
        }
    }

    public aa(j jVar, y yVar) {
        p.h(jVar, "storageManager");
        p.h(yVar, "module");
        AppMethodBeat.i(56877);
        this.TcN = jVar;
        this.Tfp = yVar;
        AppMethodBeat.o(56877);
    }

    /* access modifiers changed from: package-private */
    public static final class a {
        final kotlin.l.b.a.b.f.a Tfj;
        final List<Integer> Thw;

        /* JADX WARNING: Code restructure failed: missing block: B:7:0x0020, code lost:
            if (kotlin.g.b.p.j(r3.Thw, r4.Thw) != false) goto L_0x0022;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean equals(java.lang.Object r4) {
            /*
                r3 = this;
                r2 = 56868(0xde24, float:7.9689E-41)
                com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
                if (r3 == r4) goto L_0x0022
                boolean r0 = r4 instanceof kotlin.l.b.a.b.b.aa.a
                if (r0 == 0) goto L_0x0027
                kotlin.l.b.a.b.b.aa$a r4 = (kotlin.l.b.a.b.b.aa.a) r4
                kotlin.l.b.a.b.f.a r0 = r3.Tfj
                kotlin.l.b.a.b.f.a r1 = r4.Tfj
                boolean r0 = kotlin.g.b.p.j(r0, r1)
                if (r0 == 0) goto L_0x0027
                java.util.List<java.lang.Integer> r0 = r3.Thw
                java.util.List<java.lang.Integer> r1 = r4.Thw
                boolean r0 = kotlin.g.b.p.j(r0, r1)
                if (r0 == 0) goto L_0x0027
            L_0x0022:
                r0 = 1
                com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            L_0x0026:
                return r0
            L_0x0027:
                r0 = 0
                com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
                goto L_0x0026
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.l.b.a.b.b.aa.a.equals(java.lang.Object):boolean");
        }

        public final int hashCode() {
            int i2 = 0;
            AppMethodBeat.i(56867);
            kotlin.l.b.a.b.f.a aVar = this.Tfj;
            int hashCode = (aVar != null ? aVar.hashCode() : 0) * 31;
            List<Integer> list = this.Thw;
            if (list != null) {
                i2 = list.hashCode();
            }
            int i3 = hashCode + i2;
            AppMethodBeat.o(56867);
            return i3;
        }

        public final String toString() {
            AppMethodBeat.i(56866);
            String str = "ClassRequest(classId=" + this.Tfj + ", typeParametersCount=" + this.Thw + ")";
            AppMethodBeat.o(56866);
            return str;
        }

        public a(kotlin.l.b.a.b.f.a aVar, List<Integer> list) {
            p.h(aVar, "classId");
            p.h(list, "typeParametersCount");
            AppMethodBeat.i(56865);
            this.Tfj = aVar;
            this.Thw = list;
            AppMethodBeat.o(56865);
        }
    }

    public static final class b extends g {
        private final List<as> Thx;
        private final kotlin.l.b.a.b.m.j Thy;
        private final boolean Thz;

        @Override // kotlin.l.b.a.b.b.c.t
        public final /* synthetic */ h a(i iVar) {
            AppMethodBeat.i(56871);
            p.h(iVar, "kotlinTypeRefiner");
            h.b bVar = h.b.TKa;
            AppMethodBeat.o(56871);
            return bVar;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(j jVar, l lVar, f fVar, boolean z, int i2) {
            super(jVar, lVar, fVar, an.ThK);
            p.h(jVar, "storageManager");
            p.h(lVar, "container");
            p.h(fVar, "name");
            AppMethodBeat.i(56873);
            this.Thz = z;
            kotlin.k.f mY = kotlin.k.j.mY(0, i2);
            ArrayList arrayList = new ArrayList(kotlin.a.j.a(mY, 10));
            Iterator it = mY.iterator();
            while (it.hasNext()) {
                int nextInt = ((ab) it).nextInt();
                g.a aVar = kotlin.l.b.a.b.b.a.g.TiC;
                arrayList.add(ai.a(this, g.a.hBP(), bh.INVARIANT, f.btY("T".concat(String.valueOf(nextInt))), nextInt, jVar));
            }
            this.Thx = arrayList;
            this.Thy = new kotlin.l.b.a.b.m.j(this, this.Thx, ak.setOf(kotlin.l.b.a.b.j.d.a.F(this).hBh().hzi()), jVar);
            AppMethodBeat.o(56873);
        }

        @Override // kotlin.l.b.a.b.b.e
        public final f hzB() {
            return f.CLASS;
        }

        @Override // kotlin.l.b.a.b.b.e, kotlin.l.b.a.b.b.v
        public final w hzC() {
            return w.FINAL;
        }

        @Override // kotlin.l.b.a.b.b.e, kotlin.l.b.a.b.b.v, kotlin.l.b.a.b.b.p
        public final ba hzE() {
            AppMethodBeat.i(56869);
            ba baVar = az.ThU;
            p.g(baVar, "Visibilities.PUBLIC");
            AppMethodBeat.o(56869);
            return baVar;
        }

        @Override // kotlin.l.b.a.b.b.e, kotlin.l.b.a.b.b.i
        public final List<as> hzO() {
            return this.Thx;
        }

        @Override // kotlin.l.b.a.b.b.i
        public final boolean hzG() {
            return this.Thz;
        }

        @Override // kotlin.l.b.a.b.b.e
        public final boolean hzF() {
            return false;
        }

        @Override // kotlin.l.b.a.b.b.e
        public final boolean hzH() {
            return false;
        }

        @Override // kotlin.l.b.a.b.b.e
        public final boolean hzI() {
            return false;
        }

        @Override // kotlin.l.b.a.b.b.v
        public final boolean hzJ() {
            return false;
        }

        @Override // kotlin.l.b.a.b.b.v
        public final boolean hzK() {
            return false;
        }

        @Override // kotlin.l.b.a.b.b.c.g, kotlin.l.b.a.b.b.v
        public final boolean isExternal() {
            return false;
        }

        @Override // kotlin.l.b.a.b.b.a.a
        public final kotlin.l.b.a.b.b.a.g hzL() {
            AppMethodBeat.i(56870);
            g.a aVar = kotlin.l.b.a.b.b.a.g.TiC;
            kotlin.l.b.a.b.b.a.g hBP = g.a.hBP();
            AppMethodBeat.o(56870);
            return hBP;
        }

        @Override // kotlin.l.b.a.b.b.e
        public final d hzD() {
            return null;
        }

        @Override // kotlin.l.b.a.b.b.e
        public final e hzA() {
            return null;
        }

        public final String toString() {
            AppMethodBeat.i(56872);
            String str = "class " + hAH() + " (not found)";
            AppMethodBeat.o(56872);
            return str;
        }

        @Override // kotlin.l.b.a.b.b.h
        public final /* bridge */ /* synthetic */ at hzz() {
            return this.Thy;
        }

        @Override // kotlin.l.b.a.b.b.e
        public final /* bridge */ /* synthetic */ h hzy() {
            return h.b.TKa;
        }

        @Override // kotlin.l.b.a.b.b.e
        public final Collection<d> hxW() {
            return x.SXt;
        }

        @Override // kotlin.l.b.a.b.b.e
        public final Collection<e> hzN() {
            return v.SXr;
        }
    }

    public final e a(kotlin.l.b.a.b.f.a aVar, List<Integer> list) {
        AppMethodBeat.i(56876);
        p.h(aVar, "classId");
        p.h(list, "typeParametersCount");
        e invoke = this.Thv.invoke(new a(aVar, list));
        AppMethodBeat.o(56876);
        return invoke;
    }
}
