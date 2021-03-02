package com.tencent.mm.plugin.appbrand.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.MStorage;
import com.tencent.mm.sdk.storage.MStorageEventData;
import java.util.LinkedList;
import java.util.List;

/* access modifiers changed from: package-private */
public final class a implements MStorage.IOnStorageChange {
    a() {
    }

    @Override // com.tencent.mm.sdk.storage.MStorage.IOnStorageChange
    public final void onNotifyChange(String str, MStorageEventData mStorageEventData) {
        AppMethodBeat.i(45009);
        if (n.buJ() == null) {
            Log.w("MicroMsg.AppBrandSearchStorageChangeListener", "onNotifyChange by SysConfigStorage, but sLayoutStorage is null.");
            AppMethodBeat.o(45009);
            return;
        }
        switch (mStorageEventData.eventId) {
            case 2:
            case 3:
                LinkedList linkedList = new LinkedList();
                if (!MStorageEventData.EventType.BATCH.equals(str)) {
                    linkedList.addAll(n.buJ().Ww(mStorageEventData.obj.toString()));
                } else if (mStorageEventData.obj != null && (mStorageEventData.obj instanceof List)) {
                    for (String str2 : (List) mStorageEventData.obj) {
                        linkedList.addAll(n.buJ().Ww(str2));
                    }
                }
                if (!linkedList.isEmpty()) {
                    n.buJ().doNotify(MStorageEventData.EventType.BATCH, 3, linkedList);
                    AppMethodBeat.o(45009);
                    return;
                }
                break;
            case 5:
                LinkedList linkedList2 = new LinkedList();
                if (!MStorageEventData.EventType.BATCH.equals(str)) {
                    linkedList2.addAll(n.buJ().Ww(mStorageEventData.obj.toString()));
                } else if (mStorageEventData.obj != null && (mStorageEventData.obj instanceof List)) {
                    for (String str3 : (List) mStorageEventData.obj) {
                        linkedList2.addAll(n.buJ().Ww(str3));
                    }
                }
                if (!linkedList2.isEmpty()) {
                    n.buJ().doNotify(MStorageEventData.EventType.BATCH, 5, linkedList2);
                    break;
                }
                break;
        }
        AppMethodBeat.o(45009);
    }
}
