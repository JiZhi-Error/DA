package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;

public final class t extends com.tencent.mm.plugin.report.a {
    public String ela = "";
    public long elb = 0;
    public a elc;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 15586;
    }

    public enum a {
        NoDownLoad(0),
        DownLoading(1),
        DownLoaded(2),
        DownLoadFail(3);
        
        final int value;

        public static a valueOf(String str) {
            AppMethodBeat.i(43446);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(43446);
            return aVar;
        }

        static {
            AppMethodBeat.i(43447);
            AppMethodBeat.o(43447);
        }

        private a(int i2) {
            this.value = i2;
        }
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        int i2;
        AppMethodBeat.i(43448);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.ela);
        stringBuffer.append(",");
        stringBuffer.append(this.elb);
        stringBuffer.append(",");
        if (this.elc != null) {
            i2 = this.elc.value;
        } else {
            i2 = -1;
        }
        stringBuffer.append(i2);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(43448);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(43449);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Url:").append(this.ela);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("DownLoadCostStampMs:").append(this.elb);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("PreLoadStatus:").append(this.elc);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(43449);
        return stringBuffer2;
    }
}
