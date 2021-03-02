package com.tencent.mm.g.a;

import com.tencent.mm.sdk.event.IEvent;

public final class gb extends IEvent {
    public gb() {
        this((byte) 0);
    }

    private gb(byte b2) {
        this.order = false;
        this.callback = null;
    }
}
