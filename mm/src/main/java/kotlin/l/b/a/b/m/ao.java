package kotlin.l.b.a.b.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.k;
import kotlin.l.b.a.b.b.as;
import kotlin.l.b.a.b.m.a.i;

public final class ao extends aw {
    private final f TOu = g.a(k.PUBLICATION, new a(this));
    final as TOv;

    public ao(as asVar) {
        p.h(asVar, "typeParameter");
        AppMethodBeat.i(60814);
        this.TOv = asVar;
        AppMethodBeat.o(60814);
    }

    @Override // kotlin.l.b.a.b.m.av
    public final boolean hLH() {
        return true;
    }

    @Override // kotlin.l.b.a.b.m.av
    public final bh hLI() {
        return bh.OUT_VARIANCE;
    }

    @Override // kotlin.l.b.a.b.m.av
    public final av m(i iVar) {
        AppMethodBeat.i(60813);
        p.h(iVar, "kotlinTypeRefiner");
        ao aoVar = this;
        AppMethodBeat.o(60813);
        return aoVar;
    }

    @Override // kotlin.l.b.a.b.m.av
    public final ab hBy() {
        AppMethodBeat.i(60812);
        ab abVar = (ab) this.TOu.getValue();
        AppMethodBeat.o(60812);
        return abVar;
    }

    static final class a extends q implements kotlin.g.a.a<ab> {
        final /* synthetic */ ao TOw;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(ao aoVar) {
            super(0);
            this.TOw = aoVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ ab invoke() {
            AppMethodBeat.i(60810);
            ab c2 = ap.c(this.TOw.TOv);
            AppMethodBeat.o(60810);
            return c2;
        }
    }
}
