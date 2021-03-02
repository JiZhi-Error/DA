package com.tencent.mm.appbrand.v8;

import com.eclipsesource.v8.JavaCallback;
import com.eclipsesource.v8.V8Array;
import com.eclipsesource.v8.V8Function;
import com.eclipsesource.v8.V8Object;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class s extends o {
    private WeakReference<m> dqx = null;

    /* access modifiers changed from: package-private */
    public static class a {
        volatile int aea;
        volatile V8Function dqA;
        volatile m dqz;

        public a(int i2, m mVar, V8Function v8Function) {
            this.aea = i2;
            this.dqz = mVar;
            this.dqA = v8Function;
        }

        public final String toString() {
            AppMethodBeat.i(216894);
            String str = "LockItem{itemId=" + this.aea + '}';
            AppMethodBeat.o(216894);
            return str;
        }
    }

    static class b {
        static final /* synthetic */ boolean $assertionsDisabled = (!s.class.desiredAssertionStatus());
        private static b dqC = null;
        private final ConcurrentHashMap<Integer, ConcurrentLinkedQueue<a>> dqB = new ConcurrentHashMap<>(100);
        private AtomicInteger dqD = new AtomicInteger(0);

        static {
            AppMethodBeat.i(216904);
            AppMethodBeat.o(216904);
        }

        static /* synthetic */ b XM() {
            AppMethodBeat.i(216900);
            b XL = XL();
            AppMethodBeat.o(216900);
            return XL;
        }

        static /* synthetic */ int a(b bVar, int i2, V8Function v8Function, m mVar) {
            AppMethodBeat.i(216901);
            int a2 = bVar.a(i2, v8Function, mVar);
            AppMethodBeat.o(216901);
            return a2;
        }

        private static b XL() {
            AppMethodBeat.i(216896);
            if (dqC == null) {
                synchronized (b.class) {
                    try {
                        if (dqC == null) {
                            dqC = new b();
                        }
                    } catch (Throwable th) {
                        AppMethodBeat.o(216896);
                        throw th;
                    }
                }
            }
            b bVar = dqC;
            AppMethodBeat.o(216896);
            return bVar;
        }

        private b() {
            AppMethodBeat.i(216897);
            AppMethodBeat.o(216897);
        }

        private int a(int i2, V8Function v8Function, m mVar) {
            ConcurrentLinkedQueue<a> concurrentLinkedQueue;
            int andIncrement;
            boolean z = true;
            AppMethodBeat.i(216898);
            synchronized (this.dqB) {
                try {
                    if (this.dqB.containsKey(Integer.valueOf(i2))) {
                        concurrentLinkedQueue = this.dqB.get(Integer.valueOf(i2));
                        if ($assertionsDisabled || concurrentLinkedQueue != null) {
                            z = concurrentLinkedQueue.isEmpty();
                        } else {
                            AssertionError assertionError = new AssertionError();
                            AppMethodBeat.o(216898);
                            throw assertionError;
                        }
                    } else {
                        concurrentLinkedQueue = new ConcurrentLinkedQueue<>();
                        this.dqB.put(Integer.valueOf(i2), concurrentLinkedQueue);
                    }
                    andIncrement = this.dqD.getAndIncrement();
                    a aVar = new a(andIncrement, mVar, v8Function);
                    concurrentLinkedQueue.offer(aVar);
                    if (z) {
                        a(aVar.dqz, aVar.dqA);
                    }
                    Log.v("MicroMsg.V8DirectApiSharedBufferLock", "hy: request lock %d", Integer.valueOf(andIncrement));
                } finally {
                    AppMethodBeat.o(216898);
                }
            }
            return andIncrement;
        }

        private void a(final m mVar, final V8Function v8Function) {
            AppMethodBeat.i(216899);
            mVar.dpQ.r(new Runnable() {
                /* class com.tencent.mm.appbrand.v8.s.b.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(216895);
                    if (!v8Function.isReleased()) {
                        Log.d("MicroMsg.V8DirectApiSharedBufferLock", "hy: trigger task call");
                        v8Function.call(mVar.XJ().getGlobalObject(), null);
                        v8Function.release();
                        AppMethodBeat.o(216895);
                        return;
                    }
                    Log.w("MicroMsg.V8DirectApiSharedBufferLock", "hy: called a released task");
                    AppMethodBeat.o(216895);
                }
            });
            AppMethodBeat.o(216899);
        }

        static /* synthetic */ void a(b bVar, int i2, int i3) {
            AppMethodBeat.i(216902);
            synchronized (bVar.dqB) {
                try {
                    Log.v("MicroMsg.V8DirectApiSharedBufferLock", "hy: request unlock %d", Integer.valueOf(i3));
                    ConcurrentLinkedQueue<a> concurrentLinkedQueue = bVar.dqB.get(Integer.valueOf(i2));
                    Log.d("MicroMsg.V8DirectApiSharedBufferLock", "hy: current queue: %s", concurrentLinkedQueue);
                    if (concurrentLinkedQueue != null) {
                        a poll = concurrentLinkedQueue.poll();
                        if (poll != null) {
                            Log.d("MicroMsg.V8DirectApiSharedBufferLock", "hy: toBeRemoved: %d", Integer.valueOf(poll.aea));
                            a peek = concurrentLinkedQueue.peek();
                            if (peek != null) {
                                Log.d("MicroMsg.V8DirectApiSharedBufferLock", "hy: next called: %d", Integer.valueOf(peek.aea));
                                bVar.a(peek.dqz, peek.dqA);
                            }
                        } else {
                            Log.w("MicroMsg.V8DirectApiSharedBufferLock", "hy: bufferId: %d itemId: %d not found", Integer.valueOf(i2), Integer.valueOf(i3));
                        }
                    } else {
                        Log.v("MicroMsg.V8DirectApiSharedBufferLock", "hy: can not locate buffer locks %d", Integer.valueOf(i2));
                    }
                } finally {
                    AppMethodBeat.o(216902);
                }
            }
        }

        static /* synthetic */ void a(b bVar, m mVar) {
            AppMethodBeat.i(216903);
            synchronized (bVar.dqB) {
                try {
                    Log.i("MicroMsg.V8DirectApiSharedBufferLock", "hy: trigger release engine %d", Integer.valueOf(mVar.hashCode()));
                    for (Integer num : bVar.dqB.keySet()) {
                        ConcurrentLinkedQueue<a> concurrentLinkedQueue = bVar.dqB.get(num);
                        if (concurrentLinkedQueue != null) {
                            Iterator<a> it = concurrentLinkedQueue.iterator();
                            while (it.hasNext()) {
                                a next = it.next();
                                if (next.dqz == mVar) {
                                    next.dqA.release();
                                    concurrentLinkedQueue.remove(next);
                                }
                            }
                        }
                    }
                } finally {
                    AppMethodBeat.o(216903);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.appbrand.v8.o
    public final void a(final m mVar, V8Object v8Object) {
        AppMethodBeat.i(216905);
        Object[] objArr = new Object[1];
        objArr[0] = Integer.valueOf(mVar != null ? mVar.hashCode() : 0);
        Log.i("MicroMsg.V8DirectApiSharedBufferLock", "hy: trigger setup worker %d", objArr);
        this.dqx = new WeakReference<>(mVar);
        v8Object.registerJavaMethod(new JavaCallback() {
            /* class com.tencent.mm.appbrand.v8.s.AnonymousClass1 */

            @Override // com.eclipsesource.v8.JavaCallback
            public final Object invoke(V8Object v8Object, V8Array v8Array) {
                AppMethodBeat.i(216892);
                if (v8Array.length() >= 2 && v8Array.getType(0) == 1 && v8Array.getType(1) == 7) {
                    Integer valueOf = Integer.valueOf(b.a(b.XM(), v8Array.getInteger(0), (V8Function) v8Array.getObject(1), mVar));
                    AppMethodBeat.o(216892);
                    return valueOf;
                }
                Log.w("MicroMsg.V8DirectApiSharedBufferLock", "hy: v8 params error");
                AppMethodBeat.o(216892);
                return -1;
            }
        }, "lockSharedNativeBuffer");
        v8Object.registerJavaMethod(new JavaCallback() {
            /* class com.tencent.mm.appbrand.v8.s.AnonymousClass2 */

            @Override // com.eclipsesource.v8.JavaCallback
            public final Object invoke(V8Object v8Object, V8Array v8Array) {
                AppMethodBeat.i(216893);
                if (v8Array.length() >= 2 && v8Array.getType(0) == 1 && v8Array.getType(1) == 1) {
                    b.a(b.XM(), v8Array.getInteger(0), v8Array.getInteger(1));
                    AppMethodBeat.o(216893);
                } else {
                    Log.w("MicroMsg.V8DirectApiSharedBufferLock", "hy: v8 params error");
                    AppMethodBeat.o(216893);
                }
                return null;
            }
        }, "unlockSharedNativeBuffer");
        AppMethodBeat.o(216905);
    }

    /* access modifiers changed from: package-private */
    @Override // com.tencent.mm.appbrand.v8.o
    public final void cleanup() {
        AppMethodBeat.i(216906);
        if (this.dqx != null) {
            b.a(b.XM(), this.dqx.get());
        }
        AppMethodBeat.o(216906);
    }
}
