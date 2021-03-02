package kotlin.l.b.a.b.d.a.c.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l.b.a.b.b.as;
import kotlin.l.b.a.b.b.e;
import kotlin.l.b.a.b.b.h;
import kotlin.l.b.a.b.d.a.a.l;
import kotlin.l.b.a.b.f.b;
import kotlin.l.b.a.b.m.ab;
import kotlin.l.b.a.b.m.aj;
import kotlin.l.b.a.b.m.ao;
import kotlin.l.b.a.b.m.ap;
import kotlin.l.b.a.b.m.av;
import kotlin.l.b.a.b.m.ax;
import kotlin.l.b.a.b.m.u;
import kotlin.t;

public final class d {
    private static final b Ttr = new b("java.lang.Class");

    static {
        AppMethodBeat.i(57981);
        AppMethodBeat.o(57981);
    }

    public static /* synthetic */ a a(l lVar, boolean z, as asVar, int i2) {
        AppMethodBeat.i(57978);
        if ((i2 & 1) != 0) {
            z = false;
        }
        if ((i2 & 2) != 0) {
            asVar = null;
        }
        p.h(lVar, "$this$toAttributes");
        a aVar = new a(lVar, z, asVar);
        AppMethodBeat.o(57978);
        return aVar;
    }

    public static /* synthetic */ ab b(as asVar) {
        AppMethodBeat.i(57980);
        ab a2 = a(asVar, null, new a(asVar));
        AppMethodBeat.o(57980);
        return a2;
    }

    public static final ab a(as asVar, as asVar2, kotlin.g.a.a<? extends ab> aVar) {
        AppMethodBeat.i(57979);
        p.h(asVar, "$this$getErasedUpperBound");
        p.h(aVar, "defaultValue");
        if (asVar == asVar2) {
            ab abVar = (ab) aVar.invoke();
            AppMethodBeat.o(57979);
            return abVar;
        }
        List<ab> hyo = asVar.hyo();
        p.g(hyo, "upperBounds");
        ab abVar2 = (ab) j.ks(hyo);
        if (abVar2.hKE().hzS() instanceof e) {
            p.g(abVar2, "firstUpperBound");
            ab aO = kotlin.l.b.a.b.m.d.a.aO(abVar2);
            AppMethodBeat.o(57979);
            return aO;
        }
        if (asVar2 != null) {
            asVar = asVar2;
        }
        h hzS = abVar2.hKE().hzS();
        if (hzS == null) {
            t tVar = new t("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.TypeParameterDescriptor");
            AppMethodBeat.o(57979);
            throw tVar;
        }
        while (true) {
            as asVar3 = (as) hzS;
            if (!p.j(asVar3, asVar)) {
                List<ab> hyo2 = asVar3.hyo();
                p.g(hyo2, "current.upperBounds");
                ab abVar3 = (ab) j.ks(hyo2);
                if (abVar3.hKE().hzS() instanceof e) {
                    p.g(abVar3, "nextUpperBound");
                    ab aO2 = kotlin.l.b.a.b.m.d.a.aO(abVar3);
                    AppMethodBeat.o(57979);
                    return aO2;
                }
                hzS = abVar3.hKE().hzS();
                if (hzS == null) {
                    t tVar2 = new t("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.TypeParameterDescriptor");
                    AppMethodBeat.o(57979);
                    throw tVar2;
                }
            } else {
                ab abVar4 = (ab) aVar.invoke();
                AppMethodBeat.o(57979);
                return abVar4;
            }
        }
    }

    public static final av a(as asVar, a aVar) {
        AppMethodBeat.i(57977);
        p.h(asVar, "typeParameter");
        p.h(aVar, "attr");
        if (aVar.Ttb == l.SUPERTYPE) {
            ax axVar = new ax(ap.c(asVar));
            AppMethodBeat.o(57977);
            return axVar;
        }
        ao aoVar = new ao(asVar);
        AppMethodBeat.o(57977);
        return aoVar;
    }

    public static final class a extends q implements kotlin.g.a.a<aj> {
        final /* synthetic */ as Tts;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(as asVar) {
            super(0);
            this.Tts = asVar;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ aj invoke() {
            AppMethodBeat.i(57976);
            aj bun = u.bun("Can't compute erased upper bound of type parameter `" + this.Tts + '`');
            p.g(bun, "ErrorUtils.createErrorTy… type parameter `$this`\")");
            AppMethodBeat.o(57976);
            return bun;
        }
    }
}
