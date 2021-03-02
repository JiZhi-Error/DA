package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class fl extends a {
    private long eFL = 0;
    private long eFM;
    private long eFN;
    private String eFO = "";
    private long eFP;
    private long eFQ;
    private long eFR;
    private long eFS;
    private String eFc = "";
    private long eFe;
    private String eFx = "";
    private String eFy = "";
    private long eyI;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 19895;
    }

    public final fl so(String str) {
        AppMethodBeat.i(207437);
        this.eFc = x("roomid", str, true);
        AppMethodBeat.o(207437);
        return this;
    }

    public final fl nT(long j2) {
        this.eyI = j2;
        return this;
    }

    public final fl nU(long j2) {
        this.eFe = j2;
        return this;
    }

    public final fl nV(long j2) {
        this.eFM = j2;
        return this;
    }

    public final fl nW(long j2) {
        this.eFN = j2;
        return this;
    }

    public final fl sp(String str) {
        AppMethodBeat.i(207438);
        this.eFy = x("liveusername", str, true);
        AppMethodBeat.o(207438);
        return this;
    }

    public final fl sq(String str) {
        AppMethodBeat.i(207439);
        this.eFO = x("livemicid", str, true);
        AppMethodBeat.o(207439);
        return this;
    }

    public final fl nX(long j2) {
        this.eFP = j2;
        return this;
    }

    public final fl nY(long j2) {
        this.eFQ = j2;
        return this;
    }

    public final fl nZ(long j2) {
        this.eFR = j2;
        return this;
    }

    public final fl oa(long j2) {
        this.eFS = j2;
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(207440);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.eFc);
        stringBuffer.append(",");
        stringBuffer.append(this.eyI);
        stringBuffer.append(",");
        stringBuffer.append(this.eFL);
        stringBuffer.append(",");
        stringBuffer.append(this.eFx);
        stringBuffer.append(",");
        stringBuffer.append(this.eFe);
        stringBuffer.append(",");
        stringBuffer.append(this.eFM);
        stringBuffer.append(",");
        stringBuffer.append(this.eFN);
        stringBuffer.append(",");
        stringBuffer.append(this.eFy);
        stringBuffer.append(",");
        stringBuffer.append(this.eFO);
        stringBuffer.append(",");
        stringBuffer.append(this.eFP);
        stringBuffer.append(",");
        stringBuffer.append(this.eFQ);
        stringBuffer.append(",");
        stringBuffer.append(this.eFR);
        stringBuffer.append(",");
        stringBuffer.append(this.eFS);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(207440);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(207441);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("roomid:").append(this.eFc);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("liveid:").append(this.eyI);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("micid:").append(this.eFL);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("liveuin:").append(this.eFx);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("lastTime:").append(this.eFe);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("closeRole:").append(this.eFM);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("hasVideo:").append(this.eFN);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("liveusername:").append(this.eFy);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("livemicid:").append(this.eFO);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("StartTimeStamp:").append(this.eFP);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("EndTimeStamp:").append(this.eFQ);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("StartAudienceUV:").append(this.eFR);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("EndAudienceUV:").append(this.eFS);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(207441);
        return stringBuffer2;
    }
}
