package kotlin.l.b.a.b.j.f;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.a.v;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.l.b.a.b.b.ah;
import kotlin.l.b.a.b.b.am;
import kotlin.l.b.a.b.b.ax;
import kotlin.l.b.a.b.b.h;
import kotlin.l.b.a.b.b.l;
import kotlin.l.b.a.b.c.a.a;
import kotlin.l.b.a.b.f.f;
import kotlin.l.b.a.b.o.d;

public abstract class i implements h {
    @Override // kotlin.l.b.a.b.j.f.j
    public h c(f fVar, a aVar) {
        p.h(fVar, "name");
        p.h(aVar, FirebaseAnalytics.b.LOCATION);
        return null;
    }

    @Override // kotlin.l.b.a.b.j.f.h
    public Set<f> hCa() {
        ArrayList<am> arrayList = new ArrayList();
        for (T t : a(d.TJL, d.hLR())) {
            if (t instanceof am) {
                arrayList.add(t);
            }
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (am amVar : arrayList) {
            linkedHashSet.add(amVar.hAH());
        }
        return linkedHashSet;
    }

    @Override // kotlin.l.b.a.b.j.f.h
    public Set<f> hCb() {
        ArrayList<ax> arrayList = new ArrayList();
        for (T t : a(d.TJM, d.hLR())) {
            if (t instanceof ax) {
                arrayList.add(t);
            }
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (ax axVar : arrayList) {
            linkedHashSet.add(axVar.hAH());
        }
        return linkedHashSet;
    }

    @Override // kotlin.l.b.a.b.j.f.h
    public Collection<? extends ah> a(f fVar, a aVar) {
        p.h(fVar, "name");
        p.h(aVar, FirebaseAnalytics.b.LOCATION);
        return v.SXr;
    }

    @Override // kotlin.l.b.a.b.j.f.j, kotlin.l.b.a.b.j.f.h
    public Collection<? extends am> b(f fVar, a aVar) {
        p.h(fVar, "name");
        p.h(aVar, FirebaseAnalytics.b.LOCATION);
        return v.SXr;
    }

    @Override // kotlin.l.b.a.b.j.f.j
    public Collection<l> a(d dVar, b<? super f, Boolean> bVar) {
        p.h(dVar, "kindFilter");
        p.h(bVar, "nameFilter");
        return v.SXr;
    }

    public void d(f fVar, a aVar) {
        p.h(fVar, "name");
        p.h(aVar, FirebaseAnalytics.b.LOCATION);
        p.h(fVar, "name");
        p.h(aVar, FirebaseAnalytics.b.LOCATION);
        p.h(fVar, "name");
        p.h(aVar, FirebaseAnalytics.b.LOCATION);
        b(fVar, aVar);
    }
}
