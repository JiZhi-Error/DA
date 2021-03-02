package com.tencent.mm.g.a;

import com.tencent.mm.sdk.event.IEvent;

public final class dd extends IEvent {
    public dd() {
        this((byte) 0);
    }

    private dd(byte b2) {
        this.order = false;
        this.callback = null;
    }
}
