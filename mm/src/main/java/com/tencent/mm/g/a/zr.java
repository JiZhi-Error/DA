package com.tencent.mm.g.a;

import com.tencent.mm.sdk.event.IEvent;

public final class zr extends IEvent {
    public zr() {
        this((byte) 0);
    }

    private zr(byte b2) {
        this.order = false;
        this.callback = null;
    }
}
