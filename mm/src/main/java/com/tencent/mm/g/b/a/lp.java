package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class lp extends a {
    private String eJx = "";
    private String eRc = "";
    private String eZj = "";
    public long eZk;
    public long eZl;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 18837;
    }

    public final lp yW(String str) {
        AppMethodBeat.i(174642);
        this.eJx = x("AppId", str, true);
        AppMethodBeat.o(174642);
        return this;
    }

    public final lp yX(String str) {
        AppMethodBeat.i(174643);
        this.eZj = x("PagePath", str, true);
        AppMethodBeat.o(174643);
        return this;
    }

    public final lp yY(String str) {
        AppMethodBeat.i(174644);
        this.eRc = x("VideoUrl", str, true);
        AppMethodBeat.o(174644);
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(174645);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.eJx);
        stringBuffer.append(",");
        stringBuffer.append(this.eZj);
        stringBuffer.append(",");
        stringBuffer.append(this.eRc);
        stringBuffer.append(",");
        stringBuffer.append(this.eZk);
        stringBuffer.append(",");
        stringBuffer.append(this.eZl);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(174645);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(174646);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("AppId:").append(this.eJx);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("PagePath:").append(this.eZj);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("VideoUrl:").append(this.eRc);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("EventId:").append(this.eZk);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("EventNote:").append(this.eZl);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(174646);
        return stringBuffer2;
    }
}
