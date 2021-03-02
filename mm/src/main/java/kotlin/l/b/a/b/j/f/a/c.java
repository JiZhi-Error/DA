package kotlin.l.b.a.b.j.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l.b.a.b.b.e;
import kotlin.l.b.a.b.m.ab;
import kotlin.l.b.a.b.m.aj;

public final class c implements d, g {
    private final c TKo = this;
    private final e TKp = this.ThF;
    private final e ThF;

    public c(e eVar) {
        p.h(eVar, "classDescriptor");
        AppMethodBeat.i(60257);
        this.ThF = eVar;
        AppMethodBeat.o(60257);
    }

    @Override // kotlin.l.b.a.b.j.f.a.e
    public final /* synthetic */ ab hBy() {
        AppMethodBeat.i(60253);
        aj hDN = hDN();
        AppMethodBeat.o(60253);
        return hDN;
    }

    @Override // kotlin.l.b.a.b.j.f.a.g
    public final e hBx() {
        return this.ThF;
    }

    private aj hDN() {
        AppMethodBeat.i(60252);
        aj hAG = this.ThF.hAG();
        p.g(hAG, "classDescriptor.defaultType");
        AppMethodBeat.o(60252);
        return hAG;
    }

    public final boolean equals(Object obj) {
        e eVar = null;
        AppMethodBeat.i(60254);
        e eVar2 = this.ThF;
        c cVar = (c) (!(obj instanceof c) ? null : obj);
        if (cVar != null) {
            eVar = cVar.ThF;
        }
        boolean j2 = p.j(eVar2, eVar);
        AppMethodBeat.o(60254);
        return j2;
    }

    public final int hashCode() {
        AppMethodBeat.i(60255);
        int hashCode = this.ThF.hashCode();
        AppMethodBeat.o(60255);
        return hashCode;
    }

    public final String toString() {
        AppMethodBeat.i(60256);
        String str = "Class{" + hDN() + '}';
        AppMethodBeat.o(60256);
        return str;
    }
}
