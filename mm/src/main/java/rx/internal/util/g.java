package rx.internal.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

public final class g extends AtomicLong implements ThreadFactory {
    public static final ThreadFactory Unq = new ThreadFactory() {
        /* class rx.internal.util.g.AnonymousClass1 */

        public final Thread newThread(Runnable runnable) {
            AppMethodBeat.i(90205);
            AssertionError assertionError = new AssertionError("No threads allowed.");
            AppMethodBeat.o(90205);
            throw assertionError;
        }
    };
    final String prefix;

    static {
        AppMethodBeat.i(90207);
        AppMethodBeat.o(90207);
    }

    public g(String str) {
        this.prefix = str;
    }

    public final Thread newThread(Runnable runnable) {
        AppMethodBeat.i(90206);
        Thread thread = new Thread(runnable, this.prefix + incrementAndGet());
        thread.setDaemon(true);
        AppMethodBeat.o(90206);
        return thread;
    }
}
