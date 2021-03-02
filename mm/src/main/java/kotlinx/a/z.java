package kotlinx.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, hxF = {"Lkotlinx/serialization/UpdateMode;", "", "(Ljava/lang/String;I)V", "BANNED", "OVERWRITE", "UPDATE", "kotlinx-serialization-runtime"})
public enum z {
    BANNED,
    OVERWRITE,
    UPDATE;

    static {
        AppMethodBeat.i(225360);
        AppMethodBeat.o(225360);
    }

    public static z valueOf(String str) {
        AppMethodBeat.i(225362);
        z zVar = (z) Enum.valueOf(z.class, str);
        AppMethodBeat.o(225362);
        return zVar;
    }
}
