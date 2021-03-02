package com.tencent.mm.g.a;

import com.tencent.mm.sdk.event.IEvent;

public final class be extends IEvent {
    public be() {
        this((byte) 0);
    }

    private be(byte b2) {
        this.order = false;
        this.callback = null;
    }
}
