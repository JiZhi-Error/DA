package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Arrays;

public final class gw extends a {
    private String eHv = "";
    public long eHw = 0;
    public long eHx = 0;
    public long eLd = 0;
    private long eLe = 0;
    private boolean eLf;
    public long erY = 0;
    public int euv = 0;
    private String euw = "";

    public gw() {
    }

    public gw(String str) {
        String[] split;
        String[] strArr;
        AppMethodBeat.i(121758);
        if (!(str == null || (split = str.split(",")) == null)) {
            if (split.length < 9) {
                strArr = new String[9];
                Arrays.fill(strArr, 0, 9, "");
                System.arraycopy(split, 0, strArr, 0, split.length);
            } else {
                strArr = split;
            }
            this.euv = Util.getInt(strArr[0], 0);
            uJ(strArr[1]);
            this.eLd = Util.getLong(strArr[2], 0);
            uK(strArr[3]);
            this.erY = Util.getLong(strArr[4], 0);
            qH(Util.getLong(strArr[5], 0));
            this.eLe = Util.getLong(strArr[6], 0);
            this.eLf = a.getBoolean(strArr[7]);
            this.eHx = Util.getLong(strArr[8], 0);
        }
        AppMethodBeat.o(121758);
    }

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 15885;
    }

    public final gw uJ(String str) {
        AppMethodBeat.i(121759);
        this.euw = x("PName", str, true);
        AppMethodBeat.o(121759);
        return this;
    }

    public final gw uK(String str) {
        AppMethodBeat.i(121760);
        this.eHv = x("Name", str, true);
        AppMethodBeat.o(121760);
        return this;
    }

    public final gw qH(long j2) {
        AppMethodBeat.i(121761);
        this.eHw = j2;
        super.bj("TimeStampMs", this.eHw);
        AppMethodBeat.o(121761);
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(121762);
        String uL = uL(",");
        AppMethodBeat.o(121762);
        return uL;
    }

    public final String uL(String str) {
        int i2;
        AppMethodBeat.i(121763);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.euv);
        stringBuffer.append(str);
        stringBuffer.append(this.euw);
        stringBuffer.append(str);
        stringBuffer.append(this.eLd);
        stringBuffer.append(str);
        stringBuffer.append(this.eHv);
        stringBuffer.append(str);
        stringBuffer.append(this.erY);
        stringBuffer.append(str);
        stringBuffer.append(this.eHw);
        stringBuffer.append(str);
        stringBuffer.append(this.eLe);
        stringBuffer.append(str);
        if (this.eLf) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        stringBuffer.append(i2);
        stringBuffer.append(str);
        stringBuffer.append(this.eHx);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(121763);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(121764);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("PID:").append(this.euv);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("PName:").append(this.euw);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Seq:").append(this.eLd);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Name:").append(this.eHv);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Type:").append(this.erY);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("TimeStampMs:").append(this.eHw);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("GreenManFg:").append(this.eLe);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("QueueFgBool:").append(this.eLf);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("HashCode:").append(this.eHx);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(121764);
        return stringBuffer2;
    }
}
