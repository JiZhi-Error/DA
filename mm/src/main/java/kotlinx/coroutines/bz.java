package kotlinx.coroutines;

import kotlin.l;
import kotlin.t;
import kotlinx.coroutines.bu;

@l(hxD = {1, 1, 16}, hxE = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b \u0018\u0000*\n\b\u0000\u0010\u0001 \u0001*\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005B\r\u0012\u0006\u0010\u0006\u001a\u00028\u0000¢\u0006\u0002\u0010\u0007J\b\u0010\u0010\u001a\u00020\u0011H\u0016R\u0014\u0010\b\u001a\u00020\t8VX\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\nR\u0012\u0010\u0006\u001a\u00028\u00008\u0006X\u0004¢\u0006\u0004\n\u0002\u0010\u000bR\u0016\u0010\f\u001a\u0004\u0018\u00010\r8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, hxF = {"Lkotlinx/coroutines/JobNode;", "J", "Lkotlinx/coroutines/Job;", "Lkotlinx/coroutines/CompletionHandlerBase;", "Lkotlinx/coroutines/DisposableHandle;", "Lkotlinx/coroutines/Incomplete;", "job", "(Lkotlinx/coroutines/Job;)V", "isActive", "", "()Z", "Lkotlinx/coroutines/Job;", "list", "Lkotlinx/coroutines/NodeList;", "getList", "()Lkotlinx/coroutines/NodeList;", "dispose", "", "kotlinx-coroutines-core"})
public abstract class bz<J extends bu> extends z implements bc, bp {
    public final J TUQ;

    public bz(J j2) {
        this.TUQ = j2;
    }

    @Override // kotlinx.coroutines.bp
    public final boolean isActive() {
        return true;
    }

    @Override // kotlinx.coroutines.bp
    public final cf hMX() {
        return null;
    }

    @Override // kotlinx.coroutines.bc
    public final void dispose() {
        Object hNm;
        J j2 = this.TUQ;
        if (j2 == null) {
            throw new t("null cannot be cast to non-null type kotlinx.coroutines.JobSupport");
        }
        ca caVar = (ca) j2;
        do {
            hNm = caVar.hNm();
            if (hNm instanceof bz) {
                if (hNm != this) {
                    return;
                }
            } else if ((hNm instanceof bp) && ((bp) hNm).hMX() != null) {
                remove();
                return;
            } else {
                return;
            }
        } while (!ca.TTD.compareAndSet(caVar, hNm, cb.TVg));
    }
}
