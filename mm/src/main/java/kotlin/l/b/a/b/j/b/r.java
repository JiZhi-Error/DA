package kotlin.l.b.a.b.j.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l.b.a.b.b.a.g;
import kotlin.l.b.a.b.b.as;
import kotlin.l.b.a.b.b.e;
import kotlin.l.b.a.b.b.h;
import kotlin.l.b.a.b.b.s;
import kotlin.l.b.a.b.b.y;
import kotlin.l.b.a.b.m.ab;
import kotlin.l.b.a.b.m.ac;
import kotlin.l.b.a.b.m.ad;
import kotlin.l.b.a.b.m.aj;
import kotlin.l.b.a.b.m.av;
import kotlin.l.b.a.b.m.ax;
import kotlin.l.b.a.b.m.bh;
import kotlin.l.b.a.b.m.u;
import kotlin.m;

public final class r extends g<b> {
    public static final a TIJ = new a((byte) 0);

    static {
        AppMethodBeat.i(60106);
        AppMethodBeat.o(60106);
    }

    public static abstract class b {

        /* renamed from: kotlin.l.b.a.b.j.b.r$b$b  reason: collision with other inner class name */
        public static final class C2344b extends b {
            public final f TIK;

            public final boolean equals(Object obj) {
                AppMethodBeat.i(60100);
                if (this == obj || ((obj instanceof C2344b) && p.j(this.TIK, ((C2344b) obj).TIK))) {
                    AppMethodBeat.o(60100);
                    return true;
                }
                AppMethodBeat.o(60100);
                return false;
            }

            public final int hashCode() {
                AppMethodBeat.i(60099);
                f fVar = this.TIK;
                if (fVar != null) {
                    int hashCode = fVar.hashCode();
                    AppMethodBeat.o(60099);
                    return hashCode;
                }
                AppMethodBeat.o(60099);
                return 0;
            }

            public final String toString() {
                AppMethodBeat.i(60098);
                String str = "NormalClass(value=" + this.TIK + ")";
                AppMethodBeat.o(60098);
                return str;
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public C2344b(f fVar) {
                super((byte) 0);
                p.h(fVar, "value");
                AppMethodBeat.i(60097);
                this.TIK = fVar;
                AppMethodBeat.o(60097);
            }
        }

        private b() {
        }

        public /* synthetic */ b(byte b2) {
            this();
        }

        public static final class a extends b {
            public final ab Tbs;

            public final boolean equals(Object obj) {
                AppMethodBeat.i(60096);
                if (this == obj || ((obj instanceof a) && p.j(this.Tbs, ((a) obj).Tbs))) {
                    AppMethodBeat.o(60096);
                    return true;
                }
                AppMethodBeat.o(60096);
                return false;
            }

            public final int hashCode() {
                AppMethodBeat.i(60095);
                ab abVar = this.Tbs;
                if (abVar != null) {
                    int hashCode = abVar.hashCode();
                    AppMethodBeat.o(60095);
                    return hashCode;
                }
                AppMethodBeat.o(60095);
                return 0;
            }

            public final String toString() {
                AppMethodBeat.i(60094);
                String str = "LocalClass(type=" + this.Tbs + ")";
                AppMethodBeat.o(60094);
                return str;
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(ab abVar) {
                super((byte) 0);
                p.h(abVar, "type");
                AppMethodBeat.i(60093);
                this.Tbs = abVar;
                AppMethodBeat.o(60093);
            }
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public r(b bVar) {
        super(bVar);
        p.h(bVar, "value");
        AppMethodBeat.i(60103);
        AppMethodBeat.o(60103);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public r(f fVar) {
        this(new b.C2344b(fVar));
        p.h(fVar, "value");
        AppMethodBeat.i(60104);
        AppMethodBeat.o(60104);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public r(kotlin.l.b.a.b.f.a aVar, int i2) {
        this(new f(aVar, i2));
        p.h(aVar, "classId");
        AppMethodBeat.i(60105);
        AppMethodBeat.o(60105);
    }

    @Override // kotlin.l.b.a.b.j.b.g
    public final ab b(y yVar) {
        AppMethodBeat.i(60101);
        p.h(yVar, "module");
        g.a aVar = g.TiC;
        g hBP = g.a.hBP();
        e a2 = yVar.hBh().a(kotlin.l.b.a.b.a.g.TcO.TdT.hJj());
        if (a2 == null) {
            kotlin.l.b.a.b.a.g.atM(19);
        }
        p.g(a2, "module.builtIns.kClass");
        aj a3 = ac.a(hBP, a2, j.listOf(new ax(c(yVar))));
        AppMethodBeat.o(60101);
        return a3;
    }

    private ab c(y yVar) {
        AppMethodBeat.i(60102);
        p.h(yVar, "module");
        b bVar = (b) getValue();
        if (bVar instanceof b.a) {
            ab abVar = ((b.a) getValue()).Tbs;
            AppMethodBeat.o(60102);
            return abVar;
        } else if (bVar instanceof b.C2344b) {
            f fVar = ((b.C2344b) getValue()).TIK;
            kotlin.l.b.a.b.f.a aVar = fVar.Tfj;
            int i2 = fVar.TIt;
            e b2 = s.b(yVar, aVar);
            if (b2 == null) {
                aj bun = u.bun("Unresolved type: " + aVar + " (arrayDimensions=" + i2 + ')');
                p.g(bun, "ErrorUtils.createErrorTy…sions=$arrayDimensions)\")");
                aj ajVar = bun;
                AppMethodBeat.o(60102);
                return ajVar;
            }
            aj hAG = b2.hAG();
            p.g(hAG, "descriptor.defaultType");
            aj aO = kotlin.l.b.a.b.m.d.a.aO(hAG);
            for (int i3 = 0; i3 < i2; i3++) {
                aj a2 = yVar.hBh().a(bh.INVARIANT, aO);
                p.g(a2, "module.builtIns.getArray…Variance.INVARIANT, type)");
                aO = a2;
            }
            AppMethodBeat.o(60102);
            return aO;
        } else {
            m mVar = new m();
            AppMethodBeat.o(60102);
            throw mVar;
        }
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static g<?> ae(ab abVar) {
            AppMethodBeat.i(60092);
            p.h(abVar, "argumentType");
            if (ad.ap(abVar)) {
                AppMethodBeat.o(60092);
                return null;
            }
            int i2 = 0;
            ab abVar2 = abVar;
            while (kotlin.l.b.a.b.a.g.m(abVar2)) {
                abVar2 = ((av) j.kw(abVar2.hKB())).hBy();
                p.g(abVar2, "type.arguments.single().type");
                i2++;
            }
            h hzS = abVar2.hKE().hzS();
            if (hzS instanceof e) {
                kotlin.l.b.a.b.f.a c2 = kotlin.l.b.a.b.j.d.a.c(hzS);
                if (c2 == null) {
                    r rVar = new r(new b.a(abVar));
                    AppMethodBeat.o(60092);
                    return rVar;
                }
                r rVar2 = new r(c2, i2);
                AppMethodBeat.o(60092);
                return rVar2;
            } else if (hzS instanceof as) {
                kotlin.l.b.a.b.f.a p = kotlin.l.b.a.b.f.a.p(kotlin.l.b.a.b.a.g.TcO.TcS.hJj());
                p.g(p, "ClassId.topLevel(KotlinB…ns.FQ_NAMES.any.toSafe())");
                r rVar3 = new r(p, 0);
                AppMethodBeat.o(60092);
                return rVar3;
            } else {
                AppMethodBeat.o(60092);
                return null;
            }
        }
    }
}
