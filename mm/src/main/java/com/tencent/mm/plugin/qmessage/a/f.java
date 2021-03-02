package com.tencent.mm.plugin.qmessage.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h;
import com.tencent.mm.av.g;
import com.tencent.mm.av.q;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.c;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.protobuf.de;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.ca;
import java.util.Map;
import junit.framework.Assert;

public final class f implements h {
    @Override // com.tencent.mm.ak.h
    public final h.b b(h.a aVar) {
        ca caVar;
        long j2;
        int i2;
        ca caVar2;
        h.b bVar;
        boolean z;
        as asVar;
        String str;
        String str2;
        AppMethodBeat.i(27725);
        de deVar = aVar.heO;
        if (deVar == null) {
            Log.e("MicroMsg.QMsgExtension", "onPreAddMessage cmdAM is null");
            AppMethodBeat.o(27725);
            return null;
        } else if (deVar.xKb == 36 || deVar.xKb == 39) {
            String a2 = z.a(deVar.KHn);
            String a3 = z.a(deVar.KHl);
            String a4 = z.a(deVar.KHm);
            Log.d("MicroMsg.QMsgExtension", "parseQMsg content:".concat(String.valueOf(a2)));
            bg.aVF();
            String str3 = (String) c.azQ().get(2, (Object) null);
            if (!str3.equals(a3)) {
                a4 = a3;
            }
            bg.aVF();
            ca aJ = c.aSQ().aJ(a4, deVar.Brn);
            Log.d("MicroMsg.QMsgExtension", "dkmsgid parseQMsg svrid:%d localid:%d", Long.valueOf(deVar.Brn), Long.valueOf(aJ.field_msgId));
            if (aJ.field_msgId != 0 && aJ.field_createTime + 604800000 < bp.C(a3, (long) deVar.CreateTime)) {
                Log.w("MicroMsg.QMsgExtension", "dkmsgid prepareMsgInfo msg Too Old Remove it. svrid:%d localid:%d", Long.valueOf(deVar.Brn), Long.valueOf(aJ.field_msgId));
                bp.Ad(aJ.field_msgId);
                aJ.setMsgId(0);
            }
            if (aJ.field_msgId == 0) {
                ca caVar3 = new ca();
                caVar3.yF(deVar.Brn);
                caVar3.setCreateTime(bp.C(a3, (long) deVar.CreateTime));
                caVar = caVar3;
            } else {
                caVar = aJ;
            }
            caVar.setType(deVar.xKb);
            caVar.Cy(a4);
            d aKB = g.eFZ().aKB(a4);
            if (aKB == null || Util.nullAsNil(aKB.getUsername()).length() <= 0) {
                d dVar = new d();
                dVar.username = a4;
                dVar.Bqg = 1;
                dVar.cSx = 9;
                if (!g.eFZ().a(dVar)) {
                    Log.e("MicroMsg.QMsgExtension", "parseQMsg : insert QContact failed : username = " + dVar.getUsername());
                }
            }
            if (deVar.KHo == 2 && caVar.field_msgId == 0) {
                byte[] a5 = z.a(deVar.KHp);
                PString pString = new PString();
                PInt pInt = new PInt();
                PInt pInt2 = new PInt();
                j2 = q.bcR().a(a4, a5, deVar.Brn, false, "", pString, pInt, pInt2);
                if (j2 > 0) {
                    caVar.Cz(pString.value);
                    caVar.nG(pInt.value);
                    caVar.nH(pInt2.value);
                }
            } else {
                j2 = -1;
            }
            if (deVar.xKb == 36) {
                Assert.assertTrue(true);
                if (Util.nullAsNil(a2).length() > 0) {
                    z = true;
                } else {
                    z = false;
                }
                Assert.assertTrue(z);
                Assert.assertTrue(Util.nullAsNil(caVar.field_talker).length() > 0);
                boolean z2 = false;
                bg.aVF();
                as Kn = c.aSN().Kn(caVar.field_talker);
                if (Kn == null || Util.nullAsNil(Kn.field_username).length() <= 0) {
                    z2 = true;
                    asVar = new as(caVar.field_talker);
                } else {
                    asVar = Kn;
                }
                a aVar2 = new a((byte) 0);
                Map<String, String> parseXml = XmlParser.parseXml(a2, "msg", null);
                if (parseXml != null) {
                    aVar2.gCv = parseXml.get(".msg.from.displayname");
                    aVar2.content = parseXml.get(".msg.content.t");
                }
                if (aVar2.gCv == null) {
                    str = "";
                } else {
                    str = aVar2.gCv;
                }
                asVar.BD(str);
                if (aVar2.content == null) {
                    str2 = "";
                } else {
                    str2 = aVar2.content;
                }
                caVar.setContent(str2);
                if (z2) {
                    bg.aVF();
                    c.aSN().ap(asVar);
                } else {
                    bg.aVF();
                    c.aSN().c(asVar.field_username, asVar);
                }
            }
            bg.aVF();
            if (c.aSW().has(a3) || str3.equals(a3)) {
                caVar.nv(1);
                i2 = deVar.oTW;
                caVar2 = caVar;
            } else {
                caVar.nv(0);
                if (deVar.oTW > 3) {
                    i2 = deVar.oTW;
                    caVar2 = caVar;
                } else {
                    i2 = 3;
                    caVar2 = caVar;
                }
            }
            caVar2.setStatus(i2);
            caVar.BB(deVar.KHq);
            bp.a(caVar, aVar);
            if (caVar.field_msgId == 0) {
                caVar.setMsgId(bp.x(caVar));
                if (deVar.KHo == 2) {
                    g c2 = q.bcR().c(Long.valueOf(j2));
                    c2.Aw((long) ((int) caVar.field_msgId));
                    q.bcR().a(Long.valueOf(j2), c2);
                }
                bVar = new h.b(caVar, true);
            } else {
                bg.aVF();
                c.aSQ().b(deVar.Brn, caVar);
                bVar = new h.b(caVar, false);
            }
            AppMethodBeat.o(27725);
            return bVar;
        } else {
            Log.e("MicroMsg.QMsgExtension", "onPreAddMessage cmdAM.type:%d", Integer.valueOf(deVar.xKb));
            AppMethodBeat.o(27725);
            return null;
        }
    }

    public static final class a {
        String content;
        String gCv;

        /* synthetic */ a(byte b2) {
            this();
        }

        private a() {
            this.gCv = "";
            this.content = "";
        }
    }

    @Override // com.tencent.mm.ak.h
    public final void b(h.c cVar) {
        AppMethodBeat.i(27726);
        q.bcR().V(cVar.dTX);
        AppMethodBeat.o(27726);
    }
}
