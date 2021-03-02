package com.tencent.mm.g.a;

import com.tencent.mm.sdk.event.IEvent;

public final class ca extends IEvent {
    public ca() {
        this((byte) 0);
    }

    private ca(byte b2) {
        this.order = false;
        this.callback = null;
    }
}
