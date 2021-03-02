package com.tencent.mm.g.a;

import com.tencent.mm.sdk.event.IEvent;

public final class mb extends IEvent {
    public mb() {
        this((byte) 0);
    }

    private mb(byte b2) {
        this.order = false;
        this.callback = null;
    }
}
