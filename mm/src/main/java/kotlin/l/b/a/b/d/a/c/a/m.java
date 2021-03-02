package kotlin.l.b.a.b.d.a.c.a;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Collection;
import java.util.List;
import kotlin.a.v;
import kotlin.g.b.p;
import kotlin.l.b.a.b.b.ah;
import kotlin.l.b.a.b.b.ak;
import kotlin.l.b.a.b.b.as;
import kotlin.l.b.a.b.b.av;
import kotlin.l.b.a.b.d.a.c.a.k;
import kotlin.l.b.a.b.d.a.c.h;
import kotlin.l.b.a.b.d.a.e.q;
import kotlin.l.b.a.b.f.f;
import kotlin.l.b.a.b.m.ab;

public abstract class m extends k {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public m(h hVar) {
        super(hVar);
        p.h(hVar, "c");
    }

    /* access modifiers changed from: protected */
    @Override // kotlin.l.b.a.b.d.a.c.a.k
    public final ak hAs() {
        return null;
    }

    /* access modifiers changed from: protected */
    @Override // kotlin.l.b.a.b.d.a.c.a.k
    public final k.a a(q qVar, List<? extends as> list, ab abVar, List<? extends av> list2) {
        p.h(qVar, FirebaseAnalytics.b.METHOD);
        p.h(list, "methodTypeParameters");
        p.h(abVar, "returnType");
        p.h(list2, "valueParameters");
        return new k.a(abVar, null, list2, list, false, v.SXr);
    }

    /* access modifiers changed from: protected */
    @Override // kotlin.l.b.a.b.d.a.c.a.k
    public void b(f fVar, Collection<ah> collection) {
        p.h(fVar, "name");
        p.h(collection, "result");
    }
}
