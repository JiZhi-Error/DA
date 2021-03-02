package com.tencent.mm.g.a;

import com.tencent.mm.sdk.event.IEvent;

public final class cf extends IEvent {
    public cf() {
        this((byte) 0);
    }

    private cf(byte b2) {
        this.order = false;
        this.callback = null;
    }
}
