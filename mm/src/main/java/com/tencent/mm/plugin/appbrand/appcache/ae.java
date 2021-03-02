package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.j.a.c.m;
import java.util.HashSet;
import java.util.Set;

public final class ae {
    private static final Set<b> kLQ = new HashSet();

    public interface a {
        void a(m mVar);

        void bvj();

        void bvk();

        void bvl();

        void bvm();

        void bvn();

        void bvo();

        void bvp();

        void gE(boolean z);

        void gF(boolean z);

        void vQ(int i2);
    }

    public interface b {
        a b(com.tencent.mm.plugin.appbrand.appcache.a.a aVar);
    }

    static {
        AppMethodBeat.i(90557);
        AppMethodBeat.o(90557);
    }

    public static void a(b bVar) {
        AppMethodBeat.i(90555);
        synchronized (kLQ) {
            try {
                kLQ.add(bVar);
            } finally {
                AppMethodBeat.o(90555);
            }
        }
    }

    static a b(com.tencent.mm.plugin.appbrand.appcache.a.a aVar) {
        Object[] array;
        AppMethodBeat.i(90556);
        synchronized (kLQ) {
            try {
                array = kLQ.toArray();
            } finally {
                AppMethodBeat.o(90556);
            }
        }
        for (Object obj : array) {
            a b2 = ((b) obj).b(aVar);
            if (b2 != null) {
                return b2;
            }
        }
        AppMethodBeat.o(90556);
        return null;
    }
}
