package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Arrays;

public final class hl extends a {
    public long eLY = 0;
    public long eLZ = 0;
    public String eMa = "";
    public boolean eMb;

    public hl() {
    }

    public hl(String str) {
        String[] split;
        String[] strArr;
        AppMethodBeat.i(121765);
        if (!(str == null || (split = str.split(",")) == null)) {
            if (split.length < 4) {
                strArr = new String[4];
                Arrays.fill(strArr, 0, 4, "");
                System.arraycopy(split, 0, strArr, 0, split.length);
            } else {
                strArr = split;
            }
            this.eLY = Util.getLong(strArr[0], 0);
            qQ(Util.getLong(strArr[1], 0));
            vi(strArr[2]);
            this.eMb = a.getBoolean(strArr[3]);
        }
        AppMethodBeat.o(121765);
    }

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 0;
    }

    private hl qQ(long j2) {
        AppMethodBeat.i(121766);
        this.eLZ = j2;
        super.bk("StartTimeStampSec", this.eLZ);
        AppMethodBeat.o(121766);
        return this;
    }

    public final hl vi(String str) {
        AppMethodBeat.i(121768);
        this.eMa = x("Roomname", str, true);
        AppMethodBeat.o(121768);
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        int i2;
        AppMethodBeat.i(121769);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.eLY);
        stringBuffer.append(",");
        stringBuffer.append(this.eLZ);
        stringBuffer.append(",");
        stringBuffer.append(this.eMa);
        stringBuffer.append(",");
        if (this.eMb) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        stringBuffer.append(i2);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(121769);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(121770);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("ExptFlag:").append(this.eLY);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("StartTimeStampSec:").append(this.eLZ);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Roomname:").append(this.eMa);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("hardcodeExptBool:").append(this.eMb);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(121770);
        return stringBuffer2;
    }

    public final hl agZ() {
        AppMethodBeat.i(121767);
        hl qQ = qQ(Util.nowSecond());
        AppMethodBeat.o(121767);
        return qQ;
    }
}
