package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.d.a.b;
import kotlin.d.d;
import kotlin.d.f;
import kotlin.l;
import kotlinx.coroutines.internal.s;

/* access modifiers changed from: package-private */
@l(hxD = {1, 1, 16}, hxE = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\b\u0002\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u00028\u00000\u0015B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0014¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\r\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0014¢\u0006\u0004\b\r\u0010\fJ\u000f\u0010\u000e\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0013\u0010\u0012¨\u0006\u0014"}, hxF = {"Lkotlinx/coroutines/DispatchedCoroutine;", "T", "Lkotlin/coroutines/CoroutineContext;", "context", "Lkotlin/coroutines/Continuation;", "uCont", "<init>", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/Continuation;)V", "", "state", "", "afterCompletion", "(Ljava/lang/Object;)V", "afterResume", "getResult", "()Ljava/lang/Object;", "", "tryResume", "()Z", "trySuspend", "kotlinx-coroutines-core", "Lkotlinx/coroutines/internal/ScopeCoroutine;"})
public final class ax<T> extends s<T> {
    static final AtomicIntegerFieldUpdater TTC = AtomicIntegerFieldUpdater.newUpdater(ax.class, "_decision");
    volatile int _decision = 0;

    static {
        AppMethodBeat.i(192435);
        AppMethodBeat.o(192435);
    }

    public ax(f fVar, d<? super T> dVar) {
        super(fVar, dVar);
    }

    @Override // kotlinx.coroutines.internal.s, kotlinx.coroutines.ca
    public final void fS(Object obj) {
        AppMethodBeat.i(192433);
        fM(obj);
        AppMethodBeat.o(192433);
    }

    @Override // kotlinx.coroutines.internal.s, kotlinx.coroutines.a
    public final void fM(Object obj) {
        AppMethodBeat.i(192434);
        if (hMv()) {
            AppMethodBeat.o(192434);
            return;
        }
        aw.a(b.e(this.TWf), w.a(obj, this.TWf));
        AppMethodBeat.o(192434);
    }

    private final boolean hMv() {
        AppMethodBeat.i(192432);
        do {
            switch (this._decision) {
                case 0:
                    break;
                case 1:
                    AppMethodBeat.o(192432);
                    return false;
                default:
                    IllegalStateException illegalStateException = new IllegalStateException("Already resumed".toString());
                    AppMethodBeat.o(192432);
                    throw illegalStateException;
            }
        } while (!TTC.compareAndSet(this, 0, 2));
        AppMethodBeat.o(192432);
        return true;
    }
}
