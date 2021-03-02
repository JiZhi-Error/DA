package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class gh extends a {
    private long eJn;
    private String eJp = "";
    private long eJr;
    private String eoz = "";
    private long ete;
    private String evo = "";

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 21935;
    }

    public final gh tP(String str) {
        AppMethodBeat.i(200249);
        this.evo = x("ItemId", str, true);
        AppMethodBeat.o(200249);
        return this;
    }

    public final gh qc(long j2) {
        this.eJn = j2;
        return this;
    }

    public final gh qd(long j2) {
        this.eJr = j2;
        return this;
    }

    public final gh qe(long j2) {
        this.ete = j2;
        return this;
    }

    public final gh tQ(String str) {
        AppMethodBeat.i(200250);
        this.eoz = x("ContextId", str, true);
        AppMethodBeat.o(200250);
        return this;
    }

    public final gh tR(String str) {
        AppMethodBeat.i(200251);
        this.eJp = x("ItemSubId", str, true);
        AppMethodBeat.o(200251);
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(200252);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.evo);
        stringBuffer.append(",");
        stringBuffer.append(this.eJn);
        stringBuffer.append(",");
        stringBuffer.append(this.eJr);
        stringBuffer.append(",");
        stringBuffer.append(this.ete);
        stringBuffer.append(",");
        stringBuffer.append(this.eoz);
        stringBuffer.append(",");
        stringBuffer.append(this.eJp);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(200252);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(200253);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("ItemId:").append(this.evo);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ItemType:").append(this.eJn);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("AddType:").append(this.eJr);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Status:").append(this.ete);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ContextId:").append(this.eoz);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ItemSubId:").append(this.eJp);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(200253);
        return stringBuffer2;
    }
}
