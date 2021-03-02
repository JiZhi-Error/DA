package kotlin.l.b.a.b.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.k;
import kotlin.l.b.a.b.b.an;
import kotlin.l.b.a.b.b.e;
import kotlin.l.b.a.b.f.b;
import kotlin.l.b.a.b.m.ab;
import kotlin.l.b.a.b.m.aj;

public final class j implements c {
    private final f TiG = g.a(k.PUBLICATION, new a(this));
    final kotlin.l.b.a.b.a.g TiH;
    final b TiI;
    private final Map<kotlin.l.b.a.b.f.f, kotlin.l.b.a.b.j.b.g<?>> TiJ;

    @Override // kotlin.l.b.a.b.b.a.c
    public final ab hBy() {
        AppMethodBeat.i(56958);
        ab abVar = (ab) this.TiG.getValue();
        AppMethodBeat.o(56958);
        return abVar;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: java.util.Map<kotlin.l.b.a.b.f.f, ? extends kotlin.l.b.a.b.j.b.g<?>> */
    /* JADX WARN: Multi-variable type inference failed */
    public j(kotlin.l.b.a.b.a.g gVar, b bVar, Map<kotlin.l.b.a.b.f.f, ? extends kotlin.l.b.a.b.j.b.g<?>> map) {
        p.h(gVar, "builtIns");
        p.h(bVar, "fqName");
        p.h(map, "allValueArguments");
        AppMethodBeat.i(56960);
        this.TiH = gVar;
        this.TiI = bVar;
        this.TiJ = map;
        AppMethodBeat.o(56960);
    }

    @Override // kotlin.l.b.a.b.b.a.c
    public final b hBk() {
        return this.TiI;
    }

    @Override // kotlin.l.b.a.b.b.a.c
    public final Map<kotlin.l.b.a.b.f.f, kotlin.l.b.a.b.j.b.g<?>> hBO() {
        return this.TiJ;
    }

    @Override // kotlin.l.b.a.b.b.a.c
    public final an hzM() {
        AppMethodBeat.i(56959);
        an anVar = an.ThK;
        p.g(anVar, "SourceElement.NO_SOURCE");
        AppMethodBeat.o(56959);
        return anVar;
    }

    static final class a extends q implements kotlin.g.a.a<aj> {
        final /* synthetic */ j TiK;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(j jVar) {
            super(0);
            this.TiK = jVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ aj invoke() {
            AppMethodBeat.i(56956);
            e a2 = this.TiK.TiH.a(this.TiK.TiI);
            p.g(a2, "builtIns.getBuiltInClassByFqName(fqName)");
            aj hAG = a2.hAG();
            AppMethodBeat.o(56956);
            return hAG;
        }
    }
}
