package com.tencent.mm.g.a;

import com.tencent.mm.sdk.event.IEvent;

public final class po extends IEvent {
    public po() {
        this((byte) 0);
    }

    private po(byte b2) {
        this.order = false;
        this.callback = null;
    }
}
