package com.tencent.mm.g.a;

import com.tencent.mm.sdk.event.IEvent;

public final class vk extends IEvent {
    public vk() {
        this((byte) 0);
    }

    private vk(byte b2) {
        this.order = false;
        this.callback = null;
    }
}
