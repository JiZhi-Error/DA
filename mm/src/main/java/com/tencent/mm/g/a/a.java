package com.tencent.mm.g.a;

import com.tencent.mm.sdk.event.IEvent;

public final class a extends IEvent {
    public a() {
        this((byte) 0);
    }

    private a(byte b2) {
        this.order = false;
        this.callback = null;
    }
}
