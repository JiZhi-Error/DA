package com.tencent.mm.plugin.bbom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.c;
import com.tencent.mm.av.n;
import com.tencent.mm.av.s;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.modelmulti.i;
import com.tencent.mm.modelmulti.o;
import com.tencent.mm.plugin.byp.b.b;
import com.tencent.mm.plugin.byp.b.d;
import com.tencent.mm.plugin.emoji.a;
import com.tencent.mm.plugin.gamelife.a.e;
import com.tencent.mm.plugin.gamelife.a.f;
import com.tencent.mm.plugin.i.a.aa;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.as;

public final class h implements o.c {
    @Override // com.tencent.mm.modelmulti.o.c
    public final o.a a(o.e eVar) {
        AppMethodBeat.i(231633);
        if (eVar.jec == o.d.TEXT) {
            o.a aVar = new o.a();
            boolean avl = ((aa) g.af(aa.class)).avl(eVar.toUser);
            boolean bju = as.bju(eVar.toUser);
            Log.i("MicroMsg.CreateSendMsgCgiCallback", "[createTextCgi] constructorId=%s toUser=%s isFinderMessage=%s isGameLifeMessage=%s", Integer.valueOf(eVar.jdR), eVar.toUser, Boolean.valueOf(avl), Boolean.valueOf(bju));
            if (avl) {
                String str = eVar.toUser;
                String avi = ((aa) g.af(aa.class)).avi(str);
                eVar.dRL = as.bjt(avi) ? z.aTY() : z.aUg();
                d dVar = new d(1, str, eVar.dRL, avi, eVar.content, eVar.msgId);
                aVar.jdI = dVar.dCM.field_msgId;
                aVar.dGJ = dVar;
            } else if (bju) {
                String str2 = eVar.toUser;
                e aAW = ((f) g.af(f.class)).aAW(str2);
                eVar.dRL = aAW.getSelfUsername();
                d dVar2 = new d(3, str2, eVar.dRL, aAW.ajO(), eVar.content, eVar.msgId);
                aVar.jdI = dVar2.dCM.field_msgId;
                aVar.dGJ = dVar2;
            } else if (eVar.jdR == 5) {
                i iVar = new i(eVar.toUser, eVar.content, eVar.type, eVar.cSx, eVar.jdQ);
                aVar.jdI = iVar.msgId;
                aVar.dGJ = iVar;
            } else if (eVar.jdR == 4) {
                i iVar2 = new i(eVar.toUser, eVar.content, eVar.type, eVar.cSx);
                aVar.jdI = iVar2.msgId;
                aVar.dGJ = iVar2;
            } else if (eVar.jdR == 2) {
                i iVar3 = new i(eVar.msgId);
                aVar.jdI = iVar3.msgId;
                aVar.dGJ = iVar3;
            } else {
                i iVar4 = new i();
                aVar.jdI = iVar4.msgId;
                aVar.dGJ = iVar4;
            }
            AppMethodBeat.o(231633);
            return aVar;
        } else if (eVar.jec == o.d.jdL) {
            o.a aVar2 = new o.a();
            Log.i("MicroMsg.CreateSendMsgCgiCallback", "[createImageCgi] constructorId=%s toUser=%s", Integer.valueOf(eVar.jdR), eVar.toUser);
            n nVar = null;
            if (eVar.jdR == 2) {
                nVar = new n(eVar.jdZ, eVar.iXp);
                if (eVar.hmr) {
                    nVar.bcE();
                }
            } else if (eVar.jdR == 3) {
                nVar = new n(eVar.jdZ, eVar.iXp, eVar.jdS);
                if (eVar.hmr) {
                    nVar.bcE();
                }
            } else if (eVar.jdR == 6) {
                nVar = new n(eVar.hmk, eVar.dRL, eVar.toUser, eVar.iZt, eVar.iXp, eVar.jdS);
                if (eVar.hmr) {
                    nVar.bcE();
                }
            } else if (eVar.jdR == 9) {
                nVar = new n(eVar.hmk, eVar.dRL, eVar.toUser, eVar.iZt, eVar.iXp, eVar.jdS, eVar.dQd, eVar.iXy, eVar.thumbPath);
                if (eVar.hmr) {
                    nVar.bcE();
                }
            } else if (eVar.jdR == 10) {
                nVar = new n(eVar.hmk, eVar.dRL, eVar.toUser, eVar.iZt, eVar.iXp, eVar.jdS, eVar.dQd, eVar.jdT, eVar.jdU);
                if (eVar.hmr) {
                    nVar.bcE();
                }
            } else if (eVar.jdR == 11) {
                nVar = new n(eVar.hmk, eVar.dRL, eVar.toUser, eVar.iZt, eVar.iXp, eVar.jdS, eVar.dQd, eVar.iXy, eVar.thumbPath, eVar.jdV, eVar.jdU);
                if (eVar.hmr) {
                    nVar.bcE();
                }
            } else if (eVar.jdR == 13) {
                nVar = new n(eVar.hmk, eVar.dRL, eVar.toUser, eVar.iZt, eVar.iXp, eVar.jdS, eVar.dQd, eVar.iXy, eVar.thumbPath, eVar.jdV, eVar.jdU, eVar.jdW, eVar.jdY);
                if (eVar.hmr) {
                    nVar.bcE();
                }
            } else if (eVar.jdR == 14) {
                n nVar2 = new n((long) eVar.jdZ, eVar.hmk, eVar.dRL, eVar.toUser, eVar.iZt, eVar.iXp, eVar.jdS, eVar.dQd, eVar.iXy, eVar.thumbPath, eVar.jdV, eVar.jdU, eVar.jea);
                if (eVar.hmr) {
                    nVar2.bcE();
                    nVar = nVar2;
                } else {
                    nVar = nVar2;
                }
            } else if (eVar.jdR == 19) {
                nVar = new n(eVar.hmk, eVar.dRL, eVar.toUser, eVar.iZt, eVar.iXp, eVar.jdS, eVar.dQd, eVar.iXy, eVar.thumbPath, eVar.jdV, eVar.jdU, eVar.jea, eVar.jeb, eVar.dTj, eVar.latitude, eVar.jdX, eVar.jdW, eVar.jdY);
                if (eVar.hmr) {
                    nVar.bcE();
                }
            }
            if (!(nVar == null || nVar.bcD() == null)) {
                aVar2.jdI = nVar.bcD().field_msgId;
            }
            aVar2.dGJ = nVar;
            AppMethodBeat.o(231633);
            return aVar2;
        } else if (eVar.jec == o.d.jdM) {
            o.a aVar3 = new o.a();
            if (eVar instanceof s) {
                s sVar = (s) eVar;
                Log.i("MicroMsg.CreateSendMsgCgiCallback", "[createVideoCgi] constructorId=%s fileName=%s", Integer.valueOf(eVar.jdR), sVar.fileName);
                if (eVar.jdR == 1) {
                    aVar3.dGJ = new com.tencent.mm.modelvideo.g(sVar.fileName);
                } else if (eVar.jdR == 4) {
                    if (ar.bjj(sVar.fileName)) {
                        String str3 = sVar.jaC.field_toUser;
                        String avi2 = ((aa) g.af(aa.class)).avi(str3);
                        eVar.toUser = avi2;
                        eVar.dRL = as.bjt(avi2) ? z.aTY() : z.aUg();
                        aVar3.dGJ = new com.tencent.mm.plugin.byp.b.e(1, str3, eVar.dRL, eVar.toUser, new com.tencent.mm.modelvideo.h(sVar.fileName, sVar.jaB, sVar.jaC, sVar.jaD));
                    } else if (ar.bjk(sVar.fileName)) {
                        String str4 = sVar.jaC.field_toUser;
                        e aAW2 = ((f) g.af(f.class)).aAW(str4);
                        eVar.toUser = aAW2.ajO();
                        eVar.dRL = aAW2.getSelfUsername();
                        Log.i("MicroMsg.CreateSendMsgCgiCallback", "[createVideoCgi] gameLife fromUserName:%s,toUserName:%s", eVar.dRL, eVar.toUser);
                        aVar3.dGJ = new com.tencent.mm.plugin.byp.b.e(3, str4, eVar.dRL, eVar.toUser, new com.tencent.mm.modelvideo.h(sVar.fileName, sVar.jaB, sVar.jaC, sVar.jaD));
                    } else {
                        aVar3.dGJ = new com.tencent.mm.modelvideo.h(sVar.fileName, sVar.jaB, sVar.jaC, sVar.jaD);
                    }
                }
            }
            AppMethodBeat.o(231633);
            return aVar3;
        } else if (eVar.jec == o.d.CDN_IMAGE) {
            Log.i("MicroMsg.CreateSendMsgCgiCallback", "[createCdnImageCgi] constructorId=%s toUser=%s", Integer.valueOf(eVar.jdR), eVar.toUser);
            o.a aVar4 = new o.a();
            if (eVar instanceof c) {
                c cVar = (c) eVar;
                if (as.avl(eVar.toUser)) {
                    String str5 = eVar.toUser;
                    String avi3 = ((aa) g.af(aa.class)).avi(str5);
                    eVar.dRL = as.bjt(avi3) ? z.aTY() : z.aUg();
                    aVar4.dGJ = new com.tencent.mm.plugin.byp.b.c(1, str5, cVar.dRL, avi3, cVar);
                } else if (as.bju(eVar.toUser)) {
                    String str6 = eVar.toUser;
                    e aAW3 = ((f) g.af(f.class)).aAW(str6);
                    String ajO = aAW3.ajO();
                    eVar.dRL = aAW3.getSelfUsername();
                    aVar4.dGJ = new com.tencent.mm.plugin.byp.b.c(3, str6, cVar.dRL, ajO, cVar);
                } else {
                    aVar4.dGJ = new com.tencent.mm.av.o(cVar.hmk, cVar.iWW, cVar.iWX, cVar.hmq, cVar.iWY);
                }
            }
            AppMethodBeat.o(231633);
            return aVar4;
        } else if (eVar.jec == o.d.EMOJI) {
            o.a aVar5 = new o.a();
            if (eVar instanceof a) {
                a aVar6 = (a) eVar;
                if (as.bju(eVar.toUser)) {
                    String str7 = eVar.toUser;
                    e aAW4 = ((f) g.af(f.class)).aAW(str7);
                    aVar6.toUser = aAW4.ajO();
                    aVar6.dRL = aAW4.getSelfUsername();
                    aVar5.dGJ = new b(str7, aVar6.dRL, aVar6.toUser, aVar6.gWm, aVar6.msgId);
                }
            }
            AppMethodBeat.o(231633);
            return aVar5;
        } else {
            AppMethodBeat.o(231633);
            return null;
        }
    }
}
