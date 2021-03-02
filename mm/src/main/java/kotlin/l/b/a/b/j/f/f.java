package kotlin.l.b.a.b.j.f;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.a.v;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.l.b.a.b.b.ar;
import kotlin.l.b.a.b.b.e;
import kotlin.l.b.a.b.b.h;
import kotlin.l.b.a.b.b.i;
import kotlin.l.b.a.b.c.a.a;
import kotlin.l.b.a.b.j.f.d;

public final class f extends i {
    private final h TJU;

    public f(h hVar) {
        p.h(hVar, "workerScope");
        AppMethodBeat.i(60210);
        this.TJU = hVar;
        AppMethodBeat.o(60210);
    }

    @Override // kotlin.l.b.a.b.j.f.j, kotlin.l.b.a.b.j.f.i
    public final /* synthetic */ Collection a(d dVar, b bVar) {
        d dVar2;
        v vVar;
        AppMethodBeat.i(60206);
        p.h(dVar, "kindFilter");
        p.h(bVar, "nameFilter");
        d.a aVar = d.TJQ;
        int hKW = dVar.TJr & d.hKW();
        if (hKW == 0) {
            dVar2 = null;
        } else {
            dVar2 = new d(hKW, dVar.TJs);
        }
        if (dVar2 == null) {
            vVar = v.SXr;
        } else {
            ArrayList arrayList = new ArrayList();
            for (T t : this.TJU.a(dVar2, bVar)) {
                if (t instanceof i) {
                    arrayList.add(t);
                }
            }
            vVar = arrayList;
        }
        List list = vVar;
        AppMethodBeat.o(60206);
        return list;
    }

    @Override // kotlin.l.b.a.b.j.f.j, kotlin.l.b.a.b.j.f.i
    public final h c(kotlin.l.b.a.b.f.f fVar, a aVar) {
        h hVar;
        h hVar2;
        AppMethodBeat.i(60205);
        p.h(fVar, "name");
        p.h(aVar, FirebaseAnalytics.b.LOCATION);
        h c2 = this.TJU.c(fVar, aVar);
        if (c2 != null) {
            if (!(c2 instanceof e)) {
                hVar = null;
            } else {
                hVar = c2;
            }
            e eVar = (e) hVar;
            if (eVar != null) {
                e eVar2 = eVar;
                AppMethodBeat.o(60205);
                return eVar2;
            }
            if (!(c2 instanceof ar)) {
                hVar2 = null;
            } else {
                hVar2 = c2;
            }
            ar arVar = (ar) hVar2;
            AppMethodBeat.o(60205);
            return arVar;
        }
        AppMethodBeat.o(60205);
        return null;
    }

    @Override // kotlin.l.b.a.b.j.f.h, kotlin.l.b.a.b.j.f.i
    public final Set<kotlin.l.b.a.b.f.f> hCa() {
        AppMethodBeat.i(60207);
        Set<kotlin.l.b.a.b.f.f> hCa = this.TJU.hCa();
        AppMethodBeat.o(60207);
        return hCa;
    }

    @Override // kotlin.l.b.a.b.j.f.h, kotlin.l.b.a.b.j.f.i
    public final Set<kotlin.l.b.a.b.f.f> hCb() {
        AppMethodBeat.i(60208);
        Set<kotlin.l.b.a.b.f.f> hCb = this.TJU.hCb();
        AppMethodBeat.o(60208);
        return hCb;
    }

    public final String toString() {
        AppMethodBeat.i(60209);
        String str = "Classes from " + this.TJU;
        AppMethodBeat.o(60209);
        return str;
    }
}
