package kotlin.l.b.a.b.d.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;
import kotlin.a.ae;
import kotlin.a.j;
import kotlin.g.b.aa;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.g.b.y;
import kotlin.l.b.a.b.b.a.c;
import kotlin.l.b.a.b.b.an;
import kotlin.l.b.a.b.b.e;
import kotlin.l.b.a.b.d.a.b.i;
import kotlin.l.b.a.b.d.a.c.h;
import kotlin.l.b.a.b.j.b.g;
import kotlin.l.b.a.b.l.f;
import kotlin.l.b.a.b.m.ab;
import kotlin.l.b.a.b.m.aj;
import kotlin.l.k;

public class b implements c, i {
    static final /* synthetic */ k[] cLI = {aa.a(new y(aa.bp(b.class), "type", "getType()Lorg/jetbrains/kotlin/types/SimpleType;"))};
    final kotlin.l.b.a.b.f.b TiI;
    private final an Tik;
    private final f TpP;
    final kotlin.l.b.a.b.d.a.e.b TpQ;
    private final boolean TpR;

    static {
        AppMethodBeat.i(57654);
        AppMethodBeat.o(57654);
    }

    public b(h hVar, kotlin.l.b.a.b.d.a.e.a aVar, kotlin.l.b.a.b.f.b bVar) {
        kotlin.l.b.a.b.d.a.d.a aVar2;
        b bVar2;
        p.h(hVar, "c");
        p.h(bVar, "fqName");
        AppMethodBeat.i(57657);
        this.TiI = bVar;
        if (aVar != null) {
            aVar2 = hVar.Trv.TqY.a(aVar);
            bVar2 = this;
        } else {
            aVar2 = an.ThK;
            p.g(aVar2, "SourceElement.NO_SOURCE");
            bVar2 = this;
        }
        bVar2.Tik = aVar2;
        this.TpP = hVar.Trv.TcN.al(new a(this, hVar));
        this.TpQ = aVar != null ? (kotlin.l.b.a.b.d.a.e.b) j.f(aVar.hCD()) : null;
        this.TpR = false;
        AppMethodBeat.o(57657);
    }

    @Override // kotlin.l.b.a.b.b.a.c
    public final kotlin.l.b.a.b.f.b hBk() {
        return this.TiI;
    }

    @Override // kotlin.l.b.a.b.b.a.c
    public final an hzM() {
        return this.Tik;
    }

    @Override // kotlin.l.b.a.b.b.a.c
    public Map<kotlin.l.b.a.b.f.f, g<?>> hBO() {
        AppMethodBeat.i(57656);
        Map<kotlin.l.b.a.b.f.f, g<?>> emptyMap = ae.emptyMap();
        AppMethodBeat.o(57656);
        return emptyMap;
    }

    @Override // kotlin.l.b.a.b.d.a.b.i
    public final boolean hDF() {
        return this.TpR;
    }

    @Override // kotlin.l.b.a.b.b.a.c
    public final /* synthetic */ ab hBy() {
        AppMethodBeat.i(57655);
        aj ajVar = (aj) kotlin.l.b.a.b.l.i.a(this.TpP, cLI[0]);
        AppMethodBeat.o(57655);
        return ajVar;
    }

    static final class a extends q implements kotlin.g.a.a<aj> {
        final /* synthetic */ b TpS;
        final /* synthetic */ h TpT;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(b bVar, h hVar) {
            super(0);
            this.TpS = bVar;
            this.TpT = hVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ aj invoke() {
            AppMethodBeat.i(57653);
            e a2 = this.TpT.Trv.Tfp.hBh().a(this.TpS.TiI);
            p.g(a2, "c.module.builtIns.getBuiltInClassByFqName(fqName)");
            aj hAG = a2.hAG();
            AppMethodBeat.o(57653);
            return hAG;
        }
    }
}
