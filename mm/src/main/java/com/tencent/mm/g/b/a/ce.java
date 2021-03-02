package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class ce extends a {
    private String eiC = "";
    private String erU = "";
    private String erV = "";
    private String err = "";
    private long ery;
    private String evb = "";
    private long evc;
    private String evd = "";
    private long eve;
    private long evf;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 20027;
    }

    public final ce fF(long j2) {
        this.ery = j2;
        return this;
    }

    public final ce ll(String str) {
        AppMethodBeat.i(208978);
        this.erU = x("Sessionid", str, true);
        AppMethodBeat.o(208978);
        return this;
    }

    public final ce lm(String str) {
        AppMethodBeat.i(208979);
        this.erV = x("Contextid", str, true);
        AppMethodBeat.o(208979);
        return this;
    }

    public final ce ln(String str) {
        AppMethodBeat.i(208980);
        this.eiC = x("ClickTabContextid", str, true);
        AppMethodBeat.o(208980);
        return this;
    }

    public final ce lo(String str) {
        AppMethodBeat.i(208981);
        this.err = x("FeedId", str, true);
        AppMethodBeat.o(208981);
        return this;
    }

    public final ce lp(String str) {
        AppMethodBeat.i(208982);
        this.evb = x("FlodUsername", str, true);
        AppMethodBeat.o(208982);
        return this;
    }

    public final ce fG(long j2) {
        this.evc = j2;
        return this;
    }

    public final ce lq(String str) {
        AppMethodBeat.i(208983);
        this.evd = x("AllFlodFeedItems", str, true);
        AppMethodBeat.o(208983);
        return this;
    }

    public final String ada() {
        return this.evd;
    }

    public final ce fH(long j2) {
        this.eve = j2;
        return this;
    }

    public final ce fI(long j2) {
        this.evf = j2;
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(208984);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.ery);
        stringBuffer.append(",");
        stringBuffer.append(this.erU);
        stringBuffer.append(",");
        stringBuffer.append(this.erV);
        stringBuffer.append(",");
        stringBuffer.append(this.eiC);
        stringBuffer.append(",");
        stringBuffer.append(this.err);
        stringBuffer.append(",");
        stringBuffer.append(this.evb);
        stringBuffer.append(",");
        stringBuffer.append(this.evc);
        stringBuffer.append(",");
        stringBuffer.append(this.evd);
        stringBuffer.append(",");
        stringBuffer.append(this.eve);
        stringBuffer.append(",");
        stringBuffer.append(this.evf);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(208984);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(208985);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("CommentScene:").append(this.ery);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Sessionid:").append(this.erU);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Contextid:").append(this.erV);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ClickTabContextid:").append(this.eiC);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("FeedId:").append(this.err);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("FlodUsername:").append(this.evb);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("FlodFeedCnt:").append(this.evc);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("AllFlodFeedItems:").append(this.evd);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("MoreTabClickTimestamp:").append(this.eve);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("TopTabClickTimestamp:").append(this.evf);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(208985);
        return stringBuffer2;
    }
}
