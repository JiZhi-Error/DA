package com.tencent.mm.plugin.finder.storage;

import android.database.Cursor;
import com.facebook.appevents.UserDataStore;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.cj;
import com.tencent.mm.plugin.finder.storage.s;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.p;

public final class t extends MAutoStorage<s> {
    private static final String[] SQL_CREATE = {MAutoStorage.getCreateSQLs(s.info, "FinderLiveGiftInfo")};
    public static final a vEj = new a((byte) 0);
    public final ISQLiteDatabase db;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public t(ISQLiteDatabase iSQLiteDatabase) {
        super(iSQLiteDatabase, s.info, "FinderLiveGiftInfo", cj.INDEX_CREATE);
        p.h(iSQLiteDatabase, UserDataStore.DATE_OF_BIRTH);
        s.a aVar = s.vEi;
        AppMethodBeat.i(251802);
        this.db = iSQLiteDatabase;
        AppMethodBeat.o(251802);
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(251803);
        s.a aVar = s.vEi;
        AppMethodBeat.o(251803);
    }

    public final int b(s sVar) {
        AppMethodBeat.i(251800);
        p.h(sVar, "giftInfo");
        int replace = (int) this.db.replace("FinderLiveGiftInfo", "rewardProductId", sVar.convertTo());
        Log.i("Finder.FinderLiveGiftStorage", "insert gift " + sVar + ' ' + replace);
        AppMethodBeat.o(251800);
        return replace;
    }

    public final List<s> dxR() {
        AppMethodBeat.i(251801);
        ArrayList arrayList = new ArrayList();
        Cursor rawQuery = this.db.rawQuery("SELECT *, rowid FROM FinderLiveGiftInfo order by FinderLiveGiftInfo.giftIndex asc", null, 2);
        while (rawQuery.moveToNext()) {
            s sVar = new s();
            sVar.convertFrom(rawQuery);
            arrayList.add(sVar);
        }
        rawQuery.close();
        ArrayList arrayList2 = arrayList;
        AppMethodBeat.o(251801);
        return arrayList2;
    }
}
