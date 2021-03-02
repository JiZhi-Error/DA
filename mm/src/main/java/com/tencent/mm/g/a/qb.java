package com.tencent.mm.g.a;

import com.tencent.mm.sdk.event.IEvent;

public final class qb extends IEvent {
    public qb() {
        this((byte) 0);
    }

    private qb(byte b2) {
        this.order = false;
        this.callback = null;
    }
}
