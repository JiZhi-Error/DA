package rx.internal.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicInteger;
import rx.a.b;
import rx.f;
import rx.i;

public final class a<T> extends AtomicInteger implements f {
    final i<? super T> UkX;
    T value;

    public a(i<? super T> iVar) {
        this.UkX = iVar;
    }

    @Override // rx.f
    public final void Pw(long j2) {
        AppMethodBeat.i(90307);
        if (j2 < 0) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("n >= 0 required");
            AppMethodBeat.o(90307);
            throw illegalArgumentException;
        } else if (j2 == 0) {
            AppMethodBeat.o(90307);
        } else {
            while (true) {
                int i2 = get();
                if (i2 == 0) {
                    if (compareAndSet(0, 2)) {
                        break;
                    }
                } else if (i2 == 1 && compareAndSet(1, 3)) {
                    a(this.UkX, this.value);
                }
            }
            AppMethodBeat.o(90307);
        }
    }

    public final void setValue(T t) {
        AppMethodBeat.i(90308);
        while (true) {
            int i2 = get();
            if (i2 == 0) {
                this.value = t;
                if (compareAndSet(0, 1)) {
                    break;
                }
            } else if (i2 == 2 && compareAndSet(2, 3)) {
                a(this.UkX, t);
            }
        }
        AppMethodBeat.o(90308);
    }

    private static <T> void a(i<? super T> iVar, T t) {
        AppMethodBeat.i(90309);
        if (iVar.Ukg.UnB) {
            AppMethodBeat.o(90309);
            return;
        }
        try {
            iVar.gL(t);
            if (iVar.Ukg.UnB) {
                AppMethodBeat.o(90309);
                return;
            }
            iVar.hQw();
            AppMethodBeat.o(90309);
        } catch (Throwable th) {
            b.a(th, iVar, t);
            AppMethodBeat.o(90309);
        }
    }
}
