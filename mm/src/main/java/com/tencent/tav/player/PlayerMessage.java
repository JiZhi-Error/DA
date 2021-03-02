package com.tencent.tav.player;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class PlayerMessage {
    public Object bizMsg1;
    public Callback callback;
    public String form;
    public long msgId;

    public PlayerMessage(Object obj, long j2) {
        this.bizMsg1 = obj;
        this.msgId = j2;
    }

    public PlayerMessage(Object obj, String str, long j2) {
        this.bizMsg1 = obj;
        this.form = str;
        this.msgId = j2;
    }

    public PlayerMessage(Object obj, String str, long j2, Callback callback2) {
        this.bizMsg1 = obj;
        this.form = str;
        this.msgId = j2;
        this.callback = callback2;
    }

    public String toString() {
        AppMethodBeat.i(218621);
        String str = "PlayerMessage{bizMsg1=" + this.bizMsg1 + ", form='" + this.form + '\'' + ", msgId=" + this.msgId + '}';
        AppMethodBeat.o(218621);
        return str;
    }
}
