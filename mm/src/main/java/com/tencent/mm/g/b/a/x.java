package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.sdk.platformtools.Util;

public final class x extends com.tencent.mm.plugin.report.a {
    public String emL = "";
    public long emM = 0;
    public long emN = 0;
    public long emO = 0;
    public boolean emP;
    public long emQ = 0;
    public long emR = 0;
    public long emS = 0;
    private long emT = 0;
    private long emU = 0;
    public a emV;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 15749;
    }

    public enum a {
        ok(0),
        cancel(1),
        error(2);
        
        final int value;

        public static a valueOf(String str) {
            AppMethodBeat.i(19858);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(19858);
            return aVar;
        }

        static {
            AppMethodBeat.i(19859);
            AppMethodBeat.o(19859);
        }

        private a(int i2) {
            this.value = i2;
        }
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        int i2;
        int i3;
        AppMethodBeat.i(19862);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.emL);
        stringBuffer.append(",");
        stringBuffer.append(this.emM);
        stringBuffer.append(",");
        stringBuffer.append(this.emN);
        stringBuffer.append(",");
        stringBuffer.append(this.emO);
        stringBuffer.append(",");
        if (this.emP) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        stringBuffer.append(i2);
        stringBuffer.append(",");
        stringBuffer.append(this.emQ);
        stringBuffer.append(",");
        stringBuffer.append(this.emR);
        stringBuffer.append(",");
        stringBuffer.append(this.emS);
        stringBuffer.append(",");
        stringBuffer.append(this.emT);
        stringBuffer.append(",");
        stringBuffer.append(this.emU);
        stringBuffer.append(",");
        if (this.emV != null) {
            i3 = this.emV.value;
        } else {
            i3 = -1;
        }
        stringBuffer.append(i3);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(19862);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(19863);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("ChatName:").append(this.emL);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("MemberCount:").append(this.emM);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("MsgSvrId:").append(this.emN);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("MsgCreateTime:").append(this.emO);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("IsHdImgBool:").append(this.emP);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ImgSize:").append(this.emQ);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ImgWidth:").append(this.emR);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ImgHeight:").append(this.emS);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("StartDownloadTimeStampMs:").append(this.emT);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("FinishDownloadTimeStampMs:").append(this.emU);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("FinishCode:").append(this.emV);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(19863);
        return stringBuffer2;
    }

    public final x acb() {
        AppMethodBeat.i(19860);
        this.emT = Util.nowMilliSecond();
        super.bj("StartDownloadTimeStampMs", this.emT);
        AppMethodBeat.o(19860);
        return this;
    }

    public final x acc() {
        AppMethodBeat.i(19861);
        this.emU = Util.nowMilliSecond();
        super.bj("FinishDownloadTimeStampMs", this.emU);
        AppMethodBeat.o(19861);
        return this;
    }
}
