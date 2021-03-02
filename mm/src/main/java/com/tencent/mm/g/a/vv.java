package com.tencent.mm.g.a;

import com.tencent.mm.sdk.event.IEvent;

public final class vv extends IEvent {
    public vv() {
        this((byte) 0);
    }

    private vv(byte b2) {
        this.order = false;
        this.callback = null;
    }
}
