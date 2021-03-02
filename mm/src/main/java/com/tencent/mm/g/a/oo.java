package com.tencent.mm.g.a;

import com.tencent.mm.sdk.event.IEvent;

public final class oo extends IEvent {
    public oo() {
        this((byte) 0);
    }

    private oo(byte b2) {
        this.order = false;
        this.callback = null;
    }
}
