package kotlin.l.b.a.b.j.f;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Collection;
import java.util.Set;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.l.b.a.b.b.ah;
import kotlin.l.b.a.b.b.am;
import kotlin.l.b.a.b.b.h;
import kotlin.l.b.a.b.b.l;
import kotlin.l.b.a.b.f.f;

public abstract class a implements h {
    /* access modifiers changed from: protected */
    public abstract h hKM();

    /* JADX DEBUG: Type inference failed for r0v3. Raw type applied. Possible types: java.util.Collection<? extends kotlin.l.b.a.b.b.am>, java.util.Collection<kotlin.l.b.a.b.b.am> */
    @Override // kotlin.l.b.a.b.j.f.j, kotlin.l.b.a.b.j.f.h
    public Collection<am> b(f fVar, kotlin.l.b.a.b.c.a.a aVar) {
        p.h(fVar, "name");
        p.h(aVar, FirebaseAnalytics.b.LOCATION);
        return hKM().b(fVar, aVar);
    }

    @Override // kotlin.l.b.a.b.j.f.j
    public final h c(f fVar, kotlin.l.b.a.b.c.a.a aVar) {
        p.h(fVar, "name");
        p.h(aVar, FirebaseAnalytics.b.LOCATION);
        return hKM().c(fVar, aVar);
    }

    /* JADX DEBUG: Type inference failed for r0v3. Raw type applied. Possible types: java.util.Collection<? extends kotlin.l.b.a.b.b.ah>, java.util.Collection<kotlin.l.b.a.b.b.ah> */
    @Override // kotlin.l.b.a.b.j.f.h
    public Collection<ah> a(f fVar, kotlin.l.b.a.b.c.a.a aVar) {
        p.h(fVar, "name");
        p.h(aVar, FirebaseAnalytics.b.LOCATION);
        return hKM().a(fVar, aVar);
    }

    @Override // kotlin.l.b.a.b.j.f.j
    public Collection<l> a(d dVar, b<? super f, Boolean> bVar) {
        p.h(dVar, "kindFilter");
        p.h(bVar, "nameFilter");
        return hKM().a(dVar, bVar);
    }

    @Override // kotlin.l.b.a.b.j.f.h
    public final Set<f> hCa() {
        return hKM().hCa();
    }

    @Override // kotlin.l.b.a.b.j.f.h
    public final Set<f> hCb() {
        return hKM().hCb();
    }
}
