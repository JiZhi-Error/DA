package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class bq extends a {
    private String eiB = "";
    private String err = "";
    private String esL = "";
    private String esS = "";
    private String esT = "";
    private long esU;
    private long esV;
    private long etp;
    private long etq;
    private String etr = "";
    private long ets;
    private long ett;
    private long etu;
    private String etv = "";
    private long etw;
    private String etx = "";
    private String ety = "";

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 18944;
    }

    public final bq jP(String str) {
        AppMethodBeat.i(208903);
        this.eiB = x("SessionId", str, true);
        AppMethodBeat.o(208903);
        return this;
    }

    public final bq eq(long j2) {
        this.etp = j2;
        return this;
    }

    public final bq er(long j2) {
        this.etq = j2;
        return this;
    }

    public final bq jQ(String str) {
        AppMethodBeat.i(208904);
        this.etr = x("SourceUsr", str, true);
        AppMethodBeat.o(208904);
        return this;
    }

    public final bq jR(String str) {
        AppMethodBeat.i(208905);
        this.err = x("FeedId", str, true);
        AppMethodBeat.o(208905);
        return this;
    }

    public final bq jS(String str) {
        AppMethodBeat.i(208906);
        this.esL = x("FeedUsr", str, true);
        AppMethodBeat.o(208906);
        return this;
    }

    public final bq jT(String str) {
        AppMethodBeat.i(208907);
        this.esS = x("Tag", str, true);
        AppMethodBeat.o(208907);
        return this;
    }

    public final bq es(long j2) {
        this.ets = j2;
        return this;
    }

    public final bq et(long j2) {
        this.ett = j2;
        return this;
    }

    public final bq eu(long j2) {
        this.etu = j2;
        return this;
    }

    public final bq jU(String str) {
        AppMethodBeat.i(208908);
        this.etv = x("GroupID", str, true);
        AppMethodBeat.o(208908);
        return this;
    }

    public final bq ev(long j2) {
        this.etw = j2;
        return this;
    }

    public final bq jV(String str) {
        AppMethodBeat.i(208909);
        this.etx = x("ColumnId", str, true);
        AppMethodBeat.o(208909);
        return this;
    }

    public final bq jW(String str) {
        AppMethodBeat.i(208910);
        this.ety = x("ActivityID", str, true);
        AppMethodBeat.o(208910);
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(208911);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.eiB);
        stringBuffer.append(",");
        stringBuffer.append(this.etp);
        stringBuffer.append(",");
        stringBuffer.append(this.etq);
        stringBuffer.append(",");
        stringBuffer.append(this.etr);
        stringBuffer.append(",");
        stringBuffer.append(this.err);
        stringBuffer.append(",");
        stringBuffer.append(this.esL);
        stringBuffer.append(",");
        stringBuffer.append(this.esS);
        stringBuffer.append(",");
        stringBuffer.append(this.esT);
        stringBuffer.append(",");
        stringBuffer.append(this.esU);
        stringBuffer.append(",");
        stringBuffer.append(this.esV);
        stringBuffer.append(",");
        stringBuffer.append(this.ets);
        stringBuffer.append(",");
        stringBuffer.append(this.ett);
        stringBuffer.append(",");
        stringBuffer.append(this.etu);
        stringBuffer.append(",");
        stringBuffer.append(this.etv);
        stringBuffer.append(",");
        stringBuffer.append(this.etw);
        stringBuffer.append(",");
        stringBuffer.append(this.etx);
        stringBuffer.append(",");
        stringBuffer.append(this.ety);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(208911);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(208912);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("SessionId:").append(this.eiB);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("EnterScene:").append(this.etp);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("CardType:").append(this.etq);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("SourceUsr:").append(this.etr);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("FeedId:").append(this.err);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("FeedUsr:").append(this.esL);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Tag:").append(this.esS);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("TagId:").append(this.esT);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("IsPoi:").append(this.esU);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("TagFeedCnt:").append(this.esV);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("IsHaveCover:").append(this.ets);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("IsCgiEnd:").append(this.ett);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("UIType:").append(this.etu);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("GroupID:").append(this.etv);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("TrackType:").append(this.etw);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ColumnId:").append(this.etx);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ActivityID:").append(this.ety);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(208912);
        return stringBuffer2;
    }
}
