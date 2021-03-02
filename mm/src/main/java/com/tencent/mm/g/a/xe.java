package com.tencent.mm.g.a;

import com.tencent.mm.sdk.event.IEvent;

public final class xe extends IEvent {
    public xe() {
        this((byte) 0);
    }

    private xe(byte b2) {
        this.order = false;
        this.callback = null;
    }
}
