package kotlin.l.b.a.b.m.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l.b.a.b.m.a.g;
import kotlin.l.b.a.b.m.ab;
import kotlin.l.b.a.b.m.at;

public final class h implements g {
    private final w TPd;

    private static /* synthetic */ void atM(int i2) {
        AppMethodBeat.i(61051);
        Object[] objArr = new Object[3];
        switch (i2) {
            case 1:
                objArr[0] = "procedure";
                break;
            case 2:
                objArr[0] = "subtype";
                break;
            case 3:
                objArr[0] = "supertype";
                break;
            case 4:
                objArr[0] = "a";
                break;
            case 5:
                objArr[0] = "b";
                break;
            default:
                objArr[0] = "equalityAxioms";
                break;
        }
        objArr[1] = "kotlin/reflect/jvm/internal/impl/types/checker/KotlinTypeCheckerImpl";
        switch (i2) {
            case 1:
                objArr[2] = "<init>";
                break;
            case 2:
            case 3:
                objArr[2] = "isSubtypeOf";
                break;
            case 4:
            case 5:
                objArr[2] = "equalTypes";
                break;
            default:
                objArr[2] = "withAxioms";
                break;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        AppMethodBeat.o(61051);
        throw illegalArgumentException;
    }

    public static g b(final g.a aVar) {
        AppMethodBeat.i(61048);
        if (aVar == null) {
            atM(0);
        }
        h hVar = new h(new w(new v() {
            /* class kotlin.l.b.a.b.m.a.h.AnonymousClass1 */

            private static /* synthetic */ void atM(int i2) {
                AppMethodBeat.i(61047);
                Object[] objArr = new Object[3];
                switch (i2) {
                    case 1:
                        objArr[0] = "constructor2";
                        break;
                    default:
                        objArr[0] = "constructor1";
                        break;
                }
                objArr[1] = "kotlin/reflect/jvm/internal/impl/types/checker/KotlinTypeCheckerImpl$1";
                objArr[2] = "assertEqualTypeConstructors";
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
                AppMethodBeat.o(61047);
                throw illegalArgumentException;
            }

            @Override // kotlin.l.b.a.b.m.a.v, kotlin.l.b.a.b.m.a.x
            public final boolean b(at atVar, at atVar2) {
                AppMethodBeat.i(61046);
                if (atVar == null) {
                    atM(0);
                }
                if (atVar2 == null) {
                    atM(1);
                }
                if (atVar.equals(atVar2) || aVar.a(atVar, atVar2)) {
                    AppMethodBeat.o(61046);
                    return true;
                }
                AppMethodBeat.o(61046);
                return false;
            }
        }));
        AppMethodBeat.o(61048);
        return hVar;
    }

    private h(w wVar) {
        this.TPd = wVar;
    }

    @Override // kotlin.l.b.a.b.m.a.g
    public final boolean c(ab abVar, ab abVar2) {
        AppMethodBeat.i(61049);
        if (abVar == null) {
            atM(2);
        }
        if (abVar2 == null) {
            atM(3);
        }
        boolean c2 = this.TPd.c(abVar, abVar2);
        AppMethodBeat.o(61049);
        return c2;
    }

    @Override // kotlin.l.b.a.b.m.a.g
    public final boolean d(ab abVar, ab abVar2) {
        AppMethodBeat.i(61050);
        if (abVar == null) {
            atM(4);
        }
        if (abVar2 == null) {
            atM(5);
        }
        boolean d2 = this.TPd.d(abVar, abVar2);
        AppMethodBeat.o(61050);
        return d2;
    }
}
