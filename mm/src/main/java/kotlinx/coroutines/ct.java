package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.d.d;
import kotlin.l;
import kotlinx.coroutines.internal.s;

/* access modifiers changed from: package-private */
@l(hxD = {1, 1, 16}, hxE = {"\u00002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u0001*\n\b\u0001\u0010\u0002 \u0000*\u0002H\u00012\b\u0012\u0004\u0012\u0002H\u00020\u00032\u00060\u0004j\u0002`\u0005B\u001b\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\t¢\u0006\u0002\u0010\nJ\r\u0010\u000b\u001a\u00020\fH\u0010¢\u0006\u0002\b\rJ\b\u0010\u000e\u001a\u00020\u000fH\u0016R\u0010\u0010\u0006\u001a\u00020\u00078\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, hxF = {"Lkotlinx/coroutines/TimeoutCoroutine;", "U", "T", "Lkotlinx/coroutines/internal/ScopeCoroutine;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "time", "", "uCont", "Lkotlin/coroutines/Continuation;", "(JLkotlin/coroutines/Continuation;)V", "nameString", "", "nameString$kotlinx_coroutines_core", "run", "", "kotlinx-coroutines-core"})
public final class ct<U, T extends U> extends s<T> implements Runnable {
    public final long time;

    public ct(long j2, d<? super U> dVar) {
        super(dVar.getContext(), dVar);
        AppMethodBeat.i(192509);
        this.time = j2;
        AppMethodBeat.o(192509);
    }

    public final void run() {
        AppMethodBeat.i(192507);
        D(new cs("Timed out waiting for " + this.time + " ms", this));
        AppMethodBeat.o(192507);
    }

    @Override // kotlinx.coroutines.a, kotlinx.coroutines.ca
    public final String hMo() {
        AppMethodBeat.i(192508);
        String str = super.hMo() + "(timeMillis=" + this.time + ')';
        AppMethodBeat.o(192508);
        return str;
    }
}