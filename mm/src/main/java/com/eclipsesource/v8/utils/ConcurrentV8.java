package com.eclipsesource.v8.utils;

import com.eclipsesource.v8.V8;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ConcurrentV8 {
    private V8 v8;

    public ConcurrentV8() {
        AppMethodBeat.i(61654);
        this.v8 = null;
        this.v8 = V8.createV8Runtime();
        this.v8.getLocker().release();
        AppMethodBeat.o(61654);
    }

    public final V8 getV8() {
        return this.v8;
    }

    /* JADX INFO: finally extract failed */
    public final synchronized void run(V8Runnable v8Runnable) {
        AppMethodBeat.i(61655);
        try {
            this.v8.getLocker().acquire();
            v8Runnable.run(this.v8);
            if (this.v8 == null || this.v8.getLocker() == null || !this.v8.getLocker().hasLock()) {
                AppMethodBeat.o(61655);
            } else {
                this.v8.getLocker().release();
                AppMethodBeat.o(61655);
            }
        } catch (Throwable th) {
            if (!(this.v8 == null || this.v8.getLocker() == null || !this.v8.getLocker().hasLock())) {
                this.v8.getLocker().release();
            }
            AppMethodBeat.o(61655);
            throw th;
        }
    }

    public final void release() {
        AppMethodBeat.i(61656);
        if (this.v8 != null && !this.v8.isReleased()) {
            run(new V8Runnable() {
                /* class com.eclipsesource.v8.utils.ConcurrentV8.AnonymousClass1 */

                @Override // com.eclipsesource.v8.utils.V8Runnable
                public void run(V8 v8) {
                    AppMethodBeat.i(61653);
                    if (v8 != null && !v8.isReleased()) {
                        v8.release();
                    }
                    AppMethodBeat.o(61653);
                }
            });
        }
        AppMethodBeat.o(61656);
    }
}
