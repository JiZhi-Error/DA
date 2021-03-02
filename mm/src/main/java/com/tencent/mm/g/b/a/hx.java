package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class hx extends a {
    public long eLd = 0;
    public int eMF = 0;
    public long eMG = 0;
    public long eMH = 0;
    private String eMI = "";
    private String euw = "";

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 16976;
    }

    public final hx vF(String str) {
        AppMethodBeat.i(121771);
        this.euw = x("PName", str, true);
        AppMethodBeat.o(121771);
        return this;
    }

    public final hx vG(String str) {
        AppMethodBeat.i(121772);
        this.eMI = x("DataContent", str, false);
        AppMethodBeat.o(121772);
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(121773);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.eMF);
        stringBuffer.append(",");
        stringBuffer.append(this.euw);
        stringBuffer.append(",");
        stringBuffer.append(this.eLd);
        stringBuffer.append(",");
        stringBuffer.append(this.eMG);
        stringBuffer.append(",");
        stringBuffer.append(this.eMH);
        stringBuffer.append(",");
        stringBuffer.append(this.eMI);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(121773);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(121774);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("PId:").append(this.eMF);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("PName:").append(this.euw);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Seq:").append(this.eLd);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("SubSeq:").append(this.eMG);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("SubSeqSum:").append(this.eMH);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("DataContent:").append(this.eMI);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(121774);
        return stringBuffer2;
    }
}
