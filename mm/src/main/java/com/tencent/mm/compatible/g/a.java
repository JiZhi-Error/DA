package com.tencent.mm.compatible.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public final class a {
    public int dGe;
    public String gLc;
    public long gLd;
    public int gLe;

    public a() {
        AppMethodBeat.i(155857);
        this.gLc = null;
        this.gLd = -1;
        this.gLe = -1;
        this.dGe = -1;
        this.gLc = null;
        this.gLd = -1;
        this.gLe = -1;
        this.dGe = -1;
        AppMethodBeat.o(155857);
    }

    public final String apk() {
        AppMethodBeat.i(155858);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.gLc);
        stringBuffer.append(",");
        stringBuffer.append(this.gLd);
        stringBuffer.append(",");
        stringBuffer.append(this.gLe);
        stringBuffer.append(",");
        stringBuffer.append(this.dGe);
        Log.d("MicroMsg.AudioRecorderInfo", " getStatInfo " + stringBuffer.toString());
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(155858);
        return stringBuffer2;
    }
}
