package com.tencent.mm.plugin.location.ui.impl;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;

public final class g {
    private int enterScene;
    private int gmJ;
    private int jVX;
    int yNa;

    /* synthetic */ g(byte b2) {
        this();
    }

    private g() {
        AppMethodBeat.i(56107);
        this.jVX = b.DIRECT.ordinal();
        AppMethodBeat.o(56107);
    }

    static class c {
        static g yNm = new g((byte) 0);

        static {
            AppMethodBeat.i(56106);
            AppMethodBeat.o(56106);
        }
    }

    public final void setScene(int i2) {
        switch (i2) {
            case -1:
                this.enterScene = 3;
                return;
            case 0:
            default:
                this.enterScene = 0;
                return;
            case 1:
            case 2:
            case 4:
                this.enterScene = i2;
                return;
            case 3:
                this.enterScene = 5;
                return;
        }
    }

    public enum b {
        UNKNOWN,
        SEARCH_LIST,
        SEARCH_MAP,
        DRAG_MAP,
        LIST,
        DIRECT;

        public static b valueOf(String str) {
            AppMethodBeat.i(56104);
            b bVar = (b) Enum.valueOf(b.class, str);
            AppMethodBeat.o(56104);
            return bVar;
        }

        static {
            AppMethodBeat.i(56105);
            AppMethodBeat.o(56105);
        }
    }

    public final void a(b bVar) {
        AppMethodBeat.i(56108);
        this.jVX = bVar.ordinal();
        AppMethodBeat.o(56108);
    }

    public enum a {
        UNKNOWN,
        SUCC,
        QUIT;

        public static a valueOf(String str) {
            AppMethodBeat.i(56101);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(56101);
            return aVar;
        }

        static {
            AppMethodBeat.i(56102);
            AppMethodBeat.o(56102);
        }
    }

    public final void a(a aVar) {
        AppMethodBeat.i(56109);
        this.gmJ = aVar.ordinal();
        report();
        AppMethodBeat.o(56109);
    }

    private void reset() {
        AppMethodBeat.i(56110);
        this.enterScene = 0;
        this.jVX = b.DIRECT.ordinal();
        this.yNa = 0;
        this.gmJ = 0;
        AppMethodBeat.o(56110);
    }

    private void report() {
        AppMethodBeat.i(56111);
        h.INSTANCE.a(17993, Integer.valueOf(this.gmJ), Integer.valueOf(this.enterScene), Integer.valueOf(this.jVX), Integer.valueOf(this.yNa));
        reset();
        AppMethodBeat.o(56111);
    }
}
