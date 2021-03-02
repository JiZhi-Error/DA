package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class ah extends a {
    public int enX = 0;
    public int enY = 0;
    public int enZ = 0;
    public String eoa = "";
    public String eob = "";
    public String eoc = "";
    public String eod = "";
    public String eoe = "";
    public String eog = "";
    public String eoh = "";
    public String eoi = "";

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 15548;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(63297);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.enX);
        stringBuffer.append(",");
        stringBuffer.append(this.enY);
        stringBuffer.append(",");
        stringBuffer.append(this.enZ);
        stringBuffer.append(",");
        stringBuffer.append(this.eoa);
        stringBuffer.append(",");
        stringBuffer.append(this.eob);
        stringBuffer.append(",");
        stringBuffer.append(this.eoc);
        stringBuffer.append(",");
        stringBuffer.append(this.eod);
        stringBuffer.append(",");
        stringBuffer.append(this.eoe);
        stringBuffer.append(",");
        stringBuffer.append(this.eog);
        stringBuffer.append(",");
        stringBuffer.append(this.eoh);
        stringBuffer.append(",");
        stringBuffer.append(this.eoi);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(63297);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(63298);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("CgiCmd:").append(this.enX);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ErrType:").append(this.enY);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ErrCode:").append(this.enZ);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("EncryptKey:").append(this.eoa);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("EncryptUserinfo:").append(this.eob);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("EncryptCellinfoLength:").append(this.eoc);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("EncryptCellinfo_01:").append(this.eod);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("EncryptCellinfo_02:").append(this.eoe);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("EncryptCellinfo_03:").append(this.eog);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("EncryptCellinfo_04:").append(this.eoh);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("EncryptCellinfo_05:").append(this.eoi);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(63298);
        return stringBuffer2;
    }
}
