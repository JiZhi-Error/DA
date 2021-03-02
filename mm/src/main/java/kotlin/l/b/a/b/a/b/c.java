package kotlin.l.b.a.b.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.annotation.Annotation;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import kotlin.a.j;
import kotlin.aa;
import kotlin.g.b.p;
import kotlin.l.b.a.b.a.a.b;
import kotlin.l.b.a.b.a.g;
import kotlin.l.b.a.b.b.e;
import kotlin.l.b.a.b.f.d;
import kotlin.l.b.a.b.f.f;
import kotlin.l.b.a.b.f.h;
import kotlin.n.n;
import kotlin.t;

public final class c {
    private static final String TfN = (b.c.Function.TfF.toString() + "." + b.c.Function.TfG);
    private static final String TfO = (b.c.KFunction.TfF.toString() + "." + b.c.KFunction.TfG);
    private static final String TfP = (b.c.SuspendFunction.TfF.toString() + "." + b.c.SuspendFunction.TfG);
    private static final String TfQ = (b.c.KSuspendFunction.TfF.toString() + "." + b.c.KSuspendFunction.TfG);
    private static final kotlin.l.b.a.b.f.a TfR;
    private static final kotlin.l.b.a.b.f.b TfS;
    private static final kotlin.l.b.a.b.f.a TfT;
    private static final HashMap<kotlin.l.b.a.b.f.c, kotlin.l.b.a.b.f.a> TfU = new HashMap<>();
    private static final HashMap<kotlin.l.b.a.b.f.c, kotlin.l.b.a.b.f.a> TfV = new HashMap<>();
    private static final HashMap<kotlin.l.b.a.b.f.c, kotlin.l.b.a.b.f.b> TfW = new HashMap<>();
    static final HashMap<kotlin.l.b.a.b.f.c, kotlin.l.b.a.b.f.b> TfX = new HashMap<>();
    private static final List<a> TfY;
    public static final c TfZ;

    static {
        AppMethodBeat.i(56767);
        c cVar = new c();
        TfZ = cVar;
        kotlin.l.b.a.b.f.a p = kotlin.l.b.a.b.f.a.p(new kotlin.l.b.a.b.f.b("kotlin.jvm.functions.FunctionN"));
        p.g(p, "ClassId.topLevel(FqName(…vm.functions.FunctionN\"))");
        TfR = p;
        kotlin.l.b.a.b.f.b hJd = p.hJd();
        p.g(hJd, "FUNCTION_N_CLASS_ID.asSingleFqName()");
        TfS = hJd;
        kotlin.l.b.a.b.f.a p2 = kotlin.l.b.a.b.f.a.p(new kotlin.l.b.a.b.f.b("kotlin.reflect.KFunction"));
        p.g(p2, "ClassId.topLevel(FqName(…tlin.reflect.KFunction\"))");
        TfT = p2;
        kotlin.l.b.a.b.f.a p3 = kotlin.l.b.a.b.f.a.p(g.TcO.TdE);
        p.g(p3, "ClassId.topLevel(FQ_NAMES.iterable)");
        kotlin.l.b.a.b.f.b bVar = g.TcO.TdM;
        p.g(bVar, "FQ_NAMES.mutableIterable");
        kotlin.l.b.a.b.f.b hIY = p3.hIY();
        kotlin.l.b.a.b.f.b hIY2 = p3.hIY();
        p.g(hIY2, "kotlinReadOnly.packageFqName");
        kotlin.l.b.a.b.f.a aVar = new kotlin.l.b.a.b.f.a(hIY, d.b(bVar, hIY2), false);
        kotlin.l.b.a.b.f.a p4 = kotlin.l.b.a.b.f.a.p(g.TcO.TdD);
        p.g(p4, "ClassId.topLevel(FQ_NAMES.iterator)");
        kotlin.l.b.a.b.f.b bVar2 = g.TcO.TdL;
        p.g(bVar2, "FQ_NAMES.mutableIterator");
        kotlin.l.b.a.b.f.b hIY3 = p4.hIY();
        kotlin.l.b.a.b.f.b hIY4 = p4.hIY();
        p.g(hIY4, "kotlinReadOnly.packageFqName");
        kotlin.l.b.a.b.f.a aVar2 = new kotlin.l.b.a.b.f.a(hIY3, d.b(bVar2, hIY4), false);
        kotlin.l.b.a.b.f.a p5 = kotlin.l.b.a.b.f.a.p(g.TcO.TdF);
        p.g(p5, "ClassId.topLevel(FQ_NAMES.collection)");
        kotlin.l.b.a.b.f.b bVar3 = g.TcO.TdN;
        p.g(bVar3, "FQ_NAMES.mutableCollection");
        kotlin.l.b.a.b.f.b hIY5 = p5.hIY();
        kotlin.l.b.a.b.f.b hIY6 = p5.hIY();
        p.g(hIY6, "kotlinReadOnly.packageFqName");
        kotlin.l.b.a.b.f.a aVar3 = new kotlin.l.b.a.b.f.a(hIY5, d.b(bVar3, hIY6), false);
        kotlin.l.b.a.b.f.a p6 = kotlin.l.b.a.b.f.a.p(g.TcO.TdG);
        p.g(p6, "ClassId.topLevel(FQ_NAMES.list)");
        kotlin.l.b.a.b.f.b bVar4 = g.TcO.TdO;
        p.g(bVar4, "FQ_NAMES.mutableList");
        kotlin.l.b.a.b.f.b hIY7 = p6.hIY();
        kotlin.l.b.a.b.f.b hIY8 = p6.hIY();
        p.g(hIY8, "kotlinReadOnly.packageFqName");
        kotlin.l.b.a.b.f.a aVar4 = new kotlin.l.b.a.b.f.a(hIY7, d.b(bVar4, hIY8), false);
        kotlin.l.b.a.b.f.a p7 = kotlin.l.b.a.b.f.a.p(g.TcO.TdI);
        p.g(p7, "ClassId.topLevel(FQ_NAMES.set)");
        kotlin.l.b.a.b.f.b bVar5 = g.TcO.TdQ;
        p.g(bVar5, "FQ_NAMES.mutableSet");
        kotlin.l.b.a.b.f.b hIY9 = p7.hIY();
        kotlin.l.b.a.b.f.b hIY10 = p7.hIY();
        p.g(hIY10, "kotlinReadOnly.packageFqName");
        kotlin.l.b.a.b.f.a aVar5 = new kotlin.l.b.a.b.f.a(hIY9, d.b(bVar5, hIY10), false);
        kotlin.l.b.a.b.f.a p8 = kotlin.l.b.a.b.f.a.p(g.TcO.TdH);
        p.g(p8, "ClassId.topLevel(FQ_NAMES.listIterator)");
        kotlin.l.b.a.b.f.b bVar6 = g.TcO.TdP;
        p.g(bVar6, "FQ_NAMES.mutableListIterator");
        kotlin.l.b.a.b.f.b hIY11 = p8.hIY();
        kotlin.l.b.a.b.f.b hIY12 = p8.hIY();
        p.g(hIY12, "kotlinReadOnly.packageFqName");
        kotlin.l.b.a.b.f.a aVar6 = new kotlin.l.b.a.b.f.a(hIY11, d.b(bVar6, hIY12), false);
        kotlin.l.b.a.b.f.a p9 = kotlin.l.b.a.b.f.a.p(g.TcO.TdJ);
        p.g(p9, "ClassId.topLevel(FQ_NAMES.map)");
        kotlin.l.b.a.b.f.b bVar7 = g.TcO.TdR;
        p.g(bVar7, "FQ_NAMES.mutableMap");
        kotlin.l.b.a.b.f.b hIY13 = p9.hIY();
        kotlin.l.b.a.b.f.b hIY14 = p9.hIY();
        p.g(hIY14, "kotlinReadOnly.packageFqName");
        kotlin.l.b.a.b.f.a aVar7 = new kotlin.l.b.a.b.f.a(hIY13, d.b(bVar7, hIY14), false);
        kotlin.l.b.a.b.f.a o = kotlin.l.b.a.b.f.a.p(g.TcO.TdJ).o(g.TcO.TdK.hJg());
        p.g(o, "ClassId.topLevel(FQ_NAME…MES.mapEntry.shortName())");
        kotlin.l.b.a.b.f.b bVar8 = g.TcO.TdS;
        p.g(bVar8, "FQ_NAMES.mutableMapEntry");
        kotlin.l.b.a.b.f.b hIY15 = o.hIY();
        kotlin.l.b.a.b.f.b hIY16 = o.hIY();
        p.g(hIY16, "kotlinReadOnly.packageFqName");
        TfY = j.listOf((Object[]) new a[]{new a(cVar.bu(Iterable.class), p3, aVar), new a(cVar.bu(Iterator.class), p4, aVar2), new a(cVar.bu(Collection.class), p5, aVar3), new a(cVar.bu(List.class), p6, aVar4), new a(cVar.bu(Set.class), p7, aVar5), new a(cVar.bu(ListIterator.class), p8, aVar6), new a(cVar.bu(Map.class), p9, aVar7), new a(cVar.bu(Map.Entry.class), o, new kotlin.l.b.a.b.f.a(hIY15, d.b(bVar8, hIY16), false))});
        kotlin.l.b.a.b.f.c cVar2 = g.TcO.TcS;
        p.g(cVar2, "FQ_NAMES.any");
        cVar.a(Object.class, cVar2);
        kotlin.l.b.a.b.f.c cVar3 = g.TcO.TcY;
        p.g(cVar3, "FQ_NAMES.string");
        cVar.a(String.class, cVar3);
        kotlin.l.b.a.b.f.c cVar4 = g.TcO.TcX;
        p.g(cVar4, "FQ_NAMES.charSequence");
        cVar.a(CharSequence.class, cVar4);
        kotlin.l.b.a.b.f.b bVar9 = g.TcO.Tdl;
        p.g(bVar9, "FQ_NAMES.throwable");
        cVar.a(Throwable.class, bVar9);
        kotlin.l.b.a.b.f.c cVar5 = g.TcO.TcU;
        p.g(cVar5, "FQ_NAMES.cloneable");
        cVar.a(Cloneable.class, cVar5);
        kotlin.l.b.a.b.f.c cVar6 = g.TcO.Tdi;
        p.g(cVar6, "FQ_NAMES.number");
        cVar.a(Number.class, cVar6);
        kotlin.l.b.a.b.f.b bVar10 = g.TcO.Tdm;
        p.g(bVar10, "FQ_NAMES.comparable");
        cVar.a(Comparable.class, bVar10);
        kotlin.l.b.a.b.f.c cVar7 = g.TcO.Tdj;
        p.g(cVar7, "FQ_NAMES._enum");
        cVar.a(Enum.class, cVar7);
        kotlin.l.b.a.b.f.b bVar11 = g.TcO.Tdu;
        p.g(bVar11, "FQ_NAMES.annotation");
        cVar.a(Annotation.class, bVar11);
        for (a aVar8 : TfY) {
            kotlin.l.b.a.b.f.a aVar9 = aVar8.Tga;
            kotlin.l.b.a.b.f.a aVar10 = aVar8.Tgb;
            kotlin.l.b.a.b.f.a aVar11 = aVar8.Tgc;
            a(aVar9, aVar10);
            kotlin.l.b.a.b.f.b hJd2 = aVar11.hJd();
            p.g(hJd2, "mutableClassId.asSingleFqName()");
            a(hJd2, aVar9);
            kotlin.l.b.a.b.f.b hJd3 = aVar10.hJd();
            p.g(hJd3, "readOnlyClassId.asSingleFqName()");
            kotlin.l.b.a.b.f.b hJd4 = aVar11.hJd();
            p.g(hJd4, "mutableClassId.asSingleFqName()");
            kotlin.l.b.a.b.f.c hJe = aVar11.hJd().hJe();
            p.g(hJe, "mutableClassId.asSingleFqName().toUnsafe()");
            TfW.put(hJe, hJd3);
            kotlin.l.b.a.b.f.c hJe2 = hJd3.hJe();
            p.g(hJe2, "readOnlyFqName.toUnsafe()");
            TfX.put(hJe2, hJd4);
        }
        kotlin.l.b.a.b.j.e.d[] values = kotlin.l.b.a.b.j.e.d.values();
        for (kotlin.l.b.a.b.j.e.d dVar : values) {
            kotlin.l.b.a.b.f.a p10 = kotlin.l.b.a.b.f.a.p(dVar.hKL());
            p.g(p10, "ClassId.topLevel(jvmType.wrapperFqName)");
            kotlin.l.b.a.b.f.a p11 = kotlin.l.b.a.b.f.a.p(g.c(dVar.hKJ()));
            p.g(p11, "ClassId.topLevel(KotlinB…e(jvmType.primitiveType))");
            a(p10, p11);
        }
        kotlin.l.b.a.b.a.c cVar8 = kotlin.l.b.a.b.a.c.Tcz;
        for (kotlin.l.b.a.b.f.a aVar12 : kotlin.l.b.a.b.a.c.hza()) {
            kotlin.l.b.a.b.f.a p12 = kotlin.l.b.a.b.f.a.p(new kotlin.l.b.a.b.f.b("kotlin.jvm.internal." + aVar12.hJa().sG() + "CompanionObject"));
            p.g(p12, "ClassId.topLevel(FqName(…g() + \"CompanionObject\"))");
            kotlin.l.b.a.b.f.a o2 = aVar12.o(h.TDf);
            p.g(o2, "classId.createNestedClas…AME_FOR_COMPANION_OBJECT)");
            a(p12, o2);
        }
        for (int i2 = 0; i2 < 23; i2++) {
            kotlin.l.b.a.b.f.a p13 = kotlin.l.b.a.b.f.a.p(new kotlin.l.b.a.b.f.b("kotlin.jvm.functions.Function".concat(String.valueOf(i2))));
            p.g(p13, "ClassId.topLevel(FqName(…m.functions.Function$i\"))");
            kotlin.l.b.a.b.f.a atO = g.atO(i2);
            p.g(atO, "KotlinBuiltIns.getFunctionClassId(i)");
            a(p13, atO);
            a(new kotlin.l.b.a.b.f.b(TfO + i2), TfT);
        }
        for (int i3 = 0; i3 < 22; i3++) {
            b.c cVar9 = b.c.KSuspendFunction;
            a(new kotlin.l.b.a.b.f.b((cVar9.TfF.toString() + "." + cVar9.TfG) + i3), TfT);
        }
        kotlin.l.b.a.b.f.b hJj = g.TcO.TcT.hJj();
        p.g(hJj, "FQ_NAMES.nothing.toSafe()");
        a(hJj, cVar.bu(Void.class));
        AppMethodBeat.o(56767);
    }

    private c() {
    }

    public static kotlin.l.b.a.b.f.b hAa() {
        return TfS;
    }

    public static final class a {
        public final kotlin.l.b.a.b.f.a Tga;
        final kotlin.l.b.a.b.f.a Tgb;
        final kotlin.l.b.a.b.f.a Tgc;

        /* JADX WARNING: Code restructure failed: missing block: B:9:0x002a, code lost:
            if (kotlin.g.b.p.j(r3.Tgc, r4.Tgc) != false) goto L_0x002c;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean equals(java.lang.Object r4) {
            /*
                r3 = this;
                r2 = 56752(0xddb0, float:7.9526E-41)
                com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
                if (r3 == r4) goto L_0x002c
                boolean r0 = r4 instanceof kotlin.l.b.a.b.a.b.c.a
                if (r0 == 0) goto L_0x0031
                kotlin.l.b.a.b.a.b.c$a r4 = (kotlin.l.b.a.b.a.b.c.a) r4
                kotlin.l.b.a.b.f.a r0 = r3.Tga
                kotlin.l.b.a.b.f.a r1 = r4.Tga
                boolean r0 = kotlin.g.b.p.j(r0, r1)
                if (r0 == 0) goto L_0x0031
                kotlin.l.b.a.b.f.a r0 = r3.Tgb
                kotlin.l.b.a.b.f.a r1 = r4.Tgb
                boolean r0 = kotlin.g.b.p.j(r0, r1)
                if (r0 == 0) goto L_0x0031
                kotlin.l.b.a.b.f.a r0 = r3.Tgc
                kotlin.l.b.a.b.f.a r1 = r4.Tgc
                boolean r0 = kotlin.g.b.p.j(r0, r1)
                if (r0 == 0) goto L_0x0031
            L_0x002c:
                r0 = 1
                com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            L_0x0030:
                return r0
            L_0x0031:
                r0 = 0
                com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
                goto L_0x0030
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.l.b.a.b.a.b.c.a.equals(java.lang.Object):boolean");
        }

        public final int hashCode() {
            int i2 = 0;
            AppMethodBeat.i(56751);
            kotlin.l.b.a.b.f.a aVar = this.Tga;
            int hashCode = (aVar != null ? aVar.hashCode() : 0) * 31;
            kotlin.l.b.a.b.f.a aVar2 = this.Tgb;
            int hashCode2 = ((aVar2 != null ? aVar2.hashCode() : 0) + hashCode) * 31;
            kotlin.l.b.a.b.f.a aVar3 = this.Tgc;
            if (aVar3 != null) {
                i2 = aVar3.hashCode();
            }
            int i3 = hashCode2 + i2;
            AppMethodBeat.o(56751);
            return i3;
        }

        public final String toString() {
            AppMethodBeat.i(56750);
            String str = "PlatformMutabilityMapping(javaClass=" + this.Tga + ", kotlinReadOnly=" + this.Tgb + ", kotlinMutable=" + this.Tgc + ")";
            AppMethodBeat.o(56750);
            return str;
        }

        public a(kotlin.l.b.a.b.f.a aVar, kotlin.l.b.a.b.f.a aVar2, kotlin.l.b.a.b.f.a aVar3) {
            p.h(aVar, "javaClass");
            p.h(aVar2, "kotlinReadOnly");
            p.h(aVar3, "kotlinMutable");
            AppMethodBeat.i(56749);
            this.Tga = aVar;
            this.Tgb = aVar2;
            this.Tgc = aVar3;
            AppMethodBeat.o(56749);
        }
    }

    public static List<a> hAb() {
        return TfY;
    }

    public static kotlin.l.b.a.b.f.a c(kotlin.l.b.a.b.f.b bVar) {
        AppMethodBeat.i(56753);
        p.h(bVar, "fqName");
        kotlin.l.b.a.b.f.a aVar = TfU.get(bVar.hJe());
        AppMethodBeat.o(56753);
        return aVar;
    }

    public static /* synthetic */ e a(kotlin.l.b.a.b.f.b bVar, g gVar) {
        AppMethodBeat.i(56754);
        p.h(bVar, "fqName");
        p.h(gVar, "builtIns");
        kotlin.l.b.a.b.f.a c2 = c(bVar);
        if (c2 != null) {
            e a2 = gVar.a(c2.hJd());
            AppMethodBeat.o(56754);
            return a2;
        }
        AppMethodBeat.o(56754);
        return null;
    }

    public static kotlin.l.b.a.b.f.a c(kotlin.l.b.a.b.f.c cVar) {
        AppMethodBeat.i(56755);
        p.h(cVar, "kotlinFqName");
        if (a(cVar, TfN)) {
            kotlin.l.b.a.b.f.a aVar = TfR;
            AppMethodBeat.o(56755);
            return aVar;
        } else if (a(cVar, TfP)) {
            kotlin.l.b.a.b.f.a aVar2 = TfR;
            AppMethodBeat.o(56755);
            return aVar2;
        } else if (a(cVar, TfO)) {
            kotlin.l.b.a.b.f.a aVar3 = TfT;
            AppMethodBeat.o(56755);
            return aVar3;
        } else if (a(cVar, TfQ)) {
            kotlin.l.b.a.b.f.a aVar4 = TfT;
            AppMethodBeat.o(56755);
            return aVar4;
        } else {
            kotlin.l.b.a.b.f.a aVar5 = TfV.get(cVar);
            AppMethodBeat.o(56755);
            return aVar5;
        }
    }

    private static boolean a(kotlin.l.b.a.b.f.c cVar, String str) {
        boolean z;
        AppMethodBeat.i(56756);
        String sG = cVar.sG();
        p.g(sG, "kotlinFqName.asString()");
        String bA = n.bA(sG, str, "");
        if (bA.length() > 0) {
            z = true;
        } else {
            z = false;
        }
        if (!z || n.aP(bA)) {
            AppMethodBeat.o(56756);
            return false;
        }
        Integer buA = n.buA(bA);
        if (buA == null || buA.intValue() < 23) {
            AppMethodBeat.o(56756);
            return false;
        }
        AppMethodBeat.o(56756);
        return true;
    }

    private final void a(Class<?> cls, kotlin.l.b.a.b.f.c cVar) {
        AppMethodBeat.i(56758);
        kotlin.l.b.a.b.f.b hJj = cVar.hJj();
        p.g(hJj, "kotlinFqName.toSafe()");
        a(cls, hJj);
        AppMethodBeat.o(56758);
    }

    private final void a(Class<?> cls, kotlin.l.b.a.b.f.b bVar) {
        AppMethodBeat.i(56759);
        kotlin.l.b.a.b.f.a bu = bu(cls);
        kotlin.l.b.a.b.f.a p = kotlin.l.b.a.b.f.a.p(bVar);
        p.g(p, "ClassId.topLevel(kotlinFqName)");
        a(bu, p);
        AppMethodBeat.o(56759);
    }

    private static void a(kotlin.l.b.a.b.f.b bVar, kotlin.l.b.a.b.f.a aVar) {
        AppMethodBeat.i(56760);
        kotlin.l.b.a.b.f.c hJe = bVar.hJe();
        p.g(hJe, "kotlinFqNameUnsafe.toUnsafe()");
        TfV.put(hJe, aVar);
        AppMethodBeat.o(56760);
    }

    public static boolean h(e eVar) {
        AppMethodBeat.i(56761);
        p.h(eVar, "mutable");
        kotlin.l.b.a.b.f.c n = kotlin.l.b.a.b.j.c.n(eVar);
        HashMap<kotlin.l.b.a.b.f.c, kotlin.l.b.a.b.f.b> hashMap = TfW;
        if (hashMap == null) {
            t tVar = new t("null cannot be cast to non-null type kotlin.collections.Map<K, *>");
            AppMethodBeat.o(56761);
            throw tVar;
        }
        boolean containsKey = hashMap.containsKey(n);
        AppMethodBeat.o(56761);
        return containsKey;
    }

    public static boolean i(e eVar) {
        AppMethodBeat.i(56762);
        p.h(eVar, "readOnly");
        kotlin.l.b.a.b.f.c n = kotlin.l.b.a.b.j.c.n(eVar);
        HashMap<kotlin.l.b.a.b.f.c, kotlin.l.b.a.b.f.b> hashMap = TfX;
        if (hashMap == null) {
            t tVar = new t("null cannot be cast to non-null type kotlin.collections.Map<K, *>");
            AppMethodBeat.o(56762);
            throw tVar;
        }
        boolean containsKey = hashMap.containsKey(n);
        AppMethodBeat.o(56762);
        return containsKey;
    }

    public static e j(e eVar) {
        AppMethodBeat.i(56763);
        p.h(eVar, "mutable");
        e a2 = a(eVar, TfW, "mutable");
        AppMethodBeat.o(56763);
        return a2;
    }

    public static e k(e eVar) {
        AppMethodBeat.i(56764);
        p.h(eVar, "readOnly");
        e a2 = a(eVar, TfX, "read-only");
        AppMethodBeat.o(56764);
        return a2;
    }

    private final kotlin.l.b.a.b.f.a bu(Class<?> cls) {
        AppMethodBeat.i(56765);
        boolean z = !cls.isPrimitive() && !cls.isArray();
        if (!aa.SXc || z) {
            Class<?> declaringClass = cls.getDeclaringClass();
            if (declaringClass == null) {
                kotlin.l.b.a.b.f.a p = kotlin.l.b.a.b.f.a.p(new kotlin.l.b.a.b.f.b(cls.getCanonicalName()));
                p.g(p, "ClassId.topLevel(FqName(clazz.canonicalName))");
                AppMethodBeat.o(56765);
                return p;
            }
            kotlin.l.b.a.b.f.a o = bu(declaringClass).o(f.btY(cls.getSimpleName()));
            p.g(o, "classId(outer).createNes…tifier(clazz.simpleName))");
            AppMethodBeat.o(56765);
            return o;
        }
        AssertionError assertionError = new AssertionError("Invalid class: ".concat(String.valueOf(cls)));
        AppMethodBeat.o(56765);
        throw assertionError;
    }

    private static e a(e eVar, Map<kotlin.l.b.a.b.f.c, kotlin.l.b.a.b.f.b> map, String str) {
        AppMethodBeat.i(56766);
        kotlin.l.b.a.b.f.b bVar = map.get(kotlin.l.b.a.b.j.c.n(eVar));
        if (bVar == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Given class " + eVar + " is not a " + str + " collection");
            AppMethodBeat.o(56766);
            throw illegalArgumentException;
        }
        e a2 = kotlin.l.b.a.b.j.d.a.G(eVar).a(bVar);
        p.g(a2, "descriptor.builtIns.getB…Name(oppositeClassFqName)");
        AppMethodBeat.o(56766);
        return a2;
    }

    private static void a(kotlin.l.b.a.b.f.a aVar, kotlin.l.b.a.b.f.a aVar2) {
        AppMethodBeat.i(56757);
        kotlin.l.b.a.b.f.c hJe = aVar.hJd().hJe();
        p.g(hJe, "javaClassId.asSingleFqName().toUnsafe()");
        TfU.put(hJe, aVar2);
        kotlin.l.b.a.b.f.b hJd = aVar2.hJd();
        p.g(hJd, "kotlinClassId.asSingleFqName()");
        a(hJd, aVar);
        AppMethodBeat.o(56757);
    }
}
