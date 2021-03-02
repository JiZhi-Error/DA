package com.tencent.mm.g.a;

import com.tencent.mm.sdk.event.IEvent;

public final class wm extends IEvent {
    public wm() {
        this((byte) 0);
    }

    private wm(byte b2) {
        this.order = false;
        this.callback = null;
    }
}
