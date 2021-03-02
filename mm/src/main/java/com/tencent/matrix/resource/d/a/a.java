package com.tencent.matrix.resource.d.a;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public final class a<T> {
    public final AtomicReference<T> cZB = new AtomicReference<>();
    public final CountDownLatch cZC = new CountDownLatch(1);

    public final boolean a(TimeUnit timeUnit) {
        try {
            return this.cZC.await(5, timeUnit);
        } catch (InterruptedException e2) {
            throw new RuntimeException("Did not expect thread to be interrupted", e2);
        }
    }
}
