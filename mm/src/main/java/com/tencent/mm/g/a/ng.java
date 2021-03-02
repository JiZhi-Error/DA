package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.chi;
import com.tencent.mm.sdk.event.IEvent;
import java.util.List;

public final class ng extends IEvent {
    public a dTh;
    public b dTi;

    public static final class a {
        public int dJY = 0;
        public boolean dSQ = false;
        public float dTj = 0.0f;
        public int dTk = 0;
        public int dTl = 0;
        public String dTm;
        public String dTn;
        public float latitude = 0.0f;
    }

    public static final class b {
        public int dJY = 0;
        public boolean dTo = false;
        public List<chi> dTp;
        public int dTq = -1;
    }

    public ng() {
        this((byte) 0);
    }

    private ng(byte b2) {
        AppMethodBeat.i(89749);
        this.dTh = new a();
        this.dTi = new b();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(89749);
    }
}
