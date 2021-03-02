package kotlin.l.b.a.b.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.rtmp.sharp.jni.QLog;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.a.ak;
import kotlin.a.x;
import kotlin.g.b.aa;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.g.b.y;
import kotlin.g.b.z;
import kotlin.l.b.a.b.a.b.d;
import kotlin.l.b.a.b.b.a.g;
import kotlin.l.b.a.b.b.am;
import kotlin.l.b.a.b.b.an;
import kotlin.l.b.a.b.b.b;
import kotlin.l.b.a.b.b.s;
import kotlin.l.b.a.b.b.w;
import kotlin.l.b.a.b.d.b.v;
import kotlin.l.b.a.b.j.f.h;
import kotlin.l.b.a.b.j.i;
import kotlin.l.b.a.b.m.ab;
import kotlin.l.b.a.b.m.ae;
import kotlin.l.b.a.b.m.aj;
import kotlin.l.b.a.b.m.at;
import kotlin.l.b.a.b.m.ba;
import kotlin.l.b.a.b.o.b;
import kotlin.t;

public class h implements kotlin.l.b.a.b.b.b.a, kotlin.l.b.a.b.b.b.c {
    private static final Set<String> TgD = ak.c(v.s("Collection", "toArray()[Ljava/lang/Object;", "toArray([Ljava/lang/Object;)[Ljava/lang/Object;"), "java/lang/annotation/Annotation.annotationType()Ljava/lang/Class;");
    private static final Set<String> TgE;
    private static final Set<String> TgF = ak.b(ak.b(ak.b(ak.b(ak.b(ak.b(v.r("CharSequence", "codePoints()Ljava/util/stream/IntStream;", "chars()Ljava/util/stream/IntStream;"), v.s("Iterator", "forEachRemaining(Ljava/util/function/Consumer;)V")), v.r("Iterable", "forEach(Ljava/util/function/Consumer;)V", "spliterator()Ljava/util/Spliterator;")), v.r("Throwable", "setStackTrace([Ljava/lang/StackTraceElement;)V", "fillInStackTrace()Ljava/lang/Throwable;", "getLocalizedMessage()Ljava/lang/String;", "printStackTrace()V", "printStackTrace(Ljava/io/PrintStream;)V", "printStackTrace(Ljava/io/PrintWriter;)V", "getStackTrace()[Ljava/lang/StackTraceElement;", "initCause(Ljava/lang/Throwable;)Ljava/lang/Throwable;", "getSuppressed()[Ljava/lang/Throwable;", "addSuppressed(Ljava/lang/Throwable;)V")), v.s("Collection", "spliterator()Ljava/util/Spliterator;", "parallelStream()Ljava/util/stream/Stream;", "stream()Ljava/util/stream/Stream;", "removeIf(Ljava/util/function/Predicate;)Z")), v.s("List", "replaceAll(Ljava/util/function/UnaryOperator;)V")), v.s("Map", "getOrDefault(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "forEach(Ljava/util/function/BiConsumer;)V", "replaceAll(Ljava/util/function/BiFunction;)V", "merge(Ljava/lang/Object;Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "computeIfPresent(Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "putIfAbsent(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "replace(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Z", "replace(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "computeIfAbsent(Ljava/lang/Object;Ljava/util/function/Function;)Ljava/lang/Object;", "compute(Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;"));
    private static final Set<String> TgG = ak.b(ak.b(v.s("Collection", "removeIf(Ljava/util/function/Predicate;)Z"), v.s("List", "replaceAll(Ljava/util/function/UnaryOperator;)V", "sort(Ljava/util/Comparator;)V")), v.s("Map", "computeIfAbsent(Ljava/lang/Object;Ljava/util/function/Function;)Ljava/lang/Object;", "computeIfPresent(Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "compute(Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "merge(Ljava/lang/Object;Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "putIfAbsent(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "remove(Ljava/lang/Object;Ljava/lang/Object;)Z", "replaceAll(Ljava/util/function/BiFunction;)V", "replace(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "replace(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Z"));
    private static final Set<String> TgH;
    private static final Set<String> TgI;
    public static final a TgJ = new a((byte) 0);
    static final /* synthetic */ kotlin.l.k[] cLI = {aa.a(new y(aa.bp(h.class), "cloneableType", "getCloneableType()Lorg/jetbrains/kotlin/types/SimpleType;")), aa.a(new y(aa.bp(h.class), "notConsideredDeprecation", "getNotConsideredDeprecation()Lorg/jetbrains/kotlin/descriptors/annotations/Annotations;"))};
    private final kotlin.l.b.a.b.l.f TgA;
    private final kotlin.l.b.a.b.l.a<kotlin.l.b.a.b.f.b, kotlin.l.b.a.b.b.e> TgB;
    private final kotlin.l.b.a.b.l.f TgC;
    private final kotlin.l.b.a.b.b.y Tge;
    private final c Tgw = c.TfZ;
    private final kotlin.f Tgx;
    private final kotlin.f Tgy;
    private final ab Tgz;

    enum b {
        BLACK_LIST,
        WHITE_LIST,
        NOT_CONSIDERED,
        DROP;

        static {
            AppMethodBeat.i(56796);
            AppMethodBeat.o(56796);
        }

        public static b valueOf(String str) {
            AppMethodBeat.i(56798);
            b bVar = (b) Enum.valueOf(b.class, str);
            AppMethodBeat.o(56798);
            return bVar;
        }
    }

    private final kotlin.l.b.a.b.b.y hAh() {
        AppMethodBeat.i(56813);
        kotlin.l.b.a.b.b.y yVar = (kotlin.l.b.a.b.b.y) this.Tgx.getValue();
        AppMethodBeat.o(56813);
        return yVar;
    }

    private final boolean hAi() {
        AppMethodBeat.i(56814);
        boolean booleanValue = ((Boolean) this.Tgy.getValue()).booleanValue();
        AppMethodBeat.o(56814);
        return booleanValue;
    }

    private final aj hAj() {
        AppMethodBeat.i(56815);
        aj ajVar = (aj) kotlin.l.b.a.b.l.i.a(this.TgA, cLI[0]);
        AppMethodBeat.o(56815);
        return ajVar;
    }

    private final kotlin.l.b.a.b.b.a.g hAk() {
        AppMethodBeat.i(56816);
        kotlin.l.b.a.b.b.a.g gVar = (kotlin.l.b.a.b.b.a.g) kotlin.l.b.a.b.l.i.a(this.TgC, cLI[1]);
        AppMethodBeat.o(56816);
        return gVar;
    }

    static final class g extends q implements kotlin.g.a.m<kotlin.l.b.a.b.b.k, kotlin.l.b.a.b.b.k, Boolean> {
        final /* synthetic */ ba TgS;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(ba baVar) {
            super(2);
            this.TgS = baVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.m
        public final /* synthetic */ Boolean invoke(kotlin.l.b.a.b.b.k kVar, kotlin.l.b.a.b.b.k kVar2) {
            AppMethodBeat.i(56803);
            Boolean valueOf = Boolean.valueOf(a(kVar, kVar2));
            AppMethodBeat.o(56803);
            return valueOf;
        }

        public final boolean a(kotlin.l.b.a.b.b.k kVar, kotlin.l.b.a.b.b.k kVar2) {
            AppMethodBeat.i(56804);
            p.h(kVar, "$this$isEffectivelyTheSameAs");
            p.h(kVar2, "javaConstructor");
            if (kotlin.l.b.a.b.j.i.f(kVar, kVar2.b(this.TgS)) == i.a.EnumC2349a.OVERRIDABLE) {
                AppMethodBeat.o(56804);
                return true;
            }
            AppMethodBeat.o(56804);
            return false;
        }
    }

    /* renamed from: kotlin.l.b.a.b.a.b.h$h  reason: collision with other inner class name */
    static final class C2275h extends q implements kotlin.g.a.b<kotlin.l.b.a.b.j.f.h, Collection<? extends am>> {
        final /* synthetic */ kotlin.l.b.a.b.f.f TgT;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C2275h(kotlin.l.b.a.b.f.f fVar) {
            super(1);
            this.TgT = fVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ Collection<? extends am> invoke(kotlin.l.b.a.b.j.f.h hVar) {
            AppMethodBeat.i(56805);
            kotlin.l.b.a.b.j.f.h hVar2 = hVar;
            p.h(hVar2, LocaleUtil.ITALIAN);
            Collection<? extends am> b2 = hVar2.b(this.TgT, kotlin.l.b.a.b.c.a.c.FROM_BUILTINS);
            AppMethodBeat.o(56805);
            return b2;
        }
    }

    static final class i<N> implements b.AbstractC2365b<N> {
        final /* synthetic */ h TgP;

        i(h hVar) {
            this.TgP = hVar;
        }

        @Override // kotlin.l.b.a.b.o.b.AbstractC2365b
        public final /* synthetic */ Iterable fl(Object obj) {
            kotlin.l.b.a.b.b.h hVar;
            kotlin.l.b.a.b.d.a.c.a.f fVar;
            AppMethodBeat.i(56806);
            kotlin.l.b.a.b.b.e eVar = (kotlin.l.b.a.b.b.e) obj;
            p.g(eVar, LocaleUtil.ITALIAN);
            at hzz = eVar.hzz();
            p.g(hzz, "it.typeConstructor");
            Collection<ab> hBV = hzz.hBV();
            p.g(hBV, "it.typeConstructor.supertypes");
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = hBV.iterator();
            while (it.hasNext()) {
                kotlin.l.b.a.b.b.h hzS = it.next().hKE().hzS();
                if (hzS != null) {
                    hVar = hzS.hAF();
                } else {
                    hVar = null;
                }
                if (!(hVar instanceof kotlin.l.b.a.b.b.e)) {
                    hVar = null;
                }
                kotlin.l.b.a.b.b.e eVar2 = (kotlin.l.b.a.b.b.e) hVar;
                if (eVar2 != null) {
                    fVar = h.a(this.TgP, eVar2);
                } else {
                    fVar = null;
                }
                if (fVar != null) {
                    arrayList.add(fVar);
                }
            }
            ArrayList arrayList2 = arrayList;
            AppMethodBeat.o(56806);
            return arrayList2;
        }
    }

    static final class k<N> implements b.AbstractC2365b<N> {
        public static final k TgV = new k();

        static {
            AppMethodBeat.i(56809);
            AppMethodBeat.o(56809);
        }

        k() {
        }

        @Override // kotlin.l.b.a.b.o.b.AbstractC2365b
        public final /* synthetic */ Iterable fl(Object obj) {
            AppMethodBeat.i(56808);
            kotlin.l.b.a.b.b.b bVar = (kotlin.l.b.a.b.b.b) obj;
            p.g(bVar, LocaleUtil.ITALIAN);
            kotlin.l.b.a.b.b.b hAz = bVar.hAz();
            p.g(hAz, "it.original");
            Collection<? extends kotlin.l.b.a.b.b.b> hAy = hAz.hAy();
            AppMethodBeat.o(56808);
            return hAy;
        }
    }

    static final class l extends q implements kotlin.g.a.b<kotlin.l.b.a.b.b.b, Boolean> {
        final /* synthetic */ h TgP;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        l(h hVar) {
            super(1);
            this.TgP = hVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ Boolean invoke(kotlin.l.b.a.b.b.b bVar) {
            boolean z;
            AppMethodBeat.i(56810);
            kotlin.l.b.a.b.b.b bVar2 = bVar;
            p.g(bVar2, "overridden");
            if (bVar2.hAA() == b.a.DECLARATION) {
                c unused = this.TgP.Tgw;
                kotlin.l.b.a.b.b.l hzx = bVar2.hzx();
                if (hzx == null) {
                    t tVar = new t("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                    AppMethodBeat.o(56810);
                    throw tVar;
                } else if (c.h((kotlin.l.b.a.b.b.e) hzx)) {
                    z = true;
                    Boolean valueOf = Boolean.valueOf(z);
                    AppMethodBeat.o(56810);
                    return valueOf;
                }
            }
            z = false;
            Boolean valueOf2 = Boolean.valueOf(z);
            AppMethodBeat.o(56810);
            return valueOf2;
        }
    }

    public h(kotlin.l.b.a.b.b.y yVar, kotlin.l.b.a.b.l.j jVar, kotlin.g.a.a<? extends kotlin.l.b.a.b.b.y> aVar, kotlin.g.a.a<Boolean> aVar2) {
        p.h(yVar, "moduleDescriptor");
        p.h(jVar, "storageManager");
        p.h(aVar, "deferredOwnerModuleDescriptor");
        p.h(aVar2, "isAdditionalBuiltInsFeatureSupported");
        AppMethodBeat.i(56823);
        this.Tge = yVar;
        this.Tgx = kotlin.g.ah(aVar);
        this.Tgy = kotlin.g.ah(aVar2);
        kotlin.l.b.a.b.b.c.h hVar = new kotlin.l.b.a.b.b.c.h(new d(this, this.Tge, new kotlin.l.b.a.b.f.b("java.io")), kotlin.l.b.a.b.f.f.btY("Serializable"), w.ABSTRACT, kotlin.l.b.a.b.b.f.INTERFACE, kotlin.a.j.listOf(new ae(jVar, new e(this))), an.ThK, jVar);
        hVar.a(h.b.TKa, x.SXt, null);
        aj hAG = hVar.hAG();
        p.g(hAG, "mockSerializableClass.defaultType");
        this.Tgz = hAG;
        this.TgA = jVar.al(new c(this, jVar));
        this.TgB = jVar.hLs();
        this.TgC = jVar.al(new m(this));
        AppMethodBeat.o(56823);
    }

    public static final /* synthetic */ kotlin.l.b.a.b.d.a.c.a.f a(h hVar, kotlin.l.b.a.b.b.e eVar) {
        AppMethodBeat.i(56824);
        kotlin.l.b.a.b.d.a.c.a.f n = hVar.n(eVar);
        AppMethodBeat.o(56824);
        return n;
    }

    public static final /* synthetic */ kotlin.l.b.a.b.b.y c(h hVar) {
        AppMethodBeat.i(56825);
        kotlin.l.b.a.b.b.y hAh = hVar.hAh();
        AppMethodBeat.o(56825);
        return hAh;
    }

    @Override // kotlin.l.b.a.b.b.b.a
    public final /* synthetic */ Collection m(kotlin.l.b.a.b.b.e eVar) {
        x xVar;
        kotlin.l.b.a.b.d.a.c.a.g hDO;
        AppMethodBeat.i(56819);
        p.h(eVar, "classDescriptor");
        if (!hAi()) {
            xVar = x.SXt;
        } else {
            kotlin.l.b.a.b.d.a.c.a.f n = n(eVar);
            if (n == null || (hDO = n.hDO()) == null || (xVar = hDO.hCa()) == null) {
                xVar = x.SXt;
            }
        }
        Set<kotlin.l.b.a.b.f.f> set = xVar;
        AppMethodBeat.o(56819);
        return set;
    }

    public static final class d extends kotlin.l.b.a.b.b.c.y {
        final /* synthetic */ h TgP;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(h hVar, kotlin.l.b.a.b.b.y yVar, kotlin.l.b.a.b.f.b bVar) {
            super(yVar, bVar);
            this.TgP = hVar;
        }

        @Override // kotlin.l.b.a.b.b.ab
        public final /* bridge */ /* synthetic */ kotlin.l.b.a.b.j.f.h hAp() {
            return h.b.TKa;
        }
    }

    @Override // kotlin.l.b.a.b.b.b.a
    public final Collection<ab> l(kotlin.l.b.a.b.b.e eVar) {
        AppMethodBeat.i(56817);
        p.h(eVar, "classDescriptor");
        kotlin.l.b.a.b.f.c q = kotlin.l.b.a.b.j.d.a.q(eVar);
        if (a.e(q)) {
            aj hAj = hAj();
            p.g(hAj, "cloneableType");
            List listOf = kotlin.a.j.listOf((Object[]) new ab[]{hAj, this.Tgz});
            AppMethodBeat.o(56817);
            return listOf;
        } else if (a.d(q)) {
            List listOf2 = kotlin.a.j.listOf(this.Tgz);
            AppMethodBeat.o(56817);
            return listOf2;
        } else {
            kotlin.a.v vVar = kotlin.a.v.SXr;
            AppMethodBeat.o(56817);
            return vVar;
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x0210 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x02b4  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x0371  */
    @Override // kotlin.l.b.a.b.b.b.a
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.Collection<kotlin.l.b.a.b.b.am> a(kotlin.l.b.a.b.f.f r12, kotlin.l.b.a.b.b.e r13) {
        /*
        // Method dump skipped, instructions count: 952
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.l.b.a.b.a.b.h.a(kotlin.l.b.a.b.f.f, kotlin.l.b.a.b.b.e):java.util.Collection");
    }

    public static final class j extends b.a<kotlin.l.b.a.b.b.e, b> {
        final /* synthetic */ String TgU;
        final /* synthetic */ z.f wJX;

        j(String str, z.f fVar) {
            this.TgU = str;
            this.wJX = fVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.l.b.a.b.o.b.a, kotlin.l.b.a.b.o.b.c
        public final /* synthetic */ boolean fm(kotlin.l.b.a.b.b.e eVar) {
            AppMethodBeat.i(56807);
            kotlin.l.b.a.b.b.e eVar2 = eVar;
            p.h(eVar2, "javaClassDescriptor");
            v vVar = v.TvS;
            String a2 = v.a(eVar2, this.TgU);
            a aVar = h.TgJ;
            if (h.TgE.contains(a2)) {
                this.wJX.SYG = (T) b.BLACK_LIST;
            } else {
                a aVar2 = h.TgJ;
                if (h.TgF.contains(a2)) {
                    this.wJX.SYG = (T) b.WHITE_LIST;
                } else {
                    a aVar3 = h.TgJ;
                    if (h.TgD.contains(a2)) {
                        this.wJX.SYG = (T) b.DROP;
                    }
                }
            }
            if (this.wJX.SYG == null) {
                AppMethodBeat.o(56807);
                return true;
            }
            AppMethodBeat.o(56807);
            return false;
        }

        @Override // kotlin.l.b.a.b.o.b.c
        public final /* bridge */ /* synthetic */ Object hAq() {
            T t = this.wJX.SYG;
            return t == null ? b.NOT_CONSIDERED : t;
        }
    }

    private final kotlin.l.b.a.b.d.a.c.a.f n(kotlin.l.b.a.b.b.e eVar) {
        kotlin.l.b.a.b.f.b hJd;
        AppMethodBeat.i(56820);
        if (kotlin.l.b.a.b.a.g.f(eVar)) {
            AppMethodBeat.o(56820);
            return null;
        } else if (!kotlin.l.b.a.b.a.g.d((kotlin.l.b.a.b.b.l) eVar)) {
            AppMethodBeat.o(56820);
            return null;
        } else {
            kotlin.l.b.a.b.f.c q = kotlin.l.b.a.b.j.d.a.q(eVar);
            if (!q.hJi()) {
                AppMethodBeat.o(56820);
                return null;
            }
            kotlin.l.b.a.b.f.a c2 = c.c(q);
            if (c2 == null || (hJd = c2.hJd()) == null) {
                AppMethodBeat.o(56820);
                return null;
            }
            p.g(hJd, "j2kClassMap.mapKotlinToJ…leFqName() ?: return null");
            kotlin.l.b.a.b.b.e a2 = kotlin.l.b.a.b.b.q.a(hAh(), hJd, kotlin.l.b.a.b.c.a.c.FROM_BUILTINS);
            if (!(a2 instanceof kotlin.l.b.a.b.d.a.c.a.f)) {
                a2 = null;
            }
            kotlin.l.b.a.b.d.a.c.a.f fVar = (kotlin.l.b.a.b.d.a.c.a.f) a2;
            AppMethodBeat.o(56820);
            return fVar;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x00d3  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x013f  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0142  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x007b A[SYNTHETIC] */
    @Override // kotlin.l.b.a.b.b.b.a
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.Collection<kotlin.l.b.a.b.b.d> o(kotlin.l.b.a.b.b.e r14) {
        /*
        // Method dump skipped, instructions count: 476
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.l.b.a.b.a.b.h.o(kotlin.l.b.a.b.b.e):java.util.Collection");
    }

    @Override // kotlin.l.b.a.b.b.b.c
    public final boolean a(kotlin.l.b.a.b.b.e eVar, am amVar) {
        AppMethodBeat.i(56822);
        p.h(eVar, "classDescriptor");
        p.h(amVar, "functionDescriptor");
        kotlin.l.b.a.b.d.a.c.a.f n = n(eVar);
        if (n == null) {
            AppMethodBeat.o(56822);
            return true;
        } else if (!amVar.hzL().h(kotlin.l.b.a.b.b.b.d.hBQ())) {
            AppMethodBeat.o(56822);
            return true;
        } else if (!hAi()) {
            AppMethodBeat.o(56822);
            return false;
        } else {
            String a2 = kotlin.l.b.a.b.d.b.t.a(amVar, false, false, 3);
            kotlin.l.b.a.b.d.a.c.a.g hDO = n.hDO();
            kotlin.l.b.a.b.f.f hAH = amVar.hAH();
            p.g(hAH, "functionDescriptor.name");
            Collection<am> b2 = hDO.b(hAH, kotlin.l.b.a.b.c.a.c.FROM_BUILTINS);
            if (!(b2 instanceof Collection) || !b2.isEmpty()) {
                Iterator<T> it = b2.iterator();
                while (it.hasNext()) {
                    if (p.j(kotlin.l.b.a.b.d.b.t.a(it.next(), false, false, 3), a2)) {
                        AppMethodBeat.o(56822);
                        return true;
                    }
                }
            }
            AppMethodBeat.o(56822);
            return false;
        }
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static boolean d(kotlin.l.b.a.b.f.c cVar) {
            AppMethodBeat.i(56793);
            p.h(cVar, "fqName");
            if (e(cVar)) {
                AppMethodBeat.o(56793);
                return true;
            }
            c cVar2 = c.TfZ;
            kotlin.l.b.a.b.f.a c2 = c.c(cVar);
            if (c2 == null) {
                AppMethodBeat.o(56793);
                return false;
            }
            try {
                boolean isAssignableFrom = Serializable.class.isAssignableFrom(Class.forName(c2.hJd().sG()));
                AppMethodBeat.o(56793);
                return isAssignableFrom;
            } catch (ClassNotFoundException e2) {
                AppMethodBeat.o(56793);
                return false;
            }
        }

        static boolean e(kotlin.l.b.a.b.f.c cVar) {
            AppMethodBeat.i(56794);
            if (p.j(cVar, kotlin.l.b.a.b.a.g.TcO.TcZ) || kotlin.l.b.a.b.a.g.b(cVar)) {
                AppMethodBeat.o(56794);
                return true;
            }
            AppMethodBeat.o(56794);
            return false;
        }

        static Set<String> hAo() {
            AppMethodBeat.i(56795);
            v vVar = v.TvS;
            kotlin.l.b.a.b.j.e.d[] dVarArr = {kotlin.l.b.a.b.j.e.d.BOOLEAN, kotlin.l.b.a.b.j.e.d.BYTE, kotlin.l.b.a.b.j.e.d.DOUBLE, kotlin.l.b.a.b.j.e.d.FLOAT, kotlin.l.b.a.b.j.e.d.BYTE, kotlin.l.b.a.b.j.e.d.INT, kotlin.l.b.a.b.j.e.d.LONG, kotlin.l.b.a.b.j.e.d.SHORT};
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            for (kotlin.l.b.a.b.j.e.d dVar : kotlin.a.j.listOf((Object[]) dVarArr)) {
                String sG = dVar.hKL().hJg().sG();
                p.g(sG, "it.wrapperFqName.shortName().asString()");
                String[] aj = v.aj("Ljava/lang/String;");
                kotlin.a.j.a((Collection) linkedHashSet, (Iterable) v.r(sG, (String[]) Arrays.copyOf(aj, aj.length)));
            }
            LinkedHashSet linkedHashSet2 = linkedHashSet;
            AppMethodBeat.o(56795);
            return linkedHashSet2;
        }
    }

    static {
        AppMethodBeat.i(56812);
        v vVar = v.TvS;
        v vVar2 = v.TvS;
        v vVar3 = v.TvS;
        kotlin.l.b.a.b.j.e.d[] dVarArr = {kotlin.l.b.a.b.j.e.d.BOOLEAN, kotlin.l.b.a.b.j.e.d.CHAR};
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (kotlin.l.b.a.b.j.e.d dVar : kotlin.a.j.listOf((Object[]) dVarArr)) {
            String sG = dVar.hKL().hJg().sG();
            p.g(sG, "it.wrapperFqName.shortName().asString()");
            kotlin.a.j.a((Collection) linkedHashSet, (Iterable) v.r(sG, dVar.hKK() + "Value()" + dVar.getDesc()));
        }
        TgE = ak.b(ak.b(ak.b(ak.b(ak.b(linkedHashSet, v.s("List", "sort(Ljava/util/Comparator;)V")), v.r("String", "codePointAt(I)I", "codePointBefore(I)I", "codePointCount(II)I", "compareToIgnoreCase(Ljava/lang/String;)I", "concat(Ljava/lang/String;)Ljava/lang/String;", "contains(Ljava/lang/CharSequence;)Z", "contentEquals(Ljava/lang/CharSequence;)Z", "contentEquals(Ljava/lang/StringBuffer;)Z", "endsWith(Ljava/lang/String;)Z", "equalsIgnoreCase(Ljava/lang/String;)Z", "getBytes()[B", "getBytes(II[BI)V", "getBytes(Ljava/lang/String;)[B", "getBytes(Ljava/nio/charset/Charset;)[B", "getChars(II[CI)V", "indexOf(I)I", "indexOf(II)I", "indexOf(Ljava/lang/String;)I", "indexOf(Ljava/lang/String;I)I", "intern()Ljava/lang/String;", "isEmpty()Z", "lastIndexOf(I)I", "lastIndexOf(II)I", "lastIndexOf(Ljava/lang/String;)I", "lastIndexOf(Ljava/lang/String;I)I", "matches(Ljava/lang/String;)Z", "offsetByCodePoints(II)I", "regionMatches(ILjava/lang/String;II)Z", "regionMatches(ZILjava/lang/String;II)Z", "replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "replace(CC)Ljava/lang/String;", "replaceFirst(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;", "split(Ljava/lang/String;I)[Ljava/lang/String;", "split(Ljava/lang/String;)[Ljava/lang/String;", "startsWith(Ljava/lang/String;I)Z", "startsWith(Ljava/lang/String;)Z", "substring(II)Ljava/lang/String;", "substring(I)Ljava/lang/String;", "toCharArray()[C", "toLowerCase()Ljava/lang/String;", "toLowerCase(Ljava/util/Locale;)Ljava/lang/String;", "toUpperCase()Ljava/lang/String;", "toUpperCase(Ljava/util/Locale;)Ljava/lang/String;", "trim()Ljava/lang/String;", "isBlank()Z", "lines()Ljava/util/stream/Stream;", "repeat(I)Ljava/lang/String;")), v.r("Double", "isInfinite()Z", "isNaN()Z")), v.r("Float", "isInfinite()Z", "isNaN()Z")), v.r("Enum", "getDeclaringClass()Ljava/lang/Class;", "finalize()V"));
        v vVar4 = v.TvS;
        v vVar5 = v.TvS;
        v vVar6 = v.TvS;
        Set<String> hAo = a.hAo();
        String[] aj = v.aj(QLog.TAG_REPORTLEVEL_DEVELOPER);
        Set b2 = ak.b(hAo, v.r("Float", (String[]) Arrays.copyOf(aj, aj.length)));
        String[] aj2 = v.aj("[C", "[CII", "[III", "[BIILjava/lang/String;", "[BIILjava/nio/charset/Charset;", "[BLjava/lang/String;", "[BLjava/nio/charset/Charset;", "[BII", "[B", "Ljava/lang/StringBuffer;", "Ljava/lang/StringBuilder;");
        TgH = ak.b(b2, v.r("String", (String[]) Arrays.copyOf(aj2, aj2.length)));
        v vVar7 = v.TvS;
        String[] aj3 = v.aj("Ljava/lang/String;Ljava/lang/Throwable;ZZ");
        TgI = v.r("Throwable", (String[]) Arrays.copyOf(aj3, aj3.length));
        AppMethodBeat.o(56812);
    }

    static final class c extends q implements kotlin.g.a.a<aj> {
        final /* synthetic */ h TgP;
        final /* synthetic */ kotlin.l.b.a.b.l.j Tgm;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(h hVar, kotlin.l.b.a.b.l.j jVar) {
            super(0);
            this.TgP = hVar;
            this.Tgm = jVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ aj invoke() {
            AppMethodBeat.i(56800);
            kotlin.l.b.a.b.b.y c2 = h.c(this.TgP);
            d.a aVar = d.Tgj;
            aj hAG = s.a(c2, d.Tgi, new kotlin.l.b.a.b.b.aa(this.Tgm, h.c(this.TgP))).hAG();
            AppMethodBeat.o(56800);
            return hAG;
        }
    }

    static final class m extends q implements kotlin.g.a.a<kotlin.l.b.a.b.b.a.g> {
        final /* synthetic */ h TgP;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        m(h hVar) {
            super(0);
            this.TgP = hVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ kotlin.l.b.a.b.b.a.g invoke() {
            AppMethodBeat.i(56811);
            kotlin.l.b.a.b.b.a.c b2 = kotlin.l.b.a.b.b.a.f.b(this.TgP.Tge.hBh(), "This member is not fully supported by Kotlin compiler, so it may be absent or have different signature in next major version");
            g.a aVar = kotlin.l.b.a.b.b.a.g.TiC;
            kotlin.l.b.a.b.b.a.g kA = g.a.kA(kotlin.a.j.listOf(b2));
            AppMethodBeat.o(56811);
            return kA;
        }
    }

    static final class e extends q implements kotlin.g.a.a<aj> {
        final /* synthetic */ h TgP;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(h hVar) {
            super(0);
            this.TgP = hVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ aj invoke() {
            AppMethodBeat.i(56801);
            aj hzi = this.TgP.Tge.hBh().hzi();
            p.g(hzi, "moduleDescriptor.builtIns.anyType");
            AppMethodBeat.o(56801);
            return hzi;
        }
    }

    static final class f extends q implements kotlin.g.a.a<kotlin.l.b.a.b.d.a.c.a.f> {
        final /* synthetic */ kotlin.l.b.a.b.d.a.c.a.f TgQ;
        final /* synthetic */ kotlin.l.b.a.b.b.e TgR;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(kotlin.l.b.a.b.d.a.c.a.f fVar, kotlin.l.b.a.b.b.e eVar) {
            super(0);
            this.TgQ = fVar;
            this.TgR = eVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ kotlin.l.b.a.b.d.a.c.a.f invoke() {
            AppMethodBeat.i(56802);
            kotlin.l.b.a.b.d.a.c.a.f fVar = this.TgQ;
            kotlin.l.b.a.b.d.a.a.g gVar = kotlin.l.b.a.b.d.a.a.g.Tqm;
            p.g(gVar, "JavaResolverCache.EMPTY");
            kotlin.l.b.a.b.b.e eVar = this.TgR;
            p.h(gVar, "javaResolverCache");
            kotlin.l.b.a.b.d.a.c.h hVar = fVar.Trn;
            kotlin.l.b.a.b.d.a.c.b bVar = fVar.Trn.Trv;
            p.h(gVar, "javaResolverCache");
            kotlin.l.b.a.b.d.a.c.b bVar2 = new kotlin.l.b.a.b.d.a.c.b(bVar.TcN, bVar.TqQ, bVar.TqR, bVar.TqS, bVar.TqT, bVar.TqU, gVar, bVar.TqW, bVar.TqX, bVar.TqY, bVar.TqZ, bVar.Tra, bVar.Tkm, bVar.Trb, bVar.Tfp, bVar.Trc, bVar.Trd, bVar.Tre, bVar.Trf, bVar.Trg, bVar.Trh);
            p.h(hVar, "$this$replaceComponents");
            p.h(bVar2, "components");
            kotlin.l.b.a.b.d.a.c.h hVar2 = new kotlin.l.b.a.b.d.a.c.h(bVar2, hVar.Trw, hVar.Trx);
            kotlin.l.b.a.b.b.l hzx = fVar.hzx();
            p.g(hzx, "containingDeclaration");
            kotlin.l.b.a.b.d.a.c.a.f fVar2 = new kotlin.l.b.a.b.d.a.c.a.f(hVar2, hzx, fVar.TrI, eVar);
            AppMethodBeat.o(56802);
            return fVar2;
        }
    }
}
