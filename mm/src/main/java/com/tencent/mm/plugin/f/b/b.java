package com.tencent.mm.plugin.f.b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.storage.ca;
import java.util.ArrayList;
import java.util.List;

public final class b extends MAutoStorage<a> {
    public static final String[] INDEX_CREATE = {"CREATE  INDEX IF NOT EXISTS msgid_username_index ON WxFileIndex2 ( msgId,username,msgSubType ) ", "CREATE  INDEX IF NOT EXISTS username_type_index ON WxFileIndex2 ( username,msgtime,msgSubType ) "};
    public static final String[] SQL_CREATE = {MAutoStorage.getCreateSQLs(a.info, "WxFileIndex2"), "DROP TABLE IF EXISTS WxFileIndex"};
    public ISQLiteDatabase db;

    static {
        AppMethodBeat.i(22749);
        AppMethodBeat.o(22749);
    }

    public b(ISQLiteDatabase iSQLiteDatabase) {
        super(iSQLiteDatabase, a.info, "WxFileIndex2", INDEX_CREATE);
        this.db = iSQLiteDatabase;
    }

    public final boolean delete() {
        long j2;
        AppMethodBeat.i(22739);
        try {
            j2 = (long) this.db.delete("WxFileIndex2", null, null);
        } catch (Exception e2) {
            j2 = 0;
        }
        if (j2 > 0) {
            AppMethodBeat.o(22739);
            return true;
        }
        AppMethodBeat.o(22739);
        return false;
    }

    public final long Eb(int i2) {
        Cursor cursor = null;
        AppMethodBeat.i(22740);
        long j2 = 0;
        try {
            Cursor rawQuery = this.db.rawQuery("select sum(size)  from WxFileIndex2  where msgType=".concat(String.valueOf(i2)), null);
            if (rawQuery != null && rawQuery.moveToFirst()) {
                j2 = rawQuery.getLong(0);
            }
            if (rawQuery != null) {
                rawQuery.close();
            }
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.WxFileIndexStorage", e2, "getSumByMsgType error", new Object[0]);
            if (0 != 0) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            AppMethodBeat.o(22740);
            throw th;
        }
        AppMethodBeat.o(22740);
        return j2;
    }

    public final long Ec(int i2) {
        Cursor cursor = null;
        AppMethodBeat.i(22741);
        long j2 = 0;
        try {
            cursor = this.db.rawQuery("select count(*)  from WxFileIndex2  where msgType=" + i2 + " and size>0", null);
            if (cursor != null && cursor.moveToFirst()) {
                j2 = cursor.getLong(0);
            }
            return j2;
        } finally {
            if (cursor != null) {
                cursor.close();
            }
            AppMethodBeat.o(22741);
        }
    }

    public final long csg() {
        Cursor cursor = null;
        AppMethodBeat.i(22742);
        long j2 = 0;
        try {
            cursor = this.db.rawQuery("select sum(size)  from WxFileIndex2 where msgSubType in (1,20,23,30,32,34 )", null);
            if (cursor != null && cursor.moveToFirst()) {
                j2 = cursor.getLong(0);
            }
            return j2;
        } finally {
            if (cursor != null) {
                cursor.close();
            }
            AppMethodBeat.o(22742);
        }
    }

    public final Cursor csh() {
        Cursor cursor = null;
        AppMethodBeat.i(22743);
        try {
            cursor = this.db.rawQuery("select username,  sum(size) as total from WxFileIndex2 where size > 0  and msgSubType in (1,20,23,30,32,34 ) group by username order by total desc", null);
        } catch (Exception e2) {
        }
        AppMethodBeat.o(22743);
        return cursor;
    }

    public final List<a> u(String str, long j2, long j3) {
        AppMethodBeat.i(22744);
        long currentTicks = Util.currentTicks();
        String str2 = "select *, rowid from WxFileIndex2  where username='" + str + "' and msgtime<=" + j2 + " and msgtime>" + j3 + " and msgSubType in (1,20,23,30,32,34 ) and size > 0  order by msgtime DESC,msgSubType" + " ASC ";
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            Cursor rawQuery = this.db.rawQuery(str2, null);
            if (rawQuery != null) {
                while (rawQuery.moveToNext()) {
                    a aVar = new a();
                    aVar.convertFrom(rawQuery);
                    arrayList.add(aVar);
                }
            }
            if (rawQuery != null) {
                rawQuery.close();
            }
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.WxFileIndexStorage", e2, " sql [%s]", str2);
            if (0 != 0) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            AppMethodBeat.o(22744);
            throw th;
        }
        Log.i("MicroMsg.WxFileIndexStorage", "getNoThumbMediaWxFileIndex [%s] size[%d] cost[%d] ", str, Integer.valueOf(arrayList.size()), Long.valueOf(Util.ticksToNow(currentTicks)));
        AppMethodBeat.o(22744);
        return arrayList;
    }

    public final List<a> v(String str, long j2, long j3) {
        AppMethodBeat.i(22745);
        long currentTicks = Util.currentTicks();
        String str2 = "select *, rowid from WxFileIndex2  where username='" + str + "' and msgtime<=" + j2 + " and msgtime>" + j3 + " and msgType in (43,62,44,3,49,486539313,268435505 ) order by msgtime DESC,msgSubType ASC ";
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            Cursor rawQuery = this.db.rawQuery(str2, null);
            if (rawQuery != null) {
                while (rawQuery.moveToNext()) {
                    a aVar = new a();
                    aVar.convertFrom(rawQuery);
                    arrayList.add(aVar);
                }
            }
            if (rawQuery != null) {
                rawQuery.close();
            }
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.WxFileIndexStorage", e2, " sql [%s]", str2);
            if (0 != 0) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            AppMethodBeat.o(22745);
            throw th;
        }
        Log.i("MicroMsg.WxFileIndexStorage", "getMediaWxFileIndex [%s] size[%d] cost[%d] ", str, Integer.valueOf(arrayList.size()), Long.valueOf(Util.ticksToNow(currentTicks)));
        AppMethodBeat.o(22745);
        return arrayList;
    }

    public final List<a> ar(ca caVar) {
        Cursor cursor = null;
        AppMethodBeat.i(22746);
        if (caVar == null) {
            AppMethodBeat.o(22746);
            return null;
        }
        String str = "select *, rowid from WxFileIndex2  where msgId=" + caVar.field_msgId + " AND username='" + caVar.field_talker + "' order by msgSubType ASC ";
        ArrayList arrayList = new ArrayList();
        try {
            Cursor rawQuery = this.db.rawQuery(str, null);
            while (rawQuery.moveToNext()) {
                a aVar = new a();
                aVar.convertFrom(rawQuery);
                arrayList.add(aVar);
            }
            if (rawQuery != null) {
                rawQuery.close();
            }
        } catch (Exception e2) {
            if (0 != 0) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            AppMethodBeat.o(22746);
            throw th;
        }
        AppMethodBeat.o(22746);
        return arrayList;
    }

    public final int cQ(List<a> list) {
        AppMethodBeat.i(22747);
        if (list.isEmpty()) {
            AppMethodBeat.o(22747);
            return 0;
        }
        long currentTicks = Util.currentTicks();
        int i2 = 0;
        for (a aVar : list) {
            i2 = (insertNotify(aVar, false) ? 1 : 0) + i2;
        }
        Log.d("MicroMsg.WxFileIndexStorage", "insert list result[%d %d] cost[%d]", Integer.valueOf(i2), Integer.valueOf(list.size()), Long.valueOf(Util.ticksToNow(currentTicks)));
        AppMethodBeat.o(22747);
        return i2;
    }

    public final int cR(List<a> list) {
        AppMethodBeat.i(22748);
        if (list.isEmpty()) {
            AppMethodBeat.o(22748);
            return 0;
        }
        long currentTicks = Util.currentTicks();
        int i2 = 0;
        for (a aVar : list) {
            i2 = (update(aVar.systemRowid, aVar, false) ? 1 : 0) + i2;
        }
        Log.d("MicroMsg.WxFileIndexStorage", "update list result[%d %d] cost[%d]", Integer.valueOf(i2), Integer.valueOf(list.size()), Long.valueOf(Util.ticksToNow(currentTicks)));
        AppMethodBeat.o(22748);
        return i2;
    }
}
