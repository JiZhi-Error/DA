package com.tencent.mm.g.a;

import com.tencent.mm.sdk.event.IEvent;

public final class xh extends IEvent {
    public xh() {
        this((byte) 0);
    }

    private xh(byte b2) {
        this.order = false;
        this.callback = null;
    }
}
