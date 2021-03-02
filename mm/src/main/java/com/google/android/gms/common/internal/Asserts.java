package com.google.android.gms.common.internal;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class Asserts {
    private Asserts() {
        AppMethodBeat.i(4591);
        AssertionError assertionError = new AssertionError("Uninstantiable");
        AppMethodBeat.o(4591);
        throw assertionError;
    }

    public static void checkMainThread(String str) {
        AppMethodBeat.i(4589);
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
            String valueOf = String.valueOf(Thread.currentThread());
            String valueOf2 = String.valueOf(Looper.getMainLooper().getThread());
            new StringBuilder(String.valueOf(valueOf).length() + 57 + String.valueOf(valueOf2).length()).append("checkMainThread: current thread ").append(valueOf).append(" IS NOT the main thread ").append(valueOf2).append("!");
            IllegalStateException illegalStateException = new IllegalStateException(str);
            AppMethodBeat.o(4589);
            throw illegalStateException;
        }
        AppMethodBeat.o(4589);
    }

    public static void checkNotMainThread(String str) {
        AppMethodBeat.i(4590);
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            String valueOf = String.valueOf(Thread.currentThread());
            String valueOf2 = String.valueOf(Looper.getMainLooper().getThread());
            new StringBuilder(String.valueOf(valueOf).length() + 56 + String.valueOf(valueOf2).length()).append("checkNotMainThread: current thread ").append(valueOf).append(" IS the main thread ").append(valueOf2).append("!");
            IllegalStateException illegalStateException = new IllegalStateException(str);
            AppMethodBeat.o(4590);
            throw illegalStateException;
        }
        AppMethodBeat.o(4590);
    }

    public static void checkNotNull(Object obj) {
        AppMethodBeat.i(4583);
        if (obj == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("null reference");
            AppMethodBeat.o(4583);
            throw illegalArgumentException;
        }
        AppMethodBeat.o(4583);
    }

    public static void checkNotNull(Object obj, Object obj2) {
        AppMethodBeat.i(4584);
        if (obj == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(String.valueOf(obj2));
            AppMethodBeat.o(4584);
            throw illegalArgumentException;
        }
        AppMethodBeat.o(4584);
    }

    public static void checkNull(Object obj) {
        AppMethodBeat.i(4582);
        if (obj != null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("non-null reference");
            AppMethodBeat.o(4582);
            throw illegalArgumentException;
        }
        AppMethodBeat.o(4582);
    }

    public static void checkState(boolean z) {
        AppMethodBeat.i(4585);
        if (!z) {
            IllegalStateException illegalStateException = new IllegalStateException();
            AppMethodBeat.o(4585);
            throw illegalStateException;
        }
        AppMethodBeat.o(4585);
    }

    public static void checkState(boolean z, Object obj) {
        AppMethodBeat.i(4586);
        if (!z) {
            IllegalStateException illegalStateException = new IllegalStateException(String.valueOf(obj));
            AppMethodBeat.o(4586);
            throw illegalStateException;
        }
        AppMethodBeat.o(4586);
    }

    public static void checkState(boolean z, String str, Object... objArr) {
        AppMethodBeat.i(4587);
        if (!z) {
            IllegalStateException illegalStateException = new IllegalStateException(String.format(str, objArr));
            AppMethodBeat.o(4587);
            throw illegalStateException;
        }
        AppMethodBeat.o(4587);
    }

    public static void fail(Object obj) {
        AppMethodBeat.i(4588);
        IllegalStateException illegalStateException = new IllegalStateException(String.valueOf(obj));
        AppMethodBeat.o(4588);
        throw illegalStateException;
    }
}
