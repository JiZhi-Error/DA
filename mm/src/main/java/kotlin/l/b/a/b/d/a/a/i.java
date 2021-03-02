package kotlin.l.b.a.b.d.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;
import kotlin.a.ae;
import kotlin.a.j;
import kotlin.g.b.aa;
import kotlin.g.b.q;
import kotlin.g.b.y;
import kotlin.l.b.a.b.d.a.e.b;
import kotlin.l.b.a.b.d.a.e.e;
import kotlin.l.b.a.b.d.a.e.m;
import kotlin.l.b.a.b.j.b.g;
import kotlin.l.b.a.b.l.f;
import kotlin.l.k;
import kotlin.s;

public final class i extends b {
    static final /* synthetic */ k[] cLI = {aa.a(new y(aa.bp(i.class), "allValueArguments", "getAllValueArguments()Ljava/util/Map;"))};
    private final f Tqj;

    static {
        AppMethodBeat.i(57684);
        AppMethodBeat.o(57684);
    }

    @Override // kotlin.l.b.a.b.b.a.c, kotlin.l.b.a.b.d.a.a.b
    public final Map<kotlin.l.b.a.b.f.f, g<?>> hBO() {
        AppMethodBeat.i(57685);
        Map<kotlin.l.b.a.b.f.f, g<?>> map = (Map) kotlin.l.b.a.b.l.i.a(this.Tqj, cLI[0]);
        AppMethodBeat.o(57685);
        return map;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public i(kotlin.l.b.a.b.d.a.e.a r4, kotlin.l.b.a.b.d.a.c.h r5) {
        /*
            r3 = this;
            r2 = 57686(0xe156, float:8.0835E-41)
            java.lang.String r0 = "annotation"
            kotlin.g.b.p.h(r4, r0)
            java.lang.String r0 = "c"
            kotlin.g.b.p.h(r5, r0)
            kotlin.l.b.a.b.a.g$a r0 = kotlin.l.b.a.b.a.g.TcO
            kotlin.l.b.a.b.f.b r0 = r0.Tdv
            java.lang.String r1 = "KotlinBuiltIns.FQ_NAMES.target"
            kotlin.g.b.p.g(r0, r1)
            r3.<init>(r5, r4, r0)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
            kotlin.l.b.a.b.d.a.c.b r0 = r5.Trv
            kotlin.l.b.a.b.l.j r1 = r0.TcN
            kotlin.l.b.a.b.d.a.a.i$a r0 = new kotlin.l.b.a.b.d.a.a.i$a
            r0.<init>(r3)
            kotlin.g.a.a r0 = (kotlin.g.a.a) r0
            kotlin.l.b.a.b.l.f r0 = r1.al(r0)
            r3.Tqj = r0
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.l.b.a.b.d.a.a.i.<init>(kotlin.l.b.a.b.d.a.e.a, kotlin.l.b.a.b.d.a.c.h):void");
    }

    static final class a extends q implements kotlin.g.a.a<Map<kotlin.l.b.a.b.f.f, ? extends g<?>>> {
        final /* synthetic */ i Tqo;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(i iVar) {
            super(0);
            this.Tqo = iVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Map<kotlin.l.b.a.b.f.f, ? extends g<?>> invoke() {
            g<?> gVar;
            Map map;
            AppMethodBeat.i(57683);
            b bVar = this.Tqo.TpQ;
            if (bVar instanceof e) {
                d dVar = d.Tqh;
                gVar = d.kE(((e) this.Tqo.TpQ).hCH());
            } else if (bVar instanceof m) {
                d dVar2 = d.Tqh;
                gVar = d.kE(j.listOf(this.Tqo.TpQ));
            } else {
                gVar = null;
            }
            if (gVar != null) {
                c cVar = c.Tqe;
                map = ae.b(s.U(c.hDH(), gVar));
            } else {
                map = null;
            }
            if (map == null) {
                map = ae.emptyMap();
            }
            AppMethodBeat.o(57683);
            return map;
        }
    }
}
