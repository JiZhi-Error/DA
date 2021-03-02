package com.tencent.f.j;

import android.os.Looper;
import com.tencent.f.j.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public final class a {
    private static final ThreadLocal<a> RUP = new ThreadLocal<>();
    private static a RUQ = null;
    private static final AtomicLong RUR = new AtomicLong(0);
    private static final ConcurrentHashMap<String, a> cCB = new ConcurrentHashMap<>();
    public final d RUS;
    private int RUT = 0;
    public final String tag;

    static {
        AppMethodBeat.i(183407);
        AppMethodBeat.o(183407);
    }

    private a(String str) {
        AppMethodBeat.i(183392);
        this.tag = str;
        this.RUS = new d(new b(new b.a() {
            /* class com.tencent.f.j.a.AnonymousClass1 */
        }));
        cCB.put(this.tag, this);
        AppMethodBeat.o(183392);
    }

    public static a bqt(String str) {
        AppMethodBeat.i(183393);
        a aVar = new a(str + "@" + RUR.getAndIncrement());
        AppMethodBeat.o(183393);
        return aVar;
    }

    static void a(a aVar) {
        AppMethodBeat.i(183394);
        RUP.set(aVar);
        AppMethodBeat.o(183394);
    }

    public static String j(Looper looper) {
        AppMethodBeat.i(183395);
        if (looper == null) {
            AppMethodBeat.o(183395);
            return null;
        }
        Thread thread = looper.getThread();
        String str = thread.getName() + "@" + thread.getId();
        AppMethodBeat.o(183395);
        return str;
    }

    public static a hmD() {
        AppMethodBeat.i(183396);
        if (RUQ == null) {
            String j2 = j(Looper.getMainLooper());
            a aVar = cCB.get(j2);
            if (aVar == null) {
                aVar = new a(j2);
            }
            RUQ = aVar;
        }
        a aVar2 = RUQ;
        AppMethodBeat.o(183396);
        return aVar2;
    }

    public static a hmE() {
        AppMethodBeat.i(183397);
        if (Looper.getMainLooper() == Looper.myLooper()) {
            a hmD = hmD();
            AppMethodBeat.o(183397);
            return hmD;
        }
        a aVar = RUP.get();
        AppMethodBeat.o(183397);
        return aVar;
    }

    public static String hmF() {
        AppMethodBeat.i(183398);
        if (Looper.getMainLooper() == Looper.myLooper()) {
            String str = hmD().tag;
            AppMethodBeat.o(183398);
            return str;
        }
        a aVar = RUP.get();
        if (aVar == null) {
            AppMethodBeat.o(183398);
            return null;
        }
        String str2 = aVar.tag;
        AppMethodBeat.o(183398);
        return str2;
    }

    public final d hmG() {
        return this.RUS;
    }

    public static a bqu(String str) {
        AppMethodBeat.i(183400);
        a aVar = cCB.get(str);
        AppMethodBeat.o(183400);
        return aVar;
    }

    static synchronized a bqv(String str) {
        a aVar;
        synchronized (a.class) {
            AppMethodBeat.i(183401);
            aVar = cCB.get(str);
            if (aVar == null) {
                aVar = new a(str);
            }
            AppMethodBeat.o(183401);
        }
        return aVar;
    }

    public static Collection<a> hmH() {
        AppMethodBeat.i(183402);
        Collection<a> values = cCB.values();
        AppMethodBeat.o(183402);
        return values;
    }

    public final String toString() {
        AppMethodBeat.i(183404);
        String str = "[" + this.tag + "]";
        AppMethodBeat.o(183404);
        return str;
    }

    public final int hashCode() {
        AppMethodBeat.i(183405);
        int hashCode = this.tag.hashCode();
        AppMethodBeat.o(183405);
        return hashCode;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(183406);
        if (obj instanceof a) {
            boolean equals = ((a) obj).tag.equals(this.tag);
            AppMethodBeat.o(183406);
            return equals;
        }
        AppMethodBeat.o(183406);
        return false;
    }

    public final void quit() {
        AppMethodBeat.i(183399);
        this.RUS.quit();
        AppMethodBeat.o(183399);
    }

    public static void release() {
        AppMethodBeat.i(183403);
        for (a aVar : cCB.values()) {
            aVar.RUS.quit();
        }
        cCB.clear();
        AppMethodBeat.o(183403);
    }
}
