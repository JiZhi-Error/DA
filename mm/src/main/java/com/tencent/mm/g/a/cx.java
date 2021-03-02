package com.tencent.mm.g.a;

import com.tencent.mm.sdk.event.IEvent;

public final class cx extends IEvent {
    public cx() {
        this((byte) 0);
    }

    private cx(byte b2) {
        this.order = false;
        this.callback = null;
    }
}
