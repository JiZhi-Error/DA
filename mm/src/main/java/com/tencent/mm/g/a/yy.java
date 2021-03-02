package com.tencent.mm.g.a;

import com.tencent.mm.sdk.event.IEvent;

public final class yy extends IEvent {
    public yy() {
        this((byte) 0);
    }

    private yy(byte b2) {
        this.order = false;
        this.callback = null;
    }
}
