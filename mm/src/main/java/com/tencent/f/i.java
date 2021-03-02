package com.tencent.f;

import com.tencent.f.i.d;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;

public interface i {
    b a(String str, int i2, int i3, BlockingQueue<Runnable> blockingQueue);

    d<?> a(Runnable runnable, long j2, long j3);

    d<?> a(Runnable runnable, long j2, String str);

    <T> d<T> a(Callable<T> callable, String str);

    d<?> aV(Runnable runnable);

    d<?> aW(Runnable runnable);

    d<?> aX(Runnable runnable);

    d<?> aY(Runnable runnable);

    d<?> aZ(Runnable runnable);

    d<?> b(Runnable runnable, long j2, String str);

    d<?> b(Runnable runnable, String str);

    d<?> ba(Runnable runnable);

    boolean bqo(String str);

    b bqp(String str);

    d<?> c(Runnable runnable, String str);

    d<?> d(Runnable runnable, String str);

    <T> d<T> d(Callable<T> callable);

    d<?> e(Runnable runnable, String str);

    boolean hmg();

    a hmh();

    boolean isShutdown();

    d<?> n(Runnable runnable, long j2);

    d<?> o(Runnable runnable, long j2);

    d<?> p(Runnable runnable, long j2);
}
