package com.tencent.mm.g.a;

import com.tencent.mm.sdk.event.IEvent;

public final class pe extends IEvent {
    public pe() {
        this((byte) 0);
    }

    private pe(byte b2) {
        this.order = false;
        this.callback = null;
    }
}
