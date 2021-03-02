package com.tencent.mm.g.a;

import com.tencent.mm.sdk.event.IEvent;

public final class q extends IEvent {
    public q() {
        this((byte) 0);
    }

    private q(byte b2) {
        this.order = false;
        this.callback = null;
    }
}
