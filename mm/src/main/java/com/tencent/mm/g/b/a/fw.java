package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class fw extends a {
    private long eIh;
    private long eIi;
    private long eIj;
    private String els = "";
    private String elt = "";
    private String eoj = "";
    private String erH = "";
    private long esI;
    private String eui = "";

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 21152;
    }

    public final fw sQ(String str) {
        AppMethodBeat.i(209252);
        this.eoj = x("Feedid", str, true);
        AppMethodBeat.o(209252);
        return this;
    }

    public final fw sR(String str) {
        AppMethodBeat.i(209253);
        this.eui = x("LongVideoId", str, true);
        AppMethodBeat.o(209253);
        return this;
    }

    public final fw sS(String str) {
        AppMethodBeat.i(209254);
        this.els = x("sessionid", str, true);
        AppMethodBeat.o(209254);
        return this;
    }

    public final fw sT(String str) {
        AppMethodBeat.i(209255);
        this.elt = x("contextid", str, true);
        AppMethodBeat.o(209255);
        return this;
    }

    public final fw sU(String str) {
        AppMethodBeat.i(209256);
        this.erH = x("ClickTabContextId", str, true);
        AppMethodBeat.o(209256);
        return this;
    }

    public final fw agH() {
        this.esI = 1;
        return this;
    }

    public final fw pD(long j2) {
        this.eIh = j2;
        return this;
    }

    public final fw pE(long j2) {
        this.eIi = j2;
        return this;
    }

    public final fw pF(long j2) {
        this.eIj = j2;
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(209257);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.eoj);
        stringBuffer.append(",");
        stringBuffer.append(this.eui);
        stringBuffer.append(",");
        stringBuffer.append(this.els);
        stringBuffer.append(",");
        stringBuffer.append(this.elt);
        stringBuffer.append(",");
        stringBuffer.append(this.erH);
        stringBuffer.append(",");
        stringBuffer.append(this.esI);
        stringBuffer.append(",");
        stringBuffer.append(this.eIh);
        stringBuffer.append(",");
        stringBuffer.append(this.eIi);
        stringBuffer.append(",");
        stringBuffer.append(this.eIj);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(209257);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(209258);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Feedid:").append(this.eoj);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("LongVideoId:").append(this.eui);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("sessionid:").append(this.els);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("contextid:").append(this.elt);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ClickTabContextId:").append(this.erH);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ClickType:").append(this.esI);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("LongvideoLen:").append(this.eIh);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("IsHaveGuide:").append(this.eIi);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("PlayLen:").append(this.eIj);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(209258);
        return stringBuffer2;
    }
}
