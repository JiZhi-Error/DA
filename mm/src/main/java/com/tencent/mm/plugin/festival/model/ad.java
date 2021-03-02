package com.tencent.mm.plugin.festival.model;

import android.database.Cursor;
import com.facebook.appevents.UserDataStore;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.festival.b.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.ISQLiteDatabaseEx;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.storagebase.h;
import com.tencent.wcdb.database.SQLiteException;
import com.tencent.wcdb.database.SQLiteStatement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.f.b;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u0011\n\u0002\b\r\u0018\u0000 /2\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001:\u0001/B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0016\u0010\u000b\u001a\u00020\f2\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eJ\u0016\u0010\u0010\u001a\u00020\f2\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eJ\u0006\u0010\u0012\u001a\u00020\u0013J\u001c\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0016J\u0006\u0010\u0018\u001a\u00020\u0016J\u0010\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\bJ\b\u0010\u001c\u001a\u0004\u0018\u00010\u0002J\u0006\u0010\u001d\u001a\u00020\u0016J\u000e\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\bJ=\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00020\u000e2\b\u0010!\u001a\u0004\u0018\u00010\b2\u000e\u0010\"\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010#2\u000e\u0010$\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010#H\u0002¢\u0006\u0002\u0010%J&\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00020\u000e2\b\u0010\u001b\u001a\u0004\u0018\u00010\b2\u0006\u0010&\u001a\u00020\u001a2\u0006\u0010\u0015\u001a\u00020\u0016J\u0010\u0010'\u001a\u00020\f2\b\u0010(\u001a\u0004\u0018\u00010\u000fJ\u001a\u0010)\u001a\u00020\f2\b\u0010*\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010+\u001a\u00020\fJ\u0010\u0010,\u001a\u00020\f2\b\u0010\u001f\u001a\u0004\u0018\u00010\bJ\u0018\u0010-\u001a\u00020\f2\b\u0010\u001f\u001a\u0004\u0018\u00010\b2\u0006\u0010.\u001a\u00020\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R2\u0010\u0006\u001a&\u0012\f\u0012\n \t*\u0004\u0018\u00010\b0\b \t*\u0012\u0012\f\u0012\n \t*\u0004\u0018\u00010\b0\b\u0018\u00010\n0\u0007X\u0004¢\u0006\u0002\n\u0000¨\u00060"}, hxF = {"Lcom/tencent/mm/plugin/festival/model/FestivalWishStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/plugin/festival/model/LocalFestivalWishInfo;", UserDataStore.DATE_OF_BIRTH, "Lcom/tencent/mm/storagebase/SqliteDB;", "(Lcom/tencent/mm/storagebase/SqliteDB;)V", "unReadFriendWish", "", "", "kotlin.jvm.PlatformType", "", "bulkInsert", "", "pbList", "", "Lcom/tencent/mm/plugin/festival/proto/FestivalWish;", "bulkUpdate", "wishList", "delMyWish", "", "getFriendsWishList", "limit", "", "offset", "getFriendsWishListCount", "getMinCreateTime", "", ch.COL_USERNAME, "getMyWish", "getUnReadFriendWishCount", "getWishByWishId", "wishId", "getWishList", "selection", "selectionArgs", "", "columns", "(Ljava/lang/String;[Ljava/lang/String;[Ljava/lang/String;)Ljava/util/List;", "maxCreateTimeExclusive", "insertOrUpdate", "pb", "isFriendWish", "wish", BuildConfig.KINDA_DEFAULT, "markFriendWishRead", "updateDelFlag", "delFlag", "Companion", "plugin-festival_release"})
public final class ad extends MAutoStorage<ai> {
    private static final String[] INDEX_CREATE = {"CREATE  INDEX IF NOT EXISTS userName_createTime_index ON FestivalWish2 (userName , createTime)"};
    public static final String[] SQL_CREATE = {MAutoStorage.getCreateSQLs(ai.iBg, "FestivalWish2")};
    public static final a UzK = new a((byte) 0);
    public final Set<String> UzJ = Collections.newSetFromMap(new ConcurrentHashMap());
    final h iFy;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ad(h hVar) {
        super(hVar, ai.iBg, "FestivalWish2", INDEX_CREATE);
        p.h(hVar, UserDataStore.DATE_OF_BIRTH);
        AppMethodBeat.i(263144);
        this.iFy = hVar;
        AppMethodBeat.o(263144);
    }

    public static /* synthetic */ boolean a(ad adVar, c cVar) {
        AppMethodBeat.i(263137);
        boolean a2 = adVar.a(cVar);
        AppMethodBeat.o(263137);
        return a2;
    }

    private boolean a(c cVar) {
        Throwable th;
        Throwable th2;
        boolean z;
        boolean z2 = false;
        AppMethodBeat.i(263136);
        if (cVar != null) {
            String str = cVar.UAv;
            if (!(str == null || str.length() == 0)) {
                String str2 = cVar.UAz;
                if (!(str2 == null || str2.length() == 0)) {
                    synchronized (this) {
                        try {
                            Cursor rawQuery = this.iFy.rawQuery("select count(*) from FestivalWish2 where wishId =? or liveEncUsername =?", new String[]{cVar.UAv, cVar.UAz});
                            try {
                                Cursor cursor = rawQuery;
                                try {
                                    if (!cursor.moveToFirst() || cursor.getInt(0) <= 0) {
                                        z = false;
                                    } else {
                                        z = true;
                                    }
                                    z2 = z;
                                } catch (Exception e2) {
                                }
                                b.a(rawQuery, null);
                            } catch (Throwable th3) {
                                th = th3;
                                th2 = th;
                                b.a(rawQuery, th2);
                                AppMethodBeat.o(263136);
                                throw th;
                            }
                        } finally {
                            AppMethodBeat.o(263136);
                        }
                    }
                    return z2;
                }
            }
        }
        AppMethodBeat.o(263136);
        return z2;
    }

    public final ai hRS() {
        Throwable th;
        Throwable th2 = null;
        AppMethodBeat.i(263138);
        String aTY = z.aTY();
        synchronized (this) {
            try {
                Cursor rawQuery = this.iFy.rawQuery("select * from FestivalWish2 where userName = ? order by createTime desc limit 1 offset 0", new String[]{aTY});
                try {
                    Cursor cursor = rawQuery;
                    if (cursor.moveToFirst()) {
                        ai aiVar = new ai();
                        aiVar.convertFrom(cursor);
                        b.a(rawQuery, null);
                        return aiVar;
                    }
                    x xVar = x.SXb;
                    b.a(rawQuery, null);
                    x xVar2 = x.SXb;
                    AppMethodBeat.o(263138);
                    return null;
                } catch (Throwable th3) {
                    th = th3;
                    th2 = th;
                    b.a(rawQuery, th2);
                    AppMethodBeat.o(263138);
                    throw th;
                }
            } finally {
                AppMethodBeat.o(263138);
            }
        }
    }

    public final List<ai> u(String str, String[] strArr) {
        ArrayList arrayList;
        AppMethodBeat.i(263139);
        synchronized (this) {
            try {
                Log.i("MicroMsg.FestivalWishStorage", "db count " + getCount());
                Cursor query = this.iFy.query("FestivalWish2", null, str, strArr, null, null, null);
                if (query == null) {
                    Log.i("MicroMsg.FestivalWishStorage", "getMyWishList cursor null");
                    arrayList = new ArrayList();
                } else {
                    ArrayList arrayList2 = new ArrayList();
                    while (query.moveToNext()) {
                        try {
                            ai aiVar = new ai();
                            aiVar.convertFrom(query);
                            arrayList2.add(aiVar);
                        } catch (SQLiteException e2) {
                            Log.e("MicroMsg.FestivalWishStorage", "getMyWishList e:%s", e2);
                            arrayList = arrayList2;
                            query.close();
                            AppMethodBeat.o(263139);
                        } catch (Throwable th) {
                            query.close();
                            AppMethodBeat.o(263139);
                            throw th;
                        }
                    }
                    query.close();
                    arrayList = arrayList2;
                    AppMethodBeat.o(263139);
                }
            } finally {
                AppMethodBeat.o(263139);
            }
        }
        return arrayList;
    }

    public final boolean kV(List<? extends c> list) {
        AppMethodBeat.i(263140);
        List<? extends c> list2 = list;
        if (list2 == null || list2.isEmpty()) {
            AppMethodBeat.o(263140);
            return false;
        }
        synchronized (this) {
            try {
                ai aiVar = new ai();
                com.tencent.mm.plugin.festival.c.h hVar = com.tencent.mm.plugin.festival.c.h.UGH;
                h hVar2 = this.iFy;
                if (hVar2 instanceof ISQLiteDatabaseEx) {
                    Thread currentThread = Thread.currentThread();
                    p.g(currentThread, "Thread.currentThread()");
                    long beginTransaction = hVar2.beginTransaction(currentThread.getId());
                    try {
                        for (T t : list) {
                            String str = t.UAv;
                            if (!(str == null || str.length() == 0)) {
                                aiVar.field_wishId = t.UAv;
                                if (super.get(aiVar, new String[0])) {
                                    aiVar.c(t);
                                    super.update(aiVar, new String[0]);
                                }
                            }
                        }
                        x xVar = x.SXb;
                        hVar2.endTransaction(beginTransaction);
                    } catch (Throwable th) {
                        hVar2.endTransaction(beginTransaction);
                        AppMethodBeat.o(263140);
                        throw th;
                    }
                } else {
                    for (T t2 : list) {
                        String str2 = t2.UAv;
                        if (!(str2 == null || str2.length() == 0)) {
                            aiVar.field_wishId = t2.UAv;
                            if (super.get(aiVar, new String[0])) {
                                aiVar.c(t2);
                                super.update(aiVar, new String[0]);
                            }
                        }
                    }
                }
                x xVar2 = x.SXb;
            } catch (Throwable th2) {
                AppMethodBeat.o(263140);
                throw th2;
            }
        }
        doNotify();
        AppMethodBeat.o(263140);
        return true;
    }

    public final boolean kW(List<? extends c> list) {
        AppMethodBeat.i(263141);
        List<? extends c> list2 = list;
        if (list2 == null || list2.isEmpty()) {
            AppMethodBeat.o(263141);
            return false;
        }
        synchronized (this) {
            try {
                com.tencent.mm.plugin.festival.c.h hVar = com.tencent.mm.plugin.festival.c.h.UGH;
                h hVar2 = this.iFy;
                if (hVar2 instanceof ISQLiteDatabaseEx) {
                    Thread currentThread = Thread.currentThread();
                    p.g(currentThread, "Thread.currentThread()");
                    long beginTransaction = hVar2.beginTransaction(currentThread.getId());
                    try {
                        for (T t : list) {
                            if (b(t)) {
                                this.UzJ.add(t.UAv);
                            }
                        }
                        x xVar = x.SXb;
                        hVar2.endTransaction(beginTransaction);
                    } catch (Throwable th) {
                        hVar2.endTransaction(beginTransaction);
                        AppMethodBeat.o(263141);
                        throw th;
                    }
                } else {
                    for (T t2 : list) {
                        if (b(t2)) {
                            this.UzJ.add(t2.UAv);
                        }
                    }
                }
                x xVar2 = x.SXb;
            } catch (Throwable th2) {
                AppMethodBeat.o(263141);
                throw th2;
            }
        }
        doNotify();
        AppMethodBeat.o(263141);
        return true;
    }

    public final boolean b(c cVar) {
        String str;
        boolean insert;
        boolean z = false;
        AppMethodBeat.i(263142);
        synchronized (this) {
            if (cVar != null) {
                try {
                    str = cVar.UAv;
                } catch (Throwable th) {
                    AppMethodBeat.o(263142);
                    throw th;
                }
            } else {
                str = null;
            }
            String str2 = str;
            if (str2 == null || str2.length() == 0) {
                AppMethodBeat.o(263142);
                return false;
            }
            if (cVar == null) {
                p.hyc();
            }
            ai aiVar = new ai();
            aiVar.field_wishId = cVar.UAv;
            if (super.get(aiVar, new String[0])) {
                aiVar.c(cVar);
                insert = super.update(aiVar, new String[0]);
            } else {
                aiVar.c(cVar);
                aiVar.systemRowid = -1;
                insert = super.insert(aiVar);
            }
            if (insert) {
                try {
                    String str3 = aiVar.field_userName;
                    if (str3 == null || str3.length() == 0) {
                        z = true;
                    }
                    if (!z) {
                        com.tencent.mm.plugin.festival.c.h hVar = com.tencent.mm.plugin.festival.c.h.UGH;
                        SQLiteStatement b2 = com.tencent.mm.plugin.festival.c.h.b(this.iFy, "delete from FestivalWish2  where userName =? and createTime <?");
                        if (b2 != null) {
                            b2.bindString(1, aiVar.field_userName);
                            b2.bindLong(2, aiVar.field_createTime);
                            b2.executeUpdateDelete();
                        }
                        if (cVar.UAu != 0) {
                            this.UzJ.remove(cVar.UAv);
                        }
                    }
                } catch (Exception e2) {
                    Log.e("MicroMsg.FestivalWishStorage", "insertOrUpdate mark delFlag, username:" + aiVar.field_userName + ", createTime:" + aiVar.field_createTime + ", execute get exception:" + e2);
                }
            }
            AppMethodBeat.o(263142);
            return insert;
        }
    }

    public final boolean ii(String str, int i2) {
        boolean z = true;
        AppMethodBeat.i(263143);
        if (str == null) {
            AppMethodBeat.o(263143);
            return false;
        }
        com.tencent.mm.plugin.festival.c.h hVar = com.tencent.mm.plugin.festival.c.h.UGH;
        SQLiteStatement b2 = com.tencent.mm.plugin.festival.c.h.b(this.iFy, "update FestivalWish2 set delFlag =? where wishId =?");
        if (b2 == null) {
            AppMethodBeat.o(263143);
            return false;
        }
        b2.bindLong(1, (long) i2);
        b2.bindString(2, str);
        synchronized (this) {
            try {
                if (b2.executeUpdateDelete() <= 0) {
                    z = false;
                }
            } finally {
                AppMethodBeat.o(263143);
            }
        }
        return z;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\b\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R \u0010\t\u001a\u0010\u0012\f\u0012\n \n*\u0004\u0018\u00010\u00050\u00050\u00048\u0006X\u0004¢\u0006\u0004\n\u0002\u0010\bR\u000e\u0010\u000b\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000¨\u0006\r"}, hxF = {"Lcom/tencent/mm/plugin/festival/model/FestivalWishStorage$Companion;", "", "()V", "INDEX_CREATE", "", "", "getINDEX_CREATE", "()[Ljava/lang/String;", "[Ljava/lang/String;", "SQL_CREATE", "kotlin.jvm.PlatformType", "TABLE", "TAG", "plugin-festival_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(263145);
        AppMethodBeat.o(263145);
    }
}
