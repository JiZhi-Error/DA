package com.tencent.matrix.trace.f;

import com.tencent.matrix.trace.e.c;

public abstract class f extends c implements d {
    public volatile boolean dbi = false;

    /* access modifiers changed from: protected */
    public void onAlive() {
        com.tencent.matrix.g.c.i("Matrix.Tracer", "[onAlive] %s", getClass().getName());
    }

    /* access modifiers changed from: protected */
    public void onDead() {
        com.tencent.matrix.g.c.i("Matrix.Tracer", "[onDead] %s", getClass().getName());
    }

    public final synchronized void TG() {
        if (!this.dbi) {
            this.dbi = true;
            onAlive();
        }
    }

    public final synchronized void TH() {
        if (this.dbi) {
            this.dbi = false;
            onDead();
        }
    }

    @Override // com.tencent.matrix.b.c
    public void onForeground(boolean z) {
    }
}
