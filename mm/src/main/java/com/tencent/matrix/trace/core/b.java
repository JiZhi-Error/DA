package com.tencent.matrix.trace.core;

import android.os.SystemClock;
import android.view.Choreographer;
import com.tencent.matrix.g.f;
import com.tencent.matrix.trace.e.c;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

public final class b implements Runnable {
    private static final b dbo = new b();
    public long cPm = 16666666;
    public Choreographer choreographer;
    public com.tencent.matrix.trace.a.b daS;
    private volatile boolean dbi = false;
    private long[] dbj = new long[4];
    private final HashSet<c> dbk = new HashSet<>();
    private volatile long dbl = 0;
    private boolean dbn = false;
    public Object dbp;
    public Object[] dbq;
    public Method dbr;
    public Method dbs;
    public Method dbt;
    public Object dbu;
    private int[] dbv = new int[3];
    private boolean[] dbw = new boolean[3];
    private long[] dbx = new long[3];
    private long[] dby = null;
    public boolean isInit = false;

    static /* synthetic */ void b(b bVar) {
        long[] jArr = bVar.dbj;
        long nanoTime = System.nanoTime();
        jArr[0] = nanoTime;
        bVar.dbl = nanoTime;
        bVar.dbj[2] = SystemClock.currentThreadTimeMillis();
        AppMethodBeat.i(AppMethodBeat.METHOD_ID_DISPATCH);
        synchronized (bVar.dbk) {
            Iterator<c> it = bVar.dbk.iterator();
            while (it.hasNext()) {
                c next = it.next();
                if (!next.dbX) {
                    next.d(bVar.dbj[0], bVar.dbj[2], bVar.dbl);
                }
            }
        }
        if (bVar.daS.daO) {
            com.tencent.matrix.g.c.d("Matrix.UIThreadMonitor", "[dispatchBegin#run] inner cost:%sns", Long.valueOf(System.nanoTime() - bVar.dbl));
        }
    }

    public static b Tw() {
        return dbo;
    }

    private synchronized void b(int i2, Runnable runnable) {
        Method method = null;
        synchronized (this) {
            if (this.dbw[i2]) {
                com.tencent.matrix.g.c.w("Matrix.UIThreadMonitor", "[addFrameCallback] this type %s callback has exist! isAddHeader:%s", Integer.valueOf(i2), Boolean.TRUE);
            } else if (this.dbi || i2 != 0) {
                try {
                    synchronized (this.dbp) {
                        switch (i2) {
                            case 0:
                                method = this.dbs;
                                break;
                            case 1:
                                method = this.dbt;
                                break;
                            case 2:
                                method = this.dbr;
                                break;
                        }
                        if (method != null) {
                            method.invoke(this.dbq[i2], -1L, runnable, null);
                            this.dbw[i2] = true;
                        }
                    }
                } catch (Exception e2) {
                    com.tencent.matrix.g.c.e("Matrix.UIThreadMonitor", e2.toString(), new Object[0]);
                }
            } else {
                com.tencent.matrix.g.c.w("Matrix.UIThreadMonitor", "[addFrameCallback] UIThreadMonitor is not alive!", new Object[0]);
            }
        }
    }

    public final void a(c cVar) {
        if (!this.dbi) {
            onStart();
        }
        synchronized (this.dbk) {
            this.dbk.add(cVar);
        }
    }

    public final void b(c cVar) {
        synchronized (this.dbk) {
            this.dbk.remove(cVar);
            if (this.dbk.isEmpty()) {
                onStop();
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void iv(int i2) {
        this.dbv[i2] = 1;
        this.dbx[i2] = System.nanoTime();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void iw(int i2) {
        this.dbv[i2] = 2;
        this.dbx[i2] = System.nanoTime() - this.dbx[i2];
        synchronized (this) {
            this.dbw[i2] = false;
        }
    }

    public final synchronized void onStart() {
        if (!this.isInit) {
            com.tencent.matrix.g.c.e("Matrix.UIThreadMonitor", "[onStart] is never init.", new Object[0]);
        } else if (!this.dbi) {
            this.dbi = true;
            synchronized (this) {
                com.tencent.matrix.g.c.i("Matrix.UIThreadMonitor", "[onStart] callbackExist:%s %s", Arrays.toString(this.dbw), com.tencent.matrix.trace.g.b.getStack());
                this.dbw = new boolean[3];
                this.dbv = new int[3];
                this.dbx = new long[3];
                b(0, this);
            }
        }
    }

    public final void run() {
        long nanoTime = System.nanoTime();
        try {
            long j2 = this.dbl;
            this.dbn = true;
            iv(0);
            b(1, new Runnable() {
                /* class com.tencent.matrix.trace.core.b.AnonymousClass3 */

                public final void run() {
                    b.this.iw(0);
                    b.this.iv(1);
                }
            });
            b(2, new Runnable() {
                /* class com.tencent.matrix.trace.core.b.AnonymousClass4 */

                public final void run() {
                    b.this.iw(1);
                    b.this.iv(2);
                }
            });
            if (this.daS.daO) {
                com.tencent.matrix.g.c.d("Matrix.UIThreadMonitor", "[UIThreadMonitor#run] inner cost:%sns", Long.valueOf(System.nanoTime() - nanoTime));
            }
        } catch (Throwable th) {
            if (this.daS.daO) {
                com.tencent.matrix.g.c.d("Matrix.UIThreadMonitor", "[UIThreadMonitor#run] inner cost:%sns", Long.valueOf(System.nanoTime() - nanoTime));
            }
            throw th;
        }
    }

    public final synchronized void onStop() {
        if (!this.isInit) {
            com.tencent.matrix.g.c.e("Matrix.UIThreadMonitor", "[onStart] is never init.", new Object[0]);
        } else if (this.dbi) {
            this.dbi = false;
            com.tencent.matrix.g.c.i("Matrix.UIThreadMonitor", "[onStop] callbackExist:%s %s", Arrays.toString(this.dbw), com.tencent.matrix.trace.g.b.getStack());
        }
    }

    private long bh(long j2) {
        try {
            return ((Long) f.b(this.dbu, "mTimestampNanos", Long.valueOf(j2))).longValue();
        } catch (Exception e2) {
            com.tencent.matrix.g.c.e("Matrix.UIThreadMonitor", e2.toString(), new Object[0]);
            return j2;
        }
    }

    public final long u(int i2, long j2) {
        if (j2 != this.dbl) {
            return -1;
        }
        if (this.dbv[i2] == 2) {
            return this.dbx[i2];
        }
        return 0;
    }

    static /* synthetic */ void c(b bVar) {
        long j2;
        long nanoTime = bVar.daS.daO ? System.nanoTime() : 0;
        long j3 = bVar.dbl;
        if (bVar.dbn) {
            long j4 = bVar.dbl;
            bVar.iw(2);
            int[] iArr = bVar.dbv;
            for (int i2 : iArr) {
                if (i2 != 2) {
                    bVar.dbx[i2] = -100;
                    if (bVar.daS.daO) {
                        throw new RuntimeException(String.format("UIThreadMonitor happens type[%s] != DO_QUEUE_END", Integer.valueOf(i2)));
                    }
                }
            }
            bVar.dbv = new int[3];
            bVar.b(0, bVar);
            j2 = bVar.bh(j3);
        } else {
            j2 = j3;
        }
        long nanoTime2 = System.nanoTime();
        synchronized (bVar.dbk) {
            Iterator<c> it = bVar.dbk.iterator();
            while (it.hasNext()) {
                c next = it.next();
                if (next.dbX) {
                    next.a(AppMethodBeat.getVisibleScene(), j3, nanoTime2, bVar.dbn, j2, bVar.dbx[0], bVar.dbx[1], bVar.dbx[2]);
                }
            }
        }
        bVar.dbj[3] = SystemClock.currentThreadTimeMillis();
        bVar.dbj[1] = System.nanoTime();
        AppMethodBeat.o(AppMethodBeat.METHOD_ID_DISPATCH);
        synchronized (bVar.dbk) {
            Iterator<c> it2 = bVar.dbk.iterator();
            while (it2.hasNext()) {
                c next2 = it2.next();
                if (next2.dbX) {
                    next2.a(bVar.dbj[0], bVar.dbj[2], bVar.dbj[1], bVar.dbj[3], bVar.dbl, bVar.dbn);
                }
            }
        }
        bVar.dbn = false;
        if (bVar.daS.daO) {
            com.tencent.matrix.g.c.d("Matrix.UIThreadMonitor", "[dispatchEnd#run] inner cost:%sns", Long.valueOf(System.nanoTime() - nanoTime));
        }
    }
}
