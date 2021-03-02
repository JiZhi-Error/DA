package rx.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class e extends RuntimeException {
    public e(String str, Throwable th) {
        super(str, th);
    }

    public e(Throwable th) {
        super(th.getMessage(), th);
        AppMethodBeat.i(90050);
        AppMethodBeat.o(90050);
    }
}
