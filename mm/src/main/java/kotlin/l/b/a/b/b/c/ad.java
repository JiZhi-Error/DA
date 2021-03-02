package kotlin.l.b.a.b.b.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l.b.a.b.b.a.g;
import kotlin.l.b.a.b.b.l;
import kotlin.l.b.a.b.j.f.a.e;

public final class ad extends c {
    private final l Tko;
    private final e Tmk;

    private static /* synthetic */ void atM(int i2) {
        String str;
        int i3;
        Throwable illegalStateException;
        AppMethodBeat.i(57276);
        switch (i2) {
            case 3:
            case 4:
                str = "@NotNull method %s.%s must not return null";
                break;
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i2) {
            case 3:
            case 4:
                i3 = 2;
                break;
            default:
                i3 = 3;
                break;
        }
        Object[] objArr = new Object[i3];
        switch (i2) {
            case 1:
                objArr[0] = "value";
                break;
            case 2:
                objArr[0] = "annotations";
                break;
            case 3:
            case 4:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/ReceiverParameterDescriptorImpl";
                break;
            case 5:
                objArr[0] = "newOwner";
                break;
            default:
                objArr[0] = "containingDeclaration";
                break;
        }
        switch (i2) {
            case 3:
                objArr[1] = "getValue";
                break;
            case 4:
                objArr[1] = "getContainingDeclaration";
                break;
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/ReceiverParameterDescriptorImpl";
                break;
        }
        switch (i2) {
            case 3:
            case 4:
                break;
            case 5:
                objArr[2] = "copy";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String format = String.format(str, objArr);
        switch (i2) {
            case 3:
            case 4:
                illegalStateException = new IllegalStateException(format);
                break;
            default:
                illegalStateException = new IllegalArgumentException(format);
                break;
        }
        AppMethodBeat.o(57276);
        throw illegalStateException;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ad(l lVar, e eVar, g gVar) {
        super(gVar);
        if (lVar == null) {
            atM(0);
        }
        if (gVar == null) {
            atM(2);
        }
        AppMethodBeat.i(57273);
        this.Tko = lVar;
        this.Tmk = eVar;
        AppMethodBeat.o(57273);
    }

    @Override // kotlin.l.b.a.b.b.ak
    public final e hBt() {
        AppMethodBeat.i(57274);
        e eVar = this.Tmk;
        if (eVar == null) {
            atM(3);
        }
        AppMethodBeat.o(57274);
        return eVar;
    }

    @Override // kotlin.l.b.a.b.b.m, kotlin.l.b.a.b.b.l, kotlin.l.b.a.b.b.au
    public final l hzx() {
        AppMethodBeat.i(57275);
        l lVar = this.Tko;
        if (lVar == null) {
            atM(4);
        }
        AppMethodBeat.o(57275);
        return lVar;
    }
}
