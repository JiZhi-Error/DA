package kotlin.l.b.a.b.d.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l.b.a.b.b.ao;
import kotlin.l.b.a.b.e.a;
import kotlin.l.b.a.b.h.i;
import kotlin.l.b.a.b.j.e.c;
import kotlin.l.b.a.b.k.a.b.f;
import kotlin.l.b.a.b.k.a.t;
import kotlin.n.n;

public final class j implements f {
    private final c TvF;
    public final c TvG;
    private final t<kotlin.l.b.a.b.e.c.a.f> TvH;
    private final boolean TvI;
    final p TvJ;
    private final String cBp;

    private j(c cVar, c cVar2, a.k kVar, kotlin.l.b.a.b.e.b.c cVar3, t<kotlin.l.b.a.b.e.c.a.f> tVar, boolean z, p pVar) {
        String str;
        p.h(cVar, "className");
        p.h(kVar, "packageProto");
        p.h(cVar3, "nameResolver");
        AppMethodBeat.i(58204);
        this.TvF = cVar;
        this.TvG = cVar2;
        this.TvH = tVar;
        this.TvI = z;
        this.TvJ = pVar;
        i.f<a.k, Integer> fVar = kotlin.l.b.a.b.e.c.a.TBU;
        p.g(fVar, "JvmProtoBuf.packageModuleName");
        Integer num = (Integer) kotlin.l.b.a.b.e.b.f.a(kVar, fVar);
        this.cBp = (num == null || (str = cVar3.getString(num.intValue())) == null) ? "main" : str;
        AppMethodBeat.o(58204);
    }

    public j(p pVar, a.k kVar, kotlin.l.b.a.b.e.b.c cVar, t<kotlin.l.b.a.b.e.c.a.f> tVar, boolean z) {
        c cVar2;
        j jVar;
        c cVar3 = null;
        p.h(pVar, "kotlinClass");
        p.h(kVar, "packageProto");
        p.h(cVar, "nameResolver");
        c e2 = c.e(pVar.hyy());
        p.g(e2, "JvmClassName.byClassId(kotlinClass.classId)");
        String hEp = pVar.hCA().hEp();
        if (hEp != null) {
            cVar3 = hEp.length() > 0 ? c.buj(hEp) : cVar3;
            cVar2 = e2;
            jVar = this;
        } else {
            cVar2 = e2;
            jVar = this;
        }
        new j(cVar2, cVar3, kVar, cVar, tVar, z, pVar);
        AppMethodBeat.o(58205);
    }

    @Override // kotlin.l.b.a.b.k.a.b.f
    public final String hEl() {
        AppMethodBeat.i(58199);
        String str = "Class '" + hyy().hJd().sG() + '\'';
        AppMethodBeat.o(58199);
        return str;
    }

    public final kotlin.l.b.a.b.f.f hEm() {
        AppMethodBeat.i(58200);
        String hKI = this.TvF.hKI();
        p.g(hKI, "className.internalName");
        kotlin.l.b.a.b.f.f btY = kotlin.l.b.a.b.f.f.btY(n.b(hKI, '/'));
        p.g(btY, "Name.identifier(classNam….substringAfterLast('/'))");
        AppMethodBeat.o(58200);
        return btY;
    }

    public final kotlin.l.b.a.b.f.a hyy() {
        AppMethodBeat.i(58201);
        kotlin.l.b.a.b.f.a aVar = new kotlin.l.b.a.b.f.a(this.TvF.hIY(), hEm());
        AppMethodBeat.o(58201);
        return aVar;
    }

    public final String toString() {
        AppMethodBeat.i(58202);
        String str = getClass().getSimpleName() + ": " + this.TvF;
        AppMethodBeat.o(58202);
        return str;
    }

    @Override // kotlin.l.b.a.b.b.an
    public final ao hBu() {
        AppMethodBeat.i(58203);
        ao aoVar = ao.ThL;
        p.g(aoVar, "SourceFile.NO_SOURCE_FILE");
        AppMethodBeat.o(58203);
        return aoVar;
    }
}
