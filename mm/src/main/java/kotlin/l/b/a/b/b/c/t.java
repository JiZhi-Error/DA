package kotlin.l.b.a.b.b.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l.b.a.b.b.e;
import kotlin.l.b.a.b.j.f.h;
import kotlin.l.b.a.b.m.a.i;
import kotlin.l.b.a.b.m.ay;

public abstract class t implements e {
    public static final a TlH = new a((byte) 0);

    /* access modifiers changed from: protected */
    public abstract h a(i iVar);

    /* access modifiers changed from: protected */
    public abstract h a(ay ayVar, i iVar);

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static h a(e eVar, i iVar) {
            h hVar;
            AppMethodBeat.i(57168);
            p.h(eVar, "$this$getRefinedUnsubstitutedMemberScopeIfPossible");
            p.h(iVar, "kotlinTypeRefiner");
            t tVar = (t) (!(eVar instanceof t) ? null : eVar);
            if (tVar == null || (hVar = tVar.a(iVar)) == null) {
                hVar = eVar.hAM();
                p.g(hVar, "this.unsubstitutedMemberScope");
            }
            AppMethodBeat.o(57168);
            return hVar;
        }

        public static h a(e eVar, ay ayVar, i iVar) {
            e eVar2;
            h hVar;
            AppMethodBeat.i(57169);
            p.h(eVar, "$this$getRefinedMemberScopeIfPossible");
            p.h(ayVar, "typeSubstitution");
            p.h(iVar, "kotlinTypeRefiner");
            if (!(eVar instanceof t)) {
                eVar2 = null;
            } else {
                eVar2 = eVar;
            }
            t tVar = (t) eVar2;
            if (tVar == null || (hVar = tVar.a(ayVar, iVar)) == null) {
                hVar = eVar.a(ayVar);
                p.g(hVar, "this.getMemberScope(\n   …ubstitution\n            )");
            }
            AppMethodBeat.o(57169);
            return hVar;
        }
    }
}
