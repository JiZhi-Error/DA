package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.storage.emotion.EmojiInfo;

public final class di extends IEvent {
    public a dGs;

    public static final class a {
        public EmojiInfo dGt;
        public int scene;
    }

    public di() {
        this((byte) 0);
    }

    private di(byte b2) {
        AppMethodBeat.i(104411);
        this.dGs = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(104411);
    }
}
