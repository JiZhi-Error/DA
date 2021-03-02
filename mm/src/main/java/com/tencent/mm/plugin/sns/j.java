package com.tencent.mm.plugin.sns;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.qw;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.protocal.protobuf.cnb;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;

public final class j extends IListener<qw> {
    public j() {
        AppMethodBeat.i(160637);
        this.__eventId = qw.class.getName().hashCode();
        AppMethodBeat.o(160637);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
    @Override // com.tencent.mm.sdk.event.IListener
    public final /* synthetic */ boolean callback(qw qwVar) {
        boolean z;
        AppMethodBeat.i(94904);
        qw qwVar2 = qwVar;
        if (!(qwVar2 instanceof qw)) {
            Log.f("MicroMsg.RecentlySnsMediaObjListener", "mismatched event");
            AppMethodBeat.o(94904);
            return false;
        }
        LinkedList linkedList = new LinkedList();
        qwVar2.dXp.dXq = null;
        qwVar2.dXp.dXr = null;
        qwVar2.dXp.dXs = null;
        qwVar2.dXp.dXt = null;
        Log.i("MicroMsg.RecentlySnsMediaObjListener", "recently username " + qwVar2.dXo.username);
        if (!Util.isNullOrNil(qwVar2.dXo.username)) {
            g.aAi();
            if (qwVar2.dXo.username.equals((String) g.aAh().azQ().get(2, (Object) null))) {
                z = true;
            } else {
                z = false;
            }
            n faO = aj.faO();
            String str = ("select *,rowid from SnsInfo " + n.cn(qwVar2.dXo.username, z)) + " AND type in ( 1 , 15)" + n.Emu + " limit 4";
            Log.d("MicroMsg.SnsInfoStorage", "getUserNewerInfo ".concat(String.valueOf(str)));
            Cursor rawQuery = faO.iFy.rawQuery(str, null);
            if (rawQuery != null) {
                if (!rawQuery.moveToFirst()) {
                    rawQuery.close();
                } else {
                    int i2 = 0;
                    do {
                        SnsInfo snsInfo = new SnsInfo();
                        snsInfo.convertFrom(rawQuery);
                        if (snsInfo.getTypeFlag() != 21) {
                            Iterator<cnb> it = snsInfo.getTimeLine().ContentObj.LoV.iterator();
                            while (it.hasNext()) {
                                cnb next = it.next();
                                if (next.oUv == 2 || next.oUv == 6) {
                                    i2++;
                                    linkedList.add(next);
                                    if (i2 >= 4) {
                                        break;
                                    }
                                }
                                i2 = i2;
                            }
                        }
                    } while (rawQuery.moveToNext());
                    rawQuery.close();
                    if (linkedList.size() > 0) {
                        qwVar2.dXp.dXq = (cnb) linkedList.get(0);
                    }
                    if (linkedList.size() > 1) {
                        qwVar2.dXp.dXr = (cnb) linkedList.get(1);
                    }
                    if (linkedList.size() > 2) {
                        qwVar2.dXp.dXs = (cnb) linkedList.get(2);
                    }
                    if (linkedList.size() > 3) {
                        qwVar2.dXp.dXt = (cnb) linkedList.get(3);
                    }
                }
            }
        }
        AppMethodBeat.o(94904);
        return true;
    }
}
