package com.tencent.mm.g.a;

import com.tencent.mm.sdk.event.IEvent;

public final class oh extends IEvent {
    public oh() {
        this((byte) 0);
    }

    private oh(byte b2) {
        this.order = false;
        this.callback = null;
    }
}
