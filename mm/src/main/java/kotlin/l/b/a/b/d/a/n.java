package kotlin.l.b.a.b.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l.b.a.b.b.ab;
import kotlin.l.b.a.b.b.az;
import kotlin.l.b.a.b.b.ba;
import kotlin.l.b.a.b.b.l;
import kotlin.l.b.a.b.b.p;
import kotlin.l.b.a.b.j.c;
import kotlin.l.b.a.b.j.f.a.e;

public final class n {
    public static final ba Tpe = new ba("package") {
        /* class kotlin.l.b.a.b.d.a.n.AnonymousClass1 */

        private static /* synthetic */ void atM(int i2) {
            String str;
            int i3;
            Throwable illegalStateException;
            AppMethodBeat.i(57595);
            switch (i2) {
                case 3:
                case 5:
                    str = "@NotNull method %s.%s must not return null";
                    break;
                case 4:
                default:
                    str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                    break;
            }
            switch (i2) {
                case 3:
                case 5:
                    i3 = 2;
                    break;
                case 4:
                default:
                    i3 = 3;
                    break;
            }
            Object[] objArr = new Object[i3];
            switch (i2) {
                case 1:
                    objArr[0] = "from";
                    break;
                case 2:
                    objArr[0] = "visibility";
                    break;
                case 3:
                case 5:
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/load/java/JavaVisibilities$1";
                    break;
                case 4:
                    objArr[0] = "classDescriptor";
                    break;
                default:
                    objArr[0] = "what";
                    break;
            }
            switch (i2) {
                case 3:
                    objArr[1] = "normalize";
                    break;
                case 4:
                default:
                    objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/JavaVisibilities$1";
                    break;
                case 5:
                    objArr[1] = "effectiveVisibility";
                    break;
            }
            switch (i2) {
                case 2:
                    objArr[2] = "compareTo";
                    break;
                case 3:
                case 5:
                    break;
                case 4:
                    objArr[2] = "effectiveVisibility";
                    break;
                default:
                    objArr[2] = "isVisible";
                    break;
            }
            String format = String.format(str, objArr);
            switch (i2) {
                case 3:
                case 5:
                    illegalStateException = new IllegalStateException(format);
                    break;
                case 4:
                default:
                    illegalStateException = new IllegalArgumentException(format);
                    break;
            }
            AppMethodBeat.o(57595);
            throw illegalStateException;
        }

        @Override // kotlin.l.b.a.b.b.ba
        public final boolean b(e eVar, p pVar, l lVar) {
            AppMethodBeat.i(57592);
            if (pVar == null) {
                atM(0);
            }
            if (lVar == null) {
                atM(1);
            }
            boolean c2 = n.c(pVar, lVar);
            AppMethodBeat.o(57592);
            return c2;
        }

        @Override // kotlin.l.b.a.b.b.ba
        public final Integer c(ba baVar) {
            AppMethodBeat.i(57593);
            if (baVar == null) {
                atM(2);
            }
            if (this == baVar) {
                AppMethodBeat.o(57593);
                return 0;
            } else if (az.b(baVar)) {
                AppMethodBeat.o(57593);
                return 1;
            } else {
                AppMethodBeat.o(57593);
                return -1;
            }
        }

        @Override // kotlin.l.b.a.b.b.ba
        public final String hBM() {
            return "public/*package*/";
        }

        @Override // kotlin.l.b.a.b.b.ba
        public final ba hBN() {
            AppMethodBeat.i(57594);
            ba baVar = az.ThS;
            if (baVar == null) {
                atM(3);
            }
            AppMethodBeat.o(57594);
            return baVar;
        }
    };
    public static final ba Tpf = new ba("protected_static") {
        /* class kotlin.l.b.a.b.d.a.n.AnonymousClass2 */

        private static /* synthetic */ void atM(int i2) {
            String str;
            int i3;
            Throwable illegalStateException;
            AppMethodBeat.i(57598);
            switch (i2) {
                case 2:
                    str = "@NotNull method %s.%s must not return null";
                    break;
                default:
                    str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                    break;
            }
            switch (i2) {
                case 2:
                    i3 = 2;
                    break;
                default:
                    i3 = 3;
                    break;
            }
            Object[] objArr = new Object[i3];
            switch (i2) {
                case 1:
                    objArr[0] = "from";
                    break;
                case 2:
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/load/java/JavaVisibilities$2";
                    break;
                default:
                    objArr[0] = "what";
                    break;
            }
            switch (i2) {
                case 2:
                    objArr[1] = "normalize";
                    break;
                default:
                    objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/JavaVisibilities$2";
                    break;
            }
            switch (i2) {
                case 2:
                    break;
                default:
                    objArr[2] = "isVisible";
                    break;
            }
            String format = String.format(str, objArr);
            switch (i2) {
                case 2:
                    illegalStateException = new IllegalStateException(format);
                    break;
                default:
                    illegalStateException = new IllegalArgumentException(format);
                    break;
            }
            AppMethodBeat.o(57598);
            throw illegalStateException;
        }

        @Override // kotlin.l.b.a.b.b.ba
        public final boolean b(e eVar, p pVar, l lVar) {
            AppMethodBeat.i(57596);
            if (pVar == null) {
                atM(0);
            }
            if (lVar == null) {
                atM(1);
            }
            boolean c2 = n.c(eVar, pVar, lVar);
            AppMethodBeat.o(57596);
            return c2;
        }

        @Override // kotlin.l.b.a.b.b.ba
        public final String hBM() {
            return "protected/*protected static*/";
        }

        @Override // kotlin.l.b.a.b.b.ba
        public final ba hBN() {
            AppMethodBeat.i(57597);
            ba baVar = az.ThS;
            if (baVar == null) {
                atM(2);
            }
            AppMethodBeat.o(57597);
            return baVar;
        }
    };
    public static final ba Tpg = new ba("protected_and_package") {
        /* class kotlin.l.b.a.b.d.a.n.AnonymousClass3 */

        private static /* synthetic */ void atM(int i2) {
            String str;
            int i3;
            Throwable illegalStateException;
            AppMethodBeat.i(57602);
            switch (i2) {
                case 3:
                    str = "@NotNull method %s.%s must not return null";
                    break;
                default:
                    str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                    break;
            }
            switch (i2) {
                case 3:
                    i3 = 2;
                    break;
                default:
                    i3 = 3;
                    break;
            }
            Object[] objArr = new Object[i3];
            switch (i2) {
                case 1:
                    objArr[0] = "from";
                    break;
                case 2:
                    objArr[0] = "visibility";
                    break;
                case 3:
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/load/java/JavaVisibilities$3";
                    break;
                default:
                    objArr[0] = "what";
                    break;
            }
            switch (i2) {
                case 3:
                    objArr[1] = "normalize";
                    break;
                default:
                    objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/JavaVisibilities$3";
                    break;
            }
            switch (i2) {
                case 2:
                    objArr[2] = "compareTo";
                    break;
                case 3:
                    break;
                default:
                    objArr[2] = "isVisible";
                    break;
            }
            String format = String.format(str, objArr);
            switch (i2) {
                case 3:
                    illegalStateException = new IllegalStateException(format);
                    break;
                default:
                    illegalStateException = new IllegalArgumentException(format);
                    break;
            }
            AppMethodBeat.o(57602);
            throw illegalStateException;
        }

        @Override // kotlin.l.b.a.b.b.ba
        public final boolean b(e eVar, p pVar, l lVar) {
            AppMethodBeat.i(57599);
            if (pVar == null) {
                atM(0);
            }
            if (lVar == null) {
                atM(1);
            }
            boolean c2 = n.c(eVar, pVar, lVar);
            AppMethodBeat.o(57599);
            return c2;
        }

        @Override // kotlin.l.b.a.b.b.ba
        public final Integer c(ba baVar) {
            AppMethodBeat.i(57600);
            if (baVar == null) {
                atM(2);
            }
            if (this == baVar) {
                AppMethodBeat.o(57600);
                return 0;
            } else if (baVar == az.ThT) {
                AppMethodBeat.o(57600);
                return null;
            } else if (az.b(baVar)) {
                AppMethodBeat.o(57600);
                return 1;
            } else {
                AppMethodBeat.o(57600);
                return -1;
            }
        }

        @Override // kotlin.l.b.a.b.b.ba
        public final String hBM() {
            return "protected/*protected and package*/";
        }

        @Override // kotlin.l.b.a.b.b.ba
        public final ba hBN() {
            AppMethodBeat.i(57601);
            ba baVar = az.ThS;
            if (baVar == null) {
                atM(3);
            }
            AppMethodBeat.o(57601);
            return baVar;
        }
    };

    private static /* synthetic */ void atM(int i2) {
        AppMethodBeat.i(57607);
        Object[] objArr = new Object[3];
        switch (i2) {
            case 1:
                objArr[0] = "from";
                break;
            case 2:
                objArr[0] = "first";
                break;
            case 3:
                objArr[0] = "second";
                break;
            default:
                objArr[0] = "what";
                break;
        }
        objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/JavaVisibilities";
        switch (i2) {
            case 2:
            case 3:
                objArr[2] = "areInSamePackage";
                break;
            default:
                objArr[2] = "isVisibleForProtectedAndPackage";
                break;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        AppMethodBeat.o(57607);
        throw illegalArgumentException;
    }

    static /* synthetic */ boolean c(l lVar, l lVar2) {
        AppMethodBeat.i(57604);
        boolean b2 = b(lVar, lVar2);
        AppMethodBeat.o(57604);
        return b2;
    }

    static /* synthetic */ boolean c(e eVar, p pVar, l lVar) {
        AppMethodBeat.i(57605);
        if (pVar == null) {
            atM(0);
        }
        if (lVar == null) {
            atM(1);
        }
        if (b(c.a(pVar), lVar)) {
            AppMethodBeat.o(57605);
            return true;
        }
        boolean b2 = az.ThS.b(eVar, pVar, lVar);
        AppMethodBeat.o(57605);
        return b2;
    }

    static {
        AppMethodBeat.i(57606);
        AppMethodBeat.o(57606);
    }

    private static boolean b(l lVar, l lVar2) {
        AppMethodBeat.i(57603);
        if (lVar == null) {
            atM(2);
        }
        if (lVar2 == null) {
            atM(3);
        }
        ab abVar = (ab) c.a(lVar, ab.class, false);
        ab abVar2 = (ab) c.a(lVar2, ab.class, false);
        if (abVar2 == null || abVar == null || !abVar.hBk().equals(abVar2.hBk())) {
            AppMethodBeat.o(57603);
            return false;
        }
        AppMethodBeat.o(57603);
        return true;
    }
}
