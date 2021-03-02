package com.tencent.mm.g.a;

import com.tencent.mm.sdk.event.IEvent;

public final class ah extends IEvent {
    public ah() {
        this((byte) 0);
    }

    private ah(byte b2) {
        this.order = false;
        this.callback = null;
    }
}
