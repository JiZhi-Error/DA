package com.tencent.f.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public final class a extends e {
    private final Condition RTX = this.dgE.newCondition();
    private ReentrantLock dgE = new ReentrantLock();

    public a(int i2, int i3) {
        super(i2, i3);
        AppMethodBeat.i(183322);
        AppMethodBeat.o(183322);
    }

    @Override // com.tencent.f.g.b, com.tencent.f.g.a.a, com.tencent.f.g.a.b
    public final void a(g gVar) {
        AppMethodBeat.i(183323);
        super.a(gVar);
        try {
            this.dgE.lock();
            this.RTX.signal();
        } finally {
            this.dgE.unlock();
            AppMethodBeat.o(183323);
        }
    }

    @Override // com.tencent.f.g.a.a, com.tencent.f.g.a.b
    public final void b(g gVar) {
        AppMethodBeat.i(183324);
        super.b(gVar);
        while (!c(gVar)) {
            try {
                try {
                    this.dgE.lock();
                    this.RTX.await();
                    this.dgE.unlock();
                } catch (Throwable th) {
                    this.dgE.unlock();
                    AppMethodBeat.o(183324);
                    throw th;
                }
            } catch (InterruptedException e2) {
                AppMethodBeat.o(183324);
                return;
            }
        }
        AppMethodBeat.o(183324);
    }
}
