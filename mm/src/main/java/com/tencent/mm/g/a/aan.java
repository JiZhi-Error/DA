package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;
import java.util.List;

public final class aan extends IEvent {
    public a ehq;
    public b ehr;

    public static final class a {
        public int action;
        public String content;
        public long dFm;
        public int ehs;
    }

    public static final class b {
        public long dFm;
        public int ehs;
        public long eht;
        public String ehu;
        public List ehv;
        public byte[] ehw;
        public byte[] ehx;
        public String ehy;
        public String ehz;
    }

    public aan() {
        this((byte) 0);
    }

    private aan(byte b2) {
        AppMethodBeat.i(91234);
        this.ehq = new a();
        this.ehr = new b();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(91234);
    }
}
