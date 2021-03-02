package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class lj extends IEvent {
    public a dQz;

    public static final class a {
        public boolean dQA = false;
        public boolean dQB = false;
        public String dQC;
        public String dQD;
        public String dQE;
        public String dQF;
        public String dQG;
        public String dQH;
        public String dQl;
        public String dQm;
    }

    public lj() {
        this((byte) 0);
    }

    private lj(byte b2) {
        AppMethodBeat.i(128844);
        this.dQz = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(128844);
    }
}
