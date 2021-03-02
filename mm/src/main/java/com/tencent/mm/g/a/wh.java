package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;
import java.util.LinkedList;

public final class wh extends IEvent {
    public a ecr;

    public static final class a {
        public LinkedList<Long> ecs;
    }

    public wh() {
        this((byte) 0);
    }

    private wh(byte b2) {
        AppMethodBeat.i(125646);
        this.ecr = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(125646);
    }
}
