package com.tencent.mm.plugin.expt.hellhound.a.f.f;

import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.List;

public final class d extends a {
    private long eLd = 0;
    private int eMF = 0;
    private long eMG = 0;
    private long eMH = 0;
    private String eMI = "";
    private String euw = "";
    private int sIQ = 0;

    public static boolean aV(int i2, String str) {
        AppMethodBeat.i(122222);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(122222);
            return false;
        } else if (i2 <= 0) {
            AppMethodBeat.o(122222);
            return false;
        } else {
            List<String> aMr = a.aMr(str.replace(',', '#'));
            if (aMr != null) {
                d dVar = new d(i2);
                dVar.eMF = Process.myPid();
                dVar.euw = dVar.x("PName", g.aAe().azG().mProcessName, true);
                dVar.eLd = (long) a.eOr();
                dVar.eMH = (long) aMr.size();
                for (int i3 = 0; i3 < aMr.size(); i3++) {
                    dVar.eMG = (long) i3;
                    dVar.eMI = dVar.x("DataContent", aMr.get(i3), false);
                    dVar.bfK();
                }
            }
            AppMethodBeat.o(122222);
            return true;
        }
    }

    private d(int i2) {
        this.sIQ = i2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return this.sIQ;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(122223);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.eMF);
        stringBuffer.append(",");
        stringBuffer.append(this.euw);
        stringBuffer.append(",");
        stringBuffer.append(this.eLd);
        stringBuffer.append(",");
        stringBuffer.append(this.eMG);
        stringBuffer.append(",");
        stringBuffer.append(this.eMH);
        stringBuffer.append(",");
        stringBuffer.append(this.eMI);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(122223);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(122224);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("PId:").append(this.eMF);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("PName:").append(this.euw);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Seq:").append(this.eLd);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("SubSeq:").append(this.eMG);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("SubSeqSum:").append(this.eMH);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("DataContent:").append(this.eMI);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(122224);
        return stringBuffer2;
    }
}
