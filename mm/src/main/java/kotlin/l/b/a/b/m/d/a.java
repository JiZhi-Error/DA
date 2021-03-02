package kotlin.l.b.a.b.m.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.a.j;
import kotlin.aa;
import kotlin.g.b.p;
import kotlin.l.b.a.b.a.g;
import kotlin.l.b.a.b.b.as;
import kotlin.l.b.a.b.b.e;
import kotlin.l.b.a.b.b.f;
import kotlin.l.b.a.b.b.h;
import kotlin.l.b.a.b.m.ab;
import kotlin.l.b.a.b.m.ac;
import kotlin.l.b.a.b.m.aj;
import kotlin.l.b.a.b.m.ao;
import kotlin.l.b.a.b.m.av;
import kotlin.l.b.a.b.m.ax;
import kotlin.l.b.a.b.m.az;
import kotlin.l.b.a.b.m.bc;
import kotlin.l.b.a.b.m.be;
import kotlin.l.b.a.b.m.bg;
import kotlin.l.b.a.b.m.bh;
import kotlin.l.b.a.b.m.v;
import kotlin.m;

public final class a {
    public static final g aM(ab abVar) {
        AppMethodBeat.i(61247);
        p.h(abVar, "$this$builtIns");
        g hBh = abVar.hKE().hBh();
        p.g(hBh, "constructor.builtIns");
        AppMethodBeat.o(61247);
        return hBh;
    }

    public static final ab aC(ab abVar) {
        AppMethodBeat.i(61248);
        p.h(abVar, "$this$makeNullable");
        ab aC = bc.aC(abVar);
        p.g(aC, "TypeUtils.makeNullable(this)");
        AppMethodBeat.o(61248);
        return aC;
    }

    public static final ab aD(ab abVar) {
        AppMethodBeat.i(61249);
        p.h(abVar, "$this$makeNotNullable");
        ab aD = bc.aD(abVar);
        p.g(aD, "TypeUtils.makeNotNullable(this)");
        AppMethodBeat.o(61249);
        return aD;
    }

    public static final boolean aH(ab abVar) {
        AppMethodBeat.i(61250);
        p.h(abVar, "$this$isTypeParameter");
        boolean aH = bc.aH(abVar);
        AppMethodBeat.o(61250);
        return aH;
    }

    public static final boolean c(ab abVar, ab abVar2) {
        AppMethodBeat.i(61251);
        p.h(abVar, "$this$isSubtypeOf");
        p.h(abVar2, "superType");
        boolean c2 = kotlin.l.b.a.b.m.a.g.TPc.c(abVar, abVar2);
        AppMethodBeat.o(61251);
        return c2;
    }

    public static final ab a(ab abVar, kotlin.l.b.a.b.b.a.g gVar) {
        AppMethodBeat.i(61252);
        p.h(abVar, "$this$replaceAnnotations");
        p.h(gVar, "newAnnotations");
        if (!abVar.hzL().isEmpty() || !gVar.isEmpty()) {
            bg b2 = abVar.hLF().b(gVar);
            AppMethodBeat.o(61252);
            return b2;
        }
        AppMethodBeat.o(61252);
        return abVar;
    }

    public static final av a(ab abVar, bh bhVar, as asVar) {
        AppMethodBeat.i(61253);
        p.h(abVar, "type");
        p.h(bhVar, "projectionKind");
        if ((asVar != null ? asVar.hAJ() : null) == bhVar) {
            bhVar = bh.INVARIANT;
        }
        ax axVar = new ax(bhVar, abVar);
        AppMethodBeat.o(61253);
        return axVar;
    }

    public static final av aN(ab abVar) {
        AppMethodBeat.i(61254);
        p.h(abVar, "$this$asTypeProjection");
        ax axVar = new ax(abVar);
        AppMethodBeat.o(61254);
        return axVar;
    }

    public static final ab e(as asVar) {
        T t;
        boolean z;
        AppMethodBeat.i(61256);
        p.h(asVar, "$this$representativeUpperBound");
        List<ab> hyo = asVar.hyo();
        p.g(hyo, "upperBounds");
        boolean z2 = !hyo.isEmpty();
        if (!aa.SXc || z2) {
            List<ab> hyo2 = asVar.hyo();
            p.g(hyo2, "upperBounds");
            Iterator<T> it = hyo2.iterator();
            while (true) {
                if (!it.hasNext()) {
                    t = null;
                    break;
                }
                T next = it.next();
                h hzS = next.hKE().hzS();
                if (!(hzS instanceof e)) {
                    hzS = null;
                }
                e eVar = (e) hzS;
                if (eVar == null || eVar.hzB() == f.INTERFACE || eVar.hzB() == f.ANNOTATION_CLASS) {
                    z = false;
                    continue;
                } else {
                    z = true;
                    continue;
                }
                if (z) {
                    t = next;
                    break;
                }
            }
            T t2 = t;
            if (t2 == null) {
                List<ab> hyo3 = asVar.hyo();
                p.g(hyo3, "upperBounds");
                Object ks = j.ks(hyo3);
                p.g(ks, "upperBounds.first()");
                t2 = (ab) ks;
            }
            AppMethodBeat.o(61256);
            return t2;
        }
        AssertionError assertionError = new AssertionError("Upper bounds should not be empty: ".concat(String.valueOf(asVar)));
        AppMethodBeat.o(61256);
        throw assertionError;
    }

    public static final ab aO(ab abVar) {
        aj ajVar;
        aj ajVar2;
        AppMethodBeat.i(61255);
        p.h(abVar, "$this$replaceArgumentsWithStarProjections");
        bg hLF = abVar.hLF();
        if (hLF instanceof v) {
            aj ajVar3 = ((v) hLF).TNV;
            if (!ajVar3.hKE().getParameters().isEmpty() && ajVar3.hKE().hzS() != null) {
                List<as> parameters = ajVar3.hKE().getParameters();
                p.g(parameters, "constructor.parameters");
                List<as> list = parameters;
                ArrayList arrayList = new ArrayList(j.a(list, 10));
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(new ao(it.next()));
                }
                ajVar3 = az.a(ajVar3, arrayList, null, 2);
            }
            aj ajVar4 = ((v) hLF).TNW;
            if (ajVar4.hKE().getParameters().isEmpty() || ajVar4.hKE().hzS() == null) {
                ajVar2 = ajVar4;
            } else {
                List<as> parameters2 = ajVar4.hKE().getParameters();
                p.g(parameters2, "constructor.parameters");
                List<as> list2 = parameters2;
                ArrayList arrayList2 = new ArrayList(j.a(list2, 10));
                Iterator<T> it2 = list2.iterator();
                while (it2.hasNext()) {
                    arrayList2.add(new ao(it2.next()));
                }
                ajVar2 = az.a(ajVar4, arrayList2, null, 2);
            }
            ajVar = ac.a(ajVar3, ajVar2);
        } else if (hLF instanceof aj) {
            aj ajVar5 = (aj) hLF;
            if (!ajVar5.hKE().getParameters().isEmpty() && ajVar5.hKE().hzS() != null) {
                List<as> parameters3 = ajVar5.hKE().getParameters();
                p.g(parameters3, "constructor.parameters");
                List<as> list3 = parameters3;
                ArrayList arrayList3 = new ArrayList(j.a(list3, 10));
                Iterator<T> it3 = list3.iterator();
                while (it3.hasNext()) {
                    arrayList3.add(new ao(it3.next()));
                }
                ajVar5 = az.a(ajVar5, arrayList3, null, 2);
            }
            ajVar = ajVar5;
        } else {
            m mVar = new m();
            AppMethodBeat.o(61255);
            throw mVar;
        }
        bg a2 = be.a(ajVar, hLF);
        AppMethodBeat.o(61255);
        return a2;
    }
}
