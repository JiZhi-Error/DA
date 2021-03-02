package com.tencent.mm.g.a;

import com.tencent.mm.sdk.event.IEvent;

public final class yn extends IEvent {
    public yn() {
        this((byte) 0);
    }

    private yn(byte b2) {
        this.order = false;
        this.callback = null;
    }
}
