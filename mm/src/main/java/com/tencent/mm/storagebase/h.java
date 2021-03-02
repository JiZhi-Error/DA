package com.tencent.mm.storagebase;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.DatabaseUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabaseEx;
import com.tencent.mm.vfs.s;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wcdb.repair.DBDumpUtil;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public class h implements ISQLiteDatabaseEx {
    private a OtA = null;
    public a OtB = new a();
    private String OtC = "";
    public c OtD = null;
    public String OtE = "";
    private final LinkedList<Object> OtF = new LinkedList<>();
    private MMHandler OtG = null;
    private String TAG = "MicroMsg.SqliteDB";
    public int field_MARK_CURSOR_CHECK_IGNORE = 1;
    protected f jNN = null;
    private long oKR = 0;

    public interface a {
        void azX();

        void azY();

        void azZ();
    }

    public interface b {
        String[] getSQLs();
    }

    public interface c {
        void aAa();
    }

    public h(a aVar) {
        AppMethodBeat.i(133398);
        this.OtA = aVar;
        AppMethodBeat.o(133398);
    }

    public h() {
        AppMethodBeat.i(133399);
        AppMethodBeat.o(133399);
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        AppMethodBeat.i(133400);
        CL(null);
        AppMethodBeat.o(133400);
    }

    public void closeDB() {
        AppMethodBeat.i(133401);
        CL(null);
        AppMethodBeat.o(133401);
    }

    public void CL(String str) {
        AppMethodBeat.i(133402);
        if (this.jNN == null) {
            AppMethodBeat.o(133402);
            return;
        }
        if (this.OtA != null) {
            this.OtA.azX();
        }
        Log.w(this.TAG, "begin close db, inTrans:%b ticket:%s  thr:%d {%s}", Boolean.valueOf(inTransaction()), Long.toHexString(this.oKR), Long.valueOf(Thread.currentThread().getId()), Util.getStack());
        f.a aVar = new f.a();
        if (str != null) {
            this.OtC = str;
        }
        this.jNN.close();
        this.jNN = null;
        Log.d(this.TAG, "end close db time:%d", Long.valueOf(aVar.apr()));
        AppMethodBeat.o(133402);
    }

    @Override // com.tencent.mm.sdk.storage.ISQLiteDatabase
    public boolean isClose() {
        AppMethodBeat.i(133403);
        if (this.jNN == null || !this.jNN.isOpen()) {
            AppMethodBeat.o(133403);
            return true;
        }
        AppMethodBeat.o(133403);
        return false;
    }

    private void blA(String str) {
        AppMethodBeat.i(133404);
        String processName = MMApplicationContext.getProcessName();
        String packageName = MMApplicationContext.getPackageName();
        Log.i(this.TAG, "check process :[%s] [%s] path[%s]", processName, packageName, str);
        if (!(processName == null || packageName == null || packageName.equals(processName))) {
            Assert.assertTrue("processName:" + processName + "  packagename:" + packageName, false);
        }
        AppMethodBeat.o(133404);
    }

    public final boolean a(String str, HashMap<Integer, b> hashMap, boolean z) {
        AppMethodBeat.i(133405);
        int lastIndexOf = str.lastIndexOf(FilePathGenerator.ANDROID_DIR_SEP);
        if (lastIndexOf != -1) {
            this.TAG += "." + str.substring(lastIndexOf + 1);
        }
        blA(str);
        if (!this.OtB.a(str, hashMap, true, z) || this.OtB.jNN == null) {
            this.jNN = null;
            this.OtB = null;
            Log.e(this.TAG, "initDB failed.");
            AppMethodBeat.o(133405);
            return false;
        }
        this.jNN = this.OtB.jNN;
        Log.i(this.TAG, "SqliteDB db %s", this.jNN);
        AppMethodBeat.o(133405);
        return true;
    }

    public final boolean b(String str, String str2, String str3, long j2, HashMap<Integer, b> hashMap, boolean z) {
        AppMethodBeat.i(133406);
        int lastIndexOf = str.lastIndexOf(FilePathGenerator.ANDROID_DIR_SEP);
        if (lastIndexOf != -1) {
            this.TAG += "." + str.substring(lastIndexOf + 1);
        }
        blA(str2);
        if (!this.OtB.a(str, str2, str3, j2, hashMap, z) || this.OtB.jNN == null) {
            this.OtE = this.OtB.getError();
            this.jNN = null;
            this.OtB = null;
            Log.i(this.TAG, "initDB failed. %s", this.OtE);
            AppMethodBeat.o(133406);
            return false;
        }
        this.OtE = this.OtB.getError();
        this.jNN = this.OtB.jNN;
        AppMethodBeat.o(133406);
        return true;
    }

    public final boolean a(String str, String str2, long j2, HashMap<Integer, b> hashMap) {
        AppMethodBeat.i(133407);
        boolean b2 = b(str, str2, "", j2, hashMap, true);
        AppMethodBeat.o(133407);
        return b2;
    }

    public final boolean isOpen() {
        AppMethodBeat.i(133408);
        if (this.jNN == null || !this.jNN.isOpen()) {
            Log.e(this.TAG, "DB has been closed :[" + this.OtC + "]", Boolean.valueOf(Util.isNullOrNil(this.OtC)));
            AppMethodBeat.o(133408);
            return false;
        }
        AppMethodBeat.o(133408);
        return true;
    }

    public final String getKey() {
        if (this.OtB == null) {
            return null;
        }
        return this.OtB.key;
    }

    public final String getPath() {
        AppMethodBeat.i(133409);
        if (!isOpen()) {
            Log.e(this.TAG, "DB IS CLOSED ! {%s}", Util.getStack());
            AppMethodBeat.o(133409);
            return null;
        }
        String path = this.jNN.getPath();
        AppMethodBeat.o(133409);
        return path;
    }

    public static String Fl(String str) {
        AppMethodBeat.i(133410);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(133410);
            return "";
        }
        String sqlEscapeString = DatabaseUtils.sqlEscapeString(str);
        AppMethodBeat.o(133410);
        return sqlEscapeString;
    }

    @Override // com.tencent.mm.sdk.storage.ISQLiteDatabase
    public Cursor query(String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5) {
        AppMethodBeat.i(133411);
        Cursor query = query(str, strArr, str2, strArr2, str3, str4, str5, 0);
        AppMethodBeat.o(133411);
        return query;
    }

    @Override // com.tencent.mm.sdk.storage.ISQLiteDatabase
    public Cursor query(String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, int i2) {
        AppMethodBeat.i(133412);
        Cursor query = query(str, strArr, str2, strArr2, str3, str4, str5, i2, null);
        AppMethodBeat.o(133412);
        return query;
    }

    @Override // com.tencent.mm.sdk.storage.ISQLiteDatabase
    public Cursor query(String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, int i2, String str6) {
        int i3;
        AppMethodBeat.i(197185);
        if (!isOpen()) {
            Log.e(this.TAG, "DB IS CLOSED ! {%s}", Util.getStack());
            Cursor gFu = d.gFu();
            AppMethodBeat.o(197185);
            return gFu;
        }
        boolean z = WXHardCoderJNI.hcDBEnable;
        int i4 = WXHardCoderJNI.hcDBDelayQuery;
        int i5 = WXHardCoderJNI.hcDBCPU;
        int i6 = WXHardCoderJNI.hcDBIO;
        if (WXHardCoderJNI.hcDBThr) {
            i3 = g.aAk().getProcessTid();
        } else {
            i3 = 0;
        }
        int startPerformance = WXHardCoderJNI.startPerformance(z, i4, i5, i6, i3, WXHardCoderJNI.hcDBTimeout, 501, WXHardCoderJNI.hcDBActionQuery, this.TAG);
        c.begin();
        try {
            Cursor query = this.jNN.query(str, strArr, str2, strArr2, str3, str4, str5, i2, str6);
            c.a(str, query, this.oKR);
            return query;
        } catch (Exception e2) {
            e.INSTANCE.idkeyStat(181, 10, 1, false);
            Log.e(this.TAG, "execSQL Error :" + e2.getMessage());
            c.p(e2);
            return d.gFu();
        } finally {
            WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcDBEnable, startPerformance);
            AppMethodBeat.o(197185);
        }
    }

    @Override // com.tencent.mm.sdk.storage.ISQLiteDatabase
    public Cursor rawQuery(String str, String[] strArr, int i2) {
        int i3 = 0;
        AppMethodBeat.i(133413);
        Assert.assertTrue("sql is null ", !Util.isNullOrNil(str));
        if (!isOpen()) {
            Log.e(this.TAG, "DB IS CLOSED ! {%s}", Util.getStack());
            Cursor gFu = d.gFu();
            AppMethodBeat.o(133413);
            return gFu;
        }
        boolean z = WXHardCoderJNI.hcDBEnable;
        int i4 = WXHardCoderJNI.hcDBDelayQuery;
        int i5 = WXHardCoderJNI.hcDBCPU;
        int i6 = WXHardCoderJNI.hcDBIO;
        if (WXHardCoderJNI.hcDBThr) {
            i3 = g.aAk().getProcessTid();
        }
        int startPerformance = WXHardCoderJNI.startPerformance(z, i4, i5, i6, i3, WXHardCoderJNI.hcDBTimeout, 501, WXHardCoderJNI.hcDBActionQuery, this.TAG);
        c.begin();
        try {
            Cursor rawQuery = this.jNN.rawQuery(str, strArr, i2);
            c.a(str, rawQuery, this.oKR);
            return rawQuery;
        } catch (Exception e2) {
            e.INSTANCE.idkeyStat(181, 10, 1, false);
            Log.e(this.TAG, "execSQL Error :" + e2.getMessage());
            c.p(e2);
            return d.gFu();
        } finally {
            WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcDBEnable, startPerformance);
            AppMethodBeat.o(133413);
        }
    }

    @Override // com.tencent.mm.sdk.storage.ISQLiteDatabase
    public Cursor rawQuery(String str, String[] strArr) {
        AppMethodBeat.i(186041);
        Cursor rawQuery = rawQuery(str, strArr, 0);
        AppMethodBeat.o(186041);
        return rawQuery;
    }

    public final boolean a(String str, String str2, String str3, List<String> list, DBDumpUtil.ExecuteSqlCallback executeSqlCallback) {
        AppMethodBeat.i(133415);
        if (!isOpen()) {
            Log.e(this.TAG, "DB IS CLOSED ! {%s}", Util.getStack());
            AppMethodBeat.o(133415);
            return false;
        }
        boolean doRecoveryDb = DBDumpUtil.doRecoveryDb(this.jNN.Otb, str, str2, str3, list, null, executeSqlCallback, true);
        AppMethodBeat.o(133415);
        return doRecoveryDb;
    }

    public final long getPageSize() {
        AppMethodBeat.i(133416);
        long pageSize = this.jNN.Otb.getPageSize();
        AppMethodBeat.o(133416);
        return pageSize;
    }

    public final f gFG() {
        return this.jNN;
    }

    public final SQLiteDatabase gFH() {
        f fVar = this.jNN;
        if (fVar.Otb != null) {
            return fVar.Otb;
        }
        return fVar.Otc;
    }

    @Override // com.tencent.mm.sdk.storage.ISQLiteDatabase
    public boolean execSQL(String str, String str2) {
        int i2;
        AppMethodBeat.i(133417);
        Assert.assertTrue("sql is null ", !Util.isNullOrNil(str2));
        if (!isOpen()) {
            Log.e(this.TAG, "DB IS CLOSED ! {%s}", Util.getStack());
            AppMethodBeat.o(133417);
            return false;
        }
        boolean z = WXHardCoderJNI.hcDBEnable;
        int i3 = WXHardCoderJNI.hcDBDelayWrite;
        int i4 = WXHardCoderJNI.hcDBCPU;
        int i5 = WXHardCoderJNI.hcDBIO;
        if (WXHardCoderJNI.hcDBThr) {
            i2 = g.aAk().getProcessTid();
        } else {
            i2 = 0;
        }
        int startPerformance = WXHardCoderJNI.startPerformance(z, i3, i4, i5, i2, WXHardCoderJNI.hcDBTimeout, 501, WXHardCoderJNI.hcDBActionWrite, this.TAG);
        c.begin();
        try {
            this.jNN.execSQL(str2);
            c.a(str2, null, this.oKR);
            WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcDBEnable, startPerformance);
            AppMethodBeat.o(133417);
            return true;
        } catch (Exception e2) {
            e.INSTANCE.idkeyStat(181, 11, 1, false);
            String message = e2.getMessage();
            Log.e(this.TAG, "execSQL Error :".concat(String.valueOf(message)));
            if (message == null || !message.contains("no such table")) {
                c.p(e2);
                WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcDBEnable, startPerformance);
                AppMethodBeat.o(133417);
                return false;
            }
            a aVar = this.OtB;
            Log.d("MicroMsg.DBInit", "resetIniCache iniFilename:%s", aVar.OsS);
            s.deleteFile(aVar.OsS);
            if (this.OtD != null) {
                this.OtD.aAa();
            }
            AppMethodBeat.o(133417);
            throw e2;
        } catch (Throwable th) {
            WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcDBEnable, startPerformance);
            AppMethodBeat.o(133417);
            throw th;
        }
    }

    @Override // com.tencent.mm.sdk.storage.ISQLiteDatabase
    public long insert(String str, String str2, ContentValues contentValues) {
        AppMethodBeat.i(186042);
        long a2 = a(str, str2, contentValues);
        AppMethodBeat.o(186042);
        return a2;
    }

    public final long a(String str, String str2, ContentValues contentValues) {
        int i2 = 0;
        AppMethodBeat.i(133419);
        if (!isOpen()) {
            Log.e(this.TAG, "DB IS CLOSED ! {%s}", Util.getStack());
            AppMethodBeat.o(133419);
            return -2;
        }
        boolean z = WXHardCoderJNI.hcDBEnable;
        int i3 = WXHardCoderJNI.hcDBDelayWrite;
        int i4 = WXHardCoderJNI.hcDBCPU;
        int i5 = WXHardCoderJNI.hcDBIO;
        if (WXHardCoderJNI.hcDBThr) {
            i2 = g.aAk().getProcessTid();
        }
        int startPerformance = WXHardCoderJNI.startPerformance(z, i3, i4, i5, i2, WXHardCoderJNI.hcDBTimeout, 501, WXHardCoderJNI.hcDBActionWrite, this.TAG);
        c.begin();
        try {
            long insert = this.jNN.insert(str, str2, contentValues);
            c.a(str, null, this.oKR);
            WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcDBEnable, startPerformance);
            AppMethodBeat.o(133419);
            return insert;
        } catch (Exception e2) {
            e.INSTANCE.idkeyStat(181, 11, 1, false);
            Log.e(this.TAG, "insert Error :" + e2.getMessage());
            c.p(e2);
            WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcDBEnable, startPerformance);
            AppMethodBeat.o(133419);
            return -1;
        } catch (Throwable th) {
            WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcDBEnable, startPerformance);
            AppMethodBeat.o(133419);
            throw th;
        }
    }

    @Override // com.tencent.mm.sdk.storage.ISQLiteDatabase
    public int update(String str, ContentValues contentValues, String str2, String[] strArr) {
        int i2;
        AppMethodBeat.i(133420);
        if (!isOpen()) {
            Log.e(this.TAG, "DB IS CLOSED ! {%s}", Util.getStack());
            AppMethodBeat.o(133420);
            return -2;
        }
        boolean z = WXHardCoderJNI.hcDBEnable;
        int i3 = WXHardCoderJNI.hcDBDelayWrite;
        int i4 = WXHardCoderJNI.hcDBCPU;
        int i5 = WXHardCoderJNI.hcDBIO;
        if (WXHardCoderJNI.hcDBThr) {
            i2 = g.aAk().getProcessTid();
        } else {
            i2 = 0;
        }
        int startPerformance = WXHardCoderJNI.startPerformance(z, i3, i4, i5, i2, WXHardCoderJNI.hcDBTimeout, 501, WXHardCoderJNI.hcDBActionWrite, this.TAG);
        c.begin();
        try {
            int update = this.jNN.update(str, contentValues, str2, strArr);
            c.a(str, null, this.oKR);
            WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcDBEnable, startPerformance);
            AppMethodBeat.o(133420);
            return update;
        } catch (Exception e2) {
            e.INSTANCE.idkeyStat(181, 11, 1, false);
            Log.e(this.TAG, "update Error :" + e2.getMessage());
            c.p(e2);
            WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcDBEnable, startPerformance);
            AppMethodBeat.o(133420);
            return -1;
        } catch (Throwable th) {
            WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcDBEnable, startPerformance);
            AppMethodBeat.o(133420);
            throw th;
        }
    }

    @Override // com.tencent.mm.sdk.storage.ISQLiteDatabase
    public long replace(String str, String str2, ContentValues contentValues) {
        int i2 = 0;
        AppMethodBeat.i(133421);
        if (!isOpen()) {
            Log.e(this.TAG, "DB IS CLOSED ! {%s}", Util.getStack());
            AppMethodBeat.o(133421);
            return -2;
        }
        boolean z = WXHardCoderJNI.hcDBEnable;
        int i3 = WXHardCoderJNI.hcDBDelayWrite;
        int i4 = WXHardCoderJNI.hcDBCPU;
        int i5 = WXHardCoderJNI.hcDBIO;
        if (WXHardCoderJNI.hcDBThr) {
            i2 = g.aAk().getProcessTid();
        }
        int startPerformance = WXHardCoderJNI.startPerformance(z, i3, i4, i5, i2, WXHardCoderJNI.hcDBTimeout, 501, WXHardCoderJNI.hcDBActionWrite, this.TAG);
        c.begin();
        try {
            long replace = this.jNN.replace(str, str2, contentValues);
            c.a(str, null, this.oKR);
            WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcDBEnable, startPerformance);
            AppMethodBeat.o(133421);
            return replace;
        } catch (Exception e2) {
            e.INSTANCE.idkeyStat(181, 11, 1, false);
            Log.e(this.TAG, "repalce  Error :" + e2.getMessage());
            c.p(e2);
            WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcDBEnable, startPerformance);
            AppMethodBeat.o(133421);
            return -1;
        } catch (Throwable th) {
            WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcDBEnable, startPerformance);
            AppMethodBeat.o(133421);
            throw th;
        }
    }

    @Override // com.tencent.mm.sdk.storage.ISQLiteDatabase
    public int delete(String str, String str2, String[] strArr) {
        int i2 = 0;
        AppMethodBeat.i(133422);
        if (!isOpen()) {
            Log.e(this.TAG, "DB IS CLOSED ! {%s}", Util.getStack());
            AppMethodBeat.o(133422);
            return -2;
        }
        boolean z = WXHardCoderJNI.hcDBEnable;
        int i3 = WXHardCoderJNI.hcDBDelayWrite;
        int i4 = WXHardCoderJNI.hcDBCPU;
        int i5 = WXHardCoderJNI.hcDBIO;
        if (WXHardCoderJNI.hcDBThr) {
            i2 = g.aAk().getProcessTid();
        }
        int startPerformance = WXHardCoderJNI.startPerformance(z, i3, i4, i5, i2, WXHardCoderJNI.hcDBTimeout, 501, WXHardCoderJNI.hcDBActionWrite, this.TAG);
        c.begin();
        try {
            int delete = this.jNN.delete(str, str2, strArr);
            c.a(str, null, this.oKR);
            WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcDBEnable, startPerformance);
            AppMethodBeat.o(133422);
            return delete;
        } catch (Exception e2) {
            e.INSTANCE.idkeyStat(181, 11, 1, false);
            Log.e(this.TAG, "delete Error :" + e2.getMessage());
            c.p(e2);
            WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcDBEnable, startPerformance);
            AppMethodBeat.o(133422);
            return -1;
        } catch (Throwable th) {
            WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcDBEnable, startPerformance);
            AppMethodBeat.o(133422);
            throw th;
        }
    }

    public final boolean blB(String str) {
        AppMethodBeat.i(133423);
        if (!isOpen()) {
            Log.e(this.TAG, "DB IS CLOSED ! {%s}", Util.getStack());
            AppMethodBeat.o(133423);
        } else {
            try {
                this.jNN.execSQL("DROP TABLE ".concat(String.valueOf(str)));
                AppMethodBeat.o(133423);
            } catch (Exception e2) {
                e.INSTANCE.idkeyStat(181, 11, 1, false);
                Log.e(this.TAG, "drop table Error :" + e2.getMessage());
                c.p(e2);
                AppMethodBeat.o(133423);
            }
        }
        return false;
    }

    @Override // com.tencent.mm.sdk.storage.ISQLiteDatabaseEx
    public synchronized long beginTransaction(long j2) {
        long j3 = -1;
        synchronized (this) {
            AppMethodBeat.i(133424);
            long id = Thread.currentThread().getId();
            Log.i(this.TAG, "beginTransaction thr:(%d,%d) ticket:%d db:%b", Long.valueOf(j2), Long.valueOf(id), Long.valueOf(this.oKR), Boolean.valueOf(isOpen()));
            if (!isOpen()) {
                Log.e(this.TAG, "DB IS CLOSED ! {%s}", Util.getStack());
                j3 = -4;
                AppMethodBeat.o(133424);
            } else if (this.oKR > 0) {
                Log.e(this.TAG, "ERROR beginTransaction transactionTicket:" + this.oKR);
                AppMethodBeat.o(133424);
            } else if (MMHandlerThread.isMainThread() || j2 != -1) {
                try {
                    c.begin();
                    this.jNN.beginTransaction();
                    c.a("beginTrans", null, 0);
                    this.oKR = Util.nowMilliSecond() & 2147483647L;
                    this.oKR |= (id & 2147483647L) << 32;
                    if (this.OtA != null) {
                        this.OtA.azY();
                    }
                    j3 = this.oKR;
                    AppMethodBeat.o(133424);
                } catch (Exception e2) {
                    e.INSTANCE.idkeyStat(181, 8, 1, false);
                    Log.e(this.TAG, "beginTransaction Error :" + e2.getMessage());
                    c.p(e2);
                    j3 = -3;
                    AppMethodBeat.o(133424);
                }
            } else {
                Log.e(this.TAG, "FORBID: beginTrans UNKNOW_THREAD ParamID:%d nowThr:%d", Long.valueOf(j2), Long.valueOf(id));
                j3 = -2;
                AppMethodBeat.o(133424);
            }
        }
        return j3;
    }

    @Override // com.tencent.mm.sdk.storage.ISQLiteDatabaseEx
    public synchronized int endTransaction(long j2) {
        int i2 = 0;
        synchronized (this) {
            AppMethodBeat.i(133425);
            long nowMilliSecond = Util.nowMilliSecond();
            long id = Thread.currentThread().getId();
            Log.i(this.TAG, "endTransaction thr:%d ticket:(%d,%d) db:%b", Long.valueOf(id), Long.valueOf(j2), Long.valueOf(this.oKR), Boolean.valueOf(isOpen()));
            if (!isOpen()) {
                Log.e(this.TAG, "DB IS CLOSED ! {%s}", Util.getStack());
                i2 = -4;
                AppMethodBeat.o(133425);
            } else if (j2 != this.oKR) {
                Log.e(this.TAG, "ERROR endTransaction ticket:" + j2 + " transactionTicket:" + this.oKR);
                i2 = -1;
                AppMethodBeat.o(133425);
            } else {
                long j3 = (j2 >> 32) & 2147483647L;
                if (j3 != id) {
                    Log.e(this.TAG, "FORBID: endTrans UNKNOW_THREAD ticket:%s ParamID:%d nowThr:%d", Long.toHexString(j2), Long.valueOf(j3), Long.valueOf(id));
                    i2 = -2;
                    AppMethodBeat.o(133425);
                } else {
                    try {
                        c.begin();
                        this.jNN.endTransaction();
                        Log.i(this.TAG, "endTransaction Succ Time:%d thr:%d ticket:(%d,%d) db:%b", Long.valueOf(Util.milliSecondsToNow(nowMilliSecond)), Long.valueOf(id), Long.valueOf(j2), Long.valueOf(this.oKR), Boolean.valueOf(isOpen()));
                        c.a("endTrans", null, 0);
                        this.oKR = 0;
                        if (this.OtA != null) {
                            this.OtA.azZ();
                        }
                        AppMethodBeat.o(133425);
                    } catch (Exception e2) {
                        Log.e(this.TAG, "endTransaction Error :" + e2.getMessage());
                        e.INSTANCE.idkeyStat(181, 9, 1, false);
                        c.p(e2);
                        i2 = -3;
                        AppMethodBeat.o(133425);
                    }
                }
            }
        }
        return i2;
    }

    @Override // com.tencent.mm.sdk.storage.ISQLiteDatabaseEx
    public void close() {
        AppMethodBeat.i(133426);
        this.jNN.close();
        AppMethodBeat.o(133426);
    }

    public final synchronized boolean inTransaction() {
        boolean z = false;
        synchronized (this) {
            AppMethodBeat.i(133427);
            if (!isOpen()) {
                Log.e(this.TAG, "DB IS CLOSED ! {%s}", Util.getStack());
                AppMethodBeat.o(133427);
            } else if (this.oKR > 0) {
                AppMethodBeat.o(133427);
                z = true;
            } else {
                AppMethodBeat.o(133427);
            }
        }
        return z;
    }
}
