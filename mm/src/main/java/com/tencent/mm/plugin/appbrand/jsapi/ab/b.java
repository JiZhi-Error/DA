package com.tencent.mm.plugin.appbrand.jsapi.ab;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.s;

public enum b {
    UPDATING("updating"),
    NO_UPDATE("noUpdate"),
    UPDATE_READY("updateReady"),
    UPDATE_FAILED("updateFailed");
    
    public final String mvx;

    public static b valueOf(String str) {
        AppMethodBeat.i(147305);
        b bVar = (b) Enum.valueOf(b.class, str);
        AppMethodBeat.o(147305);
        return bVar;
    }

    static {
        AppMethodBeat.i(147307);
        AppMethodBeat.o(147307);
    }

    private b(String str) {
        this.mvx = str;
    }

    public static b aaQ(String str) {
        AppMethodBeat.i(147306);
        b[] values = values();
        for (b bVar : values) {
            if (bVar.mvx.equals(str)) {
                AppMethodBeat.o(147306);
                return bVar;
            }
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(String.format("Invalid name %s", str));
        AppMethodBeat.o(147306);
        throw illegalArgumentException;
    }

    public final String toString() {
        return this.mvx;
    }

    public static final class a extends s {
        private static final int CTRL_INDEX = -2;
        private static final String NAME = "onUpdateStatusChange";

        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }
}
