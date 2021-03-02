package com.tencent.mm.g.a;

import com.tencent.mm.sdk.event.IEvent;

public final class qk extends IEvent {
    public qk() {
        this((byte) 0);
    }

    private qk(byte b2) {
        this.order = false;
        this.callback = null;
    }
}
