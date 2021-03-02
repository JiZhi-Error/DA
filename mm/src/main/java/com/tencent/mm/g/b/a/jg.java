package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class jg extends a {
    private String eQY = "";
    public long eQZ = 0;
    private long eQv = 0;
    private long eQw = 0;
    private long eRa = 0;
    private long elI = 0;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 16659;
    }

    public final jg rL(long j2) {
        this.elI = j2;
        return this;
    }

    public final jg rM(long j2) {
        this.eQv = j2;
        return this;
    }

    public final jg wJ(String str) {
        AppMethodBeat.i(118485);
        this.eQY = x("SourceUserName", str, true);
        AppMethodBeat.o(118485);
        return this;
    }

    public final jg ahn() {
        this.eQw = 1;
        return this;
    }

    public final jg aho() {
        this.eRa = 1;
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(118486);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.elI);
        stringBuffer.append(",");
        stringBuffer.append(this.eQv);
        stringBuffer.append(",");
        stringBuffer.append(this.eQY);
        stringBuffer.append(",");
        stringBuffer.append(this.eQZ);
        stringBuffer.append(",");
        stringBuffer.append(this.eQw);
        stringBuffer.append(",");
        stringBuffer.append(this.eRa);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(118486);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(118487);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("NetType:").append(this.elI);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("PreviewEnterScene:").append(this.eQv);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("SourceUserName:").append(this.eQY);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("SourceContactType:").append(this.eQZ);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("HasUnreadStoryTips:").append(this.eQw);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("HasEnterPreview:").append(this.eRa);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(118487);
        return stringBuffer2;
    }
}
