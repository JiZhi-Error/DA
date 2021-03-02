package com.tencent.mm.plugin.festival.model;

import android.database.Cursor;
import com.facebook.appevents.UserDataStore;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.festival.b.j;
import com.tencent.mm.plugin.festival.c.e;
import com.tencent.mm.plugin.festival.c.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.ISQLiteDatabaseEx;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.util.ArrayList;
import java.util.List;
import kotlin.a.v;
import kotlin.f.b;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\fB\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0016\u0010\u0006\u001a\u00020\u00072\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tJ\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\tR\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, hxF = {"Lcom/tencent/mm/plugin/festival/model/FestivalTopicStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/plugin/festival/model/LocalFestivalTopic;", UserDataStore.DATE_OF_BIRTH, "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "bulkReplace", "", "topicList", "", "Lcom/tencent/mm/plugin/festival/proto/FestivalWishTopic;", "getTopicList", "Companion", "plugin-festival_release"})
public final class y extends MAutoStorage<ah> {
    public static final String[] SQL_CREATE = {MAutoStorage.getCreateSQLs(ah.iBg, TABLE_NAME)};
    public static final String TABLE_NAME = TABLE_NAME;
    @Deprecated
    public static final a UyZ = new a((byte) 0);
    private final ISQLiteDatabase db;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u00050\u00048\u0006X\u0004¢\u0006\u0004\n\u0002\u0010\u0007R\u0010\u0010\b\u001a\u00020\u00058\u0006XD¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/festival/model/FestivalTopicStorage$Companion;", "", "()V", "SQL_CREATE", "", "", "kotlin.jvm.PlatformType", "[Ljava/lang/String;", "TABLE_NAME", "TAG", "plugin-festival_release"})
    static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public y(ISQLiteDatabase iSQLiteDatabase) {
        super(iSQLiteDatabase, ah.iBg, TABLE_NAME, ah.INDEX_CREATE);
        p.h(iSQLiteDatabase, UserDataStore.DATE_OF_BIRTH);
        AppMethodBeat.i(263074);
        this.db = iSQLiteDatabase;
        AppMethodBeat.o(263074);
    }

    static {
        AppMethodBeat.i(263075);
        AppMethodBeat.o(263075);
    }

    public final boolean kU(List<? extends j> list) {
        AppMethodBeat.i(263072);
        List<? extends j> list2 = list;
        if (list2 == null || list2.isEmpty()) {
            AppMethodBeat.o(263072);
            return false;
        }
        try {
            synchronized (this) {
                try {
                    h hVar = h.UGH;
                    ISQLiteDatabase iSQLiteDatabase = this.db;
                    if (iSQLiteDatabase instanceof ISQLiteDatabaseEx) {
                        Thread currentThread = Thread.currentThread();
                        p.g(currentThread, "Thread.currentThread()");
                        long beginTransaction = ((ISQLiteDatabaseEx) iSQLiteDatabase).beginTransaction(currentThread.getId());
                        try {
                            this.db.execSQL(TABLE_NAME, "delete from FestivalTopic");
                            ah ahVar = new ah();
                            for (T t : list) {
                                ahVar.systemRowid = -1;
                                ahVar.field_topic = t.dST;
                                ahVar.field_count = e.awJ(t.count);
                                Log.i("MicroMsg.FestivalTopicStorage", "insert topic:" + ahVar.field_topic + ", count:" + ahVar.field_count + ", insert:" + insertNotify(ahVar, false));
                            }
                            x xVar = x.SXb;
                            ((ISQLiteDatabaseEx) iSQLiteDatabase).endTransaction(beginTransaction);
                        } catch (Throwable th) {
                            ((ISQLiteDatabaseEx) iSQLiteDatabase).endTransaction(beginTransaction);
                            AppMethodBeat.o(263072);
                            throw th;
                        }
                    } else {
                        this.db.execSQL(TABLE_NAME, "delete from FestivalTopic");
                        ah ahVar2 = new ah();
                        for (T t2 : list) {
                            ahVar2.systemRowid = -1;
                            ahVar2.field_topic = t2.dST;
                            ahVar2.field_count = e.awJ(t2.count);
                            Log.i("MicroMsg.FestivalTopicStorage", "insert topic:" + ahVar2.field_topic + ", count:" + ahVar2.field_count + ", insert:" + insertNotify(ahVar2, false));
                        }
                    }
                    x xVar2 = x.SXb;
                } catch (Throwable th2) {
                    AppMethodBeat.o(263072);
                    throw th2;
                }
            }
        } catch (Exception e2) {
            Log.e("MicroMsg.FestivalTopicStorage", "bulkReplace topicList.size:" + list.size() + ", exception:" + e2);
        }
        doNotify();
        AppMethodBeat.o(263072);
        return true;
    }

    public final List<ah> getTopicList() {
        Throwable th;
        Throwable th2 = null;
        AppMethodBeat.i(263073);
        try {
            synchronized (this) {
                try {
                    Cursor rawQuery = this.db.rawQuery("select * from FestivalTopic order by count desc", null);
                    if (rawQuery == null) {
                        return v.SXr;
                    }
                    ArrayList arrayList = new ArrayList();
                    Cursor cursor = rawQuery;
                    try {
                        if (rawQuery.moveToFirst()) {
                            do {
                                ah ahVar = new ah();
                                ahVar.convertFrom(rawQuery);
                                arrayList.add(ahVar);
                            } while (rawQuery.moveToNext());
                        }
                        x xVar = x.SXb;
                        b.a(cursor, null);
                        ArrayList arrayList2 = arrayList;
                        AppMethodBeat.o(263073);
                        return arrayList2;
                    } catch (Throwable th3) {
                        th = th3;
                        th2 = th;
                        b.a(cursor, th2);
                        AppMethodBeat.o(263073);
                        throw th;
                    }
                } finally {
                    AppMethodBeat.o(263073);
                }
            }
        } catch (Exception e2) {
            Log.e("MicroMsg.FestivalTopicStorage", "getTopicList exception:".concat(String.valueOf(e2)));
            v vVar = v.SXr;
            AppMethodBeat.o(263073);
            return vVar;
        }
    }
}
