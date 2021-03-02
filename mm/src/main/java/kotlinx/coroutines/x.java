package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

/* access modifiers changed from: package-private */
@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016R\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00018\u0006X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00018\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, hxF = {"Lkotlinx/coroutines/CompletedIdempotentResult;", "", "idempotentResume", "result", "(Ljava/lang/Object;Ljava/lang/Object;)V", "toString", "", "kotlinx-coroutines-core"})
public final class x {
    public final Object result;

    public final String toString() {
        AppMethodBeat.i(118191);
        String str = "CompletedIdempotentResult[" + this.result + ']';
        AppMethodBeat.o(118191);
        return str;
    }
}
