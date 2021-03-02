package com.tencent.matrix.a.c;

import android.os.Handler;

public final class b {
    public Handler cUa;
    public boolean started;

    public final void q(Runnable runnable) {
        this.cUa.post(runnable);
    }
}
