package com.tencent.mm.g.a;

import com.tencent.mm.sdk.event.IEvent;

public final class hc extends IEvent {
    public hc() {
        this((byte) 0);
    }

    private hc(byte b2) {
        this.order = false;
        this.callback = null;
    }
}
