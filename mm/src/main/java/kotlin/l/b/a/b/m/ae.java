package kotlin.l.b.a.b.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l.b.a.b.l.f;
import kotlin.l.b.a.b.l.j;
import kotlin.l.b.a.b.m.a.i;

public final class ae extends bi {
    final kotlin.g.a.a<ab> TMV;
    private final f<ab> TOp = this.TcN.al(this.TMV);
    private final j TcN;

    @Override // kotlin.l.b.a.b.m.ab
    public final /* synthetic */ ab d(i iVar) {
        AppMethodBeat.i(60777);
        p.h(iVar, "kotlinTypeRefiner");
        ae aeVar = new ae(this.TcN, new a(this, iVar));
        AppMethodBeat.o(60777);
        return aeVar;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: kotlin.g.a.a<? extends kotlin.l.b.a.b.m.ab> */
    /* JADX WARN: Multi-variable type inference failed */
    public ae(j jVar, kotlin.g.a.a<? extends ab> aVar) {
        p.h(jVar, "storageManager");
        p.h(aVar, "computation");
        AppMethodBeat.i(60778);
        this.TcN = jVar;
        this.TMV = aVar;
        AppMethodBeat.o(60778);
    }

    /* access modifiers changed from: protected */
    @Override // kotlin.l.b.a.b.m.bi
    public final ab hLG() {
        AppMethodBeat.i(60775);
        ab abVar = (ab) this.TOp.invoke();
        AppMethodBeat.o(60775);
        return abVar;
    }

    @Override // kotlin.l.b.a.b.m.bi
    public final boolean hLt() {
        AppMethodBeat.i(60776);
        boolean hLt = this.TOp.hLt();
        AppMethodBeat.o(60776);
        return hLt;
    }

    static final class a extends q implements kotlin.g.a.a<ab> {
        final /* synthetic */ ae TOq;
        final /* synthetic */ i TOr;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(ae aeVar, i iVar) {
            super(0);
            this.TOq = aeVar;
            this.TOr = iVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ ab invoke() {
            AppMethodBeat.i(60774);
            ab aK = this.TOr.aK(this.TOq.TMV.invoke());
            AppMethodBeat.o(60774);
            return aK;
        }
    }
}
