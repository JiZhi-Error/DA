package kotlinx.coroutines.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlinx.coroutines.ce;

public final class o {
    private static final boolean TWc = true;

    public static final ce a(MainDispatcherFactory mainDispatcherFactory, List<? extends MainDispatcherFactory> list) {
        p e2;
        AppMethodBeat.i(192441);
        try {
            e2 = mainDispatcherFactory.createDispatcher(list);
        } catch (Throwable th) {
            e2 = e(th, mainDispatcherFactory.hintOnError());
        }
        AppMethodBeat.o(192441);
        return e2;
    }

    static /* synthetic */ p b(Throwable th, int i2) {
        AppMethodBeat.i(192443);
        if ((i2 & 1) != 0) {
            th = null;
        }
        p e2 = e(th, null);
        AppMethodBeat.o(192443);
        return e2;
    }

    private static final p e(Throwable th, String str) {
        AppMethodBeat.i(192442);
        if (TWc) {
            p pVar = new p(th, str);
            AppMethodBeat.o(192442);
            return pVar;
        } else if (th != null) {
            AppMethodBeat.o(192442);
            throw th;
        } else {
            hNP();
            AppMethodBeat.o(192442);
            throw null;
        }
    }

    public static final Void hNP() {
        AppMethodBeat.i(192444);
        IllegalStateException illegalStateException = new IllegalStateException("Module with the Main dispatcher is missing. Add dependency providing the Main dispatcher, e.g. 'kotlinx-coroutines-android' and ensure it has the same version as 'kotlinx-coroutines-core'");
        AppMethodBeat.o(192444);
        throw illegalStateException;
    }
}
