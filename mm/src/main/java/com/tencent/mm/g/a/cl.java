package com.tencent.mm.g.a;

import com.tencent.mm.sdk.event.IEvent;

public final class cl extends IEvent {
    public cl() {
        this((byte) 0);
    }

    private cl(byte b2) {
        this.order = false;
        this.callback = null;
    }
}
