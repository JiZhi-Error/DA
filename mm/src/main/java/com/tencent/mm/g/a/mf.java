package com.tencent.mm.g.a;

import com.tencent.mm.sdk.event.IEvent;

public final class mf extends IEvent {
    public mf() {
        this((byte) 0);
    }

    private mf(byte b2) {
        this.order = false;
        this.callback = null;
    }
}
