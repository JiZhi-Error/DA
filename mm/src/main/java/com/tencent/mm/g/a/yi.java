package com.tencent.mm.g.a;

import com.tencent.mm.sdk.event.IEvent;

public final class yi extends IEvent {
    public yi() {
        this((byte) 0);
    }

    private yi(byte b2) {
        this.order = false;
        this.callback = null;
    }
}
