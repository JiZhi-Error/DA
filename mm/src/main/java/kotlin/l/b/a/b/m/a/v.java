package kotlin.l.b.a.b.m.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l.b.a.b.m.ab;
import kotlin.l.b.a.b.m.at;
import kotlin.l.b.a.b.m.av;

/* access modifiers changed from: package-private */
public class v implements x {
    private static /* synthetic */ void atM(int i2) {
        AppMethodBeat.i(61156);
        Object[] objArr = new Object[3];
        switch (i2) {
            case 1:
            case 4:
                objArr[0] = "b";
                break;
            case 2:
            case 7:
                objArr[0] = "typeCheckingProcedure";
                break;
            case 3:
            default:
                objArr[0] = "a";
                break;
            case 5:
            case 10:
                objArr[0] = "subtype";
                break;
            case 6:
            case 11:
                objArr[0] = "supertype";
                break;
            case 8:
                objArr[0] = "type";
                break;
            case 9:
                objArr[0] = "typeProjection";
                break;
        }
        objArr[1] = "kotlin/reflect/jvm/internal/impl/types/checker/TypeCheckerProcedureCallbacksImpl";
        switch (i2) {
            case 3:
            case 4:
                objArr[2] = "assertEqualTypeConstructors";
                break;
            case 5:
            case 6:
            case 7:
                objArr[2] = "assertSubtype";
                break;
            case 8:
            case 9:
                objArr[2] = "capture";
                break;
            case 10:
            case 11:
                objArr[2] = "noCorrespondingSupertype";
                break;
            default:
                objArr[2] = "assertEqualTypes";
                break;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        AppMethodBeat.o(61156);
        throw illegalArgumentException;
    }

    v() {
    }

    @Override // kotlin.l.b.a.b.m.a.x
    public final boolean a(ab abVar, ab abVar2, w wVar) {
        AppMethodBeat.i(61151);
        if (abVar == null) {
            atM(0);
        }
        if (abVar2 == null) {
            atM(1);
        }
        boolean d2 = wVar.d(abVar, abVar2);
        AppMethodBeat.o(61151);
        return d2;
    }

    @Override // kotlin.l.b.a.b.m.a.x
    public boolean b(at atVar, at atVar2) {
        AppMethodBeat.i(61152);
        if (atVar == null) {
            atM(3);
        }
        if (atVar2 == null) {
            atM(4);
        }
        boolean equals = atVar.equals(atVar2);
        AppMethodBeat.o(61152);
        return equals;
    }

    @Override // kotlin.l.b.a.b.m.a.x
    public final boolean b(ab abVar, ab abVar2, w wVar) {
        AppMethodBeat.i(61153);
        if (abVar == null) {
            atM(5);
        }
        if (abVar2 == null) {
            atM(6);
        }
        boolean c2 = wVar.c(abVar, abVar2);
        AppMethodBeat.o(61153);
        return c2;
    }

    @Override // kotlin.l.b.a.b.m.a.x
    public final boolean a(ab abVar, av avVar) {
        AppMethodBeat.i(61154);
        if (abVar == null) {
            atM(8);
        }
        if (avVar == null) {
            atM(9);
        }
        AppMethodBeat.o(61154);
        return false;
    }

    @Override // kotlin.l.b.a.b.m.a.x
    public final boolean e(ab abVar, ab abVar2) {
        AppMethodBeat.i(61155);
        if (abVar == null) {
            atM(10);
        }
        if (abVar2 == null) {
            atM(11);
        }
        AppMethodBeat.o(61155);
        return false;
    }
}
