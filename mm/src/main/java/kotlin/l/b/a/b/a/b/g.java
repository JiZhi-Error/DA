package kotlin.l.b.a.b.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;
import kotlin.g.b.p;
import kotlin.l.b.a.b.b.aa;
import kotlin.l.b.a.b.b.b.b;
import kotlin.l.b.a.b.b.b.c;
import kotlin.l.b.a.b.b.y;
import kotlin.l.b.a.b.c.a.b;
import kotlin.l.b.a.b.d.b.n;
import kotlin.l.b.a.b.k.a.a;
import kotlin.l.b.a.b.k.a.a.b;
import kotlin.l.b.a.b.k.a.d;
import kotlin.l.b.a.b.k.a.k;
import kotlin.l.b.a.b.k.a.l;
import kotlin.l.b.a.b.k.a.m;
import kotlin.l.b.a.b.k.a.o;
import kotlin.l.b.a.b.k.a.r;
import kotlin.l.b.a.b.k.a.s;
import kotlin.l.b.a.b.k.a.v;
import kotlin.l.b.a.b.l.j;

public final class g extends a {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public g(j jVar, n nVar, y yVar, aa aaVar, kotlin.l.b.a.b.b.b.a aVar, c cVar, m mVar, kotlin.l.b.a.b.m.a.n nVar2) {
        super(jVar, nVar, yVar);
        p.h(jVar, "storageManager");
        p.h(nVar, "finder");
        p.h(yVar, "moduleDescriptor");
        p.h(aaVar, "notFoundClasses");
        p.h(aVar, "additionalClassPartsProvider");
        p.h(cVar, "platformDependentDeclarationFilter");
        p.h(mVar, "deserializationConfiguration");
        p.h(nVar2, "kotlinTypeChecker");
        AppMethodBeat.i(56792);
        r rVar = r.TLh;
        p.g(rVar, "ErrorReporter.DO_NOTHING");
        b[] bVarArr = {new kotlin.l.b.a.b.a.a.a(jVar, yVar), new d(jVar, yVar)};
        k.a aVar2 = k.TKI;
        a(new l(jVar, yVar, mVar, new o(this), new d(yVar, aaVar, kotlin.l.b.a.b.k.a.a.a.TLQ), this, v.a.TLl, rVar, b.a.TnB, s.a.TLi, kotlin.a.j.listOf((Object[]) bVarArr), aaVar, k.a.hLd(), aVar, cVar, kotlin.l.b.a.b.k.a.a.a.TLQ.TDN, nVar2));
        AppMethodBeat.o(56792);
    }

    @Override // kotlin.l.b.a.b.k.a.a
    public final kotlin.l.b.a.b.k.a.p d(kotlin.l.b.a.b.f.b bVar) {
        kotlin.l.b.a.b.k.a.a.b bVar2;
        AppMethodBeat.i(56791);
        p.h(bVar, "fqName");
        InputStream k = this.TKr.k(bVar);
        if (k != null) {
            b.a aVar = kotlin.l.b.a.b.k.a.a.b.TLS;
            bVar2 = b.a.a(bVar, this.TcN, this.Tge, k);
        } else {
            bVar2 = null;
        }
        kotlin.l.b.a.b.k.a.a.b bVar3 = bVar2;
        AppMethodBeat.o(56791);
        return bVar3;
    }
}
