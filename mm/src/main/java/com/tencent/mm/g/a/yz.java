package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class yz extends IEvent {
    public a efi;

    public static final class a {
        public int action;
        public int efj;
        public String result;
        public String userCode;
    }

    public yz() {
        this((byte) 0);
    }

    private yz(byte b2) {
        AppMethodBeat.i(19844);
        this.efi = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(19844);
    }
}
