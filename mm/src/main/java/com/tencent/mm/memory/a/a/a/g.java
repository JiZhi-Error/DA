package com.tencent.mm.memory.a.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import java.lang.ref.WeakReference;
import java.util.Map;

public final class g<T, V> extends e<T, V, a<V>, V> {
    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.memory.a.a.a.e
    public final /* synthetic */ Object bY(Object obj) {
        AppMethodBeat.i(156520);
        a aVar = (a) obj;
        if (aVar != null) {
            if (aVar.obj != null) {
                T t = aVar.obj;
                AppMethodBeat.o(156520);
                return t;
            } else if (!(aVar.cMO == null || aVar.cMO.get() == null)) {
                T t2 = aVar.cMO.get();
                AppMethodBeat.o(156520);
                return t2;
            }
        }
        AppMethodBeat.o(156520);
        return null;
    }

    public g(int i2) {
        super(i2);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.memory.a.a.a.e
    public final V A(T t, V v) {
        return v;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.memory.a.a.a.e
    public final T aSg() {
        return null;
    }

    @Override // com.tencent.mm.b.f
    public final Map<T, V> snapshot() {
        return null;
    }

    static class a<T> {
        WeakReference<T> cMO = null;
        T obj = null;

        public a(T t) {
            AppMethodBeat.i(156519);
            this.obj = t;
            this.cMO = new WeakReference<>(t);
            MMHandlerThread.postToMainThreadDelayed(new Runnable() {
                /* class com.tencent.mm.memory.a.a.a.g.a.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(156518);
                    a.this.obj = null;
                    AppMethodBeat.o(156518);
                }
            }, 2000);
            AppMethodBeat.o(156519);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.memory.a.a.a.e
    public final /* synthetic */ Object ca(Object obj) {
        AppMethodBeat.i(156521);
        a aVar = new a(obj);
        AppMethodBeat.o(156521);
        return aVar;
    }
}
