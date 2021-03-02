package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class bu extends a {
    private String eoz = "";
    private String erH = "";
    private long ery;
    private String etS = "";

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 21726;
    }

    public final bu kh(String str) {
        AppMethodBeat.i(208913);
        this.etS = x("feedID", str, true);
        AppMethodBeat.o(208913);
        return this;
    }

    public final bu eH(long j2) {
        this.ery = j2;
        return this;
    }

    public final bu ki(String str) {
        AppMethodBeat.i(208914);
        this.erH = x("ClickTabContextId", str, true);
        AppMethodBeat.o(208914);
        return this;
    }

    public final bu kj(String str) {
        AppMethodBeat.i(208915);
        this.eoz = x("ContextId", str, true);
        AppMethodBeat.o(208915);
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(208916);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.etS);
        stringBuffer.append(",");
        stringBuffer.append(this.ery);
        stringBuffer.append(",");
        stringBuffer.append(this.erH);
        stringBuffer.append(",");
        stringBuffer.append(this.eoz);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(208916);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(208917);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("feedID:").append(this.etS);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("CommentScene:").append(this.ery);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ClickTabContextId:").append(this.erH);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ContextId:").append(this.eoz);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(208917);
        return stringBuffer2;
    }
}
