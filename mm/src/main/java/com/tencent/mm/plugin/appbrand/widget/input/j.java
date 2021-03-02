package com.tencent.mm.plugin.appbrand.widget.input;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.input.af;

public final class j {
    /* synthetic */ j(byte b2) {
        this();
    }

    public static final class a {
        private static final j osP = new j((byte) 0);

        static {
            AppMethodBeat.i(136385);
            AppMethodBeat.o(136385);
        }
    }

    private j() {
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.input.j$5 */
    static /* synthetic */ class AnonymousClass5 {
        static final /* synthetic */ int[] osO = new int[af.a.values().length];

        static {
            AppMethodBeat.i(136384);
            try {
                osO[af.a.COMPLETE.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                osO[af.a.CONFIRM.ordinal()] = 2;
                AppMethodBeat.o(136384);
            } catch (NoSuchFieldError e3) {
                AppMethodBeat.o(136384);
            }
        }
    }
}
