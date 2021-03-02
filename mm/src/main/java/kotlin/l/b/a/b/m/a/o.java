package kotlin.l.b.a.b.m.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import kotlin.a.j;
import kotlin.a.v;
import kotlin.g.b.p;
import kotlin.l.b.a.b.j.a.a.c;
import kotlin.l.b.a.b.j.b.q;
import kotlin.l.b.a.b.j.i;
import kotlin.l.b.a.b.m.aa;
import kotlin.l.b.a.b.m.ab;
import kotlin.l.b.a.b.m.ac;
import kotlin.l.b.a.b.m.aj;
import kotlin.l.b.a.b.m.at;
import kotlin.l.b.a.b.m.av;
import kotlin.l.b.a.b.m.bc;
import kotlin.l.b.a.b.m.be;
import kotlin.l.b.a.b.m.bg;
import kotlin.l.b.a.b.m.bh;
import kotlin.l.b.a.b.m.c.b;
import kotlin.l.b.a.b.m.d.a;
import kotlin.l.b.a.b.m.e;
import kotlin.m;

public final class o implements n {
    private final i THR;
    private final i TPt;

    public o(i iVar) {
        p.h(iVar, "kotlinTypeRefiner");
        AppMethodBeat.i(61089);
        this.THR = iVar;
        i f2 = i.f(this.THR);
        p.g(f2, "OverridingUtil.createWit…efiner(kotlinTypeRefiner)");
        this.TPt = f2;
        AppMethodBeat.o(61089);
    }

    @Override // kotlin.l.b.a.b.m.a.n
    public final i hLM() {
        return this.THR;
    }

    @Override // kotlin.l.b.a.b.m.a.n
    public final i hLN() {
        return this.TPt;
    }

    @Override // kotlin.l.b.a.b.m.a.g
    public final boolean c(ab abVar, ab abVar2) {
        AppMethodBeat.i(61085);
        p.h(abVar, "subtype");
        p.h(abVar2, "supertype");
        a aVar = new a(true, false, false, this.THR, 6);
        bg hLF = abVar.hLF();
        bg hLF2 = abVar2.hLF();
        p.h(aVar, "$this$isSubtypeOf");
        p.h(hLF, "subType");
        p.h(hLF2, "superType");
        e eVar = e.TNl;
        boolean a2 = e.a(aVar, hLF, hLF2);
        AppMethodBeat.o(61085);
        return a2;
    }

    @Override // kotlin.l.b.a.b.m.a.g
    public final boolean d(ab abVar, ab abVar2) {
        AppMethodBeat.i(61086);
        p.h(abVar, "a");
        p.h(abVar2, "b");
        a aVar = new a(false, false, false, this.THR, 6);
        bg hLF = abVar.hLF();
        bg hLF2 = abVar2.hLF();
        p.h(aVar, "$this$equalTypes");
        p.h(hLF, "a");
        p.h(hLF2, "b");
        e eVar = e.TNl;
        boolean b2 = e.b(aVar, hLF, hLF2);
        AppMethodBeat.o(61086);
        return b2;
    }

    private static aj c(aj ajVar) {
        aa aaVar;
        aa aaVar2;
        ab hBy;
        boolean z = true;
        bg bgVar = null;
        AppMethodBeat.i(61087);
        p.h(ajVar, "type");
        at hKE = ajVar.hKE();
        if (hKE instanceof c) {
            av avVar = ((c) hKE).TIo;
            if (avVar.hLI() != bh.IN_VARIANCE) {
                z = false;
            }
            if (!z) {
                avVar = null;
            }
            if (!(avVar == null || (hBy = avVar.hBy()) == null)) {
                bgVar = hBy.hLF();
            }
            if (((c) hKE).TIn == null) {
                c cVar = (c) hKE;
                av avVar2 = ((c) hKE).TIo;
                Collection<ab> hBV = ((c) hKE).hBV();
                ArrayList arrayList = new ArrayList(j.a(hBV, 10));
                Iterator<T> it = hBV.iterator();
                while (it.hasNext()) {
                    arrayList.add(it.next().hLF());
                }
                cVar.TIn = new l(avVar2, arrayList, (byte) 0);
            }
            b bVar = b.FOR_SUBTYPING;
            l lVar = ((c) hKE).TIn;
            if (lVar == null) {
                p.hyc();
            }
            k kVar = new k(bVar, lVar, bgVar, ajVar.hzL(), ajVar.hEa());
            AppMethodBeat.o(61087);
            return kVar;
        } else if (hKE instanceof q) {
            ArrayList<ab> arrayList2 = ((q) hKE).TII;
            ArrayList arrayList3 = new ArrayList(j.a(arrayList2, 10));
            Iterator<T> it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                arrayList3.add(bc.b(it2.next(), ajVar.hEa()));
            }
            aj a2 = ac.a(ajVar.hzL(), new aa(arrayList3), v.SXr, false, ajVar.hAp());
            AppMethodBeat.o(61087);
            return a2;
        } else if (!(hKE instanceof aa) || !ajVar.hEa()) {
            AppMethodBeat.o(61087);
            return ajVar;
        } else {
            LinkedHashSet<ab> linkedHashSet = ((aa) hKE).TOe;
            ArrayList arrayList4 = new ArrayList(j.a(linkedHashSet, 10));
            Iterator<T> it3 = linkedHashSet.iterator();
            boolean z2 = false;
            while (it3.hasNext()) {
                arrayList4.add(a.aC(it3.next()));
                z2 = true;
            }
            ArrayList arrayList5 = arrayList4;
            if (!z2) {
                aaVar = null;
            } else {
                aaVar = new aa(arrayList5);
            }
            if (aaVar == null) {
                aaVar2 = (aa) hKE;
            } else {
                aaVar2 = aaVar;
            }
            aj hLE = aaVar2.hLE();
            AppMethodBeat.o(61087);
            return hLE;
        }
    }

    public static bg c(bg bgVar) {
        aj a2;
        AppMethodBeat.i(61088);
        p.h(bgVar, "type");
        if (bgVar instanceof aj) {
            a2 = c((aj) bgVar);
        } else if (bgVar instanceof kotlin.l.b.a.b.m.v) {
            aj c2 = c(((kotlin.l.b.a.b.m.v) bgVar).TNV);
            aj c3 = c(((kotlin.l.b.a.b.m.v) bgVar).TNW);
            a2 = (c2 == ((kotlin.l.b.a.b.m.v) bgVar).TNV && c3 == ((kotlin.l.b.a.b.m.v) bgVar).TNW) ? bgVar : ac.a(c2, c3);
        } else {
            m mVar = new m();
            AppMethodBeat.o(61088);
            throw mVar;
        }
        bg a3 = be.a(a2, bgVar);
        AppMethodBeat.o(61088);
        return a3;
    }
}
