package kotlin.l.b.a.b.f;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class h {
    public static final f TDd = f.bua("<no name provided>");
    public static final f TDe = f.bua("<root package>");
    public static final f TDf = f.btY("Companion");
    public static final f TDg = f.btY("no_name_in_PSI_3d19d79d_1ba9_4cd0_b7f5_b46aa3cd5d40");
    public static final f TDh = f.bua("<anonymous>");

    private static /* synthetic */ void atM(int i2) {
        String str;
        int i3;
        Throwable illegalArgumentException;
        AppMethodBeat.i(59337);
        switch (i2) {
            case 1:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
            default:
                str = "@NotNull method %s.%s must not return null";
                break;
        }
        switch (i2) {
            case 1:
                i3 = 3;
                break;
            default:
                i3 = 2;
                break;
        }
        Object[] objArr = new Object[i3];
        switch (i2) {
            case 1:
                objArr[0] = "name";
                break;
            default:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/name/SpecialNames";
                break;
        }
        switch (i2) {
            case 1:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/name/SpecialNames";
                break;
            default:
                objArr[1] = "safeIdentifier";
                break;
        }
        switch (i2) {
            case 1:
                objArr[2] = "isSafeIdentifier";
                break;
        }
        String format = String.format(str, objArr);
        switch (i2) {
            case 1:
                illegalArgumentException = new IllegalArgumentException(format);
                break;
            default:
                illegalArgumentException = new IllegalStateException(format);
                break;
        }
        AppMethodBeat.o(59337);
        throw illegalArgumentException;
    }

    static {
        AppMethodBeat.i(59336);
        AppMethodBeat.o(59336);
    }

    public static f v(f fVar) {
        AppMethodBeat.i(59334);
        if (fVar == null || fVar.TDa) {
            fVar = TDg;
        }
        if (fVar == null) {
            atM(0);
        }
        AppMethodBeat.o(59334);
        return fVar;
    }

    public static boolean w(f fVar) {
        AppMethodBeat.i(59335);
        if (fVar == null) {
            atM(1);
        }
        if (fVar.sG().isEmpty() || fVar.TDa) {
            AppMethodBeat.o(59335);
            return false;
        }
        AppMethodBeat.o(59335);
        return true;
    }
}
