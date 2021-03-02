package com.tencent.mm.g.a;

import com.tencent.mm.sdk.event.IEvent;

public final class de extends IEvent {
    public de() {
        this((byte) 0);
    }

    private de(byte b2) {
        this.order = false;
        this.callback = null;
    }
}
