package com.tencent.mm.g.a;

import com.tencent.mm.sdk.event.IEvent;

public final class sq extends IEvent {
    public sq() {
        this((byte) 0);
    }

    private sq(byte b2) {
        this.order = false;
        this.callback = null;
    }
}
