package com.tencent.mm.ao;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bj.d;
import com.tencent.mm.model.as;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bn;
import com.tencent.mm.storage.ca;
import java.util.LinkedList;

public final class f extends as {
    @Override // com.tencent.mm.model.as
    public final boolean rT(int i2) {
        return i2 != 0 && i2 < 604307701;
    }

    @Override // com.tencent.mm.model.as
    public final void transfer(int i2) {
        AppMethodBeat.i(20481);
        if (i2 != 0 && i2 < 604307701) {
            h.INSTANCE.dN(336, 11);
            bg.aVF();
            ca[] eH = c.aSQ().eH("fmessage", 20);
            if (eH == null) {
                Log.e("MicroMsg.FMessageDataTransfer", "transfer fail, msglist is empty");
                AppMethodBeat.o(20481);
                return;
            }
            d.bgN();
            Log.d("MicroMsg.FMessageDataTransfer", "transfer, msgList count = " + eH.length);
            for (ca caVar : eH) {
                if (caVar == null || caVar.field_msgId == 0) {
                    Log.e("MicroMsg.FMessageDataTransfer", "transfer fail, msg is null, skip this msg");
                } else {
                    Log.d("MicroMsg.FMessageDataTransfer", "transfer msg type = " + caVar.getType());
                    String str = caVar.field_content;
                    if (str == null || str.length() == 0) {
                        Log.e("MicroMsg.FMessageDataTransfer", "transfer fail, content is null, skip this msg, id = " + caVar.field_msgId);
                    } else {
                        switch (caVar.getType()) {
                            case 37:
                                Log.d("MicroMsg.FMessageDataTransfer", "processVerifyMsg, msg content = " + caVar.field_content);
                                ca.d bkD = ca.d.bkD(caVar.field_content);
                                if (Util.isNullOrNil(bkD.dkU) || (bkD.scene != 18 && !bp.sb(bkD.scene))) {
                                    bn bnVar = new bn();
                                    bnVar.field_createTime = caVar.field_createTime;
                                    bnVar.field_isSend = 0;
                                    bnVar.field_msgContent = caVar.field_content;
                                    bnVar.field_svrId = caVar.field_msgSvrId;
                                    bnVar.field_talker = bkD.dkU;
                                    switch (bkD.dKy) {
                                        case 2:
                                            bnVar.field_type = 1;
                                            break;
                                        case 3:
                                        case 4:
                                        default:
                                            bnVar.field_type = 1;
                                            break;
                                        case 5:
                                            bnVar.field_type = 2;
                                            break;
                                        case 6:
                                            bnVar.field_type = 3;
                                            break;
                                    }
                                    d.bgM().b(bnVar);
                                    break;
                                } else {
                                    Log.i("MicroMsg.FMessageDataTransfer", "processVerifyMsg, skip lbs & shake, scene = " + bkD.scene);
                                    continue;
                                }
                            case 38:
                            case 39:
                            default:
                                Log.i("MicroMsg.FMessageDataTransfer", "no need to transfer, msgtype = " + caVar.getType());
                                continue;
                            case 40:
                                Log.d("MicroMsg.FMessageDataTransfer", "processFMessage, msg content = " + caVar.field_content);
                                ca.a bkA = ca.a.bkA(caVar.field_content);
                                bn bnVar2 = new bn();
                                bnVar2.field_createTime = caVar.field_createTime;
                                bnVar2.field_isSend = 0;
                                bnVar2.field_msgContent = caVar.field_content;
                                bnVar2.field_svrId = caVar.field_msgSvrId;
                                bnVar2.field_talker = bkA.dkU;
                                bnVar2.field_type = 0;
                                d.bgM().b(bnVar2);
                                continue;
                        }
                    }
                }
            }
            bg.aVF();
            c.azQ().set(143618, (Object) 0);
            d.bgN().gCQ();
            Log.d("MicroMsg.FMessageDataTransfer", "transfer, try to delete fmessage contact & conversation");
            bg.aVF();
            c.aSN().aNa("fmessage");
            LinkedList<String> linkedList = new LinkedList<>();
            linkedList.add("fmessage");
            bg.aVF();
            c.aST().bI(linkedList);
        }
        AppMethodBeat.o(20481);
    }

    @Override // com.tencent.mm.model.as
    public final String getTag() {
        return "MicroMsg.FMessageDataTransfer";
    }
}
