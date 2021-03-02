package com.tencent.mm.g.a;

import com.tencent.mm.sdk.event.IEvent;

public final class yf extends IEvent {
    public yf() {
        this((byte) 0);
    }

    private yf(byte b2) {
        this.order = false;
        this.callback = null;
    }
}
