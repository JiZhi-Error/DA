package com.tencent.mm.plugin.appbrand.p;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

/* access modifiers changed from: package-private */
public final class b {
    private volatile int count = 2;
    private final LinkedList<Runnable> ngK = new LinkedList<>();

    b() {
        AppMethodBeat.i(147340);
        AppMethodBeat.o(147340);
    }

    public final void ad(Runnable runnable) {
        AppMethodBeat.i(147341);
        LinkedList<Runnable> linkedList = null;
        synchronized (this) {
            if (runnable != null) {
                try {
                    this.ngK.addLast(runnable);
                } catch (Throwable th) {
                    AppMethodBeat.o(147341);
                    throw th;
                }
            }
            int i2 = this.count - 1;
            this.count = i2;
            if (i2 <= 0 && this.ngK.size() > 0) {
                linkedList = new LinkedList();
                linkedList.addAll(this.ngK);
                this.ngK.clear();
            }
        }
        if (linkedList != null) {
            for (Runnable runnable2 : linkedList) {
                runnable2.run();
            }
        }
        AppMethodBeat.o(147341);
    }
}
