package com.tencent.mm.g.a;

import com.tencent.mm.sdk.event.IEvent;

public final class kw extends IEvent {
    public kw() {
        this((byte) 0);
    }

    private kw(byte b2) {
        this.order = false;
        this.callback = null;
    }
}
