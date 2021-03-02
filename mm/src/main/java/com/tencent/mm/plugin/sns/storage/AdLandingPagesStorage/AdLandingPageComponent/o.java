package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class o extends q {
    public int DYl;
    public int DYm;
    public long DYn;
    public String gTk;
    public String kZe;

    public final String toString() {
        AppMethodBeat.i(96317);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[sid:").append(this.DYl).append(", compId:").append(this.DYm).append(", aid:").append(this.DYn).append(", traceId:").append(this.kZe).append(", uxinfo:").append(this.gTk).append("]");
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(96317);
        return stringBuffer2;
    }
}
