package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.a.b;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\u00020\u0001B.\u0012'\u0010\u0002\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0003j\u0002`\t¢\u0006\u0002\u0010\nJ\u0013\u0010\u000b\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004H\u0002J\b\u0010\f\u001a\u00020\rH\u0016R/\u0010\u0002\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0003j\u0002`\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, hxF = {"Lkotlinx/coroutines/InvokeOnCancel;", "Lkotlinx/coroutines/CancelHandler;", "handler", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "cause", "", "Lkotlinx/coroutines/CompletionHandler;", "(Lkotlin/jvm/functions/Function1;)V", "invoke", "toString", "", "kotlinx-coroutines-core"})
final class br extends i {
    private final b<Throwable, x> lJK;

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlin.g.a.b<? super java.lang.Throwable, kotlin.x> */
    /* JADX WARN: Multi-variable type inference failed */
    public br(b<? super Throwable, x> bVar) {
        AppMethodBeat.i(118164);
        this.lJK = bVar;
        AppMethodBeat.o(118164);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.g.a.b
    public final /* synthetic */ x invoke(Throwable th) {
        AppMethodBeat.i(118162);
        y(th);
        x xVar = x.SXb;
        AppMethodBeat.o(118162);
        return xVar;
    }

    @Override // kotlinx.coroutines.j
    public final void y(Throwable th) {
        AppMethodBeat.i(118161);
        this.lJK.invoke(th);
        AppMethodBeat.o(118161);
    }

    public final String toString() {
        AppMethodBeat.i(118163);
        String str = "InvokeOnCancel[" + this.lJK.getClass().getSimpleName() + '@' + Integer.toHexString(System.identityHashCode(this)) + ']';
        AppMethodBeat.o(118163);
        return str;
    }
}
