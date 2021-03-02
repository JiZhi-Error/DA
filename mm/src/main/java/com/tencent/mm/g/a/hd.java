package com.tencent.mm.g.a;

import com.tencent.mm.sdk.event.IEvent;

public final class hd extends IEvent {
    public hd() {
        this((byte) 0);
    }

    private hd(byte b2) {
        this.order = false;
        this.callback = null;
    }
}
