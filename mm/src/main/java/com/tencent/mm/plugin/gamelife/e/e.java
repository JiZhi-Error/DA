package com.tencent.mm.plugin.gamelife.e;

import android.database.Cursor;
import com.facebook.appevents.UserDataStore;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.da;
import com.tencent.mm.plugin.gamelife.b;
import com.tencent.mm.plugin.gamelife.e.a;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.sdk.storage.MStorageEventData;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.x;

public final class e extends MAutoStorage<a> {
    private static final String[] SQL_CREATE = {MAutoStorage.getCreateSQLs(a.info, "GameLifeConversation")};
    public static final a ycb = new a((byte) 0);
    private final ISQLiteDatabase db;

    @Override // com.tencent.mm.sdk.storage.MAutoStorage, com.tencent.mm.sdk.storage.IAutoStorage
    public final /* synthetic */ boolean replace(a aVar) {
        AppMethodBeat.i(241370);
        a aVar2 = aVar;
        Log.i("GameLife.ConversationStorage", "[replace] " + (aVar2 != null ? f.a(aVar2) : null));
        boolean replace = super.replace(aVar2);
        AppMethodBeat.o(241370);
        return replace;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public e(ISQLiteDatabase iSQLiteDatabase) {
        super(iSQLiteDatabase, a.info, "GameLifeConversation", da.INDEX_CREATE);
        p.h(iSQLiteDatabase, UserDataStore.DATE_OF_BIRTH);
        a.C1417a aVar = a.ybW;
        AppMethodBeat.i(241372);
        this.db = iSQLiteDatabase;
        AppMethodBeat.o(241372);
    }

    static {
        AppMethodBeat.i(241373);
        a.C1417a aVar = a.ybW;
        AppMethodBeat.o(241373);
    }

    public final a aBa(String str) {
        AppMethodBeat.i(241363);
        p.h(str, "sessionId");
        Cursor rawQuery = this.db.rawQuery("select *, rowid from GameLifeConversation where sessionId = '" + str + "' ", null);
        a aVar = new a();
        aVar.field_sessionId = str;
        if (rawQuery != null) {
            if (rawQuery.moveToFirst()) {
                aVar.convertFrom(rawQuery);
            }
            rawQuery.close();
        }
        AppMethodBeat.o(241363);
        return aVar;
    }

    public final List<a> dP(int i2, int i3) {
        AppMethodBeat.i(241364);
        List<a> gM = gM(i2, i3);
        Log.i("GameLife.ConversationStorage", "[query] offset=" + i2 + " pageCount=" + i3 + " list size=" + gM.size());
        AppMethodBeat.o(241364);
        return gM;
    }

    public final boolean avs(String str) {
        AppMethodBeat.i(241365);
        p.h(str, "sessionId");
        b.a aVar = b.xZZ;
        if (!b.a.aAQ(str)) {
            AppMethodBeat.o(241365);
            return false;
        }
        a aBa = aBa(str);
        int i2 = aBa.field_unReadCount;
        aBa.field_unReadCount = 0;
        aBa.field_digestFlag = 0;
        aBa.field_digestPrefix = null;
        boolean update = update(aBa.systemRowid, aBa, false);
        doNotify(MStorageEventData.EventType.SINGLE, 4, aBa);
        Log.i("GameLife.ConversationStorage", "[clearUnreadCount] ret=" + update + ' ' + i2 + " => " + aBa.field_unReadCount + " sessionId=" + str);
        AppMethodBeat.o(241365);
        return update;
    }

    public final int avf(String str) {
        Throwable th;
        int i2;
        Throwable th2 = null;
        AppMethodBeat.i(241366);
        p.h(str, "sessionId");
        b.a aVar = b.xZZ;
        if (!b.a.aAQ(str)) {
            AppMethodBeat.o(241366);
            return 0;
        }
        Cursor rawQuery = this.db.rawQuery("SELECT sessionId from GameLifeConversation WHERE sessionId='" + str + '\'', null);
        try {
            Cursor cursor = rawQuery;
            if (cursor.moveToFirst()) {
                p.g(cursor, "cursor");
                if (!cursor.isAfterLast()) {
                    i2 = cursor.getInt(0);
                    x xVar = x.SXb;
                    kotlin.f.b.a(rawQuery, null);
                    Log.i("GameLife.ConversationStorage", "[getUnreadCount] " + str + ' ' + i2);
                    AppMethodBeat.o(241366);
                    return i2;
                }
            }
            i2 = 0;
            x xVar2 = x.SXb;
            kotlin.f.b.a(rawQuery, null);
            Log.i("GameLife.ConversationStorage", "[getUnreadCount] " + str + ' ' + i2);
            AppMethodBeat.o(241366);
            return i2;
        } catch (Throwable th3) {
            th = th3;
            th2 = th;
            kotlin.f.b.a(rawQuery, th2);
            AppMethodBeat.o(241366);
            throw th;
        }
    }

    public final int dWZ() {
        Throwable th;
        int i2;
        Throwable th2 = null;
        AppMethodBeat.i(241367);
        Cursor rawQuery = this.db.rawQuery("SELECT SUM(unReadCount) FROM GameLifeConversation WHERE sessionId<>'@gamelifehistory'", null);
        try {
            Cursor cursor = rawQuery;
            if (cursor.moveToFirst()) {
                p.g(cursor, LocaleUtil.ITALIAN);
                if (!cursor.isAfterLast()) {
                    i2 = cursor.getInt(0);
                    x xVar = x.SXb;
                    kotlin.f.b.a(rawQuery, null);
                    Log.i("GameLife.ConversationStorage", "[getTotalUnreadCount] ".concat(String.valueOf(i2)));
                    AppMethodBeat.o(241367);
                    return i2;
                }
            }
            i2 = 0;
            x xVar2 = x.SXb;
            kotlin.f.b.a(rawQuery, null);
            Log.i("GameLife.ConversationStorage", "[getTotalUnreadCount] ".concat(String.valueOf(i2)));
            AppMethodBeat.o(241367);
            return i2;
        } catch (Throwable th3) {
            th = th3;
            th2 = th;
            kotlin.f.b.a(rawQuery, th2);
            AppMethodBeat.o(241367);
            throw th;
        }
    }

    private final List<a> gM(int i2, int i3) {
        Throwable th;
        Throwable th2 = null;
        AppMethodBeat.i(241368);
        LinkedList linkedList = new LinkedList();
        Cursor rawQuery = this.db.rawQuery("select *, rowid from GameLifeConversation ORDER BY updateTime DESC limit " + i3 + " offset " + i2, null);
        try {
            Cursor cursor = rawQuery;
            if (cursor.moveToFirst()) {
                while (true) {
                    p.g(cursor, "cursor");
                    if (cursor.isAfterLast()) {
                        break;
                    }
                    a aVar = new a();
                    aVar.convertFrom(cursor);
                    linkedList.add(aVar);
                    cursor.moveToNext();
                }
            }
            x xVar = x.SXb;
            kotlin.f.b.a(rawQuery, null);
            LinkedList linkedList2 = linkedList;
            AppMethodBeat.o(241368);
            return linkedList2;
        } catch (Throwable th3) {
            th = th3;
            th2 = th;
            kotlin.f.b.a(rawQuery, th2);
            AppMethodBeat.o(241368);
            throw th;
        }
    }

    public final a dXk() {
        Throwable th;
        Throwable th2 = null;
        AppMethodBeat.i(241369);
        Cursor rawQuery = this.db.rawQuery("SELECT *, rowid FROM GameLifeConversation WHERE unReadCount>0 ORDER BY updateTime DESC LIMIT 1", null);
        try {
            Cursor cursor = rawQuery;
            if (cursor.moveToFirst()) {
                p.g(cursor, LocaleUtil.ITALIAN);
                if (!cursor.isAfterLast()) {
                    a aVar = new a();
                    aVar.convertFrom(cursor);
                    kotlin.f.b.a(rawQuery, null);
                    AppMethodBeat.o(241369);
                    return aVar;
                }
            }
            x xVar = x.SXb;
            kotlin.f.b.a(rawQuery, null);
            AppMethodBeat.o(241369);
            return null;
        } catch (Throwable th3) {
            th = th3;
            th2 = th;
            kotlin.f.b.a(rawQuery, th2);
            AppMethodBeat.o(241369);
            throw th;
        }
    }

    public final a dXl() {
        Throwable th;
        Throwable th2 = null;
        AppMethodBeat.i(241371);
        a aVar = new a();
        Cursor rawQuery = this.db.rawQuery("SELECT *, rowid FROM GameLifeConversation WHERE sessionId='@gamelifehistory'", null);
        try {
            Cursor cursor = rawQuery;
            if (cursor.moveToFirst()) {
                aVar.convertFrom(cursor);
                kotlin.f.b.a(rawQuery, null);
                AppMethodBeat.o(241371);
                return aVar;
            }
            x xVar = x.SXb;
            kotlin.f.b.a(rawQuery, null);
            AppMethodBeat.o(241371);
            return aVar;
        } catch (Throwable th3) {
            th = th3;
            th2 = th;
            kotlin.f.b.a(rawQuery, th2);
            AppMethodBeat.o(241371);
            throw th;
        }
    }
}
