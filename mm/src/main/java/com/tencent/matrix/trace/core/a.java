package com.tencent.matrix.trace.core;

import android.os.Build;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.SystemClock;
import android.util.Printer;
import com.tencent.matrix.g.c;
import com.tencent.matrix.g.f;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;

public final class a implements MessageQueue.IdleHandler {
    private static final a dbc = new a();
    private static boolean dbd = false;
    private b dba;
    private long dbb;
    public final HashSet<AbstractC0235a> listeners;
    private Looper looper;

    /* renamed from: com.tencent.matrix.trace.core.a$a  reason: collision with other inner class name */
    public static abstract class AbstractC0235a {
        boolean dbe = false;

        public boolean isValid() {
            return false;
        }

        public void dispatchStart() {
        }

        public void er(String str) {
            this.dbe = true;
            dispatchStart();
        }

        public void dispatchEnd() {
        }
    }

    public static void a(AbstractC0235a aVar) {
        a aVar2 = dbc;
        synchronized (aVar2.listeners) {
            aVar2.listeners.add(aVar);
        }
    }

    static void b(AbstractC0235a aVar) {
        a aVar2 = dbc;
        synchronized (aVar2.listeners) {
            aVar2.listeners.remove(aVar);
        }
    }

    public a(Looper looper2) {
        this.listeners = new HashSet<>();
        this.dbb = 0;
        Objects.requireNonNull(looper2);
        this.looper = looper2;
        Tv();
        c(looper2);
    }

    private a() {
        this(Looper.getMainLooper());
    }

    public final boolean queueIdle() {
        if (SystemClock.uptimeMillis() - this.dbb < Util.MILLSECONDS_OF_MINUTE) {
            return true;
        }
        Tv();
        this.dbb = SystemClock.uptimeMillis();
        return true;
    }

    public final synchronized void onRelease() {
        if (this.dba != null) {
            synchronized (this.listeners) {
                this.listeners.clear();
            }
            c.v("Matrix.LooperMonitor", "[onRelease] %s, origin printer:%s", this.looper.getThread().getName(), this.dba.dbf);
            this.looper.setMessageLogging(this.dba.dbf);
            b(this.looper);
            this.looper = null;
            this.dba = null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001d, code lost:
        if (r6.dba != null) goto L_0x001f;
     */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x002a  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0059  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void Tv() {
        /*
        // Method dump skipped, instructions count: 126
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.matrix.trace.core.a.Tv():void");
    }

    private synchronized void b(Looper looper2) {
        if (Build.VERSION.SDK_INT >= 23) {
            looper2.getQueue().removeIdleHandler(this);
        } else {
            try {
                ((MessageQueue) f.a(looper2.getClass(), "mQueue", looper2)).removeIdleHandler(this);
            } catch (Exception e2) {
            }
        }
    }

    private synchronized void c(Looper looper2) {
        if (Build.VERSION.SDK_INT >= 23) {
            looper2.getQueue().addIdleHandler(this);
        } else {
            try {
                ((MessageQueue) f.a(looper2.getClass(), "mQueue", looper2)).addIdleHandler(this);
            } catch (Exception e2) {
            }
        }
    }

    /* access modifiers changed from: package-private */
    public class b implements Printer {
        boolean daZ = false;
        public Printer dbf;
        boolean dbg = false;

        b(Printer printer) {
            this.dbf = printer;
        }

        public final void println(String str) {
            boolean z = true;
            if (this.dbf != null) {
                this.dbf.println(str);
                if (this.dbf == this) {
                    throw new RuntimeException("Matrix.LooperMonitor origin == this");
                }
            }
            if (!this.dbg) {
                this.daZ = str.charAt(0) == '>' || str.charAt(0) == '<';
                this.dbg = true;
                if (!this.daZ) {
                    c.e("Matrix.LooperMonitor", "[println] Printer is inValid! x:%s", str);
                }
            }
            if (this.daZ) {
                a aVar = a.this;
                if (str.charAt(0) != '>') {
                    z = false;
                }
                a.a(aVar, z, str);
            }
        }
    }

    static /* synthetic */ void a(a aVar, boolean z, String str) {
        Iterator<AbstractC0235a> it = aVar.listeners.iterator();
        while (it.hasNext()) {
            AbstractC0235a next = it.next();
            if (next.isValid()) {
                if (z) {
                    if (!next.dbe) {
                        next.er(str);
                    }
                } else if (next.dbe) {
                    next.dbe = false;
                    next.dispatchEnd();
                }
            } else if (!z && next.dbe) {
                next.dispatchEnd();
            }
        }
    }
}
