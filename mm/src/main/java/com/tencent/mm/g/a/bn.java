package com.tencent.mm.g.a;

import com.tencent.mm.sdk.event.IEvent;

public final class bn extends IEvent {
    public bn() {
        this((byte) 0);
    }

    private bn(byte b2) {
        this.order = false;
        this.callback = null;
    }
}
