package kotlinx.coroutines.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.d.f;
import kotlin.l;
import kotlinx.coroutines.at;
import kotlinx.coroutines.bc;
import kotlinx.coroutines.ce;
import kotlinx.coroutines.k;

/* access modifiers changed from: package-private */
@l(hxD = {1, 1, 16}, hxE = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u001b\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0019\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH@ø\u0001\u0000¢\u0006\u0002\u0010\u000fJ\u001c\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\n\u0010\u0014\u001a\u00060\u0015j\u0002`\u0016H\u0016J\u001c\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u000e2\n\u0010\u0014\u001a\u00060\u0015j\u0002`\u0016H\u0016J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u001c\u001a\u00020\u0011H\u0002J\u001e\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u000e2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\f0\u001fH\u0016J\b\u0010 \u001a\u00020\u0006H\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\u00018VX\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n\u0002\u0004\n\u0002\b\u0019¨\u0006!"}, hxF = {"Lkotlinx/coroutines/internal/MissingMainCoroutineDispatcher;", "Lkotlinx/coroutines/MainCoroutineDispatcher;", "Lkotlinx/coroutines/Delay;", "cause", "", "errorHint", "", "(Ljava/lang/Throwable;Ljava/lang/String;)V", "immediate", "getImmediate", "()Lkotlinx/coroutines/MainCoroutineDispatcher;", "delay", "", "time", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "dispatch", "", "context", "Lkotlin/coroutines/CoroutineContext;", "block", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "invokeOnTimeout", "Lkotlinx/coroutines/DisposableHandle;", "timeMillis", "isDispatchNeeded", "", "missing", "scheduleResumeAfterDelay", "continuation", "Lkotlinx/coroutines/CancellableContinuation;", "toString", "kotlinx-coroutines-core"})
public final class p extends ce implements at {
    private final String TWd;
    private final Throwable cause;

    public p(Throwable th, String str) {
        this.cause = th;
        this.TWd = str;
    }

    @Override // kotlinx.coroutines.ad
    public final boolean hMH() {
        AppMethodBeat.i(192452);
        hNQ();
        AppMethodBeat.o(192452);
        throw null;
    }

    @Override // kotlinx.coroutines.at
    public final bc d(long j2, Runnable runnable) {
        AppMethodBeat.i(192453);
        hNQ();
        AppMethodBeat.o(192453);
        throw null;
    }

    private final Void hNQ() {
        String str;
        AppMethodBeat.i(192456);
        if (this.cause == null) {
            o.hNP();
            AppMethodBeat.o(192456);
            throw null;
        }
        StringBuilder sb = new StringBuilder("Module with the Main dispatcher had failed to initialize");
        String str2 = this.TWd;
        if (str2 == null || (str = ". ".concat(String.valueOf(str2))) == null) {
            str = "";
        }
        IllegalStateException illegalStateException = new IllegalStateException(sb.append((Object) str).toString(), this.cause);
        AppMethodBeat.o(192456);
        throw illegalStateException;
    }

    @Override // kotlinx.coroutines.ad
    public final String toString() {
        AppMethodBeat.i(192457);
        String str = "Main[missing" + (this.cause != null ? ", cause=" + this.cause : "") + ']';
        AppMethodBeat.o(192457);
        return str;
    }

    @Override // kotlinx.coroutines.ad
    public final /* synthetic */ void a(f fVar, Runnable runnable) {
        AppMethodBeat.i(192454);
        hNQ();
        AppMethodBeat.o(192454);
        throw null;
    }

    @Override // kotlinx.coroutines.at
    public final /* synthetic */ void a(long j2, k kVar) {
        AppMethodBeat.i(192455);
        hNQ();
        AppMethodBeat.o(192455);
        throw null;
    }
}
