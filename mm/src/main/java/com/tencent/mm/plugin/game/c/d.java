package com.tencent.mm.plugin.game.c;

import android.database.Cursor;
import com.facebook.appevents.UserDataStore;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.de;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.api.f;
import com.tencent.mm.plugin.game.b.a.c;
import com.tencent.mm.plugin.game.c.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore;
import java.util.LinkedList;
import kotlin.g.b.p;

public final class d extends MAutoStorage<a> {
    private static final String[] SQL_CREATE = {MAutoStorage.getCreateSQLs(a.info, "GameResourceDownload")};
    public static final a xvT = new a((byte) 0);
    private final ISQLiteDatabase db;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d(ISQLiteDatabase iSQLiteDatabase) {
        super(iSQLiteDatabase, a.info, "GameResourceDownload", de.INDEX_CREATE);
        p.h(iSQLiteDatabase, UserDataStore.DATE_OF_BIRTH);
        a.C1393a aVar = a.xvK;
        AppMethodBeat.i(204357);
        this.db = iSQLiteDatabase;
        AppMethodBeat.o(204357);
    }

    static {
        AppMethodBeat.i(204358);
        a.C1393a aVar = a.xvK;
        AppMethodBeat.o(204358);
    }

    public final a azw(String str) {
        a aVar;
        AppMethodBeat.i(204353);
        p.h(str, AssistantStore.DownloadInfos.DownloadInfoColumns.PACKAGENAME);
        if (str.length() == 0) {
            AppMethodBeat.o(204353);
            return null;
        }
        String str2 = "select * from GameResourceDownload where packageName=\"" + str + '\"';
        Log.i("MicroMsg.GameResourceDownloadStorage", "getDownloadStage, sql : %s", str2);
        Cursor rawQuery = rawQuery(str2, new String[0]);
        if (rawQuery == null) {
            AppMethodBeat.o(204353);
            return null;
        }
        if (rawQuery.moveToNext()) {
            aVar = new a();
            aVar.convertFrom(rawQuery);
        } else {
            aVar = null;
        }
        rawQuery.close();
        AppMethodBeat.o(204353);
        return aVar;
    }

    public static void a(String str, String str2, int i2, int i3, com.tencent.mm.plugin.game.b.a.d dVar) {
        AppMethodBeat.i(204354);
        p.h(str, AssistantStore.DownloadInfos.DownloadInfoColumns.PACKAGENAME);
        p.h(str2, "appId");
        p.h(dVar, "gameResDownloadList");
        a aVar = new a();
        aVar.field_packageName = str;
        aVar.field_appId = str2;
        aVar.field_intervalSeconds = i2;
        aVar.field_expiredSeconds = i3;
        aVar.field_createTime = Util.nowSecond();
        aVar.field_checkCgiTime = Util.nowSecond();
        aVar.field_finishDownloadTime = Util.nowSecond();
        aVar.field_downloadItemList = dVar.toByteArray();
        com.tencent.mm.kernel.c.a af = g.af(f.class);
        p.g(af, "MMKernel.service(IGameStorage::class.java)");
        Log.i("MicroMsg.GameResourceDownloadStorage", "insert db ret:" + ((f) af).dSP().insert(aVar) + ", packageName:" + str + ", interval:" + i2 + ", expiredTime:" + i3);
        b bVar = b.xvL;
        b.dTh();
        AppMethodBeat.o(204354);
    }

    public final int azx(String str) {
        AppMethodBeat.i(204355);
        p.h(str, AssistantStore.DownloadInfos.DownloadInfoColumns.PACKAGENAME);
        a azw = azw(str);
        if (azw == null) {
            AppMethodBeat.o(204355);
            return 0;
        }
        com.tencent.mm.plugin.game.b.a.d dVar = new com.tencent.mm.plugin.game.b.a.d();
        try {
            dVar.parseFrom(azw.field_downloadItemList);
            LinkedList<c> linkedList = dVar.xum;
            if (linkedList != null) {
                for (T t : linkedList) {
                    if (t.xug == 0) {
                        AppMethodBeat.o(204355);
                        return 1;
                    }
                    com.tencent.mm.plugin.downloader.g.a Cw = com.tencent.mm.plugin.downloader.model.d.Cw(t.xug);
                    if (Cw != null) {
                        Log.i("MicroMsg.GameResourceDownloadStorage", "downloadUrl:" + Cw.field_downloadUrl + ", status:" + Cw.field_status);
                        switch (Cw.field_status) {
                            default:
                                AppMethodBeat.o(204355);
                                return 1;
                            case 3:
                            case 4:
                            case 5:
                                break;
                        }
                    }
                }
            }
            AppMethodBeat.o(204355);
            return 2;
        } catch (Exception e2) {
            Log.i("MicroMsg.GameResourceDownloadStorage", "catch err:" + e2.getMessage());
            AppMethodBeat.o(204355);
            return 0;
        }
    }

    public final void azy(String str) {
        AppMethodBeat.i(204356);
        p.h(str, AssistantStore.DownloadInfos.DownloadInfoColumns.PACKAGENAME);
        Log.i("MicroMsg.GameResourceDownloadStorage", "updateDownloadTaskFinishedTime, packageName:".concat(String.valueOf(str)));
        a azw = azw(str);
        if (azw != null) {
            azw.field_finishDownloadTime = Util.nowSecond();
            update(azw, new String[0]);
            AppMethodBeat.o(204356);
            return;
        }
        AppMethodBeat.o(204356);
    }
}
