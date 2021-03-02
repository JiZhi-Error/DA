package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class be extends a {
    private long ejA;
    private String erH = "";
    private String erU = "";
    private String erV = "";
    private long erW;
    private long erX;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 19995;
    }

    public final be jc(String str) {
        AppMethodBeat.i(208854);
        this.erU = x("Sessionid", str, true);
        AppMethodBeat.o(208854);
        return this;
    }

    public final be jd(String str) {
        AppMethodBeat.i(208855);
        this.erV = x("Contextid", str, true);
        AppMethodBeat.o(208855);
        return this;
    }

    public final be je(String str) {
        AppMethodBeat.i(208856);
        this.erH = x("ClickTabContextId", str, true);
        AppMethodBeat.o(208856);
        return this;
    }

    public final be dr(long j2) {
        this.erW = j2;
        return this;
    }

    public final be ds(long j2) {
        this.ejA = j2;
        return this;
    }

    public final be dt(long j2) {
        this.erX = j2;
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(208857);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.erU);
        stringBuffer.append(",");
        stringBuffer.append(this.erV);
        stringBuffer.append(",");
        stringBuffer.append(this.erH);
        stringBuffer.append(",");
        stringBuffer.append(this.erW);
        stringBuffer.append(",");
        stringBuffer.append(this.ejA);
        stringBuffer.append(",");
        stringBuffer.append(this.erX);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(208857);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(208858);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Sessionid:").append(this.erU);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Contextid:").append(this.erV);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ClickTabContextId:").append(this.erH);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Scene:").append(this.erW);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Action:").append(this.ejA);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("HasWording:").append(this.erX);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(208858);
        return stringBuffer2;
    }
}
