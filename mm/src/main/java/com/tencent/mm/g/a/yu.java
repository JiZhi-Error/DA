package com.tencent.mm.g.a;

import com.tencent.mm.sdk.event.IEvent;

public final class yu extends IEvent {
    public yu() {
        this((byte) 0);
    }

    private yu(byte b2) {
        this.order = false;
        this.callback = null;
    }
}
