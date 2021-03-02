package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class cw extends a {
    private long emk;
    private int eqN;
    private String err = "";
    private String esS = "";
    private String etN = "";
    private String etO = "";
    private int etP;
    private String etQ = "";
    private long etR;
    private long evx;
    private long ewB;
    private long ewS;
    private String ewV = "";
    private long ewX;
    private String ewp = "";
    private String ewq = "";
    private long ews;
    private long exP;
    private long exQ;
    private long exR;
    private long exS;
    private long exT;
    private long exU;
    private long exV;
    private long exW;
    private long exX;
    private long exY;
    private long exZ;
    private long eya;
    private long eyb;
    private long eyc;
    private long eyd;
    private String eyf = "";
    private long eyg;
    private String eyh = "";
    private long eyi;
    private long eyj;
    private String eyk = "";
    private long eyl;
    private String eym = "";
    private long eyn;
    private long eyo;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 21056;
    }

    public final cw nK(String str) {
        AppMethodBeat.i(220159);
        this.etN = x("FinderUsrname", str, true);
        AppMethodBeat.o(220159);
        return this;
    }

    public final String acG() {
        return this.etN;
    }

    public final cw nL(String str) {
        AppMethodBeat.i(220160);
        this.etO = x("FinderWxAppInfo", str, true);
        AppMethodBeat.o(220160);
        return this;
    }

    public final String acH() {
        return this.etO;
    }

    public final cw ko(int i2) {
        this.etP = i2;
        return this;
    }

    public final int acI() {
        return this.etP;
    }

    public final cw nM(String str) {
        AppMethodBeat.i(220161);
        this.etQ = x("FinderSessionId", str, true);
        AppMethodBeat.o(220161);
        return this;
    }

    public final String acJ() {
        return this.etQ;
    }

    public final cw hT(long j2) {
        AppMethodBeat.i(220162);
        this.etR = j2;
        super.bi("ActionTimeMs", this.etR);
        AppMethodBeat.o(220162);
        return this;
    }

    public final long acK() {
        return this.etR;
    }

    public final cw nN(String str) {
        AppMethodBeat.i(220163);
        this.ewp = x("LiveId", str, true);
        AppMethodBeat.o(220163);
        return this;
    }

    public final String adj() {
        return this.ewp;
    }

    public final cw nO(String str) {
        AppMethodBeat.i(220164);
        this.err = x("FeedId", str, true);
        AppMethodBeat.o(220164);
        return this;
    }

    public final String adk() {
        return this.err;
    }

    public final cw nP(String str) {
        AppMethodBeat.i(220165);
        this.ewq = x("Description", str, true);
        AppMethodBeat.o(220165);
        return this;
    }

    public final String getDescription() {
        return this.ewq;
    }

    public final cw hU(long j2) {
        AppMethodBeat.i(220166);
        this.exP = j2;
        super.bi("LiveStartTimeMs", this.exP);
        AppMethodBeat.o(220166);
        return this;
    }

    public final long aeq() {
        return this.exP;
    }

    public final cw hV(long j2) {
        AppMethodBeat.i(220167);
        this.exQ = j2;
        super.bi("LiveEndTimeMs", this.exQ);
        AppMethodBeat.o(220167);
        return this;
    }

    public final long aer() {
        return this.exQ;
    }

    public final cw hW(long j2) {
        this.exR = j2;
        return this;
    }

    public final long aes() {
        return this.exR;
    }

    public final cw hX(long j2) {
        this.exS = j2;
        return this;
    }

    public final long aet() {
        return this.exS;
    }

    public final cw hY(long j2) {
        this.exT = j2;
        return this;
    }

    public final long aeu() {
        return this.exT;
    }

    public final cw hZ(long j2) {
        this.evx = j2;
        return this;
    }

    public final long adl() {
        return this.evx;
    }

    public final cw ia(long j2) {
        this.exU = j2;
        return this;
    }

    public final long aev() {
        return this.exU;
    }

    public final cw kp(int i2) {
        this.eqN = i2;
        return this;
    }

    public final int getErrorCode() {
        return this.eqN;
    }

    public final cw ib(long j2) {
        this.ewB = j2;
        return this;
    }

    public final long adx() {
        return this.ewB;
    }

    public final cw ic(long j2) {
        this.exV = j2;
        return this;
    }

    public final long aew() {
        return this.exV;
    }

    public final cw id(long j2) {
        this.exW = j2;
        return this;
    }

    public final long aex() {
        return this.exW;
    }

    public final cw ie(long j2) {
        this.exX = j2;
        return this;
    }

    public final long aey() {
        return this.exX;
    }

    /* renamed from: if  reason: not valid java name */
    public final cw m9if(long j2) {
        this.exY = j2;
        return this;
    }

    public final long aez() {
        return this.exY;
    }

    public final cw ig(long j2) {
        this.exZ = j2;
        return this;
    }

    public final long aeA() {
        return this.exZ;
    }

    public final cw ih(long j2) {
        this.eya = j2;
        return this;
    }

    public final long aeB() {
        return this.eya;
    }

    public final cw ii(long j2) {
        this.eyb = j2;
        return this;
    }

    public final long aeC() {
        return this.eyb;
    }

    public final cw ij(long j2) {
        this.eyc = j2;
        return this;
    }

    public final long aeD() {
        return this.eyc;
    }

    public final cw ik(long j2) {
        this.eyd = j2;
        return this;
    }

    public final long aeE() {
        return this.eyd;
    }

    public final cw nQ(String str) {
        AppMethodBeat.i(220168);
        this.eyf = x("PromoteGoodsJson", str, true);
        AppMethodBeat.o(220168);
        return this;
    }

    public final String aeF() {
        return this.eyf;
    }

    public final cw il(long j2) {
        this.eyg = j2;
        return this;
    }

    public final long aeG() {
        return this.eyg;
    }

    public final cw nR(String str) {
        AppMethodBeat.i(220169);
        this.eyh = x("ShopWindowId", str, true);
        AppMethodBeat.o(220169);
        return this;
    }

    public final String aeH() {
        return this.eyh;
    }

    public final cw im(long j2) {
        this.eyi = j2;
        return this;
    }

    public final long aeI() {
        return this.eyi;
    }

    public final cw in(long j2) {
        this.ews = j2;
        return this;
    }

    public final long adn() {
        return this.ews;
    }

    public final cw io(long j2) {
        this.ewS = j2;
        return this;
    }

    public final long adO() {
        return this.ewS;
    }

    public final cw ip(long j2) {
        this.eyj = j2;
        return this;
    }

    public final long aeJ() {
        return this.eyj;
    }

    public final cw iq(long j2) {
        this.emk = j2;
        return this;
    }

    public final long aeK() {
        return this.emk;
    }

    public final cw nS(String str) {
        AppMethodBeat.i(220170);
        this.ewV = x("ConnectDuration", str, true);
        AppMethodBeat.o(220170);
        return this;
    }

    public final String adR() {
        return this.ewV;
    }

    public final cw nT(String str) {
        AppMethodBeat.i(220171);
        this.esS = x("Tag", str, true);
        AppMethodBeat.o(220171);
        return this;
    }

    public final String getTag() {
        return this.esS;
    }

    public final cw nU(String str) {
        AppMethodBeat.i(220172);
        this.eyk = x("SubTag", str, true);
        AppMethodBeat.o(220172);
        return this;
    }

    public final String aeL() {
        return this.eyk;
    }

    public final cw ir(long j2) {
        this.eyl = j2;
        return this;
    }

    public final long aeM() {
        return this.eyl;
    }

    public final cw amE(String str) {
        AppMethodBeat.i(259537);
        this.eym = x("MicWithAnchor", str, true);
        AppMethodBeat.o(259537);
        return this;
    }

    public final String aDV() {
        return this.eym;
    }

    public final cw is(long j2) {
        this.eyn = j2;
        return this;
    }

    public final long aeN() {
        return this.eyn;
    }

    public final cw it(long j2) {
        this.ewX = j2;
        return this;
    }

    public final cw iu(long j2) {
        this.eyo = j2;
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(220173);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.etN);
        stringBuffer.append(",");
        stringBuffer.append(this.etO);
        stringBuffer.append(",");
        stringBuffer.append(this.etP);
        stringBuffer.append(",");
        stringBuffer.append(this.etQ);
        stringBuffer.append(",");
        stringBuffer.append(this.etR);
        stringBuffer.append(",");
        stringBuffer.append(this.ewp);
        stringBuffer.append(",");
        stringBuffer.append(this.err);
        stringBuffer.append(",");
        stringBuffer.append(this.ewq);
        stringBuffer.append(",");
        stringBuffer.append(this.exP);
        stringBuffer.append(",");
        stringBuffer.append(this.exQ);
        stringBuffer.append(",");
        stringBuffer.append(this.exR);
        stringBuffer.append(",");
        stringBuffer.append(this.exS);
        stringBuffer.append(",");
        stringBuffer.append(this.exT);
        stringBuffer.append(",");
        stringBuffer.append(this.evx);
        stringBuffer.append(",");
        stringBuffer.append(this.exU);
        stringBuffer.append(",");
        stringBuffer.append(this.eqN);
        stringBuffer.append(",");
        stringBuffer.append(this.ewB);
        stringBuffer.append(",");
        stringBuffer.append(this.exV);
        stringBuffer.append(",");
        stringBuffer.append(this.exW);
        stringBuffer.append(",");
        stringBuffer.append(this.exX);
        stringBuffer.append(",");
        stringBuffer.append(this.exY);
        stringBuffer.append(",");
        stringBuffer.append(this.exZ);
        stringBuffer.append(",");
        stringBuffer.append(this.eya);
        stringBuffer.append(",");
        stringBuffer.append(this.eyb);
        stringBuffer.append(",");
        stringBuffer.append(this.eyc);
        stringBuffer.append(",");
        stringBuffer.append(this.eyd);
        stringBuffer.append(",");
        stringBuffer.append(this.eyf);
        stringBuffer.append(",");
        stringBuffer.append(this.eyg);
        stringBuffer.append(",");
        stringBuffer.append(this.eyh);
        stringBuffer.append(",");
        stringBuffer.append(this.eyi);
        stringBuffer.append(",");
        stringBuffer.append(this.ews);
        stringBuffer.append(",");
        stringBuffer.append(this.ewS);
        stringBuffer.append(",");
        stringBuffer.append(this.eyj);
        stringBuffer.append(",");
        stringBuffer.append(this.emk);
        stringBuffer.append(",");
        stringBuffer.append(this.ewV);
        stringBuffer.append(",");
        stringBuffer.append(this.esS);
        stringBuffer.append(",");
        stringBuffer.append(this.eyk);
        stringBuffer.append(",");
        stringBuffer.append(this.eyl);
        stringBuffer.append(",");
        stringBuffer.append(this.eym);
        stringBuffer.append(",");
        stringBuffer.append(this.eyn);
        stringBuffer.append(",");
        stringBuffer.append(this.ewX);
        stringBuffer.append(",");
        stringBuffer.append(this.eyo);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(220173);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(220174);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("FinderUsrname:").append(this.etN);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("FinderWxAppInfo:").append(this.etO);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("IsPrivate:").append(this.etP);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("FinderSessionId:").append(this.etQ);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ActionTimeMs:").append(this.etR);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("LiveId:").append(this.ewp);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("FeedId:").append(this.err);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Description:").append(this.ewq);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("LiveStartTimeMs:").append(this.exP);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("LiveEndTimeMs:").append(this.exQ);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("LiveDurationSeconds:").append(this.exR);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("OriFansCount:").append(this.exS);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("AudienceCount:").append(this.exT);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("LikeCount:").append(this.evx);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("NewFansNum:").append(this.exU);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ErrorCode:").append(this.eqN);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("FloatingCount:").append(this.ewB);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ShareSnsCount:").append(this.exV);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ShareSessionCount:").append(this.exW);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ExchangeCameraCount:").append(this.exX);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ComplainCount:").append(this.exY);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("AllCommentCloseCount:").append(this.exZ);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("AllCommentOpenCount:").append(this.eya);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("PersonalCommentCloseCount:").append(this.eyb);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("PersonalCommentOpenCount:").append(this.eyc);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("KickOutCount:").append(this.eyd);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("PromoteGoodsJson:").append(this.eyf);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("PromoteGoodsCount:").append(this.eyg);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ShopWindowId:").append(this.eyh);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("TopComment:").append(this.eyi);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("SourceScene:").append(this.ews);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("LotteryCount:").append(this.ewS);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("NudgeCount:").append(this.eyj);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ConnectCount:").append(this.emk);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ConnectDuration:").append(this.ewV);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Tag:").append(this.esS);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("SubTag:").append(this.eyk);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("IsGift:").append(this.eyl);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("MicWithAnchor:").append(this.eym);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("VisibleRange:").append(this.eyn);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ShareToStatus:").append(this.ewX);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("VisibleCount:").append(this.eyo);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(220174);
        return stringBuffer2;
    }
}
