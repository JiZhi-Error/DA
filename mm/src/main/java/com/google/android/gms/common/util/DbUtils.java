package com.google.android.gms.common.util;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import com.tencent.sqlitelint.config.SharePluginInfo;
import java.io.File;
import java.nio.charset.Charset;
import javax.annotation.Nullable;

public final class DbUtils {
    private DbUtils() {
    }

    public static void clearDatabase(SQLiteDatabase sQLiteDatabase) {
        AppMethodBeat.i(5171);
        zza(sQLiteDatabase, SharePluginInfo.ISSUE_KEY_TABLE, "sqlite_sequence", "android_metadata");
        zza(sQLiteDatabase, "trigger", new String[0]);
        zza(sQLiteDatabase, "view", new String[0]);
        AppMethodBeat.o(5171);
    }

    public static long countCurrentRowBytes(Cursor cursor) {
        AppMethodBeat.i(5184);
        long countCurrentRowBytes = countCurrentRowBytes(cursor, Charset.forName(MimeTypeUtil.ContentType.DEFAULT_CHARSET));
        AppMethodBeat.o(5184);
        return countCurrentRowBytes;
    }

    public static long countCurrentRowBytes(Cursor cursor, Charset charset) {
        AppMethodBeat.i(5183);
        long j2 = 0;
        for (int i2 = 0; i2 < cursor.getColumnCount(); i2++) {
            switch (cursor.getType(i2)) {
                case 0:
                case 1:
                case 2:
                    j2 += 4;
                    break;
                case 3:
                    j2 += (long) cursor.getString(i2).getBytes(charset).length;
                    break;
                case 4:
                    j2 += (long) cursor.getBlob(i2).length;
                    break;
            }
        }
        AppMethodBeat.o(5183);
        return j2;
    }

    public static long getDatabaseSize(Context context, String str) {
        AppMethodBeat.i(5182);
        try {
            File databasePath = context.getDatabasePath(str);
            if (databasePath != null) {
                long length = databasePath.length();
                AppMethodBeat.o(5182);
                return length;
            }
        } catch (SecurityException e2) {
            String valueOf = String.valueOf(str);
            if (valueOf.length() != 0) {
                "Failed to get db size for ".concat(valueOf);
            } else {
                new String("Failed to get db size for ");
            }
        }
        AppMethodBeat.o(5182);
        return 0;
    }

    @Nullable
    public static Integer getIntegerFromCursor(Cursor cursor, int i2) {
        AppMethodBeat.i(5174);
        Integer integerFromCursor = getIntegerFromCursor(cursor, i2, null);
        AppMethodBeat.o(5174);
        return integerFromCursor;
    }

    @Nullable
    public static Integer getIntegerFromCursor(Cursor cursor, int i2, @Nullable Integer num) {
        AppMethodBeat.i(5173);
        if (i2 < 0 || cursor.isNull(i2)) {
            AppMethodBeat.o(5173);
            return num;
        }
        Integer valueOf = Integer.valueOf(cursor.getInt(i2));
        AppMethodBeat.o(5173);
        return valueOf;
    }

    @Nullable
    public static Long getLongFromCursor(Cursor cursor, int i2) {
        AppMethodBeat.i(5176);
        Long longFromCursor = getLongFromCursor(cursor, i2, null);
        AppMethodBeat.o(5176);
        return longFromCursor;
    }

    @Nullable
    public static Long getLongFromCursor(Cursor cursor, int i2, @Nullable Long l) {
        AppMethodBeat.i(5175);
        if (i2 < 0 || cursor.isNull(i2)) {
            AppMethodBeat.o(5175);
            return l;
        }
        Long valueOf = Long.valueOf(cursor.getLong(i2));
        AppMethodBeat.o(5175);
        return valueOf;
    }

    @Nullable
    public static String getStringFromCursor(Cursor cursor, int i2) {
        AppMethodBeat.i(5178);
        String stringFromCursor = getStringFromCursor(cursor, i2, null);
        AppMethodBeat.o(5178);
        return stringFromCursor;
    }

    @Nullable
    public static String getStringFromCursor(Cursor cursor, int i2, @Nullable String str) {
        AppMethodBeat.i(5177);
        if (i2 < 0 || cursor.isNull(i2)) {
            AppMethodBeat.o(5177);
            return str;
        }
        String string = cursor.getString(i2);
        AppMethodBeat.o(5177);
        return string;
    }

    public static void putIntegerIntoContentValues(ContentValues contentValues, String str, @Nullable Integer num) {
        AppMethodBeat.i(5179);
        if (num != null) {
            contentValues.put(str, num);
            AppMethodBeat.o(5179);
            return;
        }
        contentValues.putNull(str);
        AppMethodBeat.o(5179);
    }

    public static void putLongIntoContentValues(ContentValues contentValues, String str, @Nullable Long l) {
        AppMethodBeat.i(5180);
        if (l != null) {
            contentValues.put(str, l);
            AppMethodBeat.o(5180);
            return;
        }
        contentValues.putNull(str);
        AppMethodBeat.o(5180);
    }

    public static void putStringIntoContentValues(ContentValues contentValues, String str, @Nullable String str2) {
        AppMethodBeat.i(5181);
        if (str2 != null) {
            contentValues.put(str, str2);
            AppMethodBeat.o(5181);
            return;
        }
        contentValues.putNull(str);
        AppMethodBeat.o(5181);
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x009c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void zza(android.database.sqlite.SQLiteDatabase r9, java.lang.String r10, java.lang.String... r11) {
        /*
        // Method dump skipped, instructions count: 193
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.util.DbUtils.zza(android.database.sqlite.SQLiteDatabase, java.lang.String, java.lang.String[]):void");
    }
}
