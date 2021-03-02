package com.tencent.wcdb.support;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.wcdb.DatabaseErrorHandler;
import com.tencent.wcdb.FileUtils;
import com.tencent.wcdb.database.SQLiteCipherSpec;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wcdb.database.SQLiteGlobal;
import com.tencent.wxmm.v2helper;
import java.io.File;

public final class Context {
    public static final int MODE_ENABLE_WRITE_AHEAD_LOGGING = 8;

    static {
        AppMethodBeat.i(3393);
        SQLiteGlobal.loadLib();
        AppMethodBeat.o(3393);
    }

    private static File getDataDirFile(android.content.Context context) {
        AppMethodBeat.i(3383);
        if (context != null) {
            String str = context.getApplicationInfo().dataDir;
            if (str != null) {
                File file = new File(str);
                AppMethodBeat.o(3383);
                return file;
            }
            AppMethodBeat.o(3383);
            return null;
        }
        RuntimeException runtimeException = new RuntimeException("Not supported in system context");
        AppMethodBeat.o(3383);
        throw runtimeException;
    }

    private static File getDatabasesDir(android.content.Context context) {
        AppMethodBeat.i(3384);
        File file = new File(getDataDirFile(context), "databases");
        if (file.getPath().equals("databases")) {
            file = new File("/data/system");
        }
        AppMethodBeat.o(3384);
        return file;
    }

    private static File makeFilename(File file, String str) {
        AppMethodBeat.i(3385);
        if (str.indexOf(File.separatorChar) < 0) {
            File file2 = new File(file, str);
            AppMethodBeat.o(3385);
            return file2;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("File " + str + " contains a path separator");
        AppMethodBeat.o(3385);
        throw illegalArgumentException;
    }

    private static File validateFilePath(android.content.Context context, String str, boolean z) {
        File databasesDir;
        File makeFilename;
        AppMethodBeat.i(3386);
        if (str.charAt(0) == File.separatorChar) {
            databasesDir = new File(str.substring(0, str.lastIndexOf(File.separatorChar)));
            makeFilename = new File(databasesDir, str.substring(str.lastIndexOf(File.separatorChar)));
        } else {
            databasesDir = getDatabasesDir(context);
            makeFilename = makeFilename(databasesDir, str);
        }
        if (z && !databasesDir.isDirectory() && databasesDir.mkdir()) {
            FileUtils.setPermissions(databasesDir.getPath(), 505, -1, -1);
        }
        AppMethodBeat.o(3386);
        return makeFilename;
    }

    private static void setFilePermissionsFromMode(String str, int i2, int i3) {
        AppMethodBeat.i(3387);
        int i4 = i3 | v2helper.EMethodSetSendToNetworkOn;
        if ((i2 & 1) != 0) {
            i4 |= 4;
        }
        if ((i2 & 2) != 0) {
            i4 |= 2;
        }
        FileUtils.setPermissions(str, i4, -1, -1);
        AppMethodBeat.o(3387);
    }

    public static SQLiteDatabase openOrCreateDatabase(android.content.Context context, String str, int i2, SQLiteDatabase.CursorFactory cursorFactory) {
        AppMethodBeat.i(3388);
        SQLiteDatabase openOrCreateDatabase = openOrCreateDatabase(context, str, null, null, i2, cursorFactory, null, 0);
        AppMethodBeat.o(3388);
        return openOrCreateDatabase;
    }

    public static SQLiteDatabase openOrCreateDatabase(android.content.Context context, String str, int i2, SQLiteDatabase.CursorFactory cursorFactory, DatabaseErrorHandler databaseErrorHandler) {
        AppMethodBeat.i(3389);
        SQLiteDatabase openOrCreateDatabase = openOrCreateDatabase(context, str, null, null, i2, cursorFactory, databaseErrorHandler, 0);
        AppMethodBeat.o(3389);
        return openOrCreateDatabase;
    }

    public static SQLiteDatabase openOrCreateDatabase(android.content.Context context, String str, byte[] bArr, SQLiteCipherSpec sQLiteCipherSpec, int i2, SQLiteDatabase.CursorFactory cursorFactory) {
        AppMethodBeat.i(3390);
        SQLiteDatabase openOrCreateDatabase = openOrCreateDatabase(context, str, bArr, sQLiteCipherSpec, i2, cursorFactory, null, 0);
        AppMethodBeat.o(3390);
        return openOrCreateDatabase;
    }

    public static SQLiteDatabase openOrCreateDatabase(android.content.Context context, String str, byte[] bArr, SQLiteCipherSpec sQLiteCipherSpec, int i2, SQLiteDatabase.CursorFactory cursorFactory, DatabaseErrorHandler databaseErrorHandler) {
        AppMethodBeat.i(3391);
        SQLiteDatabase openOrCreateDatabase = openOrCreateDatabase(context, str, bArr, sQLiteCipherSpec, i2, cursorFactory, databaseErrorHandler, 0);
        AppMethodBeat.o(3391);
        return openOrCreateDatabase;
    }

    public static SQLiteDatabase openOrCreateDatabase(android.content.Context context, String str, byte[] bArr, SQLiteCipherSpec sQLiteCipherSpec, int i2, SQLiteDatabase.CursorFactory cursorFactory, DatabaseErrorHandler databaseErrorHandler, int i3) {
        AppMethodBeat.i(3392);
        File validateFilePath = validateFilePath(context, str, true);
        int i4 = 268435456;
        if ((i2 & 8) != 0) {
            i4 = 805306368;
        }
        SQLiteDatabase openDatabase = SQLiteDatabase.openDatabase(validateFilePath.getPath(), bArr, sQLiteCipherSpec, cursorFactory, i4, databaseErrorHandler, i3);
        setFilePermissionsFromMode(validateFilePath.getPath(), i2, 0);
        AppMethodBeat.o(3392);
        return openDatabase;
    }
}
