package com.tencent.mm.g.a;

import com.tencent.mm.sdk.event.IEvent;

public final class um extends IEvent {
    public um() {
        this((byte) 0);
    }

    private um(byte b2) {
        this.order = false;
        this.callback = null;
    }
}
