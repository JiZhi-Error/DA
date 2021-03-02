package com.tencent.mm.g.a;

import com.tencent.mm.sdk.event.IEvent;

public final class co extends IEvent {
    public co() {
        this((byte) 0);
    }

    private co(byte b2) {
        this.order = false;
        this.callback = null;
    }
}
