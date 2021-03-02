package com.tencent.mm.compatible.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public enum a {
    INSTANCE;
    
    private static volatile AbstractC0300a gDw = new AbstractC0300a() {
        /* class com.tencent.mm.compatible.d.a.AnonymousClass1 */

        @Override // com.tencent.mm.compatible.d.a.AbstractC0300a
        public final void w(long j2, long j3) {
            AppMethodBeat.i(155626);
            Log.w("MicroMsg.ReportDelegate", "hy: dummy reportIDKey, do nothing");
            AppMethodBeat.o(155626);
        }

        @Override // com.tencent.mm.compatible.d.a.AbstractC0300a
        public final void c(int i2, Object... objArr) {
            AppMethodBeat.i(215247);
            Log.w("MicroMsg.ReportDelegate", "hy: dummy reportKV, do nothing");
            AppMethodBeat.o(215247);
        }
    };

    /* renamed from: com.tencent.mm.compatible.d.a$a  reason: collision with other inner class name */
    public interface AbstractC0300a {
        void c(int i2, Object... objArr);

        void w(long j2, long j3);
    }

    public static a valueOf(String str) {
        AppMethodBeat.i(155628);
        a aVar = (a) Enum.valueOf(a.class, str);
        AppMethodBeat.o(155628);
        return aVar;
    }

    static {
        AppMethodBeat.i(155631);
        AppMethodBeat.o(155631);
    }

    public static synchronized void a(AbstractC0300a aVar) {
        synchronized (a.class) {
            gDw = aVar;
        }
    }

    public static void yT(long j2) {
        AppMethodBeat.i(155629);
        gDw.w(853, j2);
        AppMethodBeat.o(155629);
    }

    public static void v(long j2, long j3) {
        AppMethodBeat.i(215248);
        gDw.w(j2, j3);
        AppMethodBeat.o(215248);
    }

    public static void b(int i2, Object... objArr) {
        AppMethodBeat.i(215249);
        gDw.c(i2, objArr);
        AppMethodBeat.o(215249);
    }
}
