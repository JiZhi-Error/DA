package com.tencent.mm.plugin.finder.storage;

import android.content.ContentValues;
import android.database.Cursor;
import com.facebook.appevents.UserDataStore;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.cf;
import com.tencent.mm.plugin.finder.conv.c;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.util.LinkedList;
import java.util.List;
import kotlin.f.b;
import kotlin.g.b.p;
import kotlin.n.n;
import kotlin.x;

public final class e extends MAutoStorage<c> {
    private static final String[] SQL_CREATE = {MAutoStorage.getCreateSQLs(c.info, "FinderConversation")};
    public static final a vDk = new a((byte) 0);
    private final ISQLiteDatabase db;

    @Override // com.tencent.mm.sdk.storage.MAutoStorage
    public final /* synthetic */ boolean replace(c cVar, boolean z) {
        AppMethodBeat.i(251703);
        boolean a2 = a(cVar, z);
        AppMethodBeat.o(251703);
        return a2;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public e(ISQLiteDatabase iSQLiteDatabase) {
        super(iSQLiteDatabase, c.info, "FinderConversation", cf.INDEX_CREATE);
        p.h(iSQLiteDatabase, UserDataStore.DATE_OF_BIRTH);
        c.a aVar = c.tys;
        AppMethodBeat.i(251709);
        this.db = iSQLiteDatabase;
        this.db.execSQL("FinderConversation", "CREATE INDEX IF NOT EXISTS FinderConversation_type_scene_index ON FinderConversation(scene,type)");
        AppMethodBeat.o(251709);
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(251710);
        c.a aVar = c.tys;
        AppMethodBeat.o(251710);
    }

    public final List<c> a(int i2, int i3, int[] iArr, int i4) {
        AppMethodBeat.i(251698);
        List<c> b2 = b(i2, i3, iArr, i4);
        Log.i("Finder.ConversationStorage", "[query] offset=" + i2 + " pageCount=" + i3 + " type=" + iArr + " list size=" + b2.size() + ", scene=" + i4);
        AppMethodBeat.o(251698);
        return b2;
    }

    public final c avq(String str) {
        AppMethodBeat.i(251699);
        p.h(str, "sessionId");
        Cursor rawQuery = this.db.rawQuery("select *, rowid from FinderConversation where sessionId = '" + str + "' ", null);
        c cVar = new c();
        cVar.field_sessionId = str;
        if (rawQuery != null) {
            if (rawQuery.moveToFirst()) {
                cVar.convertFrom(rawQuery);
            }
            rawQuery.close();
        }
        AppMethodBeat.o(251699);
        return cVar;
    }

    private boolean avr(String str) {
        Throwable th;
        Throwable th2 = null;
        AppMethodBeat.i(251700);
        p.h(str, "sessionId");
        Cursor rawQuery = this.db.rawQuery("select *, rowid from FinderConversation where sessionId = '" + str + "' ", null);
        try {
            Cursor cursor = rawQuery;
            p.g(cursor, LocaleUtil.ITALIAN);
            boolean z = cursor.getCount() > 0;
            b.a(rawQuery, null);
            AppMethodBeat.o(251700);
            return z;
        } catch (Throwable th3) {
            th = th3;
            th2 = th;
            b.a(rawQuery, th2);
            AppMethodBeat.o(251700);
            throw th;
        }
    }

    private final List<c> b(int i2, int i3, int[] iArr, int i4) {
        String str;
        Throwable th;
        String str2;
        Throwable th2 = null;
        AppMethodBeat.i(251701);
        LinkedList linkedList = new LinkedList();
        int KX = KX(i4);
        if (iArr != null) {
            String str3 = "(";
            int length = iArr.length;
            int i5 = 0;
            int i6 = 0;
            while (i5 < length) {
                int i7 = iArr[i5];
                int i8 = i6 + 1;
                if (KX > 0 || i7 != 100) {
                    str2 = str3 + "type=" + i7;
                    if (i6 + 1 < iArr.length) {
                        str2 = str2 + " or ";
                    }
                } else {
                    str2 = str3;
                }
                i5++;
                i6 = i8;
                str3 = str2;
            }
            str = "select *, rowid from FinderConversation WHERE scene=" + i4 + " and " + (n.c(str3, (CharSequence) " or ") + ")") + " ORDER BY placedFlag DESC, updateTime DESC limit " + i3 + " offset " + i2;
        } else {
            str = "select *, rowid from FinderConversation WHERE scene=" + i4 + " ORDER BY placedFlag DESC, updateTime DESC limit " + i3 + " offset " + i2;
        }
        Cursor rawQuery = this.db.rawQuery(str, null);
        try {
            Cursor cursor = rawQuery;
            if (cursor.moveToFirst()) {
                while (true) {
                    p.g(cursor, "cursor");
                    if (cursor.isAfterLast()) {
                        break;
                    }
                    c cVar = new c();
                    cVar.convertFrom(cursor);
                    cVar.prepare();
                    linkedList.add(cVar);
                    cursor.moveToNext();
                }
            }
            x xVar = x.SXb;
            b.a(rawQuery, null);
            LinkedList linkedList2 = linkedList;
            AppMethodBeat.o(251701);
            return linkedList2;
        } catch (Throwable th3) {
            th = th3;
            th2 = th;
            b.a(rawQuery, th2);
            AppMethodBeat.o(251701);
            throw th;
        }
    }

    public final boolean a(c cVar, boolean z) {
        boolean insertNotify;
        AppMethodBeat.i(251702);
        Log.i("Finder.ConversationStorage", "[replace] " + (cVar != null ? f.b(cVar) : null));
        if (cVar == null) {
            AppMethodBeat.o(251702);
            return false;
        }
        ContentValues convertTo = cVar.convertTo();
        String str = cVar.field_sessionId;
        p.g(str, "item.field_sessionId");
        if (avr(str)) {
            insertNotify = this.db.update(getTableName(), convertTo, "sessionId = ?", new String[]{new StringBuilder().append(cVar.field_sessionId).toString()}) > 0;
        } else {
            insertNotify = super.insertNotify(cVar, false);
        }
        if (insertNotify && z) {
            doNotify(cVar.field_sessionId);
        }
        AppMethodBeat.o(251702);
        return insertNotify;
    }

    public final int KX(int i2) {
        Throwable th;
        int i3;
        Throwable th2 = null;
        AppMethodBeat.i(251704);
        Cursor rawQuery = this.db.rawQuery("select count(*) from FinderConversation WHERE scene=" + i2 + " and type=1", null);
        try {
            Cursor cursor = rawQuery;
            if (cursor.moveToFirst()) {
                i3 = cursor.getInt(0);
            } else {
                i3 = 0;
            }
            x xVar = x.SXb;
            b.a(rawQuery, null);
            AppMethodBeat.o(251704);
            return i3;
        } catch (Throwable th3) {
            th = th3;
            th2 = th;
            b.a(rawQuery, th2);
            AppMethodBeat.o(251704);
            throw th;
        }
    }

    public final int gk(int i2, int i3) {
        String concat;
        Throwable th;
        Throwable th2;
        int i4 = 0;
        Throwable th3 = null;
        AppMethodBeat.i(251705);
        if (i3 >= 0) {
            concat = "select sum(unReadCount) from FinderConversation WHERE type=" + i3 + " and scene=" + i2;
        } else {
            concat = "select sum(unReadCount) from FinderConversation WHERE scene=".concat(String.valueOf(i2));
        }
        Cursor rawQuery = this.db.rawQuery(concat, null);
        try {
            Cursor cursor = rawQuery;
            if (cursor.moveToFirst()) {
                p.g(cursor, "cursor");
                if (!cursor.isAfterLast()) {
                    i4 = cursor.getInt(0);
                }
            }
            x xVar = x.SXb;
            b.a(rawQuery, null);
            Cursor rawQuery2 = this.db.rawQuery("select * from FinderConversation WHERE type=" + i3 + " and scene=" + i2, null);
            try {
                Cursor cursor2 = rawQuery2;
                if (cursor2.moveToFirst()) {
                    p.g(cursor2, "cursor");
                    if (!cursor2.isAfterLast()) {
                        new c().convertFrom(cursor2);
                    }
                }
                x xVar2 = x.SXb;
                b.a(rawQuery2, null);
                Log.i("Finder.ConversationStorage", "[getUnreadCount] type=" + i3 + " count=" + i4);
                AppMethodBeat.o(251705);
                return i4;
            } catch (Throwable th4) {
                th2 = th4;
                th3 = th;
                b.a(rawQuery2, th3);
                AppMethodBeat.o(251705);
                throw th2;
            }
        } catch (Throwable th5) {
            th = th5;
            th3 = th;
            b.a(rawQuery, th3);
            AppMethodBeat.o(251705);
            throw th;
        }
    }

    public final int avf(String str) {
        Throwable th;
        int i2;
        Throwable th2 = null;
        AppMethodBeat.i(251706);
        p.h(str, "sessionId");
        Cursor rawQuery = this.db.rawQuery("select unReadCount, sum(unReadCount) from FinderConversation WHERE sessionId=".concat(String.valueOf(str)), null);
        try {
            Cursor cursor = rawQuery;
            if (cursor.moveToFirst()) {
                p.g(cursor, "cursor");
                if (!cursor.isAfterLast()) {
                    i2 = cursor.getInt(1);
                    x xVar = x.SXb;
                    b.a(rawQuery, null);
                    Log.i("Finder.ConversationStorage", "[getUnreadCount] sessionId=" + str + ' ' + i2);
                    AppMethodBeat.o(251706);
                    return i2;
                }
            }
            i2 = 0;
            x xVar2 = x.SXb;
            b.a(rawQuery, null);
            Log.i("Finder.ConversationStorage", "[getUnreadCount] sessionId=" + str + ' ' + i2);
            AppMethodBeat.o(251706);
            return i2;
        } catch (Throwable th3) {
            th = th3;
            th2 = th;
            b.a(rawQuery, th2);
            AppMethodBeat.o(251706);
            throw th;
        }
    }

    public final boolean avs(String str) {
        AppMethodBeat.i(251707);
        p.h(str, "sessionId");
        if (str.length() == 0) {
            AppMethodBeat.o(251707);
            return false;
        }
        c avq = avq(str);
        int i2 = avq.field_unReadCount;
        avq.field_unReadCount = 0;
        avq.field_readStatus = 1;
        boolean update = update(avq.systemRowid, avq);
        doNotify(avq.field_sessionId, 5, avq);
        Log.i("Finder.ConversationStorage", "[clearUnreadCount] ret=" + update + ' ' + i2 + " => " + avq.field_unReadCount + " sessionId=" + str);
        AppMethodBeat.o(251707);
        return update;
    }

    public final boolean bt(String str, boolean z) {
        AppMethodBeat.i(251708);
        p.h(str, "sessionId");
        c avq = avq(str);
        boolean cZv = avq.cZv();
        avq.field_placedFlag = z ? 1 : 0;
        boolean update = update(avq.systemRowid, avq, false);
        if (z) {
            doNotify(avq.field_sessionId, 3, avq);
        } else {
            doNotify(avq.field_sessionId, 4, avq);
        }
        Log.i("Finder.ConversationStorage", "[setTopPlace] ret=" + update + " isTopPlace=" + cZv + " => " + avq.cZv() + " sessionId=" + str);
        AppMethodBeat.o(251708);
        return update;
    }
}
