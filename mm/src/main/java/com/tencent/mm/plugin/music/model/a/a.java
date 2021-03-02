package com.tencent.mm.plugin.music.model.a;

import android.database.Cursor;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.jsapi.pay.q;
import com.tencent.mm.plugin.music.cache.b;
import com.tencent.mm.plugin.music.model.o;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.storage.ar;
import com.tencent.mm.vfs.s;
import java.util.ArrayList;

public final class a implements b {
    @Override // com.tencent.mm.plugin.music.cache.b
    public final void etC() {
        AppMethodBeat.i(261719);
        euF();
        AppMethodBeat.o(261719);
    }

    public final void euF() {
        AppMethodBeat.i(63039);
        long longValue = ((Long) g.aAh().azQ().get(ar.a.USERINFO_MUSIO_LAST_SCAN_MUSIC_FILE_TIME_LONG, (Object) 0L)).longValue();
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - longValue < duR.longValue()) {
            Log.e("MicroMsg.PieceCacheCleanController", "don't scanMusic because the time is in one day");
            AppMethodBeat.o(63039);
            return;
        }
        g.aAh().azQ().set(ar.a.USERINFO_MUSIO_LAST_SCAN_MUSIC_FILE_TIME_LONG, Long.valueOf(currentTimeMillis));
        ThreadPool.post(new Runnable() {
            /* class com.tencent.mm.plugin.music.model.a.a.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(63037);
                a.euG();
                AppMethodBeat.o(63037);
            }
        }, "ScanMusicThread", 1);
        AppMethodBeat.o(63039);
    }

    static /* synthetic */ void euG() {
        AppMethodBeat.i(63040);
        Log.i("MicroMsg.PieceCacheCleanController", "scanMusicFile");
        long currentTimeMillis = System.currentTimeMillis();
        com.tencent.mm.plugin.music.model.e.b euD = o.euD();
        String format = String.format("SELECT * from %s WHERE updateTime < ? AND musicType <> ? limit 10", "Music");
        ArrayList<com.tencent.mm.plugin.music.model.e.a> arrayList = new ArrayList();
        Cursor rawQuery = euD.db.rawQuery(format, new String[]{String.valueOf(System.currentTimeMillis() - 604800000), "6"});
        while (rawQuery.moveToNext()) {
            com.tencent.mm.plugin.music.model.e.a aVar = new com.tencent.mm.plugin.music.model.e.a();
            aVar.convertFrom(rawQuery);
            arrayList.add(aVar);
        }
        rawQuery.close();
        for (com.tencent.mm.plugin.music.model.e.a aVar2 : arrayList) {
            String bT = com.tencent.mm.plugin.music.h.b.bT(aVar2.field_musicId, true);
            String bT2 = com.tencent.mm.plugin.music.h.b.bT(aVar2.field_musicId, false);
            String bV = com.tencent.mm.plugin.music.h.b.bV(aVar2.field_musicId, false);
            String bV2 = com.tencent.mm.plugin.music.h.b.bV(aVar2.field_musicId, true);
            s.deleteFile(bT);
            s.deleteFile(bT2);
            s.deleteFile(bV);
            s.deleteFile(bV2);
            com.tencent.mm.plugin.music.model.e.b euD2 = o.euD();
            String str = aVar2.field_musicId;
            euD2.AlG.remove(str);
            euD2.AlH.remove(str);
            com.tencent.mm.plugin.music.model.e.b euD3 = o.euD();
            String str2 = aVar2.field_musicId;
            Log.i("MicroMsg.PieceCacheCleanController", "delete music %d %s", Integer.valueOf(euD3.db.delete("Music", "musicId=?", new String[]{str2})), aVar2.field_musicId);
        }
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        Log.i("MicroMsg.PieceCacheCleanController", "scanMusic UseTime=%d", Long.valueOf(currentTimeMillis2));
        ArrayList<IDKey> arrayList2 = new ArrayList<>();
        IDKey iDKey = new IDKey();
        iDKey.SetID(q.CTRL_INDEX);
        iDKey.SetKey(254);
        iDKey.SetValue((long) ((int) currentTimeMillis2));
        IDKey iDKey2 = new IDKey();
        iDKey2.SetID(q.CTRL_INDEX);
        iDKey2.SetKey(255);
        iDKey2.SetValue(1);
        arrayList2.add(iDKey);
        arrayList2.add(iDKey2);
        h.INSTANCE.b(arrayList2, false);
        AppMethodBeat.o(63040);
    }
}
