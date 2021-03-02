package com.tencent.mm.g.a;

import com.tencent.mm.sdk.event.IEvent;

public final class oi extends IEvent {
    public oi() {
        this((byte) 0);
    }

    private oi(byte b2) {
        this.order = false;
        this.callback = null;
    }
}
