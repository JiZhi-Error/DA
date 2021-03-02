package kotlin.l.b.a.b.d.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l.b.a.b.b.aa;
import kotlin.l.b.a.b.b.an;
import kotlin.l.b.a.b.b.av;
import kotlin.l.b.a.b.b.e;
import kotlin.l.b.a.b.b.y;
import kotlin.l.b.a.b.d.b.p;
import kotlin.l.b.a.b.e.a;
import kotlin.l.b.a.b.j.b.d;
import kotlin.l.b.a.b.j.b.g;
import kotlin.l.b.a.b.j.b.h;
import kotlin.l.b.a.b.j.b.k;
import kotlin.l.b.a.b.j.b.m;
import kotlin.l.b.a.b.j.b.r;
import kotlin.l.b.a.b.j.b.s;
import kotlin.l.b.a.b.j.b.u;
import kotlin.l.b.a.b.j.b.w;
import kotlin.l.b.a.b.j.b.x;
import kotlin.l.b.a.b.j.b.z;
import kotlin.l.b.a.b.k.a.f;
import kotlin.l.b.a.b.l.j;
import kotlin.l.b.a.b.m.ab;

public final class c extends a<kotlin.l.b.a.b.b.a.c, g<?>> {
    private final aa TeR;
    private final y Tfp;
    private final f Tvk = new f(this.Tfp, this.TeR);

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.l.b.a.b.d.b.a
    public final /* synthetic */ kotlin.l.b.a.b.b.a.c a(a.C2299a aVar, kotlin.l.b.a.b.e.b.c cVar) {
        AppMethodBeat.i(58177);
        p.h(aVar, "proto");
        p.h(cVar, "nameResolver");
        kotlin.l.b.a.b.b.a.c b2 = this.Tvk.b(aVar, cVar);
        AppMethodBeat.o(58177);
        return b2;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.l.b.a.b.d.b.a
    public final /* synthetic */ g<?> fq(g<?> gVar) {
        AppMethodBeat.i(58178);
        g<?> gVar2 = gVar;
        p.h(gVar2, "constant");
        if (gVar2 instanceof d) {
            w wVar = new w(((Number) ((d) gVar2).getValue()).byteValue());
            AppMethodBeat.o(58178);
            return wVar;
        } else if (gVar2 instanceof u) {
            z zVar = new z(((Number) ((u) gVar2).getValue()).shortValue());
            AppMethodBeat.o(58178);
            return zVar;
        } else if (gVar2 instanceof m) {
            x xVar = new x(((Number) ((m) gVar2).getValue()).intValue());
            AppMethodBeat.o(58178);
            return xVar;
        } else if (gVar2 instanceof s) {
            kotlin.l.b.a.b.j.b.y yVar = new kotlin.l.b.a.b.j.b.y(((Number) ((s) gVar2).getValue()).longValue());
            AppMethodBeat.o(58178);
            return yVar;
        } else {
            AppMethodBeat.o(58178);
            return gVar2;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(y yVar, aa aaVar, j jVar, n nVar) {
        super(jVar, nVar);
        p.h(yVar, "module");
        p.h(aaVar, "notFoundClasses");
        p.h(jVar, "storageManager");
        p.h(nVar, "kotlinClassFinder");
        AppMethodBeat.i(58180);
        this.Tfp = yVar;
        this.TeR = aaVar;
        AppMethodBeat.o(58180);
    }

    public static final class a implements p.a {
        final /* synthetic */ List FqY;
        final HashMap<kotlin.l.b.a.b.f.f, g<?>> Tvl = new HashMap<>();
        final /* synthetic */ c Tvm;
        final /* synthetic */ e Tvn;
        final /* synthetic */ an Tvo;

        a(c cVar, e eVar, List list, an anVar) {
            this.Tvm = cVar;
            this.Tvn = eVar;
            this.FqY = list;
            this.Tvo = anVar;
            AppMethodBeat.i(58176);
            AppMethodBeat.o(58176);
        }

        @Override // kotlin.l.b.a.b.d.b.p.a
        public final void a(kotlin.l.b.a.b.f.f fVar, Object obj) {
            AppMethodBeat.i(58169);
            if (fVar != null) {
                this.Tvl.put(fVar, b(fVar, obj));
            }
            AppMethodBeat.o(58169);
        }

        @Override // kotlin.l.b.a.b.d.b.p.a
        public final void a(kotlin.l.b.a.b.f.f fVar, kotlin.l.b.a.b.j.b.f fVar2) {
            AppMethodBeat.i(58170);
            kotlin.g.b.p.h(fVar, "name");
            kotlin.g.b.p.h(fVar2, "value");
            this.Tvl.put(fVar, new r(fVar2));
            AppMethodBeat.o(58170);
        }

        @Override // kotlin.l.b.a.b.d.b.p.a
        public final void a(kotlin.l.b.a.b.f.f fVar, kotlin.l.b.a.b.f.a aVar, kotlin.l.b.a.b.f.f fVar2) {
            AppMethodBeat.i(58171);
            kotlin.g.b.p.h(fVar, "name");
            kotlin.g.b.p.h(aVar, "enumClassId");
            kotlin.g.b.p.h(fVar2, "enumEntryName");
            this.Tvl.put(fVar, new kotlin.l.b.a.b.j.b.j(aVar, fVar2));
            AppMethodBeat.o(58171);
        }

        public static final class b implements p.b {
            final /* synthetic */ kotlin.l.b.a.b.f.f TgT;
            final /* synthetic */ a Tvq;
            private final ArrayList<g<?>> Tvs = new ArrayList<>();

            b(a aVar, kotlin.l.b.a.b.f.f fVar) {
                this.Tvq = aVar;
                this.TgT = fVar;
                AppMethodBeat.i(58168);
                AppMethodBeat.o(58168);
            }

            @Override // kotlin.l.b.a.b.d.b.p.b
            public final void fr(Object obj) {
                AppMethodBeat.i(58164);
                this.Tvs.add(a.b(this.TgT, obj));
                AppMethodBeat.o(58164);
            }

            @Override // kotlin.l.b.a.b.d.b.p.b
            public final void a(kotlin.l.b.a.b.f.a aVar, kotlin.l.b.a.b.f.f fVar) {
                AppMethodBeat.i(58165);
                kotlin.g.b.p.h(aVar, "enumClassId");
                kotlin.g.b.p.h(fVar, "enumEntryName");
                this.Tvs.add(new kotlin.l.b.a.b.j.b.j(aVar, fVar));
                AppMethodBeat.o(58165);
            }

            @Override // kotlin.l.b.a.b.d.b.p.b
            public final void a(kotlin.l.b.a.b.j.b.f fVar) {
                AppMethodBeat.i(58166);
                kotlin.g.b.p.h(fVar, "value");
                this.Tvs.add(new r(fVar));
                AppMethodBeat.o(58166);
            }

            @Override // kotlin.l.b.a.b.d.b.p.b
            public final void Td() {
                AppMethodBeat.i(58167);
                av b2 = kotlin.l.b.a.b.d.a.a.a.b(this.TgT, this.Tvq.Tvn);
                if (b2 != null) {
                    kotlin.l.b.a.b.f.f fVar = this.TgT;
                    h hVar = h.TIu;
                    List bC = kotlin.l.b.a.b.o.a.bC(this.Tvs);
                    ab hBy = b2.hBy();
                    kotlin.g.b.p.g(hBy, "parameter.type");
                    this.Tvq.Tvl.put(fVar, h.a(bC, hBy));
                }
                AppMethodBeat.o(58167);
            }
        }

        @Override // kotlin.l.b.a.b.d.b.p.a
        public final p.b n(kotlin.l.b.a.b.f.f fVar) {
            AppMethodBeat.i(58172);
            kotlin.g.b.p.h(fVar, "name");
            b bVar = new b(this, fVar);
            AppMethodBeat.o(58172);
            return bVar;
        }

        @Override // kotlin.l.b.a.b.d.b.p.a
        public final p.a a(kotlin.l.b.a.b.f.f fVar, kotlin.l.b.a.b.f.a aVar) {
            AppMethodBeat.i(58173);
            kotlin.g.b.p.h(fVar, "name");
            kotlin.g.b.p.h(aVar, "classId");
            ArrayList arrayList = new ArrayList();
            c cVar = this.Tvm;
            an anVar = an.ThK;
            kotlin.g.b.p.g(anVar, "SourceElement.NO_SOURCE");
            C2297a aVar2 = new C2297a(this, cVar.a(aVar, anVar, arrayList), fVar, arrayList);
            AppMethodBeat.o(58173);
            return aVar2;
        }

        /* renamed from: kotlin.l.b.a.b.d.b.c$a$a  reason: collision with other inner class name */
        public static final class C2297a implements p.a {
            final /* synthetic */ kotlin.l.b.a.b.f.f TgT;
            final /* synthetic */ ArrayList TuF;
            private final /* synthetic */ p.a Tvp;
            final /* synthetic */ a Tvq;
            final /* synthetic */ p.a Tvr;

            @Override // kotlin.l.b.a.b.d.b.p.a
            public final p.a a(kotlin.l.b.a.b.f.f fVar, kotlin.l.b.a.b.f.a aVar) {
                AppMethodBeat.i(58160);
                kotlin.g.b.p.h(fVar, "name");
                kotlin.g.b.p.h(aVar, "classId");
                p.a a2 = this.Tvp.a(fVar, aVar);
                AppMethodBeat.o(58160);
                return a2;
            }

            @Override // kotlin.l.b.a.b.d.b.p.a
            public final void a(kotlin.l.b.a.b.f.f fVar, Object obj) {
                AppMethodBeat.i(58159);
                this.Tvp.a(fVar, obj);
                AppMethodBeat.o(58159);
            }

            @Override // kotlin.l.b.a.b.d.b.p.a
            public final void a(kotlin.l.b.a.b.f.f fVar, kotlin.l.b.a.b.f.a aVar, kotlin.l.b.a.b.f.f fVar2) {
                AppMethodBeat.i(58163);
                kotlin.g.b.p.h(fVar, "name");
                kotlin.g.b.p.h(aVar, "enumClassId");
                kotlin.g.b.p.h(fVar2, "enumEntryName");
                this.Tvp.a(fVar, aVar, fVar2);
                AppMethodBeat.o(58163);
            }

            @Override // kotlin.l.b.a.b.d.b.p.a
            public final void a(kotlin.l.b.a.b.f.f fVar, kotlin.l.b.a.b.j.b.f fVar2) {
                AppMethodBeat.i(58162);
                kotlin.g.b.p.h(fVar, "name");
                kotlin.g.b.p.h(fVar2, "value");
                this.Tvp.a(fVar, fVar2);
                AppMethodBeat.o(58162);
            }

            @Override // kotlin.l.b.a.b.d.b.p.a
            public final p.b n(kotlin.l.b.a.b.f.f fVar) {
                AppMethodBeat.i(58161);
                kotlin.g.b.p.h(fVar, "name");
                p.b n = this.Tvp.n(fVar);
                AppMethodBeat.o(58161);
                return n;
            }

            C2297a(a aVar, p.a aVar2, kotlin.l.b.a.b.f.f fVar, ArrayList arrayList) {
                this.Tvq = aVar;
                this.Tvr = aVar2;
                this.TgT = fVar;
                this.TuF = arrayList;
                this.Tvp = aVar2;
            }

            @Override // kotlin.l.b.a.b.d.b.p.a
            public final void Td() {
                AppMethodBeat.i(58158);
                this.Tvr.Td();
                this.Tvq.Tvl.put(this.TgT, new kotlin.l.b.a.b.j.b.a((kotlin.l.b.a.b.b.a.c) kotlin.a.j.kw(this.TuF)));
                AppMethodBeat.o(58158);
            }
        }

        @Override // kotlin.l.b.a.b.d.b.p.a
        public final void Td() {
            AppMethodBeat.i(58174);
            this.FqY.add(new kotlin.l.b.a.b.b.a.d(this.Tvn.hAG(), this.Tvl, this.Tvo));
            AppMethodBeat.o(58174);
        }

        static g<?> b(kotlin.l.b.a.b.f.f fVar, Object obj) {
            AppMethodBeat.i(58175);
            k fz = h.TIu.fz(obj);
            if (fz == null) {
                k.a aVar = k.TIz;
                fz = k.a.bui("Unsupported annotation argument: ".concat(String.valueOf(fVar)));
            }
            AppMethodBeat.o(58175);
            return fz;
        }
    }

    /* access modifiers changed from: protected */
    @Override // kotlin.l.b.a.b.d.b.a
    public final p.a a(kotlin.l.b.a.b.f.a aVar, an anVar, List<kotlin.l.b.a.b.b.a.c> list) {
        AppMethodBeat.i(58179);
        kotlin.g.b.p.h(aVar, "annotationClassId");
        kotlin.g.b.p.h(anVar, "source");
        kotlin.g.b.p.h(list, "result");
        a aVar2 = new a(this, kotlin.l.b.a.b.b.s.a(this.Tfp, aVar, this.TeR), list, anVar);
        AppMethodBeat.o(58179);
        return aVar2;
    }
}
