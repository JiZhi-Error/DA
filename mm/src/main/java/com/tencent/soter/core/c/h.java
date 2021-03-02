package com.tencent.soter.core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import junit.framework.Assert;

public final class h {
    private static volatile a RPM = new a() {
        /* class com.tencent.soter.core.c.h.AnonymousClass1 */
        private boolean RPN = false;

        @Override // com.tencent.soter.core.c.h.a
        public final void hlv() {
            AppMethodBeat.i(88666);
            d.e("Soter.SoterDelegate", "soter: triggered OOM. using default imp, just record the flag", new Object[0]);
            this.RPN = true;
            AppMethodBeat.o(88666);
        }

        @Override // com.tencent.soter.core.c.h.a
        public final boolean hlu() {
            return this.RPN;
        }

        @Override // com.tencent.soter.core.c.h.a
        public final void reset() {
            this.RPN = false;
        }
    };

    public interface a {
        boolean hlu();

        void hlv();

        void reset();
    }

    static {
        AppMethodBeat.i(88671);
        AppMethodBeat.o(88671);
    }

    public static void a(a aVar) {
        AppMethodBeat.i(88667);
        Assert.assertNotNull(aVar);
        RPM = aVar;
        AppMethodBeat.o(88667);
    }

    public static void hlt() {
        AppMethodBeat.i(88668);
        RPM.hlv();
        AppMethodBeat.o(88668);
    }

    public static boolean hlu() {
        AppMethodBeat.i(88669);
        boolean hlu = RPM.hlu();
        AppMethodBeat.o(88669);
        return hlu;
    }

    public static void reset() {
        AppMethodBeat.i(88670);
        RPM.reset();
        AppMethodBeat.o(88670);
    }
}
