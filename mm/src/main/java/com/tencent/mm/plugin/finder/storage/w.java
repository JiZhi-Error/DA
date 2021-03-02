package com.tencent.mm.plugin.finder.storage;

import android.content.ContentValues;
import android.database.Cursor;
import com.facebook.appevents.UserDataStore;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.cl;
import com.tencent.mm.plugin.finder.model.at;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import kotlin.g.b.p;

public final class w extends MAutoStorage<at> {
    private static final String[] SQL_CREATE = {MAutoStorage.getCreateSQLs(at.info, "FinderMediaCacheInfoV2")};
    public static final a vEm = new a((byte) 0);
    public final ISQLiteDatabase db;

    @Override // com.tencent.mm.sdk.storage.MAutoStorage, com.tencent.mm.sdk.storage.IAutoStorage
    public final /* synthetic */ boolean insert(at atVar) {
        AppMethodBeat.i(167021);
        boolean b2 = b(atVar);
        AppMethodBeat.o(167021);
        return b2;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public w(ISQLiteDatabase iSQLiteDatabase) {
        super(iSQLiteDatabase, at.info, "FinderMediaCacheInfoV2", cl.INDEX_CREATE);
        p.h(iSQLiteDatabase, UserDataStore.DATE_OF_BIRTH);
        at.a aVar = at.uON;
        AppMethodBeat.i(167025);
        this.db = iSQLiteDatabase;
        AppMethodBeat.o(167025);
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(167026);
        at.a aVar = at.uON;
        AppMethodBeat.o(167026);
    }

    public final boolean b(at atVar) {
        AppMethodBeat.i(167020);
        p.h(atVar, "item");
        boolean insert = super.insert(atVar);
        AppMethodBeat.o(167020);
        return insert;
    }

    public final boolean c(at atVar) {
        boolean z = true;
        AppMethodBeat.i(167022);
        p.h(atVar, "item");
        ContentValues convertTo = atVar.convertTo();
        convertTo.remove("rowid");
        if (this.db.update(getTableName(), convertTo, "mediaId = ?", new String[]{Util.nullAsNil(convertTo.getAsString("mediaId"))}) <= 0) {
            z = false;
        }
        if (z) {
            doNotify();
        } else {
            Log.e("Finder.FinderMediaCacheStorage", "[update] failure. " + atVar.field_mediaId);
        }
        AppMethodBeat.o(167022);
        return z;
    }

    public final at avt(String str) {
        AppMethodBeat.i(167023);
        p.h(str, "mediaId");
        Cursor rawQuery = this.db.rawQuery("select *, rowid from FinderMediaCacheInfoV2  where mediaId = '" + str + "' ", null);
        at atVar = new at();
        atVar.field_mediaId = str;
        if (rawQuery != null) {
            if (rawQuery.moveToFirst()) {
                atVar.convertFrom(rawQuery);
            }
            rawQuery.close();
        }
        AppMethodBeat.o(167023);
        return atVar;
    }
}
