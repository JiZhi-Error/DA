package com.tencent.mm.g.b.a;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Arrays;

public final class as extends a {
    public long eqk;
    public int eql;
    public int eqm;
    private String eqn = "";
    private String eqo = "";
    private String eqp = "";

    public as() {
    }

    public as(String str) {
        String[] split;
        String[] strArr;
        AppMethodBeat.i(108282);
        if (!(str == null || (split = str.split(",")) == null)) {
            if (split.length < 6) {
                strArr = new String[6];
                Arrays.fill(strArr, 0, 6, "");
                System.arraycopy(split, 0, strArr, 0, split.length);
            } else {
                strArr = split;
            }
            this.eqk = Util.getLong(strArr[0], 0);
            this.eql = Util.getInt(strArr[1], 0);
            this.eqm = Util.getInt(strArr[2], 0);
            ix(strArr[3]);
            iy(strArr[4]);
            iz(strArr[5]);
        }
        AppMethodBeat.o(108282);
    }

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 18662;
    }

    public final as ix(String str) {
        AppMethodBeat.i(108283);
        this.eqn = x("pid", str, true);
        AppMethodBeat.o(108283);
        return this;
    }

    public final as iy(String str) {
        AppMethodBeat.i(108284);
        this.eqo = x("info", str, true);
        AppMethodBeat.o(108284);
        return this;
    }

    public final as iz(String str) {
        AppMethodBeat.i(108285);
        this.eqp = x(FirebaseAnalytics.b.INDEX, str, true);
        AppMethodBeat.o(108285);
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(108286);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.eqk);
        stringBuffer.append(",");
        stringBuffer.append(this.eql);
        stringBuffer.append(",");
        stringBuffer.append(this.eqm);
        stringBuffer.append(",");
        stringBuffer.append(this.eqn);
        stringBuffer.append(",");
        stringBuffer.append(this.eqo);
        stringBuffer.append(",");
        stringBuffer.append(this.eqp);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(108286);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(108287);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("EnterTime:").append(this.eqk);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("scene:").append(this.eql);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("action:").append(this.eqm);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("pid:").append(this.eqn);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("info:").append(this.eqo);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("index:").append(this.eqp);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(108287);
        return stringBuffer2;
    }
}
