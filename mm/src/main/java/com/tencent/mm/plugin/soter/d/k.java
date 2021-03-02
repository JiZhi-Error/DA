package com.tencent.mm.plugin.soter.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class k {
    public byte FhW = 1;
    public String FhX = "";
    public String dZL = "";
    public int errCode = 0;
    public String errMsg = "OK";

    public final String toString() {
        AppMethodBeat.i(145971);
        String str = "SoterMpRespModel{errCode=" + this.errCode + ", errMsg='" + this.errMsg + '\'' + ", resultMode=" + ((int) this.FhW) + ", resultJson='" + this.dZL + '\'' + ", resultJsonSignature='" + this.FhX + '\'' + '}';
        AppMethodBeat.o(145971);
        return str;
    }
}
