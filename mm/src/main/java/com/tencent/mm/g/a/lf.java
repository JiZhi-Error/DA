package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.report.model.kv_14609;
import com.tencent.mm.sdk.event.IEvent;

public final class lf extends IEvent {
    public a dQt;

    public static final class a {
        public kv_14609 dQu;
        public kv_14609.a dQv;
    }

    public lf() {
        this((byte) 0);
    }

    private lf(byte b2) {
        AppMethodBeat.i(43441);
        this.dQt = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(43441);
    }
}
