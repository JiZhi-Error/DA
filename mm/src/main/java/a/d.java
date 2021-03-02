package a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Closeable;

public final class d implements Closeable {
    private e aBH;
    private Runnable aBI;
    private boolean closed;
    private final Object lock;

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        AppMethodBeat.i(52983);
        synchronized (this.lock) {
            try {
                if (!this.closed) {
                    this.closed = true;
                    e eVar = this.aBH;
                    synchronized (eVar.lock) {
                        try {
                            eVar.nF();
                            eVar.aBJ.remove(this);
                        } catch (Throwable th) {
                            AppMethodBeat.o(52983);
                            throw th;
                        }
                    }
                    this.aBH = null;
                    this.aBI = null;
                    AppMethodBeat.o(52983);
                }
            } finally {
                AppMethodBeat.o(52983);
            }
        }
    }
}
