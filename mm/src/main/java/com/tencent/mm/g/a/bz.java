package com.tencent.mm.g.a;

import com.tencent.mm.sdk.event.IEvent;

public final class bz extends IEvent {
    public bz() {
        this((byte) 0);
    }

    private bz(byte b2) {
        this.order = false;
        this.callback = null;
    }
}
