package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class fk extends a {
    private String eFE = "";
    private long eFF;
    private String eFG = "";
    private long eFH;
    private long eFI;
    private long eFJ;
    private int eFK;
    private long eFz;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 19968;
    }

    public final fk nO(long j2) {
        this.eFF = j2;
        return this;
    }

    public final fk sn(String str) {
        AppMethodBeat.i(207434);
        this.eFG = x("micId", str, true);
        AppMethodBeat.o(207434);
        return this;
    }

    public final fk nP(long j2) {
        this.eFz = j2;
        return this;
    }

    public final fk nQ(long j2) {
        this.eFH = j2;
        return this;
    }

    public final fk nR(long j2) {
        this.eFI = j2;
        return this;
    }

    public final fk nS(long j2) {
        this.eFJ = j2;
        return this;
    }

    public final fk ll(int i2) {
        this.eFK = i2;
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(207435);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.eFE);
        stringBuffer.append(",");
        stringBuffer.append(this.eFF);
        stringBuffer.append(",");
        stringBuffer.append(this.eFG);
        stringBuffer.append(",");
        stringBuffer.append(this.eFz);
        stringBuffer.append(",");
        stringBuffer.append(this.eFH);
        stringBuffer.append(",");
        stringBuffer.append(this.eFI);
        stringBuffer.append(",");
        stringBuffer.append(this.eFJ);
        stringBuffer.append(",");
        stringBuffer.append(this.eFK);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(207435);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(207436);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("roomId:").append(this.eFE);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("liveId:").append(this.eFF);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("micId:").append(this.eFG);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("liveRole:").append(this.eFz);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("groupRole:").append(this.eFH);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("linkStatus:").append(this.eFI);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("audienceMode:").append(this.eFJ);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("errorCode:").append(this.eFK);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(207436);
        return stringBuffer2;
    }
}
