package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class bm extends a {
    private String eiB = "";
    private long enl;
    private String eoo = "";
    private String eoz = "";
    private String erH = "";
    private String err = "";
    private long ers;
    private long ert;
    private long eru;
    private long erw;
    private long erx;
    private long esI;
    private String esK = "";
    private String esL = "";
    private long esM;
    private String esN = "";
    private long esO;
    private long esP;
    private long esQ;
    private long esR;
    private String esS = "";
    private String esT = "";
    private long esU;
    private long esV;
    private long esW;
    private long esX;
    private long esY;
    private String esZ = "";
    private String eta = "";
    private long etb;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 18942;
    }

    public final bm jt(String str) {
        AppMethodBeat.i(168884);
        this.eiB = x("SessionId", str, true);
        AppMethodBeat.o(168884);
        return this;
    }

    public final bm ju(String str) {
        AppMethodBeat.i(168885);
        this.esK = x("ClickUI", str, true);
        AppMethodBeat.o(168885);
        return this;
    }

    public final bm jv(String str) {
        AppMethodBeat.i(168886);
        this.err = x("FeedId", str, true);
        AppMethodBeat.o(168886);
        return this;
    }

    public final bm jw(String str) {
        AppMethodBeat.i(168887);
        this.esL = x("FeedUsr", str, true);
        AppMethodBeat.o(168887);
        return this;
    }

    public final bm dU(long j2) {
        this.esI = j2;
        return this;
    }

    public final bm dV(long j2) {
        this.enl = j2;
        return this;
    }

    public final bm dW(long j2) {
        this.esM = j2;
        return this;
    }

    public final bm jx(String str) {
        AppMethodBeat.i(168888);
        this.esN = x("ReplyUsr", str, true);
        AppMethodBeat.o(168888);
        return this;
    }

    public final bm dX(long j2) {
        this.esO = j2;
        return this;
    }

    public final bm dY(long j2) {
        this.ers = j2;
        return this;
    }

    public final bm dZ(long j2) {
        this.ert = j2;
        return this;
    }

    public final bm ea(long j2) {
        this.eru = j2;
        return this;
    }

    public final bm eb(long j2) {
        this.erx = j2;
        return this;
    }

    public final bm jy(String str) {
        AppMethodBeat.i(168889);
        this.esS = x("Tag", str, true);
        AppMethodBeat.o(168889);
        return this;
    }

    public final bm jz(String str) {
        AppMethodBeat.i(168890);
        this.esT = x("TagId", str, true);
        AppMethodBeat.o(168890);
        return this;
    }

    public final bm ec(long j2) {
        this.erw = j2;
        return this;
    }

    public final bm ed(long j2) {
        this.esW = j2;
        return this;
    }

    public final bm ee(long j2) {
        this.esX = j2;
        return this;
    }

    public final bm jA(String str) {
        AppMethodBeat.i(208887);
        this.eoz = x("ContextId", str, true);
        AppMethodBeat.o(208887);
        return this;
    }

    public final bm jB(String str) {
        AppMethodBeat.i(208888);
        this.erH = x("ClickTabContextId", str, true);
        AppMethodBeat.o(208888);
        return this;
    }

    public final bm jC(String str) {
        AppMethodBeat.i(208889);
        this.eoo = x("SessionBuffer", str, true);
        AppMethodBeat.o(208889);
        return this;
    }

    public final bm ef(long j2) {
        this.esY = j2;
        return this;
    }

    public final bm jD(String str) {
        AppMethodBeat.i(208890);
        this.esZ = x("ExtraInfo", str, true);
        AppMethodBeat.o(208890);
        return this;
    }

    public final bm jE(String str) {
        AppMethodBeat.i(208891);
        this.eta = x("enterSourceInfo", str, true);
        AppMethodBeat.o(208891);
        return this;
    }

    public final bm eg(long j2) {
        this.etb = j2;
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(168891);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.eiB);
        stringBuffer.append(",");
        stringBuffer.append(this.esK);
        stringBuffer.append(",");
        stringBuffer.append(this.err);
        stringBuffer.append(",");
        stringBuffer.append(this.esL);
        stringBuffer.append(",");
        stringBuffer.append(this.esI);
        stringBuffer.append(",");
        stringBuffer.append(this.enl);
        stringBuffer.append(",");
        stringBuffer.append(this.esM);
        stringBuffer.append(",");
        stringBuffer.append(this.esN);
        stringBuffer.append(",");
        stringBuffer.append(this.esO);
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
        stringBuffer.append(this.esW);
        stringBuffer.append(",");
        stringBuffer.append(this.esX);
        stringBuffer.append(",");
        stringBuffer.append(this.eoz);
        stringBuffer.append(",");
        stringBuffer.append(this.erH);
        stringBuffer.append(",");
        stringBuffer.append(this.eoo);
        stringBuffer.append(",");
        stringBuffer.append(this.esY);
        stringBuffer.append(",");
        stringBuffer.append(this.esZ);
        stringBuffer.append(",");
        stringBuffer.append(this.eta);
        stringBuffer.append(",");
        stringBuffer.append(this.etb);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(168891);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(168892);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("SessionId:").append(this.eiB);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ClickUI:").append(this.esK);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("FeedId:").append(this.err);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("FeedUsr:").append(this.esL);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ClickType:").append(this.esI);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ActionType:").append(this.enl);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("LikeType:").append(this.esM);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ReplyUsr:").append(this.esN);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ReplyType:").append(this.esO);
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
        stringBuffer.append("IsSelf:").append(this.esW);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("IsShowRecWording:").append(this.esX);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ContextId:").append(this.eoz);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ClickTabContextId:").append(this.erH);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("SessionBuffer:").append(this.eoo);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("PersonalAccount:").append(this.esY);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ExtraInfo:").append(this.esZ);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("enterSourceInfo:").append(this.eta);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("FeedContentType:").append(this.etb);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(168892);
        return stringBuffer2;
    }
}
