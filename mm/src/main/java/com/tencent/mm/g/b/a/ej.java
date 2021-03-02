package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class ej extends a {
    private String eCG = "";
    private String eCH = "";
    private long eCI;
    private long eCJ;
    private long eCK;
    private String eiC = "";
    private String erU = "";
    private String erV = "";
    private long erW;
    private long ery;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 19996;
    }

    public final ej lT(long j2) {
        this.erW = j2;
        return this;
    }

    public final ej qW(String str) {
        AppMethodBeat.i(209221);
        this.erU = x("Sessionid", str, true);
        AppMethodBeat.o(209221);
        return this;
    }

    public final ej qX(String str) {
        AppMethodBeat.i(209222);
        this.erV = x("Contextid", str, true);
        AppMethodBeat.o(209222);
        return this;
    }

    public final ej qY(String str) {
        AppMethodBeat.i(209223);
        this.eiC = x("ClickTabContextid", str, true);
        AppMethodBeat.o(209223);
        return this;
    }

    public final ej qZ(String str) {
        AppMethodBeat.i(209224);
        this.eCG = x("PoiText", str, true);
        AppMethodBeat.o(209224);
        return this;
    }

    public final ej ra(String str) {
        AppMethodBeat.i(209225);
        this.eCH = x("FilterTextItems", str, true);
        AppMethodBeat.o(209225);
        return this;
    }

    public final ej lU(long j2) {
        this.eCI = j2;
        return this;
    }

    public final ej lV(long j2) {
        this.eCJ = j2;
        return this;
    }

    public final ej lW(long j2) {
        this.eCK = j2;
        return this;
    }

    public final ej lX(long j2) {
        this.ery = j2;
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(209226);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.erW);
        stringBuffer.append(",");
        stringBuffer.append(this.erU);
        stringBuffer.append(",");
        stringBuffer.append(this.erV);
        stringBuffer.append(",");
        stringBuffer.append(this.eiC);
        stringBuffer.append(",");
        stringBuffer.append(this.eCG);
        stringBuffer.append(",");
        stringBuffer.append(this.eCH);
        stringBuffer.append(",");
        stringBuffer.append(this.eCI);
        stringBuffer.append(",");
        stringBuffer.append(this.eCJ);
        stringBuffer.append(",");
        stringBuffer.append(this.eCK);
        stringBuffer.append(",");
        stringBuffer.append(this.ery);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(209226);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(209227);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Scene:").append(this.erW);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Sessionid:").append(this.erU);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Contextid:").append(this.erV);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ClickTabContextid:").append(this.eiC);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("PoiText:").append(this.eCG);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("FilterTextItems:").append(this.eCH);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("IsUnflodtab:").append(this.eCI);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("IsUnflodopen:").append(this.eCJ);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("FliterPageType:").append(this.eCK);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("CommentScene:").append(this.ery);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(209227);
        return stringBuffer2;
    }
}
