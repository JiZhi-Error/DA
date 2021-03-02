package a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class i<TResult> {
    final h<TResult> aCe = new h<>();

    public i() {
        AppMethodBeat.i(53005);
        AppMethodBeat.o(53005);
    }

    private boolean trySetResult(TResult tresult) {
        AppMethodBeat.i(53006);
        boolean trySetResult = this.aCe.trySetResult(tresult);
        AppMethodBeat.o(53006);
        return trySetResult;
    }

    private boolean b(Exception exc) {
        AppMethodBeat.i(53007);
        boolean b2 = this.aCe.b(exc);
        AppMethodBeat.o(53007);
        return b2;
    }

    public final void setResult(TResult tresult) {
        AppMethodBeat.i(53009);
        if (!trySetResult(tresult)) {
            IllegalStateException illegalStateException = new IllegalStateException("Cannot set the result of a completed task.");
            AppMethodBeat.o(53009);
            throw illegalStateException;
        }
        AppMethodBeat.o(53009);
    }

    public final void c(Exception exc) {
        AppMethodBeat.i(53010);
        if (!b(exc)) {
            IllegalStateException illegalStateException = new IllegalStateException("Cannot set the error on a completed task.");
            AppMethodBeat.o(53010);
            throw illegalStateException;
        }
        AppMethodBeat.o(53010);
    }

    public final void nK() {
        AppMethodBeat.i(53008);
        if (!this.aCe.nJ()) {
            IllegalStateException illegalStateException = new IllegalStateException("Cannot cancel a completed task.");
            AppMethodBeat.o(53008);
            throw illegalStateException;
        }
        AppMethodBeat.o(53008);
    }
}
