package com.tencent.mm.g.a;

import com.tencent.mm.sdk.event.IEvent;

public final class rm extends IEvent {
    public rm() {
        this((byte) 0);
    }

    private rm(byte b2) {
        this.order = false;
        this.callback = null;
    }
}
