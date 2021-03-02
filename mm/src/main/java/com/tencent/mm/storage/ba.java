package com.tencent.mm.storage;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.co.a;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.f;
import com.tencent.mm.plugin.messenger.foundation.a.g;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MAlarmHandler;
import com.tencent.mm.sdk.platformtools.MMStack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.sdk.storage.MStorageEvent;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.storage.bw;
import com.tencent.mm.storagebase.h;
import com.tencent.mm.vending.b.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import junit.framework.Assert;

public final class ba extends MStorageEx implements bw {
    public static final String[] SQL_CREATE = {MAutoStorage.getCreateSQLs(com.tencent.mm.o.a.info, "rconversation"), MAutoStorage.getCreateSQLs(com.tencent.mm.o.a.info, "rbottleconversation"), "CREATE TABLE IF NOT EXISTS conversation ( unReadCount INTEGER, status INT, isSend INT, createTime LONG, username VARCHAR(40), content TEXT, reserved TEXT );", "CREATE TABLE IF NOT EXISTS bottleconversation ( unReadCount INTEGER, status INT, isSend INT, createTime LONG, username VARCHAR(40), content TEXT, reserved TEXT );", "CREATE INDEX IF NOT EXISTS rconversation_unreadcount_index ON rconversation ( unReadCount )", "DROP INDEX IF EXISTS multi_index ", "DROP INDEX IF EXISTS rconversation_multi_index", "CREATE INDEX IF NOT EXISTS rconversation_parentref_index ON  rconversation ( parentRef )", "CREATE INDEX IF NOT EXISTS rbottleconversation_unreadcount_index ON  rbottleconversation ( unReadCount )"};
    private bw.b OoN;
    private f OoO;
    private a OoP = new a((byte) 0);
    private MStorageEvent<bw.a, az> OoQ = new MStorageEvent<bw.a, az>() {
        /* class com.tencent.mm.storage.ba.AnonymousClass1 */

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // com.tencent.mm.sdk.storage.MStorageEvent
        public final /* synthetic */ void processEvent(bw.a aVar, az azVar) {
            AppMethodBeat.i(117061);
            aVar.a(azVar, ba.this);
            AppMethodBeat.o(117061);
        }
    };
    private MStorageEvent<bw.a, az> OoR = new MStorageEvent<bw.a, az>() {
        /* class com.tencent.mm.storage.ba.AnonymousClass2 */

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // com.tencent.mm.sdk.storage.MStorageEvent
        public final /* synthetic */ void processEvent(bw.a aVar, az azVar) {
            AppMethodBeat.i(117062);
            aVar.a(azVar, ba.this);
            AppMethodBeat.o(117062);
        }
    };
    private final ISQLiteDatabase db;

    static {
        AppMethodBeat.i(117133);
        AppMethodBeat.o(117133);
    }

    public ba(ISQLiteDatabase iSQLiteDatabase) {
        boolean z;
        AppMethodBeat.i(117067);
        Assert.assertTrue(iSQLiteDatabase instanceof h);
        Cursor rawQuery = iSQLiteDatabase.rawQuery("PRAGMA table_info( rconversation)", null, 2);
        int columnIndex = rawQuery.getColumnIndex("name");
        while (true) {
            if (!rawQuery.moveToNext()) {
                z = false;
                break;
            }
            if (columnIndex >= 0 && "flag".equalsIgnoreCase(rawQuery.getString(columnIndex))) {
                z = true;
                break;
            }
        }
        rawQuery.close();
        List<String> updateSQLs = MAutoStorage.getUpdateSQLs(com.tencent.mm.o.a.info, "rconversation", iSQLiteDatabase);
        updateSQLs.addAll(MAutoStorage.getUpdateSQLs(com.tencent.mm.o.a.info, "rbottleconversation", iSQLiteDatabase));
        for (String str : updateSQLs) {
            iSQLiteDatabase.execSQL("rconversation", str);
        }
        if (!z) {
            iSQLiteDatabase.execSQL("rconversation", "update rconversation set flag = conversationTime");
        }
        this.db = iSQLiteDatabase;
        AppMethodBeat.o(117067);
    }

    private static String OH(String str) {
        AppMethodBeat.i(117068);
        Log.v("MicroMsg.ConversationStorage", "talker :".concat(String.valueOf(str)));
        if (as.IG(str)) {
            AppMethodBeat.o(117068);
            return "rbottleconversation";
        }
        AppMethodBeat.o(117068);
        return "rconversation";
    }

    @Override // com.tencent.mm.storage.bw
    public final void a(bw.b bVar) {
        this.OoN = bVar;
    }

    @Override // com.tencent.mm.storage.bw
    public final bw.b Xh() {
        return this.OoN;
    }

    @Override // com.tencent.mm.storage.bw
    public final void a(f fVar) {
        this.OoO = fVar;
    }

    static class a extends com.tencent.mm.co.a<g> implements g {
        private a() {
        }

        /* synthetic */ a(byte b2) {
            this();
        }

        @Override // com.tencent.mm.plugin.messenger.foundation.a.g
        public final void a(final ca caVar, final i.c cVar, final boolean[] zArr) {
            AppMethodBeat.i(187499);
            a(new a.AbstractC0297a<g>() {
                /* class com.tencent.mm.storage.ba.a.AnonymousClass1 */

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // com.tencent.mm.co.a.AbstractC0297a
                public final /* synthetic */ void bw(g gVar) {
                    AppMethodBeat.i(117063);
                    gVar.a(caVar, cVar, zArr);
                    AppMethodBeat.o(117063);
                }
            });
            AppMethodBeat.o(187499);
        }

        @Override // com.tencent.mm.plugin.messenger.foundation.a.g
        public final void a(final ca caVar, final az azVar, final boolean z, final i.c cVar) {
            AppMethodBeat.i(117065);
            a(new a.AbstractC0297a<g>() {
                /* class com.tencent.mm.storage.ba.a.AnonymousClass2 */

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // com.tencent.mm.co.a.AbstractC0297a
                public final /* synthetic */ void bw(g gVar) {
                    AppMethodBeat.i(117064);
                    gVar.a(caVar, azVar, z, cVar);
                    AppMethodBeat.o(117064);
                }
            });
            AppMethodBeat.o(117065);
        }

        @Override // com.tencent.mm.plugin.messenger.foundation.a.g
        public final void b(final ca caVar, final az azVar, final boolean z, final i.c cVar) {
            AppMethodBeat.i(117066);
            a(new a.AbstractC0297a<g>() {
                /* class com.tencent.mm.storage.ba.a.AnonymousClass3 */

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // com.tencent.mm.co.a.AbstractC0297a
                public final /* synthetic */ void bw(g gVar) {
                    AppMethodBeat.i(187498);
                    gVar.b(caVar, azVar, z, cVar);
                    AppMethodBeat.o(187498);
                }
            });
            AppMethodBeat.o(117066);
        }
    }

    @Override // com.tencent.mm.storage.bw
    public final b a(g gVar) {
        AppMethodBeat.i(117069);
        b add = this.OoP.add(gVar);
        AppMethodBeat.o(117069);
        return add;
    }

    @Override // com.tencent.mm.storage.bw
    public final void b(g gVar) {
        AppMethodBeat.i(187500);
        this.OoP.remove(gVar);
        AppMethodBeat.o(187500);
    }

    @Override // com.tencent.mm.storage.bw
    public final void a(bw.a aVar) {
        AppMethodBeat.i(117070);
        this.OoR.add(aVar, (Looper) null);
        AppMethodBeat.o(117070);
    }

    @Override // com.tencent.mm.storage.bw
    public final void b(bw.a aVar) {
        AppMethodBeat.i(117071);
        this.OoR.remove(aVar);
        AppMethodBeat.o(117071);
    }

    @Override // com.tencent.mm.storage.bw
    public final void c(bw.a aVar) {
        AppMethodBeat.i(117072);
        this.OoQ.add(aVar, (Looper) null);
        AppMethodBeat.o(117072);
    }

    @Override // com.tencent.mm.storage.bw
    public final void d(bw.a aVar) {
        AppMethodBeat.i(117073);
        this.OoQ.remove(aVar);
        AppMethodBeat.o(117073);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:78:0x02ac, code lost:
        if (r4 != false) goto L_0x02ae;
     */
    @Override // com.tencent.mm.storage.bw
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b(com.tencent.mm.plugin.messenger.foundation.a.a.i r17, com.tencent.mm.plugin.messenger.foundation.a.a.i.c r18) {
        /*
        // Method dump skipped, instructions count: 1457
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.storage.ba.b(com.tencent.mm.plugin.messenger.foundation.a.a.i, com.tencent.mm.plugin.messenger.foundation.a.a.i$c):void");
    }

    private static long d(az azVar) {
        AppMethodBeat.i(117075);
        if (azVar != null) {
            long a2 = com.tencent.mm.plugin.messenger.foundation.a.a.a.a(azVar, azVar.field_conversationTime);
            AppMethodBeat.o(117075);
            return a2;
        }
        long nowMilliSecond = Util.nowMilliSecond() & 72057594037927935L;
        AppMethodBeat.o(117075);
        return nowMilliSecond;
    }

    @Override // com.tencent.mm.storage.bw
    public final void bjW(String str) {
        AppMethodBeat.i(117076);
        Log.w("MicroMsg.ConversationStorage", "delChatContact username:%s  stack:%s", str, MMStack.getStack(true));
        if (this.db.delete(OH(str), "username=?", new String[]{str}) != 0) {
            doNotify(5, this, str);
        }
        AppMethodBeat.o(117076);
    }

    @Override // com.tencent.mm.storage.bw
    public final boolean gCs() {
        AppMethodBeat.i(117077);
        boolean z = this.db.execSQL("rconversation", "delete from rconversation") || this.db.execSQL("rconversation", "delete from rbottleconversation");
        if (z) {
            doNotify(5, this, "");
        }
        AppMethodBeat.o(117077);
        return z;
    }

    @Override // com.tencent.mm.storage.bw
    public final boolean bjX(String str) {
        AppMethodBeat.i(117078);
        Log.w("MicroMsg.ConversationStorage", "deleteMessageEndByName nameTag:%s  stack:%s", str, MMStack.getStack(true));
        boolean execSQL = this.db.execSQL("rconversation", "delete from " + OH(str) + " where username like '%" + str + "'");
        if (execSQL) {
            doNotify(5, this, str);
        }
        AppMethodBeat.o(117078);
        return execSQL;
    }

    @Override // com.tencent.mm.storage.bw
    public final az bjY(String str) {
        AppMethodBeat.i(117079);
        Cursor query = this.db.query(OH(str), null, "username=?", new String[]{str}, null, null, null, 2);
        if (!query.moveToFirst()) {
            Log.w("MicroMsg.ConversationStorage", "get null with username:".concat(String.valueOf(str)));
            query.close();
            AppMethodBeat.o(117079);
            return null;
        }
        az azVar = new az();
        azVar.convertFrom(query);
        query.close();
        AppMethodBeat.o(117079);
        return azVar;
    }

    @Override // com.tencent.mm.storage.bw
    public final boolean Tf(String str) {
        AppMethodBeat.i(187501);
        if (bjY(str) != null) {
            AppMethodBeat.o(187501);
            return true;
        }
        AppMethodBeat.o(187501);
        return false;
    }

    @Override // com.tencent.mm.storage.bw
    public final HashMap<String, Long> gCt() {
        boolean z;
        AppMethodBeat.i(117081);
        long currentTimeMillis = System.currentTimeMillis();
        HashMap<String, Long> hashMap = new HashMap<>();
        Cursor query = this.db.query("rconversation", new String[]{ch.COL_USERNAME, "conversationTime"}, null, null, null, null, null, 2);
        if (!query.moveToFirst()) {
            query.close();
            AppMethodBeat.o(117081);
            return hashMap;
        }
        while (true) {
            if (query == null) {
                z = false;
            } else if (query.isClosed() || query.isBeforeFirst() || query.isAfterLast()) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                hashMap.put(query.getString(0), Long.valueOf(query.getLong(1)));
                query.moveToNext();
            } else {
                query.close();
                Log.d("MicroMsg.ConversationStorage", "kevin getALLTimeIndex:" + (System.currentTimeMillis() - currentTimeMillis));
                AppMethodBeat.o(117081);
                return hashMap;
            }
        }
    }

    @Override // com.tencent.mm.storage.bw
    public final void gCu() {
        AppMethodBeat.i(117084);
        ContentValues contentValues = new ContentValues();
        contentValues.put("msgCount", (Integer) 0);
        this.db.update("rconversation", contentValues, null, null);
        AppMethodBeat.o(117084);
    }

    @Override // com.tencent.mm.storage.bw
    public final void bjZ(String str) {
        AppMethodBeat.i(117085);
        ContentValues contentValues = new ContentValues();
        contentValues.put("msgCount", (Integer) 0);
        this.db.update("rconversation", contentValues, "username=?", new String[]{str});
        AppMethodBeat.o(117085);
    }

    @Override // com.tencent.mm.storage.bw
    public final boolean bkb(String str) {
        AppMethodBeat.i(117087);
        if (str.length() <= 0) {
            Log.e("MicroMsg.ConversationStorage", "update updateUnreadByParentRef failed");
            AppMethodBeat.o(117087);
            return false;
        }
        Log.d("MicroMsg.ConversationStorage", "updateUnreadByParentRef %s", str);
        az bjY = bjY(str);
        if (bjY == null) {
            AppMethodBeat.o(117087);
            return true;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("unReadCount", (Integer) 0);
        contentValues.put("unReadMuteCount", (Integer) 0);
        contentValues.put("UnReadInvite", (Integer) 0);
        contentValues.put("atCount", (Integer) 0);
        contentValues.put("attrflag", Integer.valueOf(bjY.field_attrflag & -1048577));
        int update = this.db.update(OH(str), contentValues, "parentRef= ?", new String[]{Util.escapeSqlValue(str)});
        if (update > 0) {
            doNotify(3, this, str);
        }
        if (update > 0) {
            AppMethodBeat.o(117087);
            return true;
        }
        AppMethodBeat.o(117087);
        return false;
    }

    @Override // com.tencent.mm.storage.bw
    public final boolean bkc(String str) {
        AppMethodBeat.i(117088);
        if (str == null || str.length() <= 0) {
            Log.e("MicroMsg.ConversationStorage", "update conversation failed");
            AppMethodBeat.o(117088);
            return false;
        }
        az bjY = bjY(str);
        if (bjY == null || (bjY.field_unReadCount > 0 && str.equals(bjY.field_username))) {
            AppMethodBeat.o(117088);
            return true;
        }
        boolean execSQL = this.db.execSQL("rconversation", "update " + OH(str) + " set unReadCount = 1, atCount = 0, attrflag = " + (bjY.field_attrflag | 1048576) + " where username = \"" + Util.escapeSqlValue(str) + "\"");
        if (execSQL) {
            doNotify(3, this, str);
        }
        AppMethodBeat.o(117088);
        return execSQL;
    }

    @Override // com.tencent.mm.storage.bw
    public final boolean a(String str, int i2, boolean z, int i3) {
        int i4;
        AppMethodBeat.i(117089);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(117089);
            return false;
        } else if (bjY(str) == null) {
            AppMethodBeat.o(117089);
            return true;
        } else {
            if (z) {
                i4 = i3 | i2;
            } else {
                i4 = (i2 ^ -1) & i3;
            }
            if (i4 == i3) {
                AppMethodBeat.o(117089);
                return false;
            }
            if (i3 >= 0 && i3 < 536870912 && ((i4 >= 536870912 || i4 < 0) && str.contains("@"))) {
                Log.i("Conversition", "wrong add attr flag: %s, %s, %s, %s, %s", str, Integer.valueOf(i3), Integer.valueOf(i2), Boolean.valueOf(z), Util.getStack());
                e.INSTANCE.a(20435, 3, Integer.valueOf(i3), Integer.valueOf(i2), str);
            }
            boolean execSQL = this.db.execSQL("rconversation", "update " + OH(str) + " set attrflag = " + i4 + " where username = \"" + Util.escapeSqlValue(str) + "\"");
            if (execSQL) {
                doNotify(3, this, str);
            }
            AppMethodBeat.o(117089);
            return execSQL;
        }
    }

    @Override // com.tencent.mm.storage.bw
    public final int a(az azVar, String str) {
        AppMethodBeat.i(263547);
        int a2 = a(azVar, str, true);
        AppMethodBeat.o(263547);
        return a2;
    }

    @Override // com.tencent.mm.storage.bw
    public final int a(az azVar, String str, boolean z) {
        AppMethodBeat.i(117091);
        if (str == null || str.length() <= 0) {
            Log.e("MicroMsg.ConversationStorage", "update conversation failed");
            AppMethodBeat.o(117091);
            return 0;
        }
        if (z) {
            azVar.yB(d(azVar));
        }
        f(azVar);
        int update = this.db.update(OH(str), azVar.convertTo(), "username=?", new String[]{str});
        if (update != 0) {
            doNotify(3, this, str);
        } else {
            Log.e("MicroMsg.ConversationStorage", "update failed return 0,  table:%s", OH(str));
        }
        AppMethodBeat.o(117091);
        return update;
    }

    private static void f(az azVar) {
        AppMethodBeat.i(117092);
        if (azVar == null) {
            AppMethodBeat.o(117092);
            return;
        }
        if (azVar.field_unReadCount > 0) {
            Log.d("MicroMsg.ConversationStorage", "jacks check attrFlag & cancel mark");
            if ((azVar.field_attrflag & 1048576) != 0) {
                azVar.nt(azVar.field_unReadCount - 1);
                azVar.nx(azVar.field_attrflag & -1048577);
            }
        }
        AppMethodBeat.o(117092);
    }

    @Override // com.tencent.mm.storage.bw
    public final boolean bkd(String str) {
        AppMethodBeat.i(117094);
        if (str == null || str.length() <= 0) {
            Log.e("MicroMsg.ConversationStorage", "setMoveUp conversation failed");
            AppMethodBeat.o(117094);
            return false;
        }
        az bjY = bjY(str);
        if (bjY == null) {
            Log.e("MicroMsg.ConversationStorage", "setMoveUp conv == null");
            AppMethodBeat.o(117094);
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long j2 = 0;
        Cursor rawQuery = this.db.rawQuery("select max(conversationTime) as conversationTime from rconversation", null, 2);
        while (rawQuery.moveToNext()) {
            j2 = rawQuery.getLong(0);
        }
        rawQuery.close();
        Log.d("MicroMsg.ConversationStorage", "latestConversationTime = %s, cost = %d", Long.valueOf(j2), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        long aWy = cl.aWy();
        if (j2 > aWy) {
            Log.w("MicroMsg.ConversationStorage", "conversationTime=%s serverTime=%s diff=%s", Long.valueOf(j2), Long.valueOf(aWy), Long.valueOf(aWy - j2));
            j2 = aWy;
        }
        long a2 = com.tencent.mm.plugin.messenger.foundation.a.a.a.a(bjY, 1, j2 + 1);
        boolean execSQL = this.db.execSQL("rconversation", "update " + OH(bjY.field_username) + " set flag = " + a2 + " where username = \"" + Util.escapeSqlValue(bjY.field_username) + "\"");
        Log.i("MicroMsg.ConversationStorage", "[setMoveUp] flag=%s result=%s", Long.valueOf(a2), Boolean.valueOf(execSQL));
        if (execSQL) {
            doNotify(3, this, bjY.field_username);
        }
        AppMethodBeat.o(117094);
        return execSQL;
    }

    @Override // com.tencent.mm.storage.bw
    public final boolean bke(String str) {
        AppMethodBeat.i(117095);
        if (str == null || str.length() <= 0) {
            Log.e("MicroMsg.ConversationStorage", "setPlacedTop conversation failed");
            AppMethodBeat.o(117095);
            return false;
        }
        if (bjY(str) == null) {
            az azVar = new az(str);
            azVar.yA(System.currentTimeMillis());
            e(azVar);
            Log.i("MicroMsg.ConversationStorage", "setPlacedTop username = ".concat(String.valueOf(str)));
        }
        az bjY = bjY(str);
        if (bjY == null) {
            AppMethodBeat.o(117095);
            return false;
        }
        long a2 = com.tencent.mm.plugin.messenger.foundation.a.a.a.a(bjY, 2, 0);
        boolean execSQL = this.db.execSQL("rconversation", "update " + OH(bjY.field_username) + " set flag = " + a2 + " where username = \"" + Util.escapeSqlValue(bjY.field_username) + "\"");
        Log.i("MicroMsg.ConversationStorage", "[setPlacedTop] flag=%s result=%s", Long.valueOf(a2), Boolean.valueOf(execSQL));
        if (execSQL) {
            doNotify(3, this, bjY.field_username);
        }
        AppMethodBeat.o(117095);
        return execSQL;
    }

    @Override // com.tencent.mm.storage.bw
    public final boolean bkf(String str) {
        AppMethodBeat.i(117096);
        if (str == null || str.length() <= 0) {
            Log.e("MicroMsg.ConversationStorage", "unSetPlacedTop conversation failed");
            AppMethodBeat.o(117096);
            return false;
        }
        boolean g2 = g(bjY(str));
        AppMethodBeat.o(117096);
        return g2;
    }

    @Override // com.tencent.mm.storage.bw
    public final boolean g(az azVar) {
        AppMethodBeat.i(117097);
        if (azVar == null) {
            Log.e("MicroMsg.ConversationStorage", "unSetPlacedTop conversation null");
            AppMethodBeat.o(117097);
            return false;
        }
        long a2 = com.tencent.mm.plugin.messenger.foundation.a.a.a.a(azVar, 3, azVar.field_conversationTime);
        boolean execSQL = this.db.execSQL("rconversation", "update " + OH(azVar.field_username) + " set flag = " + a2 + " where username = \"" + Util.escapeSqlValue(azVar.field_username) + "\"");
        Log.i("MicroMsg.ConversationStorage", "[setPlacedTop] flag=%s result=%s", Long.valueOf(a2), Boolean.valueOf(execSQL));
        if (execSQL) {
            doNotify(3, this, azVar.field_username);
        }
        AppMethodBeat.o(117097);
        return execSQL;
    }

    @Override // com.tencent.mm.storage.bw
    public final boolean bkg(String str) {
        AppMethodBeat.i(117098);
        if (str == null || str.length() <= 0) {
            Log.e("MicroMsg.ConversationStorage", "isPlacedTop failed");
            AppMethodBeat.o(117098);
            return false;
        }
        boolean h2 = h(bjY(str));
        AppMethodBeat.o(117098);
        return h2;
    }

    @Override // com.tencent.mm.storage.bw
    public final boolean h(az azVar) {
        AppMethodBeat.i(117099);
        if (azVar == null) {
            Log.e("MicroMsg.ConversationStorage", "isPlacedTop failed, conversation null");
            AppMethodBeat.o(117099);
            return false;
        } else if (com.tencent.mm.plugin.messenger.foundation.a.a.a.a(azVar, 4, 0) != 0) {
            AppMethodBeat.o(117099);
            return true;
        } else {
            AppMethodBeat.o(117099);
            return false;
        }
    }

    @Override // com.tencent.mm.storage.bw
    public final Cursor c(String str, List<String> list, String str2) {
        AppMethodBeat.i(117100);
        StringBuilder sb = new StringBuilder();
        sb.append("select * from rconversation where ");
        if (com.tencent.mm.o.a.gNj == str2) {
            sb.append(" ( parentRef is null  or parentRef = '' ) ");
        } else if ("*".equals(str2)) {
            sb.append(" 1 = 1 ");
        } else {
            sb.append("parentRef = '").append(Util.escapeSqlValue(str2)).append("' ");
        }
        sb.append(Util.nullAsNil(str));
        if (list != null && list.size() > 0) {
            for (String str3 : list) {
                sb.append(" and rconversation.username != '").append(str3).append("'");
            }
        }
        sb.append(" order by flag desc, conversationTime desc");
        Cursor rawQuery = this.db.rawQuery(sb.toString(), null);
        AppMethodBeat.o(117100);
        return rawQuery;
    }

    @Override // com.tencent.mm.storage.bw
    public final List<String> gCv() {
        AppMethodBeat.i(117101);
        ArrayList arrayList = new ArrayList();
        StringBuilder sb = new StringBuilder();
        sb.append("select rconversation.username from rconversation,rcontact where ");
        sb.append("rconversation.username = rcontact.username");
        sb.append(Util.nullAsNil(Util.nullAsNil(ab.iCF)));
        sb.append(" and ( verifyFlag & 8 ) = 0");
        sb.append(" and ( rconversation.parentRef is null  or rconversation.parentRef = '' ) ");
        for (String str : ab.iCO) {
            sb.append(" and rconversation.username != '").append(str).append("'");
        }
        sb.append(" order by sightTime desc, flag desc, conversationTime desc");
        Cursor rawQuery = this.db.rawQuery(sb.toString(), null, 2);
        if (rawQuery != null) {
            if (rawQuery.moveToFirst()) {
                do {
                    arrayList.add(rawQuery.getString(0));
                } while (rawQuery.moveToNext());
            }
            rawQuery.close();
        }
        Log.d("MicroMsg.ConversationStorage", "user list:%s", arrayList);
        AppMethodBeat.o(117101);
        return arrayList;
    }

    @Override // com.tencent.mm.storage.bw
    public final Cursor a(String str, List<String> list, String str2, boolean z) {
        AppMethodBeat.i(117102);
        StringBuilder sb = new StringBuilder();
        sb.append("select unReadCount, status, isSend, conversationTime, username, content, msgType, flag, digest, digestUser, attrflag, editingMsg, atCount, unReadMuteCount, UnReadInvite, hasTodo, hbMarkRed");
        sb.append(" from rconversation where ");
        if (com.tencent.mm.o.a.gNj == str2) {
            sb.append(" ( parentRef is null  or parentRef = '' ) ");
        } else if ("*".equals(str2)) {
            sb.append(" 1 = 1 ");
        } else {
            sb.append("parentRef = '").append(Util.escapeSqlValue(str2)).append("' ");
        }
        sb.append(Util.nullAsNil(str));
        if (list != null && list.size() > 0) {
            for (String str3 : new ArrayList(list)) {
                sb.append(" and rconversation.username != '").append(str3).append("'");
            }
        }
        sb.append(" order by flag desc");
        Log.d("MicroMsg.ConversationStorage", "getNecessaryCursor sql " + sb.toString());
        Cursor rawQuery = this.db.rawQuery(sb.toString(), null, z ? 4 : 0);
        AppMethodBeat.o(117102);
        return rawQuery;
    }

    @Override // com.tencent.mm.storage.bw
    public final Cursor a(ArrayList<String> arrayList, String str, List<String> list, String str2) {
        AppMethodBeat.i(117103);
        StringBuilder sb = new StringBuilder();
        sb.append("select unReadCount, status, isSend, conversationTime, username, content, msgType,flag, digest, digestUser, attrflag, editingMsg, atCount, unReadMuteCount, UnReadInvite, editingQuoteMsgId, hasTodo, hbMarkRed");
        sb.append(" from rconversation where (");
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            if (i2 != arrayList.size() - 1) {
                sb.append("username = '" + arrayList.get(i2) + "' OR ");
            } else {
                sb.append("username = '" + arrayList.get(i2) + "'");
            }
        }
        sb.append(") and ");
        if (com.tencent.mm.o.a.gNj == str2) {
            sb.append(" ( parentRef is null  or parentRef = '' ) ");
        } else if ("*".equals(str2)) {
            sb.append(" 1 = 1 ");
        } else {
            sb.append("parentRef = '").append(Util.escapeSqlValue(str2)).append("' ");
        }
        sb.append(Util.nullAsNil(str));
        if (list != null && list.size() > 0) {
            for (String str3 : new ArrayList(list)) {
                sb.append(" and rconversation.username != '").append(str3).append("'");
            }
        }
        Log.d("MicroMsg.ConversationStorage", "getNecessaryCursorByNames sql %s", sb.toString());
        Cursor rawQuery = this.db.rawQuery(sb.toString(), null);
        AppMethodBeat.o(117103);
        return rawQuery;
    }

    private static String M(String str, List<String> list) {
        AppMethodBeat.i(117104);
        StringBuilder sb = new StringBuilder("");
        if (list != null && list.size() > 0) {
            sb.append(str).append(" not in (");
            int i2 = 0;
            while (i2 < list.size()) {
                sb.append("\"").append(Util.escapeSqlValue(list.get(i2))).append("\"").append(i2 == list.size() + -1 ? "" : ",");
                i2++;
            }
            sb.append(") ");
        }
        String sb2 = sb.toString();
        AppMethodBeat.o(117104);
        return sb2;
    }

    @Override // com.tencent.mm.storage.bw
    public final Cursor b(String str, List<String> list, String str2, boolean z, String str3) {
        String str4;
        AppMethodBeat.i(187503);
        String str5 = " ";
        if (str3 != null && str3.length() > 0) {
            str5 = " and rconversation.username = rcontact.username ";
        }
        String str6 = ("select unReadCount, status, isSend, conversationTime, rconversation.username, content, rconversation.msgType, rconversation.flag, rconversation.digest, rconversation.digestUser, rconversation.hasTrunc, rcontact.nickname from rconversation,rcontact" + " " + " where rconversation.username = rcontact.username" + str5 + Util.nullAsNil(str)) + M(" and rconversation.username", list);
        if (z) {
            str6 = str6 + " and ( verifyFlag & 8 ) = 0";
        }
        if (com.tencent.mm.o.a.gNj == str2) {
            str6 = str6 + " and ( parentRef is null or parentRef = '' ) ";
        }
        if (str3 != null && str3.length() > 0) {
            str6 = str6 + (" and ( rconversation.username like '%" + str3 + "%' or content like '%" + str3 + "%' or rcontact.nickname like '%" + str3 + "%' or rcontact.alias like '%" + str3 + "%' or rcontact.pyInitial like '%" + str3 + "%' or rcontact.quanPin like '%" + str3 + "%' or rcontact.conRemark like '%" + str3 + "%'  ) ");
        }
        if (str3 == null || str3.equals("")) {
            str4 = str6 + " order by flag desc, conversationTime desc";
        } else {
            str4 = str6 + " order by rconversation.username like \"%@chatroom\" asc";
        }
        Log.d("MicroMsg.ConversationStorage", "getSearchCursor sql ".concat(String.valueOf(str4)));
        Cursor rawQuery = this.db.rawQuery(str4, null);
        AppMethodBeat.o(187503);
        return rawQuery;
    }

    @Override // com.tencent.mm.storage.bw
    public final Cursor bkh(String str) {
        AppMethodBeat.i(117106);
        Cursor rawQuery = this.db.rawQuery("select unReadCount, status, isSend, conversationTime, rconversation.username, content, rconversation.msgType, nickname from rconversation,rcontact where rconversation.username = rcontact.username" + Util.nullAsNil(str) + " order by flag desc, conversationTime desc", null);
        AppMethodBeat.o(117106);
        return rawQuery;
    }

    @Override // com.tencent.mm.storage.bw
    public final void bI(LinkedList<String> linkedList) {
        AppMethodBeat.i(117107);
        Log.w("MicroMsg.ConversationStorage", "deleteConversations   stack:%s", MMStack.getStack(true));
        if (linkedList.isEmpty()) {
            Log.w("MicroMsg.ConversationStorage", "deleteConversation:namelist is null");
            AppMethodBeat.o(117107);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("delete from rconversation where ");
        sb.append("username='").append(linkedList.poll()).append('\'');
        while (!linkedList.isEmpty()) {
            sb.append(" or username='").append(linkedList.poll()).append('\'');
        }
        Log.i("MicroMsg.ConversationStorage", "deleteConversations:sql is %s", sb.toString());
        this.db.execSQL("rconversation", sb.toString());
        AppMethodBeat.o(117107);
    }

    @Override // com.tencent.mm.storage.bw
    public final List<String> gCw() {
        AppMethodBeat.i(117108);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        String str = ("select username from rconversation" + M(" where username", arrayList)) + " order by flag desc, conversationTime desc";
        Log.i("MicroMsg.ConversationStorage", "getAllConvUserName sql %s", str);
        Cursor rawQuery = this.db.rawQuery(str, null);
        int columnIndex = rawQuery.getColumnIndex(ch.COL_USERNAME);
        while (rawQuery.moveToNext()) {
            arrayList2.add(rawQuery.getString(columnIndex));
        }
        rawQuery.close();
        AppMethodBeat.o(117108);
        return arrayList2;
    }

    @Override // com.tencent.mm.storage.bw
    public final Cursor f(List<String> list, int i2, int i3) {
        AppMethodBeat.i(117109);
        if (list == null) {
            list = new ArrayList<>();
        }
        String str = "select username from rconversation";
        int i4 = 0;
        while (i4 < list.size()) {
            str = str + (i4 > 0 ? " and " : " where ") + "username != \"" + Util.escapeSqlValue(list.get(i4)) + "\"";
            i4++;
        }
        Cursor rawQuery = this.db.rawQuery(str + " order by flag desc, conversationTime desc limit " + i3 + " offset " + i2, null);
        AppMethodBeat.o(117109);
        return rawQuery;
    }

    @Override // com.tencent.mm.storage.bw
    public final Cursor gCx() {
        AppMethodBeat.i(117110);
        Cursor rawQuery = this.db.rawQuery("select * from rbottleconversation order by flag desc, conversationTime desc", null);
        AppMethodBeat.o(117110);
        return rawQuery;
    }

    @Override // com.tencent.mm.storage.bw
    public final boolean ayk(String str) {
        boolean z;
        AppMethodBeat.i(117111);
        Cursor query = this.db.query(OH(str), null, "username=?", new String[]{String.valueOf(str)}, null, null, null, 2);
        if (query.moveToFirst()) {
            z = true;
        } else {
            z = false;
        }
        query.close();
        AppMethodBeat.o(117111);
        return z;
    }

    @Override // com.tencent.mm.storage.bw
    public final Cursor mT(String str, String str2) {
        AppMethodBeat.i(117113);
        StringBuilder sb = new StringBuilder();
        sb.append("select unReadCount");
        sb.append(" from rconversation where username = '").append(str).append("' AND ( parentRef is ").append(com.tencent.mm.o.a.gNj).append(" or parentRef = '' ) ").append(Util.nullAsNil(str2));
        Cursor rawQuery = this.db.rawQuery(sb.toString(), null);
        AppMethodBeat.o(117113);
        return rawQuery;
    }

    @Override // com.tencent.mm.storage.bw
    public final Cursor bki(String str) {
        AppMethodBeat.i(187504);
        Log.i("MicroMsg.ConversationStorage", "getUnreadConversationCursor filter[%s] [%s]", str, Util.getStack());
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT rconversation.username, ");
        sb.append("rconversation.unReadCount, ");
        sb.append("rconversation.conversationTime");
        sb.append(" from rconversation where unReadCount > 0 AND (parentRef is ").append(com.tencent.mm.o.a.gNj).append(" or parentRef = '' ) ").append(Util.nullAsNil(str));
        String sb2 = sb.toString();
        Log.i("MicroMsg.ConversationStorage", "get unread conversation with black list, sql is %s", sb2);
        Cursor rawQuery = this.db.rawQuery(sb2, null);
        AppMethodBeat.o(187504);
        return rawQuery;
    }

    @Override // com.tencent.mm.storage.bw
    public final Cursor bkj(String str) {
        AppMethodBeat.i(187505);
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT rcontact.* FROM rcontact,rconversation");
        sb.append(" WHERE unReadCount > 0 AND (parentRef is ").append(com.tencent.mm.o.a.gNj).append(" or parentRef = '' ) ");
        sb.append(" AND rconversation.username = rcontact.username");
        sb.append(Util.nullAsNil(str));
        sb.append(" ORDER BY flag DESC, conversationTime DESC ");
        String sb2 = sb.toString();
        Log.i("MicroMsg.ConversationStorage", "get total unread contact with black list, sql is %s", sb2);
        Cursor rawQuery = this.db.rawQuery(sb2, null);
        AppMethodBeat.o(187505);
        return rawQuery;
    }

    @Override // com.tencent.mm.storage.bw
    public final int gCy() {
        int i2 = 0;
        AppMethodBeat.i(117117);
        String str = "SELECT SUM(rconversation.unReadCount)" + " FROM rconversation" + " WHERE parentRef = 'officialaccounts'";
        Log.d("MicroMsg.ConversationStorage", "getTotalUnreadBizCount sql %s", str);
        Cursor rawQuery = this.db.rawQuery(str, null, 2);
        if (rawQuery != null) {
            if (rawQuery.moveToFirst()) {
                i2 = rawQuery.getInt(0);
            }
            rawQuery.close();
        }
        AppMethodBeat.o(117117);
        return i2;
    }

    @Override // com.tencent.mm.storage.bw
    public final String gCz() {
        AppMethodBeat.i(117118);
        String str = "SELECT rconversation.username" + " FROM rconversation" + " WHERE parentRef = 'officialaccounts'" + " ORDER BY flag DESC, conversationTime DESC " + " LIMIT 1 ";
        Log.i("MicroMsg.ConversationStorage", "get last conversation user, sql is %s", str);
        Cursor rawQuery = this.db.rawQuery(str, null, 2);
        if (rawQuery != null) {
            if (rawQuery.moveToFirst()) {
                String string = rawQuery.getString(0);
                rawQuery.close();
                AppMethodBeat.o(117118);
                return string;
            }
            rawQuery.close();
        }
        AppMethodBeat.o(117118);
        return null;
    }

    @Override // com.tencent.mm.storage.bw
    public final int bkk(String str) {
        int i2 = 0;
        AppMethodBeat.i(117119);
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT COUNT(*) FROM rconversation");
        sb.append(" WHERE parentRef = '").append(str).append("'");
        String sb2 = sb.toString();
        Log.i("MicroMsg.ConversationStorage", "get enterprise conversation count, sql is %s", sb2);
        Cursor rawQuery = this.db.rawQuery(sb2, null, 2);
        if (rawQuery != null) {
            if (rawQuery.moveToFirst()) {
                i2 = rawQuery.getInt(0);
            }
            rawQuery.close();
        }
        AppMethodBeat.o(117119);
        return i2;
    }

    @Override // com.tencent.mm.storage.bw
    public final String bkl(String str) {
        AppMethodBeat.i(117120);
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT rconversation.username");
        sb.append(" FROM rconversation");
        sb.append(" WHERE parentRef = '").append(str).append("'");
        sb.append(" ORDER BY conversationTime DESC, conversationTime DESC ");
        sb.append(" LIMIT 1 ");
        String sb2 = sb.toString();
        Log.i("MicroMsg.ConversationStorage", "get last enterprise conversation user, sql is %s", sb2);
        Cursor rawQuery = this.db.rawQuery(sb2, null, 2);
        if (rawQuery != null) {
            if (rawQuery.moveToFirst()) {
                String string = rawQuery.getString(0);
                rawQuery.close();
                AppMethodBeat.o(117120);
                return string;
            }
            rawQuery.close();
        }
        AppMethodBeat.o(117120);
        return null;
    }

    @Override // com.tencent.mm.storage.bw
    public final Cursor gCA() {
        AppMethodBeat.i(117121);
        Log.i("MicroMsg.ConversationStorage", "get bottle total conversation unread sql is %s", "select count(*) from rbottleconversation where unReadCount > 0");
        Cursor rawQuery = this.db.rawQuery("select count(*) from rbottleconversation where unReadCount > 0", null);
        AppMethodBeat.o(117121);
        return rawQuery;
    }

    @Override // com.tencent.mm.storage.bw
    public final int JP(String str) {
        int i2 = 0;
        AppMethodBeat.i(117122);
        Cursor rawQuery = this.db.rawQuery("select sum(unReadCount) from rconversation,rcontact where rconversation.username = rcontact.username" + Util.nullAsNil(str), null, 2);
        if (rawQuery.moveToFirst()) {
            i2 = rawQuery.getInt(0);
        }
        rawQuery.close();
        AppMethodBeat.o(117122);
        return i2;
    }

    @Override // com.tencent.mm.storage.bw
    public final az gCB() {
        az azVar;
        AppMethodBeat.i(117123);
        Cursor c2 = ((l) com.tencent.mm.kernel.g.af(l.class)).aST().c(ab.iCF, null, "officialaccounts");
        if (c2 != null) {
            if (c2.getCount() <= 0 || !c2.moveToFirst()) {
                azVar = null;
            } else {
                azVar = new az();
                azVar.convertFrom(c2);
            }
            c2.close();
        } else {
            azVar = null;
        }
        AppMethodBeat.o(117123);
        return azVar;
    }

    @Override // com.tencent.mm.storage.bw
    public final az bkm(String str) {
        az azVar;
        AppMethodBeat.i(117124);
        Cursor c2 = ((l) com.tencent.mm.kernel.g.af(l.class)).aST().c(ab.iCF, null, str);
        if (c2 != null) {
            if (c2.getCount() <= 0 || !c2.moveToFirst()) {
                azVar = null;
            } else {
                azVar = new az();
                azVar.convertFrom(c2);
            }
            c2.close();
        } else {
            azVar = null;
        }
        AppMethodBeat.o(117124);
        return azVar;
    }

    @Override // com.tencent.mm.storage.bw
    public final void c(String[] strArr, String str) {
        AppMethodBeat.i(117125);
        StringBuilder sb = new StringBuilder();
        sb.append("Update rconversation");
        sb.append(" set parentRef = '").append(Util.nullAsNil(str)).append("' where 1 != 1 ");
        for (int i2 = 0; i2 <= 0; i2++) {
            sb.append(" or username = '").append(strArr[0]).append("'");
        }
        String sb2 = sb.toString();
        Log.d("MicroMsg.ConversationStorage", "update sql: %s", sb2);
        if (this.db.execSQL("rconversation", sb2)) {
            for (int i3 = 0; i3 <= 0; i3++) {
                doNotify(3, this, strArr[0]);
            }
        }
        AppMethodBeat.o(117125);
    }

    @Override // com.tencent.mm.storage.bw
    public final int bkn(String str) {
        int i2 = 0;
        AppMethodBeat.i(117126);
        StringBuilder sb = new StringBuilder();
        sb.append("select sum(atCount) from rconversation");
        sb.append(" where unReadCount > 0");
        if (!Util.isNullOrNil(str)) {
            sb.append(" and username = '").append(str).append("'");
        }
        sb.append(" and ( parentRef is null or parentRef = '' ) ");
        String sb2 = sb.toString();
        Log.d("MicroMsg.ConversationStorage", "query sql: %s", sb2);
        Cursor rawQuery = this.db.rawQuery(sb2, null, 2);
        if (rawQuery != null) {
            if (rawQuery.moveToFirst()) {
                i2 = rawQuery.getInt(0);
            }
            rawQuery.close();
        }
        AppMethodBeat.o(117126);
        return i2;
    }

    @Override // com.tencent.mm.storage.bw
    public final String dk(int i2, String str) {
        String str2 = null;
        AppMethodBeat.i(117127);
        if (!Util.isNullOrNil(str)) {
            switch (i2) {
                case 49:
                    Map<String, String> parseXml = XmlParser.parseXml(str, "msg", null);
                    if (parseXml != null) {
                        str2 = parseXml.get(".msg.appmsg.title");
                        Log.d("MicroMsg.ConversationStorage", "[oneliang][parseConversationMsgContentTitle] title:%s", str2);
                        break;
                    }
                    break;
            }
        }
        AppMethodBeat.o(117127);
        return str2;
    }

    @Override // com.tencent.mm.sdk.storage.MStorageEx
    public final boolean shouldProcessEvent() {
        AppMethodBeat.i(117128);
        if (this.db == null || this.db.isClose()) {
            Object[] objArr = new Object[1];
            objArr[0] = this.db == null ? BuildConfig.COMMAND : Boolean.valueOf(this.db.isClose());
            Log.w("MicroMsg.ConversationStorage", "shouldProcessEvent db is close :%s", objArr);
            AppMethodBeat.o(117128);
            return false;
        }
        AppMethodBeat.o(117128);
        return true;
    }

    @Override // com.tencent.mm.storage.bw
    public final void bko(String str) {
        AppMethodBeat.i(117129);
        StringBuilder sb = new StringBuilder();
        sb.append("Update rconversation");
        sb.append(" set parentRef = '', unReadCount = 0").append(" where username = \"" + Util.escapeSqlValue(str) + "\"");
        String sb2 = sb.toString();
        Log.d("MicroMsg.ConversationStorage", "removeParentRefAndUnread sql: %s", sb2);
        if (this.db.execSQL("rconversation", sb2)) {
            doNotify(3, this, str);
        }
        AppMethodBeat.o(117129);
    }

    @Override // com.tencent.mm.storage.bw
    public final void bkp(String str) {
        AppMethodBeat.i(117130);
        int delete = this.db.delete(OH(str), "username=? or parentRef =?", new String[]{str, str});
        Log.d("MicroMsg.ConversationStorage", "delEnterpriseFatherAndChildConv %s %d", str, Integer.valueOf(delete));
        if (delete != 0) {
            doNotify(5, this, str);
        }
        AppMethodBeat.o(117130);
    }

    @Override // com.tencent.mm.storage.bw
    public final int bkq(String str) {
        int i2 = -1;
        AppMethodBeat.i(117131);
        if (str == null || str.length() <= 0) {
            AppMethodBeat.o(117131);
        } else {
            Cursor rawQuery = this.db.rawQuery("select msgCount from rconversation where username=" + h.Fl(str), null, 2);
            if (rawQuery.moveToFirst()) {
                i2 = rawQuery.getInt(0);
            }
            rawQuery.close();
            AppMethodBeat.o(117131);
        }
        return i2;
    }

    @Override // com.tencent.mm.storage.bw
    public final Cursor gCC() {
        AppMethodBeat.i(117132);
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT rconversation.username, ");
        sb.append("rconversation.unReadCount");
        sb.append(" FROM rconversation");
        sb.append(" WHERE unReadCount > 0");
        sb.append(" AND ( parentRef is ").append(com.tencent.mm.o.a.gNj).append(" or parentRef = '' ) ");
        Cursor rawQuery = this.db.rawQuery(sb.toString(), null);
        AppMethodBeat.o(117132);
        return rawQuery;
    }

    @Override // com.tencent.mm.storage.bw
    public final void aY(ca caVar) {
        AppMethodBeat.i(117080);
        String str = caVar.field_talker;
        boolean z = false;
        az bjY = bjY(str);
        if (bjY == null || bjY.field_conversationTime <= caVar.field_createTime || bjY.field_conversationTime == MAlarmHandler.NEXT_FIRE_INTERVAL) {
            if (bjY == null) {
                bjY = new az(str);
                z = true;
            }
            bjY.nv(caVar.field_isSend);
            bjY.nt(bjY.field_unReadCount);
            bjY.aX(caVar);
            bjY.Cl(Integer.toString(caVar.getType()));
            bjY.yB((bjY.field_flag & 4611686018427387904L) | (caVar.field_createTime & 72057594037927935L));
            if (z) {
                e(bjY);
                AppMethodBeat.o(117080);
                return;
            }
            a(bjY, str, true);
            AppMethodBeat.o(117080);
            return;
        }
        Log.i("MicroMsg.ConversationStorage", "updateConvFromLastMsg ignore(maybe the system time is bigger than normal)");
        AppMethodBeat.o(117080);
    }

    @Override // com.tencent.mm.storage.bw
    public final long e(az azVar) {
        AppMethodBeat.i(117082);
        String nullAsNil = Util.nullAsNil(azVar.field_username);
        if (nullAsNil.length() <= 0) {
            Log.e("MicroMsg.ConversationStorage", "insert conversation failed, username empty");
            AppMethodBeat.o(117082);
            return -1;
        }
        azVar.yB(d(azVar));
        f(azVar);
        long insert = this.db.insert(OH(nullAsNil), null, azVar.convertTo());
        if (insert != -1) {
            doNotify(2, this, azVar.field_username);
        } else {
            Log.e("MicroMsg.ConversationStorage", "insert failed return -1, table:%s", OH(nullAsNil));
        }
        AppMethodBeat.o(117082);
        return insert;
    }

    @Override // com.tencent.mm.storage.bw
    public final void a(az azVar, int i2, int i3) {
        AppMethodBeat.i(117083);
        if (!bp.Kv(azVar.field_username)) {
            AppMethodBeat.o(117083);
        } else if (Util.nullAsNil(azVar.field_username).length() <= 0) {
            Log.e("MicroMsg.ConversationStorage", "countMsg conversation failed, username empty");
            AppMethodBeat.o(117083);
        } else {
            if (azVar.field_msgCount == 0) {
                azVar.ns(bp.Ku(azVar.field_username));
                Log.i("MicroMsg.ConversationStorage", "getMsgCount from message table");
            } else if (i2 > 0) {
                azVar.ns(azVar.field_msgCount - i2);
                if (azVar.field_msgCount < 0) {
                    Log.e("MicroMsg.ConversationStorage", "msg < 0 ,some path must be ignore!");
                    azVar.ns(0);
                }
            } else if (i3 > 0) {
                azVar.ns(azVar.field_msgCount + i3);
            }
            Log.i("MicroMsg.ConversationStorage", "countMsg %d talker :%s deleteCount:%d insertCount:%d", Integer.valueOf(azVar.field_msgCount), azVar.field_username, Integer.valueOf(i2), Integer.valueOf(i3));
            AppMethodBeat.o(117083);
        }
    }

    @Override // com.tencent.mm.storage.bw
    public final boolean bka(String str) {
        AppMethodBeat.i(117086);
        if (str == null || str.length() <= 0) {
            Log.e("MicroMsg.ConversationStorage", "update conversation failed");
        } else {
            Log.d("MicroMsg.ConversationStorage", "updateUnreadByTalker %s", str);
            az bjY = bjY(str);
            if (bjY == null) {
                AppMethodBeat.o(117086);
                return true;
            } else if (bjY.field_unReadCount == 0 && bjY.field_unReadMuteCount == 0 && str.equals(bjY.field_username)) {
                a(str, 1048576, false, bjY.field_attrflag);
                ContentValues contentValues = new ContentValues();
                contentValues.put("UnReadInvite", (Integer) 0);
                contentValues.put("atCount", (Integer) 0);
                if (this.db.update(OH(str), contentValues, "username= ?", new String[]{Util.escapeSqlValue(str)}) > 0) {
                    doNotify(3, this, str);
                }
                AppMethodBeat.o(117086);
                return true;
            } else {
                ContentValues contentValues2 = new ContentValues();
                contentValues2.put("unReadCount", (Integer) 0);
                contentValues2.put("unReadMuteCount", (Integer) 0);
                contentValues2.put("UnReadInvite", (Integer) 0);
                contentValues2.put("atCount", (Integer) 0);
                contentValues2.put("attrflag", Integer.valueOf(bjY.field_attrflag & -1048577));
                int update = this.db.update(OH(str), contentValues2, "username= ?", new String[]{Util.escapeSqlValue(str)});
                if (update > 0) {
                    doNotify(3, this, str);
                }
                if (update > 0) {
                    AppMethodBeat.o(117086);
                    return true;
                }
            }
        }
        AppMethodBeat.o(117086);
        return false;
    }
}
