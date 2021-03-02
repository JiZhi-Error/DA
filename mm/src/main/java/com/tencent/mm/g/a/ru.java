package com.tencent.mm.g.a;

import com.tencent.mm.sdk.event.IEvent;

public final class ru extends IEvent {
    public ru() {
        this((byte) 0);
    }

    private ru(byte b2) {
        this.order = false;
        this.callback = null;
    }
}
