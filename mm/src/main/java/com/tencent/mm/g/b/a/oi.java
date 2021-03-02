package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Arrays;

public final class oi extends a {
    private String ejs = "";
    private String ejt = "";
    private String eju = "";
    private long ejv;
    private long ejw;
    private long ejx;
    private String oqA = "";
    private String oqC = "";
    private String oqG = "";
    private String oqH = "";
    private String oqI = "";
    private String oqJ = "";
    private String oqO = "";
    private String oqP = "";
    private String oqw = "";
    private String oqx = "";
    private String oqy = "";
    private String oqz = "";

    public oi() {
    }

    public oi(String str) {
        String[] split;
        String[] strArr;
        AppMethodBeat.i(259575);
        if (!(str == null || (split = str.split(",")) == null)) {
            if (split.length < 18) {
                strArr = new String[18];
                Arrays.fill(strArr, 0, 18, "");
                System.arraycopy(split, 0, strArr, 0, split.length);
            } else {
                strArr = split;
            }
            this.ejs = x("lastSessionId", strArr[0], true);
            this.ejt = x("currSessionId", strArr[1], true);
            this.eju = x("nextSessionId", strArr[2], true);
            this.ejv = Util.getLong(strArr[3], 0);
            this.ejw = Util.getLong(strArr[4], 0);
            this.ejx = Util.getLong(strArr[5], 0);
            this.oqw = x("Sns", strArr[6], true);
            this.oqx = x("SeePeopleNearBy", strArr[7], true);
            this.oqy = x("Shake", strArr[8], true);
            this.oqz = x("Scan", strArr[9], true);
            this.oqA = x("Game", strArr[10], true);
            this.oqC = x("JDStore", strArr[11], true);
            this.oqG = x("AppBrand", strArr[12], true);
            this.oqH = x("WCO", strArr[13], true);
            this.oqI = x("Browse", strArr[14], true);
            this.oqJ = x("Search", strArr[15], true);
            this.oqO = x("Nearby", strArr[16], true);
            this.oqP = x("Finder", strArr[17], true);
        }
        AppMethodBeat.o(259575);
    }

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 22376;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(259576);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.ejs);
        stringBuffer.append(",");
        stringBuffer.append(this.ejt);
        stringBuffer.append(",");
        stringBuffer.append(this.eju);
        stringBuffer.append(",");
        stringBuffer.append(this.ejv);
        stringBuffer.append(",");
        stringBuffer.append(this.ejw);
        stringBuffer.append(",");
        stringBuffer.append(this.ejx);
        stringBuffer.append(",");
        stringBuffer.append(this.oqw);
        stringBuffer.append(",");
        stringBuffer.append(this.oqx);
        stringBuffer.append(",");
        stringBuffer.append(this.oqy);
        stringBuffer.append(",");
        stringBuffer.append(this.oqz);
        stringBuffer.append(",");
        stringBuffer.append(this.oqA);
        stringBuffer.append(",");
        stringBuffer.append(this.oqC);
        stringBuffer.append(",");
        stringBuffer.append(this.oqG);
        stringBuffer.append(",");
        stringBuffer.append(this.oqH);
        stringBuffer.append(",");
        stringBuffer.append(this.oqI);
        stringBuffer.append(",");
        stringBuffer.append(this.oqJ);
        stringBuffer.append(",");
        stringBuffer.append(this.oqO);
        stringBuffer.append(",");
        stringBuffer.append(this.oqP);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(259576);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(259577);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("lastSessionId:").append(this.ejs);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("currSessionId:").append(this.ejt);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("nextSessionId:").append(this.eju);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("currSessionEnterMs:").append(this.ejv);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("currSessionQuitMs:").append(this.ejw);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("currSessionStayTime:").append(this.ejx);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Sns:").append(this.oqw);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("SeePeopleNearBy:").append(this.oqx);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Shake:").append(this.oqy);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Scan:").append(this.oqz);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Game:").append(this.oqA);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("JDStore:").append(this.oqC);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("AppBrand:").append(this.oqG);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("WCO:").append(this.oqH);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Browse:").append(this.oqI);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Search:").append(this.oqJ);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Nearby:").append(this.oqO);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Finder:").append(this.oqP);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(259577);
        return stringBuffer2;
    }
}
