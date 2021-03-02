package kotlin.l.b.a.b.b;

import com.google.android.gms.common.internal.ImagesContract;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.ServiceLoader;
import java.util.Set;
import kotlin.a.ak;
import kotlin.l.b.a.b.b.c.ag;
import kotlin.l.b.a.b.j.c;
import kotlin.l.b.a.b.j.f.a.e;
import kotlin.l.b.a.b.j.f.a.g;
import kotlin.l.b.a.b.m.ab;
import kotlin.l.b.a.b.n.g;
import kotlin.l.b.a.b.o.a;

public final class az {
    public static final ba ThQ = new ba("private") {
        /* class kotlin.l.b.a.b.b.az.AnonymousClass1 */

        private static /* synthetic */ void atM(int i2) {
            AppMethodBeat.i(56896);
            Object[] objArr = new Object[3];
            switch (i2) {
                case 1:
                    objArr[0] = "what";
                    break;
                case 2:
                    objArr[0] = "from";
                    break;
                default:
                    objArr[0] = "descriptor";
                    break;
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/Visibilities$1";
            switch (i2) {
                case 1:
                case 2:
                    objArr[2] = "isVisible";
                    break;
                default:
                    objArr[2] = "hasContainingSourceFile";
                    break;
            }
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
            AppMethodBeat.o(56896);
            throw illegalArgumentException;
        }

        @Override // kotlin.l.b.a.b.b.ba
        public final boolean b(e eVar, p pVar, l lVar) {
            AppMethodBeat.i(56895);
            if (pVar == null) {
                atM(1);
            }
            if (lVar == null) {
                atM(2);
            }
            if (c.r(pVar)) {
                if (lVar == null) {
                    atM(0);
                }
                if (c.C(lVar) != ao.ThL) {
                    boolean a2 = az.a((l) pVar, lVar);
                    AppMethodBeat.o(56895);
                    return a2;
                }
            }
            if (pVar instanceof k) {
                i hAR = ((k) pVar).hAR();
                if (c.v(hAR) && c.r(hAR) && (lVar instanceof k) && c.r(lVar.hzx()) && az.a((l) pVar, lVar)) {
                    AppMethodBeat.o(56895);
                    return true;
                }
            }
            l lVar2 = pVar;
            while (lVar2 != null) {
                lVar2 = lVar2.hzx();
                if (lVar2 instanceof e) {
                    if (!c.u(lVar2)) {
                        break;
                    }
                }
                if (lVar2 instanceof ab) {
                    break;
                }
            }
            if (lVar2 == null) {
                AppMethodBeat.o(56895);
                return false;
            }
            for (l lVar3 = lVar; lVar3 != null; lVar3 = lVar3.hzx()) {
                if (lVar2 == lVar3) {
                    AppMethodBeat.o(56895);
                    return true;
                } else if (lVar3 instanceof ab) {
                    if (!(lVar2 instanceof ab) || !((ab) lVar2).hBk().equals(((ab) lVar3).hBk()) || !c.d(lVar3, lVar2)) {
                        AppMethodBeat.o(56895);
                        return false;
                    } else {
                        AppMethodBeat.o(56895);
                        return true;
                    }
                }
            }
            AppMethodBeat.o(56895);
            return false;
        }
    };
    public static final ba ThR = new ba("private_to_this") {
        /* class kotlin.l.b.a.b.b.az.AnonymousClass5 */

        private static /* synthetic */ void atM(int i2) {
            AppMethodBeat.i(56901);
            Object[] objArr = new Object[3];
            switch (i2) {
                case 1:
                    objArr[0] = "from";
                    break;
                default:
                    objArr[0] = "what";
                    break;
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/Visibilities$2";
            objArr[2] = "isVisible";
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
            AppMethodBeat.o(56901);
            throw illegalArgumentException;
        }

        @Override // kotlin.l.b.a.b.b.ba
        public final boolean b(e eVar, p pVar, l lVar) {
            AppMethodBeat.i(56900);
            if (pVar == null) {
                atM(0);
            }
            if (lVar == null) {
                atM(1);
            }
            if (az.ThQ.b(eVar, pVar, lVar)) {
                if (eVar == az.Tid) {
                    AppMethodBeat.o(56900);
                    return true;
                } else if (eVar == az.Tic) {
                    AppMethodBeat.o(56900);
                    return false;
                } else {
                    l a2 = c.a(pVar, e.class);
                    if (a2 != null && (eVar instanceof g)) {
                        boolean equals = ((g) eVar).hBx().hAP().equals(a2.hAE());
                        AppMethodBeat.o(56900);
                        return equals;
                    }
                }
            }
            AppMethodBeat.o(56900);
            return false;
        }

        @Override // kotlin.l.b.a.b.b.ba
        public final String hBM() {
            return "private/*private to this*/";
        }
    };
    public static final ba ThS = new ba("protected") {
        /* class kotlin.l.b.a.b.b.az.AnonymousClass6 */

        private static /* synthetic */ void atM(int i2) {
            AppMethodBeat.i(56903);
            Object[] objArr = new Object[3];
            switch (i2) {
                case 1:
                    objArr[0] = "from";
                    break;
                case 2:
                    objArr[0] = "whatDeclaration";
                    break;
                case 3:
                    objArr[0] = "fromClass";
                    break;
                default:
                    objArr[0] = "what";
                    break;
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/Visibilities$3";
            switch (i2) {
                case 2:
                case 3:
                    objArr[2] = "doesReceiverFitForProtectedVisibility";
                    break;
                default:
                    objArr[2] = "isVisible";
                    break;
            }
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
            AppMethodBeat.o(56903);
            throw illegalArgumentException;
        }

        /* JADX WARNING: Removed duplicated region for block: B:56:0x0077 A[SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:58:0x00b2 A[SYNTHETIC] */
        @Override // kotlin.l.b.a.b.b.ba
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean b(kotlin.l.b.a.b.j.f.a.e r8, kotlin.l.b.a.b.b.p r9, kotlin.l.b.a.b.b.l r10) {
            /*
            // Method dump skipped, instructions count: 184
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.l.b.a.b.b.az.AnonymousClass6.b(kotlin.l.b.a.b.j.f.a.e, kotlin.l.b.a.b.b.p, kotlin.l.b.a.b.b.l):boolean");
        }
    };
    public static final ba ThT = new ba("internal") {
        /* class kotlin.l.b.a.b.b.az.AnonymousClass7 */

        private static /* synthetic */ void atM(int i2) {
            AppMethodBeat.i(56905);
            Object[] objArr = new Object[3];
            switch (i2) {
                case 1:
                    objArr[0] = "from";
                    break;
                default:
                    objArr[0] = "what";
                    break;
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/Visibilities$4";
            objArr[2] = "isVisible";
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
            AppMethodBeat.o(56905);
            throw illegalArgumentException;
        }

        @Override // kotlin.l.b.a.b.b.ba
        public final boolean b(e eVar, p pVar, l lVar) {
            AppMethodBeat.i(56904);
            if (pVar == null) {
                atM(0);
            }
            if (lVar == null) {
                atM(1);
            }
            if (!c.s(lVar).a(c.s(pVar))) {
                AppMethodBeat.o(56904);
                return false;
            }
            boolean g2 = az.Tif.g(pVar, lVar);
            AppMethodBeat.o(56904);
            return g2;
        }
    };
    public static final ba ThU = new ba("public") {
        /* class kotlin.l.b.a.b.b.az.AnonymousClass8 */

        private static /* synthetic */ void atM(int i2) {
            AppMethodBeat.i(56907);
            Object[] objArr = new Object[3];
            switch (i2) {
                case 1:
                    objArr[0] = "from";
                    break;
                default:
                    objArr[0] = "what";
                    break;
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/Visibilities$5";
            objArr[2] = "isVisible";
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
            AppMethodBeat.o(56907);
            throw illegalArgumentException;
        }

        @Override // kotlin.l.b.a.b.b.ba
        public final boolean b(e eVar, p pVar, l lVar) {
            AppMethodBeat.i(56906);
            if (pVar == null) {
                atM(0);
            }
            if (lVar == null) {
                atM(1);
            }
            AppMethodBeat.o(56906);
            return true;
        }
    };
    public static final ba ThV = new ba(ImagesContract.LOCAL) {
        /* class kotlin.l.b.a.b.b.az.AnonymousClass9 */

        private static /* synthetic */ void atM(int i2) {
            AppMethodBeat.i(56909);
            Object[] objArr = new Object[3];
            switch (i2) {
                case 1:
                    objArr[0] = "from";
                    break;
                default:
                    objArr[0] = "what";
                    break;
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/Visibilities$6";
            objArr[2] = "isVisible";
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
            AppMethodBeat.o(56909);
            throw illegalArgumentException;
        }

        @Override // kotlin.l.b.a.b.b.ba
        public final boolean b(e eVar, p pVar, l lVar) {
            AppMethodBeat.i(56908);
            if (pVar == null) {
                atM(0);
            }
            if (lVar == null) {
                atM(1);
            }
            IllegalStateException illegalStateException = new IllegalStateException("This method shouldn't be invoked for LOCAL visibility");
            AppMethodBeat.o(56908);
            throw illegalStateException;
        }
    };
    public static final ba ThW = new ba("inherited") {
        /* class kotlin.l.b.a.b.b.az.AnonymousClass10 */

        private static /* synthetic */ void atM(int i2) {
            AppMethodBeat.i(56911);
            Object[] objArr = new Object[3];
            switch (i2) {
                case 1:
                    objArr[0] = "from";
                    break;
                default:
                    objArr[0] = "what";
                    break;
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/Visibilities$7";
            objArr[2] = "isVisible";
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
            AppMethodBeat.o(56911);
            throw illegalArgumentException;
        }

        @Override // kotlin.l.b.a.b.b.ba
        public final boolean b(e eVar, p pVar, l lVar) {
            AppMethodBeat.i(56910);
            if (pVar == null) {
                atM(0);
            }
            if (lVar == null) {
                atM(1);
            }
            IllegalStateException illegalStateException = new IllegalStateException("Visibility is unknown yet");
            AppMethodBeat.o(56910);
            throw illegalStateException;
        }
    };
    public static final ba ThX = new ba("invisible_fake") {
        /* class kotlin.l.b.a.b.b.az.AnonymousClass11 */

        private static /* synthetic */ void atM(int i2) {
            AppMethodBeat.i(56913);
            Object[] objArr = new Object[3];
            switch (i2) {
                case 1:
                    objArr[0] = "from";
                    break;
                default:
                    objArr[0] = "what";
                    break;
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/Visibilities$8";
            objArr[2] = "isVisible";
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
            AppMethodBeat.o(56913);
            throw illegalArgumentException;
        }

        @Override // kotlin.l.b.a.b.b.ba
        public final boolean b(e eVar, p pVar, l lVar) {
            AppMethodBeat.i(56912);
            if (pVar == null) {
                atM(0);
            }
            if (lVar == null) {
                atM(1);
            }
            AppMethodBeat.o(56912);
            return false;
        }
    };
    public static final ba ThY = new ba("unknown") {
        /* class kotlin.l.b.a.b.b.az.AnonymousClass12 */

        private static /* synthetic */ void atM(int i2) {
            AppMethodBeat.i(56915);
            Object[] objArr = new Object[3];
            switch (i2) {
                case 1:
                    objArr[0] = "from";
                    break;
                default:
                    objArr[0] = "what";
                    break;
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/Visibilities$9";
            objArr[2] = "isVisible";
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
            AppMethodBeat.o(56915);
            throw illegalArgumentException;
        }

        @Override // kotlin.l.b.a.b.b.ba
        public final boolean b(e eVar, p pVar, l lVar) {
            AppMethodBeat.i(56914);
            if (pVar == null) {
                atM(0);
            }
            if (lVar == null) {
                atM(1);
            }
            AppMethodBeat.o(56914);
            return false;
        }
    };
    public static final Set<ba> ThZ = Collections.unmodifiableSet(ak.setOf((Object[]) new ba[]{ThQ, ThR, ThT, ThV}));
    private static final Map<ba, Integer> Tia;
    public static final ba Tib = ThU;
    private static final e Tic = new e() {
        /* class kotlin.l.b.a.b.b.az.AnonymousClass2 */

        @Override // kotlin.l.b.a.b.j.f.a.e
        public final ab hBy() {
            AppMethodBeat.i(56897);
            IllegalStateException illegalStateException = new IllegalStateException("This method should not be called");
            AppMethodBeat.o(56897);
            throw illegalStateException;
        }
    };
    public static final e Tid = new e() {
        /* class kotlin.l.b.a.b.b.az.AnonymousClass3 */

        @Override // kotlin.l.b.a.b.j.f.a.e
        public final ab hBy() {
            AppMethodBeat.i(56898);
            IllegalStateException illegalStateException = new IllegalStateException("This method should not be called");
            AppMethodBeat.o(56898);
            throw illegalStateException;
        }
    };
    @Deprecated
    public static final e Tie = new e() {
        /* class kotlin.l.b.a.b.b.az.AnonymousClass4 */

        @Override // kotlin.l.b.a.b.j.f.a.e
        public final ab hBy() {
            AppMethodBeat.i(56899);
            IllegalStateException illegalStateException = new IllegalStateException("This method should not be called");
            AppMethodBeat.o(56899);
            throw illegalStateException;
        }
    };
    private static final kotlin.l.b.a.b.n.g Tif;

    private static /* synthetic */ void atM(int i2) {
        AppMethodBeat.i(56923);
        Object[] objArr = new Object[3];
        switch (i2) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 9:
                objArr[0] = "from";
                break;
            case 2:
            case 4:
            case 6:
            case 8:
            default:
                objArr[0] = "what";
                break;
            case 10:
            case 12:
                objArr[0] = "first";
                break;
            case 11:
            case 13:
                objArr[0] = "second";
                break;
            case 14:
                objArr[0] = "visibility";
                break;
        }
        objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/Visibilities";
        switch (i2) {
            case 2:
            case 3:
                objArr[2] = "isVisibleIgnoringReceiver";
                break;
            case 4:
            case 5:
                objArr[2] = "isVisibleWithAnyReceiver";
                break;
            case 6:
            case 7:
                objArr[2] = "inSameFile";
                break;
            case 8:
            case 9:
                objArr[2] = "findInvisibleMember";
                break;
            case 10:
            case 11:
                objArr[2] = "compareLocal";
                break;
            case 12:
            case 13:
                objArr[2] = "compare";
                break;
            case 14:
                objArr[2] = "isPrivate";
                break;
            default:
                objArr[2] = "isVisible";
                break;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        AppMethodBeat.o(56923);
        throw illegalArgumentException;
    }

    static {
        AppMethodBeat.i(56922);
        HashMap avL = a.avL(4);
        avL.put(ThR, 0);
        avL.put(ThQ, 0);
        avL.put(ThT, 1);
        avL.put(ThS, 1);
        avL.put(ThU, 2);
        Tia = Collections.unmodifiableMap(avL);
        Iterator it = ServiceLoader.load(kotlin.l.b.a.b.n.g.class, kotlin.l.b.a.b.n.g.class.getClassLoader()).iterator();
        Tif = it.hasNext() ? (kotlin.l.b.a.b.n.g) it.next() : g.a.TQr;
        AppMethodBeat.o(56922);
    }

    public static boolean a(p pVar, l lVar) {
        AppMethodBeat.i(56916);
        if (pVar == null) {
            atM(2);
        }
        if (lVar == null) {
            atM(3);
        }
        if (a(Tid, pVar, lVar) == null) {
            AppMethodBeat.o(56916);
            return true;
        }
        AppMethodBeat.o(56916);
        return false;
    }

    public static boolean a(l lVar, l lVar2) {
        AppMethodBeat.i(56917);
        if (lVar == null) {
            atM(6);
        }
        if (lVar2 == null) {
            atM(7);
        }
        ao C = c.C(lVar2);
        if (C != ao.ThL) {
            boolean equals = C.equals(c.C(lVar));
            AppMethodBeat.o(56917);
            return equals;
        }
        AppMethodBeat.o(56917);
        return false;
    }

    private static p a(e eVar, p pVar, l lVar) {
        p a2;
        AppMethodBeat.i(56918);
        if (pVar == null) {
            atM(8);
        }
        if (lVar == null) {
            atM(9);
        }
        p pVar2 = (p) pVar.hAE();
        while (pVar2 != null && pVar2.hzE() != ThV) {
            if (!pVar2.hzE().b(eVar, pVar2, lVar)) {
                AppMethodBeat.o(56918);
                return pVar2;
            }
            pVar2 = (p) c.a(pVar2, p.class);
        }
        if (!(pVar instanceof ag) || (a2 = a(eVar, ((ag) pVar).hCv(), lVar)) == null) {
            AppMethodBeat.o(56918);
            return null;
        }
        AppMethodBeat.o(56918);
        return a2;
    }

    static Integer a(ba baVar, ba baVar2) {
        AppMethodBeat.i(56919);
        if (baVar2 == null) {
            atM(11);
        }
        if (baVar == baVar2) {
            AppMethodBeat.o(56919);
            return 0;
        }
        Integer num = Tia.get(baVar);
        Integer num2 = Tia.get(baVar2);
        if (num == null || num2 == null || num.equals(num2)) {
            AppMethodBeat.o(56919);
            return null;
        }
        Integer valueOf = Integer.valueOf(num.intValue() - num2.intValue());
        AppMethodBeat.o(56919);
        return valueOf;
    }

    public static Integer b(ba baVar, ba baVar2) {
        AppMethodBeat.i(56920);
        if (baVar == null) {
            atM(12);
        }
        if (baVar2 == null) {
            atM(13);
        }
        Integer c2 = baVar.c(baVar2);
        if (c2 != null) {
            AppMethodBeat.o(56920);
            return c2;
        }
        Integer c3 = baVar2.c(baVar);
        if (c3 != null) {
            Integer valueOf = Integer.valueOf(-c3.intValue());
            AppMethodBeat.o(56920);
            return valueOf;
        }
        AppMethodBeat.o(56920);
        return null;
    }

    public static boolean b(ba baVar) {
        AppMethodBeat.i(56921);
        if (baVar == null) {
            atM(14);
        }
        if (baVar == ThQ || baVar == ThR) {
            AppMethodBeat.o(56921);
            return true;
        }
        AppMethodBeat.o(56921);
        return false;
    }
}
