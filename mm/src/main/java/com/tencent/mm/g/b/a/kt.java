package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class kt extends a {
    public long eXk = 0;
    public long eXl = 0;
    private String eXm = "";
    public long eXn = 0;
    private String eXo = "";
    private String eXp = "";
    public long ejA = 0;
    private String eoC = "";
    private String erD = "";
    public long eua = 0;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 21192;
    }

    public final kt yh(String str) {
        AppMethodBeat.i(187795);
        this.eXm = x("FeedAuthorUsername", str, true);
        AppMethodBeat.o(187795);
        return this;
    }

    public final kt yi(String str) {
        AppMethodBeat.i(187796);
        this.erD = x("FeedID", str, true);
        AppMethodBeat.o(187796);
        return this;
    }

    public final kt yj(String str) {
        AppMethodBeat.i(187797);
        this.eXo = x("CreatedCommentID", str, true);
        AppMethodBeat.o(187797);
        return this;
    }

    public final kt yk(String str) {
        AppMethodBeat.i(187798);
        this.eoC = x("SessionID", str, true);
        AppMethodBeat.o(187798);
        return this;
    }

    public final kt yl(String str) {
        AppMethodBeat.i(187799);
        this.eXp = x("QueryKey", str, true);
        AppMethodBeat.o(187799);
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(187800);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.eXk);
        stringBuffer.append(",");
        stringBuffer.append(this.eXl);
        stringBuffer.append(",");
        stringBuffer.append(this.eXm);
        stringBuffer.append(",");
        stringBuffer.append(this.erD);
        stringBuffer.append(",");
        stringBuffer.append(this.eXn);
        stringBuffer.append(",");
        stringBuffer.append(this.eXo);
        stringBuffer.append(",");
        stringBuffer.append(this.eoC);
        stringBuffer.append(",");
        stringBuffer.append(this.ejA);
        stringBuffer.append(",");
        stringBuffer.append(this.eXp);
        stringBuffer.append(",");
        stringBuffer.append(this.eua);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(187800);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(187801);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("ActionScene:").append(this.eXk);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("EnterSource:").append(this.eXl);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("FeedAuthorUsername:").append(this.eXm);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("FeedID:").append(this.erD);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("FeedAuthorType:").append(this.eXn);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("CreatedCommentID:").append(this.eXo);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("SessionID:").append(this.eoC);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Action:").append(this.ejA);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("QueryKey:").append(this.eXp);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ActionTimeStamp:").append(this.eua);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(187801);
        return stringBuffer2;
    }
}
