package com.tencent.mm.appbrand.v8;

import com.eclipsesource.v8.V8ScriptException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.v8.c;
import com.tencent.mm.appbrand.v8.l;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.reflect.UndeclaredThrowableException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/* access modifiers changed from: package-private */
public class z implements c {
    private static final ThreadLocal<z> dpE = new ThreadLocal<>();
    private boolean CA;
    private k dpw = new k();
    private final Thread dro = Thread.currentThread();
    private final l<Runnable> drp = new l<>(new LinkedList());
    private a drq = a.NONE;
    private volatile boolean drr;
    private final boolean drs;
    private c.a drt;
    private Queue<Runnable> dru = new LinkedList();
    private Queue<Runnable> drv = new LinkedList();
    private boolean drw = false;
    private int drx = -1;

    enum a {
        NONE,
        RESUME,
        ENQUEUE;

        public static a valueOf(String str) {
            AppMethodBeat.i(185104);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(185104);
            return aVar;
        }

        static {
            AppMethodBeat.i(185105);
            AppMethodBeat.o(185105);
        }
    }

    static {
        AppMethodBeat.i(144143);
        AppMethodBeat.o(144143);
    }

    z(boolean z) {
        AppMethodBeat.i(216926);
        l.a aVar = l.dpP;
        this.drs = z;
        Log.i("MicroMsg.V8JSRuntimeLooper", "V8JSRuntimeLooper <init> ignoreRemainingTaskWhenLoopEnd?%b", Boolean.valueOf(z));
        AppMethodBeat.o(216926);
    }

    @Override // com.tencent.mm.appbrand.v8.c
    public final void loop() {
        boolean isPaused;
        AppMethodBeat.i(144132);
        Log.i("MicroMsg.V8JSRuntimeLooper", "loop start %d", Integer.valueOf(hashCode()));
        while (!this.drr) {
            synchronized (this.drp) {
                while (true) {
                    try {
                        isPaused = isPaused();
                        if ((!isPaused || this.drp.XI()) && !XC()) {
                            break;
                        }
                        try {
                            this.drp.wait();
                            if (a.RESUME == this.drq) {
                                Log.i("MicroMsg.V8JSRuntimeLooper", "loop notify by reason:%s, instance:%d", this.drq, Integer.valueOf(hashCode()));
                            }
                            this.drq = a.NONE;
                        } catch (InterruptedException e2) {
                            Log.i("MicroMsg.V8JSRuntimeLooper", "wait interrupted ; loop end");
                            this.dro.interrupt();
                        }
                    } catch (Throwable th) {
                        AppMethodBeat.o(144132);
                        throw th;
                    }
                }
                this.dru.clear();
                this.drp.a(this.dru, isPaused);
            }
            XD();
        }
        XF();
        synchronized (this.drp) {
            try {
                this.drp.clear();
            } finally {
                AppMethodBeat.o(144132);
            }
        }
    }

    @Override // com.tencent.mm.appbrand.v8.c
    public final boolean Xw() {
        AppMethodBeat.i(144133);
        if (Thread.currentThread().getId() == this.dro.getId()) {
            AppMethodBeat.o(144133);
            return true;
        }
        AppMethodBeat.o(144133);
        return false;
    }

    @Override // com.tencent.mm.appbrand.v8.c
    public final void cS(boolean z) {
        this.dpw.enable = z;
    }

    @Override // com.tencent.mm.appbrand.v8.c
    public final String LP() {
        AppMethodBeat.i(185106);
        String peek = this.dpw.dpM.peek();
        AppMethodBeat.o(185106);
        return peek;
    }

    @Override // com.tencent.mm.appbrand.v8.c
    public final void u(Runnable runnable) {
        AppMethodBeat.i(216927);
        if (runnable == null) {
            AppMethodBeat.o(216927);
        } else if (this.drr) {
            Log.i("MicroMsg.V8JSRuntimeLooper", "schedule but looper end");
            AppMethodBeat.o(216927);
        } else {
            if (Thread.currentThread().getId() == this.dro.getId()) {
                v(runnable);
                if (this.dpw.enable) {
                    this.dpw.dpM.remove(null);
                }
            } else {
                boolean isPaused = isPaused();
                synchronized (this.drp) {
                    try {
                        this.drp.b(runnable, false);
                        if (!isPaused) {
                            this.drq = a.ENQUEUE;
                            this.drp.notify();
                        }
                    } catch (Throwable th) {
                        AppMethodBeat.o(216927);
                        throw th;
                    }
                }
            }
            XG();
            AppMethodBeat.o(216927);
        }
    }

    @Override // com.tencent.mm.appbrand.v8.c
    public final void b(Runnable runnable, long j2, boolean z) {
        AppMethodBeat.i(216928);
        if (runnable == null) {
            AppMethodBeat.o(216928);
        } else if (j2 != 0) {
            IllegalStateException illegalStateException = new IllegalStateException("V8JSRuntimeLooper#scheduleDelayed not support.");
            AppMethodBeat.o(216928);
            throw illegalStateException;
        } else if (this.drr) {
            Log.i("MicroMsg.V8JSRuntimeLooper", "scheduleDelayed but looper end");
            AppMethodBeat.o(216928);
        } else {
            boolean isPaused = isPaused();
            synchronized (this.drp) {
                try {
                    this.drp.b(runnable, z);
                    if (z || !isPaused) {
                        this.drp.notify();
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(216928);
                    throw th;
                }
            }
            if (z && isPaused) {
                Log.i("MicroMsg.V8JSRuntimeLooper", "scheduleDelayed: important task in pause state. queue.size:[%d]", Integer.valueOf(XQ()));
            }
            XG();
            AppMethodBeat.o(216928);
        }
    }

    private int XQ() {
        int size;
        AppMethodBeat.i(216929);
        synchronized (this.drp) {
            try {
                size = this.drp.size();
            } finally {
                AppMethodBeat.o(216929);
            }
        }
        return size;
    }

    @Override // com.tencent.mm.appbrand.v8.c
    public final void pause() {
        AppMethodBeat.i(144136);
        Log.i("MicroMsg.V8JSRuntimeLooper", "pause instance:%d queue.size:%d", Integer.valueOf(hashCode()), Integer.valueOf(XQ()));
        synchronized (this) {
            try {
                this.CA = true;
            } finally {
                AppMethodBeat.o(144136);
            }
        }
    }

    @Override // com.tencent.mm.appbrand.v8.c
    public final void resume() {
        AppMethodBeat.i(144137);
        Log.i("MicroMsg.V8JSRuntimeLooper", "resume instance:%d queue.size:%d", Integer.valueOf(hashCode()), Integer.valueOf(XQ()));
        synchronized (this) {
            try {
                this.CA = false;
            } finally {
                AppMethodBeat.o(144137);
            }
        }
        onResume();
        synchronized (this.drp) {
            try {
                this.drq = a.RESUME;
                this.drp.notify();
            } finally {
                AppMethodBeat.o(144137);
            }
        }
    }

    @Override // com.tencent.mm.appbrand.v8.c
    public final void quit() {
        AppMethodBeat.i(144138);
        Log.i("MicroMsg.V8JSRuntimeLooper", "quit %d", Integer.valueOf(hashCode()));
        XH();
        this.drr = true;
        this.dro.interrupt();
        AppMethodBeat.o(144138);
    }

    @Override // com.tencent.mm.appbrand.v8.c
    public final void a(c.a aVar) {
        this.drt = aVar;
    }

    /* access modifiers changed from: protected */
    public boolean XC() {
        AppMethodBeat.i(144139);
        boolean isEmpty = this.drp.isEmpty();
        AppMethodBeat.o(144139);
        return isEmpty;
    }

    /* access modifiers changed from: protected */
    public final synchronized boolean isPaused() {
        return this.CA;
    }

    /* access modifiers changed from: protected */
    public void XF() {
        AppMethodBeat.i(144140);
        Log.i("MicroMsg.V8JSRuntimeLooper", "loop end");
        AppMethodBeat.o(144140);
    }

    /* access modifiers changed from: protected */
    public void XG() {
    }

    /* access modifiers changed from: protected */
    public void onResume() {
    }

    /* access modifiers changed from: protected */
    public void XH() {
    }

    /* access modifiers changed from: protected */
    public void XD() {
        AppMethodBeat.i(144141);
        this.drx = -1;
        this.drw = false;
        for (Runnable runnable : this.dru) {
            if (!this.drs || !this.drr) {
                this.drx++;
                v(runnable);
                if (this.dpw.enable) {
                    this.dpw.dpM.pollFirst();
                }
                if (this.drw) {
                    break;
                }
            } else {
                Log.i("MicroMsg.V8JSRuntimeLooper", "LoopTask break for mLooperEnd");
                AppMethodBeat.o(144141);
                return;
            }
        }
        AppMethodBeat.o(144141);
    }

    /* access modifiers changed from: protected */
    public void XE() {
        AppMethodBeat.i(216930);
        for (Runnable runnable : this.drv) {
            if (!this.drs || !this.drr) {
                v(runnable);
                if (this.dpw.enable) {
                    this.dpw.dpM.pollFirst();
                }
            } else {
                Log.i("MicroMsg.V8JSRuntimeLooper", "LoopTask break for mLooperEnd");
                AppMethodBeat.o(216930);
                return;
            }
        }
        AppMethodBeat.o(216930);
    }

    @Override // com.tencent.mm.appbrand.v8.c
    public final boolean doInnerLoopTask() {
        boolean isPaused;
        AppMethodBeat.i(216931);
        if (this.drr) {
            this.drw = true;
            AppMethodBeat.o(216931);
            return true;
        }
        synchronized (this.drp) {
            while (true) {
                try {
                    isPaused = isPaused();
                    if ((!isPaused || this.drp.XI()) && !XC()) {
                        break;
                    }
                    try {
                        this.drp.wait();
                        if (a.RESUME == this.drq) {
                            Log.i("MicroMsg.V8JSRuntimeLooper", "loop notify by reason:%s, instance:%d", this.drq, Integer.valueOf(hashCode()));
                        }
                        this.drq = a.NONE;
                    } catch (InterruptedException e2) {
                        Log.i("MicroMsg.V8JSRuntimeLooper", "wait interrupted ; loop end");
                        this.dro.interrupt();
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(216931);
                    throw th;
                }
            }
            this.drv.clear();
            this.drp.a(this.drv, isPaused);
        }
        XE();
        AppMethodBeat.o(216931);
        return false;
    }

    @Override // com.tencent.mm.appbrand.v8.c
    public final void resumeLoopTasks() {
        AppMethodBeat.i(216932);
        Iterator<Runnable> it = this.dru.iterator();
        int i2 = -1;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Runnable next = it.next();
            if (this.drs && this.drr) {
                Log.i("MicroMsg.V8JSRuntimeLooper", "LoopTask break for mLooperEnd");
                break;
            }
            i2++;
            if (i2 > this.drx) {
                this.drx = i2;
                v(next);
                if (this.dpw.enable) {
                    this.dpw.dpM.pollFirst();
                }
                if (this.drw) {
                    break;
                }
            }
        }
        this.drw = true;
        AppMethodBeat.o(216932);
    }

    private void v(Runnable runnable) {
        AppMethodBeat.i(144142);
        try {
            runnable.run();
            AppMethodBeat.o(144142);
        } catch (V8ScriptException e2) {
            if (this.drt != null) {
                this.drt.b(e2);
            }
            if (e2.getCause() != null) {
                Log.e("MicroMsg.V8JSRuntimeLooper", "runTask V8ScriptException: %s, %s", e2, e2.getCause());
            }
            AppMethodBeat.o(144142);
        } catch (UndeclaredThrowableException e3) {
            Log.e("MicroMsg.V8JSRuntimeLooper", "runTask UndeclaredThrowableException: %s %s", e3, e3.getCause());
            AppMethodBeat.o(144142);
        } catch (NullPointerException e4) {
            Log.printErrStackTrace("MicroMsg.V8JSRuntimeLooper", e4, "runTask", new Object[0]);
            AppMethodBeat.o(144142);
            throw e4;
        }
    }
}
