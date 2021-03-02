package rx.schedulers;

import com.tencent.matrix.trace.core.AppMethodBeat;
import rx.g;

@Deprecated
public final class ImmediateScheduler extends g {
    private ImmediateScheduler() {
        AppMethodBeat.i(90088);
        IllegalStateException illegalStateException = new IllegalStateException("No instances!");
        AppMethodBeat.o(90088);
        throw illegalStateException;
    }

    @Override // rx.g
    public final g.a createWorker() {
        return null;
    }
}
