package com.tencent.f.j;

import com.tencent.f.i.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.Callable;

public final class e<E> extends k<E> {
    a RVg;
    public final a serial;

    public interface a {
        void a(a aVar, e eVar);

        void b(e eVar);
    }

    public e(Runnable runnable, long j2, String str, boolean z) {
        super(runnable, j2, z);
        AppMethodBeat.i(183475);
        this.serial = a.bqv(str);
        AppMethodBeat.o(183475);
    }

    public e(Callable<E> callable, long j2, String str, boolean z) {
        super(callable, j2, z);
        AppMethodBeat.i(183476);
        this.serial = a.bqv(str);
        AppMethodBeat.o(183476);
    }

    @Override // com.tencent.f.i.k
    public final void run() {
        AppMethodBeat.i(183477);
        try {
            a.a(this.serial);
            super.run();
            a.a(null);
            if (this.RVg != null) {
                this.RVg.a(this.serial, this);
                AppMethodBeat.o(183477);
                return;
            }
            AppMethodBeat.o(183477);
        } catch (Throwable th) {
            a.a(null);
            if (this.RVg != null) {
                this.RVg.a(this.serial, this);
            }
            AppMethodBeat.o(183477);
            throw th;
        }
    }

    @Override // com.tencent.f.i.k
    public final boolean cancel(boolean z) {
        AppMethodBeat.i(183478);
        if (super.cancel(z)) {
            if (this.RVg != null) {
                this.RVg.b(this);
            }
            AppMethodBeat.o(183478);
            return true;
        }
        AppMethodBeat.o(183478);
        return false;
    }
}
