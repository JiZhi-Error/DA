package com.tencent.mm.g.a;

import com.tencent.mm.sdk.event.IEvent;

public final class wc extends IEvent {
    public wc() {
        this((byte) 0);
    }

    private wc(byte b2) {
        this.order = false;
        this.callback = null;
    }
}
