package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.d.d;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005¢\u0006\u0002\u0010\u0006J\u0013\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0002J\b\u0010\u000b\u001a\u00020\fH\u0016R\u0014\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u00058\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, hxF = {"Lkotlinx/coroutines/ChildContinuation;", "Lkotlinx/coroutines/JobCancellingNode;", "Lkotlinx/coroutines/Job;", "parent", "child", "Lkotlinx/coroutines/CancellableContinuationImpl;", "(Lkotlinx/coroutines/Job;Lkotlinx/coroutines/CancellableContinuationImpl;)V", "invoke", "", "cause", "", "toString", "", "kotlinx-coroutines-core"})
public final class p extends bw<bu> {
    public final l<?> TTG;

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.g.a.b
    public final /* synthetic */ x invoke(Throwable th) {
        AppMethodBeat.i(118227);
        y(th);
        x xVar = x.SXb;
        AppMethodBeat.o(118227);
        return xVar;
    }

    public p(bu buVar, l<?> lVar) {
        super(buVar);
        this.TTG = lVar;
    }

    @Override // kotlinx.coroutines.z
    public final void y(Throwable th) {
        boolean z;
        AppMethodBeat.i(118226);
        l<?> lVar = this.TTG;
        Throwable a2 = this.TTG.a(this.TUQ);
        if (lVar.TUq != 0) {
            z = false;
        } else {
            d<T> dVar = lVar.SXL;
            if (!(dVar instanceof av)) {
                dVar = null;
            }
            av avVar = (av) dVar;
            if (avVar == null) {
                z = false;
            } else {
                while (true) {
                    Object obj = avVar._reusableCancellableContinuation;
                    if (kotlin.g.b.p.j(obj, aw.TUp)) {
                        if (av.TUl.compareAndSet(avVar, aw.TUp, a2)) {
                            z = true;
                            break;
                        }
                    } else if (obj instanceof Throwable) {
                        z = true;
                        break;
                    } else if (av.TUl.compareAndSet(avVar, obj, null)) {
                        z = false;
                        break;
                    }
                }
            }
        }
        if (!z) {
            lVar.A(a2);
            lVar.hMw();
        }
        AppMethodBeat.o(118226);
    }

    @Override // kotlinx.coroutines.internal.k
    public final String toString() {
        AppMethodBeat.i(118228);
        String str = "ChildContinuation[" + this.TTG + ']';
        AppMethodBeat.o(118228);
        return str;
    }
}
