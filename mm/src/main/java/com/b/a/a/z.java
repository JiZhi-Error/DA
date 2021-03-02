package com.b.a.a;

import android.os.Handler;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* access modifiers changed from: package-private */
public final class z {
    private static z cnA;
    private static final SparseArray<z> cnB = new SparseArray<>();
    private final ExecutorService cnC;
    private final Handler handler;

    static {
        AppMethodBeat.i(88019);
        AppMethodBeat.o(88019);
    }

    private z(Handler handler2) {
        AppMethodBeat.i(88020);
        if (handler2 != null) {
            this.cnC = null;
        } else {
            this.cnC = Executors.newSingleThreadExecutor();
        }
        this.handler = handler2;
        AppMethodBeat.o(88020);
    }

    static z b(Handler handler2) {
        AppMethodBeat.i(88021);
        if (handler2 != null) {
            int hashCode = handler2.getLooper().hashCode();
            z zVar = cnB.get(hashCode);
            if (zVar == null) {
                zVar = new z(handler2);
                cnB.put(hashCode, zVar);
            }
            AppMethodBeat.o(88021);
            return zVar;
        }
        if (cnA == null) {
            cnA = new z(null);
        }
        z zVar2 = cnA;
        AppMethodBeat.o(88021);
        return zVar2;
    }

    /* access modifiers changed from: package-private */
    public final void execute(Runnable runnable) {
        AppMethodBeat.i(88022);
        if (this.handler != null) {
            this.handler.post(runnable);
            AppMethodBeat.o(88022);
            return;
        }
        this.cnC.execute(runnable);
        AppMethodBeat.o(88022);
    }
}
