package com.tencent.mm.plugin.account.friend.a;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.TimeLogger;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.storagebase.h;
import java.util.ArrayList;
import java.util.List;

public final class b extends MStorageEx {
    public static final String[] SQL_CREATE = {"CREATE TABLE IF NOT EXISTS addr_upload2 ( id int  PRIMARY KEY , md5 text  , peopleid text  , uploadtime long  , realname text  , realnamepyinitial text  , realnamequanpin text  , username text  , nickname text  , nicknamepyinitial text  , nicknamequanpin text  , type int  , moblie text  , email text  , status int  , reserved1 text  , reserved2 text  , reserved3 int  , reserved4 int , lvbuf BLOG , showhead int  ) ", "CREATE INDEX IF NOT EXISTS upload_time_index ON addr_upload2 ( uploadtime ) ", "CREATE INDEX IF NOT EXISTS addr_upload_user_index ON addr_upload2 ( username ) "};
    public final h iFy;

    public b(h hVar) {
        AppMethodBeat.i(130974);
        this.iFy = hVar;
        Cursor rawQuery = hVar.rawQuery("PRAGMA table_info( " + "addr_upload2" + " )", null, 2);
        int columnIndex = rawQuery.getColumnIndex("name");
        boolean z = false;
        boolean z2 = false;
        while (rawQuery.moveToNext()) {
            if (columnIndex >= 0) {
                String string = rawQuery.getString(columnIndex);
                if ("lvbuf".equalsIgnoreCase(string)) {
                    z2 = true;
                } else if ("showhead".equalsIgnoreCase(string)) {
                    z = true;
                }
            }
        }
        rawQuery.close();
        if (!z2) {
            hVar.execSQL("addr_upload2", "Alter table " + "addr_upload2" + " add lvbuf BLOB ");
        }
        if (!z) {
            hVar.execSQL("addr_upload2", "Alter table " + "addr_upload2" + " add showhead int ");
        }
        AppMethodBeat.o(130974);
    }

    public final boolean aT(List<String> list) {
        boolean z;
        AppMethodBeat.i(130975);
        if (list.size() <= 0) {
            AppMethodBeat.o(130975);
            return false;
        }
        TimeLogger timeLogger = new TimeLogger("MicroMsg.AddrUploadStorage", "delete transaction");
        timeLogger.addSplit("begin");
        long beginTransaction = this.iFy.beginTransaction(Thread.currentThread().getId());
        try {
            for (String str : list) {
                if (str != null && str.length() > 0) {
                    int delete = this.iFy.delete("addr_upload2", "id =?", new String[]{new StringBuilder().append(a.SQ(str)).toString()});
                    Log.d("MicroMsg.AddrUploadStorage", "delete addr_upload2 md5 :" + str + ", res:" + delete);
                    if (delete > 0) {
                        doNotify(5, this, str);
                    }
                }
            }
            z = true;
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.AddrUploadStorage", e2, "", new Object[0]);
            z = false;
        }
        this.iFy.endTransaction(beginTransaction);
        timeLogger.addSplit("end");
        timeLogger.dumpToLog();
        AppMethodBeat.o(130975);
        return z;
    }

    public final boolean av(List<a> list) {
        boolean z;
        boolean moveToFirst;
        AppMethodBeat.i(130976);
        if (list == null || list.size() <= 0) {
            AppMethodBeat.o(130976);
            return false;
        }
        TimeLogger timeLogger = new TimeLogger("MicroMsg.AddrUploadStorage", "transaction");
        timeLogger.addSplit("transation begin");
        long beginTransaction = this.iFy.beginTransaction(Thread.currentThread().getId());
        int i2 = 0;
        while (true) {
            try {
                if (i2 >= list.size()) {
                    z = true;
                    break;
                }
                a aVar = list.get(i2);
                if (aVar != null) {
                    Cursor rawQuery = this.iFy.rawQuery("select addr_upload2.id,addr_upload2.md5,addr_upload2.peopleid,addr_upload2.uploadtime,addr_upload2.realname,addr_upload2.realnamepyinitial,addr_upload2.realnamequanpin,addr_upload2.username,addr_upload2.nickname,addr_upload2.nicknamepyinitial,addr_upload2.nicknamequanpin,addr_upload2.type,addr_upload2.moblie,addr_upload2.email,addr_upload2.status,addr_upload2.reserved1,addr_upload2.reserved2,addr_upload2.reserved3,addr_upload2.reserved4,addr_upload2.lvbuf,addr_upload2.showhead from addr_upload2  where addr_upload2.id = " + a.SQ(aVar.getMd5()), null, 2);
                    if (rawQuery == null) {
                        moveToFirst = false;
                    } else {
                        moveToFirst = rawQuery.moveToFirst();
                        rawQuery.close();
                    }
                    if (!moveToFirst) {
                        aVar.cSx = -1;
                        if (((int) this.iFy.insert("addr_upload2", "id", aVar.convertTo())) == -1) {
                            Log.i("MicroMsg.AddrUploadStorage", "batchSet insert failed, num:%s email:%s", aVar.bnP(), aVar.getEmail());
                            z = true;
                            break;
                        }
                        doNotify(2, this, aVar.getMd5());
                    } else {
                        int SQ = a.SQ(aVar.getMd5());
                        ContentValues convertTo = aVar.convertTo();
                        int i3 = 0;
                        if (convertTo.size() > 0) {
                            i3 = this.iFy.update("addr_upload2", convertTo, "id=?", new String[]{String.valueOf(SQ)});
                        }
                        if (i3 == 0) {
                            Log.i("MicroMsg.AddrUploadStorage", "batchSet update result=0, num:%s email:%s", aVar.bnP(), aVar.getEmail());
                        } else if (i3 < 0) {
                            Log.i("MicroMsg.AddrUploadStorage", "batchSet update failed, num:%s email:%s", aVar.bnP(), aVar.getEmail());
                            z = true;
                            break;
                        } else {
                            doNotify(3, this, aVar.getMd5());
                        }
                    }
                }
                i2++;
            } catch (Exception e2) {
                Log.e("MicroMsg.AddrUploadStorage", e2.getMessage());
                z = false;
            }
        }
        this.iFy.endTransaction(beginTransaction);
        timeLogger.addSplit("transation end");
        timeLogger.dumpToLog();
        AppMethodBeat.o(130976);
        return z;
    }

    public final boolean aU(List<String> list) {
        boolean z;
        AppMethodBeat.i(130977);
        TimeLogger timeLogger = new TimeLogger("MicroMsg.AddrUploadStorage", "set uploaded transaction");
        timeLogger.addSplit("transation begin");
        long beginTransaction = this.iFy.beginTransaction(Thread.currentThread().getId());
        try {
            for (String str : list) {
                if (str != null && str.length() > 0) {
                    a aVar = new a();
                    aVar.cSx = 8;
                    aVar.kdO = Util.nowSecond();
                    ContentValues convertTo = aVar.convertTo();
                    int i2 = 0;
                    if (convertTo.size() > 0) {
                        i2 = this.iFy.update("addr_upload2", convertTo, "id=?", new String[]{new StringBuilder().append(a.SQ(str)).toString()});
                    }
                    Log.i("MicroMsg.AddrUploadStorage", "local contact uploaded : " + str + ", update result: " + i2);
                }
            }
            z = true;
        } catch (Exception e2) {
            Log.e("MicroMsg.AddrUploadStorage", e2.getMessage());
            z = false;
        }
        this.iFy.endTransaction(beginTransaction);
        timeLogger.addSplit("transation end");
        timeLogger.dumpToLog();
        if (z) {
            doNotify(3, this, null);
        }
        AppMethodBeat.o(130977);
        return z;
    }

    public final int a(String str, a aVar) {
        int i2 = 0;
        AppMethodBeat.i(130978);
        ContentValues convertTo = aVar.convertTo();
        if (convertTo.size() > 0) {
            i2 = this.iFy.update("addr_upload2", convertTo, "id=?", new String[]{new StringBuilder().append(a.SQ(str)).toString()});
        }
        if (i2 > 0) {
            if (!aVar.getMd5().equals(str)) {
                doNotify(5, this, str);
                doNotify(2, this, aVar.getMd5());
            } else {
                doNotify(3, this, str);
            }
        }
        AppMethodBeat.o(130978);
        return i2;
    }

    public final a SR(String str) {
        AppMethodBeat.i(130979);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(130979);
            return null;
        }
        a aVar = new a();
        Cursor rawQuery = this.iFy.rawQuery("select addr_upload2.id,addr_upload2.md5,addr_upload2.peopleid,addr_upload2.uploadtime,addr_upload2.realname,addr_upload2.realnamepyinitial,addr_upload2.realnamequanpin,addr_upload2.username,addr_upload2.nickname,addr_upload2.nicknamepyinitial,addr_upload2.nicknamequanpin,addr_upload2.type,addr_upload2.moblie,addr_upload2.email,addr_upload2.status,addr_upload2.reserved1,addr_upload2.reserved2,addr_upload2.reserved3,addr_upload2.reserved4,addr_upload2.lvbuf,addr_upload2.showhead from addr_upload2 where addr_upload2.username=\"" + Util.escapeSqlValue(str) + "\"", null, 2);
        Log.d("MicroMsg.AddrUploadStorage", "get addrUpload :".concat(String.valueOf(str)));
        if (rawQuery.moveToFirst()) {
            aVar.convertFrom(rawQuery);
        }
        rawQuery.close();
        AppMethodBeat.o(130979);
        return aVar;
    }

    public final Cursor SS(String str) {
        AppMethodBeat.i(130980);
        StringBuilder sb = new StringBuilder();
        if (str != null && str.length() > 0) {
            sb.append(" and ( ");
            sb.append("addr_upload2.realname like '%" + str + "%' or ");
            sb.append("addr_upload2.realnamepyinitial like '%" + str + "%' or ");
            sb.append("addr_upload2.realnamequanpin like '%" + str + "%' or ");
            sb.append("addr_upload2.username like '%" + str + "%' or ");
            sb.append("addr_upload2.nickname like '%" + str + "%' or ");
            sb.append("addr_upload2.nicknamepyinitial like '%" + str + "%' or ");
            sb.append("addr_upload2.nicknamequanpin like '%" + str + "%' )");
        }
        sb.append(" and (");
        sb.append("addr_upload2.status=1");
        sb.append(" or ");
        sb.append("addr_upload2.status=2");
        sb.append(")");
        String str2 = (String) g.aAh().azQ().get(6, (Object) null);
        if (str2 == null || str2.equals("")) {
            Cursor rawQuery = this.iFy.rawQuery("select addr_upload2.id,addr_upload2.md5,addr_upload2.peopleid,addr_upload2.uploadtime,addr_upload2.realname,addr_upload2.realnamepyinitial,addr_upload2.realnamequanpin,addr_upload2.username,addr_upload2.nickname,addr_upload2.nicknamepyinitial,addr_upload2.nicknamequanpin,addr_upload2.type,addr_upload2.moblie,addr_upload2.email,addr_upload2.status,addr_upload2.reserved1,addr_upload2.reserved2,addr_upload2.reserved3,addr_upload2.reserved4,addr_upload2.lvbuf,addr_upload2.showhead from addr_upload2  where type = 0" + sb.toString() + " order by  case when status = 1 then 0  when status = 65536 then 1  when status = 2 then 2 else 3 end  , realnamepyinitial", null);
            AppMethodBeat.o(130980);
            return rawQuery;
        }
        Cursor rawQuery2 = this.iFy.rawQuery("select addr_upload2.id,addr_upload2.md5,addr_upload2.peopleid,addr_upload2.uploadtime,addr_upload2.realname,addr_upload2.realnamepyinitial,addr_upload2.realnamequanpin,addr_upload2.username,addr_upload2.nickname,addr_upload2.nicknamepyinitial,addr_upload2.nicknamequanpin,addr_upload2.type,addr_upload2.moblie,addr_upload2.email,addr_upload2.status,addr_upload2.reserved1,addr_upload2.reserved2,addr_upload2.reserved3,addr_upload2.reserved4,addr_upload2.lvbuf,addr_upload2.showhead from addr_upload2  where type = 0 and moblie <> " + str2 + sb.toString() + " order by  case when status = 1 then 0  when status = 65536 then 1  when status = 2 then 2 else 3 end  , realnamepyinitial", null);
        AppMethodBeat.o(130980);
        return rawQuery2;
    }

    public final Cursor ST(String str) {
        AppMethodBeat.i(130981);
        StringBuilder sb = new StringBuilder();
        if (str != null && str.length() > 0) {
            sb.append(" and ( ");
            sb.append("addr_upload2.realname like '%" + str + "%' or ");
            sb.append("addr_upload2.realnamepyinitial like '%" + str + "%' or ");
            sb.append("addr_upload2.realnamequanpin like '%" + str + "%' or ");
            sb.append("addr_upload2.username like '%" + str + "%' or ");
            sb.append("addr_upload2.nickname like '%" + str + "%' or ");
            sb.append("addr_upload2.nicknamepyinitial like '%" + str + "%' or ");
            sb.append("addr_upload2.nicknamequanpin like '%" + str + "%' )");
        }
        sb.append(" and (");
        sb.append("addr_upload2.status=1");
        sb.append(" or ");
        sb.append("addr_upload2.status=2");
        sb.append(")");
        String str2 = (String) g.aAh().azQ().get(6, (Object) null);
        if (str2 == null || str2.equals("")) {
            Cursor rawQuery = this.iFy.rawQuery("select addr_upload2.id,addr_upload2.md5,addr_upload2.peopleid,addr_upload2.uploadtime,addr_upload2.realname,addr_upload2.realnamepyinitial,addr_upload2.realnamequanpin,addr_upload2.username,addr_upload2.nickname,addr_upload2.nicknamepyinitial,addr_upload2.nicknamequanpin,addr_upload2.type,addr_upload2.moblie,addr_upload2.email,addr_upload2.status,addr_upload2.reserved1,addr_upload2.reserved2,addr_upload2.reserved3,addr_upload2.reserved4,addr_upload2.lvbuf,addr_upload2.showhead from addr_upload2  where type = 0" + sb.toString() + " order by showhead", null);
            AppMethodBeat.o(130981);
            return rawQuery;
        }
        Cursor rawQuery2 = this.iFy.rawQuery("select addr_upload2.id,addr_upload2.md5,addr_upload2.peopleid,addr_upload2.uploadtime,addr_upload2.realname,addr_upload2.realnamepyinitial,addr_upload2.realnamequanpin,addr_upload2.username,addr_upload2.nickname,addr_upload2.nicknamepyinitial,addr_upload2.nicknamequanpin,addr_upload2.type,addr_upload2.moblie,addr_upload2.email,addr_upload2.status,addr_upload2.reserved1,addr_upload2.reserved2,addr_upload2.reserved3,addr_upload2.reserved4,addr_upload2.lvbuf,addr_upload2.showhead from addr_upload2  where type = 0 and moblie <> " + str2 + sb.toString() + " order by showhead", null);
        AppMethodBeat.o(130981);
        return rawQuery2;
    }

    public final a SU(String str) {
        a aVar = null;
        AppMethodBeat.i(130982);
        if (str == null || str.length() <= 0) {
            AppMethodBeat.o(130982);
        } else {
            Cursor rawQuery = this.iFy.rawQuery("select addr_upload2.id,addr_upload2.md5,addr_upload2.peopleid,addr_upload2.uploadtime,addr_upload2.realname,addr_upload2.realnamepyinitial,addr_upload2.realnamequanpin,addr_upload2.username,addr_upload2.nickname,addr_upload2.nicknamepyinitial,addr_upload2.nicknamequanpin,addr_upload2.type,addr_upload2.moblie,addr_upload2.email,addr_upload2.status,addr_upload2.reserved1,addr_upload2.reserved2,addr_upload2.reserved3,addr_upload2.reserved4,addr_upload2.lvbuf,addr_upload2.showhead from addr_upload2 where addr_upload2.id=" + a.SQ(str), null, 2);
            if (rawQuery.moveToFirst()) {
                aVar = new a();
                aVar.convertFrom(rawQuery);
            }
            Log.d("MicroMsg.AddrUploadStorage", "get addrUpload :" + str + ", resCnt:" + (aVar != null ? 1 : 0));
            rawQuery.close();
            AppMethodBeat.o(130982);
        }
        return aVar;
    }

    public final List<String[]> bnS() {
        AppMethodBeat.i(130983);
        Cursor rawQuery = this.iFy.rawQuery("select addr_upload2.moblie , addr_upload2.md5 from addr_upload2 where addr_upload2.type = 0", null, 2);
        ArrayList arrayList = new ArrayList();
        while (rawQuery.moveToNext()) {
            arrayList.add(new String[]{rawQuery.getString(0), rawQuery.getString(1)});
        }
        rawQuery.close();
        AppMethodBeat.o(130983);
        return arrayList;
    }

    public final List<a> SV(String str) {
        AppMethodBeat.i(130984);
        Log.d("MicroMsg.AddrUploadStorage", "sql : ".concat(String.valueOf(str)));
        ArrayList arrayList = new ArrayList();
        Log.d("MicroMsg.AddrUploadStorage", "sql : ".concat(String.valueOf(str)));
        Cursor rawQuery = this.iFy.rawQuery(str, null, 2);
        while (rawQuery.moveToNext()) {
            a aVar = new a();
            aVar.convertFrom(rawQuery);
            arrayList.add(aVar);
        }
        rawQuery.close();
        AppMethodBeat.o(130984);
        return arrayList;
    }

    @Override // com.tencent.mm.sdk.storage.MStorageEx
    public final boolean shouldProcessEvent() {
        AppMethodBeat.i(130985);
        if (this.iFy == null || this.iFy.isClose()) {
            Object[] objArr = new Object[1];
            objArr[0] = this.iFy == null ? BuildConfig.COMMAND : Boolean.valueOf(this.iFy.isClose());
            Log.w("MicroMsg.AddrUploadStorage", "shouldProcessEvent db is close :%s", objArr);
            AppMethodBeat.o(130985);
            return false;
        }
        AppMethodBeat.o(130985);
        return true;
    }

    public final String SW(String str) {
        AppMethodBeat.i(130986);
        a SU = SU(str);
        if (SU != null) {
            String username = SU.getUsername();
            AppMethodBeat.o(130986);
            return username;
        }
        AppMethodBeat.o(130986);
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0060  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0068  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String SX(java.lang.String r12) {
        /*
        // Method dump skipped, instructions count: 115
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.account.friend.a.b.SX(java.lang.String):java.lang.String");
    }
}
