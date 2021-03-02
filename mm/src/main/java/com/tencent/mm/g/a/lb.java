package com.tencent.mm.g.a;

import com.tencent.mm.sdk.event.IEvent;

public final class lb extends IEvent {
    public lb() {
        this((byte) 0);
    }

    private lb(byte b2) {
        this.order = false;
        this.callback = null;
    }
}
