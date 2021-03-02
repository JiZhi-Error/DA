package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class jo extends a {
    private String eQY = "";
    public long eQZ = 0;
    public long eQv = 0;
    public long eQw = 0;
    public long eRK = 0;
    private long eRL = 0;
    private long eRM = 0;
    private long eRN = 0;
    private long eRO = 0;
    private long eRP = 0;
    private long eRQ = 0;
    private long eRR = 0;
    private long eRS = 0;
    public long eRT = 0;
    private long eRU = 0;
    private long eRV = 0;
    private String eiB = "";
    private long elI = 0;
    private String epT = "";
    private long eqk = 0;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 16658;
    }

    public final jo sk(long j2) {
        this.elI = j2;
        return this;
    }

    public final long ahv() {
        return this.elI;
    }

    public final jo sl(long j2) {
        this.eQv = j2;
        return this;
    }

    public final long ahw() {
        return this.eQv;
    }

    public final long ahx() {
        return this.eRK;
    }

    public final jo wS(String str) {
        AppMethodBeat.i(118505);
        this.eQY = x("SourceUserName", str, false);
        AppMethodBeat.o(118505);
        return this;
    }

    public final jo sm(long j2) {
        this.eQw = j2;
        return this;
    }

    public final jo sn(long j2) {
        this.eqk = j2;
        return this;
    }

    public final long ahy() {
        return this.eqk;
    }

    public final jo so(long j2) {
        this.eRL = j2;
        return this;
    }

    public final jo sp(long j2) {
        this.eRM = j2;
        return this;
    }

    public final long ahz() {
        return this.eRM;
    }

    public final jo sq(long j2) {
        this.eRN = j2;
        return this;
    }

    public final long ahA() {
        return this.eRN;
    }

    public final jo sr(long j2) {
        this.eRO = j2;
        return this;
    }

    public final long ahB() {
        return this.eRO;
    }

    public final jo ss(long j2) {
        this.eRP = j2;
        return this;
    }

    public final long ahC() {
        return this.eRP;
    }

    public final jo st(long j2) {
        this.eRQ = j2;
        return this;
    }

    public final long ahD() {
        return this.eRQ;
    }

    public final jo su(long j2) {
        this.eRR = j2;
        return this;
    }

    public final long ahE() {
        return this.eRR;
    }

    public final jo wT(String str) {
        AppMethodBeat.i(118506);
        this.epT = x("ActionTrace", str, true);
        AppMethodBeat.o(118506);
        return this;
    }

    public final jo sv(long j2) {
        this.eRS = j2;
        return this;
    }

    public final long ahF() {
        return this.eRS;
    }

    public final jo wU(String str) {
        AppMethodBeat.i(118507);
        this.eiB = x("SessionId", str, true);
        AppMethodBeat.o(118507);
        return this;
    }

    public final String getSessionId() {
        return this.eiB;
    }

    public final jo sw(long j2) {
        this.eRT = j2;
        return this;
    }

    public final jo sx(long j2) {
        this.eRU = j2;
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(118508);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.elI);
        stringBuffer.append(",");
        stringBuffer.append(this.eQv);
        stringBuffer.append(",");
        stringBuffer.append(this.eRK);
        stringBuffer.append(",");
        stringBuffer.append(this.eQY);
        stringBuffer.append(",");
        stringBuffer.append(this.eQZ);
        stringBuffer.append(",");
        stringBuffer.append(this.eQw);
        stringBuffer.append(",");
        stringBuffer.append(this.eqk);
        stringBuffer.append(",");
        stringBuffer.append(this.eRL);
        stringBuffer.append(",");
        stringBuffer.append(this.eRM);
        stringBuffer.append(",");
        stringBuffer.append(this.eRN);
        stringBuffer.append(",");
        stringBuffer.append(this.eRO);
        stringBuffer.append(",");
        stringBuffer.append(this.eRP);
        stringBuffer.append(",");
        stringBuffer.append(this.eRQ);
        stringBuffer.append(",");
        stringBuffer.append(this.eRR);
        stringBuffer.append(",");
        stringBuffer.append(this.epT);
        stringBuffer.append(",");
        stringBuffer.append(this.eRS);
        stringBuffer.append(",");
        stringBuffer.append(this.eiB);
        stringBuffer.append(",");
        stringBuffer.append(this.eRT);
        stringBuffer.append(",");
        stringBuffer.append(this.eRU);
        stringBuffer.append(",");
        stringBuffer.append(this.eRV);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(118508);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(118509);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("NetType:").append(this.elI);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("PreviewEnterScene:").append(this.eQv);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ProfileSource:").append(this.eRK);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("SourceUserName:").append(this.eQY);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("SourceContactType:").append(this.eQZ);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("HasUnreadStoryTips:").append(this.eQw);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("EnterTime:").append(this.eqk);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ExitTime:").append(this.eRL);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("TotalUserNameCount:").append(this.eRM);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("FriendUserNameCount:").append(this.eRN);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("TotalStoryCount:").append(this.eRO);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("FriendStoryCount:").append(this.eRP);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("TotalBrowserCount:").append(this.eRQ);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("FriendBrowserCount:").append(this.eRR);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ActionTrace:").append(this.epT);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("AllVideoBrowserCountWithRepeat:").append(this.eRS);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("SessionId:").append(this.eiB);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("WaitPlayFriendCount:").append(this.eRT);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("IsShowComment:").append(this.eRU);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("IsInformComment:").append(this.eRV);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(118509);
        return stringBuffer2;
    }
}
