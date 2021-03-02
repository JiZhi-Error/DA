package kotlin.l.b.a.b.b.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l.b.a.b.b.a.g;
import kotlin.l.b.a.b.b.e;
import kotlin.l.b.a.b.b.l;
import kotlin.l.b.a.b.j.f.a.c;

public final class q extends c {
    private final e Tlv;
    private final c Tlw;

    private static /* synthetic */ void atM(int i2) {
        String str;
        int i3;
        Throwable illegalStateException;
        AppMethodBeat.i(57121);
        switch (i2) {
            case 1:
            case 2:
                str = "@NotNull method %s.%s must not return null";
                break;
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i2) {
            case 1:
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
            case 2:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/LazyClassReceiverParameterDescriptor";
                break;
            case 3:
                objArr[0] = "newOwner";
                break;
            default:
                objArr[0] = "descriptor";
                break;
        }
        switch (i2) {
            case 1:
                objArr[1] = "getValue";
                break;
            case 2:
                objArr[1] = "getContainingDeclaration";
                break;
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/LazyClassReceiverParameterDescriptor";
                break;
        }
        switch (i2) {
            case 1:
            case 2:
                break;
            case 3:
                objArr[2] = "copy";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String format = String.format(str, objArr);
        switch (i2) {
            case 1:
            case 2:
                illegalStateException = new IllegalStateException(format);
                break;
            default:
                illegalStateException = new IllegalArgumentException(format);
                break;
        }
        AppMethodBeat.o(57121);
        throw illegalStateException;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public q(e eVar) {
        super(g.a.hBP());
        if (eVar == null) {
            atM(0);
        }
        g.a aVar = g.TiC;
        AppMethodBeat.i(57117);
        this.Tlv = eVar;
        this.Tlw = new c(eVar);
        AppMethodBeat.o(57117);
    }

    @Override // kotlin.l.b.a.b.b.ak
    public final kotlin.l.b.a.b.j.f.a.e hBt() {
        AppMethodBeat.i(57118);
        c cVar = this.Tlw;
        if (cVar == null) {
            atM(1);
        }
        AppMethodBeat.o(57118);
        return cVar;
    }

    @Override // kotlin.l.b.a.b.b.m, kotlin.l.b.a.b.b.l, kotlin.l.b.a.b.b.au
    public final l hzx() {
        AppMethodBeat.i(57119);
        e eVar = this.Tlv;
        if (eVar == null) {
            atM(2);
        }
        AppMethodBeat.o(57119);
        return eVar;
    }

    @Override // kotlin.l.b.a.b.b.c.j
    public final String toString() {
        AppMethodBeat.i(57120);
        String str = "class " + this.Tlv.hAH() + "::this";
        AppMethodBeat.o(57120);
        return str;
    }
}
