package rx.internal.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import rx.d;
import rx.i;

public enum b implements d.a<Object> {
    INSTANCE;
    
    static final d<Object> Ukx = d.a((d.a) INSTANCE);

    public static b valueOf(String str) {
        AppMethodBeat.i(90246);
        b bVar = (b) Enum.valueOf(b.class, str);
        AppMethodBeat.o(90246);
        return bVar;
    }

    @Override // rx.b.b
    public final /* synthetic */ void cA(Object obj) {
        AppMethodBeat.i(90247);
        ((i) obj).hQw();
        AppMethodBeat.o(90247);
    }

    static {
        AppMethodBeat.i(90248);
        AppMethodBeat.o(90248);
    }

    public static <T> d<T> hQF() {
        return (d<T>) Ukx;
    }
}
