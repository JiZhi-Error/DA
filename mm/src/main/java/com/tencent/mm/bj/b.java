package com.tencent.mm.bj;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.c;
import com.tencent.mm.aj.i;
import com.tencent.mm.aj.p;
import com.tencent.mm.ak.h;
import com.tencent.mm.g.a.gp;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.e;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.de;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bl;
import com.tencent.mm.storage.bn;
import com.tencent.mm.storage.ca;

public final class b extends e {
    @Override // com.tencent.mm.model.e
    public final ca a(h.a aVar, String str, String str2, String str3) {
        AppMethodBeat.i(231572);
        de deVar = aVar.heO;
        String a2 = z.a(deVar.KHn);
        if (a2 == null || a2.length() <= 0) {
            Log.e("MicroMsg.FMessageExtension", "possible friend msg : content is null");
            AppMethodBeat.o(231572);
        } else {
            ca.a bkA = ca.a.bkA(a2);
            if (!(bkA.OqK == null && bkA.OqL == null) && (bkA.scene == 10 || bkA.scene == 11)) {
                gp gpVar = new gp();
                gpVar.dKz.dKB = bkA.OqK;
                gpVar.dKz.dKC = bkA.OqL;
                EventCenter.instance.publish(gpVar);
                if (gpVar.dKA.dKD) {
                    Log.v("MicroMsg.FMessageExtension", "possible mobile friend is not in local address book");
                    AppMethodBeat.o(231572);
                }
            }
            if (bkA.Bge > 0) {
                c.e(bkA.Bge, bkA.OqJ);
            }
            if (Util.nullAsNil(bkA.dkU).length() > 0) {
                i iVar = new i();
                iVar.username = bkA.dkU;
                iVar.fuz = 3;
                iVar.fv(true);
                iVar.cSx = -1;
                iVar.iKX = bkA.OqM;
                iVar.iKW = bkA.OqN;
                iVar.cSx = -1;
                Log.d("MicroMsg.FMessageExtension", "dkhurl user:[%s] big:[%s] sm:[%s]", bkA.dkU, iVar.aYt(), iVar.aYu());
                p.aYB().b(iVar);
            }
            bn bnVar = new bn();
            bnVar.field_createTime = c.C(str, (long) deVar.CreateTime);
            bnVar.field_isSend = 0;
            bnVar.field_msgContent = z.a(deVar.KHn);
            bnVar.field_svrId = deVar.Brn;
            bnVar.field_talker = bkA.dkU;
            bnVar.field_type = 0;
            bl bkt = d.bgN().bkt(bnVar.field_talker);
            if (bkt != null) {
                Log.d("MicroMsg.FMessageExtension", "getByEncryptTalker success. encryptTalker = " + bnVar.field_talker + " , real talker = " + bkt.field_talker);
                bnVar.field_encryptTalker = bnVar.field_talker;
                bnVar.field_talker = bkt.field_talker;
            }
            bg.aVF();
            as Kn = com.tencent.mm.model.c.aSN().Kn(bnVar.field_talker);
            if (Kn == null || !com.tencent.mm.contact.c.oR(Kn.field_type) || Kn.gMZ <= 0) {
                d.bgM().b(bnVar);
                AppMethodBeat.o(231572);
            } else {
                Log.d("MicroMsg.FMessageExtension", "The biz contact whose talker is " + bnVar.field_talker + " has already been in user's contact list");
                AppMethodBeat.o(231572);
            }
        }
        return null;
    }
}
