package com.tencent.mm.g.a;

import com.tencent.mm.sdk.event.IEvent;

public final class cg extends IEvent {
    public cg() {
        this((byte) 0);
    }

    private cg(byte b2) {
        this.order = false;
        this.callback = null;
    }
}
