package kotlin.l.b.a.b.d.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l.b.a.b.b.as;
import kotlin.l.b.a.b.b.l;
import kotlin.l.b.a.b.d.a.c.a.n;
import kotlin.l.b.a.b.d.a.e.w;
import kotlin.l.b.a.b.d.a.e.x;
import kotlin.l.b.a.b.l.d;

public final class i implements m {
    final l Tko;
    final int TrA;
    final h Trn;
    final Map<w, Integer> Try;
    private final d<w, n> Trz = this.Trn.Trv.TcN.V(new a(this));

    static final class a extends q implements b<w, n> {
        final /* synthetic */ i TrB;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(i iVar) {
            super(1);
            this.TrB = iVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ n invoke(w wVar) {
            AppMethodBeat.i(57762);
            w wVar2 = wVar;
            p.h(wVar2, "typeParameter");
            Integer num = this.TrB.Try.get(wVar2);
            if (num != null) {
                int intValue = num.intValue();
                h hVar = this.TrB.Trn;
                i iVar = this.TrB;
                p.h(hVar, "$this$child");
                p.h(iVar, "typeParameterResolver");
                n nVar = new n(new h(hVar.Trv, iVar, hVar.Trx), wVar2, this.TrB.TrA + intValue, this.TrB.Tko);
                AppMethodBeat.o(57762);
                return nVar;
            }
            AppMethodBeat.o(57762);
            return null;
        }
    }

    public i(h hVar, l lVar, x xVar, int i2) {
        p.h(hVar, "c");
        p.h(lVar, "containingDeclaration");
        p.h(xVar, "typeParameterOwner");
        AppMethodBeat.i(57764);
        this.Trn = hVar;
        this.Tko = lVar;
        this.TrA = i2;
        this.Try = kotlin.l.b.a.b.o.a.G(xVar.hAt());
        AppMethodBeat.o(57764);
    }

    @Override // kotlin.l.b.a.b.d.a.c.m
    public final as a(w wVar) {
        AppMethodBeat.i(57763);
        p.h(wVar, "javaTypeParameter");
        n invoke = this.Trz.invoke(wVar);
        if (invoke != null) {
            n nVar = invoke;
            AppMethodBeat.o(57763);
            return nVar;
        }
        as a2 = this.Trn.Trw.a(wVar);
        AppMethodBeat.o(57763);
        return a2;
    }
}
