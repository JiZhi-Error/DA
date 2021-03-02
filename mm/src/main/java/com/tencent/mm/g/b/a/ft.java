package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Arrays;

public final class ft extends a {
    public String eHv = "";
    public long eHw = 0;
    public long eHx = 0;
    public long erY = 0;

    public ft() {
    }

    public ft(String str) {
        String[] split;
        String[] strArr;
        AppMethodBeat.i(121753);
        if (!(str == null || (split = str.split(",")) == null)) {
            if (split.length < 4) {
                strArr = new String[4];
                Arrays.fill(strArr, 0, 4, "");
                System.arraycopy(split, 0, strArr, 0, split.length);
            } else {
                strArr = split;
            }
            sK(strArr[0]);
            this.erY = Util.getLong(strArr[1], 0);
            pk(Util.getLong(strArr[2], 0));
            this.eHx = Util.getLong(strArr[3], 0);
        }
        AppMethodBeat.o(121753);
    }

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 0;
    }

    public final ft sK(String str) {
        AppMethodBeat.i(121754);
        this.eHv = x("Name", str, true);
        AppMethodBeat.o(121754);
        return this;
    }

    public final ft pk(long j2) {
        AppMethodBeat.i(121755);
        this.eHw = j2;
        super.bj("TimeStampMs", this.eHw);
        AppMethodBeat.o(121755);
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(121756);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.eHv);
        stringBuffer.append(",");
        stringBuffer.append(this.erY);
        stringBuffer.append(",");
        stringBuffer.append(this.eHw);
        stringBuffer.append(",");
        stringBuffer.append(this.eHx);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(121756);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(121757);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Name:").append(this.eHv);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Type:").append(this.erY);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("TimeStampMs:").append(this.eHw);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("HashCode:").append(this.eHx);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(121757);
        return stringBuffer2;
    }
}
