package com.tencent.mm.appbrand.v8;

import android.os.Looper;
import android.os.SystemClock;
import android.util.SparseArray;
import com.eclipsesource.v8.JavaCallback;
import com.eclipsesource.v8.JavaVoidCallback;
import com.eclipsesource.v8.V8Array;
import com.eclipsesource.v8.V8Function;
import com.eclipsesource.v8.V8Object;
import com.eclipsesource.v8.utils.V8ObjectUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* access modifiers changed from: package-private */
public final class t extends o {
    int dqH = 0;
    final SparseArray<b> dqI = new SparseArray<>();
    volatile Looper dqJ;
    private final boolean dqK = false;

    t() {
        AppMethodBeat.i(144098);
        AppMethodBeat.o(144098);
    }

    static int gy(String str) {
        int i2 = Integer.MIN_VALUE;
        AppMethodBeat.i(144099);
        if (str != null) {
            try {
                if (str.length() > 0) {
                    i2 = Integer.decode(str).intValue();
                    AppMethodBeat.o(144099);
                    return i2;
                }
            } catch (NumberFormatException e2) {
                Log.printErrStackTrace("MicroMsg.J2V8.V8DirectApiTimer", e2, "", new Object[0]);
                AppMethodBeat.o(144099);
            }
        }
        AppMethodBeat.o(144099);
        return i2;
    }

    @Override // com.tencent.mm.appbrand.v8.o
    public final void cleanup() {
        AppMethodBeat.i(144101);
        for (int i2 = 0; i2 < this.dqI.size(); i2++) {
            this.dqI.valueAt(i2).cancel();
        }
        this.dqI.clear();
        Looper looper = this.dqJ;
        if (!(looper == null || Looper.getMainLooper() == looper)) {
            looper.quit();
            this.dqJ = null;
        }
        AppMethodBeat.o(144101);
    }

    /* access modifiers changed from: package-private */
    public abstract class b {
        m dqQ;
        V8Function dqR;
        int id;

        /* access modifiers changed from: package-private */
        public abstract void schedule();

        b(m mVar, int i2, V8Function v8Function) {
            this.dqQ = mVar;
            this.dqR = v8Function;
            this.id = i2;
        }

        /* access modifiers changed from: package-private */
        public final void a(V8Array v8Array) {
            if (!this.dqR.isReleased() && !this.dqQ.XJ().isReleased()) {
                this.dqR.call(this.dqQ.XJ().getGlobalObject(), v8Array);
            }
        }

        /* access modifiers changed from: package-private */
        public void cancel() {
            cleanup();
        }

        /* access modifiers changed from: package-private */
        public final boolean isValid() {
            return !this.dqR.isReleased() && !this.dqQ.XJ().isReleased();
        }

        /* access modifiers changed from: package-private */
        public void cleanup() {
            t.this.dqI.remove(this.id);
            this.dqR.release();
        }
    }

    class c extends b implements Runnable {
        final long dqS;
        final boolean dqT;
        final V8Array dqU;

        c(m mVar, int i2, V8Function v8Function, V8Array v8Array, boolean z, long j2) {
            super(mVar, i2, v8Function);
            this.dqS = j2;
            this.dqT = z;
            this.dqU = v8Array;
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.appbrand.v8.t.b
        public void schedule() {
            AppMethodBeat.i(144095);
            this.dqQ.dpQ.e(this, this.dqS);
            AppMethodBeat.o(144095);
        }

        public void run() {
            AppMethodBeat.i(144096);
            if (!isValid()) {
                AppMethodBeat.o(144096);
                return;
            }
            a(this.dqU);
            if (!isValid()) {
                AppMethodBeat.o(144096);
            } else if (this.dqT) {
                schedule();
                AppMethodBeat.o(144096);
            } else {
                cleanup();
                AppMethodBeat.o(144096);
            }
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.appbrand.v8.t.b
        public final void cleanup() {
            AppMethodBeat.i(144097);
            super.cleanup();
            this.dqU.release();
            AppMethodBeat.o(144097);
        }
    }

    class a extends c implements Runnable {
        private long dqM;
        private long dqN;
        private final MTimerHandler timer;

        a(final m mVar, int i2, V8Function v8Function, V8Array v8Array, boolean z, long j2) {
            super(mVar, i2, v8Function, v8Array, z, j2);
            AppMethodBeat.i(144091);
            this.timer = new MTimerHandler(t.this.dqJ, (MTimerHandler.CallBack) new MTimerHandler.CallBack(t.this) {
                /* class com.tencent.mm.appbrand.v8.t.a.AnonymousClass1 */

                @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
                public final boolean onTimerExpired() {
                    AppMethodBeat.i(144090);
                    a.this.dqN = SystemClock.elapsedRealtimeNanos();
                    mVar.dpQ.r(a.this);
                    AppMethodBeat.o(144090);
                    return false;
                }
            }, false);
            AppMethodBeat.o(144091);
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.appbrand.v8.t.c, com.tencent.mm.appbrand.v8.t.b
        public final void schedule() {
            AppMethodBeat.i(144092);
            this.timer.startTimer(this.dqS, this.dqS);
            AppMethodBeat.o(144092);
        }

        @Override // com.tencent.mm.appbrand.v8.t.c
        public final void run() {
            AppMethodBeat.i(144093);
            if (!isValid()) {
                AppMethodBeat.o(144093);
                return;
            }
            a(this.dqU);
            if (!isValid()) {
                AppMethodBeat.o(144093);
            } else if (!this.dqT) {
                cleanup();
                AppMethodBeat.o(144093);
            } else {
                long elapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos();
                if (0 == this.dqM) {
                    this.dqM = elapsedRealtimeNanos - this.dqN;
                } else {
                    this.dqM = ((elapsedRealtimeNanos + this.dqM) - this.dqN) / 2;
                }
                long millis = this.dqS - TimeUnit.NANOSECONDS.toMillis(this.dqM);
                if (millis <= 0) {
                    millis = this.dqS;
                }
                this.timer.startTimer(millis, millis);
                AppMethodBeat.o(144093);
            }
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.appbrand.v8.t.b
        public final void cancel() {
            AppMethodBeat.i(144094);
            this.timer.stopTimer();
            super.cancel();
            AppMethodBeat.o(144094);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.appbrand.v8.o
    public final void a(final m mVar, V8Object v8Object) {
        AppMethodBeat.i(144100);
        if (!(mVar.dpQ instanceof b)) {
            this.dqJ = Looper.getMainLooper();
        }
        if (!(mVar.dpQ instanceof h) || !((h) mVar.dpQ).dpc) {
            Log.i("MicroMsg.J2V8.V8DirectApiTimer", "hy: not node. need to inject direct timer");
            v8Object.registerJavaMethod(new JavaCallback() {
                /* class com.tencent.mm.appbrand.v8.t.AnonymousClass1 */

                @Override // com.eclipsesource.v8.JavaCallback
                public final Object invoke(V8Object v8Object, V8Array v8Array) {
                    int i2;
                    V8Array newV8Array;
                    c aVar;
                    AppMethodBeat.i(144086);
                    if (v8Array.length() <= 0 || v8Array.getType(0) != 7) {
                        Log.w("MicroMsg.J2V8.V8DirectApiTimer", "setTimeout parameters invalid length:%d type[0]:%d", Integer.valueOf(v8Array.length()), Integer.valueOf(v8Array.getType(0)));
                        AppMethodBeat.o(144086);
                        return null;
                    }
                    V8Function v8Function = (V8Function) v8Array.getObject(0);
                    if (v8Array.length() <= 1) {
                        i2 = 0;
                    } else if (v8Array.getType(1) == 1) {
                        i2 = v8Array.getInteger(1);
                    } else if (v8Array.getType(1) == 2) {
                        i2 = (int) v8Array.getDouble(1);
                    } else if (v8Array.getType(1) == 4) {
                        i2 = t.gy(v8Array.getString(1));
                        if (i2 == Integer.MIN_VALUE) {
                            AppMethodBeat.o(144086);
                            return null;
                        }
                    } else {
                        Log.w("MicroMsg.J2V8.V8DirectApiTimer", "setTimeout parameters[1] type:%d", Integer.valueOf(v8Array.getType(1)));
                        AppMethodBeat.o(144086);
                        return null;
                    }
                    if (v8Array.length() > 2) {
                        List<? super Object> list = V8ObjectUtils.toList(v8Array);
                        newV8Array = V8ObjectUtils.toV8Array(mVar.XJ(), (List<? extends Object>) list.subList(1, list.size()));
                    } else {
                        newV8Array = mVar.XJ().newV8Array();
                    }
                    t tVar = t.this;
                    m mVar = mVar;
                    tVar.dqH++;
                    if (mVar.dpQ instanceof b) {
                        aVar = new c(mVar, tVar.dqH, v8Function, newV8Array, false, (long) i2);
                    } else {
                        aVar = new a(mVar, tVar.dqH, v8Function, newV8Array, false, (long) i2);
                    }
                    aVar.schedule();
                    tVar.dqI.put(tVar.dqH, aVar);
                    Integer valueOf = Integer.valueOf(tVar.dqH);
                    AppMethodBeat.o(144086);
                    return valueOf;
                }
            }, "setTimeout");
            v8Object.registerJavaMethod(new JavaCallback() {
                /* class com.tencent.mm.appbrand.v8.t.AnonymousClass2 */

                @Override // com.eclipsesource.v8.JavaCallback
                public final Object invoke(V8Object v8Object, V8Array v8Array) {
                    int gy;
                    V8Array newV8Array;
                    c aVar;
                    AppMethodBeat.i(144087);
                    if (v8Array.length() < 2 || v8Array.getType(0) != 7) {
                        Log.w("MicroMsg.J2V8.V8DirectApiTimer", "setInterval parameters invalid length:%d type[0]:%d", Integer.valueOf(v8Array.length()), Integer.valueOf(v8Array.getType(0)));
                        AppMethodBeat.o(144087);
                        return null;
                    }
                    V8Function v8Function = (V8Function) v8Array.getObject(0);
                    if (v8Array.getType(1) == 1) {
                        gy = v8Array.getInteger(1);
                    } else if (v8Array.getType(1) == 2) {
                        gy = (int) v8Array.getDouble(1);
                    } else if (v8Array.getType(1) == 4) {
                        gy = t.gy(v8Array.getString(1));
                        if (gy == Integer.MIN_VALUE) {
                            AppMethodBeat.o(144087);
                            return null;
                        }
                    } else {
                        Log.w("MicroMsg.J2V8.V8DirectApiTimer", "setInterval parameters[1] type:%d", Integer.valueOf(v8Array.getType(1)));
                        AppMethodBeat.o(144087);
                        return null;
                    }
                    if (v8Array.length() > 2) {
                        List<? super Object> list = V8ObjectUtils.toList(v8Array);
                        newV8Array = V8ObjectUtils.toV8Array(mVar.XJ(), (List<? extends Object>) list.subList(1, list.size()));
                    } else {
                        newV8Array = mVar.XJ().newV8Array();
                    }
                    t tVar = t.this;
                    m mVar = mVar;
                    tVar.dqH++;
                    if (mVar.dpQ instanceof b) {
                        aVar = new c(mVar, tVar.dqH, v8Function, newV8Array, true, (long) gy);
                    } else {
                        aVar = new a(mVar, tVar.dqH, v8Function, newV8Array, true, (long) gy);
                    }
                    aVar.schedule();
                    tVar.dqI.put(tVar.dqH, aVar);
                    Integer valueOf = Integer.valueOf(tVar.dqH);
                    AppMethodBeat.o(144087);
                    return valueOf;
                }
            }, "setInterval");
            v8Object.registerJavaMethod(new JavaVoidCallback() {
                /* class com.tencent.mm.appbrand.v8.t.AnonymousClass3 */

                @Override // com.eclipsesource.v8.JavaVoidCallback
                public final void invoke(V8Object v8Object, V8Array v8Array) {
                    AppMethodBeat.i(144088);
                    if (v8Array.length() <= 0 || v8Array.getType(0) != 1) {
                        AppMethodBeat.o(144088);
                        return;
                    }
                    t.a(t.this, v8Array.getInteger(0));
                    AppMethodBeat.o(144088);
                }
            }, "clearTimeout");
            v8Object.registerJavaMethod(new JavaVoidCallback() {
                /* class com.tencent.mm.appbrand.v8.t.AnonymousClass4 */

                @Override // com.eclipsesource.v8.JavaVoidCallback
                public final void invoke(V8Object v8Object, V8Array v8Array) {
                    AppMethodBeat.i(144089);
                    if (v8Array.length() <= 0 || v8Array.getType(0) != 1) {
                        AppMethodBeat.o(144089);
                        return;
                    }
                    t.a(t.this, v8Array.getInteger(0));
                    AppMethodBeat.o(144089);
                }
            }, "clearInterval");
            AppMethodBeat.o(144100);
            return;
        }
        Log.i("MicroMsg.J2V8.V8DirectApiTimer", "hy: node env do not need java imp timer");
        AppMethodBeat.o(144100);
    }

    static /* synthetic */ void a(t tVar, int i2) {
        AppMethodBeat.i(144102);
        b bVar = tVar.dqI.get(i2);
        if (bVar != null) {
            bVar.cancel();
            tVar.dqI.remove(i2);
        }
        AppMethodBeat.o(144102);
    }
}
