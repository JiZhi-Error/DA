package kotlin.l.b.a.b.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.a.ae;
import kotlin.a.ak;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l.b.a.b.b.t;
import kotlin.l.b.a.b.d.b.v;
import kotlin.l.b.a.b.f.f;
import kotlin.s;

public final class d {
    private static final Map<String, b> ToA;
    private static final Set<f> ToB;
    private static final Set<String> ToC;
    public static final d ToD = new d();
    private static final List<r> Tow;
    private static final List<String> Tox;
    private static final List<String> Toy;
    private static final Map<r, b> Toz;

    /* access modifiers changed from: package-private */
    public static final class c extends q implements kotlin.g.a.b<kotlin.l.b.a.b.b.b, Boolean> {
        public static final c ToP = new c();

        static {
            AppMethodBeat.i(57559);
            AppMethodBeat.o(57559);
        }

        c() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ Boolean invoke(kotlin.l.b.a.b.b.b bVar) {
            AppMethodBeat.i(57558);
            kotlin.l.b.a.b.b.b bVar2 = bVar;
            p.h(bVar2, LocaleUtil.ITALIAN);
            d dVar = d.ToD;
            Boolean valueOf = Boolean.valueOf(d.j(bVar2));
            AppMethodBeat.o(57558);
            return valueOf;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: kotlin.l.b.a.b.d.a.d$d  reason: collision with other inner class name */
    public static final class C2288d extends q implements kotlin.g.a.b<kotlin.l.b.a.b.b.b, Boolean> {
        public static final C2288d ToQ = new C2288d();

        static {
            AppMethodBeat.i(57561);
            AppMethodBeat.o(57561);
        }

        C2288d() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ Boolean invoke(kotlin.l.b.a.b.b.b bVar) {
            boolean z;
            AppMethodBeat.i(57560);
            kotlin.l.b.a.b.b.b bVar2 = bVar;
            p.h(bVar2, LocaleUtil.ITALIAN);
            if (bVar2 instanceof t) {
                d dVar = d.ToD;
                if (d.j(bVar2)) {
                    z = true;
                    Boolean valueOf = Boolean.valueOf(z);
                    AppMethodBeat.o(57560);
                    return valueOf;
                }
            }
            z = false;
            Boolean valueOf2 = Boolean.valueOf(z);
            AppMethodBeat.o(57560);
            return valueOf2;
        }
    }

    static {
        AppMethodBeat.i(57565);
        Set<String> of = ak.setOf((Object[]) new String[]{"containsAll", "removeAll", "retainAll"});
        ArrayList arrayList = new ArrayList(j.a(of, 10));
        for (String str : of) {
            String desc = kotlin.l.b.a.b.j.e.d.BOOLEAN.getDesc();
            p.g(desc, "JvmPrimitiveType.BOOLEAN.desc");
            arrayList.add(t.H("java/util/Collection", str, "Ljava/util/Collection;", desc));
        }
        ArrayList arrayList2 = arrayList;
        Tow = arrayList2;
        ArrayList<r> arrayList3 = arrayList2;
        ArrayList arrayList4 = new ArrayList(j.a(arrayList3, 10));
        for (r rVar : arrayList3) {
            arrayList4.add(rVar.signature);
        }
        Tox = arrayList4;
        List<r> list = Tow;
        ArrayList arrayList5 = new ArrayList(j.a(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList5.add(it.next().TjT.sG());
        }
        Toy = arrayList5;
        v vVar = v.TvS;
        String btS = v.btS("Collection");
        String desc2 = kotlin.l.b.a.b.j.e.d.BOOLEAN.getDesc();
        p.g(desc2, "JvmPrimitiveType.BOOLEAN.desc");
        String btS2 = v.btS("Collection");
        String desc3 = kotlin.l.b.a.b.j.e.d.BOOLEAN.getDesc();
        p.g(desc3, "JvmPrimitiveType.BOOLEAN.desc");
        String btS3 = v.btS("Map");
        String desc4 = kotlin.l.b.a.b.j.e.d.BOOLEAN.getDesc();
        p.g(desc4, "JvmPrimitiveType.BOOLEAN.desc");
        String btS4 = v.btS("Map");
        String desc5 = kotlin.l.b.a.b.j.e.d.BOOLEAN.getDesc();
        p.g(desc5, "JvmPrimitiveType.BOOLEAN.desc");
        String btS5 = v.btS("Map");
        String desc6 = kotlin.l.b.a.b.j.e.d.BOOLEAN.getDesc();
        p.g(desc6, "JvmPrimitiveType.BOOLEAN.desc");
        String btS6 = v.btS("List");
        String desc7 = kotlin.l.b.a.b.j.e.d.INT.getDesc();
        p.g(desc7, "JvmPrimitiveType.INT.desc");
        String btS7 = v.btS("List");
        String desc8 = kotlin.l.b.a.b.j.e.d.INT.getDesc();
        p.g(desc8, "JvmPrimitiveType.INT.desc");
        Map<r, b> e2 = ae.e(s.U(t.H(btS, "contains", "Ljava/lang/Object;", desc2), b.ToM), s.U(t.H(btS2, "remove", "Ljava/lang/Object;", desc3), b.ToM), s.U(t.H(btS3, "containsKey", "Ljava/lang/Object;", desc4), b.ToM), s.U(t.H(btS4, "containsValue", "Ljava/lang/Object;", desc5), b.ToM), s.U(t.H(btS5, "remove", "Ljava/lang/Object;Ljava/lang/Object;", desc6), b.ToM), s.U(t.H(v.btS("Map"), "getOrDefault", "Ljava/lang/Object;Ljava/lang/Object;", "Ljava/lang/Object;"), b.ToN), s.U(t.H(v.btS("Map"), "get", "Ljava/lang/Object;", "Ljava/lang/Object;"), b.ToK), s.U(t.H(v.btS("Map"), "remove", "Ljava/lang/Object;", "Ljava/lang/Object;"), b.ToK), s.U(t.H(btS6, "indexOf", "Ljava/lang/Object;", desc7), b.ToL), s.U(t.H(btS7, "lastIndexOf", "Ljava/lang/Object;", desc8), b.ToL));
        Toz = e2;
        LinkedHashMap linkedHashMap = new LinkedHashMap(ae.atJ(e2.size()));
        for (T t : e2.entrySet()) {
            linkedHashMap.put(((r) t.getKey()).signature, t.getValue());
        }
        ToA = linkedHashMap;
        Set b2 = ak.b(Toz.keySet(), Tow);
        Set<r> set = b2;
        ArrayList arrayList6 = new ArrayList(j.a(set, 10));
        for (r rVar2 : set) {
            arrayList6.add(rVar2.TjT);
        }
        ToB = j.r((Iterable) arrayList6);
        Set<r> set2 = b2;
        ArrayList arrayList7 = new ArrayList(j.a(set2, 10));
        for (r rVar3 : set2) {
            arrayList7.add(rVar3.signature);
        }
        ToC = j.r((Iterable) arrayList7);
        AppMethodBeat.o(57565);
    }

    private d() {
    }

    /* JADX INFO: Failed to restore enum class, 'enum' modifier removed */
    public static final class b extends Enum<b> {
        public static final b ToK;
        public static final b ToL;
        public static final b ToM;
        public static final b ToN;
        private static final /* synthetic */ b[] ToO;
        private final Object aEX;

        public static b valueOf(String str) {
            AppMethodBeat.i(57557);
            b bVar = (b) Enum.valueOf(b.class, str);
            AppMethodBeat.o(57557);
            return bVar;
        }

        public static b[] values() {
            AppMethodBeat.i(57556);
            b[] bVarArr = (b[]) ToO.clone();
            AppMethodBeat.o(57556);
            return bVarArr;
        }

        public /* synthetic */ b(String str) {
            this(str, 3, null);
        }

        private b(String str, int i2, Object obj) {
            this.aEX = obj;
        }

        static {
            AppMethodBeat.i(57555);
            b bVar = new b("NULL", 0, null);
            ToK = bVar;
            b bVar2 = new b("INDEX", 1, -1);
            ToL = bVar2;
            b bVar3 = new b("FALSE", 2, Boolean.FALSE);
            ToM = bVar3;
            a aVar = new a("MAP_GET_OR_DEFAULT");
            ToN = aVar;
            ToO = new b[]{bVar, bVar2, bVar3, aVar};
            AppMethodBeat.o(57555);
        }

        static final class a extends b {
            /* JADX WARN: Incorrect args count in method signature: ()V */
            a(String str) {
                super(str);
            }
        }
    }

    public static final t e(t tVar) {
        AppMethodBeat.i(57562);
        p.h(tVar, "functionDescriptor");
        f hAH = tVar.hAH();
        p.g(hAH, "functionDescriptor.name");
        if (!g(hAH)) {
            AppMethodBeat.o(57562);
            return null;
        }
        t tVar2 = (t) kotlin.l.b.a.b.j.d.a.b(tVar, c.ToP);
        AppMethodBeat.o(57562);
        return tVar2;
    }

    public static boolean g(f fVar) {
        AppMethodBeat.i(57563);
        p.h(fVar, "$this$sameAsBuiltinMethodWithErasedValueParameters");
        boolean contains = ToB.contains(fVar);
        AppMethodBeat.o(57563);
        return contains;
    }

    public enum a {
        ONE_COLLECTION_PARAMETER("Ljava/util/Collection<+Ljava/lang/Object;>;", false),
        OBJECT_PARAMETER_NON_GENERIC(null, true),
        OBJECT_PARAMETER_GENERIC("Ljava/lang/Object;", true);
        
        private final String ToI;
        private final boolean ToJ;

        public static a valueOf(String str) {
            AppMethodBeat.i(57554);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(57554);
            return aVar;
        }

        private a(String str, boolean z) {
            this.ToI = str;
            this.ToJ = z;
        }

        static {
            AppMethodBeat.i(57552);
            AppMethodBeat.o(57552);
        }
    }

    public static final a i(kotlin.l.b.a.b.b.b bVar) {
        String c2;
        AppMethodBeat.i(57564);
        p.h(bVar, "$this$getSpecialSignatureInfo");
        if (!ToB.contains(bVar.hAH())) {
            AppMethodBeat.o(57564);
            return null;
        }
        kotlin.l.b.a.b.b.b b2 = kotlin.l.b.a.b.j.d.a.b(bVar, C2288d.ToQ);
        if (b2 == null || (c2 = kotlin.l.b.a.b.d.b.t.c(b2)) == null) {
            AppMethodBeat.o(57564);
            return null;
        } else if (Tox.contains(c2)) {
            a aVar = a.ONE_COLLECTION_PARAMETER;
            AppMethodBeat.o(57564);
            return aVar;
        } else if (((b) ae.e(ToA, c2)) == b.ToK) {
            a aVar2 = a.OBJECT_PARAMETER_GENERIC;
            AppMethodBeat.o(57564);
            return aVar2;
        } else {
            a aVar3 = a.OBJECT_PARAMETER_NON_GENERIC;
            AppMethodBeat.o(57564);
            return aVar3;
        }
    }

    public static final /* synthetic */ boolean j(kotlin.l.b.a.b.b.b bVar) {
        AppMethodBeat.i(57566);
        boolean a2 = j.a(ToC, kotlin.l.b.a.b.d.b.t.c(bVar));
        AppMethodBeat.o(57566);
        return a2;
    }
}
