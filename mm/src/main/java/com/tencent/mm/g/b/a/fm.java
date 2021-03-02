package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class fm extends a {
    private long eFT = 0;
    private long eFU;
    private String eFV = "";
    private String eFW = "";
    private long eFX;
    private String eFc = "";
    private long eFd;
    private long eFz;
    private long ejW;
    private long elz;
    private long eyI;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 19893;
    }

    public final fm sr(String str) {
        AppMethodBeat.i(207442);
        this.eFc = x("roomid", str, true);
        AppMethodBeat.o(207442);
        return this;
    }

    public final fm ob(long j2) {
        this.eyI = j2;
        return this;
    }

    public final fm oc(long j2) {
        this.eFz = j2;
        return this;
    }

    public final fm od(long j2) {
        this.eFd = j2;
        return this;
    }

    public final fm oe(long j2) {
        this.ejW = j2;
        return this;
    }

    public final fm of(long j2) {
        this.eFU = j2;
        return this;
    }

    public final fm og(long j2) {
        this.elz = j2;
        return this;
    }

    public final fm ss(String str) {
        AppMethodBeat.i(207443);
        this.eFV = x("audienceUserName", str, true);
        AppMethodBeat.o(207443);
        return this;
    }

    public final fm st(String str) {
        AppMethodBeat.i(207444);
        this.eFW = x("anchorusername", str, true);
        AppMethodBeat.o(207444);
        return this;
    }

    public final fm oh(long j2) {
        this.eFX = j2;
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(207445);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.eFc);
        stringBuffer.append(",");
        stringBuffer.append(this.eyI);
        stringBuffer.append(",");
        stringBuffer.append(this.eFT);
        stringBuffer.append(",");
        stringBuffer.append(this.eFz);
        stringBuffer.append(",");
        stringBuffer.append(this.eFd);
        stringBuffer.append(",");
        stringBuffer.append(this.ejW);
        stringBuffer.append(",");
        stringBuffer.append(this.eFU);
        stringBuffer.append(",");
        stringBuffer.append(this.elz);
        stringBuffer.append(",");
        stringBuffer.append(this.eFV);
        stringBuffer.append(",");
        stringBuffer.append(this.eFW);
        stringBuffer.append(",");
        stringBuffer.append(this.eFX);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(207445);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(207446);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("roomid:").append(this.eFc);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("liveid:").append(this.eyI);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("audienceUin:").append(this.eFT);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("liveRole:").append(this.eFz);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("roomRole:").append(this.eFd);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("action:").append(this.ejW);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("actionResult:").append(this.eFU);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("actionTS:").append(this.elz);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("audienceUserName:").append(this.eFV);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("anchorusername:").append(this.eFW);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("audiencecount:").append(this.eFX);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(207446);
        return stringBuffer2;
    }
}
