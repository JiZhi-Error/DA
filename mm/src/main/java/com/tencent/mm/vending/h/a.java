package com.tencent.mm.vending.h;

import android.os.Looper;

public interface a {
    void c(Runnable runnable, long j2);

    void fS();

    Looper getLooper();

    void post(Runnable runnable);
}
