package com.tencent.mm.g.a;

import com.tencent.mm.sdk.event.IEvent;

public final class my extends IEvent {
    public my() {
        this((byte) 0);
    }

    private my(byte b2) {
        this.order = false;
        this.callback = null;
    }
}
