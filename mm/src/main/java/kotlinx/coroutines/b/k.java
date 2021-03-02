package kotlinx.coroutines.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\u00020\u0001B!\u0012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\rH\u0016R\u0014\u0010\u0002\u001a\u00060\u0003j\u0002`\u00048\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, hxF = {"Lkotlinx/coroutines/scheduling/TaskImpl;", "Lkotlinx/coroutines/scheduling/Task;", "block", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "submissionTime", "", "taskContext", "Lkotlinx/coroutines/scheduling/TaskContext;", "(Ljava/lang/Runnable;JLkotlinx/coroutines/scheduling/TaskContext;)V", "run", "", "toString", "", "kotlinx-coroutines-core"})
public final class k extends i {
    public final Runnable TUC;

    public k(Runnable runnable, long j2, j jVar) {
        super(j2, jVar);
        AppMethodBeat.i(117992);
        this.TUC = runnable;
        AppMethodBeat.o(117992);
    }

    public final void run() {
        AppMethodBeat.i(117990);
        try {
            this.TUC.run();
        } finally {
            this.TXa.hOe();
            AppMethodBeat.o(117990);
        }
    }

    public final String toString() {
        AppMethodBeat.i(117991);
        String str = "Task[" + this.TUC.getClass().getSimpleName() + '@' + Integer.toHexString(System.identityHashCode(this.TUC)) + ", " + this.TWZ + ", " + this.TXa + ']';
        AppMethodBeat.o(117991);
        return str;
    }
}
