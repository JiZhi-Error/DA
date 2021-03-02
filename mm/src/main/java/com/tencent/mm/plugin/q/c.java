package com.tencent.mm.plugin.q;

import android.database.Cursor;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.backup.b.g;
import com.tencent.mm.plugin.backup.h.d;
import com.tencent.mm.plugin.backup.i.k;
import com.tencent.mm.plugin.backup.i.l;
import com.tencent.mm.plugin.q.a;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.protocal.protobuf.is;
import com.tencent.mm.protocal.protobuf.it;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.ca;
import com.tencent.mm.vfs.s;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public final class c {
    boolean zGa = false;
    a.AbstractC1608a zGb;

    public static class a {
        public String oJo;

        public a(String str) {
            this.oJo = str;
        }
    }

    public final LinkedList<a> elu() {
        AppMethodBeat.i(26518);
        long nowMilliSecond = Util.nowMilliSecond();
        LinkedList<a> linkedList = new LinkedList<>();
        Cursor c2 = d.cgP().cgQ().aST().c(ab.iCF, g.cfd(), "*");
        if (c2.getCount() == 0) {
            Log.e("MicroMsg.MsgSynchronizePack", "calculateConversationList empty conversation!");
            c2.close();
            AppMethodBeat.o(26518);
            return linkedList;
        }
        Log.i("MicroMsg.MsgSynchronizePack", "calculateConversationList count[%d]", Integer.valueOf(c2.getCount()));
        int i2 = 0;
        while (true) {
            if (!c2.moveToNext()) {
                break;
            } else if (this.zGa) {
                c2.close();
                Log.e("MicroMsg.MsgSynchronizePack", "calculateConversationList is cancel!");
                AppMethodBeat.o(26518);
                return linkedList;
            } else if (i2 >= b.zFV) {
                Log.i("MicroMsg.MsgSynchronizePack", "calculateConversationList convCount has reach the max, finish. convCount:%d", Integer.valueOf(i2));
                break;
            } else {
                az azVar = new az();
                azVar.convertFrom(c2);
                if (!Util.isNullOrNil(azVar.field_username)) {
                    int aEM = d.cgP().cgQ().aSQ().aEM(azVar.field_username);
                    Log.i("MicroMsg.MsgSynchronizePack", "calculateConversationList user:%s convMsgCount:%d, convCount:%d", azVar.field_username, Integer.valueOf(aEM), Integer.valueOf(i2));
                    if (aEM > 0) {
                        linkedList.add(new a(azVar.field_username));
                        i2++;
                    }
                }
            }
        }
        c2.close();
        Log.i("MicroMsg.MsgSynchronizePack", "calculateConversationList loading time:" + Util.milliSecondsToNow(nowMilliSecond));
        AppMethodBeat.o(26518);
        return linkedList;
    }

    public static LinkedList<a> aFu(String str) {
        AppMethodBeat.i(26519);
        LinkedList<a> linkedList = new LinkedList<>();
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(26519);
        } else {
            int aEM = d.cgP().cgQ().aSQ().aEM(str);
            Log.i("MicroMsg.MsgSynchronizePack", "addConversationList user:%s convMsgCount:%d", str, Integer.valueOf(aEM));
            if (aEM <= 0) {
                AppMethodBeat.o(26519);
            } else {
                linkedList.add(new a(str));
                AppMethodBeat.o(26519);
            }
        }
        return linkedList;
    }

    public final void a(final d dVar, final LinkedList<a> linkedList, final long j2, final long j3, final int i2) {
        AppMethodBeat.i(26520);
        h.RTc.ba(new com.tencent.f.i.h() {
            /* class com.tencent.mm.plugin.q.c.AnonymousClass1 */

            @Override // com.tencent.f.i.h, com.tencent.f.i.g
            public final String getKey() {
                return "msgSynchronizePackThread";
            }

            public final void run() {
                int i2;
                AppMethodBeat.i(26517);
                long nowMilliSecond = Util.nowMilliSecond();
                if (linkedList == null || linkedList.size() <= 0) {
                    Object[] objArr = new Object[1];
                    objArr[0] = Integer.valueOf(linkedList == null ? -1 : linkedList.size());
                    Log.e("MicroMsg.MsgSynchronizePack", "startSynchronizePack MsgSynchronizeSessionList is null or zero, msgSynchronizeSessionList size:%d.", objArr);
                    if (c.this.zGb != null) {
                        c.this.zGb.onCancel();
                    }
                    AppMethodBeat.o(26517);
                    return;
                }
                g.agw(g.elw());
                g.agw(g.elx());
                StringBuilder sb = new StringBuilder();
                bg.aVF();
                g.agw(sb.append(com.tencent.mm.model.c.getAccPath()).append("msgsynchronize/").toString());
                StringBuilder sb2 = new StringBuilder();
                bg.aVF();
                g.agw(sb2.append(com.tencent.mm.model.c.getAccPath()).append("msgsynchronize.zip").toString());
                LinkedList<k> linkedList = new LinkedList<>();
                String str = (String) d.cgP().cgQ().azQ().get(2, (Object) null);
                PInt pInt = new PInt();
                PInt pInt2 = new PInt();
                PLong pLong = new PLong();
                Iterator it = linkedList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    a aVar = (a) it.next();
                    if (!c.this.zGa) {
                        az bjY = d.cgP().cgQ().aST().bjY(aVar.oJo);
                        if (bjY != null) {
                            i2 = bjY.field_unReadCount;
                        } else {
                            i2 = 0;
                        }
                        if (!dVar.action.equals(b.zFP)) {
                            if (pInt2.value >= b.zFV) {
                                break;
                            }
                            k kVar = new k();
                            kVar.UserName = aVar.oJo;
                            kVar.oTD = (int) (d.cgP().cgQ().aSQ().aEQ(aVar.oJo) / 1000);
                            kVar.oTE = i2;
                            linkedList.add(kVar);
                            pInt2.value++;
                            if (pInt.value < b.zFT) {
                                c.this.a(dVar, aVar, j2, j3, str, i2, pInt, pLong, i2);
                            }
                        } else {
                            c.this.a(dVar, aVar, j2, j3, str, i2, pInt, pLong, i2);
                            if (pLong.value >= ((long) b.zFZ)) {
                                Log.e("MicroMsg.MsgSynchronizePack", "startSynchronizePack getMore has reach the max pack number, msgCount:%d", Long.valueOf(pLong.value));
                                break;
                            }
                        }
                    } else {
                        Log.e("MicroMsg.MsgSynchronizePack", "startSynchronizePack has been canceled!");
                        break;
                    }
                }
                if (c.this.zGa) {
                    Log.e("MicroMsg.MsgSynchronizePack", "MsgSynchronizePack canceled!");
                    AppMethodBeat.o(26517);
                    return;
                }
                if (!dVar.action.equals(b.zFP)) {
                    l lVar = new l();
                    lVar.oTF = linkedList;
                    lVar.oTG = com.tencent.mm.bj.d.bgN().gCR();
                    try {
                        g.e(g.elv(), "sessionlist", lVar.toByteArray());
                        Log.i("MicroMsg.MsgSynchronizePack", "BackupSessionInfoList pack finish.");
                    } catch (Exception e2) {
                        Log.e("MicroMsg.MsgSynchronizePack", "ERROR: BackupSessionInfoList to Buffer, list:%d :%s", Integer.valueOf(lVar.oTF.size()), e2.getMessage());
                    }
                }
                s.nz(g.elw(), g.elx());
                long boW = s.boW(g.elx());
                Log.i("MicroMsg.MsgSynchronizePack", "startSynchronizePack finish, sessionCount:%d, msgCount:%d, fileLen:%d KB, backupCostTime[%d]", Integer.valueOf(pInt.value), Long.valueOf(pLong.value), Long.valueOf(boW / 1024), Long.valueOf(Util.milliSecondsToNow(nowMilliSecond)));
                d dVar = dVar;
                long j2 = pLong.value;
                dVar.zGh = (long) pInt.value;
                dVar.zGi = j2;
                dVar.zGj = boW / 1024;
                dVar.gna = new String(str);
                if (c.this.zGb != null) {
                    c.this.zGb.a(dVar, g.elx(), linkedList.size());
                }
                AppMethodBeat.o(26517);
            }
        });
        AppMethodBeat.o(26520);
    }

    public final boolean a(d dVar, a aVar, long j2, long j3, String str, int i2, PInt pInt, PLong pLong, int i3) {
        is isVar;
        boolean z;
        AppMethodBeat.i(26521);
        boolean equals = dVar.action.equals(b.zFP);
        bg.aVF();
        if (as.akh(com.tencent.mm.model.c.aSN().Kn(aVar.oJo).field_verifyFlag)) {
            AppMethodBeat.o(26521);
            return true;
        }
        Log.i("MicroMsg.MsgSynchronizePack", "synchronizeSessionPack convName:%s, unReadCount:%d", aVar.oJo, Integer.valueOf(i2));
        LinkedList<is> linkedList = new LinkedList<>();
        ArrayList arrayList = new ArrayList(i3);
        int G = d.cgP().cgQ().aSQ().G(aVar.oJo, j2, j3);
        if (G <= 0) {
            Log.i("MicroMsg.MsgSynchronizePack", "synchronizeSessionPack session no message to sync");
            AppMethodBeat.o(26521);
            return false;
        }
        Cursor b2 = d.cgP().cgQ().aSQ().b(aVar.oJo, j2, j3, i3);
        if (equals) {
            if (G > i3) {
                dVar.zGl = 0;
            } else {
                dVar.zGl = 1;
            }
        }
        while (b2.moveToNext()) {
            if (this.zGa) {
                Log.e("MicroMsg.MsgSynchronizePack", "synchronizeSessionPack is cancel!");
                b2.close();
                AppMethodBeat.o(26521);
                return false;
            }
            ca caVar = new ca();
            caVar.convertFrom(b2);
            if (caVar.field_createTime >= j2 && caVar.field_createTime <= j3) {
                if (caVar.getType() == 922746929) {
                    z = false;
                } else {
                    z = true;
                }
                if (z) {
                    arrayList.add(caVar);
                }
            }
        }
        b2.close();
        if (arrayList.size() <= 0) {
            Log.i("MicroMsg.MsgSynchronizePack", "synchronizeSessionPack session no message to sync");
            AppMethodBeat.o(26521);
            return false;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ca caVar2 = (ca) it.next();
            if (this.zGa) {
                Log.e("MicroMsg.MsgSynchronizePack", "synchronizeSessionPack is cancel!");
                AppMethodBeat.o(26521);
                return false;
            }
            try {
                isVar = com.tencent.mm.plugin.backup.f.h.a(caVar2, false, str, new PLong(), new LinkedList(), null, i2 > 0, true, 0);
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.MsgSynchronizePack", e2, "packMsg", new Object[0]);
                isVar = null;
            }
            if (isVar != null) {
                linkedList.add(isVar);
                Log.d("MicroMsg.MsgSynchronizePack", "bakItem:%s", isVar.toString());
                pLong.value++;
                i2--;
            }
        }
        Log.d("MicroMsg.MsgSynchronizePack", "synchronizeSessionPack bakChatMsgList size:%d", Integer.valueOf(linkedList.size()));
        it itVar = new it();
        itVar.oTA = linkedList;
        itVar.oTz = linkedList.size();
        try {
            String str2 = "MSG_" + linkedList.size() + "_" + aVar.oJo + "_" + Util.nowMilliSecond();
            g.e(g.elv(), str2, itVar.toByteArray());
            Log.i("MicroMsg.MsgSynchronizePack", "synchronizeSessionPack add MsgSynchronize, tagTextClientId:%s", str2);
        } catch (Exception e3) {
            Log.e("MicroMsg.MsgSynchronizePack", "ERROR: synchronizeSessionPack BakChatMsgList to Buffer list:%d :%s", Integer.valueOf(itVar.oTz), e3.getMessage());
        }
        pInt.value++;
        AppMethodBeat.o(26521);
        return true;
    }
}
