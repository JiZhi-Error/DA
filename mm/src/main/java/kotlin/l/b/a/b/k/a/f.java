package kotlin.l.b.a.b.k.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.a.ae;
import kotlin.g.b.p;
import kotlin.l.b.a.b.a.g;
import kotlin.l.b.a.b.b.aa;
import kotlin.l.b.a.b.b.an;
import kotlin.l.b.a.b.b.av;
import kotlin.l.b.a.b.b.y;
import kotlin.l.b.a.b.e.a;
import kotlin.l.b.a.b.e.b.b;
import kotlin.l.b.a.b.e.b.c;
import kotlin.l.b.a.b.j.b.d;
import kotlin.l.b.a.b.j.b.e;
import kotlin.l.b.a.b.j.b.h;
import kotlin.l.b.a.b.j.b.i;
import kotlin.l.b.a.b.j.b.j;
import kotlin.l.b.a.b.j.b.k;
import kotlin.l.b.a.b.j.b.l;
import kotlin.l.b.a.b.j.b.m;
import kotlin.l.b.a.b.j.b.r;
import kotlin.l.b.a.b.j.b.s;
import kotlin.l.b.a.b.j.b.u;
import kotlin.l.b.a.b.j.b.v;
import kotlin.l.b.a.b.j.b.w;
import kotlin.l.b.a.b.j.b.x;
import kotlin.l.b.a.b.j.b.z;
import kotlin.l.b.a.b.m.ab;
import kotlin.l.b.a.b.m.aj;
import kotlin.o;

public final class f {
    private final aa TeR;
    private final y Tfp;

    public f(y yVar, aa aaVar) {
        p.h(yVar, "module");
        p.h(aaVar, "notFoundClasses");
        AppMethodBeat.i(60287);
        this.Tfp = yVar;
        this.TeR = aaVar;
        AppMethodBeat.o(60287);
    }

    private final g hBh() {
        AppMethodBeat.i(60280);
        g hBh = this.Tfp.hBh();
        AppMethodBeat.o(60280);
        return hBh;
    }

    private final kotlin.l.b.a.b.j.b.g<?> a(ab abVar, a.C2299a.C2301a.b bVar, c cVar) {
        AppMethodBeat.i(60283);
        k b2 = b(abVar, bVar, cVar);
        if (!a(b2, abVar, bVar)) {
            b2 = null;
        }
        if (b2 == null) {
            k.a aVar = k.TIz;
            b2 = k.a.bui("Unexpected argument value: actual type " + bVar.TwS + " != expected type " + abVar);
        }
        AppMethodBeat.o(60283);
        return b2;
    }

    public final kotlin.l.b.a.b.j.b.g<?> b(ab abVar, a.C2299a.C2301a.b bVar, c cVar) {
        kotlin.l.b.a.b.j.b.g<?> mVar;
        kotlin.l.b.a.b.j.b.g<?> uVar;
        AppMethodBeat.i(60284);
        p.h(abVar, "expectedType");
        p.h(bVar, "value");
        p.h(cVar, "nameResolver");
        Boolean avk = b.TBE.avk(bVar.Txb);
        p.g(avk, "Flags.IS_UNSIGNED.get(value.flags)");
        boolean booleanValue = avk.booleanValue();
        a.C2299a.C2301a.b.EnumC2304b bVar2 = bVar.TwS;
        if (bVar2 != null) {
            switch (g.$EnumSwitchMapping$0[bVar2.ordinal()]) {
                case 1:
                    byte b2 = (byte) ((int) bVar.TwT);
                    kotlin.l.b.a.b.j.b.g<?> wVar = booleanValue ? new w(b2) : new d(b2);
                    AppMethodBeat.o(60284);
                    return wVar;
                case 2:
                    e eVar = new e((char) ((int) bVar.TwT));
                    AppMethodBeat.o(60284);
                    return eVar;
                case 3:
                    short s = (short) ((int) bVar.TwT);
                    if (booleanValue) {
                        uVar = new z(s);
                    } else {
                        uVar = new u(s);
                    }
                    kotlin.l.b.a.b.j.b.g<?> gVar = uVar;
                    AppMethodBeat.o(60284);
                    return gVar;
                case 4:
                    int i2 = (int) bVar.TwT;
                    if (booleanValue) {
                        mVar = new x(i2);
                    } else {
                        mVar = new m(i2);
                    }
                    kotlin.l.b.a.b.j.b.g<?> gVar2 = mVar;
                    AppMethodBeat.o(60284);
                    return gVar2;
                case 5:
                    long j2 = bVar.TwT;
                    kotlin.l.b.a.b.j.b.g<?> yVar = booleanValue ? new kotlin.l.b.a.b.j.b.y(j2) : new s(j2);
                    AppMethodBeat.o(60284);
                    return yVar;
                case 6:
                    l lVar = new l(bVar.TwU);
                    AppMethodBeat.o(60284);
                    return lVar;
                case 7:
                    i iVar = new i(bVar.bSh);
                    AppMethodBeat.o(60284);
                    return iVar;
                case 8:
                    kotlin.l.b.a.b.j.b.c cVar2 = new kotlin.l.b.a.b.j.b.c(bVar.TwT != 0);
                    AppMethodBeat.o(60284);
                    return cVar2;
                case 9:
                    v vVar = new v(cVar.getString(bVar.TwV));
                    AppMethodBeat.o(60284);
                    return vVar;
                case 10:
                    r rVar = new r(x.a(cVar, bVar.TwW), bVar.Txa);
                    AppMethodBeat.o(60284);
                    return rVar;
                case 11:
                    j jVar = new j(x.a(cVar, bVar.TwW), x.b(cVar, bVar.TwX));
                    AppMethodBeat.o(60284);
                    return jVar;
                case 12:
                    a.C2299a aVar = bVar.TwY;
                    p.g(aVar, "value.annotation");
                    kotlin.l.b.a.b.j.b.a aVar2 = new kotlin.l.b.a.b.j.b.a(b(aVar, cVar));
                    AppMethodBeat.o(60284);
                    return aVar2;
                case 13:
                    h hVar = h.TIu;
                    List<a.C2299a.C2301a.b> list = bVar.TwZ;
                    p.g(list, "value.arrayElementList");
                    List<a.C2299a.C2301a.b> list2 = list;
                    ArrayList arrayList = new ArrayList(kotlin.a.j.a(list2, 10));
                    for (T t : list2) {
                        aj hzi = hBh().hzi();
                        p.g(hzi, "builtIns.anyType");
                        p.g(t, LocaleUtil.ITALIAN);
                        arrayList.add(b(hzi, t, cVar));
                    }
                    kotlin.l.b.a.b.j.b.b a2 = h.a(arrayList, abVar);
                    AppMethodBeat.o(60284);
                    return a2;
            }
        }
        IllegalStateException illegalStateException = new IllegalStateException(("Unsupported annotation argument type: " + bVar.TwS + " (expected " + abVar + ')').toString());
        AppMethodBeat.o(60284);
        throw illegalStateException;
    }

    private final kotlin.l.b.a.b.b.e f(kotlin.l.b.a.b.f.a aVar) {
        AppMethodBeat.i(60286);
        kotlin.l.b.a.b.b.e a2 = kotlin.l.b.a.b.b.s.a(this.Tfp, aVar, this.TeR);
        AppMethodBeat.o(60286);
        return a2;
    }

    public final kotlin.l.b.a.b.b.a.c b(a.C2299a aVar, c cVar) {
        Map map;
        AppMethodBeat.i(60281);
        p.h(aVar, "proto");
        p.h(cVar, "nameResolver");
        kotlin.l.b.a.b.b.e f2 = f(x.a(cVar, aVar.TwM));
        Map emptyMap = ae.emptyMap();
        if (aVar.getArgumentCount() != 0 && !kotlin.l.b.a.b.m.u.L(f2) && kotlin.l.b.a.b.j.c.z((kotlin.l.b.a.b.b.l) f2)) {
            Collection<kotlin.l.b.a.b.b.d> hxW = f2.hxW();
            p.g(hxW, "annotationClass.constructors");
            kotlin.l.b.a.b.b.d dVar = (kotlin.l.b.a.b.b.d) kotlin.a.j.j(hxW);
            if (dVar != null) {
                List<av> hAw = dVar.hAw();
                p.g(hAw, "constructor.valueParameters");
                List<av> list = hAw;
                LinkedHashMap linkedHashMap = new LinkedHashMap(kotlin.k.j.mZ(ae.atJ(kotlin.a.j.a(list, 10)), 16));
                for (T t : list) {
                    T t2 = t;
                    p.g(t2, LocaleUtil.ITALIAN);
                    linkedHashMap.put(t2.hAH(), t);
                }
                List<a.C2299a.C2301a> list2 = aVar.TwN;
                p.g(list2, "proto.argumentList");
                ArrayList arrayList = new ArrayList();
                for (T t3 : list2) {
                    p.g(t3, LocaleUtil.ITALIAN);
                    o<kotlin.l.b.a.b.f.f, kotlin.l.b.a.b.j.b.g<?>> a2 = a(t3, linkedHashMap, cVar);
                    if (a2 != null) {
                        arrayList.add(a2);
                    }
                }
                map = ae.E(arrayList);
                kotlin.l.b.a.b.b.a.d dVar2 = new kotlin.l.b.a.b.b.a.d(f2.hAG(), map, an.ThK);
                AppMethodBeat.o(60281);
                return dVar2;
            }
        }
        map = emptyMap;
        kotlin.l.b.a.b.b.a.d dVar22 = new kotlin.l.b.a.b.b.a.d(f2.hAG(), map, an.ThK);
        AppMethodBeat.o(60281);
        return dVar22;
    }

    private final o<kotlin.l.b.a.b.f.f, kotlin.l.b.a.b.j.b.g<?>> a(a.C2299a.C2301a aVar, Map<kotlin.l.b.a.b.f.f, ? extends av> map, c cVar) {
        AppMethodBeat.i(60282);
        av avVar = (av) map.get(x.b(cVar, aVar.TwP));
        if (avVar == null) {
            AppMethodBeat.o(60282);
            return null;
        }
        kotlin.l.b.a.b.f.f b2 = x.b(cVar, aVar.TwP);
        ab hBy = avVar.hBy();
        p.g(hBy, "parameter.type");
        a.C2299a.C2301a.b bVar = aVar.TwQ;
        p.g(bVar, "proto.value");
        o<kotlin.l.b.a.b.f.f, kotlin.l.b.a.b.j.b.g<?>> oVar = new o<>(b2, a(hBy, bVar, cVar));
        AppMethodBeat.o(60282);
        return oVar;
    }

    private final boolean a(kotlin.l.b.a.b.j.b.g<?> gVar, ab abVar, a.C2299a.C2301a.b bVar) {
        AppMethodBeat.i(60285);
        a.C2299a.C2301a.b.EnumC2304b bVar2 = bVar.TwS;
        if (bVar2 != null) {
            switch (g.haE[bVar2.ordinal()]) {
                case 1:
                    kotlin.l.b.a.b.b.h hzS = abVar.hKE().hzS();
                    if (!(hzS instanceof kotlin.l.b.a.b.b.e)) {
                        hzS = null;
                    }
                    kotlin.l.b.a.b.b.e eVar = (kotlin.l.b.a.b.b.e) hzS;
                    if (eVar == null || g.g(eVar)) {
                        AppMethodBeat.o(60285);
                        return true;
                    }
                    AppMethodBeat.o(60285);
                    return false;
                case 2:
                    if (!((gVar instanceof kotlin.l.b.a.b.j.b.b) && ((List) ((kotlin.l.b.a.b.j.b.b) gVar).getValue()).size() == bVar.TwZ.size())) {
                        IllegalStateException illegalStateException = new IllegalStateException("Deserialized ArrayValue should have the same number of elements as the original array value: ".concat(String.valueOf(gVar)).toString());
                        AppMethodBeat.o(60285);
                        throw illegalStateException;
                    }
                    ab l = hBh().l(abVar);
                    p.g(l, "builtIns.getArrayElementType(expectedType)");
                    Iterator it = kotlin.a.j.r((Collection<?>) ((Collection) ((kotlin.l.b.a.b.j.b.b) gVar).getValue())).iterator();
                    while (it.hasNext()) {
                        int nextInt = ((kotlin.a.ab) it).nextInt();
                        a.C2299a.C2301a.b atT = bVar.atT(nextInt);
                        p.g(atT, "value.getArrayElement(i)");
                        if (!a((kotlin.l.b.a.b.j.b.g) ((List) ((kotlin.l.b.a.b.j.b.b) gVar).getValue()).get(nextInt), l, atT)) {
                            AppMethodBeat.o(60285);
                            return false;
                        }
                    }
                    AppMethodBeat.o(60285);
                    return true;
            }
        }
        boolean j2 = p.j(gVar.b(this.Tfp), abVar);
        AppMethodBeat.o(60285);
        return j2;
    }
}
