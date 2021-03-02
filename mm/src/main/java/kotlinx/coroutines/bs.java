package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.g.a.b;
import kotlin.l;
import kotlin.x;

/* access modifiers changed from: package-private */
@l(hxD = {1, 1, 16}, hxE = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00010\u0014B8\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012'\u0010\n\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0003j\u0002`\t¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\r\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011R7\u0010\n\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0003j\u0002`\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u0012¨\u0006\u0013"}, hxF = {"Lkotlinx/coroutines/InvokeOnCancelling;", "Lkotlinx/coroutines/Job;", "job", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "cause", "", "Lkotlinx/coroutines/CompletionHandler;", "handler", "<init>", "(Lkotlinx/coroutines/Job;Lkotlin/jvm/functions/Function1;)V", "invoke", "(Ljava/lang/Throwable;)V", "", "toString", "()Ljava/lang/String;", "Lkotlin/jvm/functions/Function1;", "kotlinx-coroutines-core", "Lkotlinx/coroutines/JobCancellingNode;"})
public final class bs extends bw<bu> {
    private static final AtomicIntegerFieldUpdater TUN = AtomicIntegerFieldUpdater.newUpdater(bs.class, "_invoked");
    private volatile int _invoked = 0;
    private final b<Throwable, x> lJK;

    static {
        AppMethodBeat.i(118220);
        AppMethodBeat.o(118220);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: kotlin.g.a.b<? super java.lang.Throwable, kotlin.x> */
    /* JADX WARN: Multi-variable type inference failed */
    public bs(bu buVar, b<? super Throwable, x> bVar) {
        super(buVar);
        AppMethodBeat.i(118219);
        this.lJK = bVar;
        AppMethodBeat.o(118219);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.g.a.b
    public final /* synthetic */ x invoke(Throwable th) {
        AppMethodBeat.i(118217);
        y(th);
        x xVar = x.SXb;
        AppMethodBeat.o(118217);
        return xVar;
    }

    @Override // kotlinx.coroutines.z
    public final void y(Throwable th) {
        AppMethodBeat.i(118216);
        if (TUN.compareAndSet(this, 0, 1)) {
            this.lJK.invoke(th);
        }
        AppMethodBeat.o(118216);
    }

    @Override // kotlinx.coroutines.internal.k
    public final String toString() {
        AppMethodBeat.i(118218);
        String str = "InvokeOnCancelling[" + getClass().getSimpleName() + '@' + Integer.toHexString(System.identityHashCode(this)) + ']';
        AppMethodBeat.o(118218);
        return str;
    }
}
