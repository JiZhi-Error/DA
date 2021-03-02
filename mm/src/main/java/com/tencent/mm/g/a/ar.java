package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ar extends IEvent {
    public a dDD;
    public b dDE;

    public static final class a {
        public String event;
        public int position = 0;
        public int type;
    }

    public static final class b {
        public String Title;
        public int dDF = 0;
        public int dDG = 0;
        public int dDH = 0;
        public int dDI = 0;
        public String dDJ;
        public String desc;
        public int position = 0;
        public String url;
        public boolean visible = false;
    }

    public ar() {
        this((byte) 0);
    }

    private ar(byte b2) {
        AppMethodBeat.i(155543);
        this.dDD = new a();
        this.dDE = new b();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(155543);
    }
}
