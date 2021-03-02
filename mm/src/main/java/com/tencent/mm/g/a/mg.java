package com.tencent.mm.g.a;

import com.tencent.mm.sdk.event.IEvent;

public final class mg extends IEvent {
    public mg() {
        this((byte) 0);
    }

    private mg(byte b2) {
        this.order = false;
        this.callback = null;
    }
}
