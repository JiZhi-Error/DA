package com.tencent.mm.appbrand.v8;

import android.os.Process;
import android.util.SparseArray;
import com.eclipsesource.v8.MultiContextV8;
import com.eclipsesource.v8.V8Context;
import com.eclipsesource.v8.V8Locker;
import com.eclipsesource.v8.V8ScriptException;
import com.eclipsesource.v8.utils.MemoryManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.v8.IJSRuntime;
import com.tencent.mm.appbrand.v8.c;
import com.tencent.mm.appbrand.v8.m;
import com.tencent.mm.plugin.appbrand.m.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.lang.reflect.UndeclaredThrowableException;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class a implements IJSRuntime {
    private static final AtomicInteger doO = new AtomicInteger(0);
    private static Runnable doP = new Runnable() {
        /* class com.tencent.mm.appbrand.v8.a.AnonymousClass1 */

        public final void run() {
            AppMethodBeat.i(143988);
            AppMethodBeat.o(143988);
        }
    };
    private MultiContextV8 doQ;
    private c doR;
    private CountDownLatch doS;
    private MemoryManager doT;
    private aa doU;
    private e doV;
    private String doW = "RuntimeLooper";
    String doX;
    byte[] doY;
    String doZ;
    boolean dpa;
    private final boolean dpb;
    final boolean dpc;
    private final SparseArray<h> dpd;
    private final ConcurrentLinkedQueue<Runnable> dpe;
    IJSRuntime.Config dpf;
    private volatile int mTid = -1;

    /* access modifiers changed from: package-private */
    public abstract MultiContextV8 Xs();

    /* access modifiers changed from: package-private */
    public abstract c Xt();

    /* access modifiers changed from: package-private */
    public abstract void Xu();

    @Override // com.tencent.mm.appbrand.v8.IJSRuntime
    public final IJSRuntime.Config Xr() {
        return this.dpf;
    }

    a(IJSRuntime.Config config) {
        IJSRuntime.Config config2;
        if (config != null) {
            this.doX = config.dpj;
            this.doY = config.dpk;
            this.dpb = config.useNativeBufferJNI();
            this.dpa = config.dpn;
            this.dpc = config.dpo;
            this.doZ = config.dpq;
            this.doV = config.opR;
            if (!Util.isNullOrNil(config.dpr)) {
                this.doW = config.dpr;
            }
        } else {
            this.dpb = false;
            this.dpc = false;
        }
        if (config == null) {
            config2 = new IJSRuntime.Config();
        } else {
            config2 = config;
        }
        this.dpf = config2;
        Log.i("MicroMsg.AbstractJSRuntime", "hy: use native buffer: %b, hasGlobalTimer: %b", Boolean.valueOf(this.dpb), Boolean.valueOf(this.dpc));
        Object[] objArr = new Object[1];
        objArr[0] = config != null ? config.toString() : "";
        Log.i("MicroMsg.AbstractJSRuntime", "hy: config: %s", objArr);
        this.dpd = new SparseArray<>();
        this.dpe = new ConcurrentLinkedQueue<>();
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        this.doS = new CountDownLatch(1);
        new Thread(String.format(Locale.US, "JS%s#%d", this.doW, Integer.valueOf(doO.getAndIncrement()))) {
            /* class com.tencent.mm.appbrand.v8.a.AnonymousClass3 */

            public final void run() {
                AppMethodBeat.i(143991);
                a.this.mTid = Process.myTid();
                a.doP.run();
                Log.i("MicroMsg.AbstractJSRuntime", "expansions file is ready");
                a.this.doR = a.this.Xt();
                a.this.doR.a(new c.a() {
                    /* class com.tencent.mm.appbrand.v8.a.AnonymousClass3.AnonymousClass1 */

                    @Override // com.tencent.mm.appbrand.v8.c.a
                    public final void b(V8ScriptException v8ScriptException) {
                        AppMethodBeat.i(143990);
                        a.this.a((a) v8ScriptException);
                        AppMethodBeat.o(143990);
                    }
                });
                countDownLatch.countDown();
                a.this.doS.countDown();
                long currentTimeMillis = System.currentTimeMillis();
                Log.i("MicroMsg.AbstractJSRuntime", "prepareV8WhenThreadStart, tid[%d] JsRuntime[%d] JsLooper[%d]", Integer.valueOf(a.this.mTid), Integer.valueOf(a.this.hashCode()), Integer.valueOf(a.this.doR.hashCode()));
                a.this.doQ = a.this.Xs();
                a.this.doU = new aa(a.this.doQ);
                aa unused = a.this.doU;
                a.this.doT = a.this.doQ.createMemoryManager();
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                Log.i("MicroMsg.AbstractJSRuntime", "v8 init cost:%d ms", Long.valueOf(currentTimeMillis2));
                x.a(5, currentTimeMillis2, -1, null, -1, -1, -1);
                V8Locker v8Locker = a.this.doQ.getV8Locker();
                if (v8Locker.hasLock()) {
                    Log.i("MicroMsg.AbstractJSRuntime", "has lock release");
                    v8Locker.release();
                }
                v8Locker.acquire();
                a.this.doR.loop();
                a.f(a.this);
                a.this.doT.release();
                aa unused2 = a.this.doU;
                try {
                    a.this.dpd.clear();
                    Log.i("MicroMsg.AbstractJSRuntime", "whenThreadEnd, mJSExceptionHandlerMap.clear() succeed, JsRuntime[%d]", Integer.valueOf(a.this.hashCode()));
                } catch (Throwable th) {
                    Log.e("MicroMsg.AbstractJSRuntime", "whenThreadEnd, mJSExceptionHandlerMap.clear(), JsRuntime[%d] get exception[%s]", Integer.valueOf(a.this.hashCode()), th);
                }
                a.this.Xu();
                AppMethodBeat.o(143991);
            }
        }.start();
        try {
            countDownLatch.await(5000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e2) {
            Log.i("MicroMsg.AbstractJSRuntime", "init latch.await InterruptedException:%s", e2);
        }
    }

    public final e Xv() {
        if (this.doV == null) {
            if (this.dpb) {
                Log.i("MicroMsg.AbstractJSRuntime", "hy: start load native buffer jni");
                this.doV = new NativeBufferJNI();
            } else {
                this.doV = new u();
            }
        }
        return this.doV;
    }

    @Override // com.tencent.mm.appbrand.v8.IJSRuntime
    public final void setThreadPriority(int i2) {
        int i3 = this.mTid;
        if (i3 > 0) {
            try {
                Process.setThreadPriority(i3, i2);
                Log.d("MicroMsg.AbstractJSRuntime", "setThreadPriority priority=%d tid=%d", Integer.valueOf(i2), Integer.valueOf(i3));
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.AbstractJSRuntime", e2, "setThreadPriority priority=%d tid=%d", Integer.valueOf(i2), Integer.valueOf(i3));
            }
        }
    }

    @Override // com.tencent.mm.appbrand.v8.IJSRuntime
    public final void cS(boolean z) {
        this.doR.cS(z);
    }

    @Override // com.tencent.mm.appbrand.v8.IJSRuntime
    public final String LP() {
        return this.doR.LP();
    }

    @Override // com.tencent.mm.appbrand.v8.IJSRuntime
    public final void pause() {
        this.doR.pause();
    }

    @Override // com.tencent.mm.appbrand.v8.IJSRuntime
    public final void resume() {
        this.doR.resume();
    }

    @Override // com.tencent.mm.appbrand.v8.IJSRuntime
    public final void quit() {
        Log.i("MicroMsg.AbstractJSRuntime", "quit() JsRuntime[%d]", Integer.valueOf(hashCode()));
        this.doR.quit();
        this.mTid = -1;
    }

    @Override // com.tencent.mm.appbrand.v8.IJSRuntime
    public final void r(Runnable runnable) {
        s(runnable);
    }

    @Override // com.tencent.mm.appbrand.v8.IJSRuntime
    public final void s(Runnable runnable) {
        Xx();
        this.doR.u(runnable);
    }

    @Override // com.tencent.mm.appbrand.v8.IJSRuntime
    public final void e(Runnable runnable, long j2) {
        a(runnable, j2, false);
    }

    @Override // com.tencent.mm.appbrand.v8.IJSRuntime
    public final void a(Runnable runnable, long j2, boolean z) {
        Xx();
        this.doR.b(runnable, j2, z);
    }

    @Override // com.tencent.mm.appbrand.v8.IJSRuntime
    public final boolean Xw() {
        return this.doR.Xw();
    }

    @Override // com.tencent.mm.appbrand.v8.IJSRuntime
    public final void t(Runnable runnable) {
        this.dpe.add(runnable);
    }

    @Override // com.tencent.mm.appbrand.v8.IJSRuntime
    public final m iP(final int i2) {
        return new m(this, Xv(), new m.a() {
            /* class com.tencent.mm.appbrand.v8.a.AnonymousClass2 */

            @Override // com.tencent.mm.appbrand.v8.m.a
            public final V8Context Xy() {
                AppMethodBeat.i(143989);
                if (a.this.doQ == null) {
                    IllegalStateException illegalStateException = new IllegalStateException("createContext mV8 not ready!");
                    AppMethodBeat.o(143989);
                    throw illegalStateException;
                }
                V8Context createContext = a.this.doQ.createContext(i2);
                AppMethodBeat.o(143989);
                return createContext;
            }
        });
    }

    @Override // com.tencent.mm.appbrand.v8.IJSRuntime
    public final void a(int i2, h hVar) {
        if (this.mTid < 0) {
            Log.e("MicroMsg.AbstractJSRuntime", "setJsExceptionHandler after destroyed, JsRuntime[%d] stack=%s", Integer.valueOf(hashCode()), android.util.Log.getStackTraceString(new Throwable()));
            return;
        }
        Log.i("MicroMsg.AbstractJSRuntime", "setJsExceptionHandler contextId[%d] JsRuntime[%d] JSThread.id[%d], currentThread.id[%d]", Integer.valueOf(i2), Integer.valueOf(hashCode()), Integer.valueOf(this.mTid), Long.valueOf(Thread.currentThread().getId()));
        synchronized (this.dpd) {
            this.dpd.put(i2, hVar);
        }
    }

    private void Xx() {
        if (this.doR == null && this.doS != null) {
            Log.i("MicroMsg.AbstractJSRuntime", "scheduleToJSThread but looper null");
            try {
                this.doS.await(30000, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e2) {
                Log.i("MicroMsg.AbstractJSRuntime", "scheduleToJSThread latch.await InterruptedException:%s", e2);
            }
            Log.i("MicroMsg.AbstractJSRuntime", "scheduleToJSThread but looper assigned");
        }
        if (this.doR == null) {
            doP.run();
            if (this.doR == null) {
                throw new IllegalStateException("JSRuntime not ready!");
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void a(V8ScriptException v8ScriptException) {
        h hVar;
        synchronized (this.dpd) {
            hVar = this.dpd.get(v8ScriptException.getContextTag());
        }
        if (hVar != null) {
            hVar.u(v8ScriptException.getJSMessage(), v8ScriptException.getJSStackTrace());
            return;
        }
        Log.w("MicroMsg.AbstractJSRuntime", "publishJSException jsHandler null %s", v8ScriptException);
    }

    @Override // com.tencent.mm.appbrand.v8.IJSRuntime
    public final long getIsolatePtr() {
        return this.doQ.getIsolatePtr();
    }

    @Override // com.tencent.mm.appbrand.v8.IJSRuntime
    public final long getUVLoopPtr() {
        return this.doQ.getUVLoopPtr();
    }

    @Override // com.tencent.mm.appbrand.v8.IJSRuntime
    public final void waitForDebugger(String str) {
        n nVar = new n(this.doQ, this);
        nVar.dqn.r(new Runnable(str) {
            /* class com.tencent.mm.appbrand.v8.n.AnonymousClass1 */
            final /* synthetic */ String dqb;

            {
                this.dqb = r2;
            }

            public final void run() {
                AppMethodBeat.i(144068);
                if (n.this.doQ == null) {
                    IllegalStateException illegalStateException = new IllegalStateException("V8DebuggerHelper v8 null");
                    AppMethodBeat.o(144068);
                    throw illegalStateException;
                }
                n.this.doQ.waitForDebugger(this.dqb);
                n nVar = n.this;
                if (nVar.dqo == null) {
                    nVar.dqo = new Timer();
                    nVar.dqo.schedule(new TimerTask() {
                        /* class com.tencent.mm.appbrand.v8.n.AnonymousClass4 */

                        public final void run() {
                            AppMethodBeat.i(144071);
                            n.this.dqn.r(n.this.dqp);
                            AppMethodBeat.o(144071);
                        }
                    }, 2000, 2000);
                }
                AppMethodBeat.o(144068);
            }
        });
        nVar.dqn.t(new Runnable() {
            /* class com.tencent.mm.appbrand.v8.n.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(144069);
                if (n.this.dqo != null) {
                    n.this.dqo.cancel();
                }
                AppMethodBeat.o(144069);
            }
        });
    }

    @Override // com.tencent.mm.appbrand.v8.IJSRuntime
    public final void resumeLoopTasks() {
        this.doR.resumeLoopTasks();
    }

    @Override // com.tencent.mm.appbrand.v8.IJSRuntime
    public final boolean doInnerLoopTask() {
        return this.doR.doInnerLoopTask();
    }

    static /* synthetic */ void f(a aVar) {
        while (true) {
            Runnable poll = aVar.dpe.poll();
            if (poll != null) {
                try {
                    poll.run();
                } catch (V8ScriptException e2) {
                    aVar.a(e2);
                } catch (UndeclaredThrowableException e3) {
                    Log.e("MicroMsg.AbstractJSRuntime", "doPostedCleanUpJob UndeclaredThrowableException: %s %s", e3, e3.getCause());
                }
            } else {
                return;
            }
        }
    }
}
