package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class yg extends IEvent {
    public a eeB;

    public static final class a {
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

    public yg() {
        this((byte) 0);
    }

    private yg(byte b2) {
        AppMethodBeat.i(140991);
        this.eeB = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(140991);
    }
}
