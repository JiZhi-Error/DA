package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.model.e;
import com.tencent.mm.protocal.protobuf.cly;
import com.tencent.mm.sdk.event.IEvent;

public final class wb extends IEvent {
    public a eci;
    public b ecj;

    public static final class a {
        public String ebP;
        public cly eck;
        public Runnable ecl;
        public e ecm;
        public int scene;
    }

    public static final class b {
        public int result;
    }

    public wb() {
        this((byte) 0);
    }

    private wb(byte b2) {
        AppMethodBeat.i(148772);
        this.eci = new a();
        this.ecj = new b();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(148772);
    }
}
