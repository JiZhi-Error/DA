package com.tencent.mm.g.a;

import com.tencent.mm.sdk.event.IEvent;

public final class oy extends IEvent {
    public oy() {
        this((byte) 0);
    }

    private oy(byte b2) {
        this.order = false;
        this.callback = null;
    }
}
