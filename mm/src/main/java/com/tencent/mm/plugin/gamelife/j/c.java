package com.tencent.mm.plugin.gamelife.j;

import android.database.Cursor;
import com.facebook.appevents.UserDataStore;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.db;
import com.tencent.mm.plugin.gamelife.j.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.g.b.p;

public final class c extends MAutoStorage<a> {
    private static final String[] SQL_CREATE = {MAutoStorage.getCreateSQLs(a.info, "GameLifeSessionInfo")};
    public static final a ycx = new a((byte) 0);
    final ISQLiteDatabase db;
    private final ConcurrentHashMap<String, a> vFb = new ConcurrentHashMap<>();
    final ConcurrentHashMap<String, a> ycw = new ConcurrentHashMap<>();

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(ISQLiteDatabase iSQLiteDatabase) {
        super(iSQLiteDatabase, a.info, "GameLifeSessionInfo", db.INDEX_CREATE);
        p.h(iSQLiteDatabase, UserDataStore.DATE_OF_BIRTH);
        a.C1421a aVar = a.yct;
        AppMethodBeat.i(241428);
        this.db = iSQLiteDatabase;
        AppMethodBeat.o(241428);
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(241429);
        a.C1421a aVar = a.yct;
        AppMethodBeat.o(241429);
    }

    public final a aBc(String str) {
        AppMethodBeat.i(241425);
        String str2 = str;
        if (str2 == null || str2.length() == 0) {
            a aVar = new a();
            AppMethodBeat.o(241425);
            return aVar;
        }
        a aVar2 = this.vFb.get(str);
        if (aVar2 == null) {
            c cVar = this;
            Cursor rawQuery = cVar.db.rawQuery("select * , rowid from GameLifeSessionInfo where sessionId = '" + str + "' ", null);
            a aVar3 = new a();
            aVar3.field_sessionId = str;
            if (rawQuery != null) {
                if (rawQuery.moveToFirst()) {
                    aVar3.convertFrom(rawQuery);
                }
                rawQuery.close();
            }
            if (aVar3.systemRowid > 0) {
                cVar.vFb.put(str, aVar3);
                String str3 = aVar3.field_selfUserName;
                p.g(str3, "cache.field_selfUserName");
                String str4 = aVar3.field_talker;
                p.g(str4, "cache.field_talker");
                cVar.ycw.put(hS(str3, str4), aVar3);
            }
            aVar2 = aVar3;
        }
        AppMethodBeat.o(241425);
        return aVar2;
    }

    public final void a(String str, String str2, String str3, com.tencent.mm.plugin.gamelife.b.c cVar) {
        Long l = null;
        AppMethodBeat.i(241426);
        p.h(str, "sessionId");
        p.h(str2, "selfUsername");
        p.h(str3, "talker");
        a aVar = new a();
        aVar.field_sessionId = str;
        aVar.field_talker = str3;
        aVar.field_selfUserName = str2;
        aVar.field_extInfo = cVar;
        StringBuilder append = new StringBuilder("[replaceSessionInfo] sessionId=").append(str).append(", talker=").append(str3).append(", selfUsername=").append(aVar.field_selfUserName).append(' ').append("extInfo:");
        com.tencent.mm.plugin.gamelife.b.c cVar2 = aVar.field_extInfo;
        StringBuilder append2 = append.append(cVar2 != null ? Long.valueOf(cVar2.ybc) : null).append('/');
        com.tencent.mm.plugin.gamelife.b.c cVar3 = aVar.field_extInfo;
        if (cVar3 != null) {
            l = Long.valueOf(cVar3.ybb);
        }
        Log.i("GameLife.GameLifeSessionInfoStorage", append2.append(l).toString());
        this.vFb.put(str, aVar);
        this.ycw.put(hS(str2, str3), aVar);
        replace(aVar);
        AppMethodBeat.o(241426);
    }

    static String hS(String str, String str2) {
        AppMethodBeat.i(241427);
        String str3 = str + '_' + str2;
        AppMethodBeat.o(241427);
        return str3;
    }
}
