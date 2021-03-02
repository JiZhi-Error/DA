package com.tencent.mm.rabbiteye;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.rabbiteye.detective.AnrDetective;
import com.tencent.mm.rabbiteye.detective.LagDetective;

public final class a {
    private static b NAM;

    /* renamed from: com.tencent.mm.rabbiteye.a$a  reason: collision with other inner class name */
    public static class C2040a {

        /* renamed from: a  reason: collision with root package name */
        public boolean f1529a = false;

        /* renamed from: b  reason: collision with root package name */
        public boolean f1530b = false;

        /* renamed from: c  reason: collision with root package name */
        public String f1531c = "";

        /* renamed from: d  reason: collision with root package name */
        public boolean f1532d = false;

        /* renamed from: e  reason: collision with root package name */
        public boolean f1533e = false;

        /* renamed from: f  reason: collision with root package name */
        public boolean f1534f = false;

        /* renamed from: g  reason: collision with root package name */
        public boolean f1535g = false;

        /* renamed from: h  reason: collision with root package name */
        public long f1536h = 2000;

        /* renamed from: i  reason: collision with root package name */
        public long f1537i = 2000;

        /* renamed from: j  reason: collision with root package name */
        public long f1538j = 2000;

        public C2040a() {
            AppMethodBeat.i(186286);
            AppMethodBeat.o(186286);
        }
    }

    public interface b {
        void a(String str, long j2, String str2, boolean z, String str3);

        void gf(String str);
    }

    static {
        AppMethodBeat.i(186288);
        System.loadLibrary("rabbiteye");
        AppMethodBeat.o(186288);
    }

    public static void a(b bVar) {
        NAM = bVar;
    }

    public static void a(C2040a aVar) {
        AppMethodBeat.i(186287);
        if (aVar.f1529a) {
            AnrDetective.a(NAM, aVar);
            AnrDetective.a();
            AnrDetective.nativeInitAnr(AnrDetective.NAP.f1531c);
        }
        if (aVar.f1532d) {
            LagDetective.b(NAM, aVar).start();
        }
        AppMethodBeat.o(186287);
    }
}
