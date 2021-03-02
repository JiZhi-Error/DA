package com.tencent.mm.plugin.appbrand.page;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.a.b;
import com.tencent.mm.plugin.appbrand.jsapi.s;

public final class p extends s {
    private static final int CTRL_INDEX = -2;
    private static final String NAME = "onAppRunningStatusChange";

    /* renamed from: com.tencent.mm.plugin.appbrand.page.p$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] kRf = new int[b.values().length];

        static {
            AppMethodBeat.i(135001);
            try {
                kRf[b.BACKGROUND.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                kRf[b.kQH.ordinal()] = 2;
            } catch (NoSuchFieldError e3) {
            }
            try {
                kRf[b.SUSPEND.ordinal()] = 3;
            } catch (NoSuchFieldError e4) {
            }
            try {
                kRf[b.DESTROYED.ordinal()] = 4;
                AppMethodBeat.o(135001);
            } catch (NoSuchFieldError e5) {
                AppMethodBeat.o(135001);
            }
        }
    }
}
