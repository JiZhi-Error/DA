package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class en extends a {
    private long eCT;
    private long eCU;
    private long eCV;
    private long eCW;
    private long eCX;
    private long eCY;
    private long eCZ;
    private long eDA;
    private String eDB = "";
    private String eDC = "";
    private long eDD;
    private long eDE;
    private String eDF = "";
    private long eDG;
    private int eDH;
    private long eDI;
    private int eDJ;
    private String eDK = "";
    private String eDL = "";
    private int eDM;
    private int eDN;
    private int eDO;
    private String eDP = "";
    private long eDa;
    private long eDb;
    private long eDc;
    private long eDd;
    private long eDe;
    private long eDf;
    private long eDg;
    private long eDh;
    private long eDi;
    private long eDj;
    private long eDk;
    private long eDl;
    private long eDm;
    private String eDn = "";
    private long eDo;
    private long eDp;
    private String eDq = "";
    private long eDr;
    private long eDs;
    private long eDt;
    private long eDu;
    private long eDv;
    private String eDw = "";
    private long eDx;
    private String eDy = "";
    private String eDz = "";
    private String eiB = "";
    private String ejC = "";
    private String ejm = "";
    private long elK;
    private int enZ;
    private String eoo = "";
    private String eoz = "";
    private String erH = "";
    private long erW;
    private long ery;
    private long erz;
    private String esZ = "";
    private String etW = "";
    private String eta = "";
    private String eui = "";
    private long ewu;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 19059;
    }

    public final en afI() {
        this.eCT = 0;
        return this;
    }

    public final en rp(String str) {
        AppMethodBeat.i(168927);
        this.ejC = x("MediaId", str, true);
        AppMethodBeat.o(168927);
        return this;
    }

    public final String getMediaId() {
        return this.ejC;
    }

    public final en mj(long j2) {
        this.ewu = j2;
        return this;
    }

    public final en mk(long j2) {
        this.eCU = j2;
        return this;
    }

    public final en ml(long j2) {
        this.eCV = j2;
        return this;
    }

    public final long afJ() {
        return this.eCV;
    }

    public final en mm(long j2) {
        this.eCW = j2;
        return this;
    }

    public final long afK() {
        return this.eCW;
    }

    public final en mn(long j2) {
        this.elK = j2;
        return this;
    }

    public final long getFileSize() {
        return this.elK;
    }

    public final en mo(long j2) {
        this.eCX = j2;
        return this;
    }

    public final en mp(long j2) {
        this.eCY = j2;
        return this;
    }

    public final en mq(long j2) {
        this.eCZ = j2;
        return this;
    }

    public final en mr(long j2) {
        this.eDa = j2;
        return this;
    }

    public final en ms(long j2) {
        this.eDb = j2;
        return this;
    }

    public final en mt(long j2) {
        this.eDc = j2;
        return this;
    }

    public final en rq(String str) {
        AppMethodBeat.i(168928);
        this.ejm = x("NetType", str, true);
        AppMethodBeat.o(168928);
        return this;
    }

    public final en rr(String str) {
        AppMethodBeat.i(168929);
        this.eiB = x("SessionId", str, true);
        AppMethodBeat.o(168929);
        return this;
    }

    public final en mu(long j2) {
        this.eDd = j2;
        return this;
    }

    public final long getPosition() {
        return this.eDd;
    }

    public final en afL() {
        this.eDe = 0;
        return this;
    }

    public final en mv(long j2) {
        this.eDf = j2;
        return this;
    }

    public final long afM() {
        return this.eDf;
    }

    public final en mw(long j2) {
        this.eDg = j2;
        return this;
    }

    public final long afN() {
        return this.eDg;
    }

    public final en mx(long j2) {
        this.eDh = j2;
        return this;
    }

    public final en my(long j2) {
        this.erz = j2;
        return this;
    }

    public final en mz(long j2) {
        this.eDi = j2;
        return this;
    }

    public final en mA(long j2) {
        this.eDj = j2;
        return this;
    }

    public final en mB(long j2) {
        this.eDk = j2;
        return this;
    }

    public final en mC(long j2) {
        this.eDl = j2;
        return this;
    }

    public final en mD(long j2) {
        this.eDm = j2;
        return this;
    }

    public final long afO() {
        return this.eDm;
    }

    public final en rs(String str) {
        AppMethodBeat.i(168930);
        this.eDn = x("NewFeedId", str, true);
        AppMethodBeat.o(168930);
        return this;
    }

    public final en mE(long j2) {
        this.eDo = j2;
        return this;
    }

    public final en mF(long j2) {
        this.eDp = j2;
        return this;
    }

    public final en rt(String str) {
        AppMethodBeat.i(168931);
        this.eDq = x("HistoryPlayInfo", str, true);
        AppMethodBeat.o(168931);
        return this;
    }

    public final en mG(long j2) {
        this.eDr = j2;
        return this;
    }

    public final en mH(long j2) {
        this.eDs = j2;
        return this;
    }

    public final long afP() {
        return this.eDs;
    }

    public final en mI(long j2) {
        this.eDt = j2;
        return this;
    }

    public final en mJ(long j2) {
        this.eDu = j2;
        return this;
    }

    public final long afQ() {
        return this.eDu;
    }

    public final en mK(long j2) {
        this.eDv = j2;
        return this;
    }

    public final en ru(String str) {
        AppMethodBeat.i(184192);
        this.eDw = x("SvrIp", str, true);
        AppMethodBeat.o(184192);
        return this;
    }

    public final en mL(long j2) {
        this.eDx = j2;
        return this;
    }

    public final en rv(String str) {
        AppMethodBeat.i(184193);
        this.eDy = x("WaitingDetails", str, true);
        AppMethodBeat.o(184193);
        return this;
    }

    public final en rw(String str) {
        AppMethodBeat.i(184194);
        this.etW = x("Username", str, true);
        AppMethodBeat.o(184194);
        return this;
    }

    public final en rx(String str) {
        AppMethodBeat.i(209235);
        this.eDz = x("PreloadStrategyId", str, true);
        AppMethodBeat.o(209235);
        return this;
    }

    public final en mM(long j2) {
        this.eDA = j2;
        return this;
    }

    public final long afR() {
        return this.eDA;
    }

    public final en ry(String str) {
        AppMethodBeat.i(209236);
        this.eDB = x("PlayProgressInfo", str, true);
        AppMethodBeat.o(209236);
        return this;
    }

    public final en rz(String str) {
        AppMethodBeat.i(209237);
        this.eDC = x("VoiceInfo", str, true);
        AppMethodBeat.o(209237);
        return this;
    }

    public final en mN(long j2) {
        this.ery = j2;
        return this;
    }

    public final en mO(long j2) {
        this.eDD = j2;
        return this;
    }

    public final en mP(long j2) {
        this.eDE = j2;
        return this;
    }

    public final en rA(String str) {
        AppMethodBeat.i(209238);
        this.eDF = x("PlayFormat", str, true);
        AppMethodBeat.o(209238);
        return this;
    }

    public final en rB(String str) {
        AppMethodBeat.i(209239);
        this.erH = x("ClickTabContextId", str, true);
        AppMethodBeat.o(209239);
        return this;
    }

    public final en rC(String str) {
        AppMethodBeat.i(209240);
        this.eoz = x("ContextId", str, true);
        AppMethodBeat.o(209240);
        return this;
    }

    public final en rD(String str) {
        AppMethodBeat.i(209241);
        this.eoo = x("SessionBuffer", str, true);
        AppMethodBeat.o(209241);
        return this;
    }

    public final en mQ(long j2) {
        this.eDG = j2;
        return this;
    }

    public final en lf(int i2) {
        this.enZ = i2;
        return this;
    }

    public final en lg(int i2) {
        this.eDH = i2;
        return this;
    }

    public final en mR(long j2) {
        this.eDI = j2;
        return this;
    }

    public final long afS() {
        return this.eDI;
    }

    public final en lh(int i2) {
        this.eDJ = i2;
        return this;
    }

    public final en rE(String str) {
        AppMethodBeat.i(209242);
        this.eDK = x("PlayCodeFormat", str, true);
        AppMethodBeat.o(209242);
        return this;
    }

    public final en rF(String str) {
        AppMethodBeat.i(209243);
        this.eDL = x("PlayFileFormat", str, true);
        AppMethodBeat.o(209243);
        return this;
    }

    public final en li(int i2) {
        this.eDM = i2;
        return this;
    }

    public final en lj(int i2) {
        this.eDN = i2;
        return this;
    }

    public final en lk(int i2) {
        this.eDO = i2;
        return this;
    }

    public final en rG(String str) {
        AppMethodBeat.i(209244);
        this.eDP = x("PlayFormatJson", str, true);
        AppMethodBeat.o(209244);
        return this;
    }

    public final en rH(String str) {
        AppMethodBeat.i(209245);
        this.esZ = x("ExtraInfo", str, true);
        AppMethodBeat.o(209245);
        return this;
    }

    public final en rI(String str) {
        AppMethodBeat.i(209246);
        this.eta = x("enterSourceInfo", str, true);
        AppMethodBeat.o(209246);
        return this;
    }

    public final en rJ(String str) {
        AppMethodBeat.i(209247);
        this.eui = x("LongVideoId", str, true);
        AppMethodBeat.o(209247);
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(168932);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.eCT);
        stringBuffer.append(",");
        stringBuffer.append(this.ejC);
        stringBuffer.append(",");
        stringBuffer.append(this.erW);
        stringBuffer.append(",");
        stringBuffer.append(this.ewu);
        stringBuffer.append(",");
        stringBuffer.append(this.eCU);
        stringBuffer.append(",");
        stringBuffer.append(this.eCV);
        stringBuffer.append(",");
        stringBuffer.append(this.eCW);
        stringBuffer.append(",");
        stringBuffer.append(this.elK);
        stringBuffer.append(",");
        stringBuffer.append(this.eCX);
        stringBuffer.append(",");
        stringBuffer.append(this.eCY);
        stringBuffer.append(",");
        stringBuffer.append(this.eCZ);
        stringBuffer.append(",");
        stringBuffer.append(this.eDa);
        stringBuffer.append(",");
        stringBuffer.append(this.eDb);
        stringBuffer.append(",");
        stringBuffer.append(this.eDc);
        stringBuffer.append(",");
        stringBuffer.append(this.ejm);
        stringBuffer.append(",");
        stringBuffer.append(this.eiB);
        stringBuffer.append(",");
        stringBuffer.append(this.eDd);
        stringBuffer.append(",");
        stringBuffer.append(this.eDe);
        stringBuffer.append(",");
        stringBuffer.append(this.eDf);
        stringBuffer.append(",");
        stringBuffer.append(this.eDg);
        stringBuffer.append(",");
        stringBuffer.append(this.eDh);
        stringBuffer.append(",");
        stringBuffer.append(this.erz);
        stringBuffer.append(",");
        stringBuffer.append(this.eDi);
        stringBuffer.append(",");
        stringBuffer.append(this.eDj);
        stringBuffer.append(",");
        stringBuffer.append(this.eDk);
        stringBuffer.append(",");
        stringBuffer.append(this.eDl);
        stringBuffer.append(",");
        stringBuffer.append(this.eDm);
        stringBuffer.append(",");
        stringBuffer.append(this.eDn);
        stringBuffer.append(",");
        stringBuffer.append(this.eDo);
        stringBuffer.append(",");
        stringBuffer.append(this.eDp);
        stringBuffer.append(",");
        stringBuffer.append(this.eDq);
        stringBuffer.append(",");
        stringBuffer.append(this.eDr);
        stringBuffer.append(",");
        stringBuffer.append(this.eDs);
        stringBuffer.append(",");
        stringBuffer.append(this.eDt);
        stringBuffer.append(",");
        stringBuffer.append(this.eDu);
        stringBuffer.append(",");
        stringBuffer.append(this.eDv);
        stringBuffer.append(",");
        stringBuffer.append(this.eDw);
        stringBuffer.append(",");
        stringBuffer.append(this.eDx);
        stringBuffer.append(",");
        stringBuffer.append(this.eDy);
        stringBuffer.append(",");
        stringBuffer.append(this.etW);
        stringBuffer.append(",");
        stringBuffer.append(this.eDz);
        stringBuffer.append(",");
        stringBuffer.append(this.eDA);
        stringBuffer.append(",");
        stringBuffer.append(this.eDB);
        stringBuffer.append(",");
        stringBuffer.append(this.eDC);
        stringBuffer.append(",");
        stringBuffer.append(this.ery);
        stringBuffer.append(",");
        stringBuffer.append(this.eDD);
        stringBuffer.append(",");
        stringBuffer.append(this.eDE);
        stringBuffer.append(",");
        stringBuffer.append(this.eDF);
        stringBuffer.append(",");
        stringBuffer.append(this.erH);
        stringBuffer.append(",");
        stringBuffer.append(this.eoz);
        stringBuffer.append(",");
        stringBuffer.append(this.eoo);
        stringBuffer.append(",");
        stringBuffer.append(this.eDG);
        stringBuffer.append(",");
        stringBuffer.append(this.enZ);
        stringBuffer.append(",");
        stringBuffer.append(this.eDH);
        stringBuffer.append(",");
        stringBuffer.append(this.eDI);
        stringBuffer.append(",");
        stringBuffer.append(this.eDJ);
        stringBuffer.append(",");
        stringBuffer.append(this.eDK);
        stringBuffer.append(",");
        stringBuffer.append(this.eDL);
        stringBuffer.append(",");
        stringBuffer.append(this.eDM);
        stringBuffer.append(",");
        stringBuffer.append(this.eDN);
        stringBuffer.append(",");
        stringBuffer.append(this.eDO);
        stringBuffer.append(",");
        stringBuffer.append(this.eDP);
        stringBuffer.append(",");
        stringBuffer.append(this.esZ);
        stringBuffer.append(",");
        stringBuffer.append(this.eta);
        stringBuffer.append(",");
        stringBuffer.append(this.eui);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(168932);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(168933);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("FeedId:").append(this.eCT);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("MediaId:").append(this.ejC);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Scene:").append(this.erW);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Duration:").append(this.ewu);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("PlayTime:").append(this.eCU);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("HitPreload:").append(this.eCV);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("HitPreloadPercent:").append(this.eCW);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("FileSize:").append(this.elK);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("FirstLoadTime:").append(this.eCX);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("PlayPercent:").append(this.eCY);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("DownloadFinishTime:").append(this.eCZ);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("MoovReadyTime:").append(this.eDa);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("MoovReadyOffset:").append(this.eDb);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("StartPlayTime:").append(this.eDc);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("NetType:").append(this.ejm);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("SessionId:").append(this.eiB);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Position:").append(this.eDd);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("PageIndex:").append(this.eDe);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("DownloadPercent:").append(this.eDf);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("FirstPlay:").append(this.eDg);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ReplayCount:").append(this.eDh);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("InnerVersion:").append(this.erz);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("PlayStatus:").append(this.eDi);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("DownloadSpeed:").append(this.eDj);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("PauseTotalTime:").append(this.eDk);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("RealPlayTime:").append(this.eDl);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("FirstFrameTime:").append(this.eDm);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("NewFeedId:").append(this.eDn);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("WaittingCount:").append(this.eDo);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("FetchTimestamp:").append(this.eDp);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("HistoryPlayInfo:").append(this.eDq);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("FirstRequestDataOffset:").append(this.eDr);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("PlayDownloadSpeed:").append(this.eDs);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("NetTypeInt:").append(this.eDt);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("PlayWaittingCount:").append(this.eDu);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("RttMsg:").append(this.eDv);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("SvrIp:").append(this.eDw);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("SvrPort:").append(this.eDx);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("WaitingDetails:").append(this.eDy);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Username:").append(this.etW);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("PreloadStrategyId:").append(this.eDz);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("useTPPlayer:").append(this.eDA);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("PlayProgressInfo:").append(this.eDB);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("VoiceInfo:").append(this.eDC);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("CommentScene:").append(this.ery);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("IsSeek:").append(this.eDD);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("IsPause:").append(this.eDE);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("PlayFormat:").append(this.eDF);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ClickTabContextId:").append(this.erH);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ContextId:").append(this.eoz);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("SessionBuffer:").append(this.eoo);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("VideoMode:").append(this.eDG);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ErrCode:").append(this.enZ);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("PlayerErrCode:").append(this.eDH);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("TotalWaittingTime:").append(this.eDI);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("videoBitrate:").append(this.eDJ);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("PlayCodeFormat:").append(this.eDK);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("PlayFileFormat:").append(this.eDL);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("PlayAudioBitrate:").append(this.eDM);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("FrameRate:").append(this.eDN);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("VideoResolution:").append(this.eDO);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("PlayFormatJson:").append(this.eDP);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ExtraInfo:").append(this.esZ);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("enterSourceInfo:").append(this.eta);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("LongVideoId:").append(this.eui);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(168933);
        return stringBuffer2;
    }
}
