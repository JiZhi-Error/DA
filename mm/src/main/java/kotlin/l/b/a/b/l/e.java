package kotlin.l.b.a.b.l;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

final class e implements Lock {
    public static final Lock TNg = new e();

    static {
        AppMethodBeat.i(60555);
        AppMethodBeat.o(60555);
    }

    private e() {
    }

    public final void lock() {
    }

    public final void unlock() {
    }

    @Override // java.util.concurrent.locks.Lock
    public final void lockInterruptibly() {
        AppMethodBeat.i(60551);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Should not be called");
        AppMethodBeat.o(60551);
        throw unsupportedOperationException;
    }

    public final boolean tryLock() {
        AppMethodBeat.i(60552);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Should not be called");
        AppMethodBeat.o(60552);
        throw unsupportedOperationException;
    }

    public final Condition newCondition() {
        AppMethodBeat.i(60554);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Should not be called");
        AppMethodBeat.o(60554);
        throw unsupportedOperationException;
    }

    @Override // java.util.concurrent.locks.Lock
    public final boolean tryLock(long j2, TimeUnit timeUnit) {
        AppMethodBeat.i(60553);
        if (timeUnit == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "unit", "kotlin/reflect/jvm/internal/impl/storage/NoLock", "tryLock"));
            AppMethodBeat.o(60553);
            throw illegalArgumentException;
        }
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Should not be called");
        AppMethodBeat.o(60553);
        throw unsupportedOperationException;
    }
}
