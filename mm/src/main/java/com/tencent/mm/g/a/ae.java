package com.tencent.mm.g.a;

import com.tencent.mm.sdk.event.IEvent;

public final class ae extends IEvent {
    public ae() {
        this((byte) 0);
    }

    private ae(byte b2) {
        this.order = false;
        this.callback = null;
    }
}
