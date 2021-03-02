package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0000\b\u0010\u0018\u00002\u00020\u000fB\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\u0002\u001a\u00020\u00018\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0002\u0010\fR\u0013\u0010\u0004\u001a\u00020\u00038F@\u0006¢\u0006\u0006\u001a\u0004\b\r\u0010\b¨\u0006\u000e"}, hxF = {"Lkotlinx/coroutines/CompletedExceptionally;", "", "cause", "", "handled", "<init>", "(Ljava/lang/Throwable;Z)V", "makeHandled", "()Z", "", "toString", "()Ljava/lang/String;", "Ljava/lang/Throwable;", "getHandled", "kotlinx-coroutines-core", ""})
public class v {
    private static final AtomicIntegerFieldUpdater TTN = AtomicIntegerFieldUpdater.newUpdater(v.class, "_handled");
    private volatile int _handled;
    public final Throwable cause;

    static {
        AppMethodBeat.i(192376);
        AppMethodBeat.o(192376);
    }

    public v(Throwable th, boolean z) {
        this.cause = th;
        this._handled = z ? 1 : 0;
    }

    public /* synthetic */ v(Throwable th) {
        this(th, false);
        AppMethodBeat.i(118158);
        AppMethodBeat.o(118158);
    }

    public final boolean hME() {
        AppMethodBeat.i(192375);
        boolean compareAndSet = TTN.compareAndSet(this, 0, 1);
        AppMethodBeat.o(192375);
        return compareAndSet;
    }

    public String toString() {
        AppMethodBeat.i(118157);
        String str = getClass().getSimpleName() + '[' + this.cause + ']';
        AppMethodBeat.o(118157);
        return str;
    }
}
