package com.tencent.mm.g.a;

import com.tencent.mm.sdk.event.IEvent;

public final class ts extends IEvent {
    public ts() {
        this((byte) 0);
    }

    private ts(byte b2) {
        this.order = false;
        this.callback = null;
    }
}
