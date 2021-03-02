package com.tencent.mm.g.a;

import com.tencent.mm.sdk.event.IEvent;

public final class sj extends IEvent {
    public sj() {
        this((byte) 0);
    }

    private sj(byte b2) {
        this.order = false;
        this.callback = null;
    }
}
