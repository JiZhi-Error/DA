package com.tencent.mm.g.a;

import com.tencent.mm.sdk.event.IEvent;

public final class ro extends IEvent {
    public ro() {
        this((byte) 0);
    }

    private ro(byte b2) {
        this.order = false;
        this.callback = null;
    }
}
