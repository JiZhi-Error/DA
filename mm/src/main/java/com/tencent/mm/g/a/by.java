package com.tencent.mm.g.a;

import com.tencent.mm.sdk.event.IEvent;

public final class by extends IEvent {
    public by() {
        this((byte) 0);
    }

    private by(byte b2) {
        this.order = false;
        this.callback = null;
    }
}
