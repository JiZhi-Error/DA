package com.tencent.mm.g.a;

import com.tencent.mm.sdk.event.IEvent;

public final class ys extends IEvent {
    public ys() {
        this((byte) 0);
    }

    private ys(byte b2) {
        this.order = false;
        this.callback = null;
    }
}
