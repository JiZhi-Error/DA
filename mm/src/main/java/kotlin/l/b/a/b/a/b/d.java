package kotlin.l.b.a.b.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.Set;
import kotlin.a.ak;
import kotlin.a.x;
import kotlin.g.b.aa;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.g.b.y;
import kotlin.l.b.a.b.a.g;
import kotlin.l.b.a.b.b.an;
import kotlin.l.b.a.b.b.c.h;
import kotlin.l.b.a.b.b.e;
import kotlin.l.b.a.b.b.l;
import kotlin.l.b.a.b.b.w;
import kotlin.l.b.a.b.f.f;
import kotlin.l.b.a.b.l.i;
import kotlin.l.b.a.b.l.j;
import kotlin.l.k;

public final class d implements kotlin.l.b.a.b.b.b.b {
    private static final kotlin.l.b.a.b.f.b Tgg = g.TcD;
    private static final f Tgh;
    private static final kotlin.l.b.a.b.f.a Tgi;
    public static final a Tgj = new a((byte) 0);
    static final /* synthetic */ k[] cLI = {aa.a(new y(aa.bp(d.class), "cloneable", "getCloneable()Lorg/jetbrains/kotlin/descriptors/impl/ClassDescriptorImpl;"))};
    private final kotlin.l.b.a.b.l.f Tgd;
    private final kotlin.l.b.a.b.b.y Tge;
    private final kotlin.g.a.b<kotlin.l.b.a.b.b.y, l> Tgf;

    private final h hAc() {
        AppMethodBeat.i(56772);
        h hVar = (h) i.a(this.Tgd, cLI[0]);
        AppMethodBeat.o(56772);
        return hVar;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: kotlin.g.a.b<? super kotlin.l.b.a.b.b.y, ? extends kotlin.l.b.a.b.b.l> */
    /* JADX WARN: Multi-variable type inference failed */
    private d(j jVar, kotlin.l.b.a.b.b.y yVar, kotlin.g.a.b<? super kotlin.l.b.a.b.b.y, ? extends l> bVar) {
        p.h(jVar, "storageManager");
        p.h(yVar, "moduleDescriptor");
        p.h(bVar, "computeContainingDeclaration");
        AppMethodBeat.i(56776);
        this.Tge = yVar;
        this.Tgf = bVar;
        this.Tgd = jVar.al(new b(this, jVar));
        AppMethodBeat.o(56776);
    }

    public /* synthetic */ d(j jVar, kotlin.l.b.a.b.b.y yVar) {
        this(jVar, yVar, AnonymousClass1.Tgk);
        AppMethodBeat.i(56777);
        AppMethodBeat.o(56777);
    }

    @Override // kotlin.l.b.a.b.b.b.b
    public final boolean a(kotlin.l.b.a.b.f.b bVar, f fVar) {
        AppMethodBeat.i(56773);
        p.h(bVar, "packageFqName");
        p.h(fVar, "name");
        if (!p.j(fVar, Tgh) || !p.j(bVar, Tgg)) {
            AppMethodBeat.o(56773);
            return false;
        }
        AppMethodBeat.o(56773);
        return true;
    }

    @Override // kotlin.l.b.a.b.b.b.b
    public final e b(kotlin.l.b.a.b.f.a aVar) {
        AppMethodBeat.i(56774);
        p.h(aVar, "classId");
        if (p.j(aVar, Tgi)) {
            h hAc = hAc();
            AppMethodBeat.o(56774);
            return hAc;
        }
        AppMethodBeat.o(56774);
        return null;
    }

    @Override // kotlin.l.b.a.b.b.b.b
    public final Collection<e> b(kotlin.l.b.a.b.f.b bVar) {
        AppMethodBeat.i(56775);
        p.h(bVar, "packageFqName");
        if (p.j(bVar, Tgg)) {
            Set of = ak.setOf(hAc());
            AppMethodBeat.o(56775);
            return of;
        }
        x xVar = x.SXt;
        AppMethodBeat.o(56775);
        return xVar;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(56771);
        f hJg = g.TcO.TcU.hJg();
        p.g(hJg, "KotlinBuiltIns.FQ_NAMES.cloneable.shortName()");
        Tgh = hJg;
        kotlin.l.b.a.b.f.a p = kotlin.l.b.a.b.f.a.p(g.TcO.TcU.hJj());
        p.g(p, "ClassId.topLevel(KotlinB…NAMES.cloneable.toSafe())");
        Tgi = p;
        AppMethodBeat.o(56771);
    }

    static final class b extends q implements kotlin.g.a.a<h> {
        final /* synthetic */ d Tgl;
        final /* synthetic */ j Tgm;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(d dVar, j jVar) {
            super(0);
            this.Tgl = dVar;
            this.Tgm = jVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ h invoke() {
            AppMethodBeat.i(56770);
            h hVar = new h((l) this.Tgl.Tgf.invoke(this.Tgl.Tge), d.Tgh, w.ABSTRACT, kotlin.l.b.a.b.b.f.INTERFACE, kotlin.a.j.listOf(this.Tgl.Tge.hBh().hzi()), an.ThK, this.Tgm);
            hVar.a(new a(this.Tgm, hVar), x.SXt, null);
            AppMethodBeat.o(56770);
            return hVar;
        }
    }
}
