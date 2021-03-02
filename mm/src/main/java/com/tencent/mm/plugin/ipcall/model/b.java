package com.tencent.mm.plugin.ipcall.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ky;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.ipcall.model.h.c;
import com.tencent.mm.plugin.ipcall.model.h.k;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.thread.ThreadPool;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public final class b {
    private static IListener yov = new IListener<ky>() {
        /* class com.tencent.mm.plugin.ipcall.model.b.AnonymousClass1 */

        {
            AppMethodBeat.i(161378);
            this.__eventId = ky.class.getName().hashCode();
            AppMethodBeat.o(161378);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(ky kyVar) {
            AppMethodBeat.i(25333);
            if (kyVar instanceof ky) {
                ThreadPool.post(new Runnable() {
                    /* class com.tencent.mm.plugin.ipcall.model.b.AnonymousClass1.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(25332);
                        b.access$000();
                        AppMethodBeat.o(25332);
                    }
                }, "IPCall_SyncAddressBook");
            }
            AppMethodBeat.o(25333);
            return false;
        }
    };

    static {
        AppMethodBeat.i(25337);
        AppMethodBeat.o(25337);
    }

    public static void init() {
        AppMethodBeat.i(25334);
        EventCenter.instance.addListener(yov);
        AppMethodBeat.o(25334);
    }

    public static void release() {
        AppMethodBeat.i(25335);
        EventCenter.instance.removeListener(yov);
        AppMethodBeat.o(25335);
    }

    static /* synthetic */ void access$000() {
        boolean z;
        AppMethodBeat.i(25336);
        try {
            if (!bg.aAc()) {
                Log.e("MicroMsg.IPCallAddressUpdater", "updateAddressStorage, acc not ready");
                AppMethodBeat.o(25336);
                return;
            }
            Log.d("MicroMsg.IPCallAddressUpdater", "start updateAddressStorage");
            long currentTimeMillis = System.currentTimeMillis();
            new com.tencent.mm.plugin.ipcall.model.h.b();
            ArrayList<c> eaY = i.eay().eaY();
            if (eaY != null && eaY.size() > 0) {
                HashMap<String, c> eaX = com.tencent.mm.plugin.ipcall.model.h.b.eaX();
                if (eaX == null || eaX.size() < 0) {
                    AppMethodBeat.o(25336);
                    return;
                }
                long beginTransaction = i.eay().beginTransaction(Thread.currentThread().getId());
                Log.d("MicroMsg.IPCallAddressUpdater", "start delete not exist address");
                Log.d("MicroMsg.IPCallAddressUpdater", "oldItemList.size: %d", Integer.valueOf(eaY.size()));
                Iterator<c> it = eaY.iterator();
                while (it.hasNext()) {
                    c next = it.next();
                    if (!eaX.containsKey(next.field_contactId)) {
                        long j2 = next.systemRowid;
                        i.eay().delete(j2);
                        Log.d("MicroMsg.IPCallAddressUpdater", "updateDeleteAddressRecord, id: %d", Long.valueOf(j2));
                        Cursor GT = i.eaz().GT(j2);
                        if (GT != null) {
                            try {
                                if (GT.moveToFirst()) {
                                    while (!GT.isAfterLast()) {
                                        k kVar = new k();
                                        kVar.convertFrom(GT);
                                        kVar.field_addressId = -1;
                                        kVar.field_phoneType = -1;
                                        i.eaz().a(kVar);
                                        GT.moveToNext();
                                    }
                                }
                            } catch (Exception e2) {
                                Log.e("MicroMsg.IPCallAddressUpdater", "updateDeleteAddressRecord error: %s", e2.getMessage());
                                if (GT != null) {
                                    GT.close();
                                }
                            } catch (Throwable th) {
                                if (GT != null) {
                                    GT.close();
                                }
                                AppMethodBeat.o(25336);
                                throw th;
                            }
                        }
                        if (GT != null) {
                            GT.close();
                        }
                    }
                }
                Log.d("MicroMsg.IPCallAddressUpdater", "start update or insert address");
                for (c cVar : eaX.values()) {
                    c aBV = i.eay().aBV(cVar.field_contactId);
                    if (aBV == null || aBV.systemRowid == -1) {
                        i.eay().insert(cVar);
                    } else {
                        if (cVar == null || !c.ik(aBV.field_contactId, cVar.field_contactId) || !c.ik(aBV.field_systemAddressBookUsername, cVar.field_systemAddressBookUsername) || !c.ik(aBV.field_wechatUsername, cVar.field_wechatUsername)) {
                            z = false;
                        } else {
                            z = true;
                        }
                        if (!z) {
                            i.eay().update(aBV.systemRowid, cVar);
                        }
                    }
                }
                i.eay().GS(beginTransaction);
                Log.d("MicroMsg.IPCallAddressUpdater", "updateAddressStorage, used %dms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            }
            AppMethodBeat.o(25336);
        } catch (Exception e3) {
            Log.e("MicroMsg.IPCallAddressUpdater", "updateAddressStorage error:" + e3.getMessage());
            AppMethodBeat.o(25336);
        }
    }
}
