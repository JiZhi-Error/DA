package kotlin.l.b.a.b.k.a.b;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.a.j;
import kotlin.a.x;
import kotlin.g.b.p;
import kotlin.l.b.a.b.b.ab;
import kotlin.l.b.a.b.b.h;
import kotlin.l.b.a.b.b.l;
import kotlin.l.b.a.b.c.a.c;
import kotlin.l.b.a.b.f.a;
import kotlin.l.b.a.b.f.b;
import kotlin.l.b.a.b.f.f;
import kotlin.l.b.a.b.j.f.d;

public final class i extends h {
    private final ab TMD;
    private final b TfF = this.TMD.hBk();

    @Override // kotlin.l.b.a.b.j.f.j, kotlin.l.b.a.b.j.f.i
    public final /* synthetic */ Collection a(d dVar, kotlin.g.a.b bVar) {
        AppMethodBeat.i(60467);
        p.h(dVar, "kindFilter");
        p.h(bVar, "nameFilter");
        Collection<l> a2 = a(dVar, bVar, c.WHEN_GET_ALL_DESCRIPTORS);
        Iterable<kotlin.l.b.a.b.b.b.b> iterable = this.TLm.Tvt.TKS;
        ArrayList arrayList = new ArrayList();
        for (kotlin.l.b.a.b.b.b.b bVar2 : iterable) {
            j.a((Collection) arrayList, (Iterable) bVar2.b(this.TfF));
        }
        List b2 = j.b((Collection) a2, (Iterable) arrayList);
        AppMethodBeat.o(60467);
        return b2;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public i(kotlin.l.b.a.b.b.ab r9, kotlin.l.b.a.b.e.a.k r10, kotlin.l.b.a.b.e.b.c r11, kotlin.l.b.a.b.e.b.a r12, kotlin.l.b.a.b.k.a.b.f r13, kotlin.l.b.a.b.k.a.l r14, kotlin.g.a.a<? extends java.util.Collection<kotlin.l.b.a.b.f.f>> r15) {
        /*
        // Method dump skipped, instructions count: 127
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.l.b.a.b.k.a.b.i.<init>(kotlin.l.b.a.b.b.ab, kotlin.l.b.a.b.e.a$k, kotlin.l.b.a.b.e.b.c, kotlin.l.b.a.b.e.b.a, kotlin.l.b.a.b.k.a.b.f, kotlin.l.b.a.b.k.a.l, kotlin.g.a.a):void");
    }

    /* access modifiers changed from: protected */
    @Override // kotlin.l.b.a.b.k.a.b.h
    public final boolean C(f fVar) {
        boolean z;
        AppMethodBeat.i(60468);
        p.h(fVar, "name");
        if (!super.C(fVar)) {
            Iterable<kotlin.l.b.a.b.b.b.b> iterable = this.TLm.Tvt.TKS;
            if (!(iterable instanceof Collection) || !((Collection) iterable).isEmpty()) {
                Iterator<kotlin.l.b.a.b.b.b.b> it = iterable.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (it.next().a(this.TfF, fVar)) {
                            z = true;
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
            z = false;
            if (!z) {
                AppMethodBeat.o(60468);
                return false;
            }
        }
        AppMethodBeat.o(60468);
        return true;
    }

    /* access modifiers changed from: protected */
    @Override // kotlin.l.b.a.b.k.a.b.h
    public final a z(f fVar) {
        AppMethodBeat.i(60469);
        p.h(fVar, "name");
        a aVar = new a(this.TfF, fVar);
        AppMethodBeat.o(60469);
        return aVar;
    }

    @Override // kotlin.l.b.a.b.k.a.b.h, kotlin.l.b.a.b.j.f.j, kotlin.l.b.a.b.j.f.i
    public final h c(f fVar, kotlin.l.b.a.b.c.a.a aVar) {
        AppMethodBeat.i(60470);
        p.h(fVar, "name");
        p.h(aVar, FirebaseAnalytics.b.LOCATION);
        d(fVar, aVar);
        h c2 = super.c(fVar, aVar);
        AppMethodBeat.o(60470);
        return c2;
    }

    /* access modifiers changed from: protected */
    @Override // kotlin.l.b.a.b.k.a.b.h
    public final void c(Collection<l> collection, kotlin.g.a.b<? super f, Boolean> bVar) {
        AppMethodBeat.i(60472);
        p.h(collection, "result");
        p.h(bVar, "nameFilter");
        AppMethodBeat.o(60472);
    }

    @Override // kotlin.l.b.a.b.j.f.i
    public final void d(f fVar, kotlin.l.b.a.b.c.a.a aVar) {
        AppMethodBeat.i(60471);
        p.h(fVar, "name");
        p.h(aVar, FirebaseAnalytics.b.LOCATION);
        kotlin.l.b.a.b.c.a.a(this.TLm.Tvt.Trb, aVar, this.TMD, fVar);
        AppMethodBeat.o(60471);
    }

    /* access modifiers changed from: protected */
    @Override // kotlin.l.b.a.b.k.a.b.h
    public final Set<f> hLm() {
        return x.SXt;
    }

    /* access modifiers changed from: protected */
    @Override // kotlin.l.b.a.b.k.a.b.h
    public final Set<f> hLn() {
        return x.SXt;
    }
}
