package com.tencent.mm.g.a;

import com.tencent.mm.sdk.event.IEvent;

public final class pp extends IEvent {
    public pp() {
        this((byte) 0);
    }

    private pp(byte b2) {
        this.order = false;
        this.callback = null;
    }
}
