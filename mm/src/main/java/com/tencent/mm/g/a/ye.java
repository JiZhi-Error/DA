package com.tencent.mm.g.a;

import com.tencent.mm.sdk.event.IEvent;

public final class ye extends IEvent {
    public ye() {
        this((byte) 0);
    }

    private ye(byte b2) {
        this.order = false;
        this.callback = null;
    }
}
