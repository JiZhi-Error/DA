package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.a.b;
import kotlin.l;
import kotlin.x;

/* access modifiers changed from: package-private */
@l(hxD = {1, 1, 16}, hxE = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B6\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012'\u0010\u0004\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0005j\u0002`\u000b¢\u0006\u0002\u0010\fJ\u0013\u0010\r\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\u0006H\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0016R/\u0010\u0004\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0005j\u0002`\u000bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, hxF = {"Lkotlinx/coroutines/InvokeOnCompletion;", "Lkotlinx/coroutines/JobNode;", "Lkotlinx/coroutines/Job;", "job", "handler", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "cause", "", "Lkotlinx/coroutines/CompletionHandler;", "(Lkotlinx/coroutines/Job;Lkotlin/jvm/functions/Function1;)V", "invoke", "toString", "", "kotlinx-coroutines-core"})
public final class bt extends bz<bu> {
    private final b<Throwable, x> lJK;

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: kotlin.g.a.b<? super java.lang.Throwable, kotlin.x> */
    /* JADX WARN: Multi-variable type inference failed */
    public bt(bu buVar, b<? super Throwable, x> bVar) {
        super(buVar);
        AppMethodBeat.i(118058);
        this.lJK = bVar;
        AppMethodBeat.o(118058);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.g.a.b
    public final /* synthetic */ x invoke(Throwable th) {
        AppMethodBeat.i(118056);
        y(th);
        x xVar = x.SXb;
        AppMethodBeat.o(118056);
        return xVar;
    }

    @Override // kotlinx.coroutines.z
    public final void y(Throwable th) {
        AppMethodBeat.i(118055);
        this.lJK.invoke(th);
        AppMethodBeat.o(118055);
    }

    @Override // kotlinx.coroutines.internal.k
    public final String toString() {
        AppMethodBeat.i(118057);
        String str = "InvokeOnCompletion[" + getClass().getSimpleName() + '@' + Integer.toHexString(System.identityHashCode(this)) + ']';
        AppMethodBeat.o(118057);
        return str;
    }
}
