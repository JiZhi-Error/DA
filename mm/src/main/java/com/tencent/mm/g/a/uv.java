package com.tencent.mm.g.a;

import com.tencent.mm.sdk.event.IEvent;

public final class uv extends IEvent {
    public uv() {
        this((byte) 0);
    }

    private uv(byte b2) {
        this.order = false;
        this.callback = null;
    }
}
