package kotlin.l.b.a.b.m.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.l.b.a.b.a.g;
import kotlin.l.b.a.b.b.as;
import kotlin.l.b.a.b.m.ab;
import kotlin.l.b.a.b.m.ad;
import kotlin.l.b.a.b.m.at;
import kotlin.l.b.a.b.m.av;
import kotlin.l.b.a.b.m.bc;
import kotlin.l.b.a.b.m.bh;
import kotlin.l.b.a.b.m.y;

public class w {
    static final /* synthetic */ boolean $assertionsDisabled = (!w.class.desiredAssertionStatus());
    private final x TPy;

    private static /* synthetic */ void atM(int i2) {
        String str;
        int i3;
        Throwable illegalStateException;
        AppMethodBeat.i(61175);
        switch (i2) {
            case 7:
            case 10:
                str = "@NotNull method %s.%s must not return null";
                break;
            case 8:
            case 9:
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i2) {
            case 7:
            case 10:
                i3 = 2;
                break;
            case 8:
            case 9:
            default:
                i3 = 3;
                break;
        }
        Object[] objArr = new Object[i3];
        switch (i2) {
            case 1:
            case 3:
            case 16:
            case 18:
                objArr[0] = "supertype";
                break;
            case 2:
            case 15:
            case 17:
            default:
                objArr[0] = "subtype";
                break;
            case 4:
                objArr[0] = "typeCheckingProcedureCallbacks";
                break;
            case 5:
            case 8:
            case 21:
                objArr[0] = "parameter";
                break;
            case 6:
            case 9:
                objArr[0] = "argument";
                break;
            case 7:
            case 10:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/types/checker/TypeCheckingProcedure";
                break;
            case 11:
                objArr[0] = "type1";
                break;
            case 12:
                objArr[0] = "type2";
                break;
            case 13:
                objArr[0] = "typeParameter";
                break;
            case 14:
                objArr[0] = "typeArgument";
                break;
            case 19:
                objArr[0] = "subtypeArgumentProjection";
                break;
            case 20:
                objArr[0] = "supertypeArgumentProjection";
                break;
        }
        switch (i2) {
            case 7:
                objArr[1] = "getOutType";
                break;
            case 8:
            case 9:
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/types/checker/TypeCheckingProcedure";
                break;
            case 10:
                objArr[1] = "getInType";
                break;
        }
        switch (i2) {
            case 5:
            case 6:
                objArr[2] = "getOutType";
                break;
            case 7:
            case 10:
                break;
            case 8:
            case 9:
                objArr[2] = "getInType";
                break;
            case 11:
            case 12:
                objArr[2] = "equalTypes";
                break;
            case 13:
            case 14:
                objArr[2] = "getEffectiveProjectionKind";
                break;
            case 15:
            case 16:
                objArr[2] = "isSubtypeOf";
                break;
            case 17:
            case 18:
                objArr[2] = "checkSubtypeForTheSameConstructor";
                break;
            case 19:
            case 20:
            case 21:
                objArr[2] = "capture";
                break;
            default:
                objArr[2] = "findCorrespondingSupertype";
                break;
        }
        String format = String.format(str, objArr);
        switch (i2) {
            case 7:
            case 10:
                illegalStateException = new IllegalStateException(format);
                break;
            case 8:
            case 9:
            default:
                illegalStateException = new IllegalArgumentException(format);
                break;
        }
        AppMethodBeat.o(61175);
        throw illegalStateException;
    }

    static {
        AppMethodBeat.i(61174);
        AppMethodBeat.o(61174);
    }

    public static ab f(ab abVar, ab abVar2) {
        AppMethodBeat.i(61163);
        if (abVar == null) {
            atM(0);
        }
        if (abVar2 == null) {
            atM(1);
        }
        ab a2 = a(abVar, abVar2, new v());
        AppMethodBeat.o(61163);
        return a2;
    }

    private static ab a(ab abVar, ab abVar2, x xVar) {
        AppMethodBeat.i(61164);
        if (abVar == null) {
            atM(2);
        }
        if (abVar2 == null) {
            atM(3);
        }
        if (xVar == null) {
            atM(4);
        }
        ab a2 = z.a(abVar, abVar2, xVar);
        AppMethodBeat.o(61164);
        return a2;
    }

    private static ab a(as asVar, av avVar) {
        AppMethodBeat.i(61165);
        if (asVar == null) {
            atM(5);
        }
        if (avVar == null) {
            atM(6);
        }
        ab hzj = avVar.hLI() == bh.IN_VARIANCE || asVar.hAJ() == bh.IN_VARIANCE ? kotlin.l.b.a.b.j.d.a.G(asVar).hzj() : avVar.hBy();
        if (hzj == null) {
            atM(7);
        }
        AppMethodBeat.o(61165);
        return hzj;
    }

    private static ab b(as asVar, av avVar) {
        AppMethodBeat.i(61166);
        if (asVar == null) {
            atM(8);
        }
        if (avVar == null) {
            atM(9);
        }
        ab hzh = avVar.hLI() == bh.OUT_VARIANCE || asVar.hAJ() == bh.OUT_VARIANCE ? kotlin.l.b.a.b.j.d.a.G(asVar).hzh() : avVar.hBy();
        if (hzh == null) {
            atM(10);
        }
        AppMethodBeat.o(61166);
        return hzh;
    }

    public w(x xVar) {
        this.TPy = xVar;
    }

    public final boolean d(ab abVar, ab abVar2) {
        AppMethodBeat.i(61167);
        if (abVar == null) {
            atM(11);
        }
        if (abVar2 == null) {
            atM(12);
        }
        if (abVar == abVar2) {
            AppMethodBeat.o(61167);
            return true;
        } else if (y.al(abVar)) {
            if (!y.al(abVar2)) {
                boolean g2 = g(abVar2, abVar);
                AppMethodBeat.o(61167);
                return g2;
            } else if (ad.ap(abVar) || ad.ap(abVar2) || !c(abVar, abVar2) || !c(abVar2, abVar)) {
                AppMethodBeat.o(61167);
                return false;
            } else {
                AppMethodBeat.o(61167);
                return true;
            }
        } else if (y.al(abVar2)) {
            boolean g3 = g(abVar, abVar2);
            AppMethodBeat.o(61167);
            return g3;
        } else if (abVar.hEa() != abVar2.hEa()) {
            AppMethodBeat.o(61167);
            return false;
        } else if (abVar.hEa()) {
            boolean a2 = this.TPy.a(bc.aD(abVar), bc.aD(abVar2), this);
            AppMethodBeat.o(61167);
            return a2;
        } else {
            at hKE = abVar.hKE();
            at hKE2 = abVar2.hKE();
            if (!this.TPy.b(hKE, hKE2)) {
                AppMethodBeat.o(61167);
                return false;
            }
            List<av> hKB = abVar.hKB();
            List<av> hKB2 = abVar2.hKB();
            if (hKB.size() != hKB2.size()) {
                AppMethodBeat.o(61167);
                return false;
            }
            for (int i2 = 0; i2 < hKB.size(); i2++) {
                av avVar = hKB.get(i2);
                av avVar2 = hKB2.get(i2);
                if (!avVar.hLH() || !avVar2.hLH()) {
                    as asVar = hKE.getParameters().get(i2);
                    as asVar2 = hKE2.getParameters().get(i2);
                    if (a(avVar, avVar2, asVar)) {
                        continue;
                    } else if (c(asVar, avVar) != c(asVar2, avVar2)) {
                        AppMethodBeat.o(61167);
                        return false;
                    } else if (!this.TPy.a(avVar.hBy(), avVar2.hBy(), this)) {
                        AppMethodBeat.o(61167);
                        return false;
                    }
                }
            }
            AppMethodBeat.o(61167);
            return true;
        }
    }

    private boolean g(ab abVar, ab abVar2) {
        AppMethodBeat.i(61168);
        if (!$assertionsDisabled && y.al(abVar)) {
            AssertionError assertionError = new AssertionError("Only inflexible types are allowed here: ".concat(String.valueOf(abVar)));
            AppMethodBeat.o(61168);
            throw assertionError;
        } else if (!c(y.am(abVar2).TNV, abVar) || !c(abVar, y.am(abVar2).TNW)) {
            AppMethodBeat.o(61168);
            return false;
        } else {
            AppMethodBeat.o(61168);
            return true;
        }
    }

    public enum a {
        IN,
        OUT,
        INV,
        STAR;

        private static /* synthetic */ void atM(int i2) {
            String str;
            int i3;
            Throwable illegalStateException;
            AppMethodBeat.i(61162);
            switch (i2) {
                case 1:
                case 2:
                case 3:
                    str = "@NotNull method %s.%s must not return null";
                    break;
                default:
                    str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                    break;
            }
            switch (i2) {
                case 1:
                case 2:
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
                case 2:
                case 3:
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/types/checker/TypeCheckingProcedure$EnrichedProjectionKind";
                    break;
                default:
                    objArr[0] = "variance";
                    break;
            }
            switch (i2) {
                case 1:
                case 2:
                case 3:
                    objArr[1] = "fromVariance";
                    break;
                default:
                    objArr[1] = "kotlin/reflect/jvm/internal/impl/types/checker/TypeCheckingProcedure$EnrichedProjectionKind";
                    break;
            }
            switch (i2) {
                case 1:
                case 2:
                case 3:
                    break;
                default:
                    objArr[2] = "fromVariance";
                    break;
            }
            String format = String.format(str, objArr);
            switch (i2) {
                case 1:
                case 2:
                case 3:
                    illegalStateException = new IllegalStateException(format);
                    break;
                default:
                    illegalStateException = new IllegalArgumentException(format);
                    break;
            }
            AppMethodBeat.o(61162);
            throw illegalStateException;
        }

        public static a valueOf(String str) {
            AppMethodBeat.i(61159);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(61159);
            return aVar;
        }

        static {
            AppMethodBeat.i(61161);
            AppMethodBeat.o(61161);
        }

        public static a b(bh bhVar) {
            a aVar;
            AppMethodBeat.i(61160);
            if (bhVar == null) {
                atM(0);
            }
            switch (bhVar) {
                case INVARIANT:
                    aVar = INV;
                    if (aVar == null) {
                        atM(1);
                    }
                    AppMethodBeat.o(61160);
                    break;
                case IN_VARIANCE:
                    aVar = IN;
                    if (aVar == null) {
                        atM(2);
                    }
                    AppMethodBeat.o(61160);
                    break;
                case OUT_VARIANCE:
                    aVar = OUT;
                    if (aVar == null) {
                        atM(3);
                    }
                    AppMethodBeat.o(61160);
                    break;
                default:
                    IllegalStateException illegalStateException = new IllegalStateException("Unknown variance");
                    AppMethodBeat.o(61160);
                    throw illegalStateException;
            }
            return aVar;
        }
    }

    private static a c(as asVar, av avVar) {
        bh bhVar;
        bh bhVar2;
        AppMethodBeat.i(61169);
        if (asVar == null) {
            atM(13);
        }
        if (avVar == null) {
            atM(14);
        }
        bh hAJ = asVar.hAJ();
        bh hLI = avVar.hLI();
        if (hLI == bh.INVARIANT) {
            bhVar = hAJ;
            bhVar2 = hLI;
        } else {
            bhVar = hLI;
            bhVar2 = hAJ;
        }
        if (bhVar2 == bh.IN_VARIANCE && bhVar == bh.OUT_VARIANCE) {
            a aVar = a.STAR;
            AppMethodBeat.o(61169);
            return aVar;
        } else if (bhVar2 == bh.OUT_VARIANCE && bhVar == bh.IN_VARIANCE) {
            a aVar2 = a.STAR;
            AppMethodBeat.o(61169);
            return aVar2;
        } else {
            a b2 = a.b(bhVar);
            AppMethodBeat.o(61169);
            return b2;
        }
    }

    public final boolean c(ab abVar, ab abVar2) {
        AppMethodBeat.i(61170);
        while (true) {
            if (abVar == null) {
                atM(15);
            }
            if (abVar2 == null) {
                atM(16);
            }
            if (!kotlin.l.b.a.b.m.as.b(abVar, abVar2)) {
                ab av = kotlin.l.b.a.b.m.as.av(abVar);
                ab aw = kotlin.l.b.a.b.m.as.aw(abVar2);
                if (av == abVar && aw == abVar2) {
                    boolean h2 = h(abVar, abVar2);
                    AppMethodBeat.o(61170);
                    return h2;
                }
                abVar2 = aw;
                abVar = av;
            } else if (!abVar.hEa() || abVar2.hEa()) {
                AppMethodBeat.o(61170);
                return true;
            } else {
                AppMethodBeat.o(61170);
                return false;
            }
        }
    }

    private boolean h(ab abVar, ab abVar2) {
        AppMethodBeat.i(61171);
        if (ad.ap(abVar) || ad.ap(abVar2)) {
            AppMethodBeat.o(61171);
            return true;
        } else if (!abVar2.hEa() && abVar.hEa()) {
            AppMethodBeat.o(61171);
            return false;
        } else if (g.y(abVar)) {
            AppMethodBeat.o(61171);
            return true;
        } else {
            ab a2 = a(abVar, abVar2, this.TPy);
            if (a2 == null) {
                boolean e2 = this.TPy.e(abVar, abVar2);
                AppMethodBeat.o(61171);
                return e2;
            } else if (abVar2.hEa() || !a2.hEa()) {
                boolean i2 = i(a2, abVar2);
                AppMethodBeat.o(61171);
                return i2;
            } else {
                AppMethodBeat.o(61171);
                return false;
            }
        }
    }

    private boolean i(ab abVar, ab abVar2) {
        AppMethodBeat.i(61172);
        if (abVar == null) {
            atM(17);
        }
        if (abVar2 == null) {
            atM(18);
        }
        at hKE = abVar.hKE();
        List<av> hKB = abVar.hKB();
        List<av> hKB2 = abVar2.hKB();
        if (hKB.size() != hKB2.size()) {
            AppMethodBeat.o(61172);
            return false;
        }
        List<as> parameters = hKE.getParameters();
        for (int i2 = 0; i2 < parameters.size(); i2++) {
            as asVar = parameters.get(i2);
            av avVar = hKB2.get(i2);
            av avVar2 = hKB.get(i2);
            if (!avVar.hLH() && !a(avVar2, avVar, asVar)) {
                if ((ad.ap(avVar2.hBy()) || ad.ap(avVar.hBy())) || asVar.hAJ() != bh.INVARIANT || avVar2.hLI() != bh.INVARIANT || avVar.hLI() != bh.INVARIANT) {
                    if (!this.TPy.b(a(asVar, avVar2), a(asVar, avVar), this)) {
                        AppMethodBeat.o(61172);
                        return false;
                    }
                    ab b2 = b(asVar, avVar);
                    ab b3 = b(asVar, avVar2);
                    if (avVar.hLI() != bh.OUT_VARIANCE) {
                        if (!this.TPy.b(b2, b3, this)) {
                            AppMethodBeat.o(61172);
                            return false;
                        }
                    } else if (!$assertionsDisabled && !g.x(b2)) {
                        AssertionError assertionError = new AssertionError("In component must be Nothing for out-projection");
                        AppMethodBeat.o(61172);
                        throw assertionError;
                    }
                } else if (!this.TPy.a(avVar2.hBy(), avVar.hBy(), this)) {
                    AppMethodBeat.o(61172);
                    return false;
                }
            }
        }
        AppMethodBeat.o(61172);
        return true;
    }

    private boolean a(av avVar, av avVar2, as asVar) {
        AppMethodBeat.i(61173);
        if (avVar == null) {
            atM(19);
        }
        if (avVar2 == null) {
            atM(20);
        }
        if (asVar == null) {
            atM(21);
        }
        if (asVar.hAJ() != bh.INVARIANT) {
            AppMethodBeat.o(61173);
            return false;
        } else if (avVar.hLI() == bh.INVARIANT || avVar2.hLI() != bh.INVARIANT) {
            AppMethodBeat.o(61173);
            return false;
        } else {
            boolean a2 = this.TPy.a(avVar2.hBy(), avVar);
            AppMethodBeat.o(61173);
            return a2;
        }
    }
}
