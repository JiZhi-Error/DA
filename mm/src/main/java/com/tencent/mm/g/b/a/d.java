package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Arrays;

public final class d extends a {
    public boolean eiJ;
    public long eiK;
    public long eiL;
    private String eiM = "";
    public long eiU;
    private String eiV = "";
    public int eiW;
    public int eiX;
    public String eiY = "";
    public long eiZ;
    public long eja;
    public int ejb;
    public int ejc;
    public long ejd;
    public long eje;
    public long ejf;
    private long ejg;
    public long ejh;
    public long eji;
    public String ejj = "";
    public long ejk;
    public String ejl = "";
    private String ejm = "";
    public int ejn;

    public d() {
    }

    public d(String str) {
        String[] split;
        String[] strArr;
        AppMethodBeat.i(238830);
        if (!(str == null || (split = str.split(",")) == null)) {
            if (split.length < 24) {
                strArr = new String[24];
                Arrays.fill(strArr, 0, 24, "");
                System.arraycopy(split, 0, strArr, 0, split.length);
            } else {
                strArr = split;
            }
            this.eiU = Util.getLong(strArr[0], 0);
            this.eiJ = a.getBoolean(strArr[1]);
            bG(Util.getLong(strArr[2], 0));
            this.eiL = Util.getLong(strArr[3], 0);
            hG(strArr[4]);
            this.eiW = Util.getInt(strArr[5], 0);
            this.eiX = Util.getInt(strArr[6], 0);
            hH(strArr[7]);
            this.eiZ = Util.getLong(strArr[8], 0);
            this.eja = Util.getLong(strArr[9], 0);
            hI(strArr[10]);
            this.ejb = Util.getInt(strArr[11], 0);
            this.ejc = Util.getInt(strArr[12], 0);
            this.ejd = Util.getLong(strArr[13], 0);
            this.eje = Util.getLong(strArr[14], 0);
            this.ejf = Util.getLong(strArr[15], 0);
            bH(Util.getLong(strArr[16], 0));
            this.ejh = Util.getLong(strArr[17], 0);
            this.eji = Util.getLong(strArr[18], 0);
            hJ(strArr[19]);
            this.ejk = Util.getLong(strArr[20], 0);
            hK(strArr[21]);
            hL(strArr[22]);
            this.ejn = Util.getInt(strArr[23], 0);
        }
        AppMethodBeat.o(238830);
    }

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 20964;
    }

    public final d bG(long j2) {
        AppMethodBeat.i(238831);
        this.eiK = j2;
        super.bj("LastEnterFinderTimeStampMs", this.eiK);
        AppMethodBeat.o(238831);
        return this;
    }

    public final d hG(String str) {
        AppMethodBeat.i(238832);
        this.eiV = x("LastFinderRedDotTipsId", str, true);
        AppMethodBeat.o(238832);
        return this;
    }

    public final d hH(String str) {
        AppMethodBeat.i(238833);
        this.eiY = x("LastSessionId", str, true);
        AppMethodBeat.o(238833);
        return this;
    }

    public final d hI(String str) {
        AppMethodBeat.i(238834);
        this.eiM = x("FinderRedDotTipsId", str, true);
        AppMethodBeat.o(238834);
        return this;
    }

    public final d bH(long j2) {
        AppMethodBeat.i(238835);
        this.ejg = j2;
        super.bj("EnterFinderTimeStampMs", this.ejg);
        AppMethodBeat.o(238835);
        return this;
    }

    public final d hJ(String str) {
        AppMethodBeat.i(238836);
        this.ejj = x("FindFriendUIExposure", str, true);
        AppMethodBeat.o(238836);
        return this;
    }

    public final d hK(String str) {
        AppMethodBeat.i(238837);
        this.ejl = x("WechatDurationNMinute", str, true);
        AppMethodBeat.o(238837);
        return this;
    }

    public final d hL(String str) {
        AppMethodBeat.i(238838);
        this.ejm = x("NetType", str, true);
        AppMethodBeat.o(238838);
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        int i2;
        AppMethodBeat.i(238839);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.eiU);
        stringBuffer.append(",");
        if (this.eiJ) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        stringBuffer.append(i2);
        stringBuffer.append(",");
        stringBuffer.append(this.eiK);
        stringBuffer.append(",");
        stringBuffer.append(this.eiL);
        stringBuffer.append(",");
        stringBuffer.append(this.eiV);
        stringBuffer.append(",");
        stringBuffer.append(this.eiW);
        stringBuffer.append(",");
        stringBuffer.append(this.eiX);
        stringBuffer.append(",");
        stringBuffer.append(this.eiY);
        stringBuffer.append(",");
        stringBuffer.append(this.eiZ);
        stringBuffer.append(",");
        stringBuffer.append(this.eja);
        stringBuffer.append(",");
        stringBuffer.append(this.eiM);
        stringBuffer.append(",");
        stringBuffer.append(this.ejb);
        stringBuffer.append(",");
        stringBuffer.append(this.ejc);
        stringBuffer.append(",");
        stringBuffer.append(this.ejd);
        stringBuffer.append(",");
        stringBuffer.append(this.eje);
        stringBuffer.append(",");
        stringBuffer.append(this.ejf);
        stringBuffer.append(",");
        stringBuffer.append(this.ejg);
        stringBuffer.append(",");
        stringBuffer.append(this.ejh);
        stringBuffer.append(",");
        stringBuffer.append(this.eji);
        stringBuffer.append(",");
        stringBuffer.append(this.ejj);
        stringBuffer.append(",");
        stringBuffer.append(this.ejk);
        stringBuffer.append(",");
        stringBuffer.append(this.ejl);
        stringBuffer.append(",");
        stringBuffer.append(this.ejm);
        stringBuffer.append(",");
        stringBuffer.append(this.ejn);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(238839);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(238840);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("IsEnterFinderUI:").append(this.eiU);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("NewMsgOpenWechatBool:").append(this.eiJ);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("LastEnterFinderTimeStampMs:").append(this.eiK);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("LastFinderStayTime:").append(this.eiL);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("LastFinderRedDotTipsId:").append(this.eiV);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("LastFinderRedDotCtrlType:").append(this.eiW);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("LastFinderRedDotShowType:").append(this.eiX);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("LastSessionId:").append(this.eiY);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("FriendsTabRedDot:").append(this.eiZ);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("FriendsTabRedUnread:").append(this.eja);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("FinderRedDotTipsId:").append(this.eiM);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("FinderRedDotCtrlType:").append(this.ejb);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("FinderRedDotShowType:").append(this.ejc);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("SnsRedDot:").append(this.ejd);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("SnsUnread:").append(this.eje);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("TopStoryRedDot:").append(this.ejf);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("EnterFinderTimeStampMs:").append(this.ejg);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("FinderStayTime:").append(this.ejh);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("LastSessionDuration:").append(this.eji);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("FindFriendUIExposure:").append(this.ejj);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("WechatDuration7DayHour:").append(this.ejk);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("WechatDurationNMinute:").append(this.ejl);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("NetType:").append(this.ejm);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("WechatUseCount:").append(this.ejn);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(238840);
        return stringBuffer2;
    }
}
