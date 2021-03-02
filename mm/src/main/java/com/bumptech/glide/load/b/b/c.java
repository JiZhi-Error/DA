package com.bumptech.glide.load.b.b;

import com.bumptech.glide.g.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

final class c {
    final Map<String, a> aIP = new HashMap();
    final b aIQ = new b();

    c() {
        AppMethodBeat.i(77147);
        AppMethodBeat.o(77147);
    }

    /* access modifiers changed from: package-private */
    public final void release(String str) {
        a aVar;
        AppMethodBeat.i(77148);
        synchronized (this) {
            try {
                aVar = (a) j.checkNotNull(this.aIP.get(str), "Argument must not be null");
                if (aVar.aIS <= 0) {
                    IllegalStateException illegalStateException = new IllegalStateException("Cannot release a lock that is not held, safeKey: " + str + ", interestedThreads: " + aVar.aIS);
                    AppMethodBeat.o(77148);
                    throw illegalStateException;
                }
                aVar.aIS--;
                if (aVar.aIS == 0) {
                    a remove = this.aIP.remove(str);
                    if (!remove.equals(aVar)) {
                        IllegalStateException illegalStateException2 = new IllegalStateException("Removed the wrong lock, expected to remove: " + aVar + ", but actually removed: " + remove + ", safeKey: " + str);
                        AppMethodBeat.o(77148);
                        throw illegalStateException2;
                    }
                    b bVar = this.aIQ;
                    synchronized (bVar.aIT) {
                        try {
                            if (bVar.aIT.size() < 10) {
                                bVar.aIT.offer(remove);
                            }
                        } catch (Throwable th) {
                            AppMethodBeat.o(77148);
                            throw th;
                        }
                    }
                }
            } catch (Throwable th2) {
                AppMethodBeat.o(77148);
                throw th2;
            }
        }
        aVar.aIR.unlock();
        AppMethodBeat.o(77148);
    }

    static class a {
        final Lock aIR = new ReentrantLock();
        int aIS;

        a() {
            AppMethodBeat.i(77144);
            AppMethodBeat.o(77144);
        }
    }

    static class b {
        final Queue<a> aIT = new ArrayDeque();

        b() {
            AppMethodBeat.i(77145);
            AppMethodBeat.o(77145);
        }

        /* access modifiers changed from: package-private */
        public final a pg() {
            a poll;
            AppMethodBeat.i(77146);
            synchronized (this.aIT) {
                try {
                    poll = this.aIT.poll();
                } finally {
                    AppMethodBeat.o(77146);
                }
            }
            if (poll == null) {
                poll = new a();
            }
            return poll;
        }
    }
}
