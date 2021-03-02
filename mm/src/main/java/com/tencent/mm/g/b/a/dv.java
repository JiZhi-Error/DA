package com.tencent.mm.g.b.a;

import com.google.android.gms.actions.SearchIntents;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class dv extends a {
    private String eBO = "";
    private String eBP = "";
    private String eBQ = "";
    private long eBR;
    private long eBS;
    private long eBT;
    private long eBU;
    private long eBV;
    private long eiE;
    private String ekG = "";
    private String erH = "";
    private long esb;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 21690;
    }

    public final dv qa(String str) {
        AppMethodBeat.i(209187);
        this.ekG = x("sessionId", str, true);
        AppMethodBeat.o(209187);
        return this;
    }

    public final dv qb(String str) {
        AppMethodBeat.i(209188);
        this.erH = x("ClickTabContextId", str, true);
        AppMethodBeat.o(209188);
        return this;
    }

    public final dv afh() {
        this.esb = 1;
        return this;
    }

    public final dv qc(String str) {
        AppMethodBeat.i(209189);
        this.eBO = x("searchSessionId", str, true);
        AppMethodBeat.o(209189);
        return this;
    }

    public final dv qd(String str) {
        AppMethodBeat.i(209190);
        this.eBP = x("requestId", str, true);
        AppMethodBeat.o(209190);
        return this;
    }

    public final dv qe(String str) {
        AppMethodBeat.i(209191);
        this.eBQ = x(SearchIntents.EXTRA_QUERY, str, true);
        AppMethodBeat.o(209191);
        return this;
    }

    public final dv kV(long j2) {
        this.eBR = j2;
        return this;
    }

    public final dv kW(long j2) {
        this.eBS = j2;
        return this;
    }

    public final dv kX(long j2) {
        this.eiE = j2;
        return this;
    }

    public final dv kY(long j2) {
        this.eBT = j2;
        return this;
    }

    public final dv kZ(long j2) {
        this.eBU = j2;
        return this;
    }

    public final dv la(long j2) {
        this.eBV = j2;
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(209192);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.ekG);
        stringBuffer.append(",");
        stringBuffer.append(this.erH);
        stringBuffer.append(",");
        stringBuffer.append(this.esb);
        stringBuffer.append(",");
        stringBuffer.append(this.eBO);
        stringBuffer.append(",");
        stringBuffer.append(this.eBP);
        stringBuffer.append(",");
        stringBuffer.append(this.eBQ);
        stringBuffer.append(",");
        stringBuffer.append(this.eBR);
        stringBuffer.append(",");
        stringBuffer.append(this.eBS);
        stringBuffer.append(",");
        stringBuffer.append(this.eiE);
        stringBuffer.append(",");
        stringBuffer.append(this.eBT);
        stringBuffer.append(",");
        stringBuffer.append(this.eBU);
        stringBuffer.append(",");
        stringBuffer.append(this.eBV);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(209192);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(209193);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("sessionId:").append(this.ekG);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ClickTabContextId:").append(this.erH);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("myAccountType:").append(this.esb);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("searchSessionId:").append(this.eBO);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("requestId:").append(this.eBP);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("query:").append(this.eBQ);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("searchScene:").append(this.eBR);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("searchType:").append(this.eBS);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("commentScene:").append(this.eiE);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("searchResultType:").append(this.eBT);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("isAccountEmpty:").append(this.eBU);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("isFeedEmpty:").append(this.eBV);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(209193);
        return stringBuffer2;
    }
}
