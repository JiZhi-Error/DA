package rx.internal.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.ThreadFactory;
import rx.g;

public final class g extends rx.g {
    private final ThreadFactory RSH;

    public g(ThreadFactory threadFactory) {
        this.RSH = threadFactory;
    }

    @Override // rx.g
    public final g.a createWorker() {
        AppMethodBeat.i(90385);
        h hVar = new h(this.RSH);
        AppMethodBeat.o(90385);
        return hVar;
    }
}
