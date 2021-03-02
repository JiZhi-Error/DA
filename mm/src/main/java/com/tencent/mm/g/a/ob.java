package com.tencent.mm.g.a;

import com.tencent.mm.sdk.event.IEvent;

public final class ob extends IEvent {
    public ob() {
        this((byte) 0);
    }

    private ob(byte b2) {
        this.order = false;
        this.callback = null;
    }
}
