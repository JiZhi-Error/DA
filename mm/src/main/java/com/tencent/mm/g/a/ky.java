package com.tencent.mm.g.a;

import com.tencent.mm.sdk.event.IEvent;

public final class ky extends IEvent {
    public ky() {
        this((byte) 0);
    }

    private ky(byte b2) {
        this.order = false;
        this.callback = null;
    }
}
