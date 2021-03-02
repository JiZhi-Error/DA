package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class nr extends a {
    public long fij = 0;
    public long fik = 0;
    public long fil = 0;
    public long fim = 0;
    private long fin = 0;
    private long fio = 0;
    public long fip = 0;
    public long fiq = 0;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 14176;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(91041);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.fij);
        stringBuffer.append(",");
        stringBuffer.append(this.fik);
        stringBuffer.append(",");
        stringBuffer.append(this.fil);
        stringBuffer.append(",");
        stringBuffer.append(this.fim);
        stringBuffer.append(",");
        stringBuffer.append(this.fin);
        stringBuffer.append(",");
        stringBuffer.append(this.fio);
        stringBuffer.append(",");
        stringBuffer.append(this.fip);
        stringBuffer.append(",");
        stringBuffer.append(this.fiq);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(91041);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(91042);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("isSuccessful:").append(this.fij);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("scanTime:").append(this.fik);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("focusMode:").append(this.fil);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("totalFrames:").append(this.fim);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("focusTime:").append(this.fin);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("previewStartTime:").append(this.fio);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("hasCodeTime:").append(this.fip);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("scanMode:").append(this.fiq);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(91042);
        return stringBuffer2;
    }
}
