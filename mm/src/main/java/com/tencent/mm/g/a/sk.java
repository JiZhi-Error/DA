package com.tencent.mm.g.a;

import com.tencent.mm.sdk.event.IEvent;

public final class sk extends IEvent {
    public sk() {
        this((byte) 0);
    }

    private sk(byte b2) {
        this.order = false;
        this.callback = null;
    }
}
