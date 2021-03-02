package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class fx extends a {
    private String els = "";
    private String elt = "";
    private long enl;
    private String eoj = "";
    private String erH = "";
    private long esJ;
    private String eui = "";

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 21151;
    }

    public final fx sV(String str) {
        AppMethodBeat.i(209259);
        this.eoj = x("Feedid", str, true);
        AppMethodBeat.o(209259);
        return this;
    }

    public final fx sW(String str) {
        AppMethodBeat.i(209260);
        this.eui = x("LongVideoId", str, true);
        AppMethodBeat.o(209260);
        return this;
    }

    public final fx pG(long j2) {
        this.enl = j2;
        return this;
    }

    public final fx pH(long j2) {
        this.esJ = j2;
        return this;
    }

    public final fx sX(String str) {
        AppMethodBeat.i(209261);
        this.els = x("sessionid", str, true);
        AppMethodBeat.o(209261);
        return this;
    }

    public final fx sY(String str) {
        AppMethodBeat.i(209262);
        this.elt = x("contextid", str, true);
        AppMethodBeat.o(209262);
        return this;
    }

    public final fx sZ(String str) {
        AppMethodBeat.i(209263);
        this.erH = x("ClickTabContextId", str, true);
        AppMethodBeat.o(209263);
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(209264);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.eoj);
        stringBuffer.append(",");
        stringBuffer.append(this.eui);
        stringBuffer.append(",");
        stringBuffer.append(this.enl);
        stringBuffer.append(",");
        stringBuffer.append(this.esJ);
        stringBuffer.append(",");
        stringBuffer.append(this.els);
        stringBuffer.append(",");
        stringBuffer.append(this.elt);
        stringBuffer.append(",");
        stringBuffer.append(this.erH);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(209264);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(209265);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Feedid:").append(this.eoj);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("LongVideoId:").append(this.eui);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ActionType:").append(this.enl);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Outcome:").append(this.esJ);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("sessionid:").append(this.els);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("contextid:").append(this.elt);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ClickTabContextId:").append(this.erH);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(209265);
        return stringBuffer2;
    }
}
