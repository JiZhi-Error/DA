package kotlin.l.b.a.b.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.a.ae;
import kotlin.a.j;
import kotlin.a.v;
import kotlin.aa;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l.b.a.b.a.g;
import kotlin.l.b.a.b.f.b;
import kotlin.l.b.a.b.f.c;
import kotlin.l.b.a.b.f.f;
import kotlin.o;
import kotlin.s;

public final class e {
    private static final Map<b, f> ToR;
    private static final Map<f, List<f>> ToS;
    private static final Set<b> ToT;
    private static final Set<f> ToU;
    public static final e ToV = new e();

    /* access modifiers changed from: package-private */
    public static final class a extends q implements kotlin.g.a.b<kotlin.l.b.a.b.b.b, Boolean> {
        public static final a ToW = new a();

        static {
            AppMethodBeat.i(57568);
            AppMethodBeat.o(57568);
        }

        a() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ Boolean invoke(kotlin.l.b.a.b.b.b bVar) {
            AppMethodBeat.i(57567);
            kotlin.l.b.a.b.b.b bVar2 = bVar;
            p.h(bVar2, LocaleUtil.ITALIAN);
            e eVar = e.ToV;
            Boolean valueOf = Boolean.valueOf(e.k(bVar2));
            AppMethodBeat.o(57567);
            return valueOf;
        }
    }

    static {
        AppMethodBeat.i(57572);
        c cVar = g.TcO.Tdj;
        p.g(cVar, "BUILTIN_NAMES._enum");
        c cVar2 = g.TcO.Tdj;
        p.g(cVar2, "BUILTIN_NAMES._enum");
        b bVar = g.TcO.TdF;
        p.g(bVar, "BUILTIN_NAMES.collection");
        b bVar2 = g.TcO.TdJ;
        p.g(bVar2, "BUILTIN_NAMES.map");
        c cVar3 = g.TcO.TcX;
        p.g(cVar3, "BUILTIN_NAMES.charSequence");
        b bVar3 = g.TcO.TdJ;
        p.g(bVar3, "BUILTIN_NAMES.map");
        b bVar4 = g.TcO.TdJ;
        p.g(bVar4, "BUILTIN_NAMES.map");
        b bVar5 = g.TcO.TdJ;
        p.g(bVar5, "BUILTIN_NAMES.map");
        Map<b, f> e2 = ae.e(s.U(t.b(cVar, "name"), f.btY("name")), s.U(t.b(cVar2, "ordinal"), f.btY("ordinal")), s.U(t.a(bVar, "size"), f.btY("size")), s.U(t.a(bVar2, "size"), f.btY("size")), s.U(t.b(cVar3, "length"), f.btY("length")), s.U(t.a(bVar3, "keys"), f.btY("keySet")), s.U(t.a(bVar4, "values"), f.btY("values")), s.U(t.a(bVar5, "entries"), f.btY("entrySet")));
        ToR = e2;
        Set<Map.Entry<b, f>> entrySet = e2.entrySet();
        ArrayList arrayList = new ArrayList(j.a(entrySet, 10));
        for (T t : entrySet) {
            arrayList.add(new o(((b) t.getKey()).hJg(), t.getValue()));
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : arrayList) {
            B b2 = ((o) obj).second;
            Object obj2 = linkedHashMap.get(b2);
            if (obj2 == null) {
                obj2 = new ArrayList();
                linkedHashMap.put(b2, obj2);
            }
            ((List) obj2).add(((o) obj).first);
        }
        ToS = linkedHashMap;
        Set<b> keySet = ToR.keySet();
        ToT = keySet;
        Set<b> set = keySet;
        ArrayList arrayList2 = new ArrayList(j.a(set, 10));
        Iterator<T> it = set.iterator();
        while (it.hasNext()) {
            arrayList2.add(it.next().hJg());
        }
        ToU = j.r((Iterable) arrayList2);
        AppMethodBeat.o(57572);
    }

    private e() {
    }

    public static Set<f> hDt() {
        return ToU;
    }

    public static boolean k(kotlin.l.b.a.b.b.b bVar) {
        AppMethodBeat.i(57569);
        p.h(bVar, "callableMemberDescriptor");
        if (!ToU.contains(bVar.hAH())) {
            AppMethodBeat.o(57569);
            return false;
        } else if (!j.a(ToT, kotlin.l.b.a.b.j.d.a.I(bVar)) || !bVar.hAw().isEmpty()) {
            if (g.c(bVar)) {
                Collection<? extends kotlin.l.b.a.b.b.b> hAy = bVar.hAy();
                p.g(hAy, "overriddenDescriptors");
                Collection<? extends kotlin.l.b.a.b.b.b> collection = hAy;
                if (!(collection instanceof Collection) || !collection.isEmpty()) {
                    for (T t : collection) {
                        p.g(t, LocaleUtil.ITALIAN);
                        if (k(t)) {
                            AppMethodBeat.o(57569);
                            return true;
                        }
                    }
                }
            }
            AppMethodBeat.o(57569);
            return false;
        } else {
            AppMethodBeat.o(57569);
            return true;
        }
    }

    public static List<f> h(f fVar) {
        AppMethodBeat.i(57570);
        p.h(fVar, "name1");
        v vVar = ToS.get(fVar);
        if (vVar == null) {
            vVar = v.SXr;
        }
        AppMethodBeat.o(57570);
        return vVar;
    }

    public static String l(kotlin.l.b.a.b.b.b bVar) {
        AppMethodBeat.i(57571);
        p.h(bVar, "$this$getBuiltinSpecialPropertyGetterName");
        boolean c2 = g.c(bVar);
        if (!aa.SXc || c2) {
            kotlin.l.b.a.b.b.b b2 = kotlin.l.b.a.b.j.d.a.b(kotlin.l.b.a.b.j.d.a.v(bVar), a.ToW);
            if (b2 == null) {
                AppMethodBeat.o(57571);
                return null;
            }
            f fVar = ToR.get(kotlin.l.b.a.b.j.d.a.o(b2));
            if (fVar != null) {
                String sG = fVar.sG();
                AppMethodBeat.o(57571);
                return sG;
            }
            AppMethodBeat.o(57571);
            return null;
        }
        AssertionError assertionError = new AssertionError("This method is defined only for builtin members, but " + bVar + " found");
        AppMethodBeat.o(57571);
        throw assertionError;
    }
}
