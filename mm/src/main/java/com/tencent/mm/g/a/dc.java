package com.tencent.mm.g.a;

import com.tencent.mm.sdk.event.IEvent;

public final class dc extends IEvent {
    public dc() {
        this((byte) 0);
    }

    private dc(byte b2) {
        this.order = false;
        this.callback = null;
    }
}
