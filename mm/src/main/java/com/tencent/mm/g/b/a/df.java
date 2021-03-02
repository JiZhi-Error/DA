package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class df extends a {
    private String els = "";
    private long ezg;
    private long ezh;
    private long ezi;
    private long ezj;
    private long ezk;
    private long ezl;
    private long ezm;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 20372;
    }

    public final df ov(String str) {
        AppMethodBeat.i(209099);
        this.els = x("sessionid", str, true);
        AppMethodBeat.o(209099);
        return this;
    }

    public final df jb(long j2) {
        AppMethodBeat.i(209100);
        this.ezg = j2;
        super.bi("EnterTimeMs", this.ezg);
        AppMethodBeat.o(209100);
        return this;
    }

    public final df jc(long j2) {
        this.ezh = j2;
        return this;
    }

    public final df jd(long j2) {
        this.ezi = j2;
        return this;
    }

    public final df je(long j2) {
        this.ezj = j2;
        return this;
    }

    public final df jf(long j2) {
        this.ezk = j2;
        return this;
    }

    public final df jg(long j2) {
        this.ezl = j2;
        return this;
    }

    public final df jh(long j2) {
        this.ezm = j2;
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(209101);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.els);
        stringBuffer.append(",");
        stringBuffer.append(this.ezg);
        stringBuffer.append(",");
        stringBuffer.append(this.ezh);
        stringBuffer.append(",");
        stringBuffer.append(this.ezi);
        stringBuffer.append(",");
        stringBuffer.append(this.ezj);
        stringBuffer.append(",");
        stringBuffer.append(this.ezk);
        stringBuffer.append(",");
        stringBuffer.append(this.ezl);
        stringBuffer.append(",");
        stringBuffer.append(this.ezm);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(209101);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(209102);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("sessionid:").append(this.els);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("EnterTimeMs:").append(this.ezg);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("IsRedDotEnter:").append(this.ezh);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Event:").append(this.ezi);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("BannerType:").append(this.ezj);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("EventTime:").append(this.ezk);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("IsHaveRedDot:").append(this.ezl);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("MsgCnt:").append(this.ezm);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(209102);
        return stringBuffer2;
    }
}
