package kotlin.l.b.a.b.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.a.v;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.l.b.a.b.a.g;
import kotlin.l.b.a.b.a.j;
import kotlin.l.b.a.b.b.a.g;
import kotlin.l.b.a.b.b.ab;
import kotlin.l.b.a.b.b.an;
import kotlin.l.b.a.b.b.aq;
import kotlin.l.b.a.b.b.as;
import kotlin.l.b.a.b.b.az;
import kotlin.l.b.a.b.b.ba;
import kotlin.l.b.a.b.b.c.ai;
import kotlin.l.b.a.b.b.d;
import kotlin.l.b.a.b.b.e;
import kotlin.l.b.a.b.b.l;
import kotlin.l.b.a.b.b.s;
import kotlin.l.b.a.b.b.w;
import kotlin.l.b.a.b.b.y;
import kotlin.l.b.a.b.f.f;
import kotlin.l.b.a.b.j.f.h;
import kotlin.l.b.a.b.m.a.i;
import kotlin.l.b.a.b.m.ac;
import kotlin.l.b.a.b.m.at;
import kotlin.l.b.a.b.m.ax;
import kotlin.l.b.a.b.m.bh;
import kotlin.x;

public final class b extends kotlin.l.b.a.b.b.c.a {
    private static final kotlin.l.b.a.b.f.a Tfw = new kotlin.l.b.a.b.f.a(g.TcD, f.btY("Function"));
    private static final kotlin.l.b.a.b.f.a Tfx = new kotlin.l.b.a.b.f.a(j.hzw(), f.btY("KFunction"));
    public static final a Tfy = new a((byte) 0);
    private final kotlin.l.b.a.b.l.j TcN;
    private final C2273b Tfs = new C2273b();
    private final d Tft = new d(this.TcN, this);
    private final ab Tfu;
    final c Tfv;
    final int arity;
    final List<as> parameters;

    @Override // kotlin.l.b.a.b.b.c.t
    public final /* synthetic */ h a(i iVar) {
        AppMethodBeat.i(56727);
        p.h(iVar, "kotlinTypeRefiner");
        d dVar = this.Tft;
        AppMethodBeat.o(56727);
        return dVar;
    }

    @Override // kotlin.l.b.a.b.b.e
    public final /* bridge */ /* synthetic */ e hzA() {
        return null;
    }

    @Override // kotlin.l.b.a.b.b.e
    public final /* bridge */ /* synthetic */ d hzD() {
        return null;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(kotlin.l.b.a.b.l.j jVar, ab abVar, c cVar, int i2) {
        super(jVar, cVar.atQ(i2));
        p.h(jVar, "storageManager");
        p.h(abVar, "containingDeclaration");
        p.h(cVar, "functionKind");
        AppMethodBeat.i(56732);
        this.TcN = jVar;
        this.Tfu = abVar;
        this.Tfv = cVar;
        this.arity = i2;
        final ArrayList arrayList = new ArrayList();
        AnonymousClass1 r4 = new m<bh, String, x>(this) {
            /* class kotlin.l.b.a.b.a.a.b.AnonymousClass1 */
            final /* synthetic */ b Tfz;

            {
                this.Tfz = r2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
            @Override // kotlin.g.a.m
            public final /* synthetic */ x invoke(bh bhVar, String str) {
                AppMethodBeat.i(56716);
                a(bhVar, str);
                x xVar = x.SXb;
                AppMethodBeat.o(56716);
                return xVar;
            }

            public final void a(bh bhVar, String str) {
                AppMethodBeat.i(56717);
                p.h(bhVar, "variance");
                p.h(str, "name");
                ArrayList arrayList = arrayList;
                g.a aVar = kotlin.l.b.a.b.b.a.g.TiC;
                arrayList.add(ai.a(this.Tfz, g.a.hBP(), bhVar, f.btY(str), arrayList.size(), this.Tfz.TcN));
                AppMethodBeat.o(56717);
            }
        };
        kotlin.k.f fVar = new kotlin.k.f(1, this.arity);
        ArrayList arrayList2 = new ArrayList(kotlin.a.j.a(fVar, 10));
        Iterator it = fVar.iterator();
        while (it.hasNext()) {
            r4.a(bh.IN_VARIANCE, "P".concat(String.valueOf(((kotlin.a.ab) it).nextInt())));
            arrayList2.add(x.SXb);
        }
        r4.a(bh.OUT_VARIANCE, "R");
        this.parameters = kotlin.a.j.p(arrayList);
        AppMethodBeat.o(56732);
    }

    /* JADX WARN: Init of enum TfA can be incorrect */
    /* JADX WARN: Init of enum TfB can be incorrect */
    public enum c {
        Function(r3, "Function"),
        SuspendFunction(r3, "SuspendFunction"),
        KFunction(j.hzw(), "KFunction"),
        KSuspendFunction(j.hzw(), "KSuspendFunction");
        
        public static final a TfH = new a((byte) 0);
        public final kotlin.l.b.a.b.f.b TfF;
        public final String TfG;

        public static c valueOf(String str) {
            AppMethodBeat.i(56726);
            c cVar = (c) Enum.valueOf(c.class, str);
            AppMethodBeat.o(56726);
            return cVar;
        }

        private c(kotlin.l.b.a.b.f.b bVar, String str) {
            this.TfF = bVar;
            this.TfG = str;
        }

        static {
            AppMethodBeat.i(56723);
            p.g(kotlin.l.b.a.b.a.g.TcD, "BUILT_INS_PACKAGE_FQ_NAME");
            p.g(kotlin.l.b.a.b.j.c.THv, "COROUTINES_PACKAGE_FQ_NAME_RELEASE");
            AppMethodBeat.o(56723);
        }

        public final f atQ(int i2) {
            AppMethodBeat.i(56724);
            f btY = f.btY(this.TfG + i2);
            p.g(btY, "Name.identifier(\"$classNamePrefix$arity\")");
            AppMethodBeat.o(56724);
            return btY;
        }

        public static final class a {
            private a() {
            }

            public /* synthetic */ a(byte b2) {
                this();
            }
        }
    }

    @Override // kotlin.l.b.a.b.b.h
    public final at hzz() {
        return this.Tfs;
    }

    @Override // kotlin.l.b.a.b.b.e
    public final kotlin.l.b.a.b.b.f hzB() {
        return kotlin.l.b.a.b.b.f.INTERFACE;
    }

    @Override // kotlin.l.b.a.b.b.e, kotlin.l.b.a.b.b.v
    public final w hzC() {
        return w.ABSTRACT;
    }

    @Override // kotlin.l.b.a.b.b.e, kotlin.l.b.a.b.b.v, kotlin.l.b.a.b.b.p
    public final ba hzE() {
        AppMethodBeat.i(56728);
        ba baVar = az.ThU;
        p.g(baVar, "Visibilities.PUBLIC");
        AppMethodBeat.o(56728);
        return baVar;
    }

    @Override // kotlin.l.b.a.b.b.e
    public final boolean hzF() {
        return false;
    }

    @Override // kotlin.l.b.a.b.b.i
    public final boolean hzG() {
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

    @Override // kotlin.l.b.a.b.b.v
    public final boolean isExternal() {
        return false;
    }

    @Override // kotlin.l.b.a.b.b.a.a
    public final kotlin.l.b.a.b.b.a.g hzL() {
        AppMethodBeat.i(56729);
        g.a aVar = kotlin.l.b.a.b.b.a.g.TiC;
        kotlin.l.b.a.b.b.a.g hBP = g.a.hBP();
        AppMethodBeat.o(56729);
        return hBP;
    }

    @Override // kotlin.l.b.a.b.b.o
    public final an hzM() {
        AppMethodBeat.i(56730);
        an anVar = an.ThK;
        p.g(anVar, "SourceElement.NO_SOURCE");
        AppMethodBeat.o(56730);
        return anVar;
    }

    @Override // kotlin.l.b.a.b.b.e, kotlin.l.b.a.b.b.i
    public final List<as> hzO() {
        return this.parameters;
    }

    /* renamed from: kotlin.l.b.a.b.a.a.b$b  reason: collision with other inner class name */
    final class C2273b extends kotlin.l.b.a.b.m.b {
        /* JADX WARN: Incorrect args count in method signature: ()V */
        public C2273b() {
            super(b.this.TcN);
            AppMethodBeat.i(56722);
            AppMethodBeat.o(56722);
        }

        @Override // kotlin.l.b.a.b.m.h
        public final Collection<kotlin.l.b.a.b.m.ab> hzR() {
            List listOf;
            AppMethodBeat.i(56719);
            switch (c.$EnumSwitchMapping$0[b.this.Tfv.ordinal()]) {
                case 1:
                    listOf = kotlin.a.j.listOf(b.Tfw);
                    break;
                case 2:
                    listOf = kotlin.a.j.listOf((Object[]) new kotlin.l.b.a.b.f.a[]{b.Tfx, new kotlin.l.b.a.b.f.a(kotlin.l.b.a.b.a.g.TcD, c.Function.atQ(b.this.arity))});
                    break;
                case 3:
                    listOf = kotlin.a.j.listOf(b.Tfw);
                    break;
                case 4:
                    listOf = kotlin.a.j.listOf((Object[]) new kotlin.l.b.a.b.f.a[]{b.Tfx, new kotlin.l.b.a.b.f.a(kotlin.l.b.a.b.j.c.THv, c.SuspendFunction.atQ(b.this.arity))});
                    break;
                default:
                    kotlin.m mVar = new kotlin.m();
                    AppMethodBeat.o(56719);
                    throw mVar;
            }
            y hBj = b.this.Tfu.hBj();
            List<kotlin.l.b.a.b.f.a> list = listOf;
            ArrayList arrayList = new ArrayList(kotlin.a.j.a(list, 10));
            for (kotlin.l.b.a.b.f.a aVar : list) {
                e b2 = s.b(hBj, aVar);
                if (b2 == null) {
                    IllegalStateException illegalStateException = new IllegalStateException(("Built-in class " + aVar + " not found").toString());
                    AppMethodBeat.o(56719);
                    throw illegalStateException;
                }
                List list2 = b.this.parameters;
                at hzz = b2.hzz();
                p.g(hzz, "descriptor.typeConstructor");
                List<as> N = kotlin.a.j.N(list2, hzz.getParameters().size());
                ArrayList arrayList2 = new ArrayList(kotlin.a.j.a(N, 10));
                for (as asVar : N) {
                    arrayList2.add(new ax(asVar.hAG()));
                }
                g.a aVar2 = kotlin.l.b.a.b.b.a.g.TiC;
                arrayList.add(ac.a(g.a.hBP(), b2, arrayList2));
            }
            List p = kotlin.a.j.p(arrayList);
            AppMethodBeat.o(56719);
            return p;
        }

        @Override // kotlin.l.b.a.b.m.at
        public final List<as> getParameters() {
            AppMethodBeat.i(258553);
            List<as> list = b.this.parameters;
            AppMethodBeat.o(258553);
            return list;
        }

        @Override // kotlin.l.b.a.b.m.at
        public final boolean hzU() {
            return true;
        }

        @Override // kotlin.l.b.a.b.m.h
        public final aq hzV() {
            return aq.a.ThM;
        }

        @Override // kotlin.l.b.a.b.m.at, kotlin.l.b.a.b.m.b
        public final /* bridge */ /* synthetic */ kotlin.l.b.a.b.b.h hzS() {
            return b.this;
        }

        @Override // kotlin.l.b.a.b.m.b
        public final /* bridge */ /* synthetic */ e hzT() {
            return b.this;
        }

        public final String toString() {
            AppMethodBeat.i(56721);
            String bVar = b.this.toString();
            AppMethodBeat.o(56721);
            return bVar;
        }
    }

    public final String toString() {
        AppMethodBeat.i(56731);
        String sG = hAH().sG();
        p.g(sG, "name.asString()");
        AppMethodBeat.o(56731);
        return sG;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(56733);
        AppMethodBeat.o(56733);
    }

    @Override // kotlin.l.b.a.b.b.e, kotlin.l.b.a.b.b.m, kotlin.l.b.a.b.b.l
    public final /* bridge */ /* synthetic */ l hzx() {
        return this.Tfu;
    }

    @Override // kotlin.l.b.a.b.b.e
    public final /* bridge */ /* synthetic */ h hzy() {
        return h.b.TKa;
    }

    @Override // kotlin.l.b.a.b.b.e
    public final /* bridge */ /* synthetic */ Collection hxW() {
        return v.SXr;
    }

    @Override // kotlin.l.b.a.b.b.e
    public final /* bridge */ /* synthetic */ Collection hzN() {
        return v.SXr;
    }
}
