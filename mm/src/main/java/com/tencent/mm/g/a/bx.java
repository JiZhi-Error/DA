package com.tencent.mm.g.a;

import com.tencent.mm.sdk.event.IEvent;

public final class bx extends IEvent {
    public bx() {
        this((byte) 0);
    }

    private bx(byte b2) {
        this.order = false;
        this.callback = null;
    }
}
