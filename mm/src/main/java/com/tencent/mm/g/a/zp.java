package com.tencent.mm.g.a;

import com.tencent.mm.sdk.event.IEvent;

public final class zp extends IEvent {
    public zp() {
        this((byte) 0);
    }

    private zp(byte b2) {
        this.order = false;
        this.callback = null;
    }
}
