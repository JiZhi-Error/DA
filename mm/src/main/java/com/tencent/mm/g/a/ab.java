package com.tencent.mm.g.a;

import com.tencent.mm.sdk.event.IEvent;

public final class ab extends IEvent {
    public ab() {
        this((byte) 0);
    }

    private ab(byte b2) {
        this.order = false;
        this.callback = null;
    }
}
