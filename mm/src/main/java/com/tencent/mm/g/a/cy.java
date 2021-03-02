package com.tencent.mm.g.a;

import com.tencent.mm.sdk.event.IEvent;

public final class cy extends IEvent {
    public cy() {
        this((byte) 0);
    }

    private cy(byte b2) {
        this.order = false;
        this.callback = null;
    }
}
