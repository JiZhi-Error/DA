package kotlin.l.b.a.b.k.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l.b.a.b.b.an;
import kotlin.l.b.a.b.b.y;
import kotlin.l.b.a.b.e.a;
import kotlin.l.b.a.b.e.b.d;
import kotlin.l.b.a.b.j.f.h;
import kotlin.l.b.a.b.k.a.b.f;
import kotlin.l.b.a.b.k.a.b.i;
import kotlin.l.b.a.b.l.j;

public abstract class q extends p {
    private final kotlin.l.b.a.b.e.b.a TKB;
    private final f TLb = null;
    private final d TLc;
    final y TLd;
    private a.l TLe;
    private h TLf;

    static final class a extends kotlin.g.b.q implements kotlin.g.a.b<kotlin.l.b.a.b.f.a, an> {
        final /* synthetic */ q TLg;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(q qVar) {
            super(1);
            this.TLg = qVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ an invoke(kotlin.l.b.a.b.f.a aVar) {
            AppMethodBeat.i(60312);
            p.h(aVar, LocaleUtil.ITALIAN);
            f fVar = this.TLg.TLb;
            if (fVar != null) {
                f fVar2 = fVar;
                AppMethodBeat.o(60312);
                return fVar2;
            }
            an anVar = an.ThK;
            p.g(anVar, "SourceElement.NO_SOURCE");
            AppMethodBeat.o(60312);
            return anVar;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public q(kotlin.l.b.a.b.f.b bVar, j jVar, y yVar, a.l lVar, kotlin.l.b.a.b.e.b.a aVar) {
        super(bVar, jVar, yVar);
        p.h(bVar, "fqName");
        p.h(jVar, "storageManager");
        p.h(yVar, "module");
        p.h(lVar, "proto");
        p.h(aVar, "metadataVersion");
        this.TKB = aVar;
        a.o oVar = lVar.TyP;
        p.g(oVar, "proto.strings");
        a.n nVar = lVar.TyQ;
        p.g(nVar, "proto.qualifiedNames");
        this.TLc = new d(oVar, nVar);
        this.TLd = new y(lVar, this.TLc, this.TKB, new a(this));
        this.TLe = lVar;
    }

    @Override // kotlin.l.b.a.b.k.a.p
    public final void b(l lVar) {
        p.h(lVar, "components");
        a.l lVar2 = this.TLe;
        if (lVar2 == null) {
            throw new IllegalStateException("Repeated call to DeserializedPackageFragmentImpl::initialize".toString());
        }
        this.TLe = null;
        a.k kVar = lVar2.TyR;
        p.g(kVar, "proto.`package`");
        this.TLf = new i(this, kVar, this.TLc, this.TKB, this.TLb, lVar, new b(this));
    }

    @Override // kotlin.l.b.a.b.b.ab
    public final h hAp() {
        h hVar = this.TLf;
        if (hVar == null) {
            p.btv("_memberScope");
        }
        return hVar;
    }

    static final class b extends kotlin.g.b.q implements kotlin.g.a.a<List<? extends kotlin.l.b.a.b.f.f>> {
        final /* synthetic */ q TLg;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(q qVar) {
            super(0);
            this.TLg = qVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX WARNING: Removed duplicated region for block: B:19:0x001f A[SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:9:0x0041  */
        @Override // kotlin.g.a.a
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final /* synthetic */ java.util.List<? extends kotlin.l.b.a.b.f.f> invoke() {
            /*
            // Method dump skipped, instructions count: 118
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.l.b.a.b.k.a.q.b.invoke():java.lang.Object");
        }
    }

    @Override // kotlin.l.b.a.b.k.a.p
    public final /* bridge */ /* synthetic */ i hLe() {
        return this.TLd;
    }
}
