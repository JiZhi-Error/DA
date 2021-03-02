package kotlin.l.b.a.b.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class b implements a {
    private final g Tih;

    private static /* synthetic */ void atM(int i2) {
        String str;
        int i3;
        Throwable illegalStateException;
        AppMethodBeat.i(56926);
        switch (i2) {
            case 1:
                str = "@NotNull method %s.%s must not return null";
                break;
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i2) {
            case 1:
                i3 = 2;
                break;
            default:
                i3 = 3;
                break;
        }
        Object[] objArr = new Object[i3];
        switch (i2) {
            case 1:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/annotations/AnnotatedImpl";
                break;
            default:
                objArr[0] = "annotations";
                break;
        }
        switch (i2) {
            case 1:
                objArr[1] = "getAnnotations";
                break;
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/annotations/AnnotatedImpl";
                break;
        }
        switch (i2) {
            case 1:
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String format = String.format(str, objArr);
        switch (i2) {
            case 1:
                illegalStateException = new IllegalStateException(format);
                break;
            default:
                illegalStateException = new IllegalArgumentException(format);
                break;
        }
        AppMethodBeat.o(56926);
        throw illegalStateException;
    }

    public b(g gVar) {
        if (gVar == null) {
            atM(0);
        }
        AppMethodBeat.i(56924);
        this.Tih = gVar;
        AppMethodBeat.o(56924);
    }

    @Override // kotlin.l.b.a.b.b.a.a
    public g hzL() {
        AppMethodBeat.i(56925);
        g gVar = this.Tih;
        if (gVar == null) {
            atM(1);
        }
        AppMethodBeat.o(56925);
        return gVar;
    }
}
