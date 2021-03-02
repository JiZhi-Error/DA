package com.tencent.mm.g.a;

import com.tencent.mm.sdk.event.IEvent;

public final class vu extends IEvent {
    public vu() {
        this((byte) 0);
    }

    private vu(byte b2) {
        this.order = false;
        this.callback = null;
    }
}
