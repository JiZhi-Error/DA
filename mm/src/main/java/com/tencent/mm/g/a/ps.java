package com.tencent.mm.g.a;

import com.tencent.mm.sdk.event.IEvent;

public final class ps extends IEvent {
    public ps() {
        this((byte) 0);
    }

    private ps(byte b2) {
        this.order = false;
        this.callback = null;
    }
}
