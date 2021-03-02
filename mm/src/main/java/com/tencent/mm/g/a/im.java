package com.tencent.mm.g.a;

import com.tencent.mm.sdk.event.IEvent;

public final class im extends IEvent {
    public im() {
        this((byte) 0);
    }

    private im(byte b2) {
        this.order = false;
        this.callback = null;
    }
}
