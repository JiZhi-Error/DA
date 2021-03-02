package com.tencent.mm.g.a;

import com.tencent.mm.sdk.event.IEvent;

public final class ur extends IEvent {
    public ur() {
        this((byte) 0);
    }

    private ur(byte b2) {
        this.order = false;
        this.callback = null;
    }
}
