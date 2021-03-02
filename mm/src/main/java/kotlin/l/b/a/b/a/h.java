package kotlin.l.b.a.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;
import kotlin.l.b.a.b.f.b;
import kotlin.l.b.a.b.f.f;

public enum h {
    BOOLEAN("Boolean"),
    CHAR("Char"),
    BYTE("Byte"),
    SHORT("Short"),
    INT("Int"),
    FLOAT("Float"),
    LONG("Long"),
    DOUBLE("Double");
    
    public static final Set<h> TeC = Collections.unmodifiableSet(EnumSet.of(CHAR, BYTE, SHORT, INT, FLOAT, LONG, DOUBLE));
    public final f TeD;
    public final f TeE;
    public b TeF = null;
    public b TeG = null;

    public static /* synthetic */ void atM(int i2) {
        AppMethodBeat.i(56688);
        Object[] objArr = new Object[2];
        objArr[0] = "kotlin/reflect/jvm/internal/impl/builtins/PrimitiveType";
        switch (i2) {
            case 1:
            case 2:
                objArr[1] = "getTypeFqName";
                break;
            case 3:
                objArr[1] = "getArrayTypeName";
                break;
            case 4:
            case 5:
                objArr[1] = "getArrayTypeFqName";
                break;
            default:
                objArr[1] = "getTypeName";
                break;
        }
        IllegalStateException illegalStateException = new IllegalStateException(String.format("@NotNull method %s.%s must not return null", objArr));
        AppMethodBeat.o(56688);
        throw illegalStateException;
    }

    public static h valueOf(String str) {
        AppMethodBeat.i(56683);
        h hVar = (h) Enum.valueOf(h.class, str);
        AppMethodBeat.o(56683);
        return hVar;
    }

    static {
        AppMethodBeat.i(56687);
        AppMethodBeat.o(56687);
    }

    private h(String str) {
        AppMethodBeat.i(56684);
        this.TeD = f.btY(str);
        this.TeE = f.btY(str + "Array");
        AppMethodBeat.o(56684);
    }

    public final f hzt() {
        AppMethodBeat.i(56685);
        f fVar = this.TeD;
        if (fVar == null) {
            atM(0);
        }
        AppMethodBeat.o(56685);
        return fVar;
    }

    public final f hzu() {
        AppMethodBeat.i(56686);
        f fVar = this.TeE;
        if (fVar == null) {
            atM(3);
        }
        AppMethodBeat.o(56686);
        return fVar;
    }
}
