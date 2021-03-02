package com.tencent.mm.plugin.expt.hellhound.core.stack;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b {

    /* access modifiers changed from: package-private */
    /* renamed from: com.tencent.mm.plugin.expt.hellhound.core.stack.b$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] szy = new int[a.values().length];

        static {
            AppMethodBeat.i(121878);
            try {
                szy[a.CREATE.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                szy[a.RESUME.ordinal()] = 2;
            } catch (NoSuchFieldError e3) {
            }
            try {
                szy[a.PAUSE.ordinal()] = 3;
            } catch (NoSuchFieldError e4) {
            }
            try {
                szy[a.STOP.ordinal()] = 4;
                AppMethodBeat.o(121878);
            } catch (NoSuchFieldError e5) {
                AppMethodBeat.o(121878);
            }
        }
    }
}
