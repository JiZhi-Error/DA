package com.tencent.mm.plugin.account.model;

import android.accounts.Account;
import android.app.Service;
import android.content.AbstractThreadedSyncAdapter;
import android.content.ContentProviderClient;
import android.content.Context;
import android.content.Intent;
import android.content.SyncResult;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.friend.a.ad;
import com.tencent.mm.plugin.account.friend.a.ao;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.pluginsdk.permission.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;

@JgClassChecked(author = 20, fComment = "checked", lastDate = "20140422", reviewer = 20, vComment = {EType.SERVICESCHECK})
public class ContactsSyncService extends Service implements i {
    private static Account jMD;
    private a kil = null;
    private Looper kim;

    static /* synthetic */ void a(ContactsSyncService contactsSyncService) {
        AppMethodBeat.i(127823);
        contactsSyncService.boM();
        AppMethodBeat.o(127823);
    }

    public ContactsSyncService() {
        AppMethodBeat.i(127817);
        Log.i("MicroMsg.ContactsSyncService", "ContactsSyncService construction");
        AppMethodBeat.o(127817);
    }

    class a extends AbstractThreadedSyncAdapter {
        private Context mContext;

        public a(Context context) {
            super(context, true);
            AppMethodBeat.i(127815);
            this.mContext = context;
            Log.i("MicroMsg.ContactsSyncService", "ContactsSyncService SyncAdapterImpl construction");
            AppMethodBeat.o(127815);
        }

        public final void onPerformSync(Account account, Bundle bundle, String str, ContentProviderClient contentProviderClient, SyncResult syncResult) {
            AppMethodBeat.i(127816);
            Log.i("MicroMsg.ContactsSyncService", "ContactsSyncService SyncAdapterImpl onPerformSync");
            if (!g.aAc()) {
                Log.e("MicroMsg.ContactsSyncService", "ContactsSyncService account not ready, ignore this sync");
                AppMethodBeat.o(127816);
                return;
            }
            try {
                Looper.prepare();
                ContactsSyncService.this.kim = Looper.myLooper();
                ContactsSyncService.a(ContactsSyncService.this, account);
                Looper.loop();
                AppMethodBeat.o(127816);
            } catch (Exception e2) {
                ContactsSyncService.a(ContactsSyncService.this);
                Log.e("MicroMsg.ContactsSyncService", "ContactsSyncService.onPerformSync error: " + e2.getMessage());
                AppMethodBeat.o(127816);
            }
        }
    }

    public IBinder onBind(Intent intent) {
        AppMethodBeat.i(127818);
        IBinder iBinder = null;
        if (b.n(this, "android.permission.READ_CONTACTS")) {
            if (this.kil == null) {
                this.kil = new a(getApplicationContext());
            }
            iBinder = this.kil.getSyncAdapterBinder();
        } else {
            Log.i("MicroMsg.ContactsSyncService", "ContactsSyncService onBind no permission");
        }
        Log.i("MicroMsg.ContactsSyncService", "ContactsSyncService onBind ret[%s]", iBinder);
        AppMethodBeat.o(127818);
        return iBinder;
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(127819);
        Log.i("MicroMsg.ContactsSyncService", "onSceneEnd: errType = " + i2 + " errCode = " + i3 + " errMsg = " + str + " type = " + qVar.getType());
        if (qVar.getType() == 133) {
            g.azz().b(133, this);
            Log.i("MicroMsg.ContactsSyncService", "uploadcontact onSceneEnd: errType = " + i2 + ", errCode = " + i3);
            long longValue = ((Long) g.aAh().azQ().get(327728, (Object) 0L)).longValue();
            long currentTimeMillis = System.currentTimeMillis();
            Log.d("MicroMsg.ContactsSyncService", "getMFriend : curTime=" + currentTimeMillis + ", lastTime=" + longValue);
            if (i3 == 0 || currentTimeMillis - longValue >= Util.MILLSECONDS_OF_DAY) {
                g.aAh().azQ().set(327728, Long.valueOf(currentTimeMillis));
                g.azz().a(32, this);
                ao aoVar = (ao) qVar;
                g.azz().a(new ad(aoVar.kfA, aoVar.kfB), 0);
            } else {
                boM();
                Log.e("MicroMsg.ContactsSyncService", "uploadmcontact list null, do not do getmfriend.");
                AppMethodBeat.o(127819);
                return;
            }
        }
        if (qVar.getType() == 32) {
            g.azz().b(32, this);
            Log.i("MicroMsg.ContactsSyncService", "getmfriend onSceneEnd: errType = " + i2 + ", errCode = " + i3);
            if (i2 == 0 && i3 == 0 && !g.aAh().azQ().getBoolean(ar.a.USERINFO_ACCOUNT_MANAGER_NEW_ACCOUNTS_BOOLEAN_SYNC, false)) {
                h.RTc.aX(new com.tencent.mm.platformtools.g(this, jMD));
            }
            boM();
        }
        AppMethodBeat.o(127819);
    }

    private void boM() {
        AppMethodBeat.i(127820);
        if (this.kim != null) {
            this.kim.quit();
        }
        AppMethodBeat.o(127820);
    }

    public void onDestroy() {
        AppMethodBeat.i(127821);
        Log.i("MicroMsg.ContactsSyncService", "contacts sync service destroy");
        super.onDestroy();
        AppMethodBeat.o(127821);
    }

    static /* synthetic */ void a(ContactsSyncService contactsSyncService, Account account) {
        AppMethodBeat.i(127822);
        jMD = account;
        g.aAf();
        if (!com.tencent.mm.kernel.a.azo() || com.tencent.mm.kernel.a.azj()) {
            contactsSyncService.boM();
            Log.e("MicroMsg.ContactsSyncService", "performSync error: no user login");
            AppMethodBeat.o(127822);
        } else if (!l.bnX()) {
            Log.e("MicroMsg.ContactsSyncService", "this user has not agreed to upload address book");
            contactsSyncService.boM();
            AppMethodBeat.o(127822);
        } else {
            Log.i("MicroMsg.ContactsSyncService", "performSync start");
            if (!com.tencent.mm.platformtools.a.syncAddrBook(new com.tencent.mm.plugin.account.a.a.b() {
                /* class com.tencent.mm.plugin.account.model.ContactsSyncService.AnonymousClass1 */

                @Override // com.tencent.mm.plugin.account.a.a.b
                public final void fG(boolean z) {
                    AppMethodBeat.i(127814);
                    Log.i("MicroMsg.ContactsSyncService", "performSync end, succ:%b", Boolean.valueOf(z));
                    if (!z) {
                        ContactsSyncService.a(ContactsSyncService.this);
                        AppMethodBeat.o(127814);
                        return;
                    }
                    g.azz().a(133, ContactsSyncService.this);
                    System.currentTimeMillis();
                    l.boe();
                    g.azz().a(new ao(l.boi(), l.boh()), 0);
                    AppMethodBeat.o(127814);
                }
            })) {
                contactsSyncService.boM();
                Log.i("MicroMsg.ContactsSyncService", "performSync result false");
            }
            AppMethodBeat.o(127822);
        }
    }
}
