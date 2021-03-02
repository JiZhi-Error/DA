package com.tencent.mm.g.a;

import com.tencent.mm.sdk.event.IEvent;

public final class ub extends IEvent {
    public ub() {
        this((byte) 0);
    }

    private ub(byte b2) {
        this.order = false;
        this.callback = null;
    }
}
