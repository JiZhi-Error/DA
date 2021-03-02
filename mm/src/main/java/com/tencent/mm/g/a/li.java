package com.tencent.mm.g.a;

import com.tencent.mm.sdk.event.IEvent;

public final class li extends IEvent {
    public li() {
        this((byte) 0);
    }

    private li(byte b2) {
        this.order = false;
        this.callback = null;
    }
}
