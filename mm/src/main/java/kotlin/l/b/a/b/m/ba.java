package kotlin.l.b.a.b.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;
import kotlin.l.b.a.b.a.g;
import kotlin.l.b.a.b.b.a.k;
import kotlin.l.b.a.b.b.a.l;
import kotlin.l.b.a.b.b.as;
import kotlin.l.b.a.b.j.a.a.d;
import kotlin.l.b.a.b.o.c;

public class ba {
    static final /* synthetic */ boolean $assertionsDisabled = (!ba.class.desiredAssertionStatus());
    public static final ba TOF = d(ay.TOD);
    public final ay Tlg;

    private static /* synthetic */ void atM(int i2) {
        String str;
        int i3;
        Throwable illegalStateException;
        AppMethodBeat.i(60870);
        switch (i2) {
            case 6:
            case 9:
            case 10:
            case 11:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 24:
            case 27:
            case 30:
            case 31:
            case 32:
                str = "@NotNull method %s.%s must not return null";
                break;
            case 7:
            case 8:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 23:
            case 25:
            case 26:
            case 28:
            case 29:
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i2) {
            case 6:
            case 9:
            case 10:
            case 11:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 24:
            case 27:
            case 30:
            case 31:
            case 32:
                i3 = 2;
                break;
            case 7:
            case 8:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 23:
            case 25:
            case 26:
            case 28:
            case 29:
            default:
                i3 = 3;
                break;
        }
        Object[] objArr = new Object[i3];
        switch (i2) {
            case 1:
                objArr[0] = "first";
                break;
            case 2:
                objArr[0] = "second";
                break;
            case 3:
                objArr[0] = "substitutionContext";
                break;
            case 4:
                objArr[0] = "context";
                break;
            case 5:
            default:
                objArr[0] = "substitution";
                break;
            case 6:
            case 9:
            case 10:
            case 11:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 24:
            case 27:
            case 30:
            case 31:
            case 32:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/types/TypeSubstitutor";
                break;
            case 7:
            case 12:
                objArr[0] = "type";
                break;
            case 8:
            case 13:
                objArr[0] = "howThisTypeIsUsed";
                break;
            case 14:
            case 15:
            case 26:
                objArr[0] = "typeProjection";
                break;
            case 16:
                objArr[0] = "originalProjection";
                break;
            case 23:
                objArr[0] = "annotations";
                break;
            case 25:
            case 28:
                objArr[0] = "typeParameterVariance";
                break;
            case 29:
                objArr[0] = "projectionKind";
                break;
        }
        switch (i2) {
            case 6:
                objArr[1] = "getSubstitution";
                break;
            case 7:
            case 8:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 23:
            case 25:
            case 26:
            case 28:
            case 29:
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/types/TypeSubstitutor";
                break;
            case 9:
            case 10:
            case 11:
                objArr[1] = "safeSubstitute";
                break;
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
                objArr[1] = "unsafeSubstitute";
                break;
            case 24:
                objArr[1] = "filterOutUnsafeVariance";
                break;
            case 27:
            case 30:
            case 31:
            case 32:
                objArr[1] = "combine";
                break;
        }
        switch (i2) {
            case 1:
            case 2:
                objArr[2] = "createChainedSubstitutor";
                break;
            case 3:
            case 4:
            default:
                objArr[2] = "create";
                break;
            case 5:
                objArr[2] = "<init>";
                break;
            case 6:
            case 9:
            case 10:
            case 11:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 24:
            case 27:
            case 30:
            case 31:
            case 32:
                break;
            case 7:
            case 8:
                objArr[2] = "safeSubstitute";
                break;
            case 12:
            case 13:
            case 14:
                objArr[2] = "substitute";
                break;
            case 15:
                objArr[2] = "substituteWithoutApproximation";
                break;
            case 16:
                objArr[2] = "unsafeSubstitute";
                break;
            case 23:
                objArr[2] = "filterOutUnsafeVariance";
                break;
            case 25:
            case 26:
            case 28:
            case 29:
                objArr[2] = "combine";
                break;
        }
        String format = String.format(str, objArr);
        switch (i2) {
            case 6:
            case 9:
            case 10:
            case 11:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 24:
            case 27:
            case 30:
            case 31:
            case 32:
                illegalStateException = new IllegalStateException(format);
                break;
            case 7:
            case 8:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 23:
            case 25:
            case 26:
            case 28:
            case 29:
            default:
                illegalStateException = new IllegalArgumentException(format);
                break;
        }
        AppMethodBeat.o(60870);
        throw illegalStateException;
    }

    static {
        AppMethodBeat.i(60869);
        AppMethodBeat.o(60869);
    }

    /* access modifiers changed from: package-private */
    public static final class a extends Exception {
        public a(String str) {
            super(str);
        }
    }

    public static ba d(ay ayVar) {
        AppMethodBeat.i(60852);
        if (ayVar == null) {
            atM(0);
        }
        ba baVar = new ba(ayVar);
        AppMethodBeat.o(60852);
        return baVar;
    }

    public static ba b(ay ayVar, ay ayVar2) {
        AppMethodBeat.i(60853);
        if (ayVar == null) {
            atM(1);
        }
        if (ayVar2 == null) {
            atM(2);
        }
        ba d2 = d(q.a(ayVar, ayVar2));
        AppMethodBeat.o(60853);
        return d2;
    }

    public static ba az(ab abVar) {
        AppMethodBeat.i(60854);
        if (abVar == null) {
            atM(4);
        }
        ba d2 = d(au.a(abVar.hKE(), abVar.hKB()));
        AppMethodBeat.o(60854);
        return d2;
    }

    private ba(ay ayVar) {
        if (ayVar == null) {
            atM(5);
        }
        AppMethodBeat.i(60855);
        this.Tlg = ayVar;
        AppMethodBeat.o(60855);
    }

    public final ay hLK() {
        AppMethodBeat.i(60856);
        ay ayVar = this.Tlg;
        if (ayVar == null) {
            atM(6);
        }
        AppMethodBeat.o(60856);
        return ayVar;
    }

    public final ab c(ab abVar, bh bhVar) {
        AppMethodBeat.i(60858);
        if (abVar == null) {
            atM(12);
        }
        if (bhVar == null) {
            atM(13);
        }
        av c2 = c(new ax(bhVar, hLK().a(abVar, bhVar)));
        if (c2 == null) {
            AppMethodBeat.o(60858);
            return null;
        }
        ab hBy = c2.hBy();
        AppMethodBeat.o(60858);
        return hBy;
    }

    private av c(av avVar) {
        AppMethodBeat.i(60859);
        av d2 = d(avVar);
        if (this.Tlg.hLy() || this.Tlg.hKG()) {
            av a2 = kotlin.l.b.a.b.m.e.b.a(d2, this.Tlg.hKG());
            AppMethodBeat.o(60859);
            return a2;
        }
        AppMethodBeat.o(60859);
        return d2;
    }

    private av a(av avVar, int i2) {
        ab c2;
        AppMethodBeat.i(60861);
        if (avVar == null) {
            atM(16);
        }
        a(i2, avVar, this.Tlg);
        if (avVar.hLH()) {
            if (avVar == null) {
                atM(17);
            }
            AppMethodBeat.o(60861);
            return avVar;
        }
        ab hBy = avVar.hBy();
        if (hBy instanceof bd) {
            bg hLC = ((bd) hBy).hLC();
            ab hLD = ((bd) hBy).hLD();
            av a2 = a(new ax(avVar.hLI(), hLC), i2 + 1);
            ax axVar = new ax(a2.hLI(), be.b(a2.hBy().hLF(), c(hLD, avVar.hLI())));
            AppMethodBeat.o(60861);
            return axVar;
        } else if (s.aj(hBy) || (hBy.hLF() instanceof ai)) {
            if (avVar == null) {
                atM(18);
            }
            AppMethodBeat.o(60861);
            return avVar;
        } else {
            av N = this.Tlg.N(hBy);
            bh hLI = avVar.hLI();
            if (N == null && y.al(hBy) && !as.at(hBy)) {
                v am = y.am(hBy);
                av a3 = a(new ax(hLI, am.TNV), i2 + 1);
                av a4 = a(new ax(hLI, am.TNW), i2 + 1);
                bh hLI2 = a3.hLI();
                if (!$assertionsDisabled && ((hLI2 != a4.hLI() || hLI != bh.INVARIANT) && hLI != hLI2)) {
                    AssertionError assertionError = new AssertionError("Unexpected substituted projection kind: " + hLI2 + "; original: " + hLI);
                    AppMethodBeat.o(60861);
                    throw assertionError;
                } else if (a3.hBy() == am.TNV && a4.hBy() == am.TNW) {
                    if (avVar == null) {
                        atM(19);
                    }
                    AppMethodBeat.o(60861);
                    return avVar;
                } else {
                    ax axVar2 = new ax(hLI2, ac.a(az.ay(a3.hBy()), az.ay(a4.hBy())));
                    AppMethodBeat.o(60861);
                    return axVar2;
                }
            } else if (g.x(hBy) || ad.ap(hBy)) {
                if (avVar == null) {
                    atM(20);
                }
                AppMethodBeat.o(60861);
                return avVar;
            } else if (N != null) {
                b b2 = b(hLI, N.hLI());
                if (!d.ad(hBy)) {
                    switch (b2) {
                        case OUT_IN_IN_POSITION:
                            a aVar = new a("Out-projection in in-position");
                            AppMethodBeat.o(60861);
                            throw aVar;
                        case IN_IN_OUT_POSITION:
                            ax axVar3 = new ax(bh.OUT_VARIANCE, hBy.hKE().hBh().hzj());
                            AppMethodBeat.o(60861);
                            return axVar3;
                    }
                }
                k au = as.au(hBy);
                if (N.hLH()) {
                    if (N == null) {
                        atM(21);
                    }
                    AppMethodBeat.o(60861);
                    return N;
                }
                if (au != null) {
                    c2 = au.Q(N.hBy());
                } else {
                    c2 = bc.c(N.hBy(), hBy.hEa());
                }
                if (!hBy.hzL().isEmpty()) {
                    c2 = kotlin.l.b.a.b.m.d.a.a(c2, new k(c2.hzL(), j(this.Tlg.h(hBy.hzL()))));
                }
                ax axVar4 = new ax(b2 == b.NO_CONFLICT ? a(hLI, N.hLI()) : hLI, c2);
                AppMethodBeat.o(60861);
                return axVar4;
            } else {
                av b3 = b(avVar, i2);
                if (b3 == null) {
                    atM(22);
                }
                AppMethodBeat.o(60861);
                return b3;
            }
        }
    }

    private static kotlin.l.b.a.b.b.a.g j(kotlin.l.b.a.b.b.a.g gVar) {
        AppMethodBeat.i(60862);
        if (gVar == null) {
            atM(23);
        }
        if (!gVar.h(g.TcO.TdB)) {
            if (gVar == null) {
                atM(24);
            }
            AppMethodBeat.o(60862);
            return gVar;
        }
        l lVar = new l(gVar, new kotlin.g.a.b<kotlin.l.b.a.b.f.b, Boolean>() {
            /* class kotlin.l.b.a.b.m.ba.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.g.a.b
            public final /* synthetic */ Boolean invoke(kotlin.l.b.a.b.f.b bVar) {
                boolean z = true;
                AppMethodBeat.i(60847);
                kotlin.l.b.a.b.f.b bVar2 = bVar;
                if (bVar2 == null) {
                    IllegalArgumentException illegalArgumentException = new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "name", "kotlin/reflect/jvm/internal/impl/types/TypeSubstitutor$1", "invoke"));
                    AppMethodBeat.o(60847);
                    throw illegalArgumentException;
                }
                if (bVar2.equals(g.TcO.TdB)) {
                    z = false;
                }
                Boolean valueOf = Boolean.valueOf(z);
                AppMethodBeat.o(60847);
                return valueOf;
            }
        }, (byte) 0);
        AppMethodBeat.o(60862);
        return lVar;
    }

    private av b(av avVar, int i2) {
        AppMethodBeat.i(60863);
        ab hBy = avVar.hBy();
        bh hLI = avVar.hLI();
        if (hBy.hKE().hzS() instanceof as) {
            AppMethodBeat.o(60863);
            return avVar;
        }
        ab abVar = null;
        aj aq = am.aq(hBy);
        if (aq != null) {
            abVar = c(aq, bh.INVARIANT);
        }
        ab a2 = az.a(hBy, b(hBy.hKE().getParameters(), hBy.hKB(), i2), this.Tlg.h(hBy.hzL()));
        if ((a2 instanceof aj) && (abVar instanceof aj)) {
            a2 = am.b((aj) a2, (aj) abVar);
        }
        ax axVar = new ax(hLI, a2);
        AppMethodBeat.o(60863);
        return axVar;
    }

    private List<av> b(List<as> list, List<av> list2, int i2) {
        av d2;
        boolean z;
        AppMethodBeat.i(60864);
        ArrayList arrayList = new ArrayList(list.size());
        int i3 = 0;
        boolean z2 = false;
        while (i3 < list.size()) {
            as asVar = list.get(i3);
            av avVar = list2.get(i3);
            av a2 = a(avVar, i2 + 1);
            switch (b(asVar.hAJ(), a2.hLI())) {
                case OUT_IN_IN_POSITION:
                case IN_IN_OUT_POSITION:
                    d2 = bc.d(asVar);
                    break;
                case NO_CONFLICT:
                    if (asVar.hAJ() != bh.INVARIANT && !a2.hLH()) {
                        d2 = new ax(bh.INVARIANT, a2.hBy());
                        break;
                    }
                default:
                    d2 = a2;
                    break;
            }
            if (d2 != avVar) {
                z = true;
            } else {
                z = z2;
            }
            arrayList.add(d2);
            i3++;
            z2 = z;
        }
        if (!z2) {
            AppMethodBeat.o(60864);
            return list2;
        }
        AppMethodBeat.o(60864);
        return arrayList;
    }

    public static bh a(bh bhVar, av avVar) {
        AppMethodBeat.i(60865);
        if (bhVar == null) {
            atM(25);
        }
        if (avVar == null) {
            atM(26);
        }
        if (avVar.hLH()) {
            bh bhVar2 = bh.OUT_VARIANCE;
            if (bhVar2 == null) {
                atM(27);
            }
            AppMethodBeat.o(60865);
            return bhVar2;
        }
        bh a2 = a(bhVar, avVar.hLI());
        AppMethodBeat.o(60865);
        return a2;
    }

    private static bh a(bh bhVar, bh bhVar2) {
        AppMethodBeat.i(60866);
        if (bhVar == null) {
            atM(28);
        }
        if (bhVar2 == null) {
            atM(29);
        }
        if (bhVar == bh.INVARIANT) {
            if (bhVar2 == null) {
                atM(30);
            }
            AppMethodBeat.o(60866);
            return bhVar2;
        } else if (bhVar2 == bh.INVARIANT) {
            if (bhVar == null) {
                atM(31);
            }
            AppMethodBeat.o(60866);
            return bhVar;
        } else if (bhVar == bhVar2) {
            if (bhVar2 == null) {
                atM(32);
            }
            AppMethodBeat.o(60866);
            return bhVar2;
        } else {
            AssertionError assertionError = new AssertionError("Variance conflict: type parameter variance '" + bhVar + "' and projection kind '" + bhVar2 + "' cannot be combined");
            AppMethodBeat.o(60866);
            throw assertionError;
        }
    }

    /* access modifiers changed from: package-private */
    public enum b {
        NO_CONFLICT,
        IN_IN_OUT_POSITION,
        OUT_IN_IN_POSITION;

        public static b valueOf(String str) {
            AppMethodBeat.i(60850);
            b bVar = (b) Enum.valueOf(b.class, str);
            AppMethodBeat.o(60850);
            return bVar;
        }

        static {
            AppMethodBeat.i(60851);
            AppMethodBeat.o(60851);
        }
    }

    private static b b(bh bhVar, bh bhVar2) {
        if (bhVar == bh.IN_VARIANCE && bhVar2 == bh.OUT_VARIANCE) {
            return b.OUT_IN_IN_POSITION;
        }
        if (bhVar == bh.OUT_VARIANCE && bhVar2 == bh.IN_VARIANCE) {
            return b.IN_IN_OUT_POSITION;
        }
        return b.NO_CONFLICT;
    }

    private static void a(int i2, av avVar, ay ayVar) {
        AppMethodBeat.i(60867);
        if (i2 > 100) {
            IllegalStateException illegalStateException = new IllegalStateException("Recursion too deep. Most likely infinite loop while substituting " + fE(avVar) + "; substitution: " + fE(ayVar));
            AppMethodBeat.o(60867);
            throw illegalStateException;
        }
        AppMethodBeat.o(60867);
    }

    private static String fE(Object obj) {
        AppMethodBeat.i(60868);
        try {
            String obj2 = obj.toString();
            AppMethodBeat.o(60868);
            return obj2;
        } catch (Throwable th) {
            if (c.u(th)) {
                RuntimeException runtimeException = (RuntimeException) th;
                AppMethodBeat.o(60868);
                throw runtimeException;
            }
            String str = "[Exception while computing toString(): " + th + "]";
            AppMethodBeat.o(60868);
            return str;
        }
    }

    public final ab b(ab abVar, bh bhVar) {
        AppMethodBeat.i(60857);
        if (abVar == null) {
            atM(7);
        }
        if (bhVar == null) {
            atM(8);
        }
        if (this.Tlg.isEmpty()) {
            if (abVar == null) {
                atM(9);
            }
            AppMethodBeat.o(60857);
        } else {
            try {
                abVar = a(new ax(bhVar, abVar), 0).hBy();
                if (abVar == null) {
                    atM(10);
                }
                AppMethodBeat.o(60857);
            } catch (a e2) {
                abVar = u.bun(e2.getMessage());
                if (abVar == null) {
                    atM(11);
                }
                AppMethodBeat.o(60857);
            }
        }
        return abVar;
    }

    public final av d(av avVar) {
        AppMethodBeat.i(60860);
        if (avVar == null) {
            atM(15);
        }
        if (this.Tlg.isEmpty()) {
            AppMethodBeat.o(60860);
            return avVar;
        }
        try {
            av a2 = a(avVar, 0);
            AppMethodBeat.o(60860);
            return a2;
        } catch (a e2) {
            AppMethodBeat.o(60860);
            return null;
        }
    }
}
