package com.tencent.mm.ui.chatting.l;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.chatting.h.d;

public final class b {
    public static final b PEW = new b();
    public int[] PEX = {0, 0, 0, 0, 0};

    public b() {
        AppMethodBeat.i(36605);
        AppMethodBeat.o(36605);
    }

    static {
        AppMethodBeat.i(36606);
        AppMethodBeat.o(36606);
    }

    /* renamed from: com.tencent.mm.ui.chatting.l.b$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] PEY = new int[d.a.values().length];

        static {
            AppMethodBeat.i(36604);
            try {
                PEY[d.a.ACTION_BOTTOM.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                PEY[d.a.ACTION_TOP.ordinal()] = 2;
            } catch (NoSuchFieldError e3) {
            }
            try {
                PEY[d.a.ACTION_UPDATE.ordinal()] = 3;
            } catch (NoSuchFieldError e4) {
            }
            try {
                PEY[d.a.ACTION_POSITION.ordinal()] = 4;
                AppMethodBeat.o(36604);
            } catch (NoSuchFieldError e5) {
                AppMethodBeat.o(36604);
            }
        }
    }
}
