package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class gi extends a {
    private long eJn;
    private String eJp = "";
    private String eoz = "";
    private String evo = "";
    private long ewu;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 21947;
    }

    public final gi tS(String str) {
        AppMethodBeat.i(200254);
        this.eoz = x("ContextId", str, true);
        AppMethodBeat.o(200254);
        return this;
    }

    public final gi tT(String str) {
        AppMethodBeat.i(200255);
        this.evo = x("ItemId", str, true);
        AppMethodBeat.o(200255);
        return this;
    }

    public final gi qf(long j2) {
        this.eJn = j2;
        return this;
    }

    public final gi tU(String str) {
        AppMethodBeat.i(200256);
        this.eJp = x("ItemSubId", str, true);
        AppMethodBeat.o(200256);
        return this;
    }

    public final gi qg(long j2) {
        this.ewu = j2;
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(200257);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.eoz);
        stringBuffer.append(",");
        stringBuffer.append(this.evo);
        stringBuffer.append(",");
        stringBuffer.append(this.eJn);
        stringBuffer.append(",");
        stringBuffer.append(this.eJp);
        stringBuffer.append(",");
        stringBuffer.append(this.ewu);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(200257);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(200258);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("ContextId:").append(this.eoz);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ItemId:").append(this.evo);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ItemType:").append(this.eJn);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ItemSubId:").append(this.eJp);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Duration:").append(this.ewu);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(200258);
        return stringBuffer2;
    }
}
