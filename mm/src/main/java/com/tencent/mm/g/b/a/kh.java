package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class kh extends a {
    private String eDC = "";
    private String eGT = "";
    public long ePF;
    private String ePf = "";
    private String eUA = "";
    private long eUB;
    private long eUC;
    public long eUD;
    private String eUE = "";
    public long eUF;
    public long eUG;
    private long eUH;
    private long eUI;
    private long eUJ;
    private long eUK;
    private long eUL;
    private long eUM;
    private long eUN;
    private String eUO = "";
    private String eUP = "";
    private String eUQ = "";
    private String eUR = "";
    private long eUS;
    private String eUT = "";
    private String eUU = "";
    public long eUV;
    public long eUW;
    private String eUX = "";
    private String eUY = "";
    public long eUg;
    public long eUh;
    public long eUi;
    public long eUj;
    private long eUk;
    private long eUl;
    private long eUm;
    private long eUn;
    private long eUo;
    private long eUp;
    private String eUq = "";
    public long eUr;
    public long eUs;
    public long eUt;
    public long eUu;
    public long eUv;
    public long eUw;
    private long eUx;
    public long eUy;
    public long eUz;
    private String eiB = "";
    private String eqv = "";

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 10991;
    }

    public final kh xo(String str) {
        AppMethodBeat.i(184512);
        this.eGT = x("SearchId", str, true);
        AppMethodBeat.o(184512);
        return this;
    }

    public final kh xp(String str) {
        AppMethodBeat.i(184513);
        this.eUq = x("ItemName", str, true);
        AppMethodBeat.o(184513);
        return this;
    }

    public final kh xq(String str) {
        AppMethodBeat.i(184514);
        this.eUA = x("UniSearchId", str, true);
        AppMethodBeat.o(184514);
        return this;
    }

    public final kh xr(String str) {
        AppMethodBeat.i(184515);
        this.eqv = x("Query", str, true);
        AppMethodBeat.o(184515);
        return this;
    }

    public final kh xs(String str) {
        AppMethodBeat.i(184516);
        this.eUE = x("HasSHowType", str, true);
        AppMethodBeat.o(184516);
        return this;
    }

    public final kh xt(String str) {
        AppMethodBeat.i(184517);
        this.eDC = x("VoiceInfo", str, true);
        AppMethodBeat.o(184517);
        return this;
    }

    public final kh xu(String str) {
        AppMethodBeat.i(184518);
        this.eiB = x("SessionId", str, true);
        AppMethodBeat.o(184518);
        return this;
    }

    public final kh xv(String str) {
        AppMethodBeat.i(184519);
        this.ePf = x("GroupId", str, true);
        AppMethodBeat.o(184519);
        return this;
    }

    public final kh xw(String str) {
        AppMethodBeat.i(184520);
        this.eUO = x("MatchStr", str, true);
        AppMethodBeat.o(184520);
        return this;
    }

    public final kh xx(String str) {
        AppMethodBeat.i(184521);
        this.eUP = x("MyRecentMsgCount", str, true);
        AppMethodBeat.o(184521);
        return this;
    }

    public final kh xy(String str) {
        AppMethodBeat.i(184522);
        this.eUQ = x("MyRecentSearchCount", str, true);
        AppMethodBeat.o(184522);
        return this;
    }

    public final kh xz(String str) {
        AppMethodBeat.i(184523);
        this.eUR = x("MyRecentSearchDays", str, true);
        AppMethodBeat.o(184523);
        return this;
    }

    public final kh xA(String str) {
        AppMethodBeat.i(184524);
        this.eUT = x("TophitsCount", str, true);
        AppMethodBeat.o(184524);
        return this;
    }

    public final kh xB(String str) {
        AppMethodBeat.i(184525);
        this.eUU = x("TrainScore", str, true);
        AppMethodBeat.o(184525);
        return this;
    }

    public final kh xC(String str) {
        AppMethodBeat.i(184526);
        this.eUX = x("strDocId", str, true);
        AppMethodBeat.o(184526);
        return this;
    }

    public final kh xD(String str) {
        AppMethodBeat.i(184527);
        this.eUY = x("ClickedAppId", str, true);
        AppMethodBeat.o(184527);
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(177570);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.eUg);
        stringBuffer.append(",");
        stringBuffer.append(this.eUh);
        stringBuffer.append(",");
        stringBuffer.append(this.eUi);
        stringBuffer.append(",");
        stringBuffer.append(this.eUj);
        stringBuffer.append(",");
        stringBuffer.append(this.eUk);
        stringBuffer.append(",");
        stringBuffer.append(this.eGT);
        stringBuffer.append(",");
        stringBuffer.append(this.eUl);
        stringBuffer.append(",");
        stringBuffer.append(this.eUm);
        stringBuffer.append(",");
        stringBuffer.append(this.eUn);
        stringBuffer.append(",");
        stringBuffer.append(this.eUo);
        stringBuffer.append(",");
        stringBuffer.append(this.eUp);
        stringBuffer.append(",");
        stringBuffer.append(this.eUq);
        stringBuffer.append(",");
        stringBuffer.append(this.ePF);
        stringBuffer.append(",");
        stringBuffer.append(this.eUr);
        stringBuffer.append(",");
        stringBuffer.append(this.eUs);
        stringBuffer.append(",");
        stringBuffer.append(this.eUt);
        stringBuffer.append(",");
        stringBuffer.append(this.eUu);
        stringBuffer.append(",");
        stringBuffer.append(this.eUv);
        stringBuffer.append(",");
        stringBuffer.append(this.eUw);
        stringBuffer.append(",");
        stringBuffer.append(this.eUx);
        stringBuffer.append(",");
        stringBuffer.append(this.eUy);
        stringBuffer.append(",");
        stringBuffer.append(this.eUz);
        stringBuffer.append(",");
        stringBuffer.append(this.eUA);
        stringBuffer.append(",");
        stringBuffer.append(this.eqv);
        stringBuffer.append(",");
        stringBuffer.append(this.eUB);
        stringBuffer.append(",");
        stringBuffer.append(this.eUC);
        stringBuffer.append(",");
        stringBuffer.append(this.eUD);
        stringBuffer.append(",");
        stringBuffer.append(this.eUE);
        stringBuffer.append(",");
        stringBuffer.append(this.eDC);
        stringBuffer.append(",");
        stringBuffer.append(this.eiB);
        stringBuffer.append(",");
        stringBuffer.append(this.eUF);
        stringBuffer.append(",");
        stringBuffer.append(this.eUG);
        stringBuffer.append(",");
        stringBuffer.append(this.eUH);
        stringBuffer.append(",");
        stringBuffer.append(this.eUI);
        stringBuffer.append(",");
        stringBuffer.append(this.eUJ);
        stringBuffer.append(",");
        stringBuffer.append(this.eUK);
        stringBuffer.append(",");
        stringBuffer.append(this.eUL);
        stringBuffer.append(",");
        stringBuffer.append(this.eUM);
        stringBuffer.append(",");
        stringBuffer.append(this.eUN);
        stringBuffer.append(",");
        stringBuffer.append(this.ePf);
        stringBuffer.append(",");
        stringBuffer.append(this.eUO);
        stringBuffer.append(",");
        stringBuffer.append(this.eUP);
        stringBuffer.append(",");
        stringBuffer.append(this.eUQ);
        stringBuffer.append(",");
        stringBuffer.append(this.eUR);
        stringBuffer.append(",");
        stringBuffer.append(this.eUS);
        stringBuffer.append(",");
        stringBuffer.append(this.eUT);
        stringBuffer.append(",");
        stringBuffer.append(this.eUU);
        stringBuffer.append(",");
        stringBuffer.append(this.eUV);
        stringBuffer.append(",");
        stringBuffer.append(this.eUW);
        stringBuffer.append(",");
        stringBuffer.append(this.eUX);
        stringBuffer.append(",");
        stringBuffer.append(this.eUY);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(177570);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(177571);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("SearchScene:").append(this.eUg);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ClickedType:").append(this.eUh);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ClickedRow:").append(this.eUi);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ClickSubType:").append(this.eUj);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ClickSubRow:").append(this.eUk);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("SearchId:").append(this.eGT);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("DocId:").append(this.eUl);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("MatchType:").append(this.eUm);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("GuideStyle:").append(this.eUn);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("QueryMatchType:").append(this.eUo);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("GroupMemberMatchType:").append(this.eUp);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ItemName:").append(this.eUq);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("BrowseTime:").append(this.ePF);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("NormalContactCount:").append(this.eUr);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("GroupContactCount:").append(this.eUs);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("BizContactCount:").append(this.eUt);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("MessageCount:").append(this.eUu);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("FeatureCount:").append(this.eUv);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("FavCount:").append(this.eUw);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("GameCount:").append(this.eUx);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("AddressBookCount:").append(this.eUy);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("WeAppCount:").append(this.eUz);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("UniSearchId:").append(this.eUA);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Query:").append(this.eqv);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("MiniGameCount:").append(this.eUB);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("BlockPosition:").append(this.eUC);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("IsVoiceInput:").append(this.eUD);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("HasSHowType:").append(this.eUE);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("VoiceInfo:").append(this.eDC);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("SessionId:").append(this.eiB);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("VoiceVer:").append(this.eUF);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("IsVoiceMod:").append(this.eUG);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("GroupLastActiveTime:").append(this.eUH);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("GroupMySelfLastActiveTime:").append(this.eUI);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("GroupMemberCount:").append(this.eUJ);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("IsMute:").append(this.eUK);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("GroupUnReadMsgCount:").append(this.eUL);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("GroupFriendsCount:").append(this.eUM);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("TrainFlag:").append(this.eUN);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("GroupId:").append(this.ePf);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("MatchStr:").append(this.eUO);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("MyRecentMsgCount:").append(this.eUP);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("MyRecentSearchCount:").append(this.eUQ);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("MyRecentSearchDays:").append(this.eUR);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("RecentSearchTime:").append(this.eUS);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("TophitsCount:").append(this.eUT);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("TrainScore:").append(this.eUU);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("NewSessionId:").append(this.eUV);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("NewSearchId:").append(this.eUW);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("strDocId:").append(this.eUX);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ClickedAppId:").append(this.eUY);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(177571);
        return stringBuffer2;
    }
}
