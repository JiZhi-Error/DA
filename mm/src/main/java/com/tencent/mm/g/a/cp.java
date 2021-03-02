package com.tencent.mm.g.a;

import com.tencent.mm.sdk.event.IEvent;

public final class cp extends IEvent {
    public cp() {
        this((byte) 0);
    }

    private cp(byte b2) {
        this.order = false;
        this.callback = null;
    }
}
