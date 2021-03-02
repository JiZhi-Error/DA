package rx.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class f extends RuntimeException {
    public f(String str, Throwable th) {
        super(str, th);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public f(Throwable th) {
        super(th != null ? th.getMessage() : null, th == null ? new NullPointerException() : th);
        AppMethodBeat.i(90051);
        AppMethodBeat.o(90051);
    }
}
