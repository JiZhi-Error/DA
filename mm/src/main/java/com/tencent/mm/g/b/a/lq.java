package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class lq extends a {
    public long eZm = 0;
    public long eZn = 0;
    public long eZo = 0;
    public long eZp = 0;
    public long eZq = 0;

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 15401;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(43478);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.eZm);
        stringBuffer.append(",");
        stringBuffer.append(this.eZn);
        stringBuffer.append(",");
        stringBuffer.append(this.eZo);
        stringBuffer.append(",");
        stringBuffer.append(this.eZp);
        stringBuffer.append(",");
        stringBuffer.append(this.eZq);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(43478);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(43479);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("AllPackageSize:").append(this.eZm);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("AllPackageClientStoragePercent:").append(this.eZn);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ClientStorageFreePercent:").append(this.eZo);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("AbtestStatus:").append(this.eZp);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("WeappCountThatHasPackage:").append(this.eZq);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(43479);
        return stringBuffer2;
    }
}
