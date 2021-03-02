package com.tencent.mm.plugin.story.i;

import android.database.Cursor;
import com.facebook.appevents.UserDataStore;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.em;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.plugin.story.i.h;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.sdk.storage.MStorage;
import com.tencent.mm.sdk.storage.MStorageEventData;
import kotlin.g.b.p;

public final class i extends MAutoStorage<h> implements MStorage.IOnStorageChange {
    private static final String Fwl = ("select * from " + TABLE + ' ');
    public static final a Fwo = new a((byte) 0);
    private static final String[] SQL_CREATE = {MAutoStorage.getCreateSQLs(h.info, TABLE)};
    public static final String TABLE = TABLE;
    private static final String TAG = TAG;
    public final ISQLiteDatabase db;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public i(ISQLiteDatabase iSQLiteDatabase) {
        super(iSQLiteDatabase, h.info, TABLE, em.INDEX_CREATE);
        p.h(iSQLiteDatabase, UserDataStore.DATE_OF_BIRTH);
        h.a aVar = h.Fwn;
        AppMethodBeat.i(119528);
        this.db = iSQLiteDatabase;
        AppMethodBeat.o(119528);
    }

    @Override // com.tencent.mm.sdk.storage.MStorage.IOnStorageChange
    public final void onNotifyChange(String str, MStorageEventData mStorageEventData) {
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(119529);
        h.a aVar = h.Fwn;
        AppMethodBeat.o(119529);
    }

    public final boolean a(h hVar) {
        AppMethodBeat.i(119524);
        p.h(hVar, "storyHistoryInfo");
        if (aSx(hVar.frD())) {
            boolean update = update(hVar, FFmpegMetadataRetriever.METADATA_KEY_DATE);
            AppMethodBeat.o(119524);
            return update;
        }
        boolean b2 = b(hVar);
        AppMethodBeat.o(119524);
        return b2;
    }

    private boolean aSx(String str) {
        AppMethodBeat.i(119525);
        p.h(str, FFmpegMetadataRetriever.METADATA_KEY_DATE);
        Cursor rawQuery = this.db.rawQuery(Fwl + " WHERE " + TABLE + ".date = '" + str + '\'', null);
        p.g(rawQuery, "cu");
        int count = rawQuery.getCount();
        rawQuery.close();
        if (count > 0) {
            AppMethodBeat.o(119525);
            return true;
        }
        AppMethodBeat.o(119525);
        return false;
    }

    public final h aSy(String str) {
        AppMethodBeat.i(119526);
        p.h(str, FFmpegMetadataRetriever.METADATA_KEY_DATE);
        Cursor rawQuery = this.db.rawQuery(Fwl + " WHERE " + TABLE + ".date = '" + str + '\'', null);
        if (rawQuery.moveToFirst()) {
            h hVar = new h();
            hVar.convertFrom(rawQuery);
            rawQuery.close();
            AppMethodBeat.o(119526);
            return hVar;
        }
        rawQuery.close();
        AppMethodBeat.o(119526);
        return null;
    }

    private boolean b(h hVar) {
        AppMethodBeat.i(119527);
        p.h(hVar, "info");
        boolean replace = super.replace(hVar);
        AppMethodBeat.o(119527);
        return replace;
    }
}
