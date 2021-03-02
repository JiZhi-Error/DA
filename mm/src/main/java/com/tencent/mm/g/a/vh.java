package com.tencent.mm.g.a;

import com.tencent.mm.sdk.event.IEvent;

public final class vh extends IEvent {
    public vh() {
        this((byte) 0);
    }

    private vh(byte b2) {
        this.order = false;
        this.callback = null;
    }
}
