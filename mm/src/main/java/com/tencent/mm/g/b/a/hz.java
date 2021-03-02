package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class hz extends a {
    public long eLd = 0;
    public int eMF = 0;
    public long eMG = 0;
    public long eMH = 0;
    private String eMI = "";
    private String euw = "";

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 17193;
    }

    public final hz vJ(String str) {
        AppMethodBeat.i(121779);
        this.euw = x("PName", str, true);
        AppMethodBeat.o(121779);
        return this;
    }

    public final hz vK(String str) {
        AppMethodBeat.i(121780);
        this.eMI = x("DataContent", str, true);
        AppMethodBeat.o(121780);
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(121781);
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
        AppMethodBeat.o(121781);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(121782);
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
        AppMethodBeat.o(121782);
        return stringBuffer2;
    }
}
