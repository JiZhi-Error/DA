package com.tencent.mm.plugin.account.model;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.mp;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.plugin.account.a.a.b;
import com.tencent.mm.plugin.account.friend.a.ad;
import com.tencent.mm.plugin.account.friend.a.ao;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public final class a implements i {
    b iUG = new b() {
        /* class com.tencent.mm.plugin.account.model.a.AnonymousClass3 */

        @Override // com.tencent.mm.plugin.account.a.a.b
        public final void fG(boolean z) {
            AppMethodBeat.i(127809);
            Log.i("MicroMsg.ContactsAutoSyncLogic ", "performSync end, succ:%b", Boolean.valueOf(z));
            if (!z) {
                AppMethodBeat.o(127809);
            } else if (l.boi().size() > 0) {
                Log.i("MicroMsg.ContactsAutoSyncLogic ", "start to upload mobile list");
                g.azz().a(133, a.this);
                System.currentTimeMillis();
                l.boe();
                g.azz().a(new ao(l.boi(), l.boh()), 0);
                AppMethodBeat.o(127809);
            } else {
                Log.i("MicroMsg.ContactsAutoSyncLogic ", "update mobile friend list");
                String[] strArr = (String[]) a.this.kig.toArray(new String[0]);
                a.this.kig.clear();
                ArrayList arrayList = new ArrayList();
                for (String str : strArr) {
                    com.tencent.mm.plugin.account.friend.a.a SR = com.tencent.mm.plugin.account.a.getAddrUploadStg().SR(str);
                    if (SR == null || Util.isNullOrNil(SR.bnP())) {
                        Log.i("MicroMsg.ContactsAutoSyncLogic ", "not find mobile username %s", str);
                    } else {
                        arrayList.add(SR.bnP());
                        Log.i("MicroMsg.ContactsAutoSyncLogic ", "find mobile %s username %s", SR.bnP(), str);
                    }
                }
                g.azz().a(32, a.this);
                if (arrayList.size() == 0) {
                    Log.i("MicroMsg.ContactsAutoSyncLogic ", "sync mobile list is zero");
                    g.azz().a(new ad(), 0);
                    AppMethodBeat.o(127809);
                    return;
                }
                Log.i("MicroMsg.ContactsAutoSyncLogic ", "sync mobile list is %d", Integer.valueOf(arrayList.size()));
                g.azz().a(new ad(arrayList, null), 0);
                AppMethodBeat.o(127809);
            }
        }
    };
    boolean jkK = false;
    Set<String> kig = Collections.synchronizedSet(new HashSet());
    IListener kih = new IListener<mp>() {
        /* class com.tencent.mm.plugin.account.model.a.AnonymousClass1 */

        {
            AppMethodBeat.i(161697);
            this.__eventId = mp.class.getName().hashCode();
            AppMethodBeat.o(161697);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(mp mpVar) {
            AppMethodBeat.i(127807);
            mp mpVar2 = mpVar;
            Log.i("MicroMsg.ContactsAutoSyncLogic ", "sync username=%s isUploading=%b", mpVar2.dSe.username, Boolean.valueOf(a.this.jkK));
            a.this.kig.add(mpVar2.dSe.username);
            if (!a.this.jkK) {
                a.this.kii.removeMessages(0);
                a.this.kii.sendEmptyMessageDelayed(0, 10000);
            }
            AppMethodBeat.o(127807);
            return false;
        }
    };
    MMHandler kii = new MMHandler() {
        /* class com.tencent.mm.plugin.account.model.a.AnonymousClass2 */

        @Override // com.tencent.mm.sdk.platformtools.MMHandler
        public final void handleMessage(Message message) {
            AppMethodBeat.i(127808);
            switch (message.what) {
                case 0:
                    a.this.jkK = true;
                    boolean syncAddrBook = com.tencent.mm.platformtools.a.syncAddrBook(a.this.iUG);
                    if (!syncAddrBook) {
                        a.this.jkK = false;
                    }
                    Log.i("MicroMsg.ContactsAutoSyncLogic ", "sync result %b", Boolean.valueOf(syncAddrBook));
                    break;
            }
            AppMethodBeat.o(127808);
        }
    };

    public a() {
        AppMethodBeat.i(127810);
        EventCenter.instance.addListener(this.kih);
        AppMethodBeat.o(127810);
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(127811);
        if (qVar.getType() == 133) {
            g.azz().b(133, this);
            if (i2 == 0 && i3 == 0) {
                g.azz().a(32, this);
                ao aoVar = (ao) qVar;
                g.azz().a(new ad(aoVar.kfA, aoVar.kfB), 0);
            } else {
                Log.e("MicroMsg.ContactsAutoSyncLogic ", "MMFunc_UploadMContact onSceneEnd: errType = " + i2 + ", errCode = " + i3);
                this.jkK = false;
            }
        }
        if (qVar.getType() == 32) {
            this.jkK = false;
            g.azz().b(32, this);
            if (i2 == 0 && i3 == 0) {
                Log.i("MicroMsg.ContactsAutoSyncLogic ", "update All Contact");
                t.dt(MMApplicationContext.getContext());
            } else {
                Log.e("MicroMsg.ContactsAutoSyncLogic ", "rtGETMFRIEND onSceneEnd: errType = " + i2 + ", errCode = " + i3);
                AppMethodBeat.o(127811);
                return;
            }
        }
        AppMethodBeat.o(127811);
    }
}
