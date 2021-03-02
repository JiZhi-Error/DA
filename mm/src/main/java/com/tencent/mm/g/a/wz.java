package com.tencent.mm.g.a;

import com.tencent.mm.sdk.event.IEvent;

public final class wz extends IEvent {
    public wz() {
        this((byte) 0);
    }

    private wz(byte b2) {
        this.order = false;
        this.callback = null;
    }
}
