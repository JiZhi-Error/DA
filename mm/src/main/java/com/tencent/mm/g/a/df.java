package com.tencent.mm.g.a;

import com.tencent.mm.sdk.event.IEvent;

public final class df extends IEvent {
    public df() {
        this((byte) 0);
    }

    private df(byte b2) {
        this.order = false;
        this.callback = null;
    }
}
