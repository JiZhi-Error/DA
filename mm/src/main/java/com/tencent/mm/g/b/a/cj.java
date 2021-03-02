package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class cj extends a {
    private String eiB = "";
    private long eoV;
    private String eoo = "";
    private long eor;
    private String eoz = "";
    private String erH = "";
    private long erW;
    private String err = "";
    private long erx;
    private long ery;
    private long erz;
    private String etE = "";
    private long euN;
    private long euV;
    private long euX;
    private String eug = "";
    private String euh = "";
    private String evA = "";
    private long evB;
    private long evC;
    private long evD;
    private long evE;
    private long evF;
    private String evG = "";
    private long evH;
    private long evI;
    private long evJ;
    private long evK;
    private long evL;
    private String evM = "";
    private long evN;
    private String evO = "";
    private long evP;
    private long evQ;
    private long evR;
    private long evS;
    private long evT;
    private long evw;
    private long evx;
    private long evy;
    private String evz = "";

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 19259;
    }

    public final cj lO(String str) {
        AppMethodBeat.i(168902);
        this.err = x("FeedId", str, true);
        AppMethodBeat.o(168902);
        return this;
    }

    public final cj fY(long j2) {
        this.erx = j2;
        return this;
    }

    public final cj lP(String str) {
        AppMethodBeat.i(168903);
        this.eiB = x("SessionId", str, true);
        AppMethodBeat.o(168903);
        return this;
    }

    public final cj fZ(long j2) {
        this.evw = j2;
        return this;
    }

    public final cj ga(long j2) {
        this.evx = j2;
        return this;
    }

    public final cj gb(long j2) {
        this.evy = j2;
        return this;
    }

    public final cj lQ(String str) {
        AppMethodBeat.i(168904);
        this.evz = x("topic", str, true);
        AppMethodBeat.o(168904);
        return this;
    }

    public final cj lR(String str) {
        AppMethodBeat.i(168905);
        this.evA = x("recommendWording", str, true);
        AppMethodBeat.o(168905);
        return this;
    }

    public final cj gc(long j2) {
        this.evB = j2;
        return this;
    }

    public final cj gd(long j2) {
        this.evC = j2;
        return this;
    }

    public final cj adg() {
        this.eor = 1;
        return this;
    }

    public final cj ge(long j2) {
        this.evD = j2;
        return this;
    }

    public final cj gf(long j2) {
        this.eoV = j2;
        return this;
    }

    public final cj gg(long j2) {
        this.euX = j2;
        return this;
    }

    public final cj gh(long j2) {
        this.erz = j2;
        return this;
    }

    public final cj gi(long j2) {
        this.evE = j2;
        return this;
    }

    public final cj lS(String str) {
        AppMethodBeat.i(184160);
        this.etE = x("FeedUsername", str, true);
        AppMethodBeat.o(184160);
        return this;
    }

    public final cj gj(long j2) {
        this.evF = j2;
        return this;
    }

    public final cj lT(String str) {
        AppMethodBeat.i(209008);
        this.evG = x("NoticeWording", str, true);
        AppMethodBeat.o(209008);
        return this;
    }

    public final cj gk(long j2) {
        this.evH = j2;
        return this;
    }

    public final cj gl(long j2) {
        this.evI = j2;
        return this;
    }

    public final cj lU(String str) {
        AppMethodBeat.i(209009);
        this.eoz = x("ContextId", str, true);
        AppMethodBeat.o(209009);
        return this;
    }

    public final cj gm(long j2) {
        this.ery = j2;
        return this;
    }

    public final cj lV(String str) {
        AppMethodBeat.i(209010);
        this.eug = x("ClickFeedId", str, true);
        AppMethodBeat.o(209010);
        return this;
    }

    public final cj lW(String str) {
        AppMethodBeat.i(209011);
        this.euh = x("ClickFeedContextId", str, true);
        AppMethodBeat.o(209011);
        return this;
    }

    public final cj lX(String str) {
        AppMethodBeat.i(209012);
        this.erH = x("ClickTabContextId", str, true);
        AppMethodBeat.o(209012);
        return this;
    }

    public final cj gn(long j2) {
        this.euV = j2;
        return this;
    }

    public final cj go(long j2) {
        this.euN = j2;
        return this;
    }

    public final cj lY(String str) {
        AppMethodBeat.i(209013);
        this.eoo = x("SessionBuffer", str, true);
        AppMethodBeat.o(209013);
        return this;
    }

    public final cj gp(long j2) {
        this.evK = j2;
        return this;
    }

    public final cj gq(long j2) {
        this.evL = j2;
        return this;
    }

    public final cj lZ(String str) {
        AppMethodBeat.i(209014);
        this.evM = x("ExpoFriendLikeUserList", str, true);
        AppMethodBeat.o(209014);
        return this;
    }

    public final String adh() {
        return this.evM;
    }

    public final cj gr(long j2) {
        this.evN = j2;
        return this;
    }

    public final cj ma(String str) {
        AppMethodBeat.i(209015);
        this.evO = x("ExpoCommentUser", str, true);
        AppMethodBeat.o(209015);
        return this;
    }

    public final cj gs(long j2) {
        this.evR = j2;
        return this;
    }

    public final cj gt(long j2) {
        this.evS = j2;
        return this;
    }

    public final cj gu(long j2) {
        this.evT = j2;
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(168906);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.err);
        stringBuffer.append(",");
        stringBuffer.append(this.erx);
        stringBuffer.append(",");
        stringBuffer.append(this.eiB);
        stringBuffer.append(",");
        stringBuffer.append(this.erW);
        stringBuffer.append(",");
        stringBuffer.append(this.evw);
        stringBuffer.append(",");
        stringBuffer.append(this.evx);
        stringBuffer.append(",");
        stringBuffer.append(this.evy);
        stringBuffer.append(",");
        stringBuffer.append(this.evz);
        stringBuffer.append(",");
        stringBuffer.append(this.evA);
        stringBuffer.append(",");
        stringBuffer.append(this.evB);
        stringBuffer.append(",");
        stringBuffer.append(this.evC);
        stringBuffer.append(",");
        stringBuffer.append(this.eor);
        stringBuffer.append(",");
        stringBuffer.append(this.evD);
        stringBuffer.append(",");
        stringBuffer.append(this.eoV);
        stringBuffer.append(",");
        stringBuffer.append(this.euX);
        stringBuffer.append(",");
        stringBuffer.append(this.erz);
        stringBuffer.append(",");
        stringBuffer.append(this.evE);
        stringBuffer.append(",");
        stringBuffer.append(this.etE);
        stringBuffer.append(",");
        stringBuffer.append(this.evF);
        stringBuffer.append(",");
        stringBuffer.append(this.evG);
        stringBuffer.append(",");
        stringBuffer.append(this.evH);
        stringBuffer.append(",");
        stringBuffer.append(this.evI);
        stringBuffer.append(",");
        stringBuffer.append(this.eoz);
        stringBuffer.append(",");
        stringBuffer.append(this.ery);
        stringBuffer.append(",");
        stringBuffer.append(this.eug);
        stringBuffer.append(",");
        stringBuffer.append(this.euh);
        stringBuffer.append(",");
        stringBuffer.append(this.erH);
        stringBuffer.append(",");
        stringBuffer.append(this.evJ);
        stringBuffer.append(",");
        stringBuffer.append(this.euV);
        stringBuffer.append(",");
        stringBuffer.append(this.euN);
        stringBuffer.append(",");
        stringBuffer.append(this.eoo);
        stringBuffer.append(",");
        stringBuffer.append(this.evK);
        stringBuffer.append(",");
        stringBuffer.append(this.evL);
        stringBuffer.append(",");
        stringBuffer.append(this.evM);
        stringBuffer.append(",");
        stringBuffer.append(this.evN);
        stringBuffer.append(",");
        stringBuffer.append(this.evO);
        stringBuffer.append(",");
        stringBuffer.append(this.evP);
        stringBuffer.append(",");
        stringBuffer.append(this.evQ);
        stringBuffer.append(",");
        stringBuffer.append(this.evR);
        stringBuffer.append(",");
        stringBuffer.append(this.evS);
        stringBuffer.append(",");
        stringBuffer.append(this.evT);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(168906);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(168907);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("FeedId:").append(this.err);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("FeedType:").append(this.erx);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("SessionId:").append(this.eiB);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Scene:").append(this.erW);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("exposeTimestamp:").append(this.evw);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("LikeCount:").append(this.evx);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("CommentCount:").append(this.evy);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("topic:").append(this.evz);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("recommendWording:").append(this.evA);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("MyPost:").append(this.evB);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("PostTimestamp:").append(this.evC);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("HasLocation:").append(this.eor);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("PicCount:").append(this.evD);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("VideoDuration:").append(this.eoV);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ExposeTime:").append(this.euX);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("InnerVersion:").append(this.erz);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("recommendType:").append(this.evE);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("FeedUsername:").append(this.etE);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("RealRecommendType:").append(this.evF);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("NoticeWording:").append(this.evG);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("NoticeType:").append(this.evH);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ExposeType:").append(this.evI);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ContextId:").append(this.eoz);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("CommentScene:").append(this.ery);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ClickFeedId:").append(this.eug);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ClickFeedContextId:").append(this.euh);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ClickTabContextId:").append(this.erH);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("DangerTip:").append(this.evJ);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Index:").append(this.euV);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("RefreshTime:").append(this.euN);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("SessionBuffer:").append(this.eoo);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("FriendLikeCount:").append(this.evK);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ExpoFriendHeaderCount:").append(this.evL);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ExpoFriendLikeUserList:").append(this.evM);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ExpoComment:").append(this.evN);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ExpoCommentUser:").append(this.evO);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("HasFlodIcon:").append(this.evP);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("HasFlodWording:").append(this.evQ);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("FriendLikeCountNew:").append(this.evR);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ExpoFriendCommentCount:").append(this.evS);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ExpoCommentCount:").append(this.evT);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(168907);
        return stringBuffer2;
    }
}
