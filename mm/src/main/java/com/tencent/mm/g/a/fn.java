package com.tencent.mm.g.a;

import com.tencent.mm.sdk.event.IEvent;

public final class fn extends IEvent {
    public fn() {
        this((byte) 0);
    }

    private fn(byte b2) {
        this.order = false;
        this.callback = null;
    }
}
