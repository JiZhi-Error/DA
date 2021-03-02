package kotlin.l.b.a.b.j.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l.b.a.b.m.ab;

public final class h extends a {
    private static /* synthetic */ void atM(int i2) {
        AppMethodBeat.i(60261);
        Object[] objArr = new Object[3];
        switch (i2) {
            case 2:
                objArr[0] = "newType";
                break;
            default:
                objArr[0] = "type";
                break;
        }
        objArr[1] = "kotlin/reflect/jvm/internal/impl/resolve/scopes/receivers/TransientReceiver";
        switch (i2) {
            case 2:
                objArr[2] = "replaceType";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        AppMethodBeat.o(60261);
        throw illegalArgumentException;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public h(ab abVar) {
        this(abVar, (byte) 0);
        if (abVar == null) {
            atM(0);
        }
        AppMethodBeat.i(60258);
        AppMethodBeat.o(60258);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private h(ab abVar, byte b2) {
        super(abVar, null);
        if (abVar == null) {
            atM(1);
        }
        AppMethodBeat.i(60259);
        AppMethodBeat.o(60259);
    }

    public final String toString() {
        AppMethodBeat.i(60260);
        String str = "{Transient} : " + hBy();
        AppMethodBeat.o(60260);
        return str;
    }
}
