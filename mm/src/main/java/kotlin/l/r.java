package kotlin.l;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, hxF = {"Lkotlin/reflect/KVariance;", "", "(Ljava/lang/String;I)V", "INVARIANT", "IN", "OUT", "kotlin-stdlib"})
public enum r {
    INVARIANT,
    IN,
    OUT;

    static {
        AppMethodBeat.i(129551);
        AppMethodBeat.o(129551);
    }

    public static r valueOf(String str) {
        AppMethodBeat.i(129553);
        r rVar = (r) Enum.valueOf(r.class, str);
        AppMethodBeat.o(129553);
        return rVar;
    }
}
