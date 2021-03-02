package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class fe extends a {
    private String eFc = "";
    private long eFd;
    private long eFe = 0;
    private long eFf;
    private long eFg;
    private long eFh;
    private long eFi;
    private long eFj;
    private long eFk;
    private long eFl;
    private long eFm;
    private long erw;
    private String evz = "";
    private long eyI;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 19891;
    }

    public final fe afX() {
        this.erw = 1;
        return this;
    }

    public final fe sb(String str) {
        AppMethodBeat.i(207410);
        this.eFc = x("roomid", str, true);
        AppMethodBeat.o(207410);
        return this;
    }

    public final fe ng(long j2) {
        this.eyI = j2;
        return this;
    }

    public final fe sc(String str) {
        AppMethodBeat.i(207411);
        this.evz = x("topic", str, true);
        AppMethodBeat.o(207411);
        return this;
    }

    public final fe nh(long j2) {
        this.eFd = j2;
        return this;
    }

    public final fe ni(long j2) {
        this.eFf = j2;
        return this;
    }

    public final fe nj(long j2) {
        this.eFg = j2;
        return this;
    }

    public final fe nk(long j2) {
        this.eFh = j2;
        return this;
    }

    public final fe nl(long j2) {
        this.eFi = j2;
        return this;
    }

    public final fe nm(long j2) {
        this.eFj = j2;
        return this;
    }

    public final fe nn(long j2) {
        this.eFk = j2;
        return this;
    }

    public final fe no(long j2) {
        this.eFl = j2;
        return this;
    }

    public final fe np(long j2) {
        this.eFm = j2;
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(207412);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.erw);
        stringBuffer.append(",");
        stringBuffer.append(this.eFc);
        stringBuffer.append(",");
        stringBuffer.append(this.eyI);
        stringBuffer.append(",");
        stringBuffer.append(this.evz);
        stringBuffer.append(",");
        stringBuffer.append(this.eFd);
        stringBuffer.append(",");
        stringBuffer.append(this.eFe);
        stringBuffer.append(",");
        stringBuffer.append(this.eFf);
        stringBuffer.append(",");
        stringBuffer.append(this.eFg);
        stringBuffer.append(",");
        stringBuffer.append(this.eFh);
        stringBuffer.append(",");
        stringBuffer.append(this.eFi);
        stringBuffer.append(",");
        stringBuffer.append(this.eFj);
        stringBuffer.append(",");
        stringBuffer.append(this.eFk);
        stringBuffer.append(",");
        stringBuffer.append(this.eFl);
        stringBuffer.append(",");
        stringBuffer.append(this.eFm);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(207412);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(207413);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("scene:").append(this.erw);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("roomid:").append(this.eFc);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("liveid:").append(this.eyI);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("topic:").append(this.evz);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("roomRole:").append(this.eFd);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("lastTime:").append(this.eFe);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("audienceCount:").append(this.eFf);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("audienceCountMax:").append(this.eFg);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("commentCount:").append(this.eFh);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("heartCount:").append(this.eFi);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("connectCount:").append(this.eFj);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("allowReplay:").append(this.eFk);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("roomCount:").append(this.eFl);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("costTime:").append(this.eFm);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(207413);
        return stringBuffer2;
    }
}
