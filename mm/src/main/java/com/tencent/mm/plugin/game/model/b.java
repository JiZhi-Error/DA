package com.tencent.mm.plugin.game.model;

import android.content.Context;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.a.d;
import com.tencent.mm.plugin.r.a;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import java.util.ArrayList;
import java.util.LinkedList;

public final class b {
    LinkedList<String> xDS = new LinkedList<>();
    LinkedList<g> xDT = new LinkedList<>();

    public b() {
        AppMethodBeat.i(41351);
        AppMethodBeat.o(41351);
    }

    public final void init(Context context) {
        AppMethodBeat.i(41352);
        if (this.xDT == null) {
            this.xDT = new LinkedList<>();
        } else {
            this.xDT.clear();
        }
        if (this.xDS == null) {
            this.xDS = new LinkedList<>();
        } else {
            this.xDS.clear();
        }
        long currentTimeMillis = System.currentTimeMillis();
        fW(context);
        long currentTimeMillis2 = System.currentTimeMillis();
        dUO();
        long currentTimeMillis3 = System.currentTimeMillis();
        Log.i("MicroMsg.GameAppCacheService", "Init time: %d, %d, %d", Long.valueOf(currentTimeMillis2 - currentTimeMillis), Long.valueOf(currentTimeMillis3 - currentTimeMillis2), Long.valueOf(currentTimeMillis3 - currentTimeMillis));
        AppMethodBeat.o(41352);
    }

    private void fW(Context context) {
        AppMethodBeat.i(41353);
        Cursor gmX = a.eAS().gmX();
        if (gmX == null) {
            Log.e("MicroMsg.GameAppCacheService", "getInstalledGame faild: curosr is null");
            AppMethodBeat.o(41353);
            return;
        }
        if (gmX.moveToFirst()) {
            do {
                g gVar = new g();
                gVar.convertFrom(gmX);
                if (h.a(context, gVar) && !this.xDS.contains(gVar.field_appId)) {
                    Log.i("MicroMsg.GameAppCacheService", "installed game:[%s][%s]", gVar.field_appName, gVar.field_appId);
                    this.xDT.add(gVar);
                    this.xDS.add(gVar.field_appId);
                }
            } while (gmX.moveToNext());
        }
        gmX.close();
        AppMethodBeat.o(41353);
    }

    public final void clearCache() {
        AppMethodBeat.i(41355);
        Log.i("MicroMsg.GameAppCacheService", "clear cached apppinfos");
        if (this.xDT != null) {
            this.xDT.clear();
        }
        if (this.xDS != null) {
            this.xDS.clear();
        }
        AppMethodBeat.o(41355);
    }

    private void dUO() {
        ArrayList<String> arrayList;
        g o;
        AppMethodBeat.i(41354);
        ArrayList arrayList2 = new ArrayList();
        Cursor rawQuery = ((d) com.tencent.mm.kernel.g.af(d.class)).aSU().rawQuery("select * from FileDownloadInfo where status=3", new String[0]);
        if (rawQuery == null) {
            arrayList = arrayList2;
        } else {
            while (rawQuery.moveToNext()) {
                com.tencent.mm.plugin.downloader.g.a aVar = new com.tencent.mm.plugin.downloader.g.a();
                aVar.convertFrom(rawQuery);
                if (!Util.isNullOrNil(aVar.field_appId) && aVar.field_appId.startsWith("wx") && aVar.field_status == 3 && s.YS(aVar.field_filePath) && !arrayList2.contains(aVar.field_appId)) {
                    arrayList2.add(aVar.field_appId);
                }
            }
            rawQuery.close();
            arrayList = arrayList2;
        }
        if (!arrayList.isEmpty()) {
            for (String str : arrayList) {
                if (!Util.isNullOrNil(str) && !this.xDS.contains(str) && (o = h.o(str, false, false)) != null && !this.xDT.contains(o)) {
                    this.xDT.add(o);
                    this.xDS.add(str);
                }
            }
        }
        AppMethodBeat.o(41354);
    }
}
