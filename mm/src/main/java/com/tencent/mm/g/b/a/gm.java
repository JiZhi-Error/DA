package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class gm extends a {
    private long eJL;
    private long eJM;
    private String eJN = "";
    private String eJO = "";
    private String eJP = "";
    private String eJQ = "";
    private long ejW;
    private long elz;
    private String erU = "";
    private String erV = "";

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 22116;
    }

    public final gm qt(long j2) {
        this.ejW = j2;
        return this;
    }

    public final gm qu(long j2) {
        this.elz = j2;
        return this;
    }

    public final gm qv(long j2) {
        this.eJL = j2;
        return this;
    }

    public final gm qw(long j2) {
        this.eJM = j2;
        return this;
    }

    public final gm uk(String str) {
        AppMethodBeat.i(209292);
        this.erV = x("Contextid", str, true);
        AppMethodBeat.o(209292);
        return this;
    }

    public final gm ul(String str) {
        AppMethodBeat.i(209293);
        this.erU = x("Sessionid", str, true);
        AppMethodBeat.o(209293);
        return this;
    }

    public final gm um(String str) {
        AppMethodBeat.i(209294);
        this.eJN = x("POIID", str, true);
        AppMethodBeat.o(209294);
        return this;
    }

    public final gm un(String str) {
        AppMethodBeat.i(209295);
        this.eJO = x("POIDetail", str, true);
        AppMethodBeat.o(209295);
        return this;
    }

    public final gm uo(String str) {
        AppMethodBeat.i(209296);
        this.eJQ = x("sourceid", str, true);
        AppMethodBeat.o(209296);
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(209297);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.ejW);
        stringBuffer.append(",");
        stringBuffer.append(this.elz);
        stringBuffer.append(",");
        stringBuffer.append(this.eJL);
        stringBuffer.append(",");
        stringBuffer.append(this.eJM);
        stringBuffer.append(",");
        stringBuffer.append(this.erV);
        stringBuffer.append(",");
        stringBuffer.append(this.erU);
        stringBuffer.append(",");
        stringBuffer.append(this.eJN);
        stringBuffer.append(",");
        stringBuffer.append(this.eJO);
        stringBuffer.append(",");
        stringBuffer.append(this.eJP);
        stringBuffer.append(",");
        stringBuffer.append(this.eJQ);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(209297);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(209298);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("action:").append(this.ejW);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("actionTS:").append(this.elz);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("duration:").append(this.eJL);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("DynamicState:").append(this.eJM);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Contextid:").append(this.erV);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Sessionid:").append(this.erU);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("POIID:").append(this.eJN);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("POIDetail:").append(this.eJO);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("finderusername:").append(this.eJP);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("sourceid:").append(this.eJQ);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(209298);
        return stringBuffer2;
    }
}
