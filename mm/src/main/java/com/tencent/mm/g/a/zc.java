package com.tencent.mm.g.a;

import com.tencent.mm.sdk.event.IEvent;

public final class zc extends IEvent {
    public zc() {
        this((byte) 0);
    }

    private zc(byte b2) {
        this.order = false;
        this.callback = null;
    }
}
