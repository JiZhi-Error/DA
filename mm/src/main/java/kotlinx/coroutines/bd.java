package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;
import kotlin.x;

/* access modifiers changed from: package-private */
@l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0013\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0002J\b\u0010\t\u001a\u00020\nH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, hxF = {"Lkotlinx/coroutines/DisposeOnCancel;", "Lkotlinx/coroutines/CancelHandler;", "handle", "Lkotlinx/coroutines/DisposableHandle;", "(Lkotlinx/coroutines/DisposableHandle;)V", "invoke", "", "cause", "", "toString", "", "kotlinx-coroutines-core"})
public final class bd extends i {
    private final bc TTy;

    public bd(bc bcVar) {
        AppMethodBeat.i(118047);
        this.TTy = bcVar;
        AppMethodBeat.o(118047);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.g.a.b
    public final /* synthetic */ x invoke(Throwable th) {
        AppMethodBeat.i(118045);
        y(th);
        x xVar = x.SXb;
        AppMethodBeat.o(118045);
        return xVar;
    }

    @Override // kotlinx.coroutines.j
    public final void y(Throwable th) {
        AppMethodBeat.i(118044);
        this.TTy.dispose();
        AppMethodBeat.o(118044);
    }

    public final String toString() {
        AppMethodBeat.i(118046);
        String str = "DisposeOnCancel[" + this.TTy + ']';
        AppMethodBeat.o(118046);
        return str;
    }
}
