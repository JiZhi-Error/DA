package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class bz extends a {
    private String eoD = "";
    private String erU = "";
    private long eua;
    private long euq = 0;
    private long eur;
    private String eus = "";
    private long eut;
    private long euu;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 19949;
    }

    public final bz fi(long j2) {
        this.euq = j2;
        return this;
    }

    public final bz fj(long j2) {
        this.eur = j2;
        return this;
    }

    public final bz fk(long j2) {
        this.eua = j2;
        return this;
    }

    public final bz kF(String str) {
        AppMethodBeat.i(208942);
        this.erU = x("Sessionid", str, true);
        AppMethodBeat.o(208942);
        return this;
    }

    public final bz kG(String str) {
        AppMethodBeat.i(208943);
        this.eus = x("ClickContextid", str, true);
        AppMethodBeat.o(208943);
        return this;
    }

    public final String acW() {
        return this.eus;
    }

    public final bz acX() {
        this.eut = 1;
        return this;
    }

    public final bz fl(long j2) {
        this.euu = j2;
        return this;
    }

    public final bz kH(String str) {
        AppMethodBeat.i(208944);
        this.eoD = x("ContextID", str, true);
        AppMethodBeat.o(208944);
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(208945);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.euq);
        stringBuffer.append(",");
        stringBuffer.append(this.eur);
        stringBuffer.append(",");
        stringBuffer.append(this.eua);
        stringBuffer.append(",");
        stringBuffer.append(this.erU);
        stringBuffer.append(",");
        stringBuffer.append(this.eus);
        stringBuffer.append(",");
        stringBuffer.append(this.eut);
        stringBuffer.append(",");
        stringBuffer.append(this.euu);
        stringBuffer.append(",");
        stringBuffer.append(this.eoD);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(208945);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(208946);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("fromTab:").append(this.euq);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("toTab:").append(this.eur);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ActionTimeStamp:").append(this.eua);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Sessionid:").append(this.erU);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ClickContextid:").append(this.eus);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("hasRedDot:").append(this.eut);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ManuallyTapped:").append(this.euu);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ContextID:").append(this.eoD);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(208946);
        return stringBuffer2;
    }
}
