package kotlin;

import com.tencent.matrix.trace.core.AppMethodBeat;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, hxF = {"Lkotlin/LazyThreadSafetyMode;", "", "(Ljava/lang/String;I)V", "SYNCHRONIZED", "PUBLICATION", "NONE", "kotlin-stdlib"})
public enum k {
    SYNCHRONIZED,
    PUBLICATION,
    NONE;

    static {
        AppMethodBeat.i(129289);
        AppMethodBeat.o(129289);
    }

    public static k valueOf(String str) {
        AppMethodBeat.i(129291);
        k kVar = (k) Enum.valueOf(k.class, str);
        AppMethodBeat.o(129291);
        return kVar;
    }
}
