package com.facebook.internal;

import com.facebook.FacebookSdk;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.FutureTask;

public class LockOnGetVariable<T> {
    private CountDownLatch initLatch;
    private T value;

    public LockOnGetVariable(T t) {
        this.value = t;
    }

    public LockOnGetVariable(final Callable<T> callable) {
        AppMethodBeat.i(17838);
        this.initLatch = new CountDownLatch(1);
        FacebookSdk.getExecutor().execute(new FutureTask(new Callable<Void>() {
            /* class com.facebook.internal.LockOnGetVariable.AnonymousClass1 */

            @Override // java.util.concurrent.Callable
            public Void call() {
                AppMethodBeat.i(17836);
                try {
                    LockOnGetVariable.this.value = callable.call();
                    LockOnGetVariable.this.initLatch.countDown();
                    AppMethodBeat.o(17836);
                    return null;
                } catch (Throwable th) {
                    LockOnGetVariable.this.initLatch.countDown();
                    AppMethodBeat.o(17836);
                    throw th;
                }
            }
        }));
        AppMethodBeat.o(17838);
    }

    public T getValue() {
        AppMethodBeat.i(17839);
        waitOnInit();
        T t = this.value;
        AppMethodBeat.o(17839);
        return t;
    }

    private void waitOnInit() {
        AppMethodBeat.i(17840);
        if (this.initLatch == null) {
            AppMethodBeat.o(17840);
            return;
        }
        try {
            this.initLatch.await();
            AppMethodBeat.o(17840);
        } catch (InterruptedException e2) {
            AppMethodBeat.o(17840);
        }
    }
}
