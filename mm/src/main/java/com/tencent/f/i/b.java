package com.tencent.f.i;

import java.util.concurrent.Future;

public abstract class b implements e, g, j, Runnable {
    private Future dBz;

    @Override // com.tencent.f.i.e
    public final void a(Future future) {
        this.dBz = future;
    }

    public boolean cancel() {
        if (this.dBz == null || this.dBz.isDone()) {
            return false;
        }
        return this.dBz.cancel(false);
    }

    public final void hmy() {
        if (this.dBz != null && !this.dBz.isCancelled()) {
            this.dBz.get();
        }
    }

    @Override // com.tencent.f.i.j
    public boolean axI() {
        return true;
    }

    public final boolean isDone() {
        if (this.dBz == null) {
            return false;
        }
        return this.dBz.isDone();
    }
}
