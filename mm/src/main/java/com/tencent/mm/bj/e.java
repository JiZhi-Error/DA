package com.tencent.mm.bj;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.i;
import com.tencent.mm.aj.p;
import com.tencent.mm.ak.h;
import com.tencent.mm.g.a.ls;
import com.tencent.mm.g.a.qh;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ay;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.c;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.de;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bl;
import com.tencent.mm.storage.bn;
import com.tencent.mm.storage.bo;
import com.tencent.mm.storage.ca;

public final class e implements h {
    @Override // com.tencent.mm.ak.h
    public final h.b b(h.a aVar) {
        int i2 = 0;
        AppMethodBeat.i(20675);
        de deVar = aVar.heO;
        String a2 = z.a(deVar.KHl);
        if ("fmessage".equals(a2) || deVar.xKb == 37) {
            String a3 = z.a(deVar.KHn);
            final ca.d bkD = ca.d.bkD(a3);
            String aTY = com.tencent.mm.model.z.aTY();
            if (bkD.dkU == null || !bkD.dkU.equals(aTY)) {
                i iVar = new i();
                iVar.username = bkD.dkU;
                iVar.fuz = 3;
                iVar.fv(true);
                iVar.cSx = -1;
                iVar.iKX = bkD.OqM;
                iVar.iKW = bkD.OqN;
                Log.d("MicroMsg.VerifyMessageExtension", "dkhurl user:[%s] big:[%s] sm:[%s]", bkD.dkU, iVar.aYt(), iVar.aYu());
                p.aYB().b(iVar);
                if (!Util.isNullOrNil(bkD.dkU)) {
                    if (bkD.scene == 18) {
                        d.a(deVar, bkD);
                        bg.aVF();
                        c.azQ().set(73729, (Object) 1);
                        bg.aVF();
                        as Kn = c.aSN().Kn(bkD.OqZ);
                        if (Kn == null || ((int) Kn.gMZ) <= 0) {
                            ay.a.iDq.a(bkD.OqZ, null, new ay.b.a() {
                                /* class com.tencent.mm.bj.e.AnonymousClass1 */

                                @Override // com.tencent.mm.model.ay.b.a
                                public final void p(String str, boolean z) {
                                    AppMethodBeat.i(20674);
                                    bg.aVF();
                                    Log.d("MicroMsg.VerifyMessageExtension", String.valueOf(c.aSN().Kn(bkD.OqZ)));
                                    ls lsVar = new ls();
                                    lsVar.dRd.dRe = bkD.OqZ;
                                    lsVar.dRd.type = 1;
                                    EventCenter.instance.publish(lsVar);
                                    AppMethodBeat.o(20674);
                                }
                            });
                        } else {
                            String str = Kn.field_username;
                            if (str != null && !ab.IR(str)) {
                                Kn.setUsername(bkD.OqZ);
                                Kn.BK(null);
                                bg.aVF();
                                c.aSN().c(str, Kn);
                            }
                            ls lsVar = new ls();
                            lsVar.dRd.dRe = bkD.OqZ;
                            lsVar.dRd.type = 1;
                            EventCenter.instance.publish(lsVar);
                        }
                        AppMethodBeat.o(20675);
                    } else if (bp.sb(bkD.scene)) {
                        d.b(deVar, bkD);
                        bg.aVF();
                        c.azQ().set(73730, (Object) 1);
                        AppMethodBeat.o(20675);
                    } else if (bkD.scene == 48) {
                        qh qhVar = new qh();
                        qhVar.dWE.dWG = a3;
                        qhVar.dWE.talker = bkD.dkU;
                        EventCenter.instance.publish(qhVar);
                    }
                }
                bn bnVar = new bn();
                bnVar.field_createTime = c.C(a2, (long) deVar.CreateTime);
                if (deVar.oTW == 4) {
                    i2 = 2;
                }
                bnVar.field_isSend = i2 + 0;
                bnVar.field_msgContent = z.a(deVar.KHn);
                bnVar.field_svrId = deVar.Brn;
                bnVar.field_talker = bkD.dkU;
                bg.aVF();
                as Kn2 = c.aSN().Kn(bkD.chatroomName);
                if (!(Kn2 == null || ((int) Kn2.gMZ) == -1)) {
                    bnVar.field_chatroomName = bkD.chatroomName;
                }
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
                if (!Util.isNullOrNil(bkD.OqZ)) {
                    bnVar.field_encryptTalker = bkD.OqZ;
                    if (d.bgN().aEl(bkD.OqZ) != null) {
                        bo bgM = d.bgM();
                        String str2 = bnVar.field_encryptTalker;
                        bgM.db.execSQL("fmessage_msginfo", "update fmessage_msginfo set talker = '" + Util.escapeSqlValue(bnVar.field_talker) + "'  where talker = '" + Util.escapeSqlValue(str2) + "'");
                        d.bgN().x(0, bnVar.field_encryptTalker);
                    }
                    d.bgM().b(bnVar);
                } else {
                    Log.e("MicroMsg.VerifyMessageExtension", "it should not go in here");
                    bl bkt = d.bgN().bkt(bnVar.field_talker);
                    if (bkt != null) {
                        bnVar.field_encryptTalker = bkt.field_talker;
                        bnVar.field_talker = bkt.field_talker;
                    }
                    d.bgM().b(bnVar);
                }
                AppMethodBeat.o(20675);
            } else {
                Log.d("MicroMsg.VerifyMessageExtension", "onPreAddMessage, verify scene:%d, content:%s", Integer.valueOf(bkD.scene), a3);
                Log.e("MicroMsg.VerifyMessageExtension", "fromUserName is self, simply drop this msg");
                AppMethodBeat.o(20675);
            }
        } else {
            AppMethodBeat.o(20675);
        }
        return null;
    }

    @Override // com.tencent.mm.ak.h
    public final void b(h.c cVar) {
    }
}
