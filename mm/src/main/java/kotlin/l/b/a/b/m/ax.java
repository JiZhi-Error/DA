package kotlin.l.b.a.b.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l.b.a.b.m.a.i;

public final class ax extends aw {
    private final bh TOC;
    private final ab Tbs;

    private static /* synthetic */ void atM(int i2) {
        String str;
        int i3;
        Throwable illegalStateException;
        AppMethodBeat.i(60841);
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
            case 2:
                objArr[0] = "type";
                break;
            case 3:
            case 4:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/types/TypeProjectionImpl";
                break;
            case 5:
                objArr[0] = "kotlinTypeRefiner";
                break;
            default:
                objArr[0] = "projection";
                break;
        }
        switch (i2) {
            case 3:
                objArr[1] = "getProjectionKind";
                break;
            case 4:
                objArr[1] = "getType";
                break;
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/types/TypeProjectionImpl";
                break;
        }
        switch (i2) {
            case 3:
            case 4:
                break;
            case 5:
                objArr[2] = "refine";
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
        AppMethodBeat.o(60841);
        throw illegalStateException;
    }

    public ax(bh bhVar, ab abVar) {
        if (bhVar == null) {
            atM(0);
        }
        if (abVar == null) {
            atM(1);
        }
        AppMethodBeat.i(60836);
        this.TOC = bhVar;
        this.Tbs = abVar;
        AppMethodBeat.o(60836);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ax(ab abVar) {
        this(bh.INVARIANT, abVar);
        if (abVar == null) {
            atM(2);
        }
        AppMethodBeat.i(60837);
        AppMethodBeat.o(60837);
    }

    @Override // kotlin.l.b.a.b.m.av
    public final bh hLI() {
        AppMethodBeat.i(60838);
        bh bhVar = this.TOC;
        if (bhVar == null) {
            atM(3);
        }
        AppMethodBeat.o(60838);
        return bhVar;
    }

    @Override // kotlin.l.b.a.b.m.av
    public final ab hBy() {
        AppMethodBeat.i(60839);
        ab abVar = this.Tbs;
        if (abVar == null) {
            atM(4);
        }
        AppMethodBeat.o(60839);
        return abVar;
    }

    @Override // kotlin.l.b.a.b.m.av
    public final boolean hLH() {
        return false;
    }

    @Override // kotlin.l.b.a.b.m.av
    public final av m(i iVar) {
        AppMethodBeat.i(60840);
        if (iVar == null) {
            atM(5);
        }
        ax axVar = new ax(this.TOC, iVar.aK(this.Tbs));
        AppMethodBeat.o(60840);
        return axVar;
    }
}
