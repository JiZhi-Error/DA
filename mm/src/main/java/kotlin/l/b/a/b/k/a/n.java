package kotlin.l.b.a.b.k.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l.b.a.b.b.l;
import kotlin.l.b.a.b.e.a;
import kotlin.l.b.a.b.e.b.a;
import kotlin.l.b.a.b.e.b.c;
import kotlin.l.b.a.b.e.b.h;
import kotlin.l.b.a.b.e.b.i;
import kotlin.l.b.a.b.k.a.b.f;

public final class n {
    public final c SZH;
    public final h SZI;
    private final a TKB;
    public final ad TKY;
    public final w TKZ;
    final i TLa;
    final f TLb;
    public final l Tko;
    public final l Tvt;

    public n(l lVar, c cVar, l lVar2, h hVar, i iVar, a aVar, f fVar, ad adVar, List<a.r> list) {
        String str;
        p.h(lVar, "components");
        p.h(cVar, "nameResolver");
        p.h(lVar2, "containingDeclaration");
        p.h(hVar, "typeTable");
        p.h(iVar, "versionRequirementTable");
        p.h(aVar, "metadataVersion");
        p.h(list, "typeParameters");
        AppMethodBeat.i(60309);
        this.Tvt = lVar;
        this.SZH = cVar;
        this.Tko = lVar2;
        this.SZI = hVar;
        this.TLa = iVar;
        this.TKB = aVar;
        this.TLb = fVar;
        String str2 = "Deserializer for \"" + this.Tko.hAH() + '\"';
        f fVar2 = this.TLb;
        this.TKY = new ad(this, adVar, list, str2, (fVar2 == null || (str = fVar2.hEl()) == null) ? "[container not found]" : str, (byte) 0);
        this.TKZ = new w(this);
        AppMethodBeat.o(60309);
    }

    public static /* synthetic */ n a(n nVar, l lVar, List list) {
        AppMethodBeat.i(60308);
        n a2 = nVar.a(lVar, list, nVar.SZH, nVar.SZI, nVar.TLa, nVar.TKB);
        AppMethodBeat.o(60308);
        return a2;
    }

    public final n a(l lVar, List<a.r> list, c cVar, h hVar, i iVar, kotlin.l.b.a.b.e.b.a aVar) {
        boolean z;
        AppMethodBeat.i(60307);
        p.h(lVar, "descriptor");
        p.h(list, "typeParameterProtos");
        p.h(cVar, "nameResolver");
        p.h(hVar, "typeTable");
        p.h(iVar, "versionRequirementTable");
        p.h(aVar, "metadataVersion");
        l lVar2 = this.Tvt;
        p.h(aVar, "version");
        p.h(aVar, "version");
        if (aVar.major != 1 || aVar.minor < 4) {
            z = false;
        } else {
            z = true;
        }
        n nVar = new n(lVar2, cVar, lVar, hVar, z ? iVar : this.TLa, aVar, this.TLb, this.TKY, list);
        AppMethodBeat.o(60307);
        return nVar;
    }
}
