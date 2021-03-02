package com.tencent.mm.g.a;

import com.tencent.mm.sdk.event.IEvent;

public final class ok extends IEvent {
    public ok() {
        this((byte) 0);
    }

    private ok(byte b2) {
        this.order = false;
        this.callback = null;
    }
}
