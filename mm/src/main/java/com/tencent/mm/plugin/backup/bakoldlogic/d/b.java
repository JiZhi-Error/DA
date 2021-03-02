package com.tencent.mm.plugin.backup.bakoldlogic.d;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.i;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.g.a.ae;
import com.tencent.mm.g.a.ca;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.messenger.foundation.a.m;
import com.tencent.mm.pluginsdk.model.app.d;
import com.tencent.mm.pluginsdk.model.app.j;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.bk;
import com.tencent.mm.storage.ck;
import com.tencent.mm.storage.emotion.f;
import com.tencent.mm.storage.t;
import com.tencent.mm.storagebase.h;
import com.tencent.mm.vfs.s;
import java.util.HashMap;
import junit.framework.Assert;

public final class b extends com.tencent.mm.plugin.backup.b.a {
    private static b oSS;
    private static int oSV = 0;
    private c oST;
    private a oSU;
    private c oSW;

    static /* synthetic */ boolean a(b bVar, PLong pLong, PLong pLong2, PLong pLong3, a aVar, int i2) {
        AppMethodBeat.i(22077);
        boolean a2 = bVar.a(pLong, pLong2, pLong3, aVar, i2);
        AppMethodBeat.o(22077);
        return a2;
    }

    static /* synthetic */ int access$008() {
        int i2 = oSV;
        oSV = i2 + 1;
        return i2;
    }

    static /* synthetic */ int chC() {
        int i2 = oSV;
        oSV = i2 - 1;
        return i2;
    }

    public static b chw() {
        AppMethodBeat.i(22068);
        if (oSS == null) {
            b bVar = new b();
            oSS = bVar;
            a(bVar);
        }
        b bVar2 = oSS;
        AppMethodBeat.o(22068);
        return bVar2;
    }

    @Override // com.tencent.mm.plugin.backup.b.a
    public final void ceH() {
        oSS = null;
    }

    public final c chx() {
        AppMethodBeat.i(22069);
        if (this.oST == null) {
            this.oST = new c();
        }
        c cVar = this.oST;
        AppMethodBeat.o(22069);
        return cVar;
    }

    public final a chy() {
        AppMethodBeat.i(22070);
        if (this.oSU == null) {
            this.oSU = new a();
        }
        a aVar = this.oSU;
        AppMethodBeat.o(22070);
        return aVar;
    }

    private static void chz() {
        AppMethodBeat.i(22071);
        EventCenter.instance.publish(new ae());
        AppMethodBeat.o(22071);
    }

    private c chA() {
        AppMethodBeat.i(22072);
        if (this.oSW == null) {
            this.oSW = new c();
        }
        c cVar = this.oSW;
        AppMethodBeat.o(22072);
        return cVar;
    }

    public final void a(final a aVar) {
        AppMethodBeat.i(22073);
        final long nowMilliSecond = Util.nowMilliSecond();
        Log.i("MicroMsg.BakOldTempDbModel", "initTempDB needSyncPauser:%b %s", Boolean.FALSE, Util.getStack());
        MMHandlerThread.postToMainThreadDelayed(new Runnable() {
            /* class com.tencent.mm.plugin.backup.bakoldlogic.d.b.AnonymousClass1 */
            final /* synthetic */ int oPV = -1;

            public final void run() {
                AppMethodBeat.i(22061);
                g.aAf().azk();
                Log.i("MicroMsg.BakOldTempDbModel", "initTempDB, initTempDBCount:%d  timediff:%d ", Integer.valueOf(b.oSV), Long.valueOf(Util.milliSecondsToNow(nowMilliSecond)));
                b.access$008();
                bg.aAk().postAtFrontOfWorker(new MMHandlerThread.IWaitWorkThread() {
                    /* class com.tencent.mm.plugin.backup.bakoldlogic.d.b.AnonymousClass1.AnonymousClass1 */

                    @Override // com.tencent.mm.sdk.platformtools.MMHandlerThread.IWaitWorkThread
                    public final boolean onPostExecute() {
                        AppMethodBeat.i(22058);
                        Log.i("MicroMsg.BakOldTempDbModel", "initTempDB onPostExecute");
                        aVar.run();
                        b.chC();
                        AppMethodBeat.o(22058);
                        return false;
                    }

                    @Override // com.tencent.mm.sdk.platformtools.MMHandlerThread.IWaitWorkThread
                    public final boolean doInBackground() {
                        AppMethodBeat.i(22059);
                        b.chB();
                        b.a(b.this, new PLong(), new PLong(), new PLong(), aVar, AnonymousClass1.this.oPV);
                        AppMethodBeat.o(22059);
                        return true;
                    }

                    public final String toString() {
                        AppMethodBeat.i(22060);
                        String str = super.toString() + "|initTempDB";
                        AppMethodBeat.o(22060);
                        return str;
                    }
                });
                AppMethodBeat.o(22061);
            }
        }, 1000);
        AppMethodBeat.o(22073);
    }

    private boolean a(PLong pLong, PLong pLong2, PLong pLong3, a aVar, int i2) {
        AppMethodBeat.i(22074);
        bg.aVF();
        c.closeDB();
        Log.d("MicroMsg.BakOldTempDbModel", "bakoldInitTempDBimp after close db");
        bg.aVF();
        long boW = s.boW(c.azN());
        bg.aVF();
        pLong3.value = boW + s.boW(c.azO());
        long j2 = pLong3.value;
        bg.aVF();
        if (!com.tencent.mm.plugin.backup.bakoldlogic.a.a.a(j2, pLong, pLong2, c.getAccPath())) {
            Log.e("MicroMsg.BakOldTempDbModel", "bakoldInitTempDBimp data free error, len %d", Long.valueOf(pLong3.value));
            aVar.oTe = false;
            aVar.oTf = pLong.value;
            aVar.oTg = pLong2.value;
            aVar.dbSize = pLong3.value;
            AppMethodBeat.o(22074);
            return false;
        }
        bg.aVF();
        String azN = c.azN();
        StringBuilder sb = new StringBuilder();
        bg.aVF();
        s.nw(azN, sb.append(c.azN()).append(".tem").toString());
        bg.aVF();
        String azO = c.azO();
        StringBuilder sb2 = new StringBuilder();
        bg.aVF();
        s.nw(azO, sb2.append(c.azO()).append(".tem").toString());
        StringBuilder sb3 = new StringBuilder();
        bg.aVF();
        String sb4 = sb3.append(c.azO()).append("-journal").toString();
        StringBuilder sb5 = new StringBuilder();
        bg.aVF();
        s.nw(sb4, sb5.append(c.azO()).append(".tem-journal").toString());
        StringBuilder sb6 = new StringBuilder();
        bg.aVF();
        String sb7 = sb6.append(c.azO()).append("-wal").toString();
        StringBuilder sb8 = new StringBuilder();
        bg.aVF();
        s.nw(sb7, sb8.append(c.azO()).append(".tem-wal").toString());
        Log.i("MicroMsg.BakOldTempDbModel", "bakoldInitTempDBimp before reset account");
        g.aAf().release();
        g.aAf().initialize();
        Log.i("MicroMsg.BakOldTempDbModel", "bakoldInitTempDBimp before TemAccStg setAccInfo");
        c chA = chA();
        bg.aVF();
        String accPath = c.getAccPath();
        bg.aVF();
        int uin = c.getUin();
        Log.i("MicroMsg.BakOldTempStorage", "accPath:%s, accUin:%d", accPath, Integer.valueOf(uin));
        chA.uin = uin;
        chA.hqG = accPath;
        Log.i("MicroMsg.BakOldTempDbModel", "bakoldInitTempDBimp before TemAccStg initDB");
        c chA2 = chA();
        StringBuilder sb9 = new StringBuilder();
        bg.aVF();
        String sb10 = sb9.append(c.azN()).append(".tem").toString();
        bg.aVF();
        int uin2 = c.getUin();
        StringBuilder sb11 = new StringBuilder();
        bg.aVF();
        String sb12 = sb11.append(c.azO()).append(".tem").toString();
        Log.i("MicroMsg.BakOldTempStorage", "bakoldInitDB isTempDB:%s  cache:%s uin:%s db:%s %s", chA2.oTj, sb10, Integer.valueOf(uin2), sb12, Util.getStack());
        if (chA2.hqK != null) {
            Log.e("MicroMsg.BakOldTempStorage", "bakoldInitDB dataDB is already init!!!");
        }
        if (i2 > 0) {
            if (chA2.oTj != null && !chA2.oTj.booleanValue()) {
                Log.e("MicroMsg.BakOldTempStorage", "bakoldInitDB isTempDB is false!!!");
                chA2.chE();
            }
            Assert.assertTrue("bakoldInitDB here  isTempDb should null :" + chA2.oTj, chA2.oTj == null);
        }
        chA2.oTj = Boolean.TRUE;
        chA2.hqK = new h(new h.a() {
            /* class com.tencent.mm.plugin.backup.bakoldlogic.d.c.AnonymousClass2 */

            @Override // com.tencent.mm.storagebase.h.a
            public final void azX() {
                AppMethodBeat.i(22080);
                if (c.this.oTi != null) {
                    com.tencent.mm.storagebase.g gVar = c.this.oTi;
                    for (String str : gVar.Oty.keySet()) {
                        gVar.Oty.get(str).gFI();
                    }
                }
                AppMethodBeat.o(22080);
            }

            @Override // com.tencent.mm.storagebase.h.a
            public final void azY() {
            }

            /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
                jadx.core.utils.exceptions.JadxRuntimeException: CFG modification limit reached, blocks count: 147
                	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:72)
                	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.visit(BlockProcessor.java:46)
                */
            @Override // com.tencent.mm.storagebase.h.a
            public final void azZ() {
                /*
                // Method dump skipped, instructions count: 491
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.backup.bakoldlogic.d.c.AnonymousClass2.azZ():void");
            }
        });
        q.dr(true);
        if (!chA2.hqK.b(sb10, sb12, "", (long) uin2, new HashMap<>(), false)) {
            com.tencent.mm.model.b bVar = new com.tencent.mm.model.b((byte) 0);
            AppMethodBeat.o(22074);
            throw bVar;
        }
        chA2.oQv = new ao(chA2.hqK);
        m mVar = (m) g.af(m.class);
        chA2.oQw = mVar.c(chA2.hqK);
        chA2.oQy = mVar.d(chA2.hqK);
        chA2.oQx = mVar.a(chA2.hqK, chA2.oQw, chA2.oQy);
        chA2.oQx.a(new bk(chA2.oQx));
        chA2.oQx.a(new t(chA2.oQx));
        chA2.oQB = mVar.e(chA2.hqK);
        chA2.oQz = new i(chA2.hqK);
        if (com.tencent.mm.br.c.aZU("emoji")) {
            chA2.oQA = new f(chA2.hqK);
        }
        chA2.oQD = ((com.tencent.mm.plugin.chatroom.a.c) g.af(com.tencent.mm.plugin.chatroom.a.c.class)).b(chA2.hqK);
        chA2.oQC = new com.tencent.mm.modelvideo.t(chA2.hqK);
        chA2.oQE = new l(chA2.hqK);
        chA2.oQF = new j(chA2.hqK);
        chA2.oQG = new d(chA2.hqK);
        chA2.oTh = new ck(chA2.oQv);
        chA2.oTh.add(new MStorage.IOnStorageChange() {
            /* class com.tencent.mm.plugin.backup.bakoldlogic.d.c.AnonymousClass1 */

            @Override // com.tencent.mm.sdk.storage.MStorage.IOnStorageChange
            public final void onNotifyChange(String str, MStorageEventData mStorageEventData) {
                AppMethodBeat.i(22079);
                com.tencent.mm.compatible.deviceinfo.ae.DV(str);
                AppMethodBeat.o(22079);
            }
        });
        chA2.oTh.gEr();
        Log.i("MicroMsg.BakOldTempDbModel", "bakoldInitTempDBimp after TemAccStg initDB");
        chz();
        aVar.oTe = true;
        aVar.oTf = pLong.value;
        aVar.oTg = pLong2.value;
        aVar.dbSize = pLong3.value;
        com.tencent.mm.plugin.backup.bakoldlogic.a.a.agL(com.tencent.mm.plugin.backup.bakoldlogic.a.a.cgW());
        AppMethodBeat.o(22074);
        return true;
    }

    public static void chB() {
        AppMethodBeat.i(22075);
        StringBuilder sb = new StringBuilder();
        bg.aVF();
        s.deleteFile(sb.append(c.azN()).append(".tem").toString());
        StringBuilder sb2 = new StringBuilder();
        bg.aVF();
        s.deleteFile(sb2.append(c.azN()).append(".ini.tem").toString());
        StringBuilder sb3 = new StringBuilder();
        bg.aVF();
        s.deleteFile(sb3.append(c.azO()).append(".tem").toString());
        StringBuilder sb4 = new StringBuilder();
        bg.aVF();
        s.deleteFile(sb4.append(c.azO()).append(".ini.tem").toString());
        AppMethodBeat.o(22075);
    }

    public static class a implements Runnable {
        public long dbSize = 0;
        public boolean oTe = true;
        public long oTf = 0;
        public long oTg = 0;

        public void run() {
            AppMethodBeat.i(22067);
            AppMethodBeat.o(22067);
        }
    }

    public final void a(final Runnable runnable, final int i2) {
        AppMethodBeat.i(22076);
        if (i2 < 0 || oSV == 0) {
            if (i2 < 0) {
                Log.e("MicroMsg.BakOldTempDbModel", "closeTempDB no left tryCount!!");
            }
            Log.i("MicroMsg.BakOldTempDbModel", "closeDB before");
            chA().chE();
            Log.i("MicroMsg.BakOldTempDbModel", "closeDB after");
            if (runnable != null) {
                runnable.run();
                AppMethodBeat.o(22076);
                return;
            }
        } else {
            new MMHandler(Looper.getMainLooper()).postDelayed(new Runnable() {
                /* class com.tencent.mm.plugin.backup.bakoldlogic.d.b.AnonymousClass3 */

                public final void run() {
                    AppMethodBeat.i(22066);
                    b.this.a(runnable, i2 - 1);
                    AppMethodBeat.o(22066);
                }
            }, 500);
        }
        AppMethodBeat.o(22076);
    }

    static /* synthetic */ void chD() {
        AppMethodBeat.i(22078);
        long nowMilliSecond = Util.nowMilliSecond();
        bg.aVF();
        c.closeDB();
        StringBuilder sb = new StringBuilder();
        bg.aVF();
        String sb2 = sb.append(c.azN()).append(".tem").toString();
        bg.aVF();
        s.nw(sb2, c.azN());
        StringBuilder sb3 = new StringBuilder();
        bg.aVF();
        String sb4 = sb3.append(c.azO()).append(".tem").toString();
        bg.aVF();
        s.nw(sb4, c.azO());
        StringBuilder sb5 = new StringBuilder();
        bg.aVF();
        String sb6 = sb5.append(c.azO()).append(".tem-journal").toString();
        StringBuilder sb7 = new StringBuilder();
        bg.aVF();
        s.nw(sb6, sb7.append(c.azO()).append("-journal").toString());
        StringBuilder sb8 = new StringBuilder();
        bg.aVF();
        String sb9 = sb8.append(c.azO()).append(".tem-wal").toString();
        StringBuilder sb10 = new StringBuilder();
        bg.aVF();
        s.nw(sb9, sb10.append(c.azO()).append("-wal").toString());
        EventCenter.instance.publish(new ca());
        g.aAf().release();
        g.aAf().initialize();
        chB();
        chz();
        Log.i("MicroMsg.BakOldTempDbModel", "bakoldRecoverFromTempDbImp finish cost time[%d]", Long.valueOf(Util.milliSecondsToNow(nowMilliSecond)));
        AppMethodBeat.o(22078);
    }
}
