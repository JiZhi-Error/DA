package com.tencent.mm.plugin.chatroom.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a {
    public final int jvu;
    public final String qnh;
    public final int qni;
    public final int qnj;
    public final int qnk;

    public a(String str, int i2, int i3, int i4, int i5) {
        this.qnh = str;
        this.qni = i2;
        this.jvu = i3;
        this.qnj = i4;
        this.qnk = i5;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(116463);
        if (hashCode() == obj.hashCode()) {
            AppMethodBeat.o(116463);
            return true;
        } else if (obj instanceof a) {
            a aVar = (a) obj;
            if (this.qni == aVar.qni && this.jvu == aVar.jvu && this.qnj == aVar.qnj && this.qnk == aVar.qnk && this.qnh.equals(aVar.qnh)) {
                AppMethodBeat.o(116463);
                return true;
            }
            AppMethodBeat.o(116463);
            return false;
        } else {
            AppMethodBeat.o(116463);
            return false;
        }
    }

    public final String toString() {
        AppMethodBeat.i(116464);
        String str = "GetChatRoomMsgInfo chatroomId[" + this.qnh + "], filterSeq[" + this.qni + "], msgSeq[" + this.jvu + "], needCount[" + this.qnj + "], upDownFlag[" + this.qnk + "], hash[" + hashCode() + "]";
        AppMethodBeat.o(116464);
        return str;
    }
}
