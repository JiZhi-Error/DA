package com.tencent.mm.g.a;

import com.tencent.mm.sdk.event.IEvent;

public final class mm extends IEvent {
    public mm() {
        this((byte) 0);
    }

    private mm(byte b2) {
        this.order = false;
        this.callback = null;
    }
}
