package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.storage.emotion.EmojiInfo;

public final class bi extends IEvent {
    public a dEx;
    public b dEy;

    public static final class a {
        public String dEA;
        public EmojiInfo dEz;
        public int type;
    }

    public static final class b {
        public boolean result = false;
    }

    public bi() {
        this((byte) 0);
    }

    private bi(byte b2) {
        AppMethodBeat.i(104409);
        this.dEx = new a();
        this.dEy = new b();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(104409);
    }
}
