package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0013\u0010\f\u001a\u00020\r2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0016R\u0010\u0010\u0005\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, hxF = {"Lkotlinx/coroutines/ChildHandleNode;", "Lkotlinx/coroutines/JobCancellingNode;", "Lkotlinx/coroutines/JobSupport;", "Lkotlinx/coroutines/ChildHandle;", "parent", "childJob", "Lkotlinx/coroutines/ChildJob;", "(Lkotlinx/coroutines/JobSupport;Lkotlinx/coroutines/ChildJob;)V", "childCancelled", "", "cause", "", "invoke", "", "toString", "", "kotlinx-coroutines-core"})
public final class r extends bw<ca> implements q {
    public final s TTH;

    public r(ca caVar, s sVar) {
        super(caVar);
        AppMethodBeat.i(118196);
        this.TTH = sVar;
        AppMethodBeat.o(118196);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.g.a.b
    public final /* synthetic */ x invoke(Throwable th) {
        AppMethodBeat.i(118193);
        y(th);
        x xVar = x.SXb;
        AppMethodBeat.o(118193);
        return xVar;
    }

    @Override // kotlinx.coroutines.z
    public final void y(Throwable th) {
        AppMethodBeat.i(118192);
        this.TTH.a((ci) this.TUQ);
        AppMethodBeat.o(118192);
    }

    @Override // kotlinx.coroutines.q
    public final boolean B(Throwable th) {
        AppMethodBeat.i(118194);
        boolean B = ((ca) this.TUQ).B(th);
        AppMethodBeat.o(118194);
        return B;
    }

    @Override // kotlinx.coroutines.internal.k
    public final String toString() {
        AppMethodBeat.i(118195);
        String str = "ChildHandle[" + this.TTH + ']';
        AppMethodBeat.o(118195);
        return str;
    }
}
