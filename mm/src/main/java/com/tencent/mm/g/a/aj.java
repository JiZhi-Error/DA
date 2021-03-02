package com.tencent.mm.g.a;

import com.tencent.mm.sdk.event.IEvent;

public final class aj extends IEvent {
    public aj() {
        this((byte) 0);
    }

    private aj(byte b2) {
        this.order = false;
        this.callback = null;
    }
}
