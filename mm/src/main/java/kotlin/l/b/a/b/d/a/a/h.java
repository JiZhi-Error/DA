package kotlin.l.b.a.b.d.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;
import kotlin.a.ae;
import kotlin.g.b.aa;
import kotlin.g.b.q;
import kotlin.g.b.y;
import kotlin.l.b.a.b.j.b.g;
import kotlin.l.b.a.b.l.f;
import kotlin.l.b.a.b.l.i;
import kotlin.l.k;
import kotlin.s;

public final class h extends b {
    static final /* synthetic */ k[] cLI = {aa.a(new y(aa.bp(h.class), "allValueArguments", "getAllValueArguments()Ljava/util/Map;"))};
    private final f Tqj;

    static {
        AppMethodBeat.i(57680);
        AppMethodBeat.o(57680);
    }

    @Override // kotlin.l.b.a.b.b.a.c, kotlin.l.b.a.b.d.a.a.b
    public final Map<kotlin.l.b.a.b.f.f, g<?>> hBO() {
        AppMethodBeat.i(57681);
        Map<kotlin.l.b.a.b.f.f, g<?>> map = (Map) i.a(this.Tqj, cLI[0]);
        AppMethodBeat.o(57681);
        return map;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public h(kotlin.l.b.a.b.d.a.e.a r4, kotlin.l.b.a.b.d.a.c.h r5) {
        /*
            r3 = this;
            r2 = 57682(0xe152, float:8.083E-41)
            java.lang.String r0 = "annotation"
            kotlin.g.b.p.h(r4, r0)
            java.lang.String r0 = "c"
            kotlin.g.b.p.h(r5, r0)
            kotlin.l.b.a.b.a.g$a r0 = kotlin.l.b.a.b.a.g.TcO
            kotlin.l.b.a.b.f.b r0 = r0.Tdy
            java.lang.String r1 = "KotlinBuiltIns.FQ_NAMES.retention"
            kotlin.g.b.p.g(r0, r1)
            r3.<init>(r5, r4, r0)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
            kotlin.l.b.a.b.d.a.c.b r0 = r5.Trv
            kotlin.l.b.a.b.l.j r1 = r0.TcN
            kotlin.l.b.a.b.d.a.a.h$a r0 = new kotlin.l.b.a.b.d.a.a.h$a
            r0.<init>(r3)
            kotlin.g.a.a r0 = (kotlin.g.a.a) r0
            kotlin.l.b.a.b.l.f r0 = r1.al(r0)
            r3.Tqj = r0
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.l.b.a.b.d.a.a.h.<init>(kotlin.l.b.a.b.d.a.e.a, kotlin.l.b.a.b.d.a.c.h):void");
    }

    static final class a extends q implements kotlin.g.a.a<Map<kotlin.l.b.a.b.f.f, ? extends g<?>>> {
        final /* synthetic */ h Tqn;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(h hVar) {
            super(0);
            this.Tqn = hVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Map<kotlin.l.b.a.b.f.f, ? extends g<?>> invoke() {
            Map map;
            AppMethodBeat.i(57679);
            d dVar = d.Tqh;
            g<?> a2 = d.a(this.Tqn.TpQ);
            if (a2 != null) {
                c cVar = c.Tqe;
                map = ae.b(s.U(c.hDI(), a2));
            } else {
                map = null;
            }
            if (map == null) {
                map = ae.emptyMap();
            }
            AppMethodBeat.o(57679);
            return map;
        }
    }
}
