package com.tencent.mm.g.a;

import com.tencent.mm.sdk.event.IEvent;

public final class bs extends IEvent {
    public bs() {
        this((byte) 0);
    }

    private bs(byte b2) {
        this.order = false;
        this.callback = null;
    }
}
