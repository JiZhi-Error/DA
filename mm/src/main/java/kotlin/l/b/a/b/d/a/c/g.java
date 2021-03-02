package kotlin.l.b.a.b.d.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.List;
import kotlin.a.j;
import kotlin.a.v;
import kotlin.d;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l.b.a.b.b.ac;
import kotlin.l.b.a.b.d.a.c.a.h;
import kotlin.l.b.a.b.d.a.c.m;
import kotlin.l.b.a.b.d.a.e.t;
import kotlin.l.b.a.b.f.b;

public final class g implements ac {
    final h Trn;
    private final kotlin.l.b.a.b.l.a<b, h> Trq = this.Trn.Trv.TcN.hLs();

    public g(b bVar) {
        p.h(bVar, "components");
        AppMethodBeat.i(57758);
        this.Trn = new h(bVar, m.a.TrF, new d(null));
        AppMethodBeat.o(57758);
    }

    @Override // kotlin.l.b.a.b.b.ac
    public final /* synthetic */ Collection a(b bVar, kotlin.g.a.b bVar2) {
        AppMethodBeat.i(57757);
        p.h(bVar, "fqName");
        p.h(bVar2, "nameFilter");
        h o = o(bVar);
        v vVar = o != null ? (List) o.Tst.invoke() : null;
        if (vVar == null) {
            vVar = v.SXr;
        }
        List list = vVar;
        AppMethodBeat.o(57757);
        return list;
    }

    private final h o(b bVar) {
        AppMethodBeat.i(57755);
        h b2 = this.Trq.b(bVar, new a(this, this.Trn.Trv.TqQ.i(bVar)));
        AppMethodBeat.o(57755);
        return b2;
    }

    @Override // kotlin.l.b.a.b.b.ac
    public final List<h> f(b bVar) {
        AppMethodBeat.i(57756);
        p.h(bVar, "fqName");
        List<h> eR = j.eR(o(bVar));
        AppMethodBeat.o(57756);
        return eR;
    }

    /* access modifiers changed from: package-private */
    public static final class a extends q implements kotlin.g.a.a<h> {
        final /* synthetic */ g Trr;
        final /* synthetic */ t Trs;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(g gVar, t tVar) {
            super(0);
            this.Trr = gVar;
            this.Trs = tVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ h invoke() {
            AppMethodBeat.i(57754);
            h hVar = new h(this.Trr.Trn, this.Trs);
            AppMethodBeat.o(57754);
            return hVar;
        }
    }
}
