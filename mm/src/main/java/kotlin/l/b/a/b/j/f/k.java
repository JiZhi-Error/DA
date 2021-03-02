package kotlin.l.b.a.b.j.f;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.g.a.b;
import kotlin.g.b.aa;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.g.b.y;
import kotlin.l.b.a.b.b.am;
import kotlin.l.b.a.b.b.e;
import kotlin.l.b.a.b.b.h;
import kotlin.l.b.a.b.l.f;
import kotlin.l.b.a.b.l.i;
import kotlin.l.b.a.b.l.j;

public final class k extends i {
    static final /* synthetic */ kotlin.l.k[] cLI = {aa.a(new y(aa.bp(k.class), "functions", "getFunctions()Ljava/util/List;"))};
    private final e TJS;
    private final f TKb;

    static {
        AppMethodBeat.i(60219);
        AppMethodBeat.o(60219);
    }

    private final List<am> hLa() {
        AppMethodBeat.i(60221);
        List<am> list = (List) i.a(this.TKb, cLI[0]);
        AppMethodBeat.o(60221);
        return list;
    }

    @Override // kotlin.l.b.a.b.j.f.j, kotlin.l.b.a.b.j.f.i
    public final /* synthetic */ Collection a(d dVar, b bVar) {
        AppMethodBeat.i(60222);
        p.h(dVar, "kindFilter");
        p.h(bVar, "nameFilter");
        List<am> hLa = hLa();
        AppMethodBeat.o(60222);
        return hLa;
    }

    @Override // kotlin.l.b.a.b.j.f.j, kotlin.l.b.a.b.j.f.h, kotlin.l.b.a.b.j.f.i
    public final /* synthetic */ Collection b(kotlin.l.b.a.b.f.f fVar, kotlin.l.b.a.b.c.a.a aVar) {
        AppMethodBeat.i(60223);
        p.h(fVar, "name");
        p.h(aVar, FirebaseAnalytics.b.LOCATION);
        ArrayList arrayList = new ArrayList(1);
        for (T t : hLa()) {
            if (p.j(t.hAH(), fVar)) {
                arrayList.add(t);
            }
        }
        ArrayList arrayList2 = arrayList;
        AppMethodBeat.o(60223);
        return arrayList2;
    }

    @Override // kotlin.l.b.a.b.j.f.j, kotlin.l.b.a.b.j.f.i
    public final /* synthetic */ h c(kotlin.l.b.a.b.f.f fVar, kotlin.l.b.a.b.c.a.a aVar) {
        AppMethodBeat.i(60220);
        p.h(fVar, "name");
        p.h(aVar, FirebaseAnalytics.b.LOCATION);
        AppMethodBeat.o(60220);
        return null;
    }

    public k(j jVar, e eVar) {
        p.h(jVar, "storageManager");
        p.h(eVar, "containingClass");
        AppMethodBeat.i(60224);
        this.TJS = eVar;
        boolean z = this.TJS.hzB() == kotlin.l.b.a.b.b.f.ENUM_CLASS;
        if (!kotlin.aa.SXc || z) {
            this.TKb = jVar.al(new a(this));
            AppMethodBeat.o(60224);
            return;
        }
        AssertionError assertionError = new AssertionError("Class should be an enum: " + this.TJS);
        AppMethodBeat.o(60224);
        throw assertionError;
    }

    static final class a extends q implements kotlin.g.a.a<List<? extends am>> {
        final /* synthetic */ k TKc;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(k kVar) {
            super(0);
            this.TKc = kVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ List<? extends am> invoke() {
            AppMethodBeat.i(60218);
            List listOf = kotlin.a.j.listOf((Object[]) new am[]{kotlin.l.b.a.b.j.b.x(this.TKc.TJS), kotlin.l.b.a.b.j.b.w(this.TKc.TJS)});
            AppMethodBeat.o(60218);
            return listOf;
        }
    }
}
