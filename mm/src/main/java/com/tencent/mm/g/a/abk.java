package com.tencent.mm.g.a;

import com.tencent.mm.sdk.event.IEvent;

public final class abk extends IEvent {
    public abk() {
        this((byte) 0);
    }

    private abk(byte b2) {
        this.order = false;
        this.callback = null;
    }
}
