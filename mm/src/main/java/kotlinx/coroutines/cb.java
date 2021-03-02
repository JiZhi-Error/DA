package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlinx.coroutines.internal.u;

public final class cb {
    private static final u TVa = new u("COMPLETING_ALREADY");
    public static final u TVb = new u("COMPLETING_WAITING_CHILDREN");
    private static final u TVc = new u("COMPLETING_RETRY");
    private static final u TVd = new u("TOO_LATE_TO_CANCEL");
    private static final u TVe = new u("SEALED");
    private static final bf TVf = new bf(false);
    private static final bf TVg = new bf(true);

    public static final Object gc(Object obj) {
        AppMethodBeat.i(192429);
        if (obj instanceof bp) {
            bq bqVar = new bq((bp) obj);
            AppMethodBeat.o(192429);
            return bqVar;
        }
        AppMethodBeat.o(192429);
        return obj;
    }

    public static final Object gd(Object obj) {
        bp bpVar;
        bq bqVar = (bq) (!(obj instanceof bq) ? null : obj);
        return (bqVar == null || (bpVar = bqVar.TUM) == null) ? obj : bpVar;
    }

    static {
        AppMethodBeat.i(118155);
        AppMethodBeat.o(118155);
    }
}
