package com.tencent.mm.plugin.cloudvoip.cloudvoice.c;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b {
    public String openId;
    public int qrD;

    public final String toString() {
        AppMethodBeat.i(90786);
        String str = "OpenVoiceMember{memberId=" + this.qrD + ", openId='" + this.openId + '\'' + '}';
        AppMethodBeat.o(90786);
        return str;
    }
}
