package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class fi extends a {
    private long eFA;
    private long eFB;
    private String eFc = "";
    private long eFd;
    private String eFy = "";
    private long eFz;
    private long erw;
    private String evz = "";
    private long eyI;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 19897;
    }

    public final fi sj(String str) {
        AppMethodBeat.i(207426);
        this.eFc = x("roomid", str, true);
        AppMethodBeat.o(207426);
        return this;
    }

    public final fi nG(long j2) {
        this.eyI = j2;
        return this;
    }

    public final fi sk(String str) {
        AppMethodBeat.i(207427);
        this.evz = x("topic", str, true);
        AppMethodBeat.o(207427);
        return this;
    }

    public final fi sl(String str) {
        AppMethodBeat.i(207428);
        this.eFy = x("liveusername", str, true);
        AppMethodBeat.o(207428);
        return this;
    }

    public final fi nH(long j2) {
        this.erw = j2;
        return this;
    }

    public final fi nI(long j2) {
        this.eFz = j2;
        return this;
    }

    public final fi nJ(long j2) {
        this.eFd = j2;
        return this;
    }

    public final fi nK(long j2) {
        this.eFA = j2;
        return this;
    }

    public final fi nL(long j2) {
        this.eFB = j2;
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(207429);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.eFc);
        stringBuffer.append(",");
        stringBuffer.append(this.eyI);
        stringBuffer.append(",");
        stringBuffer.append(this.evz);
        stringBuffer.append(",");
        stringBuffer.append(this.eFy);
        stringBuffer.append(",");
        stringBuffer.append(this.erw);
        stringBuffer.append(",");
        stringBuffer.append(this.eFz);
        stringBuffer.append(",");
        stringBuffer.append(this.eFd);
        stringBuffer.append(",");
        stringBuffer.append(this.eFA);
        stringBuffer.append(",");
        stringBuffer.append(this.eFB);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(207429);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(207430);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("roomid:").append(this.eFc);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("liveid:").append(this.eyI);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("topic:").append(this.evz);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("liveusername:").append(this.eFy);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("scene:").append(this.erw);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("liveRole:").append(this.eFz);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("roomRole:").append(this.eFd);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("replayStatusEnd:").append(this.eFA);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("replayStatusBegin:").append(this.eFB);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(207430);
        return stringBuffer2;
    }
}
