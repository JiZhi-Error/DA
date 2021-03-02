package com.tencent.mm.plugin.soter.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class j {
    public byte FhV = 1;
    public String content = null;
    public String wFE = "";

    public final String toString() {
        AppMethodBeat.i(145970);
        String str = "SoterMpReqModel{reqAuthenMode=" + ((int) this.FhV) + ", challenge='" + this.wFE + '\'' + ", content='" + this.content + '\'' + '}';
        AppMethodBeat.o(145970);
        return str;
    }
}
