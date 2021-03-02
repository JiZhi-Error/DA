package com.tencent.mm.plugin.appbrand.jsapi.video.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class a extends IEvent {
    public C0711a mAJ;

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.video.c.a$a  reason: collision with other inner class name */
    public static final class C0711a {
    }

    public a() {
        this((byte) 0);
    }

    private a(byte b2) {
        AppMethodBeat.i(234905);
        this.mAJ = new C0711a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(234905);
    }
}
