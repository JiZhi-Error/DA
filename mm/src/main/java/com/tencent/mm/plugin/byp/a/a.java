package com.tencent.mm.plugin.byp.a;

import com.tencent.mm.ak.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.aa;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.protobuf.cp;
import com.tencent.mm.protocal.protobuf.ss;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

public abstract class a implements b {
    /* access modifiers changed from: protected */
    public abstract int crR();

    /* access modifiers changed from: protected */
    public abstract int crS();

    /* access modifiers changed from: protected */
    public abstract aa crT();

    /* access modifiers changed from: protected */
    public boolean a(cp cpVar) {
        return true;
    }

    @Override // com.tencent.mm.plugin.byp.a.b
    public final void O(LinkedList<ss> linkedList) {
        Log.i("BaseBypSyncHandler", "[onReceive] size=%s", Integer.valueOf(linkedList.size()));
        l lVar = (l) g.af(l.class);
        try {
            lVar.eiy().aEs("BaseBypSyncHandler");
            Iterator<ss> it = linkedList.iterator();
            while (it.hasNext()) {
                ss next = it.next();
                if (next.pWk == 1) {
                    cp cpVar = new cp();
                    cpVar.parseFrom(next.pUz.zy);
                    if (Util.isNullOrNil(cpVar.KGL)) {
                        Log.e("BaseBypSyncHandler", "msg_session_id is null! FromUserName=%s ToUserName=%s", z.a(cpVar.KGK.KHl), z.a(cpVar.KGK.KHm));
                    } else if (cpVar.KGK.Brn == 0) {
                        Log.e("BaseBypSyncHandler", "NewMsgId is zero! FromUserName=%s ToUserName=%s", z.a(cpVar.KGK.KHl), z.a(cpVar.KGK.KHm));
                    } else if (!a(cpVar)) {
                        Log.e("BaseBypSyncHandler", "[onReceive] ignore this msg %s", cpVar.KGL);
                    } else {
                        String a2 = z.a(cpVar.KGN ? cpVar.KGK.KHl : cpVar.KGK.KHm);
                        String str = (String) g.aAh().azQ().get(2, "");
                        if (cpVar.KGN && !a2.equals(str)) {
                            lVar.aSW().eJ(a2, crR());
                        }
                        if (cpVar.KGN) {
                            cpVar.KGK.KHm = z.Su(cpVar.KGL);
                        } else {
                            cpVar.KGK.KHl = z.Su(cpVar.KGL);
                        }
                        h.a aVar = new h.a(cpVar.KGK, false, false, false);
                        aVar.iMa = new cp().parseFrom(next.pUz.zy);
                        aVar.what = crS();
                        ((k) g.af(k.class)).processAddMsg(aVar, crT());
                    }
                }
            }
        } catch (IOException e2) {
            Log.printDebugStack("BaseBypSyncHandler", "", e2);
        } finally {
            lVar.eiy().aEt("BaseBypSyncHandler");
        }
    }
}
