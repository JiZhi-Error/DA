package com.tencent.mm.plugin.appbrand.ad.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class b extends IEvent {
    public a kHp;

    public static final class a {
        public String appId;
    }

    public b() {
        this((byte) 0);
    }

    private b(byte b2) {
        AppMethodBeat.i(160567);
        this.kHp = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(160567);
    }
}
