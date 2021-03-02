package com.tencent.mm.g.a;

import com.tencent.mm.sdk.event.IEvent;

public final class abh extends IEvent {
    public abh() {
        this((byte) 0);
    }

    private abh(byte b2) {
        this.order = false;
        this.callback = null;
    }
}
