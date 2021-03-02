package com.tencent.mm.plugin.ipcall;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.jx;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.storage.ar;
import java.util.ArrayList;
import java.util.Iterator;

public final class a implements i {
    private static a yod = null;
    private boolean gYQ = false;
    private long ynZ = -1;
    private long yoa = -1;
    private long yob = -1;
    private long yoc = -1;

    private a() {
    }

    public static a dZG() {
        AppMethodBeat.i(25283);
        if (yod == null) {
            yod = new a();
        }
        a aVar = yod;
        AppMethodBeat.o(25283);
        return aVar;
    }

    public final void cmK() {
        AppMethodBeat.i(25284);
        if (!com.tencent.mm.plugin.ipcall.a.a.boc()) {
            Log.d("MicroMsg.IPCallAddressBookUsernameUpdater", "tryUpdate, can't sync addr book");
        }
        if (this.gYQ) {
            Log.d("MicroMsg.IPCallAddressBookUsernameUpdater", "tryUpdate, updating");
            AppMethodBeat.o(25284);
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        bg.aVF();
        if (Math.abs(currentTimeMillis - ((Long) c.azQ().get(ar.a.USERINFO_IPCALL_ADDRESS_GETMFRIEND_LASTUPDATE_TIME_LONG, (Object) 0L)).longValue()) >= Util.MILLSECONDS_OF_DAY) {
            this.gYQ = true;
            this.ynZ = -1;
            this.yoa = -1;
            this.yob = -1;
            this.yoc = -1;
            bg.azz().a(32, this);
            ThreadPool.post(new Runnable() {
                /* class com.tencent.mm.plugin.ipcall.a.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(25281);
                    Log.d("MicroMsg.IPCallAddressBookUsernameUpdater", "start GetMFriend");
                    jx jxVar = new jx();
                    jxVar.dOQ.scene = 2;
                    EventCenter.instance.publish(jxVar);
                    a.this.ynZ = System.currentTimeMillis();
                    AppMethodBeat.o(25281);
                }
            }, "IPCallAddressBookUpdater_updateUsername");
            AppMethodBeat.o(25284);
            return;
        }
        Log.d("MicroMsg.IPCallAddressBookUsernameUpdater", "tryUpdate, not reach time limit");
        AppMethodBeat.o(25284);
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(25285);
        Log.d("MicroMsg.IPCallAddressBookUsernameUpdater", "onSceneEnd, errType: %d, errCode: %d, isUpdating: %b", Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(this.gYQ));
        if (!this.gYQ) {
            AppMethodBeat.o(25285);
            return;
        }
        bg.azz().b(32, this);
        this.yoa = System.currentTimeMillis();
        Log.d("MicroMsg.IPCallAddressBookUsernameUpdater", "GetMFriend used %dms", Long.valueOf(this.yoa - this.ynZ));
        if (i2 == 0 && i3 == 0) {
            ThreadPool.post(new Runnable() {
                /* class com.tencent.mm.plugin.ipcall.a.AnonymousClass2 */

                public final void run() {
                    AppMethodBeat.i(25282);
                    a.a(a.this);
                    AppMethodBeat.o(25282);
                }
            }, "IPCallAddressBookUsernameUpdater_updateUsernameAfterGetMFriend");
            AppMethodBeat.o(25285);
            return;
        }
        Log.d("MicroMsg.IPCallAddressBookUsernameUpdater", "GetMFriend failed");
        this.gYQ = false;
        dZH();
        AppMethodBeat.o(25285);
    }

    private static void dZH() {
        AppMethodBeat.i(25286);
        long currentTimeMillis = System.currentTimeMillis();
        bg.aVF();
        c.azQ().set(ar.a.USERINFO_IPCALL_ADDRESS_GETMFRIEND_LASTUPDATE_TIME_LONG, Long.valueOf(currentTimeMillis));
        AppMethodBeat.o(25286);
    }

    static /* synthetic */ void a(a aVar) {
        AppMethodBeat.i(25287);
        Log.d("MicroMsg.IPCallAddressBookUsernameUpdater", "updateUsernameAfterGetMFriend");
        aVar.yob = System.currentTimeMillis();
        ArrayList<com.tencent.mm.plugin.ipcall.model.h.c> eaY = com.tencent.mm.plugin.ipcall.model.i.eay().eaY();
        if (eaY != null && eaY.size() > 0) {
            Log.d("MicroMsg.IPCallAddressBookUsernameUpdater", "addressitemList.size: %d", Integer.valueOf(eaY.size()));
            long beginTransaction = com.tencent.mm.plugin.ipcall.model.i.eay().beginTransaction(Thread.currentThread().getId());
            Iterator<com.tencent.mm.plugin.ipcall.model.h.c> it = eaY.iterator();
            while (it.hasNext()) {
                com.tencent.mm.plugin.ipcall.model.h.c next = it.next();
                String aCt = com.tencent.mm.plugin.ipcall.a.a.aCt(next.field_contactId);
                if (next.systemRowid > 0 && !Util.isNullOrNil(aCt)) {
                    Log.d("MicroMsg.IPCallAddressBookUsernameUpdater", "update username for contactId: %s, newUsername: %s, oldUsername: %s", next.field_contactId, aCt, next.field_wechatUsername);
                    if ((!Util.isNullOrNil(next.field_wechatUsername) && !next.field_wechatUsername.equals(aCt)) || Util.isNullOrNil(next.field_wechatUsername)) {
                        next.field_wechatUsername = aCt;
                        com.tencent.mm.plugin.ipcall.model.i.eay().update(next.systemRowid, next);
                    }
                }
            }
            com.tencent.mm.plugin.ipcall.model.i.eay().GS(beginTransaction);
        }
        aVar.yoc = System.currentTimeMillis();
        Log.d("MicroMsg.IPCallAddressBookUsernameUpdater", "update username use %dms", Long.valueOf(aVar.yoc - aVar.yob));
        aVar.gYQ = false;
        dZH();
        AppMethodBeat.o(25287);
    }
}
