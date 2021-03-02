package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class eb extends a {
    private long eCh;
    private long eCi;
    private long eCj;
    private long eCk;
    private long eCl;
    private String eCm = "";
    private String eCn = "";
    private String eCo = "";
    private String eCp = "";
    private String eCq = "";
    private String eCr = "";
    private long enH;
    private String err = "";
    private String esS = "";
    private String etN = "";
    private String etO = "";
    private int etP;
    private String etQ = "";
    private long etR;
    private long ewL;
    private String ewp = "";
    private String ewq = "";
    private long ews;
    private String eyh = "";
    private String eyk = "";
    private long eyn;
    private long eyo;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 21024;
    }

    public final eb qq(String str) {
        AppMethodBeat.i(220189);
        this.etN = x("FinderUsrname", str, true);
        AppMethodBeat.o(220189);
        return this;
    }

    public final String acG() {
        return this.etN;
    }

    public final eb qr(String str) {
        AppMethodBeat.i(220190);
        this.etO = x("FinderWxAppInfo", str, true);
        AppMethodBeat.o(220190);
        return this;
    }

    public final String acH() {
        return this.etO;
    }

    public final eb ld(int i2) {
        this.etP = i2;
        return this;
    }

    public final int acI() {
        return this.etP;
    }

    public final eb qs(String str) {
        AppMethodBeat.i(220191);
        this.etQ = x("FinderSessionId", str, true);
        AppMethodBeat.o(220191);
        return this;
    }

    public final String acJ() {
        return this.etQ;
    }

    public final eb lo(long j2) {
        AppMethodBeat.i(220192);
        this.etR = j2;
        super.bi("ActionTimeMs", this.etR);
        AppMethodBeat.o(220192);
        return this;
    }

    public final long acK() {
        return this.etR;
    }

    public final eb lp(long j2) {
        this.eCh = j2;
        return this;
    }

    public final long afl() {
        return this.eCh;
    }

    public final eb lq(long j2) {
        this.eCi = j2;
        return this;
    }

    public final long afm() {
        return this.eCi;
    }

    public final eb lr(long j2) {
        AppMethodBeat.i(220193);
        this.eCj = j2;
        super.bi("EnterUITimeMs", this.eCj);
        AppMethodBeat.o(220193);
        return this;
    }

    public final long afn() {
        return this.eCj;
    }

    public final eb ls(long j2) {
        AppMethodBeat.i(220194);
        this.enH = j2;
        super.bi("StayTimeMs", this.enH);
        AppMethodBeat.o(220194);
        return this;
    }

    public final long afo() {
        return this.enH;
    }

    public final eb lt(long j2) {
        this.eCk = j2;
        return this;
    }

    public final long afp() {
        return this.eCk;
    }

    public final eb lu(long j2) {
        this.eCl = j2;
        return this;
    }

    public final long afq() {
        return this.eCl;
    }

    public final eb qt(String str) {
        AppMethodBeat.i(220195);
        this.eCm = x("PoiJson", str, true);
        AppMethodBeat.o(220195);
        return this;
    }

    public final String afr() {
        return this.eCm;
    }

    public final eb qu(String str) {
        AppMethodBeat.i(220196);
        this.ewq = x("Description", str, true);
        AppMethodBeat.o(220196);
        return this;
    }

    public final String getDescription() {
        return this.ewq;
    }

    public final eb qv(String str) {
        AppMethodBeat.i(220197);
        this.ewp = x("LiveId", str, true);
        AppMethodBeat.o(220197);
        return this;
    }

    public final String adj() {
        return this.ewp;
    }

    public final eb qw(String str) {
        AppMethodBeat.i(220198);
        this.err = x("FeedId", str, true);
        AppMethodBeat.o(220198);
        return this;
    }

    public final String adk() {
        return this.err;
    }

    public final eb lv(long j2) {
        this.ewL = j2;
        return this;
    }

    public final long adH() {
        return this.ewL;
    }

    public final eb qx(String str) {
        AppMethodBeat.i(220199);
        this.eCn = x("ErrorCode", str, true);
        AppMethodBeat.o(220199);
        return this;
    }

    public final String afs() {
        return this.eCn;
    }

    public final eb qy(String str) {
        AppMethodBeat.i(220200);
        this.eCo = x("GoodsListJson", str, true);
        AppMethodBeat.o(220200);
        return this;
    }

    public final String aft() {
        return this.eCo;
    }

    public final eb qz(String str) {
        AppMethodBeat.i(220201);
        this.eyh = x("ShopWindowId", str, true);
        AppMethodBeat.o(220201);
        return this;
    }

    public final String aeH() {
        return this.eyh;
    }

    public final eb lw(long j2) {
        this.ews = j2;
        return this;
    }

    public final long adn() {
        return this.ews;
    }

    public final eb qA(String str) {
        AppMethodBeat.i(220202);
        this.eCp = x("RetouchResult", str, true);
        AppMethodBeat.o(220202);
        return this;
    }

    public final String afu() {
        return this.eCp;
    }

    public final eb qB(String str) {
        AppMethodBeat.i(220203);
        this.eCq = x("FiltersResult", str, true);
        AppMethodBeat.o(220203);
        return this;
    }

    public final String afv() {
        return this.eCq;
    }

    public final eb qC(String str) {
        AppMethodBeat.i(220204);
        this.esS = x("Tag", str, true);
        AppMethodBeat.o(220204);
        return this;
    }

    public final String getTag() {
        return this.esS;
    }

    public final eb qD(String str) {
        AppMethodBeat.i(220205);
        this.eyk = x("SubTag", str, true);
        AppMethodBeat.o(220205);
        return this;
    }

    public final String aeL() {
        return this.eyk;
    }

    public final eb qE(String str) {
        AppMethodBeat.i(220206);
        this.eCr = x("ConnectSwitch", str, true);
        AppMethodBeat.o(220206);
        return this;
    }

    public final String afw() {
        return this.eCr;
    }

    public final eb lx(long j2) {
        this.eyn = j2;
        return this;
    }

    public final long aeN() {
        return this.eyn;
    }

    public final eb ly(long j2) {
        this.eyo = j2;
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(220207);
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
        stringBuffer.append(this.eCh);
        stringBuffer.append(",");
        stringBuffer.append(this.eCi);
        stringBuffer.append(",");
        stringBuffer.append(this.eCj);
        stringBuffer.append(",");
        stringBuffer.append(this.enH);
        stringBuffer.append(",");
        stringBuffer.append(this.eCk);
        stringBuffer.append(",");
        stringBuffer.append(this.eCl);
        stringBuffer.append(",");
        stringBuffer.append(this.eCm);
        stringBuffer.append(",");
        stringBuffer.append(this.ewq);
        stringBuffer.append(",");
        stringBuffer.append(this.ewp);
        stringBuffer.append(",");
        stringBuffer.append(this.err);
        stringBuffer.append(",");
        stringBuffer.append(this.ewL);
        stringBuffer.append(",");
        stringBuffer.append(this.eCn);
        stringBuffer.append(",");
        stringBuffer.append(this.eCo);
        stringBuffer.append(",");
        stringBuffer.append(this.eyh);
        stringBuffer.append(",");
        stringBuffer.append(this.ews);
        stringBuffer.append(",");
        stringBuffer.append(this.eCp);
        stringBuffer.append(",");
        stringBuffer.append(this.eCq);
        stringBuffer.append(",");
        stringBuffer.append(this.esS);
        stringBuffer.append(",");
        stringBuffer.append(this.eyk);
        stringBuffer.append(",");
        stringBuffer.append(this.eCr);
        stringBuffer.append(",");
        stringBuffer.append(this.eyn);
        stringBuffer.append(",");
        stringBuffer.append(this.eyo);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(220207);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(220208);
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
        stringBuffer.append("FansCount:").append(this.eCh);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("CameraStatus:").append(this.eCi);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("EnterUITimeMs:").append(this.eCj);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("StayTimeMs:").append(this.enH);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("CoverType:").append(this.eCk);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("RuleType:").append(this.eCl);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("PoiJson:").append(this.eCm);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Description:").append(this.ewq);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("LiveId:").append(this.ewp);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("FeedId:").append(this.err);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ExitType:").append(this.ewL);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ErrorCode:").append(this.eCn);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("GoodsListJson:").append(this.eCo);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ShopWindowId:").append(this.eyh);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("SourceScene:").append(this.ews);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("RetouchResult:").append(this.eCp);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("FiltersResult:").append(this.eCq);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Tag:").append(this.esS);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("SubTag:").append(this.eyk);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ConnectSwitch:").append(this.eCr);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("VisibleRange:").append(this.eyn);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("VisibleCount:").append(this.eyo);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(220208);
        return stringBuffer2;
    }
}
