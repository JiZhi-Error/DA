package com.tencent.mm.rabbiteye.detective;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.MessageQueue;
import android.util.Printer;
import androidx.annotation.Keep;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.rabbiteye.a;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LagDetective extends a {
    private static volatile LagDetective NAQ = new LagDetective();
    private static Handler NAR = null;
    private static Runnable NAS = new b();
    private static Runnable NAT = new a();
    private static a.b NAU;
    private static a.C2040a NAV;

    /* renamed from: b  reason: collision with root package name */
    private static long f1542b = 5000;

    /* renamed from: c  reason: collision with root package name */
    private static HandlerThread f1543c = new HandlerThread("LooperLagThread");

    /* renamed from: d  reason: collision with root package name */
    private static HandlerThread f1544d = new HandlerThread("IdleHandlerLagThread");

    /* renamed from: e  reason: collision with root package name */
    private static Handler f1545e = null;

    /* renamed from: i  reason: collision with root package name */
    private static boolean f1546i = false;
    private static long l = 0;
    private static boolean m;

    static class a implements Runnable {
        a() {
        }

        public final void run() {
            AppMethodBeat.i(186291);
            LagDetective.NAU.a("IdleHandler", 0, com.tencent.mm.rabbiteye.a.b.gut(), com.tencent.mm.rabbiteye.a.a.gus(), com.tencent.mm.rabbiteye.a.a.RF());
            AppMethodBeat.o(186291);
        }
    }

    static class b implements Runnable {
        b() {
        }

        public final void run() {
            AppMethodBeat.i(186292);
            LagDetective.NAU.a("Looper", 0, "", com.tencent.mm.rabbiteye.a.a.gus(), com.tencent.mm.rabbiteye.a.a.RF());
            AppMethodBeat.o(186292);
        }
    }

    /* access modifiers changed from: package-private */
    public static class c implements Printer {
        public Printer NAW;

        /* renamed from: b  reason: collision with root package name */
        boolean f1547b = false;

        /* renamed from: c  reason: collision with root package name */
        boolean f1548c = false;

        c(Printer printer) {
            AppMethodBeat.i(186293);
            this.NAW = printer;
            AppMethodBeat.o(186293);
        }

        public final void println(String str) {
            boolean z;
            boolean z2 = true;
            AppMethodBeat.i(186294);
            Printer printer = this.NAW;
            if (printer != null) {
                printer.println(str);
            }
            if (!this.f1547b) {
                if (str.charAt(0) == '>' || str.charAt(0) == '<') {
                    z = true;
                } else {
                    z = false;
                }
                this.f1548c = z;
                this.f1547b = true;
            }
            if (this.f1548c) {
                if (str.charAt(0) != '>') {
                    z2 = false;
                }
                LagDetective.a(z2);
            }
            AppMethodBeat.o(186294);
        }
    }

    /* access modifiers changed from: package-private */
    public static class d<T> extends ArrayList {

        /* renamed from: a  reason: collision with root package name */
        Map<MessageQueue.IdleHandler, e> f1549a = new HashMap();

        d() {
            AppMethodBeat.i(186295);
            AppMethodBeat.o(186295);
        }

        @Override // java.util.AbstractCollection, java.util.List, java.util.Collection, java.util.AbstractList, java.util.ArrayList
        public final boolean add(Object obj) {
            AppMethodBeat.i(186296);
            if (obj instanceof MessageQueue.IdleHandler) {
                MessageQueue.IdleHandler idleHandler = (MessageQueue.IdleHandler) obj;
                e eVar = new e(idleHandler);
                this.f1549a.put(idleHandler, eVar);
                boolean add = super.add(eVar);
                AppMethodBeat.o(186296);
                return add;
            }
            boolean add2 = super.add(obj);
            AppMethodBeat.o(186296);
            return add2;
        }

        @Override // java.util.List, java.util.ArrayList
        public final boolean remove(Object obj) {
            AppMethodBeat.i(186297);
            if (obj instanceof e) {
                this.f1549a.remove(((e) obj).NAX);
                boolean remove = super.remove(obj);
                AppMethodBeat.o(186297);
                return remove;
            }
            e remove2 = this.f1549a.remove(obj);
            if (remove2 != null) {
                boolean remove3 = super.remove(remove2);
                AppMethodBeat.o(186297);
                return remove3;
            }
            boolean remove4 = super.remove(obj);
            AppMethodBeat.o(186297);
            return remove4;
        }
    }

    static class e implements MessageQueue.IdleHandler {
        private MessageQueue.IdleHandler NAX;

        e(MessageQueue.IdleHandler idleHandler) {
            this.NAX = idleHandler;
        }

        public final boolean queueIdle() {
            AppMethodBeat.i(186298);
            LagDetective.NAR.postDelayed(LagDetective.NAT, LagDetective.NAV.f1538j);
            boolean queueIdle = this.NAX.queueIdle();
            LagDetective.NAR.removeCallbacks(LagDetective.NAT);
            AppMethodBeat.o(186298);
            return queueIdle;
        }
    }

    static {
        AppMethodBeat.i(186301);
        AppMethodBeat.o(186301);
    }

    public static synchronized LagDetective b(a.b bVar, a.C2040a aVar) {
        LagDetective lagDetective;
        synchronized (LagDetective.class) {
            NAU = bVar;
            NAV = aVar;
            f1542b = aVar.f1536h;
            lagDetective = NAQ;
        }
        return lagDetective;
    }

    private static native void nativeInitTouchDetective(int i2);

    public static native void nativeTestSleep();

    @Keep
    private static void onTouchDumped(int i2) {
        AppMethodBeat.i(186299);
        if (System.currentTimeMillis() - l > NAV.f1537i * 2) {
            NAU.a("Touch", (long) i2, com.tencent.mm.rabbiteye.a.b.gut(), com.tencent.mm.rabbiteye.a.a.gus(), com.tencent.mm.rabbiteye.a.a.RF());
        }
        l = System.currentTimeMillis();
        AppMethodBeat.o(186299);
    }

    public final synchronized void start() {
        AppMethodBeat.i(186302);
        if (m) {
            AppMethodBeat.o(186302);
        } else {
            m = true;
            if (NAV.f1534f) {
                nativeInitTouchDetective((int) NAV.f1537i);
            }
            if (NAV.f1535g) {
                try {
                    MessageQueue queue = Looper.getMainLooper().getQueue();
                    Field declaredField = MessageQueue.class.getDeclaredField("mIdleHandlers");
                    declaredField.setAccessible(true);
                    declaredField.set(queue, new d());
                    f1544d.start();
                    NAR = new Handler(f1544d.getLooper());
                } catch (Throwable th) {
                }
            }
            if (NAV.f1533e) {
                f1543c.start();
                f1545e = new Handler(f1543c.getLooper());
                Looper mainLooper = Looper.getMainLooper();
                try {
                    if (!f1546i) {
                        Field declaredField2 = mainLooper.getClass().getDeclaredField("mLogging");
                        declaredField2.setAccessible(true);
                        mainLooper.setMessageLogging(new c((Printer) declaredField2.get(mainLooper)));
                        AppMethodBeat.o(186302);
                    }
                } catch (Exception e2) {
                    f1546i = true;
                }
            }
            AppMethodBeat.o(186302);
        }
    }

    static /* synthetic */ void a(boolean z) {
        AppMethodBeat.i(186300);
        if (z) {
            f1545e.postDelayed(NAS, f1542b);
            AppMethodBeat.o(186300);
            return;
        }
        f1545e.removeCallbacks(NAS);
        AppMethodBeat.o(186300);
    }
}
