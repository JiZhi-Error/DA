package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class cf extends a {
    private String eoo = "";
    private String eoz = "";
    private String erH = "";
    private String erU = "";
    private String err = "";
    private long ers;
    private long ert;
    private long eru;
    private String erv = "";
    private long erw;
    private long erx;
    private String esL = "";
    private long esP;
    private long esQ;
    private long esR;
    private String esS = "";
    private String esT = "";
    private long esU;
    private long esV;
    private String esZ = "";
    private String eta = "";
    private String etv = "";
    private long etw;
    private String etx = "";
    private String ety = "";
    private String eui = "";
    private long evg;
    private long evh;
    private String evi = "";
    private String evj = "";
    private long evk;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 18941;
    }

    public final cf lr(String str) {
        AppMethodBeat.i(168893);
        this.erU = x("Sessionid", str, true);
        AppMethodBeat.o(168893);
        return this;
    }

    public final cf fJ(long j2) {
        this.evg = j2;
        return this;
    }

    public final cf fK(long j2) {
        this.evh = j2;
        return this;
    }

    public final cf ls(String str) {
        AppMethodBeat.i(168894);
        this.err = x("FeedId", str, true);
        AppMethodBeat.o(168894);
        return this;
    }

    public final cf lt(String str) {
        AppMethodBeat.i(168895);
        this.esL = x("FeedUsr", str, true);
        AppMethodBeat.o(168895);
        return this;
    }

    public final cf lu(String str) {
        AppMethodBeat.i(168896);
        this.evj = x("ForwardToUsr", str, true);
        AppMethodBeat.o(168896);
        return this;
    }

    public final cf fL(long j2) {
        this.ers = j2;
        return this;
    }

    public final cf fM(long j2) {
        this.ert = j2;
        return this;
    }

    public final cf fN(long j2) {
        this.eru = j2;
        return this;
    }

    public final cf lv(String str) {
        AppMethodBeat.i(168897);
        this.erv = x("CurrentPageName", str, true);
        AppMethodBeat.o(168897);
        return this;
    }

    public final cf fO(long j2) {
        this.erx = j2;
        return this;
    }

    public final cf lw(String str) {
        AppMethodBeat.i(168898);
        this.esS = x("Tag", str, true);
        AppMethodBeat.o(168898);
        return this;
    }

    public final cf lx(String str) {
        AppMethodBeat.i(168899);
        this.esT = x("TagId", str, true);
        AppMethodBeat.o(168899);
        return this;
    }

    public final cf fP(long j2) {
        this.erw = j2;
        return this;
    }

    public final cf ly(String str) {
        AppMethodBeat.i(208986);
        this.erH = x("ClickTabContextId", str, true);
        AppMethodBeat.o(208986);
        return this;
    }

    public final cf lz(String str) {
        AppMethodBeat.i(208987);
        this.eoz = x("ContextId", str, true);
        AppMethodBeat.o(208987);
        return this;
    }

    public final cf lA(String str) {
        AppMethodBeat.i(208988);
        this.eoo = x("SessionBuffer", str, true);
        AppMethodBeat.o(208988);
        return this;
    }

    public final cf fQ(long j2) {
        this.evk = j2;
        return this;
    }

    public final cf lB(String str) {
        AppMethodBeat.i(208989);
        this.esZ = x("ExtraInfo", str, true);
        AppMethodBeat.o(208989);
        return this;
    }

    public final cf lC(String str) {
        AppMethodBeat.i(208990);
        this.eta = x("enterSourceInfo", str, true);
        AppMethodBeat.o(208990);
        return this;
    }

    public final cf lD(String str) {
        AppMethodBeat.i(208991);
        this.eui = x("LongVideoId", str, true);
        AppMethodBeat.o(208991);
        return this;
    }

    public final cf lE(String str) {
        AppMethodBeat.i(208992);
        this.etv = x("GroupID", str, true);
        AppMethodBeat.o(208992);
        return this;
    }

    public final cf fR(long j2) {
        this.etw = j2;
        return this;
    }

    public final cf lF(String str) {
        AppMethodBeat.i(208993);
        this.etx = x("ColumnId", str, true);
        AppMethodBeat.o(208993);
        return this;
    }

    public final cf lG(String str) {
        AppMethodBeat.i(208994);
        this.ety = x("ActivityID", str, true);
        AppMethodBeat.o(208994);
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(168900);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.erU);
        stringBuffer.append(",");
        stringBuffer.append(this.evg);
        stringBuffer.append(",");
        stringBuffer.append(this.evh);
        stringBuffer.append(",");
        stringBuffer.append(this.evi);
        stringBuffer.append(",");
        stringBuffer.append(this.err);
        stringBuffer.append(",");
        stringBuffer.append(this.esL);
        stringBuffer.append(",");
        stringBuffer.append(this.evj);
        stringBuffer.append(",");
        stringBuffer.append(this.ers);
        stringBuffer.append(",");
        stringBuffer.append(this.ert);
        stringBuffer.append(",");
        stringBuffer.append(this.eru);
        stringBuffer.append(",");
        stringBuffer.append(this.esP);
        stringBuffer.append(",");
        stringBuffer.append(this.esQ);
        stringBuffer.append(",");
        stringBuffer.append(this.esR);
        stringBuffer.append(",");
        stringBuffer.append(this.erv);
        stringBuffer.append(",");
        stringBuffer.append(this.erx);
        stringBuffer.append(",");
        stringBuffer.append(this.esS);
        stringBuffer.append(",");
        stringBuffer.append(this.esT);
        stringBuffer.append(",");
        stringBuffer.append(this.esU);
        stringBuffer.append(",");
        stringBuffer.append(this.esV);
        stringBuffer.append(",");
        stringBuffer.append(this.erw);
        stringBuffer.append(",");
        stringBuffer.append(this.erH);
        stringBuffer.append(",");
        stringBuffer.append(this.eoz);
        stringBuffer.append(",");
        stringBuffer.append(this.eoo);
        stringBuffer.append(",");
        stringBuffer.append(this.evk);
        stringBuffer.append(",");
        stringBuffer.append(this.esZ);
        stringBuffer.append(",");
        stringBuffer.append(this.eta);
        stringBuffer.append(",");
        stringBuffer.append(this.eui);
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
        AppMethodBeat.o(168900);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(168901);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Sessionid:").append(this.erU);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ForwardType:").append(this.evg);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ForwardResult:").append(this.evh);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ForwardId:").append(this.evi);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("FeedId:").append(this.err);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("FeedUsr:").append(this.esL);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ForwardToUsr:").append(this.evj);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("FeedLikeCount:").append(this.ers);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("FeedCommentCount:").append(this.ert);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("FeedFriLikeCount:").append(this.eru);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("FeedFriCommentCount:").append(this.esP);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("FeedAuthorLikeCount:").append(this.esQ);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("FeedAuthorCommentCount:").append(this.esR);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("CurrentPageName:").append(this.erv);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("FeedType:").append(this.erx);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Tag:").append(this.esS);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("TagId:").append(this.esT);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("IsPoi:").append(this.esU);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("TagFeedCnt:").append(this.esV);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("scene:").append(this.erw);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ClickTabContextId:").append(this.erH);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ContextId:").append(this.eoz);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("SessionBuffer:").append(this.eoo);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ForwardUsrCount:").append(this.evk);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ExtraInfo:").append(this.esZ);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("enterSourceInfo:").append(this.eta);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("LongVideoId:").append(this.eui);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("GroupID:").append(this.etv);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("TrackType:").append(this.etw);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ColumnId:").append(this.etx);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ActivityID:").append(this.ety);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(168901);
        return stringBuffer2;
    }
}
