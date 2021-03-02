package a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Closeable;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ScheduledFuture;

public final class e implements Closeable {
    final List<d> aBJ;
    private ScheduledFuture<?> aBK;
    private boolean aBL;
    private boolean closed;
    final Object lock;

    public final boolean isCancellationRequested() {
        boolean z;
        AppMethodBeat.i(52984);
        synchronized (this.lock) {
            try {
                nF();
                z = this.aBL;
            } finally {
                AppMethodBeat.o(52984);
            }
        }
        return z;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        AppMethodBeat.i(52985);
        synchronized (this.lock) {
            try {
                if (!this.closed) {
                    if (this.aBK != null) {
                        this.aBK.cancel(true);
                        this.aBK = null;
                    }
                    for (d dVar : this.aBJ) {
                        dVar.close();
                    }
                    this.aBJ.clear();
                    this.closed = true;
                    AppMethodBeat.o(52985);
                }
            } finally {
                AppMethodBeat.o(52985);
            }
        }
    }

    public final String toString() {
        AppMethodBeat.i(52986);
        String format = String.format(Locale.US, "%s@%s[cancellationRequested=%s]", getClass().getName(), Integer.toHexString(hashCode()), Boolean.toString(isCancellationRequested()));
        AppMethodBeat.o(52986);
        return format;
    }

    /* access modifiers changed from: package-private */
    public final void nF() {
        AppMethodBeat.i(52987);
        if (this.closed) {
            IllegalStateException illegalStateException = new IllegalStateException("Object already closed");
            AppMethodBeat.o(52987);
            throw illegalStateException;
        }
        AppMethodBeat.o(52987);
    }
}
