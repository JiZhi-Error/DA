package com.tencent.mm.g.a;

import com.tencent.mm.sdk.event.IEvent;

public final class un extends IEvent {
    public un() {
        this((byte) 0);
    }

    private un(byte b2) {
        this.order = false;
        this.callback = null;
    }
}
