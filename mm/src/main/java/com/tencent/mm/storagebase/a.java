package com.tencent.mm.storagebase;

import android.database.Cursor;
import com.facebook.internal.ServerProtocol;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.compatible.deviceinfo.l;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ConfigFile;
import com.tencent.mm.storagebase.h;
import com.tencent.mm.vfs.s;
import com.tencent.wcdb.database.SQLiteDatabaseCorruptException;
import com.tencent.wcdb.database.SQLiteDirectCursor;
import com.tencent.wcdb.database.SQLiteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import junit.framework.Assert;

public final class a {
    public static final Pattern OsR = Pattern.compile("^[\\s]*CREATE[\\s]+TABLE[\\s]*", 2);
    String OsS = "";
    public boolean OsT = false;
    String OsU = "";
    public boolean OsV = false;
    private String errMsg = "";
    private boolean isNew = false;
    f jNN;
    String key;

    static {
        AppMethodBeat.i(133323);
        AppMethodBeat.o(133323);
    }

    public final String getError() {
        AppMethodBeat.i(133311);
        if (Util.isNullOrNil(this.errMsg) || Util.isNullOrNil(this.OsU)) {
            AppMethodBeat.o(133311);
            return "";
        } else if (!Util.isNullOrNil(ConfigFile.getValue(this.OsU, "Reported"))) {
            AppMethodBeat.o(133311);
            return "";
        } else {
            ConfigFile.saveValue(this.OsU, "Reported", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
            String str = this.errMsg;
            AppMethodBeat.o(133311);
            return str;
        }
    }

    private void mY(String str, String str2) {
        AppMethodBeat.i(133312);
        HashSet hashSet = new HashSet();
        Cursor rawQuery = this.jNN.rawQuery("select * from " + str + " limit 1 ", null, 0);
        if (rawQuery.getCount() == 0) {
            rawQuery.close();
            AppMethodBeat.o(133312);
            return;
        }
        rawQuery.moveToFirst();
        for (int i2 = 0; i2 < rawQuery.getColumnCount(); i2++) {
            hashSet.add(rawQuery.getColumnName(i2));
        }
        rawQuery.close();
        Cursor rawQuery2 = this.jNN.rawQuery("PRAGMA table_info( " + str2 + " )", null, 0);
        String str3 = "";
        while (rawQuery2.moveToNext()) {
            String string = rawQuery2.getString(rawQuery2.getColumnIndex("name"));
            if (hashSet.contains(string)) {
                str3 = (str3 + string) + ",";
            }
        }
        rawQuery2.close();
        String substring = str3.substring(0, str3.length() - 1);
        this.jNN.execSQL("insert into " + str2 + "(" + substring + ") select " + substring + " from " + str + ";");
        AppMethodBeat.o(133312);
    }

    private boolean q(Cursor cursor) {
        Cursor rawQuery;
        AppMethodBeat.i(133313);
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        for (int i2 = 0; i2 < cursor.getCount(); i2++) {
            cursor.moveToPosition(i2);
            hashSet.add(cursor.getString(0));
        }
        Cursor rawQuery2 = this.jNN.rawQuery("select DISTINCT tbl_name from old.sqlite_master;", null, 0);
        if (rawQuery2 == null) {
            AppMethodBeat.o(133313);
            return false;
        }
        for (int i3 = 0; i3 < rawQuery2.getCount(); i3++) {
            rawQuery2.moveToPosition(i3);
            hashSet2.add(rawQuery2.getString(0));
        }
        rawQuery2.close();
        this.jNN.beginTransaction();
        Iterator it = hashSet2.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (!hashSet.contains(str) && (rawQuery = this.jNN.rawQuery("SELECT sql FROM old.sqlite_master WHERE type='table' AND tbl_name='" + str + "'", null, 0)) != null) {
                this.jNN.execSQL(rawQuery.getString(0));
                rawQuery.close();
            }
        }
        this.jNN.endTransaction();
        AppMethodBeat.o(133313);
        return true;
    }

    private List<String> mZ(String str, String str2) {
        AppMethodBeat.i(133314);
        ArrayList arrayList = new ArrayList();
        if (this.jNN == null) {
            AppMethodBeat.o(133314);
            return arrayList;
        }
        Cursor rawQuery = this.jNN.rawQuery("PRAGMA table_info( " + str + " )", null, 0);
        if (rawQuery == null) {
            AppMethodBeat.o(133314);
            return arrayList;
        }
        HashMap hashMap = new HashMap();
        int columnIndex = rawQuery.getColumnIndex("name");
        int columnIndex2 = rawQuery.getColumnIndex("type");
        while (rawQuery.moveToNext()) {
            hashMap.put(rawQuery.getString(columnIndex), rawQuery.getString(columnIndex2));
        }
        rawQuery.close();
        Cursor rawQuery2 = this.jNN.rawQuery("PRAGMA table_info( " + str2 + " )", null, 0);
        if (rawQuery2 == null) {
            AppMethodBeat.o(133314);
            return arrayList;
        }
        HashMap hashMap2 = new HashMap();
        int columnIndex3 = rawQuery2.getColumnIndex("name");
        int columnIndex4 = rawQuery2.getColumnIndex("type");
        while (rawQuery2.moveToNext()) {
            hashMap.put(rawQuery2.getString(columnIndex3), rawQuery2.getString(columnIndex4));
        }
        rawQuery2.close();
        Iterator it = new HashSet(hashMap.entrySet()).iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            String str3 = (String) entry.getKey();
            String str4 = (String) entry.getValue();
            if (str4 != null && str4.length() > 0) {
                String str5 = (String) hashMap2.get(str3);
                if (str5 == null) {
                    arrayList.add("ALTER TABLE " + str2 + " ADD COLUMN " + str3 + " " + str4 + ";");
                    hashMap.remove(str3);
                } else if (!str4.toLowerCase().startsWith(str5.toLowerCase())) {
                    Log.e("MicroMsg.DBInit", "conflicting alter table on column: " + str3 + ", " + str5 + "<o-n>" + str4);
                    hashMap.remove(str3);
                }
            }
        }
        AppMethodBeat.o(133314);
        return arrayList;
    }

    private boolean na(String str, String str2) {
        int i2;
        AppMethodBeat.i(133315);
        Cursor rawQuery = this.jNN.rawQuery("select DISTINCT  tbl_name from sqlite_master;", null, 0);
        if (rawQuery == null) {
            AppMethodBeat.o(133315);
            return false;
        }
        try {
            if (Util.isNullOrNil(str2)) {
                this.jNN.execSQL("ATTACH DATABASE '" + str + "' AS old KEY ''");
            } else {
                this.jNN.execSQL("ATTACH DATABASE '" + str + "' AS old KEY '" + str2 + "'");
            }
            if (!q(rawQuery)) {
                AppMethodBeat.o(133315);
                return false;
            }
            this.jNN.beginTransaction();
            for (int i3 = 0; i3 < rawQuery.getCount(); i3++) {
                rawQuery.moveToPosition(i3);
                Cursor rawQuery2 = this.jNN.rawQuery("select * from old.sqlite_master where tbl_name = '" + rawQuery.getString(0) + "'", null, 0);
                if (rawQuery2 != null) {
                    i2 = rawQuery2.getCount();
                    rawQuery2.close();
                } else {
                    i2 = 0;
                }
                if (i2 == 0) {
                    Log.w("MicroMsg.DBInit", "In old db not found :" + rawQuery.getString(0));
                } else {
                    try {
                        for (String str3 : mZ("old." + rawQuery.getString(0), rawQuery.getString(0))) {
                            this.jNN.execSQL(str3);
                        }
                        mY("old." + rawQuery.getString(0), rawQuery.getString(0));
                    } catch (Exception e2) {
                        Log.w("MicroMsg.DBInit", "Insertselect FAILED :" + rawQuery.getString(0));
                    }
                }
            }
            this.jNN.endTransaction();
            rawQuery.close();
            this.jNN.execSQL("DETACH DATABASE old;");
            AppMethodBeat.o(133315);
            return true;
        } catch (SQLiteDatabaseCorruptException e3) {
            Log.e("MicroMsg.DBInit", "Attached database is corrupted: ".concat(String.valueOf(str)));
            s.deleteFile(str);
            AppMethodBeat.o(133315);
            throw e3;
        }
    }

    public final boolean a(String str, HashMap<Integer, h.b> hashMap, boolean z, boolean z2) {
        boolean z3;
        AppMethodBeat.i(197181);
        if (this.jNN != null) {
            this.jNN.close();
            this.jNN = null;
        }
        boolean YS = s.YS(str);
        try {
            Log.i("MicroMsg.DBInit", "initSysDB checkini:%b exist:%b db:%s ", Boolean.TRUE, Boolean.valueOf(YS), str);
            this.jNN = f.dk(str, z2);
            if (!YS) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (!a(hashMap, true, z3)) {
                if (this.jNN != null) {
                    this.jNN.close();
                    this.jNN = null;
                }
                AppMethodBeat.o(197181);
                return false;
            }
            AppMethodBeat.o(197181);
            return true;
        } catch (SQLiteException e2) {
            AppMethodBeat.o(197181);
            return false;
        }
    }

    public final boolean a(String str, String str2, String str3, long j2, HashMap<Integer, h.b> hashMap, boolean z) {
        boolean z2;
        AppMethodBeat.i(133317);
        Assert.assertTrue("create SqliteDB enDbCachePath == null ", !Util.isNullOrNil(str2));
        this.OsU = str2 + ".errreport";
        if (this.jNN != null) {
            this.jNN.close();
            this.jNN = null;
        }
        boolean YS = s.YS(str2);
        boolean YS2 = s.YS(str);
        boolean YS3 = s.YS(str3);
        boolean z3 = !YS && YS2;
        this.OsT = b(str2, j2, f.gFB(), str3);
        Object[] objArr = new Object[7];
        objArr[0] = str2;
        objArr[1] = Boolean.valueOf(YS);
        objArr[2] = Boolean.valueOf(YS2);
        objArr[3] = Boolean.TRUE;
        objArr[4] = Boolean.valueOf(this.OsT);
        objArr[5] = Boolean.valueOf(this.jNN != null);
        objArr[6] = Thread.currentThread().getName();
        Log.i("MicroMsg.DBInit", "initDb(en) path:%s enExist:%b oldExist:%b copyold:%b dbopenSUCC:%b db:%b thr:%s", objArr);
        if (this.jNN == null || this.jNN.getPath().equals(str3) || !YS3) {
            z2 = false;
        } else {
            z2 = true;
            Log.i("MicroMsg.DBInit", "backup db exsits, copy data to en db");
        }
        if (!a(hashMap, z, this.isNew)) {
            AppMethodBeat.o(133317);
            return false;
        } else if (YS2 || YS3) {
            if (z2 || z3) {
                this.OsV = true;
            }
            if (z2) {
                this.key = g.getMessageDigest((q.dr(true) + j2).getBytes()).substring(0, 7);
                nb(str3, this.key);
                com.tencent.mm.blink.a.s(201, 1);
            }
            if (z3) {
                boolean nb = nb(str, "");
                com.tencent.mm.blink.a.s(200, 1);
                AppMethodBeat.o(133317);
                return nb;
            } else if (this.jNN != null) {
                AppMethodBeat.o(133317);
                return true;
            } else {
                AppMethodBeat.o(133317);
                return false;
            }
        } else {
            AppMethodBeat.o(133317);
            return true;
        }
    }

    private boolean nb(String str, String str2) {
        AppMethodBeat.i(133318);
        if (na(str, str2)) {
            Log.i("MicroMsg.DBInit", "system transfer success ,delete it path %s", str);
            Log.i("MicroMsg.DBInit", "delete result :%b", Boolean.valueOf(s.deleteFile(str)));
            AppMethodBeat.o(133318);
            return true;
        }
        Log.i("MicroMsg.DBInit", "system transfer fail path %s", str);
        AppMethodBeat.o(133318);
        return false;
    }

    private static void c(f fVar) {
        AppMethodBeat.i(133319);
        com.tencent.wcdb.Cursor rawQueryWithFactory = (fVar.Otb != null ? fVar.Otb : fVar.Otc).rawQueryWithFactory(SQLiteDirectCursor.FACTORY, "SELECT count(*) FROM sqlite_master;", null, null);
        if (!rawQueryWithFactory.moveToFirst()) {
            SQLiteException sQLiteException = new SQLiteException("Cannot get count for sqlite_master");
            AppMethodBeat.o(133319);
            throw sQLiteException;
        }
        rawQueryWithFactory.close();
        AppMethodBeat.o(133319);
    }

    private boolean b(String str, long j2, boolean z, String str2) {
        int i2;
        AppMethodBeat.i(133321);
        if (this.jNN != null) {
            AssertionError assertionError = new AssertionError();
            AppMethodBeat.o(133321);
            throw assertionError;
        }
        this.isNew = !s.YS(str);
        boolean z2 = false;
        Iterator<String> it = IMEISave.gFy().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            String next = it.next();
            this.key = g.getMessageDigest((next + j2).getBytes()).substring(0, 7);
            try {
                this.jNN = f.E(str, this.key, z);
                c(this.jNN);
                if (!q.dr(true).equals(next)) {
                    Log.i("MicroMsg.DBInit", "IMEI changed detected: ".concat(String.valueOf(next)));
                    l.aol().set(CdnLogic.kAppTypeFestivalVideo, next);
                    e.INSTANCE.idkeyStat(181, 5, 1, false);
                }
                AppMethodBeat.o(133321);
                return true;
            } catch (SQLiteException e2) {
                if (!(e2 instanceof SQLiteDatabaseCorruptException)) {
                    z2 = false;
                    break;
                }
                z2 = true;
            }
        }
        if (z2) {
            if (!z) {
                i2 = 42;
            } else if (f.gFC()) {
                i2 = 43;
            } else {
                i2 = 41;
            }
            e.INSTANCE.idkeyStat(181, (long) i2, 1, true);
            f.bly(str);
            if (str.endsWith("EnMicroMsg.db")) {
                f.bly(com.tencent.mm.kernel.g.aAh().hqG + "dbback/EnMicroMsg.db");
            }
            try {
                this.key = g.getMessageDigest((q.dr(true) + j2).getBytes()).substring(0, 7);
                this.jNN = f.E(str, this.key, z);
                c(this.jNN);
                this.isNew = true;
                e.INSTANCE.idkeyStat(181, 6, 1, false);
                AppMethodBeat.o(133321);
                return true;
            } catch (SQLiteException e3) {
                e.INSTANCE.idkeyStat(181, 7, 1, false);
            }
        } else {
            if (str2 != null && str2.length() > 0) {
                this.isNew = !s.YS(str2);
                try {
                    this.jNN = f.E(str2, this.key, z);
                    c(this.jNN);
                    e.INSTANCE.idkeyStat(181, 6, 1, false);
                    AppMethodBeat.o(133321);
                    return true;
                } catch (SQLiteException e4) {
                    e.INSTANCE.idkeyStat(181, 7, 1, false);
                }
            }
            if (this.jNN != null) {
                this.jNN.close();
                this.jNN = null;
            }
            this.key = null;
            AppMethodBeat.o(133321);
            return false;
        }
    }

    private boolean a(HashMap<Integer, h.b> hashMap, boolean z, boolean z2) {
        int i2;
        AppMethodBeat.i(133322);
        if (this.jNN == null) {
            AppMethodBeat.o(133322);
            return false;
        }
        Object[] objArr = new Object[2];
        objArr[0] = Boolean.valueOf(z);
        objArr[1] = Integer.valueOf(hashMap == null ? -1 : hashMap.size());
        Log.d("MicroMsg.DBInit", "createtables checkCreateIni:%b  tables:%d", objArr);
        String str = "";
        if (z) {
            this.OsS = this.jNN.getPath() + ".ini";
            StringBuilder sb = new StringBuilder();
            if (hashMap != null) {
                for (h.b bVar : hashMap.values()) {
                    if (bVar.getSQLs() == null) {
                        Log.e("MicroMsg.DBInit", "factory.getSQLs() is null: %s", bVar.getClass().toString());
                        Assert.assertTrue("factory.getSQLs() is null:" + bVar.getClass().toString(), false);
                    }
                    String[] sQLs = bVar.getSQLs();
                    for (String str2 : sQLs) {
                        sb.append(str2.hashCode());
                    }
                }
            }
            str = g.getMessageDigest(sb.toString().getBytes());
            if (!z2) {
                String value = ConfigFile.getValue(this.OsS, "createmd5");
                if (!Util.isNullOrNil(value) && str.equals(value)) {
                    Log.i("MicroMsg.DBInit", "Create table factories not changed , no need create !  %s", this.jNN.getPath());
                    AppMethodBeat.o(133322);
                    return true;
                }
            }
        }
        this.jNN.execSQL("pragma auto_vacuum = 0 ");
        f.a aVar = new f.a();
        int i3 = 0;
        this.jNN.beginTransaction();
        if (hashMap != null) {
            Iterator<h.b> it = hashMap.values().iterator();
            while (true) {
                i2 = i3;
                if (!it.hasNext()) {
                    break;
                }
                String[] sQLs2 = it.next().getSQLs();
                i3 = i2;
                for (String str3 : sQLs2) {
                    try {
                        this.jNN.execSQL(str3);
                        i3++;
                    } catch (Exception e2) {
                        Matcher matcher = OsR.matcher(str3);
                        if (matcher == null || !matcher.matches()) {
                            Log.w("MicroMsg.DBInit", "CreateTable failed:[" + str3 + "][" + e2.getMessage() + "]");
                        } else {
                            Assert.assertTrue("CreateTable failed:[" + str3 + "][" + e2.getMessage() + "]", false);
                        }
                    }
                }
            }
        } else {
            i2 = 0;
        }
        long apr = aVar.apr();
        this.jNN.endTransaction();
        Log.i("MicroMsg.DBInit", "createtables end sql:%d trans:%d sqlCount:%d", Long.valueOf(apr), Long.valueOf(aVar.apr()), Integer.valueOf(i2));
        if (z) {
            ConfigFile.saveValue(this.OsS, "createmd5", str);
        }
        AppMethodBeat.o(133322);
        return true;
    }
}
