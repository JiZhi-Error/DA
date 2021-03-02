package com.tencent.mm.g.a;

import com.tencent.mm.sdk.event.IEvent;

public final class rj extends IEvent {
    public rj() {
        this((byte) 0);
    }

    private rj(byte b2) {
        this.order = false;
        this.callback = null;
    }
}
