package com.tencent.mm.g.a;

import com.tencent.mm.sdk.event.IEvent;

public final class at extends IEvent {
    public at() {
        this((byte) 0);
    }

    private at(byte b2) {
        this.order = false;
        this.callback = null;
    }
}
