package com.tencent.mm.g.a;

import com.tencent.mm.sdk.event.IEvent;

public final class wd extends IEvent {
    public wd() {
        this((byte) 0);
    }

    private wd(byte b2) {
        this.order = false;
        this.callback = null;
    }
}
