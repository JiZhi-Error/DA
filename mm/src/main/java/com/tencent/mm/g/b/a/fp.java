package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class fp extends a {
    private String eFc = "";
    private long eFe;
    private long eFh;
    private long eFi;
    private long eFj;
    private long eFw;
    private String eFx = "";
    private String eFy = "";
    private long eGJ;
    private long eGK;
    private long eGL;
    private long eGM;
    private long eGN;
    private long eGO;
    private long erw;
    private long eyI;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 19892;
    }

    public final fp oT(long j2) {
        this.erw = j2;
        return this;
    }

    public final fp sB(String str) {
        AppMethodBeat.i(207452);
        this.eFc = x("roomid", str, true);
        AppMethodBeat.o(207452);
        return this;
    }

    public final fp oU(long j2) {
        this.eyI = j2;
        return this;
    }

    public final fp oV(long j2) {
        this.eFw = j2;
        return this;
    }

    public final fp oW(long j2) {
        this.eGJ = j2;
        return this;
    }

    public final fp oX(long j2) {
        this.eGK = j2;
        return this;
    }

    public final fp oY(long j2) {
        this.eFh = j2;
        return this;
    }

    public final fp oZ(long j2) {
        this.eFi = j2;
        return this;
    }

    public final fp pa(long j2) {
        this.eGL = j2;
        return this;
    }

    public final fp pb(long j2) {
        this.eFj = j2;
        return this;
    }

    public final fp sC(String str) {
        AppMethodBeat.i(207453);
        this.eFy = x("liveusername", str, true);
        AppMethodBeat.o(207453);
        return this;
    }

    public final fp pc(long j2) {
        this.eFe = j2;
        return this;
    }

    public final fp pd(long j2) {
        this.eGM = j2;
        return this;
    }

    public final long agA() {
        return this.eGM;
    }

    public final fp pe(long j2) {
        this.eGN = j2;
        return this;
    }

    public final long agB() {
        return this.eGN;
    }

    public final fp pf(long j2) {
        this.eGO = j2;
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(207454);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.erw);
        stringBuffer.append(",");
        stringBuffer.append(this.eFc);
        stringBuffer.append(",");
        stringBuffer.append(this.eyI);
        stringBuffer.append(",");
        stringBuffer.append(this.eFx);
        stringBuffer.append(",");
        stringBuffer.append(this.eFw);
        stringBuffer.append(",");
        stringBuffer.append(this.eGJ);
        stringBuffer.append(",");
        stringBuffer.append(this.eGK);
        stringBuffer.append(",");
        stringBuffer.append(this.eFh);
        stringBuffer.append(",");
        stringBuffer.append(this.eFi);
        stringBuffer.append(",");
        stringBuffer.append(this.eGL);
        stringBuffer.append(",");
        stringBuffer.append(this.eFj);
        stringBuffer.append(",");
        stringBuffer.append(this.eFy);
        stringBuffer.append(",");
        stringBuffer.append(this.eFe);
        stringBuffer.append(",");
        stringBuffer.append(this.eGM);
        stringBuffer.append(",");
        stringBuffer.append(this.eGN);
        stringBuffer.append(",");
        stringBuffer.append(this.eGO);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(207454);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(207455);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("scene:").append(this.erw);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("roomid:").append(this.eFc);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("liveid:").append(this.eyI);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("liveuin:").append(this.eFx);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("errcode:").append(this.eFw);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("enterRoomCount:").append(this.eGJ);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("exitRoomCount:").append(this.eGK);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("commentCount:").append(this.eFh);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("heartCount:").append(this.eFi);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("connectReqCount:").append(this.eGL);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("connectCount:").append(this.eFj);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("liveusername:").append(this.eFy);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("lastTime:").append(this.eFe);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("enterTimestamp:").append(this.eGM);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("exitTimestamp:").append(this.eGN);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("exitChatroomUV:").append(this.eGO);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(207455);
        return stringBuffer2;
    }
}
