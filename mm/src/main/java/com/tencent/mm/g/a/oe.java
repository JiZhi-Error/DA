package com.tencent.mm.g.a;

import com.tencent.mm.sdk.event.IEvent;

public final class oe extends IEvent {
    public oe() {
        this((byte) 0);
    }

    private oe(byte b2) {
        this.order = false;
        this.callback = null;
    }
}
