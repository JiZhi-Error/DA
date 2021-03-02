package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Arrays;

public final class b extends a {
    public boolean eiJ;
    public long eiK = 0;
    public long eiL = 0;
    public String eiM = "";
    public long eiN = 0;
    public long eiO = 0;

    public b() {
    }

    public b(String str) {
        String[] split;
        String[] strArr;
        AppMethodBeat.i(238823);
        if (!(str == null || (split = str.split(",")) == null)) {
            if (split.length < 6) {
                strArr = new String[6];
                Arrays.fill(strArr, 0, 6, "");
                System.arraycopy(split, 0, strArr, 0, split.length);
            } else {
                strArr = split;
            }
            this.eiJ = a.getBoolean(strArr[0]);
            bF(Util.getLong(strArr[1], 0));
            this.eiL = Util.getLong(strArr[2], 0);
            hF(strArr[3]);
            this.eiN = Util.getLong(strArr[4], 0);
            this.eiO = Util.getLong(strArr[5], 0);
        }
        AppMethodBeat.o(238823);
    }

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 0;
    }

    public final b bF(long j2) {
        AppMethodBeat.i(238824);
        this.eiK = j2;
        super.bj("LastEnterFinderTimeStampMs", this.eiK);
        AppMethodBeat.o(238824);
        return this;
    }

    public final b hF(String str) {
        AppMethodBeat.i(238825);
        this.eiM = x("FinderRedDotTipsId", str, true);
        AppMethodBeat.o(238825);
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        int i2;
        AppMethodBeat.i(238826);
        StringBuffer stringBuffer = new StringBuffer();
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
        stringBuffer.append(this.eiM);
        stringBuffer.append(",");
        stringBuffer.append(this.eiN);
        stringBuffer.append(",");
        stringBuffer.append(this.eiO);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(238826);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(238827);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("NewMsgOpenWechatBool:").append(this.eiJ);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("LastEnterFinderTimeStampMs:").append(this.eiK);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("LastFinderStayTime:").append(this.eiL);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("FinderRedDotTipsId:").append(this.eiM);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("FinderRedDotCtrlType:").append(this.eiN);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("FinderRedDotShowType:").append(this.eiO);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(238827);
        return stringBuffer2;
    }
}
