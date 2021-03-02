package com.tencent.mm.g.a;

import com.tencent.mm.sdk.event.IEvent;

public final class ra extends IEvent {
    public ra() {
        this((byte) 0);
    }

    private ra(byte b2) {
        this.order = false;
        this.callback = null;
    }
}
