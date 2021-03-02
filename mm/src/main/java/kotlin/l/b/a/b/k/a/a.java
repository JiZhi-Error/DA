package kotlin.l.b.a.b.k.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.List;
import kotlin.a.x;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l.b.a.b.b.ab;
import kotlin.l.b.a.b.b.ac;
import kotlin.l.b.a.b.b.y;
import kotlin.l.b.a.b.f.b;
import kotlin.l.b.a.b.f.f;
import kotlin.l.b.a.b.l.d;
import kotlin.l.b.a.b.l.j;

public abstract class a implements ac {
    private final d<b, ab> TKq = this.TcN.V(new C2350a(this));
    protected final u TKr;
    protected final j TcN;
    protected final y Tge;
    protected l Tvt;

    /* access modifiers changed from: protected */
    public abstract p d(b bVar);

    /* renamed from: kotlin.l.b.a.b.k.a.a$a  reason: collision with other inner class name */
    static final class C2350a extends q implements kotlin.g.a.b<b, p> {
        final /* synthetic */ a TKs;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C2350a(a aVar) {
            super(1);
            this.TKs = aVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ p invoke(b bVar) {
            AppMethodBeat.i(60263);
            b bVar2 = bVar;
            p.h(bVar2, "fqName");
            p d2 = this.TKs.d(bVar2);
            if (d2 != null) {
                d2.b(this.TKs.hEh());
                AppMethodBeat.o(60263);
                return d2;
            }
            AppMethodBeat.o(60263);
            return null;
        }
    }

    public a(j jVar, u uVar, y yVar) {
        p.h(jVar, "storageManager");
        p.h(uVar, "finder");
        p.h(yVar, "moduleDescriptor");
        this.TcN = jVar;
        this.TKr = uVar;
        this.Tge = yVar;
    }

    /* access modifiers changed from: protected */
    public final void a(l lVar) {
        p.h(lVar, "<set-?>");
        this.Tvt = lVar;
    }

    /* access modifiers changed from: protected */
    public final l hEh() {
        l lVar = this.Tvt;
        if (lVar == null) {
            p.btv("components");
        }
        return lVar;
    }

    @Override // kotlin.l.b.a.b.b.ac
    public final List<ab> f(b bVar) {
        p.h(bVar, "fqName");
        return kotlin.a.j.eR(this.TKq.invoke(bVar));
    }

    @Override // kotlin.l.b.a.b.b.ac
    public final Collection<b> a(b bVar, kotlin.g.a.b<? super f, Boolean> bVar2) {
        p.h(bVar, "fqName");
        p.h(bVar2, "nameFilter");
        return x.SXt;
    }
}
