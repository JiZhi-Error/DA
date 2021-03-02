package com.tencent.mm.g.a;

import com.tencent.mm.sdk.event.IEvent;

public final class qm extends IEvent {
    public qm() {
        this((byte) 0);
    }

    private qm(byte b2) {
        this.order = false;
        this.callback = null;
    }
}
