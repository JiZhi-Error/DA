package com.eclipsesource.v8.utils;

import com.eclipsesource.v8.V8;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class V8Thread extends Thread {
    private V8 runtime;
    private final V8Runnable target;

    public V8Thread(V8Runnable v8Runnable) {
        this.target = v8Runnable;
    }

    public void run() {
        AppMethodBeat.i(61783);
        this.runtime = V8.createV8Runtime();
        try {
            this.target.run(this.runtime);
            synchronized (this) {
                try {
                    if (this.runtime.getLocker().hasLock()) {
                        this.runtime.release();
                        this.runtime = null;
                    }
                } finally {
                    AppMethodBeat.o(61783);
                }
            }
        } catch (Throwable th) {
            AppMethodBeat.o(61783);
            throw th;
        }
    }
}
