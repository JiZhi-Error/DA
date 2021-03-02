package com.tencent.mm.vending.h;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import junit.framework.Assert;

public class g {
    private static Map<String, d> RaH = new ConcurrentHashMap();
    private static Map<Thread, d> RaI = new HashMap();
    private static boolean RaJ = false;
    private static ThreadLocal<d> RaK = new ThreadLocal<>();
    private static a RaL = null;

    public interface a {
        d hdJ();
    }

    static {
        AppMethodBeat.i(74933);
        hdI();
        AppMethodBeat.o(74933);
    }

    public static void a(String str, d dVar) {
        AppMethodBeat.i(74928);
        Assert.assertNotNull("Scheduler type is null", str);
        String upperCase = str.toUpperCase(Locale.ENGLISH);
        if (RaH.containsKey(upperCase)) {
            new IllegalStateException("Fatal error! Duplicate scheduler type " + str.toUpperCase(Locale.ENGLISH));
        }
        RaH.put(upperCase, dVar);
        if (dVar instanceof h) {
            synchronized (g.class) {
                try {
                    RaI.put(((h) dVar).mLooper.getThread(), dVar);
                } finally {
                    AppMethodBeat.o(74928);
                }
            }
        } else if (dVar instanceof i) {
            synchronized (g.class) {
                try {
                    RaI.put(((i) dVar).mThread, dVar);
                } finally {
                    AppMethodBeat.o(74928);
                }
            }
        } else {
            AppMethodBeat.o(74928);
        }
    }

    public static void boG(String str) {
        AppMethodBeat.i(74929);
        RaH.remove(str.toUpperCase(Locale.ENGLISH));
        AppMethodBeat.o(74929);
    }

    public static d boH(String str) {
        AppMethodBeat.i(74930);
        Assert.assertNotNull("Scheduler type is null", str);
        d dVar = RaH.get(str.toUpperCase(Locale.ENGLISH));
        Assert.assertNotNull("Scheduler type not found: " + str.toUpperCase(Locale.ENGLISH), dVar);
        AppMethodBeat.o(74930);
        return dVar;
    }

    public static d current() {
        d remove;
        d dVar;
        AppMethodBeat.i(74931);
        d dVar2 = RaK.get();
        if (dVar2 == null || RaI.size() != 0) {
            synchronized (g.class) {
                try {
                    remove = RaI.remove(Thread.currentThread());
                } catch (Throwable th) {
                    AppMethodBeat.o(74931);
                    throw th;
                }
            }
            if (dVar2 != null && remove == null) {
                AppMethodBeat.o(74931);
                return dVar2;
            } else if (remove != null) {
                RaK.set(remove);
                AppMethodBeat.o(74931);
                return remove;
            } else {
                if (Looper.myLooper() != null) {
                    dVar = new h(Looper.myLooper(), Looper.myLooper().toString());
                } else {
                    a aVar = RaL;
                    if (aVar != null) {
                        Thread.currentThread();
                        dVar = aVar.hdJ();
                        com.tencent.mm.vending.f.a.i("Vending.SchedulerProvider", "This is not a handler thread(%s). So we get a instance(%s) from thread factory.", Thread.currentThread(), dVar);
                    } else {
                        dVar = remove;
                    }
                    if (dVar == null) {
                        com.tencent.mm.vending.f.a.w("Vending.SchedulerProvider", "This is not a handler thread! %s", Thread.currentThread());
                        c cVar = new c();
                        AppMethodBeat.o(74931);
                        return cVar;
                    }
                }
                RaK.set(dVar);
                AppMethodBeat.o(74931);
                return dVar;
            }
        } else {
            AppMethodBeat.o(74931);
            return dVar2;
        }
    }

    static synchronized void hdI() {
        synchronized (g.class) {
            AppMethodBeat.i(177494);
            if (RaJ) {
                AppMethodBeat.o(177494);
            } else {
                com.tencent.mm.vending.f.a.i("Vending.SchedulerProvider", "SchedulerProvider provided.", new Object[0]);
                RaJ = true;
                a("Vending.UI", d.UI);
                a("Vending.LOGIC", d.LOGIC);
                a("Vending.HEAVY_WORK", d.HEAVY_WORK);
                AppMethodBeat.o(177494);
            }
        }
    }
}
