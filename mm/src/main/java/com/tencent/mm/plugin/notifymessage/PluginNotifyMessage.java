package com.tencent.mm.plugin.notifymessage;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.api.a;
import com.tencent.mm.kernel.api.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storage.cf;
import com.tencent.mm.storagebase.h;
import com.tencent.mm.vending.b.b;
import com.tencent.rtmp.TXLiveConstants;
import com.tencent.wxmm.v2helper;
import java.util.HashMap;
import java.util.Iterator;

public class PluginNotifyMessage extends f implements a, c, a {
    private cf AHY;
    private final i.a AHZ = new i.a() {
        /* class com.tencent.mm.plugin.notifymessage.PluginNotifyMessage.AnonymousClass1 */

        @Override // com.tencent.mm.plugin.messenger.foundation.a.a.i.a
        public final void a(i iVar, i.c cVar) {
            AppMethodBeat.i(231770);
            if (!(iVar == null || cVar.hIs == null)) {
                Iterator<ca> it = cVar.hIs.iterator();
                while (it.hasNext()) {
                    ca next = it.next();
                    if (next != null && "notifymessage".equals(cVar.talker)) {
                        cf notifyMessageRecordStorage = PluginNotifyMessage.this.getNotifyMessageRecordStorage();
                        if (notifyMessageRecordStorage == null) {
                            Log.e("MicroMsg.PluginNotifyMessage", "get message notify storage return null");
                            AppMethodBeat.o(231770);
                            return;
                        }
                        String bc = cf.bc(next);
                        if (Util.isNullOrNil(bc)) {
                            Log.i("MicroMsg.PluginNotifyMessage", "username is null or nil");
                        }
                        String bd = cf.bd(next);
                        next.Cy(bc);
                        String str = cVar.zqn;
                        char c2 = 65535;
                        switch (str.hashCode()) {
                            case -1335458389:
                                if (str.equals("delete")) {
                                    c2 = 1;
                                    break;
                                }
                                break;
                            case -1183792455:
                                if (str.equals("insert")) {
                                    c2 = 0;
                                    break;
                                }
                                break;
                            case -838846263:
                                if (str.equals("update")) {
                                    c2 = 2;
                                    break;
                                }
                                break;
                        }
                        switch (c2) {
                            case 0:
                                notifyMessageRecordStorage.e(next, bd);
                                continue;
                            case 1:
                                notifyMessageRecordStorage.bb(next);
                                continue;
                            case 2:
                                notifyMessageRecordStorage.f(next, bd);
                                continue;
                        }
                    }
                }
            }
            AppMethodBeat.o(231770);
        }
    };
    private b kJs = null;
    private MMHandler mHandler = null;

    public PluginNotifyMessage() {
        AppMethodBeat.i(231772);
        AppMethodBeat.o(231772);
    }

    static /* synthetic */ void access$000(PluginNotifyMessage pluginNotifyMessage, long j2) {
        AppMethodBeat.i(231779);
        pluginNotifyMessage.reportTimeCost(j2);
        AppMethodBeat.o(231779);
    }

    @Override // com.tencent.mm.kernel.a.c.b
    public void execute(g gVar) {
    }

    @Override // com.tencent.mm.kernel.api.a
    public HashMap<Integer, h.b> collectDatabaseFactory() {
        AppMethodBeat.i(231773);
        HashMap<Integer, h.b> hashMap = new HashMap<>();
        hashMap.put(Integer.valueOf("NotifyMessageRecord".hashCode()), new h.b() {
            /* class com.tencent.mm.plugin.notifymessage.PluginNotifyMessage.AnonymousClass2 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                return cf.SQL_CREATE;
            }
        });
        AppMethodBeat.o(231773);
        return hashMap;
    }

    @Override // com.tencent.mm.kernel.api.c
    public void onAccountInitialized(e.c cVar) {
        AppMethodBeat.i(231774);
        Log.d("MicroMsg.PluginNotifyMessage", "onAccountInitialized");
        Log.i("MicroMsg.PluginNotifyMessage", "onAccountPostReset updated %b", Boolean.valueOf(cVar.hrc));
        getNotifyMessageRecordStorage();
        ((l) com.tencent.mm.kernel.g.af(l.class)).eiy().a(this.AHZ, Looper.getMainLooper());
        checkNotifyRecord();
        AppMethodBeat.o(231774);
    }

    @Override // com.tencent.mm.kernel.api.c
    public void onAccountRelease() {
        AppMethodBeat.i(231775);
        Log.d("MicroMsg.PluginNotifyMessage", "onAccountRelease");
        if (this.kJs != null) {
            this.kJs.dead();
            this.kJs = null;
        }
        ((l) com.tencent.mm.kernel.g.af(l.class)).eiy().a(this.AHZ);
        AppMethodBeat.o(231775);
    }

    @Override // com.tencent.mm.plugin.notifymessage.a
    public cf getNotifyMessageRecordStorage() {
        AppMethodBeat.i(231776);
        com.tencent.mm.kernel.g.aAf().azk();
        if (this.AHY == null) {
            com.tencent.mm.kernel.g.aAi();
            this.AHY = new cf(com.tencent.mm.kernel.g.aAh().hqK);
        }
        cf cfVar = this.AHY;
        AppMethodBeat.o(231776);
        return cfVar;
    }

    private void checkNotifyRecord() {
        AppMethodBeat.i(231777);
        Log.i("MicroMsg.PluginNotifyMessage", "check record");
        final cf notifyMessageRecordStorage = getNotifyMessageRecordStorage();
        if (notifyMessageRecordStorage == null) {
            Log.e("MicroMsg.PluginNotifyMessage", "get message notify storage return null");
            AppMethodBeat.o(231777);
            return;
        }
        boolean z = notifyMessageRecordStorage.gEh() != notifyMessageRecordStorage.gEi();
        Log.i("MicroMsg.NotifyMessageRecordStorage", "need sync record: %b", Boolean.valueOf(z));
        if (z) {
            if (this.mHandler == null) {
                this.mHandler = new MMHandler("PluginNotifyMessage#syncRecord");
            }
            Log.i("MicroMsg.PluginNotifyMessage", "pre sync");
            this.mHandler.post(new Runnable() {
                /* class com.tencent.mm.plugin.notifymessage.PluginNotifyMessage.AnonymousClass3 */

                public final void run() {
                    boolean gEj;
                    AppMethodBeat.i(231771);
                    Log.i("MicroMsg.PluginNotifyMessage", "before sync");
                    long currentTicks = Util.currentTicks();
                    cf cfVar = notifyMessageRecordStorage;
                    if (cf.Orv) {
                        Log.e("MicroMsg.NotifyMessageRecordStorage", "sync is running");
                        gEj = false;
                    } else {
                        Log.i("MicroMsg.NotifyMessageRecordStorage", "syncRecord");
                        long currentTicks2 = Util.currentTicks();
                        cf.Orv = true;
                        gEj = cfVar.gEj();
                        Log.i("MicroMsg.NotifyMessageRecordStorage", "handle msg info done, cost: %d", Long.valueOf(Util.ticksToNow(currentTicks2)));
                        cf.Orv = false;
                    }
                    long ticksToNow = Util.ticksToNow(currentTicks);
                    Log.i("MicroMsg.PluginNotifyMessage", "syncNotifyRecord finish, ret: %b, cost: %d", Boolean.valueOf(gEj), Long.valueOf(ticksToNow));
                    PluginNotifyMessage.access$000(PluginNotifyMessage.this, ticksToNow);
                    AppMethodBeat.o(231771);
                }
            });
        }
        AppMethodBeat.o(231777);
    }

    private void reportTimeCost(long j2) {
        int i2;
        AppMethodBeat.i(231778);
        com.tencent.mm.plugin.report.service.h.INSTANCE.n(1584, 0, j2);
        com.tencent.mm.plugin.report.service.h.INSTANCE.n(1584, 1, 1);
        long j3 = j2 / 1000;
        int[] iArr = {5, 10, 20, 30, 40, 50, 60, 90, TXLiveConstants.RENDER_ROTATION_180, v2helper.VOIP_ENC_HEIGHT_LV1, 600};
        if (j3 >= 600) {
            i2 = 32;
        } else {
            i2 = 21;
            int i3 = 0;
            while (true) {
                if (i3 >= 11) {
                    break;
                } else if (j3 < ((long) iArr[i3])) {
                    i2 = i3 + 21;
                    break;
                } else {
                    i3++;
                }
            }
        }
        com.tencent.mm.plugin.report.service.h.INSTANCE.n(1584, (long) i2, 1);
        AppMethodBeat.o(231778);
    }
}
