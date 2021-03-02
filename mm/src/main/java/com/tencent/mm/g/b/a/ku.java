package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class ku extends a {
    private String eXq = "";
    public long eXr = 0;
    private long eXs = 0;
    private long eXt = 0;
    private String eXu = "";
    public long eXv = 0;
    private String eXw = "";
    public long erW = 0;
    public long evl = 0;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 14404;
    }

    public final ku ym(String str) {
        AppMethodBeat.i(149932);
        this.eXq = x("BiilNo", str, true);
        AppMethodBeat.o(149932);
        return this;
    }

    public final ku yn(String str) {
        AppMethodBeat.i(149933);
        this.eXu = x("content", str, true);
        AppMethodBeat.o(149933);
        return this;
    }

    public final ku yo(String str) {
        AppMethodBeat.i(149934);
        this.eXw = x("packId", str, true);
        AppMethodBeat.o(149934);
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(149935);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.erW);
        stringBuffer.append(",");
        stringBuffer.append(this.eXq);
        stringBuffer.append(",");
        stringBuffer.append(this.eXr);
        stringBuffer.append(",");
        stringBuffer.append(this.eXs);
        stringBuffer.append(",");
        stringBuffer.append(this.evl);
        stringBuffer.append(",");
        stringBuffer.append(this.eXt);
        stringBuffer.append(",");
        stringBuffer.append(this.eXu);
        stringBuffer.append(",");
        stringBuffer.append(this.eXv);
        stringBuffer.append(",");
        stringBuffer.append(this.eXw);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(149935);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(149936);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Scene:").append(this.erW);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("BiilNo:").append(this.eXq);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("failReason:").append(this.eXr);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("playerErrCode:").append(this.eXs);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("type:").append(this.evl);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("retCode:").append(this.eXt);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("content:").append(this.eXu);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("amount:").append(this.eXv);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("packId:").append(this.eXw);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(149936);
        return stringBuffer2;
    }
}
