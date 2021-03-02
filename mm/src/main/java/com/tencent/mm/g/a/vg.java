package com.tencent.mm.g.a;

import com.tencent.mm.sdk.event.IEvent;

public final class vg extends IEvent {
    public vg() {
        this((byte) 0);
    }

    private vg(byte b2) {
        this.order = false;
        this.callback = null;
    }
}
