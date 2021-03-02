package com.tencent.mm.g.a;

import com.tencent.mm.sdk.event.IEvent;

public final class xj extends IEvent {
    public xj() {
        this((byte) 0);
    }

    private xj(byte b2) {
        this.order = false;
        this.callback = null;
    }
}
