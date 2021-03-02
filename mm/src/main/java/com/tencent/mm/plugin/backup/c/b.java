package com.tencent.mm.plugin.backup.c;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.backup.b.f;
import com.tencent.mm.plugin.backup.b.g;
import com.tencent.mm.plugin.backup.f.h;
import com.tencent.mm.plugin.backup.h.d;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.ca;
import java.util.LinkedList;

public final class b {
    public boolean oJF = false;

    public interface a {
        void C(LinkedList<f.b> linkedList);
    }

    /* renamed from: com.tencent.mm.plugin.backup.c.b$b  reason: collision with other inner class name */
    public interface AbstractC0842b extends a {
        void D(LinkedList<f.b> linkedList);

        void a(LinkedList<f.b> linkedList, f.b bVar, int i2);
    }

    public final void cancel() {
        AppMethodBeat.i(21229);
        Log.i("MicroMsg.BackupCalculator", "cancel. stack:%s", Util.getStack());
        this.oJF = true;
        AppMethodBeat.o(21229);
    }

    public final void a(final a aVar) {
        AppMethodBeat.i(21230);
        Log.i("MicroMsg.BackupCalculator", "calculateChooseConversation start");
        long nowMilliSecond = Util.nowMilliSecond();
        final LinkedList linkedList = new LinkedList();
        Cursor c2 = d.cgP().cgQ().aST().c(ab.iCF, g.cfd(), "*");
        if (c2.getCount() == 0) {
            if (aVar != null) {
                MMHandlerThread.postToMainThread(new Runnable() {
                    /* class com.tencent.mm.plugin.backup.c.b.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(21225);
                        if (aVar != null) {
                            aVar.C(linkedList);
                        }
                        AppMethodBeat.o(21225);
                    }
                });
            }
            Log.i("MicroMsg.BackupCalculator", "calculateChooseConversation empty conversation!");
            c2.close();
            AppMethodBeat.o(21230);
            return;
        }
        c2.moveToFirst();
        Log.i("MicroMsg.BackupCalculator", "calculateChooseConversation count[%d]", Integer.valueOf(c2.getCount()));
        while (!this.oJF) {
            az azVar = new az();
            azVar.convertFrom(c2);
            if (!Util.isNullOrNil(azVar.field_username)) {
                int aEM = d.cgP().cgQ().aSQ().aEM(azVar.field_username);
                if (aEM <= 0) {
                    Log.i("MicroMsg.BackupCalculator", "calculateChooseConversation empty conversation:%s", azVar.field_username);
                } else {
                    bg.aVF();
                    if (as.akh(c.aSN().Kn(azVar.field_username).field_verifyFlag)) {
                        Log.i("MicroMsg.BackupCalculator", "calculateChooseConversation Biz conv:%s, msgCount[%d]", azVar.field_username, Integer.valueOf(aEM));
                    } else {
                        f.b bVar = new f.b();
                        bVar.oJq = azVar.field_username;
                        bVar.oJr = d.cgP().cgQ().aSQ().aEP(azVar.field_username);
                        bVar.oJs = d.cgP().cgQ().aSQ().aEQ(azVar.field_username);
                        Log.i("MicroMsg.BackupCalculator", "calculateChooseConversation add conv:%s, msgCount[%d], firstMsgTime[%d], lastMsgTime[%d]", bVar.oJq, Integer.valueOf(aEM), Long.valueOf(bVar.oJr), Long.valueOf(bVar.oJs));
                        linkedList.add(bVar);
                    }
                }
            }
            if (!c2.moveToNext()) {
                c2.close();
                if (!this.oJF && aVar != null) {
                    MMHandlerThread.postToMainThread(new Runnable() {
                        /* class com.tencent.mm.plugin.backup.c.b.AnonymousClass2 */

                        public final void run() {
                            AppMethodBeat.i(21226);
                            if (!b.this.oJF && aVar != null) {
                                aVar.C(linkedList);
                            }
                            AppMethodBeat.o(21226);
                        }
                    });
                }
                Log.i("MicroMsg.BackupCalculator", "calculateChooseConversation finish, use time[%d]", Long.valueOf(Util.milliSecondsToNow(nowMilliSecond)));
                AppMethodBeat.o(21230);
                return;
            }
        }
        Log.e("MicroMsg.BackupCalculator", "calculateChooseConversation cancel.");
        c2.close();
        AppMethodBeat.o(21230);
    }

    public final boolean a(f.b bVar, String str, long j2) {
        AppMethodBeat.i(21231);
        if (bVar == null) {
            AppMethodBeat.o(21231);
            return false;
        }
        Cursor aEG = d.cgP().cgQ().aSQ().aEG(bVar.oJq);
        Log.i("MicroMsg.BackupCalculator", "calConversation start convName:%s msgCnt:%d[cu.getCount]", bVar.oJq, Integer.valueOf(aEG.getCount()));
        if (aEG.moveToFirst()) {
            PLong pLong = new PLong();
            PLong pLong2 = new PLong();
            while (!this.oJF) {
                ca caVar = new ca();
                caVar.convertFrom(aEG);
                try {
                    h.a(caVar, true, str, pLong, null, null, false, false, j2);
                } catch (Exception e2) {
                    Log.printErrStackTrace("MicroMsg.BackupCalculator", e2, "packedMsg", new Object[0]);
                }
                pLong2.value++;
                if (!aEG.moveToNext()) {
                    bVar.oJt = pLong.value;
                    bVar.oJu = pLong2.value;
                    Log.i("MicroMsg.BackupCalculator", "calConversation convName:%s, convDataSize:%d, convMsgCount:%d", bVar.oJq, Long.valueOf(bVar.oJt), Long.valueOf(bVar.oJu));
                }
            }
            Log.i("MicroMsg.BackupCalculator", "calConversation cancel, return");
            aEG.close();
            AppMethodBeat.o(21231);
            return true;
        }
        aEG.close();
        AppMethodBeat.o(21231);
        return false;
    }
}
