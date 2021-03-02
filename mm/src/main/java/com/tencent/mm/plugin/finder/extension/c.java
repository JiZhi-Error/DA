package com.tencent.mm.plugin.finder.extension;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ie;
import com.tencent.mm.g.b.a.ee;
import com.tencent.mm.plugin.finder.api.f;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.protobuf.apf;
import com.tencent.mm.protocal.protobuf.bdh;
import com.tencent.mm.protocal.protobuf.bdj;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class c implements f {
    private ee tJf = new ee();

    public c() {
        AppMethodBeat.i(241786);
        AppMethodBeat.o(241786);
    }

    @Override // com.tencent.mm.plugin.finder.api.f
    public final void a(apf apf, int i2, int i3) {
        AppMethodBeat.i(241787);
        if (apf == null) {
            AppMethodBeat.o(241787);
            return;
        }
        long currentTicks = Util.currentTicks();
        PString pString = new PString();
        PString pString2 = new PString();
        pString2.value = "";
        pString.value = "";
        switch (apf.cmdId) {
            case 113:
                bdh bdh = new bdh();
                try {
                    bdh.parseFrom(apf.LBo.toByteArray());
                    if (bdh.LKY != null) {
                        StringBuffer stringBuffer = new StringBuffer();
                        StringBuffer stringBuffer2 = new StringBuffer();
                        for (int i4 = 0; i4 < bdh.LKY.size(); i4++) {
                            bdj bdj = bdh.LKY.get(i4);
                            if (!(bdj == null || bdj.LNi == null)) {
                                if (i4 > 0) {
                                    stringBuffer.append(";");
                                    stringBuffer2.append(";");
                                }
                                stringBuffer.append(bdj.LNi.LKM);
                                stringBuffer2.append(bdj.LNi.type);
                            }
                        }
                        pString.value = stringBuffer.toString();
                        pString2.value = stringBuffer2.toString();
                        String str = pString.value;
                        String str2 = pString2.value;
                        int i5 = apf.cmdId;
                        if (!Util.isNullOrNil(str)) {
                            ee eeVar = this.tJf;
                            eeVar.ejo = eeVar.x("TipsId", str, true);
                            eeVar.ejr = eeVar.x("CtrlType", str2, true);
                            eeVar.eCB = i3;
                            eeVar.eCC = i5;
                            eeVar.bfK();
                            Log.i("MicroMsg.FinderSyncReportHandler", "report RedDot [%s] scene[%d] cmdId[%d]", str, Integer.valueOf(i3), Integer.valueOf(i5));
                            break;
                        }
                    }
                } catch (Exception e2) {
                    Log.printErrStackTrace("MicroMsg.FinderSyncReportHandler", e2, "report tab tips", new Object[0]);
                    break;
                }
                break;
        }
        ie ieVar = new ie();
        ieVar.dMM.dMO = apf.cmdId;
        ieVar.dMM.dMN = pString.value;
        ieVar.dMM.dMP = pString2.value;
        ieVar.dMM.scene = i3;
        EventCenter.instance.publish(ieVar);
        Log.i("MicroMsg.FinderSyncReportHandler", "FinderSyncReport handle cmd[%d] selector[%d] scene[%d] cost[%d]", Integer.valueOf(apf.cmdId), Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(Util.ticksToNow(currentTicks)));
        AppMethodBeat.o(241787);
    }
}
