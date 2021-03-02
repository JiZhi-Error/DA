package com.tencent.matrix.trace;

import android.app.Application;
import android.os.Build;
import android.os.Looper;
import android.view.Choreographer;
import com.tencent.matrix.e.b;
import com.tencent.matrix.g.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.matrix.trace.core.a;
import com.tencent.matrix.trace.f.c;
import com.tencent.matrix.trace.f.e;
import com.tencent.tav.coremedia.TimeUtil;

public class a extends b {
    public final com.tencent.matrix.trace.a.b daC;
    public com.tencent.matrix.trace.f.b daD;
    public e daE;
    public c daF;
    public com.tencent.matrix.trace.f.a daG;

    public a(com.tencent.matrix.trace.a.b bVar) {
        this.daC = bVar;
    }

    @Override // com.tencent.matrix.e.b
    public void init(Application application, com.tencent.matrix.e.c cVar) {
        super.init(application, cVar);
        com.tencent.matrix.g.c.i("Matrix.TracePlugin", "trace plugin init, trace config: %s", this.daC.toString());
        if (Build.VERSION.SDK_INT < 16) {
            com.tencent.matrix.g.c.e("Matrix.TracePlugin", "[FrameBeat] API is low Build.VERSION_CODES.JELLY_BEAN(16), TracePlugin is not supported", new Object[0]);
            unSupportPlugin();
            return;
        }
        this.daG = new com.tencent.matrix.trace.f.a(this.daC);
        this.daF = new c(this.daC);
        this.daD = new com.tencent.matrix.trace.f.b(this.daC);
        this.daE = new e(this.daC);
    }

    @Override // com.tencent.matrix.e.b
    public void start() {
        super.start();
        if (!isSupported()) {
            com.tencent.matrix.g.c.w("Matrix.TracePlugin", "[start] Plugin is unSupported!", new Object[0]);
            return;
        }
        com.tencent.matrix.g.c.w("Matrix.TracePlugin", "start!", new Object[0]);
        AnonymousClass1 r0 = new Runnable() {
            /* class com.tencent.matrix.trace.a.AnonymousClass1 */

            public final void run() {
                boolean z;
                if (!com.tencent.matrix.trace.core.b.Tw().isInit) {
                    try {
                        com.tencent.matrix.trace.core.b Tw = com.tencent.matrix.trace.core.b.Tw();
                        com.tencent.matrix.trace.a.b bVar = a.this.daC;
                        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
                            throw new AssertionError("must be init in main thread!");
                        }
                        Tw.daS = bVar;
                        Tw.choreographer = Choreographer.getInstance();
                        Tw.dbp = f.b(Tw.choreographer, "mLock", new Object());
                        Tw.dbq = (Object[]) f.b(Tw.choreographer, "mCallbackQueues", null);
                        if (Tw.dbq != null) {
                            Tw.dbs = f.c(Tw.dbq[0], "addCallbackLocked", Long.TYPE, Object.class, Object.class);
                            Tw.dbt = f.c(Tw.dbq[1], "addCallbackLocked", Long.TYPE, Object.class, Object.class);
                            Tw.dbr = f.c(Tw.dbq[2], "addCallbackLocked", Long.TYPE, Object.class, Object.class);
                        }
                        Tw.dbu = f.b(Tw.choreographer, "mDisplayEventReceiver", null);
                        Tw.cPm = ((Long) f.b(Tw.choreographer, "mFrameIntervalNanos", 16666667L)).longValue();
                        com.tencent.matrix.trace.core.a.a(new a.AbstractC0235a() {
                            /* class com.tencent.matrix.trace.core.b.AnonymousClass1 */

                            @Override // com.tencent.matrix.trace.core.a.AbstractC0235a
                            public final boolean isValid() {
                                return b.this.dbi;
                            }

                            @Override // com.tencent.matrix.trace.core.a.AbstractC0235a
                            public final void dispatchStart() {
                                super.dispatchStart();
                                b.b(b.this);
                            }

                            @Override // com.tencent.matrix.trace.core.a.AbstractC0235a
                            public final void dispatchEnd() {
                                super.dispatchEnd();
                                b.c(b.this);
                            }
                        });
                        Tw.isInit = true;
                        Object[] objArr = new Object[7];
                        objArr[0] = Boolean.valueOf(Tw.dbp == null);
                        objArr[1] = Boolean.valueOf(Tw.dbq == null);
                        objArr[2] = Boolean.valueOf(Tw.dbs == null);
                        if (Tw.dbr == null) {
                            z = true;
                        } else {
                            z = false;
                        }
                        objArr[3] = Boolean.valueOf(z);
                        objArr[4] = Boolean.valueOf(Tw.dbt == null);
                        objArr[5] = Boolean.valueOf(Tw.dbu == null);
                        objArr[6] = Long.valueOf(Tw.cPm);
                        com.tencent.matrix.g.c.i("Matrix.UIThreadMonitor", "[UIThreadMonitor] %s %s %s %s %s %s frameIntervalNanos:%s", objArr);
                        if (bVar.daO) {
                            Tw.a(new com.tencent.matrix.trace.e.c() {
                                /* class com.tencent.matrix.trace.core.b.AnonymousClass2 */

                                @Override // com.tencent.matrix.trace.e.c
                                public final void a(String str, long j2, long j3, boolean z, long j4, long j5, long j6, long j7) {
                                    com.tencent.matrix.g.c.i("Matrix.UIThreadMonitor", "focusedActivity[%s] frame cost:%sms isVsyncFrame=%s intendedFrameTimeNs=%s [%s|%s|%s]ns", str, Long.valueOf((j3 - j2) / TimeUtil.SECOND_TO_US), Boolean.valueOf(z), Long.valueOf(j4), Long.valueOf(j5), Long.valueOf(j6), Long.valueOf(j7));
                                }
                            });
                        }
                    } catch (RuntimeException e2) {
                        com.tencent.matrix.g.c.e("Matrix.TracePlugin", "[start] RuntimeException:%s", e2);
                        return;
                    }
                }
                AppMethodBeat.getInstance().onStart();
                com.tencent.matrix.trace.core.b.Tw().onStart();
                a.this.daG.TG();
                a.this.daF.TG();
                a.this.daD.TG();
                a.this.daE.TG();
            }
        };
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            r0.run();
            return;
        }
        com.tencent.matrix.g.c.w("Matrix.TracePlugin", "start TracePlugin in Thread[%s] but not in mainThread!", Long.valueOf(Thread.currentThread().getId()));
        com.tencent.matrix.g.b.TO().post(r0);
    }

    @Override // com.tencent.matrix.e.b
    public void stop() {
        super.stop();
        if (!isSupported()) {
            com.tencent.matrix.g.c.w("Matrix.TracePlugin", "[stop] Plugin is unSupported!", new Object[0]);
            return;
        }
        com.tencent.matrix.g.c.w("Matrix.TracePlugin", "stop!", new Object[0]);
        AnonymousClass2 r0 = new Runnable() {
            /* class com.tencent.matrix.trace.a.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.getInstance().onStop();
                com.tencent.matrix.trace.core.b.Tw().onStop();
                a.this.daG.TH();
                a.this.daF.TH();
                a.this.daD.TH();
                a.this.daE.TH();
            }
        };
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            r0.run();
            return;
        }
        com.tencent.matrix.g.c.w("Matrix.TracePlugin", "stop TracePlugin in Thread[%s] but not in mainThread!", Long.valueOf(Thread.currentThread().getId()));
        com.tencent.matrix.g.b.TO().post(r0);
    }

    @Override // com.tencent.matrix.e.b, com.tencent.matrix.b.c
    public void onForeground(boolean z) {
        super.onForeground(z);
        if (isSupported()) {
            if (this.daF != null) {
                this.daF.onForeground(z);
            }
            if (this.daG != null) {
                this.daG.onForeground(z);
            }
            if (this.daD != null) {
                this.daD.onForeground(z);
            }
            if (this.daE != null) {
                this.daE.onForeground(z);
            }
        }
    }

    @Override // com.tencent.matrix.e.b
    public void destroy() {
        super.destroy();
    }

    @Override // com.tencent.matrix.e.b
    public String getTag() {
        return "Trace";
    }

    public static AppMethodBeat Ts() {
        return AppMethodBeat.getInstance();
    }

    public static com.tencent.matrix.trace.core.b Tt() {
        if (com.tencent.matrix.trace.core.b.Tw().isInit) {
            return com.tencent.matrix.trace.core.b.Tw();
        }
        return null;
    }
}
