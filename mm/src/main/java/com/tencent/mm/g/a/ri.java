package com.tencent.mm.g.a;

import com.tencent.mm.sdk.event.IEvent;

public final class ri extends IEvent {
    public ri() {
        this((byte) 0);
    }

    private ri(byte b2) {
        this.order = false;
        this.callback = null;
    }
}
