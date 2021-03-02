package com.tencent.mm.storagebase;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.SharedPreferences;
import android.os.Looper;
import android.util.Pair;
import android.util.Printer;
import android.util.StringBuilderPrinter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.AppForegroundDelegate;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import com.tencent.wcdb.Cursor;
import com.tencent.wcdb.CursorIndexOutOfBoundsException;
import com.tencent.wcdb.CursorWindow;
import com.tencent.wcdb.CursorWrapper;
import com.tencent.wcdb.DatabaseErrorHandler;
import com.tencent.wcdb.DatabaseUtils;
import com.tencent.wcdb.database.SQLiteAsyncCheckpointer;
import com.tencent.wcdb.database.SQLiteCheckpointListener;
import com.tencent.wcdb.database.SQLiteCipherSpec;
import com.tencent.wcdb.database.SQLiteCursor;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wcdb.database.SQLiteDatabaseConfiguration;
import com.tencent.wcdb.database.SQLiteDebug;
import com.tencent.wcdb.database.SQLiteDirectCursor;
import com.tencent.wcdb.database.SQLiteException;
import com.tencent.wcdb.database.SQLiteGlobal;
import com.tencent.wcdb.database.SQLiteTrace;
import com.tencent.wcdb.support.LogPrinter;
import com.tencent.youtu.sdkkitframework.common.ErrorCode;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class f implements DatabaseErrorHandler, SQLiteTrace {
    private static Map<String, SQLiteDatabase> Otd = new HashMap();
    private static final SharedPreferences Ote;
    private static int Otf;
    private static final SQLiteCheckpointListener Otg;
    public static final a Oth = new a();
    private static SQLiteTrace Otl;
    private static com.tencent.mm.plugin.report.b Otm = new com.tencent.mm.plugin.report.b();
    private static final int[] Otn = {27, 39, 24, 36, 27, 39, 48, 54, 33, 45, 30, 42, 33, 45, 51, 57};
    private static final Pattern Oto = ((BuildInfo.IS_FLAVOR_RED || WeChatEnvironment.hasDebugger()) ? Pattern.compile("^\\s*create\\s+(?:unique\\s+)?index\\s+(?:if\\s+not\\s+exists\\s+)?(\\S+)\\s+on\\s+(\\S+)\\s*\\(", 66) : null);
    private static final String[] Otq = {"messagecreatetaklertimeindex", "messagecreatetaklertypetimeindex", "messagecreatetimeindex", "messageidindex", "messagemessagetalkerflagmsgseqindex", "messagemessagetalkermsgseqindex", "messagesendcreatetimeindex", "messagesvridindex", "messagetalkercreatetimeissendindex", "messagetalkeridtypeindex", "messagetalkerstatusindex", "messagetalkersvridindex", "messagetalkertypeindex"};
    private static final SQLiteCipherSpec qDP = new SQLiteCipherSpec().setPageSize(1024).setSQLCipherVersion(1);
    public SQLiteDatabase Otb = null;
    public SQLiteDatabase Otc = null;
    private boolean Oti = false;
    private boolean Otj = false;
    private volatile String Otk = "";
    private final HashMap<String, String> Otp;

    public f() {
        HashMap<String, String> hashMap = null;
        AppMethodBeat.i(197182);
        this.Otp = (BuildInfo.IS_FLAVOR_RED || WeChatEnvironment.hasDebugger()) ? new HashMap<>() : hashMap;
        AppMethodBeat.o(197182);
    }

    public static final class a {
        public SQLiteDatabase AYk;
        public String sql;
        public int status;
        public long time;

        /* access modifiers changed from: package-private */
        public final synchronized a gFE() {
            a aVar;
            AppMethodBeat.i(133348);
            aVar = new a();
            aVar.AYk = this.AYk;
            aVar.status = this.status;
            aVar.sql = this.sql;
            aVar.time = this.time;
            AppMethodBeat.o(133348);
            return aVar;
        }

        public final void a(SQLiteDatabase sQLiteDatabase, int i2, String str) {
            AppMethodBeat.i(133349);
            long currentTimeMillis = System.currentTimeMillis();
            synchronized (this) {
                try {
                    this.AYk = sQLiteDatabase;
                    this.status = i2;
                    this.sql = str;
                    this.time = currentTimeMillis;
                } finally {
                    AppMethodBeat.o(133349);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public final synchronized void gFF() {
            this.status = 0;
            this.time = 0;
        }
    }

    static {
        AppMethodBeat.i(133385);
        SQLiteGlobal.loadLib();
        SQLiteDebug.setIOTraceFlags(0);
        CursorWindow.windowSize(ErrorCode.YT_SDK_PARAM_ERROR);
        SharedPreferences sharedPreferences = MMApplicationContext.getContext().getSharedPreferences("db_config", 0);
        Ote = sharedPreferences;
        Otf = sharedPreferences.getInt("flags", 0);
        int i2 = Ote.getInt("acp", 100);
        Otg = new SQLiteAsyncCheckpointer(i2 >>> 16, i2 & 65535) {
            /* class com.tencent.mm.storagebase.f.AnonymousClass1 */

            @Override // com.tencent.wcdb.database.SQLiteAsyncCheckpointer
            public final void onCheckpointResult(SQLiteDatabase sQLiteDatabase, int i2, int i3, long j2) {
                AppMethodBeat.i(133345);
                int i4 = i2 == i3 ? 18 : 21;
                f.Otm.l(i4 + 1, i4 + 2, j2);
                Log.d("MicroMsg.MMDataBase", "Checkpointed, pages: %d/%d, time: %d, db: %s", Integer.valueOf(i3), Integer.valueOf(i2), Long.valueOf(j2), sQLiteDatabase.getPath());
                AppMethodBeat.o(133345);
            }
        };
        AppMethodBeat.o(133385);
    }

    public static boolean isMainThread() {
        AppMethodBeat.i(133360);
        if (Looper.myLooper() == Looper.getMainLooper()) {
            AppMethodBeat.o(133360);
            return true;
        }
        AppMethodBeat.o(133360);
        return false;
    }

    public static void a(SQLiteTrace sQLiteTrace) {
        Otl = sQLiteTrace;
    }

    public static void cf(Map<String, ?> map) {
        AppMethodBeat.i(133361);
        Map<String, ?> all = Ote.getAll();
        if (all == null || all.equals(map)) {
            AppMethodBeat.o(133361);
            return;
        }
        SharedPreferences.Editor edit = Ote.edit();
        for (Map.Entry<String, ?> entry : map.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (value instanceof Integer) {
                edit.putInt(key, ((Integer) value).intValue());
            } else if (value instanceof Long) {
                edit.putLong(key, ((Long) value).longValue());
            } else if (value instanceof Boolean) {
                edit.putBoolean(key, ((Boolean) value).booleanValue());
            } else if (value instanceof String) {
                edit.putString(key, value.toString());
            } else if (value instanceof Float) {
                edit.putFloat(key, ((Float) value).floatValue());
            }
        }
        edit.apply();
        AppMethodBeat.o(133361);
    }

    public static a gFz() {
        AppMethodBeat.i(133362);
        a gFE = Oth.gFE();
        AppMethodBeat.o(133362);
        return gFE;
    }

    /* access modifiers changed from: package-private */
    public static class b extends CursorWrapper {
        private String NSb;
        private int Otv;
        private long mCreateTime;

        public b(Cursor cursor, String str) {
            super(cursor);
            AppMethodBeat.i(133350);
            this.NSb = str;
            if (cursor instanceof SQLiteDirectCursor) {
                this.Otv = 2;
            } else if (cursor instanceof SQLiteCursor) {
                this.Otv = 1;
            } else {
                this.Otv = -1;
            }
            this.mCreateTime = System.nanoTime();
            AppMethodBeat.o(133350);
        }

        @Override // java.io.Closeable, com.tencent.wcdb.CursorWrapper, com.tencent.wcdb.Cursor, java.lang.AutoCloseable
        public final void close() {
            AppMethodBeat.i(133351);
            this.mCursor.close();
            long nanoTime = (System.nanoTime() - this.mCreateTime) / 1000;
            int i2 = -1;
            if (this.Otv == 1) {
                i2 = 0;
            } else if (this.Otv == 2) {
                i2 = 3;
            }
            if (i2 >= 0) {
                f.Otm.l(i2 + 1, i2 + 2, nanoTime);
            }
            AppMethodBeat.o(133351);
        }

        @Override // com.tencent.wcdb.CursorWrapper, com.tencent.wcdb.Cursor
        public final int getCount() {
            AppMethodBeat.i(133352);
            if (this.Otv == 2) {
                Log.w("MicroMsg.MMDataBase", "Slow operation: " + Util.stackTraceToString(new Throwable()));
            }
            int count = this.mCursor.getCount();
            AppMethodBeat.o(133352);
            return count;
        }

        @Override // com.tencent.wcdb.CursorWrapper, com.tencent.wcdb.Cursor
        public final double getDouble(int i2) {
            AppMethodBeat.i(133353);
            try {
                double d2 = super.getDouble(i2);
                AppMethodBeat.o(133353);
                return d2;
            } catch (CursorIndexOutOfBoundsException | IllegalStateException e2) {
                Log.printErrStackTrace("MicroMsg.MMDataBase", e2, "", new Object[0]);
                AppMethodBeat.o(133353);
                return 0.0d;
            }
        }

        @Override // com.tencent.wcdb.CursorWrapper, com.tencent.wcdb.Cursor
        public final float getFloat(int i2) {
            AppMethodBeat.i(133354);
            try {
                float f2 = super.getFloat(i2);
                AppMethodBeat.o(133354);
                return f2;
            } catch (CursorIndexOutOfBoundsException | IllegalStateException e2) {
                Log.printErrStackTrace("MicroMsg.MMDataBase", e2, "", new Object[0]);
                AppMethodBeat.o(133354);
                return 0.0f;
            }
        }

        @Override // com.tencent.wcdb.CursorWrapper, com.tencent.wcdb.Cursor
        public final int getInt(int i2) {
            AppMethodBeat.i(133355);
            try {
                int i3 = super.getInt(i2);
                AppMethodBeat.o(133355);
                return i3;
            } catch (CursorIndexOutOfBoundsException | IllegalStateException e2) {
                Log.printErrStackTrace("MicroMsg.MMDataBase", e2, "", new Object[0]);
                AppMethodBeat.o(133355);
                return 0;
            }
        }

        @Override // com.tencent.wcdb.CursorWrapper, com.tencent.wcdb.Cursor
        public final long getLong(int i2) {
            AppMethodBeat.i(133356);
            try {
                long j2 = super.getLong(i2);
                AppMethodBeat.o(133356);
                return j2;
            } catch (CursorIndexOutOfBoundsException | IllegalStateException e2) {
                Log.printErrStackTrace("MicroMsg.MMDataBase", e2, "", new Object[0]);
                AppMethodBeat.o(133356);
                return 0;
            }
        }

        @Override // com.tencent.wcdb.CursorWrapper, com.tencent.wcdb.Cursor
        public final short getShort(int i2) {
            AppMethodBeat.i(133357);
            try {
                short s = super.getShort(i2);
                AppMethodBeat.o(133357);
                return s;
            } catch (CursorIndexOutOfBoundsException | IllegalStateException e2) {
                Log.printErrStackTrace("MicroMsg.MMDataBase", e2, "", new Object[0]);
                AppMethodBeat.o(133357);
                return 0;
            }
        }

        @Override // com.tencent.wcdb.CursorWrapper, com.tencent.wcdb.Cursor
        public final String getString(int i2) {
            AppMethodBeat.i(133358);
            try {
                String string = super.getString(i2);
                AppMethodBeat.o(133358);
                return string;
            } catch (CursorIndexOutOfBoundsException | IllegalStateException e2) {
                Log.printErrStackTrace("MicroMsg.MMDataBase", e2, "", new Object[0]);
                AppMethodBeat.o(133358);
                return null;
            }
        }

        @Override // com.tencent.wcdb.CursorWrapper, com.tencent.wcdb.Cursor
        public final byte[] getBlob(int i2) {
            AppMethodBeat.i(133359);
            try {
                byte[] blob = super.getBlob(i2);
                AppMethodBeat.o(133359);
                return blob;
            } catch (CursorIndexOutOfBoundsException | IllegalStateException e2) {
                Log.printErrStackTrace("MicroMsg.MMDataBase", e2, "", new Object[0]);
                AppMethodBeat.o(133359);
                return null;
            }
        }
    }

    @SuppressLint({"DefaultLocale"})
    private static String gFA() {
        AppMethodBeat.i(133363);
        int i2 = Ote.getInt("acp", 100);
        String format = String.format("flags: 0x%04x\nacp: %d / %d", Integer.valueOf(Ote.getInt("flags", 0)), Integer.valueOf(i2 >>> 16), Integer.valueOf(i2 & 65535));
        AppMethodBeat.o(133363);
        return format;
    }

    static void bly(String str) {
        AppMethodBeat.i(133364);
        o oVar = new o(str);
        o heq = oVar.heq();
        String name = oVar.getName();
        o oVar2 = new o(oVar.heq(), "corrupted");
        oVar2.mkdirs();
        String[] strArr = {"", "-journal", "-wal", ".ini", ".bak", ".sm", "-vfslog", "-vfslo1"};
        for (int i2 = 0; i2 < 8; i2++) {
            String str2 = strArr[i2];
            new o(heq, name + str2).am(new o(oVar2, name + str2));
        }
        AppMethodBeat.o(133364);
    }

    @Override // com.tencent.wcdb.DatabaseErrorHandler
    public final void onCorruption(SQLiteDatabase sQLiteDatabase) {
        int i2;
        AppMethodBeat.i(133365);
        boolean isOpen = sQLiteDatabase.isOpen();
        String path = sQLiteDatabase.getPath();
        Log.e("MicroMsg.MMDataBase", "Database corrupted, isOpen: %s, path: %s", Boolean.toString(isOpen), path);
        if (!this.Otj) {
            this.Otj = true;
            int lastErrorLine = SQLiteDebug.getLastErrorLine();
            String format = String.format("%s (line: %d, open: %s)\n%s", new o(sQLiteDatabase.getPath()).getName(), Integer.valueOf(lastErrorLine), Boolean.toString(sQLiteDatabase.isOpen()), gFA());
            HashMap hashMap = new HashMap();
            hashMap.put("fileSystem", b.gFt());
            e.INSTANCE.e("DBCorrupt", format, hashMap);
        }
        List<Pair<String, String>> attachedDbs = sQLiteDatabase.getAttachedDbs();
        if (!isOpen) {
            AppMethodBeat.o(133365);
            return;
        }
        try {
            if (!sQLiteDatabase.isWriteAheadLoggingEnabled()) {
                i2 = 42;
            } else if (sQLiteDatabase.getAsyncCheckpointEnabled()) {
                i2 = 43;
            } else {
                i2 = 41;
            }
            e.INSTANCE.idkeyStat(181, (long) i2, 1, true);
            sQLiteDatabase.close();
            if (attachedDbs == null) {
                bly(path);
                AppMethodBeat.o(133365);
                return;
            }
            for (Pair<String, String> pair : attachedDbs) {
                bly((String) pair.second);
            }
            AppMethodBeat.o(133365);
        } catch (Exception e2) {
            AppMethodBeat.o(133365);
        }
    }

    @Override // com.tencent.wcdb.database.SQLiteTrace
    public final void onSQLExecuted(SQLiteDatabase sQLiteDatabase, String str, int i2, long j2) {
        String put;
        AppMethodBeat.i(133366);
        if (sQLiteDatabase.getPath().endsWith("EnMicroMsg.db")) {
            int i3 = Otn[(sQLiteDatabase.isWriteAheadLoggingEnabled() ? 2 : 0) + (sQLiteDatabase.getAsyncCheckpointEnabled() ? 4 : 0) + (i2 != 1 ? 8 : 0)];
            Otm.l(i3 + 1, i3 + 2, (long) ((int) j2));
        }
        if (Otl != null) {
            Otl.onSQLExecuted(sQLiteDatabase, str, i2, j2);
        }
        if (isMainThread()) {
            Oth.gFF();
        }
        if (this.Otp != null && i2 == 8) {
            Matcher matcher = Oto.matcher(str);
            if (matcher.find()) {
                String group = matcher.group(1);
                String group2 = matcher.group(2);
                synchronized (this.Otp) {
                    try {
                        put = this.Otp.put(group, str);
                        if (put == null || put.equals(str)) {
                            put = null;
                        } else {
                            this.Otp.put(group, put);
                        }
                    } catch (Throwable th) {
                        AppMethodBeat.o(133366);
                        throw th;
                    }
                }
                if (put != null) {
                    AssertionError assertionError = new AssertionError(String.format("Duplicated index created: %s, SQL: %s, existing: %s", group, str, put));
                    AppMethodBeat.o(133366);
                    throw assertionError;
                } else if (group2.equalsIgnoreCase("message") && Arrays.binarySearch(Otq, group.toLowerCase()) < 0) {
                    AssertionError assertionError2 = new AssertionError(String.format("New index for message table found: %s, SQL: %s", group, str));
                    AppMethodBeat.o(133366);
                    throw assertionError2;
                }
            }
        }
        AppMethodBeat.o(133366);
    }

    @Override // com.tencent.wcdb.database.SQLiteTrace
    public final void onConnectionObtained(SQLiteDatabase sQLiteDatabase, String str, long j2, boolean z) {
        int i2;
        int i3;
        int i4 = 0;
        AppMethodBeat.i(133367);
        if (sQLiteDatabase.getPath().endsWith("EnMicroMsg.db")) {
            int i5 = sQLiteDatabase.isWriteAheadLoggingEnabled() ? 2 : 0;
            if (sQLiteDatabase.getAsyncCheckpointEnabled()) {
                i2 = 4;
            } else {
                i2 = 0;
            }
            if (z) {
                i3 = 8;
            } else {
                i3 = 0;
            }
            int i6 = Otn[i5 + i2 + i3 + 1];
            Otm.l(i6 + 1, i6 + 2, (long) ((int) j2));
        }
        if (isMainThread()) {
            a aVar = Oth;
            if (z) {
                i4 = 32768;
            }
            aVar.a(sQLiteDatabase, i4 | 3, str);
        }
        AppMethodBeat.o(133367);
    }

    @Override // com.tencent.wcdb.database.SQLiteTrace
    @SuppressLint({"DefaultLocale"})
    public final void onConnectionPoolBusy(SQLiteDatabase sQLiteDatabase, String str, long j2, boolean z, List<SQLiteTrace.TraceInfo<String>> list, List<SQLiteTrace.TraceInfo<StackTraceElement[]>> list2) {
        AppMethodBeat.i(133368);
        if (isMainThread()) {
            Oth.a(sQLiteDatabase, (z ? 32768 : 0) | 2, str);
        }
        String name = new o(sQLiteDatabase.getPath()).getName();
        long currentTimeMillis = System.currentTimeMillis();
        final StringBuilder sb = new StringBuilder(2048);
        sb.append(name).append("\n");
        if (list != null && !list.isEmpty()) {
            for (SQLiteTrace.TraceInfo<String> traceInfo : list) {
                sb.append("[RUNNING] ").append((String) traceInfo.info).append('\n');
            }
            sb.append('\n');
        }
        if (list2 != null && !list2.isEmpty()) {
            for (SQLiteTrace.TraceInfo<StackTraceElement[]> traceInfo2 : list2) {
                sb.append("[TRANSACTION]\n");
                for (StackTraceElement stackTraceElement : (StackTraceElement[]) traceInfo2.info) {
                    sb.append("  at ").append(stackTraceElement.toString()).append('\n');
                }
                sb.append('\n');
            }
        }
        String sb2 = sb.toString();
        if (this.Otk.equals(sb2)) {
            AppMethodBeat.o(133368);
            return;
        }
        Log.w("MicroMsg.MMDataBase", "Database connection pool busy: ".concat(String.valueOf(name)));
        Log.w("MicroMsg.MMDataBase", "[REQUEST primary: " + z + "] " + str);
        if (list != null && !list.isEmpty()) {
            for (SQLiteTrace.TraceInfo<String> traceInfo3 : list) {
                Log.w("MicroMsg.MMDataBase", "[RUNNING tid: %d (%d ms)] %s", Integer.valueOf(traceInfo3.tid), Long.valueOf(currentTimeMillis - traceInfo3.time), traceInfo3.info);
            }
            sb.append('\n');
        }
        if (list2 != null && !list2.isEmpty()) {
            for (SQLiteTrace.TraceInfo<StackTraceElement[]> traceInfo4 : list2) {
                sb.setLength(0);
                sb.append(String.format("[TRANSACTION tid: %d (%d ms)]\n", Integer.valueOf(traceInfo4.tid), Long.valueOf(currentTimeMillis - traceInfo4.time)));
                for (StackTraceElement stackTraceElement2 : (StackTraceElement[]) traceInfo4.info) {
                    sb.append("  at ").append(stackTraceElement2.toString()).append('\n');
                }
                sb.append('\n');
                Log.w("MicroMsg.MMDataBase", sb.toString());
            }
        }
        sb.setLength(0);
        sQLiteDatabase.dump(new Printer() {
            /* class com.tencent.mm.storagebase.f.AnonymousClass2 */
            final Printer Otr = new StringBuilderPrinter(sb);
            final Printer Ots = new LogPrinter(5, "MicroMsg.MMDataBase");

            {
                AppMethodBeat.i(133346);
                AppMethodBeat.o(133346);
            }

            public final void println(String str) {
                AppMethodBeat.i(133347);
                this.Otr.println(str);
                this.Ots.println(str);
                AppMethodBeat.o(133347);
            }
        }, false);
        String sb3 = sb.toString();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("SQL", str);
        linkedHashMap.put("dump", sb3);
        linkedHashMap.put("settings", gFA());
        e.INSTANCE.e("DBPoolBusy", sb2, linkedHashMap);
        this.Otk = sb2;
        e.INSTANCE.idkeyStat(463, 6, 1, false);
        try {
            StringBuilder sb4 = new StringBuilder();
            if (list == null) {
                AppMethodBeat.o(133368);
                return;
            }
            for (SQLiteTrace.TraceInfo<String> traceInfo5 : list) {
                sb4.append((String) traceInfo5.info);
            }
            boolean z2 = AppForegroundDelegate.INSTANCE.cPB;
            boolean isMainThread = isMainThread();
            e eVar = e.INSTANCE;
            Object[] objArr = new Object[7];
            objArr[0] = str;
            objArr[1] = Long.valueOf(j2);
            objArr[2] = Integer.valueOf(z ? 1 : 0);
            objArr[3] = sb4.toString();
            objArr[4] = Integer.valueOf(z2 ? 1 : 0);
            objArr[5] = Integer.valueOf(isMainThread ? 1 : 0);
            objArr[6] = name;
            eVar.a(20584, objArr);
            AppMethodBeat.o(133368);
        } catch (Throwable th) {
            Log.e("MicroMsg.MMDataBase", "report db busy failed = " + th.getMessage());
            AppMethodBeat.o(133368);
        }
    }

    @Override // com.tencent.wcdb.database.SQLiteTrace
    public final void onDatabaseCorrupted(SQLiteDatabase sQLiteDatabase) {
    }

    public static f dk(String str, boolean z) {
        AppMethodBeat.i(133369);
        f fVar = new f();
        if (str == null || str.length() == 0) {
            fVar.Otc = SQLiteDatabase.create(null);
            fVar.Oti = true;
            if (fVar.Otc == null) {
                AppMethodBeat.o(133369);
                return null;
            }
            AppMethodBeat.o(133369);
            return fVar;
        }
        int i2 = 268435456;
        if (z && b.OsW) {
            i2 = 805306368;
        } else if (!b.OsW) {
            s.deleteFile(str + "-shm");
        }
        try {
            fVar.Otc = SQLiteDatabase.openDatabase(str, null, i2, fVar);
            fVar.Otc.setTraceCallback(fVar);
            if (gFC()) {
                fVar.Otc.setCheckpointCallback(Otg);
                Log.i("MicroMsg.MMDataBase", "Enable async checkpointer for DB: " + fVar.getPath());
            }
            if (BuildInfo.ext.getBoolean("ENABLE_STETHO")) {
                Otd.put(fVar.getPath(), fVar.Otc);
            }
            if (fVar.Otc == null) {
                AppMethodBeat.o(133369);
                return null;
            }
            AppMethodBeat.o(133369);
            return fVar;
        } catch (SQLiteException e2) {
            e.INSTANCE.e("DBCantOpen", "DB (" + new o(str).getName() + ") can't open: " + Util.stackTraceToString(e2), null);
            AppMethodBeat.o(133369);
            throw e2;
        }
    }

    public final String getPath() {
        AppMethodBeat.i(133370);
        if (this.Otb != null) {
            String path = this.Otb.getPath();
            AppMethodBeat.o(133370);
            return path;
        }
        String path2 = this.Otc.getPath();
        AppMethodBeat.o(133370);
        return path2;
    }

    public static boolean gFB() {
        return true;
    }

    public static boolean gFC() {
        return (Otf & 8) != 0;
    }

    public static f E(String str, String str2, boolean z) {
        String str3;
        byte[] bytes;
        SQLiteCipherSpec sQLiteCipherSpec;
        AppMethodBeat.i(133371);
        try {
            o oVar = new o(str + "-vfslog");
            o oVar2 = new o(str + "-vfslo1");
            if (oVar.exists() && oVar.length() > 256) {
                oVar.delete();
            }
            if (oVar2.exists() && oVar2.length() > 256) {
                oVar2.delete();
            }
        } catch (Throwable th) {
            Log.printErrStackTrace("MicroMsg.MMDataBase", th, "", new Object[0]);
        }
        f fVar = new f();
        int i2 = 268435456;
        if (Util.isNullOrNil(str)) {
            str3 = SQLiteDatabaseConfiguration.MEMORY_DB_PATH;
            fVar.Oti = true;
        } else {
            str3 = str;
        }
        if (Util.isNullOrNil(str2)) {
            sQLiteCipherSpec = null;
            bytes = null;
        } else {
            bytes = str2.getBytes();
            sQLiteCipherSpec = qDP;
        }
        if (z && b.OsW) {
            i2 = 805306368;
        } else if (!b.OsW) {
            s.deleteFile(str + "-shm");
        }
        try {
            if (str3.endsWith("EnMicroMsg.db")) {
                fVar.Otb = SQLiteDatabase.openDatabase(str3, bytes, sQLiteCipherSpec, null, i2, fVar, 8);
            } else {
                fVar.Otb = SQLiteDatabase.openDatabase(str3, bytes, sQLiteCipherSpec, null, i2, fVar);
            }
            fVar.Otb.setTraceCallback(fVar);
            if (gFC()) {
                fVar.Otb.setCheckpointCallback(Otg);
                Log.i("MicroMsg.MMDataBase", "Enable async checkpointer for DB: " + fVar.getPath());
            }
            if (BuildInfo.ext.getBoolean("ENABLE_STETHO")) {
                Otd.put(fVar.getPath(), fVar.Otb);
            }
            if (fVar.Otb == null) {
                AppMethodBeat.o(133371);
                return null;
            }
            AppMethodBeat.o(133371);
            return fVar;
        } catch (SQLiteException e2) {
            e.INSTANCE.e("DBCantOpen", "DB (" + new o(str3).getName() + ") can't open: " + Util.stackTraceToString(e2), null);
            AppMethodBeat.o(133371);
            throw e2;
        }
    }

    public final boolean isOpen() {
        AppMethodBeat.i(133372);
        if (this.Otb != null) {
            boolean isOpen = this.Otb.isOpen();
            AppMethodBeat.o(133372);
            return isOpen;
        } else if (this.Otc != null) {
            boolean isOpen2 = this.Otc.isOpen();
            AppMethodBeat.o(133372);
            return isOpen2;
        } else {
            AppMethodBeat.o(133372);
            return false;
        }
    }

    public final void close() {
        AppMethodBeat.i(133373);
        try {
            if (this.Otb != null && this.Otb.isOpen()) {
                this.Otb.close();
                this.Otb = null;
            }
            if (this.Otc != null && this.Otc.isOpen()) {
                this.Otc.close();
                this.Otc = null;
            }
            AppMethodBeat.o(133373);
        } catch (Exception e2) {
            Log.e("MicroMsg.MMDataBase", "exception:%s", Util.stackTraceToString(e2));
            AppMethodBeat.o(133373);
        }
    }

    public final android.database.Cursor rawQuery(String str, String[] strArr, int i2) {
        boolean z;
        SQLiteDatabase.CursorFactory cursorFactory;
        Cursor cursor;
        boolean z2 = true;
        int i3 = 0;
        AppMethodBeat.i(133374);
        SQLiteDatabase sQLiteDatabase = this.Otb != null ? this.Otb : this.Otc;
        if ((Otf & 2) != 0) {
            z = true;
        } else {
            z = false;
        }
        if (i2 == 4) {
            cursorFactory = com.tencent.mm.storagebase.a.f.FACTORY;
        } else if (i2 == 100) {
            cursorFactory = SQLiteDirectCursor.FACTORY;
        } else if (CrashReportFactory.hasDebuger() || z) {
            switch (i2) {
                case 0:
                    cursorFactory = null;
                    break;
                case 1:
                    cursorFactory = SQLiteCursor.FACTORY;
                    break;
                case 2:
                    cursorFactory = SQLiteDirectCursor.FACTORY;
                    break;
                case 3:
                    cursorFactory = null;
                    break;
                default:
                    cursorFactory = null;
                    break;
            }
        } else {
            cursorFactory = null;
        }
        if (isMainThread()) {
            if (DatabaseUtils.getSqlStatementType(str) != 1) {
                z2 = false;
            }
            a aVar = Oth;
            if (z2) {
                i3 = 32768;
            }
            aVar.a(sQLiteDatabase, i3 | 1, str);
        }
        Cursor rawQueryWithFactory = sQLiteDatabase.rawQueryWithFactory(cursorFactory, str, strArr, null);
        if (i2 == 0 || i2 == 4) {
            cursor = rawQueryWithFactory;
        } else {
            cursor = new b(rawQueryWithFactory, str);
        }
        AppMethodBeat.o(133374);
        return cursor;
    }

    public final void execSQL(String str) {
        AppMethodBeat.i(133375);
        SQLiteDatabase sQLiteDatabase = this.Otb != null ? this.Otb : this.Otc;
        if (isMainThread()) {
            Oth.a(sQLiteDatabase, 32769, str);
        }
        sQLiteDatabase.execSQL(str);
        AppMethodBeat.o(133375);
    }

    public final android.database.Cursor query(String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, int i2, String str6) {
        Cursor cursor;
        AppMethodBeat.i(197183);
        SQLiteDatabase sQLiteDatabase = this.Otb != null ? this.Otb : this.Otc;
        boolean z = (Otf & 2) != 0;
        SQLiteDatabase.CursorFactory cursorFactory = null;
        if (i2 != 4) {
            if (i2 != 100) {
                if (CrashReportFactory.hasDebuger() || z) {
                    switch (i2) {
                        case 0:
                            cursorFactory = null;
                            break;
                        case 1:
                            cursorFactory = SQLiteCursor.FACTORY;
                            break;
                        case 2:
                            cursorFactory = SQLiteDirectCursor.FACTORY;
                            break;
                        case 3:
                            cursorFactory = null;
                            break;
                        default:
                            cursorFactory = null;
                            break;
                    }
                }
            } else {
                cursorFactory = SQLiteDirectCursor.FACTORY;
            }
        } else {
            cursorFactory = com.tencent.mm.storagebase.a.f.FACTORY;
        }
        if (isMainThread()) {
            Oth.a(sQLiteDatabase, 1, str);
        }
        Cursor queryWithFactory = sQLiteDatabase.queryWithFactory(cursorFactory, false, str, strArr, str2, strArr2, str3, str4, str5, str6);
        if (i2 != 4) {
            cursor = new b(queryWithFactory, str);
        } else {
            cursor = queryWithFactory;
        }
        AppMethodBeat.o(197183);
        return cursor;
    }

    public final long insert(String str, String str2, ContentValues contentValues) {
        AppMethodBeat.i(133377);
        SQLiteDatabase sQLiteDatabase = this.Otb != null ? this.Otb : this.Otc;
        if (isMainThread()) {
            Oth.a(sQLiteDatabase, 32769, str);
        }
        long insert = sQLiteDatabase.insert(str, str2, contentValues);
        AppMethodBeat.o(133377);
        return insert;
    }

    public final int update(String str, ContentValues contentValues, String str2, String[] strArr) {
        AppMethodBeat.i(133379);
        SQLiteDatabase sQLiteDatabase = this.Otb != null ? this.Otb : this.Otc;
        if (isMainThread()) {
            Oth.a(sQLiteDatabase, 32769, str);
        }
        int update = sQLiteDatabase.update(str, contentValues, str2, strArr);
        AppMethodBeat.o(133379);
        return update;
    }

    public final long replace(String str, String str2, ContentValues contentValues) {
        AppMethodBeat.i(133380);
        SQLiteDatabase sQLiteDatabase = this.Otb != null ? this.Otb : this.Otc;
        if (isMainThread()) {
            Oth.a(sQLiteDatabase, 32769, str);
        }
        long replace = sQLiteDatabase.replace(str, str2, contentValues);
        AppMethodBeat.o(133380);
        return replace;
    }

    public final int delete(String str, String str2, String[] strArr) {
        AppMethodBeat.i(133381);
        SQLiteDatabase sQLiteDatabase = this.Otb != null ? this.Otb : this.Otc;
        if (isMainThread()) {
            Oth.a(sQLiteDatabase, 32769, str);
        }
        int delete = sQLiteDatabase.delete(str, str2, strArr);
        AppMethodBeat.o(133381);
        return delete;
    }

    public final void beginTransaction() {
        AppMethodBeat.i(133382);
        SQLiteDatabase sQLiteDatabase = this.Otb != null ? this.Otb : this.Otc;
        if (isMainThread()) {
            Oth.a(sQLiteDatabase, 32769, "BEGIN TRANSACTION;");
        }
        try {
            sQLiteDatabase.beginTransaction();
            AppMethodBeat.o(133382);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.MMDataBase", e2, "", new Object[0]);
            AppMethodBeat.o(133382);
        }
    }

    public final void endTransaction() {
        AppMethodBeat.i(133383);
        SQLiteDatabase sQLiteDatabase = this.Otb != null ? this.Otb : this.Otc;
        if (isMainThread()) {
            Oth.a(sQLiteDatabase, 32769, "COMMIT;");
        }
        try {
            sQLiteDatabase.setTransactionSuccessful();
            sQLiteDatabase.endTransaction();
            AppMethodBeat.o(133383);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.MMDataBase", e2, "", new Object[0]);
            AppMethodBeat.o(133383);
        }
    }

    public static boolean a(f fVar, String str) {
        AppMethodBeat.i(133384);
        if (fVar == null || str == null) {
            Object[] objArr = new Object[2];
            objArr[0] = Boolean.valueOf(fVar == null);
            objArr[1] = str;
            Log.e("MicroMsg.MMDataBase", "[arthurdan.checkTableExist] Notice!!! null == db: %b, table: %s", objArr);
            AppMethodBeat.o(133384);
            return false;
        }
        android.database.Cursor rawQuery = fVar.rawQuery("select tbl_name from sqlite_master  where type = \"table\" and tbl_name=\"" + str + "\"", null, 0);
        if (rawQuery == null) {
            AppMethodBeat.o(133384);
            return false;
        }
        int count = rawQuery.getCount();
        rawQuery.close();
        if (count > 0) {
            AppMethodBeat.o(133384);
            return true;
        }
        AppMethodBeat.o(133384);
        return false;
    }
}
