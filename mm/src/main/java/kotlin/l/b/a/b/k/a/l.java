package kotlin.l.b.a.b.k.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.a.v;
import kotlin.g.b.p;
import kotlin.l.b.a.b.b.a.c;
import kotlin.l.b.a.b.b.aa;
import kotlin.l.b.a.b.b.ab;
import kotlin.l.b.a.b.b.ac;
import kotlin.l.b.a.b.b.b.a;
import kotlin.l.b.a.b.b.b.b;
import kotlin.l.b.a.b.b.e;
import kotlin.l.b.a.b.b.y;
import kotlin.l.b.a.b.e.b.h;
import kotlin.l.b.a.b.e.b.i;
import kotlin.l.b.a.b.j.b.g;
import kotlin.l.b.a.b.k.a.b.f;
import kotlin.l.b.a.b.l.j;
import kotlin.l.b.a.b.m.a.n;

public final class l {
    public final j TKL = new j(this);
    public final m TKM;
    final i TKN;
    public final c<c, g<?>> TKO;
    final ac TKP;
    private final v TKQ;
    final s TKR;
    public final Iterable<b> TKS;
    final k TKT;
    public final a TKU;
    public final kotlin.l.b.a.b.b.b.c TKV;
    public final kotlin.l.b.a.b.h.g TKW;
    public final j TcN;
    public final aa TeR;
    public final y Tge;
    public final r TqU;
    public final kotlin.l.b.a.b.c.a.b Trb;
    public final n Trh;

    /* JADX DEBUG: Multi-variable search result rejected for r7v0, resolved type: kotlin.l.b.a.b.k.a.c<? extends kotlin.l.b.a.b.b.a.c, ? extends kotlin.l.b.a.b.j.b.g<?>> */
    /* JADX DEBUG: Multi-variable search result rejected for r13v0, resolved type: java.lang.Iterable<? extends kotlin.l.b.a.b.b.b.b> */
    /* JADX WARN: Multi-variable type inference failed */
    public l(j jVar, y yVar, m mVar, i iVar, c<? extends c, ? extends g<?>> cVar, ac acVar, v vVar, r rVar, kotlin.l.b.a.b.c.a.b bVar, s sVar, Iterable<? extends b> iterable, aa aaVar, k kVar, a aVar, kotlin.l.b.a.b.b.b.c cVar2, kotlin.l.b.a.b.h.g gVar, n nVar) {
        p.h(jVar, "storageManager");
        p.h(yVar, "moduleDescriptor");
        p.h(mVar, "configuration");
        p.h(iVar, "classDataFinder");
        p.h(cVar, "annotationAndConstantLoader");
        p.h(acVar, "packageFragmentProvider");
        p.h(vVar, "localClassifierTypeSettings");
        p.h(rVar, "errorReporter");
        p.h(bVar, "lookupTracker");
        p.h(sVar, "flexibleTypeDeserializer");
        p.h(iterable, "fictitiousClassDescriptorFactories");
        p.h(aaVar, "notFoundClasses");
        p.h(kVar, "contractDeserializer");
        p.h(aVar, "additionalClassPartsProvider");
        p.h(cVar2, "platformDependentDeclarationFilter");
        p.h(gVar, "extensionRegistryLite");
        p.h(nVar, "kotlinTypeChecker");
        AppMethodBeat.i(60305);
        this.TcN = jVar;
        this.Tge = yVar;
        this.TKM = mVar;
        this.TKN = iVar;
        this.TKO = cVar;
        this.TKP = acVar;
        this.TKQ = vVar;
        this.TqU = rVar;
        this.Trb = bVar;
        this.TKR = sVar;
        this.TKS = iterable;
        this.TeR = aaVar;
        this.TKT = kVar;
        this.TKU = aVar;
        this.TKV = cVar2;
        this.TKW = gVar;
        this.Trh = nVar;
        AppMethodBeat.o(60305);
    }

    public final e g(kotlin.l.b.a.b.f.a aVar) {
        AppMethodBeat.i(60303);
        p.h(aVar, "classId");
        e a2 = j.a(this.TKL, aVar);
        AppMethodBeat.o(60303);
        return a2;
    }

    public final n a(ab abVar, kotlin.l.b.a.b.e.b.c cVar, h hVar, i iVar, kotlin.l.b.a.b.e.b.a aVar, f fVar) {
        AppMethodBeat.i(60304);
        p.h(abVar, "descriptor");
        p.h(cVar, "nameResolver");
        p.h(hVar, "typeTable");
        p.h(iVar, "versionRequirementTable");
        p.h(aVar, "metadataVersion");
        n nVar = new n(this, cVar, abVar, hVar, iVar, aVar, fVar, null, v.SXr);
        AppMethodBeat.o(60304);
        return nVar;
    }
}
