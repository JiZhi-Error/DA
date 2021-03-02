package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class z extends a {
    public int ena = 0;
    public int enb = 0;
    public int enc = 0;
    public int ene = 0;
    private String enf = "";
    public int eng;
    public long enh = 0;
    public long eni = 0;
    private String enj = "";
    public long enk = 0;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 17473;
    }

    public final z ib(String str) {
        AppMethodBeat.i(149903);
        this.enf = x("filekey", str, true);
        AppMethodBeat.o(149903);
        return this;
    }

    public final z ic(String str) {
        AppMethodBeat.i(149904);
        this.enj = x("SystemErrorDescribe", str, true);
        AppMethodBeat.o(149904);
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(149905);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.ena);
        stringBuffer.append(",");
        stringBuffer.append(this.enb);
        stringBuffer.append(",");
        stringBuffer.append(this.enc);
        stringBuffer.append(",");
        stringBuffer.append(this.ene);
        stringBuffer.append(",");
        stringBuffer.append(this.enf);
        stringBuffer.append(",");
        stringBuffer.append(this.eng);
        stringBuffer.append(",");
        stringBuffer.append(this.enh);
        stringBuffer.append(",");
        stringBuffer.append(this.eni);
        stringBuffer.append(",");
        stringBuffer.append(this.enj);
        stringBuffer.append(",");
        stringBuffer.append(this.enk);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(149905);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(149906);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("optype:").append(this.ena);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("errtype:").append(this.enb);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("errcode:").append(this.enc);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("mapederror:").append(this.ene);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("filekey:").append(this.enf);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("filetype:").append(this.eng);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("TryWritenBytes:").append(this.enh);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("AvailableBytes:").append(this.eni);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("SystemErrorDescribe:").append(this.enj);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("CurrentFileSize:").append(this.enk);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(149906);
        return stringBuffer2;
    }
}
