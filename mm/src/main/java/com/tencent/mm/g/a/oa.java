package com.tencent.mm.g.a;

import com.tencent.mm.sdk.event.IEvent;

public final class oa extends IEvent {
    public oa() {
        this((byte) 0);
    }

    private oa(byte b2) {
        this.order = false;
        this.callback = null;
    }
}
