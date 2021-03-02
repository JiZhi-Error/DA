package kotlin.l.b.a.b.j.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l.b.a.b.b.a;
import kotlin.l.b.a.b.m.ab;

public final class b extends a implements d {
    private final a TKn;

    private static /* synthetic */ void atM(int i2) {
        String str;
        int i3;
        Throwable illegalStateException;
        AppMethodBeat.i(60251);
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
                objArr[0] = "receiverType";
                break;
            case 2:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/resolve/scopes/receivers/ExtensionReceiver";
                break;
            case 3:
                objArr[0] = "newType";
                break;
            default:
                objArr[0] = "callableDescriptor";
                break;
        }
        switch (i2) {
            case 2:
                objArr[1] = "getDeclarationDescriptor";
                break;
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/resolve/scopes/receivers/ExtensionReceiver";
                break;
        }
        switch (i2) {
            case 2:
                break;
            case 3:
                objArr[2] = "replaceType";
                break;
            default:
                objArr[2] = "<init>";
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
        AppMethodBeat.o(60251);
        throw illegalStateException;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(a aVar, ab abVar, e eVar) {
        super(abVar, eVar);
        if (aVar == null) {
            atM(0);
        }
        if (abVar == null) {
            atM(1);
        }
        AppMethodBeat.i(60249);
        this.TKn = aVar;
        AppMethodBeat.o(60249);
    }

    public final String toString() {
        AppMethodBeat.i(60250);
        String str = hBy() + ": Ext {" + this.TKn + "}";
        AppMethodBeat.o(60250);
        return str;
    }
}
