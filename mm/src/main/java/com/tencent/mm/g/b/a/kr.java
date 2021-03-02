package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class kr extends a {
    private long eLO = 0;
    private String eWa = "";
    private String eWb = "";
    private long eXc = 0;
    private long eXf;
    private long eXh = 0;
    private String eXi = "";
    private String etW = "";

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 16634;
    }

    public final kr yd(String str) {
        AppMethodBeat.i(43460);
        this.etW = x("Username", str, true);
        AppMethodBeat.o(43460);
        return this;
    }

    public final kr ye(String str) {
        AppMethodBeat.i(43461);
        this.eWa = x("Appid", str, true);
        AppMethodBeat.o(43461);
        return this;
    }

    public final kr tV(long j2) {
        this.eXc = j2;
        return this;
    }

    public final kr tW(long j2) {
        this.eXh = j2;
        return this;
    }

    public final kr tX(long j2) {
        this.eLO = j2;
        return this;
    }

    public final kr tY(long j2) {
        this.eXf = j2;
        return this;
    }

    public final kr yf(String str) {
        AppMethodBeat.i(43462);
        this.eXi = x("ModuleName", str, true);
        AppMethodBeat.o(43462);
        return this;
    }

    public final kr yg(String str) {
        AppMethodBeat.i(43463);
        this.eWb = x("InstanceId", str, true);
        AppMethodBeat.o(43463);
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(43464);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.etW);
        stringBuffer.append(",");
        stringBuffer.append(this.eWa);
        stringBuffer.append(",");
        stringBuffer.append(this.eXc);
        stringBuffer.append(",");
        stringBuffer.append(this.eXh);
        stringBuffer.append(",");
        stringBuffer.append(this.eLO);
        stringBuffer.append(",");
        stringBuffer.append(this.eXf);
        stringBuffer.append(",");
        stringBuffer.append(this.eXi);
        stringBuffer.append(",");
        stringBuffer.append(this.eWb);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(43464);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(43465);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Username:").append(this.etW);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Appid:").append(this.eWa);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("AppVersion:").append(this.eXc);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("IsFirstHit:").append(this.eXh);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ReportId:").append(this.eLO);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("PackageType:").append(this.eXf);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ModuleName:").append(this.eXi);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("InstanceId:").append(this.eWb);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(43465);
        return stringBuffer2;
    }
}
