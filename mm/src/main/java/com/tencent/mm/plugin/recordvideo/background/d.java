package com.tencent.mm.plugin.recordvideo.background;

import android.content.ContentValues;
import android.database.Cursor;
import com.facebook.appevents.UserDataStore;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.background.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.util.Arrays;
import kotlin.f.b;
import kotlin.g.b.ae;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\u0018\u0000 \u00152\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0015B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fJ\u0006\u0010\r\u001a\u00020\u000eJ\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000b\u001a\u00020\fJ\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0011\u001a\u00020\u0012J\u0016\u0010\u0013\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0016"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/background/VideoEditDataStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/plugin/recordvideo/background/VideoEditData;", UserDataStore.DATE_OF_BIRTH, "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "getDb", "()Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "cleanExpiredTask", "", "deleteByTaskId", "taskId", "", "droptable", "", "getByTaskId", "getLastDataIfNoMix", "limitTime", "", "updateByTaskId", "editorData", "Companion", "plugin-recordvideo_release"})
public final class d extends MAutoStorage<c> {
    public static final a BKl = new a((byte) 0);
    private static final String[] SQL_CREATE;
    static final String TABLE = c.TABLE;
    private static final String TAG = TAG;
    final ISQLiteDatabase db;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public d(com.tencent.mm.sdk.storage.ISQLiteDatabase r5) {
        /*
            r4 = this;
            r3 = 75187(0x125b3, float:1.0536E-40)
            java.lang.String r0 = "db"
            kotlin.g.b.p.h(r5, r0)
            com.tencent.mm.plugin.recordvideo.background.c$a r0 = com.tencent.mm.plugin.recordvideo.background.c.BKh
            com.tencent.mm.sdk.storage.IAutoDBItem$MAutoDBInfo r0 = com.tencent.mm.plugin.recordvideo.background.c.eIL()
            com.tencent.mm.plugin.recordvideo.background.c$a r1 = com.tencent.mm.plugin.recordvideo.background.c.BKh
            java.lang.String r1 = com.tencent.mm.plugin.recordvideo.background.c.eIM()
            com.tencent.mm.plugin.recordvideo.background.c$a r2 = com.tencent.mm.plugin.recordvideo.background.c.BKh
            java.lang.String[] r2 = com.tencent.mm.plugin.recordvideo.background.c.eIN()
            r4.<init>(r5, r0, r1, r2)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r3)
            r4.db = r5
            com.tencent.matrix.trace.core.AppMethodBeat.o(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.recordvideo.background.d.<init>(com.tencent.mm.sdk.storage.ISQLiteDatabase):void");
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\n\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R!\u0010\u0003\u001a\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u00050\u0004¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\u0005XD¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u0005XD¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\f¨\u0006\u000f"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/background/VideoEditDataStorage$Companion;", "", "()V", "SQL_CREATE", "", "", "kotlin.jvm.PlatformType", "getSQL_CREATE", "()[Ljava/lang/String;", "[Ljava/lang/String;", "TABLE", "getTABLE", "()Ljava/lang/String;", "TAG", "getTAG", "plugin-recordvideo_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(75188);
        c.a aVar = c.BKh;
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = c.iBg;
        c.a aVar2 = c.BKh;
        SQL_CREATE = new String[]{MAutoStorage.getCreateSQLs(mAutoDBInfo, c.TABLE)};
        c.a aVar3 = c.BKh;
        AppMethodBeat.o(75188);
    }

    public final c aLe(String str) {
        Throwable th;
        Throwable th2 = null;
        AppMethodBeat.i(75183);
        p.h(str, "taskId");
        ae aeVar = ae.SYK;
        String format = String.format("select * from %s where %s=\"%s\"", Arrays.copyOf(new Object[]{TABLE, "taskId", str}, 3));
        p.g(format, "java.lang.String.format(format, *args)");
        Cursor rawQuery = rawQuery(format, new String[0]);
        if (rawQuery != null) {
            Cursor cursor = rawQuery;
            try {
                Cursor cursor2 = cursor;
                if (cursor2.moveToFirst()) {
                    c cVar = new c();
                    cVar.convertFrom(cursor2);
                    b.a(cursor, null);
                    AppMethodBeat.o(75183);
                    return cVar;
                }
                x xVar = x.SXb;
                b.a(cursor, null);
            } catch (Throwable th3) {
                th = th3;
                th2 = th;
                b.a(cursor, th2);
                AppMethodBeat.o(75183);
                throw th;
            }
        }
        AppMethodBeat.o(75183);
        return null;
    }

    public final int a(String str, c cVar) {
        AppMethodBeat.i(75184);
        p.h(str, "taskId");
        p.h(cVar, "editorData");
        ContentValues convertTo = cVar.convertTo();
        convertTo.remove("rowid");
        int update = this.db.update(TABLE, convertTo, "taskId=?", new String[]{String.valueOf(str)});
        AppMethodBeat.o(75184);
        return update;
    }

    public final c HX(long j2) {
        Throwable th;
        Throwable th2 = null;
        AppMethodBeat.i(75185);
        ae aeVar = ae.SYK;
        c.b bVar = c.b.BKk;
        c.b bVar2 = c.b.BKk;
        String format = String.format("select * from %s where %s not in (%d, %d) and %s > %d - %s order by %s asc limit 1", Arrays.copyOf(new Object[]{TABLE, "status", Integer.valueOf(c.b.bTk()), Integer.valueOf(c.b.eIP()), "timeStamp", Long.valueOf(j2), "expiredTime", "timeStamp"}, 8));
        p.g(format, "java.lang.String.format(format, *args)");
        Cursor rawQuery = rawQuery(format, new String[0]);
        if (rawQuery != null) {
            Cursor cursor = rawQuery;
            try {
                Cursor cursor2 = cursor;
                if (cursor2.moveToFirst()) {
                    c cVar = new c();
                    cVar.convertFrom(cursor2);
                    b.a(cursor, null);
                    AppMethodBeat.o(75185);
                    return cVar;
                }
                x xVar = x.SXb;
                b.a(cursor, null);
            } catch (Throwable th3) {
                th = th3;
                th2 = th;
                b.a(cursor, th2);
                AppMethodBeat.o(75185);
                throw th;
            }
        }
        AppMethodBeat.o(75185);
        return null;
    }

    public final void eIQ() {
        AppMethodBeat.i(75186);
        Log.i(TAG, "dropTable ".concat(String.valueOf(this.db.delete(TABLE, null, null))));
        AppMethodBeat.o(75186);
    }
}
