package com.tencent.mm.plugin.appbrand.jsapi.ag.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class a extends IEvent {
    public C0605a mJH;

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.ag.c.a$a  reason: collision with other inner class name */
    public static final class C0605a {
        public String appId;
        public int beL;
        public int dDe;
    }

    public a() {
        this((byte) 0);
    }

    private a(byte b2) {
        AppMethodBeat.i(215838);
        this.mJH = new C0605a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(215838);
    }
}
