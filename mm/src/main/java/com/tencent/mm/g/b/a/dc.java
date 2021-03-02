package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class dc extends a {
    private String eiB = "";
    private long eyO;
    private long eyP;
    private long eyQ;
    private long eyR;
    private long eyS;
    private long eyT;
    private long eyU;
    private long eyV;
    private long eyW;
    private long eyX;
    private long eyY;
    private long eyZ;
    private long eza;
    private long ezb;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 19948;
    }

    public final dc ok(String str) {
        AppMethodBeat.i(209088);
        this.eiB = x("SessionId", str, true);
        AppMethodBeat.o(209088);
        return this;
    }

    public final dc iL(long j2) {
        this.eyP = j2;
        return this;
    }

    public final long aeP() {
        return this.eyP;
    }

    public final dc iM(long j2) {
        this.eyQ = j2;
        return this;
    }

    public final long aeQ() {
        return this.eyQ;
    }

    public final dc iN(long j2) {
        this.eyR = j2;
        return this;
    }

    public final long aeR() {
        return this.eyR;
    }

    public final dc iO(long j2) {
        this.eyS = j2;
        return this;
    }

    public final long aeS() {
        return this.eyS;
    }

    public final dc iP(long j2) {
        this.eyT = j2;
        return this;
    }

    public final long aeT() {
        return this.eyT;
    }

    public final dc iQ(long j2) {
        this.eyU = j2;
        return this;
    }

    public final long aeU() {
        return this.eyU;
    }

    public final dc iR(long j2) {
        this.eyV = j2;
        return this;
    }

    public final long aeV() {
        return this.eyV;
    }

    public final dc iS(long j2) {
        this.eyW = j2;
        return this;
    }

    public final long aeW() {
        return this.eyW;
    }

    public final dc iT(long j2) {
        this.eyX = j2;
        return this;
    }

    public final long aeX() {
        return this.eyX;
    }

    public final dc iU(long j2) {
        this.eyY = j2;
        return this;
    }

    public final long aeY() {
        return this.eyY;
    }

    public final dc iV(long j2) {
        this.eyZ = j2;
        return this;
    }

    public final long aeZ() {
        return this.eyZ;
    }

    public final dc iW(long j2) {
        this.eza = j2;
        return this;
    }

    public final long afa() {
        return this.eza;
    }

    public final dc iX(long j2) {
        this.ezb = j2;
        return this;
    }

    public final dc afb() {
        this.eyO = 2;
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(209089);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.eiB);
        stringBuffer.append(",");
        stringBuffer.append(this.eyP);
        stringBuffer.append(",");
        stringBuffer.append(this.eyQ);
        stringBuffer.append(",");
        stringBuffer.append(this.eyR);
        stringBuffer.append(",");
        stringBuffer.append(this.eyS);
        stringBuffer.append(",");
        stringBuffer.append(this.eyT);
        stringBuffer.append(",");
        stringBuffer.append(this.eyU);
        stringBuffer.append(",");
        stringBuffer.append(this.eyV);
        stringBuffer.append(",");
        stringBuffer.append(this.eyW);
        stringBuffer.append(",");
        stringBuffer.append(this.eyX);
        stringBuffer.append(",");
        stringBuffer.append(this.eyY);
        stringBuffer.append(",");
        stringBuffer.append(this.eyZ);
        stringBuffer.append(",");
        stringBuffer.append(this.eza);
        stringBuffer.append(",");
        stringBuffer.append(this.ezb);
        stringBuffer.append(",");
        stringBuffer.append(this.eyO);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(209089);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(209090);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("SessionId:").append(this.eiB);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("FetchNewCount:").append(this.eyP);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("BrowseTotalCount:").append(this.eyQ);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("BrowseNewCount:").append(this.eyR);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("BrowseOldCount:").append(this.eyS);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("BrowseNewFollowCount:").append(this.eyT);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("BrowseNewLikeCount:").append(this.eyU);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("BrowseNewCommentCount:").append(this.eyV);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("BrowseNewAtCount:").append(this.eyW);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("BrowseOldFollowCount:").append(this.eyX);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("BrowseOldLikeCount:").append(this.eyY);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("BrowseOldCommentCount:").append(this.eyZ);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("BrowseOldAtCount:").append(this.eza);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("BrowseDuration:").append(this.ezb);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("TabType:").append(this.eyO);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(209090);
        return stringBuffer2;
    }
}
