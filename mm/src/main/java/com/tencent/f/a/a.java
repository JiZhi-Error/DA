package com.tencent.f.a;

import com.tencent.f.i.j;
import com.tencent.f.i.k;
import com.tencent.f.j.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public final class a {
    public static k<?> d(Runnable runnable, long j2, String str) {
        AppMethodBeat.i(183189);
        if (str == null || str.isEmpty()) {
            k<?> kVar = new k<>(runnable, a(j2, TimeUnit.MILLISECONDS), eC(runnable));
            AppMethodBeat.o(183189);
            return kVar;
        }
        e eVar = new e(runnable, a(j2, TimeUnit.MILLISECONDS), str, eC(runnable));
        AppMethodBeat.o(183189);
        return eVar;
    }

    public static <E> k<E> a(Callable<E> callable, long j2, String str) {
        AppMethodBeat.i(183190);
        if (str == null || str.isEmpty()) {
            k<E> kVar = new k<>(callable, a(j2, TimeUnit.MILLISECONDS), eC(callable));
            AppMethodBeat.o(183190);
            return kVar;
        }
        e eVar = new e(callable, a(j2, TimeUnit.MILLISECONDS), str, eC(callable));
        AppMethodBeat.o(183190);
        return eVar;
    }

    public static long a(long j2, TimeUnit timeUnit) {
        AppMethodBeat.i(183191);
        if (timeUnit == null) {
            long nanoTime = System.nanoTime();
            AppMethodBeat.o(183191);
            return nanoTime;
        }
        if (j2 < 0) {
            j2 = 0;
        }
        long OD = OD(timeUnit.toNanos(j2));
        AppMethodBeat.o(183191);
        return OD;
    }

    private static long OD(long j2) {
        AppMethodBeat.i(183192);
        long nanoTime = System.nanoTime();
        if (j2 >= 4611686018427387903L) {
            j2 = 4611686018427387903L;
        }
        long j3 = nanoTime + j2;
        AppMethodBeat.o(183192);
        return j3;
    }

    public static boolean eC(Object obj) {
        AppMethodBeat.i(183193);
        if (obj instanceof j) {
            boolean axI = ((j) obj).axI();
            AppMethodBeat.o(183193);
            return axI;
        }
        AppMethodBeat.o(183193);
        return true;
    }
}
